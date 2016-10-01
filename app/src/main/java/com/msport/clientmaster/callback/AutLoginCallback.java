package com.msport.clientmaster.callback;

import android.content.Context;

import com.msport.clientmaster.util.CustomToast;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.Map;

public abstract class AutLoginCallback implements UMAuthListener{
	
	private Context context;

	
	public AutLoginCallback(Context context) {
		super();
		this.context = context;
	}


	@Override
	public void onCancel(SHARE_MEDIA arg0, int arg1) {
		CustomToast.createToast().showFaild(context, "用户取消");
		
	}

	@Override
	public void onComplete(SHARE_MEDIA arg0, int arg1, Map<String, String> arg2) {	
		onSuccess(arg2);
	}
	
	/**
	 * 如果需要对登陆成功做操作，重写此方法
	 * @param arg2
	 */
	public abstract void onSuccess(Map<String, String> arg2);

	@Override
	public void onError(SHARE_MEDIA arg0, int arg1, Throwable arg2) {
		CustomToast.createToast().showFaild(context, "网络链接不给力");
		
	}
	
	

}
