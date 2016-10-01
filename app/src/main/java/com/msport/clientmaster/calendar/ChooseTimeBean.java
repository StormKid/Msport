package com.msport.clientmaster.calendar;

import java.io.Serializable;

public class ChooseTimeBean implements Serializable{


	private String timestart;

	public String getTimeend() {
		return timeend;
	}

	public void setTimeend(String timeend) {
		this.timeend = timeend;
	}

	public String getTimestart() {
		return timestart;
	}

	public void setTimestart(String timestart) {
		this.timestart = timestart;
	}

	private String timeend;


	/**
	 * 课程名字
	 */
	private String name;
	/**
	 * 内容
	 */
	private String content;
	/**
	 * 课程相关
	 */
	private String course;
	
	/**
	 * 创建时间
	 */
	private String createtime;
	
	/**
	 * 私教id
	 */
	private String coachid;
	
	/**
	 * 课程状态
	 */
	private String status;
	
	/**
	 * 课程开始时间
	 */
	private String startTime;
	
	/**
	 * 课程结束时间
	 */
	private String endTime;
	
	/**
	 * 课程id
	 */
	private String courseid;
	
	/**
	 * 当前项目id
	 */
	private String id;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public String getCoachid() {
		return coachid;
	}

	public void setCoachid(String coachid) {
		this.coachid = coachid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getCourseid() {
		return courseid;
	}

	public void setCourseid(String courseid) {
		this.courseid = courseid;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
	
	
}
