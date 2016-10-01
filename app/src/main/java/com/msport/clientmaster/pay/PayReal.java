package com.msport.clientmaster.pay;

import android.app.Activity;
import android.os.Handler;

import com.msport.clientmaster.constants.Constant;

/**
 * 本地支付的转换方式
 * 
 * @author like 2016-5-17
 */
public class PayReal {

	public static IPay creatPayMethod(int nselPayType, InitPayOrderBean bean,
			Activity context, Handler handler,String url) {

		/**  支付逻辑业务相关 */
		IPay pay;
		switch (nselPayType) {
		case Constant.PayType_WeiXin:
			pay = new WeiXinPay();
			pay.initPayInfo(context, bean, handler, url);
			break;
		case Constant.PayType_ZhiFuBao: // 支付宝支付
			pay = new AliPayPay();
			pay.initPayInfo(context, bean, handler, url);
			pay.Pay();
			break;
		default: // 默认
			pay = new AliPayPay();
			pay.initPayInfo(context, bean, handler, url);
			break;
		}
		return pay;

	}

}
