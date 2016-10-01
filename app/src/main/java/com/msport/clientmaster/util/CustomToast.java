package com.msport.clientmaster.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.msport.clientmaster.R;


/**
 * 自定义Toast
 * 
 * @author wzx
 * 
 */
public class CustomToast {
	private static CustomToast customToast;
	private Toast toast;

	public static CustomToast createToast() {
		if (customToast == null)
			customToast = new CustomToast();
		return customToast;
	}

	@SuppressLint("ResourceAsColor")
	public void show(Context context, ViewGroup root, String txt,int imgResid) {
		View layout = View.inflate(context, R.layout.custom_toast, root);
		TextView text = (TextView) layout.findViewById(R.id.text);
		ImageView mImageView = (ImageView) layout.findViewById(R.id.iv);
		mImageView.setBackgroundResource(imgResid);
		text.setText(txt);
		toast = new Toast(context);
		toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
		toast.setDuration(Toast.LENGTH_SHORT);
		toast.setView(layout);
		toast.show();
	}
	
	/**
	 * 成功
	 * @param context
	 * @param text
	 */
	public void showSuccess(Context context,String text)
	{
		show(context,null,text,R.mipmap.toast_success);
	}
	
	/**
	 * 失败
	 * @param context
	 * @param text
	 */
	public void showFaild(Context context,String text)
	{
		show(context,null,text, R.mipmap.toast_faild);
	}
	
	/**
	 * 直接显示
	 * @param context
	 * @param text
	 */
	public void showNormal(Context context,String text){
		show(context, null, text, 0);
	}
	
}
