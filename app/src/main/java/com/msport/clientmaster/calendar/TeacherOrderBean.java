package com.msport.clientmaster.calendar;

import java.io.Serializable;
import java.util.List;
/**
 * 私教订单的请求bean
 * @author like
 * 2016-6-2
 */
public class TeacherOrderBean implements Serializable{
	/**
	 * 课程品类id
	 */
	public String qCourseCatagoryId;
	/**
	 * 课程金额
	 */
	public String amount;
	/**
	 * 支付方式
	 */
	public String paymentmode;
	/**
	 * 支付者id
	 */
	public String payerId;
	/**
	 * 场馆id
	 */
	public String aVenueId;
	/**
	 * 私教课程安排时间进度
	 */
	public String qScheduleList;
	/**
	 * 订单名称
	 */
	public String name;
	/**
	 * 自定义场馆地址
	 */
	public String customerAddress;
	
	/**
	 * 生成coachid
	 */
	public String coachid;
	
	/**
	 * 单例
	 */
	private static TeacherOrderBean teacherOrderBean;
	
	public static TeacherOrderBean getIntstance() {
		if (teacherOrderBean == null) {
			teacherOrderBean = new TeacherOrderBean();
		}
		return teacherOrderBean;
	}
	
	/*****************订单信息*********************/
	/**
	 * 订单人数
	 */
	public int orderPeople;
	
	/**
	 * 订单私教
	 */
	public String orderTeacher;
	
	/**
	 * 开课时间
	 */
	public String startTime;
	
	/**
	 * 显示时间
	 */
	public List<TimeShowBean> timeShow;
	
	/**
	 * 价格
	 */
	public String orderPrice;
	
	/**
	 * 地点
	 */
	public String orderLocation;

	/**
	 * 订单号
	 */
	public String billId;
	
	
	/******************订单信息结束********************/
	
	
}
