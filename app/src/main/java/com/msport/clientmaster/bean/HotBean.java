package com.msport.clientmaster.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by like on 2016/7/4.
 */
public class HotBean implements Serializable{

    /**
     * 课程名称
     */
    private String name;
    /**
     * 课程地点
     */
    private String location;
    /**
     * 是否是热门课程
     */
    private String isHot;

    /**
     * 订单号
     */
    private String billId;

    /**
     * 课程时间列表【课时】
     */
    private List<CourseTime> timeScheduleList;

    /**
     * 开始时间
     */
    private String timestart;

    /**
     * 结束时间
     */
    private String timeend;

    /**
     * 单价
     */
    private String price;

    /**
     * 课程类别
     */
    private String coursetype;

    /**
     * 当前人数
     */
    private String totalavailable;

    /**
     * 课程大纲章节
     */
    private List<CourseListItem> courseItemList;

    /**
     * 课程id
     */
    private String id;

    /**
     * 课程图片
     */
    private String courseimage;
    /**
     * 经度
     */
    private String  latitude;
    /**
     * 纬度
     */
    private String longtitude;

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    public String getCourseimage() {
        return courseimage;
    }

    public void setCourseimage(String courseimage) {
        this.courseimage = courseimage;
    }

    public List<CourseListItem> getCourseItemList() {
        return courseItemList;
    }

    public void setCourseItemList(List<CourseListItem> courseItemList) {
        this.courseItemList = courseItemList;
    }

    public String getCoursetype() {
        return coursetype;
    }

    public void setCoursetype(String coursetype) {
        this.coursetype = coursetype;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIsHot() {
        return isHot;
    }

    public void setIsHot(String isHot) {
        this.isHot = isHot;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(String longtitude) {
        this.longtitude = longtitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTimeend() {
        return timeend;
    }

    public void setTimeend(String timeend) {
        this.timeend = timeend;
    }

    public List<CourseTime> getTimeScheduleList() {
        return timeScheduleList;
    }

    public void setTimeScheduleList(List<CourseTime> timeScheduleList) {
        this.timeScheduleList = timeScheduleList;
    }

    public String getTimestart() {
        return timestart;
    }

    public void setTimestart(String timestart) {
        this.timestart = timestart;
    }

    public String getTotalavailable() {
        return totalavailable;
    }

    public void setTotalavailable(String totalavailable) {
        this.totalavailable = totalavailable;
    }
}
