package com.msport.clientmaster.entity;

import java.io.Serializable;

/**
 * Created by like on 2016/8/23.
 */

public class MenPiaoOrderEntity extends BaseEntity{


    /**
     * billInfo : {"name":"822测试","number":"1","tag":0,"status":-1,"amount":"12.00","billid":"201608231730161822977957","billType":7,"customerAddress":null,"invitationId":null,"refundStatus":null,"qCoachName":null,"coachId":null,"course":null,"aVenueId":null,"qScheduleList":null,"courseId":null,"activityId":"-1","qTelephone":null,"extraOpenId":null,"extraTranscId":null,"payee":null,"tradingtime":1471944616272,"paymentmode":-1,"buyerEmail":null,"coach":null,"consumeCode":null,"venue":null,"actualAmount":null,"ticketDetailId":null,"receiveAccount":null,"qCommentStatus":null,"qCourseCatagoryId":null,"extraTranscDate":null,"invitationActivity":null,"consumeCodeVerify":null,"consumeCodeTime":null,"couponId":null,"payerId":"80","id":"2d811d58d68c49d2b985c8106bc0327a"}
     * ticketInfo : {"address":null,"name":"822测试","value":0,"number":null,"comment":"没有备注","source":null,"amount":"12.00","sort":0,"validEndDate":1473475546000,"unit":"次卡","marketPrice":"123.00","venueId":"26","image":"|/msport-admin/userfiles/c07bd4b956034129b09d04ee7c095822/files/admin/venueTicket/2016/08/lALOYiGV_M0B8c0CAA_512_497.png","extraRemainNum":null,"currentSaleNum":null,"validStartDate":1471920344000,"id":"38"}
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * name : 822测试
         * number : 1
         * tag : 0
         * status : -1
         * amount : 12.00
         * billid : 201608231730161822977957
         * billType : 7
         * customerAddress : null
         * invitationId : null
         * refundStatus : null
         * qCoachName : null
         * coachId : null
         * course : null
         * aVenueId : null
         * qScheduleList : null
         * courseId : null
         * activityId : -1
         * qTelephone : null
         * extraOpenId : null
         * extraTranscId : null
         * payee : null
         * tradingtime : 1471944616272
         * paymentmode : -1
         * buyerEmail : null
         * coach : null
         * consumeCode : null
         * venue : null
         * actualAmount : null
         * ticketDetailId : null
         * receiveAccount : null
         * qCommentStatus : null
         * qCourseCatagoryId : null
         * extraTranscDate : null
         * invitationActivity : null
         * consumeCodeVerify : null
         * consumeCodeTime : null
         * couponId : null
         * payerId : 80
         * id : 2d811d58d68c49d2b985c8106bc0327a
         */

        private BillInfoBean billInfo;
        /**
         * address : null
         * name : 822测试
         * value : 0
         * number : null
         * comment : 没有备注
         * source : null
         * amount : 12.00
         * sort : 0
         * validEndDate : 1473475546000
         * unit : 次卡
         * marketPrice : 123.00
         * venueId : 26
         * image : |/msport-admin/userfiles/c07bd4b956034129b09d04ee7c095822/files/admin/venueTicket/2016/08/lALOYiGV_M0B8c0CAA_512_497.png
         * extraRemainNum : null
         * currentSaleNum : null
         * validStartDate : 1471920344000
         * id : 38
         */

        private TicketInfoBean ticketInfo;

        public BillInfoBean getBillInfo() {
            return billInfo;
        }

        public void setBillInfo(BillInfoBean billInfo) {
            this.billInfo = billInfo;
        }

        public TicketInfoBean getTicketInfo() {
            return ticketInfo;
        }

        public void setTicketInfo(TicketInfoBean ticketInfo) {
            this.ticketInfo = ticketInfo;
        }

        public static class BillInfoBean implements Serializable{
            private String name;
            private String number;
            private String tag;
            private String status;
            private String amount;
            private String billid;
            private String billType;
            private String customerAddress;
            private String invitationId;
            private String refundStatus;
            private String qCoachName;
            private String coachId;
            private String course;
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
            private String coach;
            private String consumeCode;
            private String venue;
            private String actualAmount;
            private String ticketDetailId;
            private String receiveAccount;
            private String qCommentStatus;
            private String qCourseCatagoryId;
            private String extraTranscDate;
            private String invitationActivity;
            private String consumeCodeVerify;
            private String consumeCodeTime;
            private String couponId;
            private String payerId;
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

            public String getCustomerAddress() {
                return customerAddress;
            }

            public void setCustomerAddress(String customerAddress) {
                this.customerAddress = customerAddress;
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

            public String getCourse() {
                return course;
            }

            public void setCourse(String course) {
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

            public String getCoach() {
                return coach;
            }

            public void setCoach(String coach) {
                this.coach = coach;
            }

            public String getConsumeCode() {
                return consumeCode;
            }

            public void setConsumeCode(String consumeCode) {
                this.consumeCode = consumeCode;
            }

            public String getVenue() {
                return venue;
            }

            public void setVenue(String venue) {
                this.venue = venue;
            }

            public String getActualAmount() {
                return actualAmount;
            }

            public void setActualAmount(String actualAmount) {
                this.actualAmount = actualAmount;
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

            public String getInvitationActivity() {
                return invitationActivity;
            }

            public void setInvitationActivity(String invitationActivity) {
                this.invitationActivity = invitationActivity;
            }

            public String getConsumeCodeVerify() {
                return consumeCodeVerify;
            }

            public void setConsumeCodeVerify(String consumeCodeVerify) {
                this.consumeCodeVerify = consumeCodeVerify;
            }

            public String getConsumeCodeTime() {
                return consumeCodeTime;
            }

            public void setConsumeCodeTime(String consumeCodeTime) {
                this.consumeCodeTime = consumeCodeTime;
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

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }
        }

        public static class TicketInfoBean implements Serializable {
            private String address;
            private String name;
            private String value;
            private String number;
            private String comment;
            private String source;
            private String amount;
            private String sort;
            private String validEndDate;
            private String unit;
            private String marketPrice;
            private String venueId;
            private String image;
            private String extraRemainNum;
            private String currentSaleNum;
            private String validStartDate;
            private String id;

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

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

            public String getNumber() {
                return number;
            }

            public void setNumber(String number) {
                this.number = number;
            }

            public String getComment() {
                return comment;
            }

            public void setComment(String comment) {
                this.comment = comment;
            }

            public String getSource() {
                return source;
            }

            public void setSource(String source) {
                this.source = source;
            }

            public String getAmount() {
                return amount;
            }

            public void setAmount(String amount) {
                this.amount = amount;
            }

            public String getSort() {
                return sort;
            }

            public void setSort(String sort) {
                this.sort = sort;
            }

            public String getValidEndDate() {
                return validEndDate;
            }

            public void setValidEndDate(String validEndDate) {
                this.validEndDate = validEndDate;
            }

            public String getUnit() {
                return unit;
            }

            public void setUnit(String unit) {
                this.unit = unit;
            }

            public String getMarketPrice() {
                return marketPrice;
            }

            public void setMarketPrice(String marketPrice) {
                this.marketPrice = marketPrice;
            }

            public String getVenueId() {
                return venueId;
            }

            public void setVenueId(String venueId) {
                this.venueId = venueId;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public String getExtraRemainNum() {
                return extraRemainNum;
            }

            public void setExtraRemainNum(String extraRemainNum) {
                this.extraRemainNum = extraRemainNum;
            }

            public String getCurrentSaleNum() {
                return currentSaleNum;
            }

            public void setCurrentSaleNum(String currentSaleNum) {
                this.currentSaleNum = currentSaleNum;
            }

            public String getValidStartDate() {
                return validStartDate;
            }

            public void setValidStartDate(String validStartDate) {
                this.validStartDate = validStartDate;
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
