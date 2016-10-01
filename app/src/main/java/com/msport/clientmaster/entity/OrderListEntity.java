package com.msport.clientmaster.entity;

import com.msport.clientmaster.bean.YueQiuBean;

import java.util.List;

/**
 * Created by like on 2016/8/18.
 */

public class OrderListEntity extends BaseEntity {


    /**
     * name : 课程详情测试测试
     * number : null
     * tag : 0
     * status : 1
     * ticketDetailId : null
     * receiveAccount : null
     * qCommentStatus : 1
     * qCourseCatagoryId : null
     * extraTranscDate : null
     * invitationActivity : null
     * qTelephone : 15172518243
     * extraOpenId : -1
     * extraTranscId : null
     * payee : null
     * tradingtime : 1471423234000
     * paymentmode : 1
     * buyerEmail : null
     * coach : null
     * consumeCode : null
     * amount : 0.02
     * billid : 201608171640340204595711
     * billType : 0
     * couponId : null
     * payerId : 80
     * actualAmount : null
     * customerAddress : null
     * activityId : null
     * invitationId : null
     * refundStatus : null
     * qCoachName : null
     * coachId : null
     * course : {"name":"课程详情测试测试","value":0,"location":null,"comment":"课程短介绍课程短介绍课程短介绍课程短介绍课程短介绍课程短介绍课程短介绍课程短介绍课程短介绍","orgId":null,"smsTemplateId":null,"smsTemplate":{"name":null,"content":null,"createTime":null,"courseId":null,"id":"-1"},"qDate":null,"distance":null,"latitude":null,"longtitude":null,"courseimage":"|/msport-admin/userfiles/c07bd4b956034129b09d04ee7c095822/files/admin/course/2016/08/lALOYiGV_M0B8c0CAA_512_497.png","timestart":"2016-08-25","timeend":"2016-08-27","price":"0.01","coursetype":"1","isPrivate":null,"introduce":"课程介绍课程介绍课程介绍课程介绍课程介绍课程介绍课程介绍课程介绍课程介绍课程介绍课程介绍课程介绍课程介绍课程介绍课程介绍课程介绍课程介绍课程介绍课程介绍课程介绍课程介绍课程介绍课程介绍课程介绍课程介绍课程介绍课程介绍课程介绍课程介绍课程介绍课程介绍课程介绍课程介绍课程介绍课程介绍课程介绍课程介绍课程介绍课程介绍课程介绍课程介绍课程介绍课程介绍课程介绍课程介绍课程介绍课程介绍课程介绍课程介绍课程介绍课程介绍课程介绍课程介绍课程介绍课程介绍课程介绍课程介绍课程介绍课程介绍课程介绍","totalMember":null,"coachName":"李教练","album":"|/msport-admin/userfiles/c07bd4b956034129b09d04ee7c095822/files/admin/course/2016/08/QQ%E6%88%AA%E5%9B%BE20160803140120.png|/msport-admin/userfiles/c07bd4b956034129b09d04ee7c095822/files/admin/course/2016/08/QQ%E6%88%AA%E5%9B%BE20160803140128.png|/msport-admin/userfiles/c07bd4b956034129b09d04ee7c095822/files/admin/course/2016/08/QQ%E6%88%AA%E5%9B%BE20160803140135.png","servRange":",1,2,3,","subCourseType":"8","lowestPrice":0,"highestPrice":0,"officePhone":null,"status":0,"sort":0,"coach":null,"activity":{"name":null,"endTime":null,"startTime":null,"isEnable":null,"activityImage":null,"id":"-1"},"timeScheduleList":[],"totalavailable":"100","courseItemList":[],"billId":null,"isHot":null,"venueName":null,"id":"29"}
     * aVenueId : null
     * qScheduleList : null
     * courseId : 29
     * id : 1126
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
        private String ticketDetailId;
        private String receiveAccount;
        private String qCommentStatus;
        private String qCourseCatagoryId;
        private String extraTranscDate;
        private YueQiuBean invitationActivity;
        private String qTelephone;
        private String extraOpenId;
        private String extraTranscId;
        private String payee;
        private String tradingtime;
        private String paymentmode;
        private String buyerEmail;
        private CoachDetailEntity.DataBean.QualificationCoachListBean.CoachBean coach;
        private String consumeCode;
        private String amount;
        private String billid;
        private String billType;
        private String couponId;
        private String payerId;
        private String actualAmount;
        private String customerAddress;
        private String activityId;
        private String invitationId;
        private String refundStatus;
        private String qCoachName;
        private String coachId;

        public String getTicketImage() {
            return ticketImage;
        }

        public void setTicketImage(String ticketImage) {
            this.ticketImage = ticketImage;
        }

        private String ticketImage;
        /**
         * name : 课程详情测试测试
         * value : 0
         * location : null
         * comment : 课程短介绍课程短介绍课程短介绍课程短介绍课程短介绍课程短介绍课程短介绍课程短介绍课程短介绍
         * orgId : null
         * smsTemplateId : null
         * smsTemplate : {"name":null,"content":null,"createTime":null,"courseId":null,"id":"-1"}
         * qDate : null
         * distance : null
         * latitude : null
         * longtitude : null
         * courseimage : |/msport-admin/userfiles/c07bd4b956034129b09d04ee7c095822/files/admin/course/2016/08/lALOYiGV_M0B8c0CAA_512_497.png
         * timestart : 2016-08-25
         * timeend : 2016-08-27
         * price : 0.01
         * coursetype : 1
         * isPrivate : null
         * introduce : 课程介绍课程介绍课程介绍课程介绍课程介绍课程介绍课程介绍课程介绍课程介绍课程介绍课程介绍课程介绍课程介绍课程介绍课程介绍课程介绍课程介绍课程介绍课程介绍课程介绍课程介绍课程介绍课程介绍课程介绍课程介绍课程介绍课程介绍课程介绍课程介绍课程介绍课程介绍课程介绍课程介绍课程介绍课程介绍课程介绍课程介绍课程介绍课程介绍课程介绍课程介绍课程介绍课程介绍课程介绍课程介绍课程介绍课程介绍课程介绍课程介绍课程介绍课程介绍课程介绍课程介绍课程介绍课程介绍课程介绍课程介绍课程介绍课程介绍课程介绍
         * totalMember : null
         * coachName : 李教练
         * album : |/msport-admin/userfiles/c07bd4b956034129b09d04ee7c095822/files/admin/course/2016/08/QQ%E6%88%AA%E5%9B%BE20160803140120.png|/msport-admin/userfiles/c07bd4b956034129b09d04ee7c095822/files/admin/course/2016/08/QQ%E6%88%AA%E5%9B%BE20160803140128.png|/msport-admin/userfiles/c07bd4b956034129b09d04ee7c095822/files/admin/course/2016/08/QQ%E6%88%AA%E5%9B%BE20160803140135.png
         * servRange : ,1,2,3,
         * subCourseType : 8
         * lowestPrice : 0
         * highestPrice : 0
         * officePhone : null
         * status : 0
         * sort : 0
         * coach : null
         * activity : {"name":null,"endTime":null,"startTime":null,"isEnable":null,"activityImage":null,"id":"-1"}
         * timeScheduleList : []
         * totalavailable : 100
         * courseItemList : []
         * billId : null
         * isHot : null
         * venueName : null
         * id : 29
         */

        private CourseBean course;
        private String aVenueId;
        private String qScheduleList;
        private String courseId;
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

        public String getTicketDetailId() {
            return ticketDetailId;
        }

        public void setTicketDetailId(String ticketDetailId) {
            this.ticketDetailId = ticketDetailId;
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

        public YueQiuBean getInvitationActivity() {
            return invitationActivity;
        }

        public void setInvitationActivity(YueQiuBean invitationActivity) {
            this.invitationActivity = invitationActivity;
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

        public String getCustomerAddress() {
            return customerAddress;
        }

        public void setCustomerAddress(String customerAddress) {
            this.customerAddress = customerAddress;
        }

        public String getActivityId() {
            return activityId;
        }

        public void setActivityId(String activityId) {
            this.activityId = activityId;
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
             * id : -1
             */

            private SmsTemplateBean smsTemplate;
            private String qDate;
            private String distance;
            private String latitude;
            private String longtitude;
            private String courseimage;
            private String timestart;
            private String timeend;
            private String price;
            private String coursetype;
            private String isPrivate;
            private String introduce;
            private String totalMember;
            private String coachName;
            private String album;
            private String servRange;
            private String subCourseType;
            private String lowestPrice;
            private String highestPrice;
            private String officePhone;
            private String status;
            private String sort;
            private String coach;
            /**
             * name : null
             * endTime : null
             * startTime : null
             * isEnable : null
             * activityImage : null
             * id : -1
             */

            private ActivityBean activity;
            private String totalavailable;
            private String billId;
            private String isHot;
            private String venueName;
            private String id;
            private List<?> timeScheduleList;
            private List<?> courseItemList;

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

            public String getLongtitude() {
                return longtitude;
            }

            public void setLongtitude(String longtitude) {
                this.longtitude = longtitude;
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

            public String getIsPrivate() {
                return isPrivate;
            }

            public void setIsPrivate(String isPrivate) {
                this.isPrivate = isPrivate;
            }

            public String getIntroduce() {
                return introduce;
            }

            public void setIntroduce(String introduce) {
                this.introduce = introduce;
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

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getSort() {
                return sort;
            }

            public void setSort(String sort) {
                this.sort = sort;
            }

            public String getCoach() {
                return coach;
            }

            public void setCoach(String coach) {
                this.coach = coach;
            }

            public ActivityBean getActivity() {
                return activity;
            }

            public void setActivity(ActivityBean activity) {
                this.activity = activity;
            }

            public String getTotalavailable() {
                return totalavailable;
            }

            public void setTotalavailable(String totalavailable) {
                this.totalavailable = totalavailable;
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

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public List<?> getTimeScheduleList() {
                return timeScheduleList;
            }

            public void setTimeScheduleList(List<?> timeScheduleList) {
                this.timeScheduleList = timeScheduleList;
            }

            public List<?> getCourseItemList() {
                return courseItemList;
            }

            public void setCourseItemList(List<?> courseItemList) {
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
        }
    }
}
