package com.msport.clientmaster.entity;

import com.msport.clientmaster.bean.LoginBean;

/**
 * 用户登陆返回实体
 * @author like
 * 2016-4-18
 */
public class LoginEntity extends BaseEntity {

	
	private LoginBean data;

	public LoginBean getData() {
		return data;
	}

	public void setData(LoginBean data) {
		this.data = data;
	}
	
	
	
	
}
