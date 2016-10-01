package com.msport.clientmaster.pay;

import android.app.Activity;
import android.os.Handler;

import com.msport.clientmaster.callback.MainCallback;
import com.msport.clientmaster.constants.HttpConstant;
import com.msport.clientmaster.entity.WeiPayEntity;
import com.msport.clientmaster.intef.MyViewCallback;
import com.msport.clientmaster.util.CustomToast;
import com.msport.clientmaster.util.LogUtils;
import com.tencent.mm.sdk.modelpay.PayReq;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.WXAPIFactory;

import retrofit2.Response;

public class WeiXinPay implements IPay, MyViewCallback {
	private static IWXAPI msgApi;
	private PayReq req;
	private Activity activity;
	private Handler handler;
	private WeiXinRequestBean payOrderBean;
	private MainCallback callback;

	@Override
	public void initPayInfo(Activity activity, InitPayOrderBean bean,
			Handler handler,String url) {
		this.activity = activity;
		this.handler = handler;
		this.payOrderBean = (WeiXinRequestBean) bean;
		if (msgApi == null) {
			msgApi = WXAPIFactory.createWXAPI(activity, null);
			msgApi.registerApp(PayConstant.WEIXIN_APP_ID); // 注册
		}
		callback = new MainCallback(this,activity);
		req = new PayReq();
		genPayReq();

	}

	@Override
	public void Pay() {

	}

	@SuppressWarnings("deprecation")
	private void genPayReq() {

		req.appId = PayConstant.WEIXIN_APP_ID;
		req.partnerId = PayConstant.WEIXIN_MCH_ID;
		req.prepayId = payOrderBean.getPrepayId();
		req.packageValue = "Sign=WXPay";
		req.nonceStr = genNonceStr();
		req.timeStamp = String.valueOf(genTimeStamp());

		ProPayBean bean = new ProPayBean();
		bean.appId = req.appId;
		bean.nonceStr = req.nonceStr;
		bean.prepay_id = req.prepayId;
		bean.timeStamp = req.timeStamp;
		bean.partnerid = req.partnerId;
		callback.weixinPay(bean);



	}

	private long genTimeStamp() {
		return System.currentTimeMillis() / 1000;
	}

	private String genNonceStr() {
		return MD5.getMessageDigest(16);
	}



	/**
	 * 检测是否安装微信
	 * 
	 * @return
	 */
	private boolean isWXAppInstalledAndSupported() {
		IWXAPI msgApi = WXAPIFactory.createWXAPI(activity, null);
		msgApi.registerApp(PayConstant.WEIXIN_APP_ID);
		boolean sIsWXAppInstalledAndSupported = msgApi.isWXAppInstalled()
				&& msgApi.isWXAppSupportAPI();
		return sIsWXAppInstalledAndSupported;
	}


	@Override
	public void viewMode(Response res, String tag) {
		if (HttpConstant.weipay.equals(tag)) {
			WeiPayEntity entity = (WeiPayEntity) res.body();
			req.sign = entity.getData().getSign();
			if (isWXAppInstalledAndSupported()) {
				boolean sendReq = msgApi.sendReq(req);
				LogUtils.i("ZzL", sendReq);

			} else {
				CustomToast.createToast().showFaild(activity, "请安装微信客户端");
			}
		}
	}

	@Override
	public void getFalse(boolean tag, String message) {

	}

	@Override
	public void showCode(int code, String string) {

	}
}
