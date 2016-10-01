package com.msport.clientmaster.pay;

import java.io.Serializable;
/**
 * 生成订单
 * @author like
 * 2016-5-17
 */
public class InitPayOrderBean implements Serializable{
	private String name;    //支付主题
	private String customerAddress;       //支付描述
	private String amount;     //支付金额
	private String billid;    //订单号(真实订单号)

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getBillid() {
		return billid;
	}

	public void setBillid(String billid) {
		this.billid = billid;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
