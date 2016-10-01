package com.msport.clientmaster.requestbean;

import java.io.Serializable;

/**
 * Created by like on 2016/8/18.
 */
public class ReviewRequestBean implements Serializable{

    private String type;
    private String content;
    private String title;
    private String memberId;
    private String commentIds;
    private String courseDegree;
    private String coachDegree;
    private String courseId;
    private String coachId;
    private String billId;
    private String createTime;

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    public String getCoachDegree() {
        return coachDegree;
    }

    public void setCoachDegree(String coachDegree) {
        this.coachDegree = coachDegree;
    }

    public String getCoachId() {
        return coachId;
    }

    public void setCoachId(String coachId) {
        this.coachId = coachId;
    }

    public String getCommentIds() {
        return commentIds;
    }

    public void setCommentIds(String commentIds) {
        this.commentIds = commentIds;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCourseDegree() {
        return courseDegree;
    }

    public void setCourseDegree(String courseDegree) {
        this.courseDegree = courseDegree;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
