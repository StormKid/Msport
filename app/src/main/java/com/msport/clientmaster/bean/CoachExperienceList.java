package com.msport.clientmaster.bean;

import java.io.Serializable;

/**
 * Created by like on 2016/8/2.
 */

public class CoachExperienceList implements Serializable {


    /**
     * type : 0
     * content : 这是我的赛事经历具体有什么我也不知道
     * timeEnd : 1472021754000
     * timeStart : 1470120950000
     * createTime : 1470120982000
     * coachId : 10
     * id : 1
     */

    private String type;
    private String content;
    private String timeEnd;
    private String timeStart;
    private String createTime;
    private String coachId;
    private String id;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(String timeEnd) {
        this.timeEnd = timeEnd;
    }

    public String getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(String timeStart) {
        this.timeStart = timeStart;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getCoachId() {
        return coachId;
    }

    public void setCoachId(String coachId) {
        this.coachId = coachId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
