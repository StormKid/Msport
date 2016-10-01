package com.msport.clientmaster.pay;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;

import com.alipay.sdk.app.PayTask;
import com.msport.clientmaster.util.LogUtils;

//实现支付宝支付方式
public class AliPayPay implements IPay {
    private Activity activity;
    private Handler handler;
    private InitPayOrderBean payOrderBean;
    private String payurl;

    @Override
    public void initPayInfo(Activity activity, InitPayOrderBean bean,
                            Handler handler, String payurl) {
        this.activity = activity;
        this.handler = handler;
        this.payOrderBean = bean;
        this.payurl = payurl;

    }

    @Override
    public void Pay() {
        Runnable payRunnable = new Runnable() {
            @Override
            public void run() {
                // 构造PayTask 对象
                PayTask alipay = new PayTask(activity);
                // 调用支付接口，获取支付结果
                String rawResult = alipay.pay(payurl, true);
                PayResult result = new PayResult();

                if (TextUtils.isEmpty(rawResult))
                    result.setIsSuccess(false);

                LogUtils.i("ZHI", "支付宝返回" + rawResult);

                String[] resultParams = rawResult.split(";");
                String resultStatus = "";
                String result_result = "";
                String memo = "";
                for (String resultParam : resultParams) {
                    if (resultParam.startsWith("resultStatus")) {
                        resultStatus = gatValue(resultParam, "resultStatus");
                    }
                    if (resultParam.startsWith("result")) {
                        result_result = gatValue(resultParam, "result");
                    }
                    if (resultParam.startsWith("memo")) {
                        memo = gatValue(resultParam, "memo");
                    }

                    if (TextUtils.equals(resultStatus, "9000")) {
                        result.setIsSuccess(true); //支付成功
                    } else {
                        // 判断resultStatus 为非“9000”则代表可能支付失败
                        // “8000”代表支付结果因为支付渠道原因或者系统原因还在等待支付结果确认，最终交易是否成功以服务端异步通知为准（小概率状态）
                        if (TextUtils.equals(resultStatus, "8000")) {
                            result.setIsSuccess(false);
                            result.setDesc("支付结果确认中");

                        } else {
                            // 其他值就可以判断为支付失败，包括用户主动取消支付，或者系统返回的错误
                            result.setIsSuccess(false);
                            result.setDesc("支付失败" + memo);

                        }
                    }
                }
                Message msg = new Message();
                msg.what = PayConstant.ALIPAY_SDK_PAY_FLAG;
                msg.obj = result;
                handler.sendMessage(msg);
            }
        };

        // 必须异步调用
        Thread payThread = new Thread(payRunnable);
        payThread.start();

    }


    private String gatValue(String content, String key) {
        String prefix = key + "={";
        return content.substring(content.indexOf(prefix) + prefix.length(),
                content.lastIndexOf("}"));
    }


}
