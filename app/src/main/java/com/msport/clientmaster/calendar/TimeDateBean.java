package com.msport.clientmaster.calendar;

import java.io.Serializable;
/**
 * 课程时间和日期的相关
 * @author like
 * 2016-4-22
 */
public class TimeDateBean implements Serializable{
	
	private String startTime;
	private String endTime;
	private String courseid;
	private String createtime;
	private String coachid;
	private String course;
	private String id;
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
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
}
