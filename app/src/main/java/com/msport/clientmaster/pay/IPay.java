package com.msport.clientmaster.pay;

import android.app.Activity;
import android.os.Handler;

/**
 * 要完成支付的接口
 * @author user
 *
 */
public interface IPay {
	
	/**
	 * 正在支付功能
	 */
	void Pay();
	/**
	 * 初始化支付功能
	 * @param activity 
	 * @param bean
	 * @param handler
	 */
	void initPayInfo(Activity activity, InitPayOrderBean bean, Handler handler,
					 String payurl);



}
