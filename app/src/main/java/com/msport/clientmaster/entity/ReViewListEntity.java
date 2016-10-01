package com.msport.clientmaster.entity;

import java.util.List;

/**
 * Created by like on 2016/8/17.
 */

public class ReViewListEntity extends  BaseEntity {

    /**
     * name : 瑜伽课程--汉街运动
     * number : null
     * tag : 0
     * status : 3
     * amount : 0.01
     * billid : 201607041517321467616652281101
     * billType : 0
     * couponId : null
     * payerId : 80
     * actualAmount : null
     * invitationId : null
     * refundStatus : null
     * qCoachName : null
     * coachId : null
     * course : {"name":"瑜伽课程--汉街运动","value":0,"location":"33","comment":"没有备注","orgId":"b4e7c365113644b3935984d459cfc140","smsTemplateId":null,"smsTemplate":{"name":null,"content":null,"createTime":null,"courseId":null,"id":"2"},"qDate":null,"distance":null,"latitude":"30.558644","Stringtitude":"114.352849","courseimage":"","timestart":"14:30","timeend":"15:00","price":"0.01","coursetype":"1","sort":0,"Stringroduce":"没有介绍","isPrivate":null,"status":0,"timeScheduleList":[{"name":"第一章","content":"伸展运动","endTime":"2016-04-22 22:47","startTime":"2016-04-22 22:47","courseid":"6","status":0,"createtime":null,"coachid":null,"isPush":null,"course":null,"memberId":null,"id":"14"},{"name":"第二章","content":"轮刮眼圈","endTime":"2016-05-20 16:07","startTime":"2016-05-19 16:07","courseid":"6","status":0,"createtime":null,"coachid":null,"isPush":null,"course":null,"memberId":null,"id":"28"}],"totalavailable":"600","courseItemList":[{"name":"第一章","status":"1","id":"16"},{"name":"第二章","status":"1","id":"17"},{"name":"精英课程","status":"0","id":"18"}],"activity":{"name":null,"endTime":null,"startTime":null,"isEnable":null,"activityImage":null,"id":"1"},"billId":null,"isHot":null,"venueName":"汉街运动健身场馆","coach":null,"totalMember":1,"coachName":null,"album":"","servRange":",0,","subCourseType":"19","lowestPrice":0,"highestPrice":0,"officePhone":"","id":"6"}
     * aVenueId : null
     * qScheduleList : null
     * courseId : 6
     * activityId : null
     * qTelephone : 15172518243
     * extraOpenId : -1
     * extraTranscId : null
     * payee : null
     * tradingtime : 1467616652000
     * paymentmode : 0
     * buyerEmail : null
     * coach : null
     * consumeCode : null
     * receiveAccount : null
     * qCommentStatus : 1
     * qCourseCatagoryId : null
     * extraTranscDate : 1470899646000
     * invitationActivity : null
     * customerAddress : null
     * ticketDetailId : null
     * id : 777
     */

    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        private String name;
        private String number;
        private String tag;
        private String status;
        private String amount;
        private String billid;
        private String billType;
        private String couponId;
        private String payerId;
        private String actualAmount;
        private String invitationId;
        private String refundStatus;
        private String qCoachName;
        private String coachId;
        /**
         * name : 瑜伽课程--汉街运动
         * value : 0
         * location : 33
         * comment : 没有备注
         * orgId : b4e7c365113644b3935984d459cfc140
         * smsTemplateId : null
         * smsTemplate : {"name":null,"content":null,"createTime":null,"courseId":null,"id":"2"}
         * qDate : null
         * distance : null
         * latitude : 30.558644
         * Stringtitude : 114.352849
         * courseimage : 
         * timestart : 14:30
         * timeend : 15:00
         * price : 0.01
         * coursetype : 1
         * sort : 0
         * Stringroduce : 没有介绍
         * isPrivate : null
         * status : 0
         * timeScheduleList : [{"name":"第一章","content":"伸展运动","endTime":"2016-04-22 22:47","startTime":"2016-04-22 22:47","courseid":"6","status":0,"createtime":null,"coachid":null,"isPush":null,"course":null,"memberId":null,"id":"14"},{"name":"第二章","content":"轮刮眼圈","endTime":"2016-05-20 16:07","startTime":"2016-05-19 16:07","courseid":"6","status":0,"createtime":null,"coachid":null,"isPush":null,"course":null,"memberId":null,"id":"28"}]
         * totalavailable : 600
         * courseItemList : [{"name":"第一章","status":"1","id":"16"},{"name":"第二章","status":"1","id":"17"},{"name":"精英课程","status":"0","id":"18"}]
         * activity : {"name":null,"endTime":null,"startTime":null,"isEnable":null,"activityImage":null,"id":"1"}
         * billId : null
         * isHot : null
         * venueName : 汉街运动健身场馆
         * coach : null
         * totalMember : 1
         * coachName : null
         * album : 
         * servRange : ,0,
         * subCourseType : 19
         * lowestPrice : 0
         * highestPrice : 0
         * officePhone : 
         * id : 6
         */

        private CourseBean course;
        private String aVenueId;
        private String qScheduleList;
        private String courseId;
        private String activityId;
        private String qTelephone;
        private String extraOpenId;
        private String extraTranscId;
        private String payee;
        private String tradingtime;
        private String paymentmode;
        private String buyerEmail;
        private CoachDetailEntity.DataBean.QualificationCoachListBean.CoachBean coach;
        private String consumeCode;
        private String receiveAccount;
        private String qCommentStatus;
        private String qCourseCatagoryId;
        private String extraTranscDate;
        private String invitationActivity;
        private String customerAddress;
        private String ticketDetailId;
        private String id;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

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

        public String getBillType() {
            return billType;
        }

        public void setBillType(String billType) {
            this.billType = billType;
        }

        public String getCouponId() {
            return couponId;
        }

        public void setCouponId(String couponId) {
            this.couponId = couponId;
        }

        public String getPayerId() {
            return payerId;
        }

        public void setPayerId(String payerId) {
            this.payerId = payerId;
        }

        public String getActualAmount() {
            return actualAmount;
        }

        public void setActualAmount(String actualAmount) {
            this.actualAmount = actualAmount;
        }

        public String getInvitationId() {
            return invitationId;
        }

        public void setInvitationId(String invitationId) {
            this.invitationId = invitationId;
        }

        public String getRefundStatus() {
            return refundStatus;
        }

        public void setRefundStatus(String refundStatus) {
            this.refundStatus = refundStatus;
        }

        public String getQCoachName() {
            return qCoachName;
        }

        public void setQCoachName(String qCoachName) {
            this.qCoachName = qCoachName;
        }

        public String getCoachId() {
            return coachId;
        }

        public void setCoachId(String coachId) {
            this.coachId = coachId;
        }

        public CourseBean getCourse() {
            return course;
        }

        public void setCourse(CourseBean course) {
            this.course = course;
        }

        public String getAVenueId() {
            return aVenueId;
        }

        public void setAVenueId(String aVenueId) {
            this.aVenueId = aVenueId;
        }

        public String getQScheduleList() {
            return qScheduleList;
        }

        public void setQScheduleList(String qScheduleList) {
            this.qScheduleList = qScheduleList;
        }

        public String getCourseId() {
            return courseId;
        }

        public void setCourseId(String courseId) {
            this.courseId = courseId;
        }

        public String getActivityId() {
            return activityId;
        }

        public void setActivityId(String activityId) {
            this.activityId = activityId;
        }

        public String getQTelephone() {
            return qTelephone;
        }

        public void setQTelephone(String qTelephone) {
            this.qTelephone = qTelephone;
        }

        public String getExtraOpenId() {
            return extraOpenId;
        }

        public void setExtraOpenId(String extraOpenId) {
            this.extraOpenId = extraOpenId;
        }

        public String getExtraTranscId() {
            return extraTranscId;
        }

        public void setExtraTranscId(String extraTranscId) {
            this.extraTranscId = extraTranscId;
        }

        public String getPayee() {
            return payee;
        }

        public void setPayee(String payee) {
            this.payee = payee;
        }

        public String getTradingtime() {
            return tradingtime;
        }

        public void setTradingtime(String tradingtime) {
            this.tradingtime = tradingtime;
        }

        public String getPaymentmode() {
            return paymentmode;
        }

        public void setPaymentmode(String paymentmode) {
            this.paymentmode = paymentmode;
        }

        public String getBuyerEmail() {
            return buyerEmail;
        }

        public void setBuyerEmail(String buyerEmail) {
            this.buyerEmail = buyerEmail;
        }

        public CoachDetailEntity.DataBean.QualificationCoachListBean.CoachBean getCoach() {
            return coach;
        }

        public void setCoach(CoachDetailEntity.DataBean.QualificationCoachListBean.CoachBean coach) {
            this.coach = coach;
        }

        public String getConsumeCode() {
            return consumeCode;
        }

        public void setConsumeCode(String consumeCode) {
            this.consumeCode = consumeCode;
        }

        public String getReceiveAccount() {
            return receiveAccount;
        }

        public void setReceiveAccount(String receiveAccount) {
            this.receiveAccount = receiveAccount;
        }

        public String getQCommentStatus() {
            return qCommentStatus;
        }

        public void setQCommentStatus(String qCommentStatus) {
            this.qCommentStatus = qCommentStatus;
        }

        public String getQCourseCatagoryId() {
            return qCourseCatagoryId;
        }

        public void setQCourseCatagoryId(String qCourseCatagoryId) {
            this.qCourseCatagoryId = qCourseCatagoryId;
        }

        public String getExtraTranscDate() {
            return extraTranscDate;
        }

        public void setExtraTranscDate(String extraTranscDate) {
            this.extraTranscDate = extraTranscDate;
        }

        public String getInvitationActivity() {
            return invitationActivity;
        }

        public void setInvitationActivity(String invitationActivity) {
            this.invitationActivity = invitationActivity;
        }

        public String getCustomerAddress() {
            return customerAddress;
        }

        public void setCustomerAddress(String customerAddress) {
            this.customerAddress = customerAddress;
        }

        public String getTicketDetailId() {
            return ticketDetailId;
        }

        public void setTicketDetailId(String ticketDetailId) {
            this.ticketDetailId = ticketDetailId;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public static class CourseBean {
            private String name;
            private String value;
            private String location;
            private String comment;
            private String orgId;
            private String smsTemplateId;
            /**
             * name : null
             * content : null
             * createTime : null
             * courseId : null
             * id : 2
             */

            private SmsTemplateBean smsTemplate;
            private String qDate;
            private String distance;
            private String latitude;
            private String Stringtitude;
            private String courseimage;
            private String timestart;
            private String timeend;
            private String price;
            private String coursetype;
            private String sort;
            private String Stringroduce;
            private String isPrivate;
            private String status;
            private String totalavailable;
            /**
             * name : null
             * endTime : null
             * startTime : null
             * isEnable : null
             * activityImage : null
             * id : 1
             */

            private ActivityBean activity;
            private String billId;
            private String isHot;
            private String venueName;
            private CoachDetailEntity.DataBean.QualificationCoachListBean.CoachBean coach;
            private String totalMember;
            private String coachName;
            private String album;
            private String servRange;
            private String subCourseType;
            private String lowestPrice;
            private String highestPrice;
            private String officePhone;
            private String id;
            /**
             * name : 第一章
             * content : 伸展运动
             * endTime : 2016-04-22 22:47
             * startTime : 2016-04-22 22:47
             * courseid : 6
             * status : 0
             * createtime : null
             * coachid : null
             * isPush : null
             * course : null
             * memberId : null
             * id : 14
             */

            private List<TimeScheduleListBean> timeScheduleList;
            /**
             * name : 第一章
             * status : 1
             * id : 16
             */

            private List<CourseItemListBean> courseItemList;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getValue() {
                return value;
            }

            public void setValue(String value) {
                this.value = value;
            }

            public String getLocation() {
                return location;
            }

            public void setLocation(String location) {
                this.location = location;
            }

            public String getComment() {
                return comment;
            }

            public void setComment(String comment) {
                this.comment = comment;
            }

            public String getOrgId() {
                return orgId;
            }

            public void setOrgId(String orgId) {
                this.orgId = orgId;
            }

            public String getSmsTemplateId() {
                return smsTemplateId;
            }

            public void setSmsTemplateId(String smsTemplateId) {
                this.smsTemplateId = smsTemplateId;
            }

            public SmsTemplateBean getSmsTemplate() {
                return smsTemplate;
            }

            public void setSmsTemplate(SmsTemplateBean smsTemplate) {
                this.smsTemplate = smsTemplate;
            }

            public String getQDate() {
                return qDate;
            }

            public void setQDate(String qDate) {
                this.qDate = qDate;
            }

            public String getDistance() {
                return distance;
            }

            public void setDistance(String distance) {
                this.distance = distance;
            }

            public String getLatitude() {
                return latitude;
            }

            public void setLatitude(String latitude) {
                this.latitude = latitude;
            }

            public String getStringtitude() {
                return Stringtitude;
            }

            public void setStringtitude(String Stringtitude) {
                this.Stringtitude = Stringtitude;
            }

            public String getCourseimage() {
                return courseimage;
            }

            public void setCourseimage(String courseimage) {
                this.courseimage = courseimage;
            }

            public String getTimestart() {
                return timestart;
            }

            public void setTimestart(String timestart) {
                this.timestart = timestart;
            }

            public String getTimeend() {
                return timeend;
            }

            public void setTimeend(String timeend) {
                this.timeend = timeend;
            }

            public String getPrice() {
                return price;
            }

            public void setPrice(String price) {
                this.price = price;
            }

            public String getCoursetype() {
                return coursetype;
            }

            public void setCoursetype(String coursetype) {
                this.coursetype = coursetype;
            }

            public String getSort() {
                return sort;
            }

            public void setSort(String sort) {
                this.sort = sort;
            }

            public String getStringroduce() {
                return Stringroduce;
            }

            public void setStringroduce(String Stringroduce) {
                this.Stringroduce = Stringroduce;
            }

            public String getIsPrivate() {
                return isPrivate;
            }

            public void setIsPrivate(String isPrivate) {
                this.isPrivate = isPrivate;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getTotalavailable() {
                return totalavailable;
            }

            public void setTotalavailable(String totalavailable) {
                this.totalavailable = totalavailable;
            }

            public ActivityBean getActivity() {
                return activity;
            }

            public void setActivity(ActivityBean activity) {
                this.activity = activity;
            }

            public String getBillId() {
                return billId;
            }

            public void setBillId(String billId) {
                this.billId = billId;
            }

            public String getIsHot() {
                return isHot;
            }

            public void setIsHot(String isHot) {
                this.isHot = isHot;
            }

            public String getVenueName() {
                return venueName;
            }

            public void setVenueName(String venueName) {
                this.venueName = venueName;
            }

            public CoachDetailEntity.DataBean.QualificationCoachListBean.CoachBean getCoach() {
                return coach;
            }

            public void setCoach(CoachDetailEntity.DataBean.QualificationCoachListBean.CoachBean coach) {
                this.coach = coach;
            }

            public String getTotalMember() {
                return totalMember;
            }

            public void setTotalMember(String totalMember) {
                this.totalMember = totalMember;
            }

            public String getCoachName() {
                return coachName;
            }

            public void setCoachName(String coachName) {
                this.coachName = coachName;
            }

            public String getAlbum() {
                return album;
            }

            public void setAlbum(String album) {
                this.album = album;
            }

            public String getServRange() {
                return servRange;
            }

            public void setServRange(String servRange) {
                this.servRange = servRange;
            }

            public String getSubCourseType() {
                return subCourseType;
            }

            public void setSubCourseType(String subCourseType) {
                this.subCourseType = subCourseType;
            }

            public String getLowestPrice() {
                return lowestPrice;
            }

            public void setLowestPrice(String lowestPrice) {
                this.lowestPrice = lowestPrice;
            }

            public String getHighestPrice() {
                return highestPrice;
            }

            public void setHighestPrice(String highestPrice) {
                this.highestPrice = highestPrice;
            }

            public String getOfficePhone() {
                return officePhone;
            }

            public void setOfficePhone(String officePhone) {
                this.officePhone = officePhone;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public List<TimeScheduleListBean> getTimeScheduleList() {
                return timeScheduleList;
            }

            public void setTimeScheduleList(List<TimeScheduleListBean> timeScheduleList) {
                this.timeScheduleList = timeScheduleList;
            }

            public List<CourseItemListBean> getCourseItemList() {
                return courseItemList;
            }

            public void setCourseItemList(List<CourseItemListBean> courseItemList) {
                this.courseItemList = courseItemList;
            }

            public static class SmsTemplateBean {
                private String name;
                private String content;
                private String createTime;
                private String courseId;
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

                public String getCreateTime() {
                    return createTime;
                }

                public void setCreateTime(String createTime) {
                    this.createTime = createTime;
                }

                public String getCourseId() {
                    return courseId;
                }

                public void setCourseId(String courseId) {
                    this.courseId = courseId;
                }

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }
            }

            public static class ActivityBean {
                private String name;
                private String endTime;
                private String startTime;
                private String isEnable;
                private String activityImage;
                private String id;

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
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

                public String getIsEnable() {
                    return isEnable;
                }

                public void setIsEnable(String isEnable) {
                    this.isEnable = isEnable;
                }

                public String getActivityImage() {
                    return activityImage;
                }

                public void setActivityImage(String activityImage) {
                    this.activityImage = activityImage;
                }

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }
            }

            public static class TimeScheduleListBean {
                private String name;
                private String content;
                private String endTime;
                private String startTime;
                private String courseid;
                private String status;
                private String createtime;
                private String coachid;
                private String isPush;
                private String course;
                private String memberId;
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

                public String getCourseid() {
                    return courseid;
                }

                public void setCourseid(String courseid) {
                    this.courseid = courseid;
                }

                public String getStatus() {
                    return status;
                }

                public void setStatus(String status) {
                    this.status = status;
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

                public String getIsPush() {
                    return isPush;
                }

                public void setIsPush(String isPush) {
                    this.isPush = isPush;
                }

                public String getCourse() {
                    return course;
                }

                public void setCourse(String course) {
                    this.course = course;
                }

                public String getMemberId() {
                    return memberId;
                }

                public void setMemberId(String memberId) {
                    this.memberId = memberId;
                }

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }
            }

            public static class CourseItemListBean {
                private String name;
                private String status;
                private String id;

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getStatus() {
                    return status;
                }

                public void setStatus(String status) {
                    this.status = status;
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
}
