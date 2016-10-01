package com.msport.clientmaster.callback;

import android.content.Context;

import com.msport.clientmaster.util.CustomToast;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
/**
 * 分享回调抽象类
 * @author like
 * 2016-3-29
 */
public abstract class ShareListener implements UMShareListener{
	
	private Context context;
	
	
	public ShareListener(Context context) {
		super();
		this.context = context;
	}

	@Override
	public void onCancel(SHARE_MEDIA arg0) {
		CustomToast.createToast().showFaild(context, "取消分享");
	}

	@Override
	public void onError(SHARE_MEDIA arg0, Throwable arg1) {
		CustomToast.createToast().showFaild(context, "分享失败");
	}

	@Override
	public void onResult(SHARE_MEDIA arg0) {
		mySuccess();
	}

	protected abstract void mySuccess();
	
}
