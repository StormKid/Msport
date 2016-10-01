package com.msport.clientmaster.util;

import com.google.gson.Gson;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import okhttp3.RequestBody;

/**
 * 加密
 * @author like
 * 2016-6-27
 */
public class SignUtil {
	/**
	 * 排序
	 * @param keySet
	 * @return
	 */
	private static List<String> getSortList(Set<String> keySet){
		List<String> params = new ArrayList<String>();
		for (String key : keySet) {
			params.add(key);
		}
		Collections.sort(params);
		return params;
	}

	/**
	 * 加密调用的方法
	 * @param secret
	 * @param params
     * @return
     */
	public static String getSign(String secret,Map<String,String> params){
		if (params == null)
			return "";
		Set<String> keySet = params.keySet();
		List<String> sortList = getSortList(keySet);
		String sighKey = "";
		
		for (int i = 0; i < sortList.size(); i++) {
			String key = sortList.get(i);
			String value = params.get(key);
			value = StringUtil.utf8Encode(value,"utf-8");
			if (i==sortList.size()-1) {
				sighKey += key+"="+value;
			}else{
				sighKey += key+"="+value+"&";
			}
		}
		String urlAsString = sighKey+"&secret="+secret;
	    LogUtils.e("sighkey", urlAsString);
		String sigh = ShaUtil.SHA1(urlAsString);
		return sigh;
	}

	/**
	 * 拼接json模型
	 * @param bean
	 * @return
	 */
	public static RequestBody Urljson(Serializable bean){
		Gson gson = new Gson();
		String request = gson.toJson(bean);
		LogUtils.e("json",request);
		RequestBody body= RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"),request);
		return body;
	}




}
