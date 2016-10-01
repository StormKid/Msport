package com.msport.clientmaster.requestbean;

import java.io.Serializable;

/**
 * Created by like on 2016/8/12.
 */
public class CourseOrderRequestBean implements Serializable{
    public String memberId;
    public String courseId;
    public String extraOpenId;
    public String activityId;
    public String number;
    public String billType;
    public String paymentMode;

    private static CourseOrderRequestBean courseRequestBean;
    public static CourseOrderRequestBean getInstance(){
        if (courseRequestBean == null){
            courseRequestBean = new CourseOrderRequestBean();
        }
        return courseRequestBean;
    }
    private CourseOrderRequestBean(){}



}
