package com.msport.clientmaster.pay;

import java.io.Serializable;

/**
 * 支付结果的bean
 * @author like
 * 2016-5-17
 */
public class PayResult implements Serializable {
	//是否支付成功
	private Boolean isSuccess;
	private String desc; //描述内容
	private Boolean isHuoDao;  //是否货到付款
	private String orderno;    //订单号
	public String getOrderno() {
		return orderno;
	}
	public void setOrderno(String orderno) {
		this.orderno = orderno;
	}
	public Boolean getIsHuoDao() {
		return isHuoDao;
	}
	public void setIsHuoDao(Boolean isHuoDao) {
		this.isHuoDao = isHuoDao;
	}
	public Boolean getIsSuccess() {
		return isSuccess;
	}
	public void setIsSuccess(Boolean isSuccess) {
		this.isSuccess = isSuccess;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
}
