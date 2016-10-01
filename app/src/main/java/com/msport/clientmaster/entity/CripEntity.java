package com.msport.clientmaster.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by like on 2016/8/24.
 */

public class CripEntity extends BaseEntity {


    /**
     * name : 游泳满30减8
     * type : 1
     * comment : 
     * endTime : 1472261670000
     * startTime : 1470965667000
     * discount : null
     * abatement : 8.0
     * maxDiscount : null
     * condi : 30.0
     * totalNum : null
     * getNum : null
     * useNum : null
     * couponCode : null
     * canGet : 1
     * validtime : null
     * useType : null
     * status : 0
     * nowTime : null
     * courseType : 1
     * createTime : 1470878878000
     * couponActivityId : null
     * id : 6
     */

    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean implements Serializable{
        private String name;
        private String type;
        private String comment;
        private String endTime;
        private String startTime;
        private String discount;
        private String abatement;
        private String maxDiscount;
        private String condi;
        private String totalNum;
        private String getNum;
        private String useNum;
        private String couponCode;
        private String canGet;
        private String validtime;
        private String useType;
        private String status;
        private String nowTime;
        private String courseType;
        private String createTime;
        private String couponActivityId;
        private String id;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getComment() {
            return comment;
        }

        public void setComment(String comment) {
            this.comment = comment;
        }

        public String getEndTime() {
            return endTime;
        }

        public void setEndTime(String endTime) {
            this.endTime = endTime;
        }

        public String getStartTime() {
            return startTime;
        }

        public void setStartTime(String startTime) {
            this.startTime = startTime;
        }

        public String getDiscount() {
            return discount;
        }

        public void setDiscount(String discount) {
            this.discount = discount;
        }

        public String getAbatement() {
            return abatement;
        }

        public void setAbatement(String abatement) {
            this.abatement = abatement;
        }

        public String getMaxDiscount() {
            return maxDiscount;
        }

        public void setMaxDiscount(String maxDiscount) {
            this.maxDiscount = maxDiscount;
        }

        public String getCondi() {
            return condi;
        }

        public void setCondi(String condi) {
            this.condi = condi;
        }

        public String getTotalNum() {
            return totalNum;
        }

        public void setTotalNum(String totalNum) {
            this.totalNum = totalNum;
        }

        public String getGetNum() {
            return getNum;
        }

        public void setGetNum(String getNum) {
            this.getNum = getNum;
        }

        public String getUseNum() {
            return useNum;
        }

        public void setUseNum(String useNum) {
            this.useNum = useNum;
        }

        public String getCouponCode() {
            return couponCode;
        }

        public void setCouponCode(String couponCode) {
            this.couponCode = couponCode;
        }

        public String getCanGet() {
            return canGet;
        }

        public void setCanGet(String canGet) {
            this.canGet = canGet;
        }

        public String getValidtime() {
            return validtime;
        }

        public void setValidtime(String validtime) {
            this.validtime = validtime;
        }

        public String getUseType() {
            return useType;
        }

        public void setUseType(String useType) {
            this.useType = useType;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getNowTime() {
            return nowTime;
        }

        public void setNowTime(String nowTime) {
            this.nowTime = nowTime;
        }

        public String getCourseType() {
            return courseType;
        }

        public void setCourseType(String courseType) {
            this.courseType = courseType;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getCouponActivityId() {
            return couponActivityId;
        }

        public void setCouponActivityId(String couponActivityId) {
            this.couponActivityId = couponActivityId;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }
}
