package com.msport.clientmaster.entity;

import java.util.List;

/**
 * Created by like on 2016/8/25.
 */

public class MyCripsEntity extends BaseEntity {


    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * name : 游泳满10减2
         * type : 1
         * comment : 
         * endTime : 1472261670000
         * startTime : 1470965667000
         * discount : null
         * abatement : 2.0
         * maxDiscount : null
         * condi : 10.0
         * totalNum : 1
         * getNum : 1
         * useNum : null
         * couponCode : null
         * status : 1
         * canGet : 1
         * nowTime : null
         * validtime : null
         * useType : null
         * courseType : 0
         * image : null
         * createTime : 1469502981000
         * couponActivityId : null
         * id : 4
         */

        private List<CouponBean> coupon;

        public List<CouponBean> getCoupon() {
            return coupon;
        }

        public void setCoupon(List<CouponBean> coupon) {
            this.coupon = coupon;
        }

        public static class CouponBean {
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
            private String status;
            private String canGet;
            private String nowTime;
            private String validtime;
            private String useType;
            private String courseType;
            private String image;
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

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getCanGet() {
                return canGet;
            }

            public void setCanGet(String canGet) {
                this.canGet = canGet;
            }

            public String getNowTime() {
                return nowTime;
            }

            public void setNowTime(String nowTime) {
                this.nowTime = nowTime;
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

            public String getCourseType() {
                return courseType;
            }

            public void setCourseType(String courseType) {
                this.courseType = courseType;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
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
}
