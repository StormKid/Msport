package com.msport.clientmaster.util;

import android.content.Context;

import com.msport.clientmaster.bean.LoginBean;
import com.msport.clientmaster.constants.Constant;

/**
 * 从服务器保存信息到本地专用类
 * @author like
 * 2016-5-17
 */
public class Sptools {
	
	
	/**
	 * 保存用户信息
	 * @param context
	 * @param telephone
	 * @param pwd
	 */
	public static void putInLogin(Context context,String telephone,String pwd){
		PublicPreferencesUtils.putString(context, Constant.USER_PHONE, telephone);
		PublicPreferencesUtils.putString(context, Constant.USER_PWD, pwd);
	}
	
	
	
	/**
	 * 保存用户所有的单个信息
	 * @param context 
	 */
	public static void putInProperties(LoginBean bean, Context context){
		PublicPreferencesUtils.putString(context, Constant.NUTZER_NAME, bean.getName());
		PublicPreferencesUtils.putString(context, Constant.NUTZER_ACCESSTOKEN, bean.getAccessToken());
		PublicPreferencesUtils.putString(context, Constant.NUTZER_BIETHDAY, bean.getBirthday());
		PublicPreferencesUtils.putString(context, Constant.NUTZER_EXPIRETIME, bean.getExpiretime());
		PublicPreferencesUtils.putString(context, Constant.NUTZER_FIRSTBUYTIME, bean.getFirstbuytime());
		PublicPreferencesUtils.putString(context, Constant.NUTZER_HEIGHT, bean.getHeight());
		PublicPreferencesUtils.putString(context, Constant.NUTZER_ID, bean.getId());
		PublicPreferencesUtils.putString(context, Constant.NUTZER_JOB, bean.getJob());
		PublicPreferencesUtils.putString(context, Constant.NUTZER_LOCATION, bean.getLocation());
		PublicPreferencesUtils.putString(context, Constant.NUTZER_REGISTETIME, bean.getRegistetime());
		PublicPreferencesUtils.putString(context, Constant.NUTZER_SEX, bean.getSex());
		PublicPreferencesUtils.putString(context, Constant.NUTZER_TELEPHONE, bean.getTelephone());
		PublicPreferencesUtils.putString(context, Constant.NUTZER_WEIGHT, bean.getWeight());
		PublicPreferencesUtils.putString(context, Constant.NUTZER_PHOTOURL,bean.getAvatarUrl());
		PublicPreferencesUtils.putString(context, Constant.NUTZER_AGE, bean.getAge());
		PublicPreferencesUtils.putString(context, Constant.NUTZER_SERCRET, bean.getSecret());
		PublicPreferencesUtils.putString(context,Constant.NUTZER_OPENID,bean.getOpenId());
		PublicPreferencesUtils.putString(context,Constant.NUTZER_TYPE,bean.getType());
		PublicPreferencesUtils.putString(context,Constant.NUTZER_UNIONID,bean.getUnionId());
	}


}
