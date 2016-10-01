package com.msport.clientmaster.entity;

import com.msport.clientmaster.bean.VenueBean;
import com.msport.clientmaster.bean.YueQiuBean;

import java.util.List;

/**
 * Created by like on 2016/8/20.
 */

public class OrderDetailEntity extends BaseEntity {



    /**
     * name : (null)(1课时)
     * number : null
     * tag : 1
     * status : 1
     * amount : 0.02
     * billid : 201606201927451466422065346735
     * billType : 2
     * couponId : null
     * payerId : 80
     * actualAmount : null
     * customerAddress : 武汉市蔡甸区武汉体育中心
     * invitationId : null
     * refundStatus : null
     * qCoachName : 张雅芝
     * coachId : 1
     * course : null
     * aVenueId : null
     * qScheduleList : 30,31
     * courseId : null
     * activityId : null
     * qTelephone : 15172518243
     * extraOpenId : null
     * extraTranscId : null
     * payee : null
     * tradingtime : 1466422065000
     * paymentmode : 1
     * buyerEmail : null
     * coach : {"name":"张雅芝","value":0,"major":"1","grade":"三级","sort":0,"courseCatagoryList":[],"servIdTimeList":["null"],"availabletimeid":"3","qualificationCoachList":[],"coachExperienceList":[],"servTime":",null,","courseList":[],"weight":90,"fees":20,"telephone":"13476778888","isHot":1,"avatarimg":"|/msport-admin/userfiles/1/files/admin/coach/2016/05/timg.jpeg","age":18,"height":180,"Stringroduce":"李教练是个好人","album":"|/msport-admin/userfiles/1/files/admin/coach/2016/05/timg.jpeg|/msport-admin/userfiles/1/files/admin/course/2016/04/bd_logo1.png","servRange":",0,1,2,","lowestPrice":0,"highestPrice":0,"cooperatetype":"2","cooperatetime":1459911720000,"contractimage":"","isapproval":"1","scheduleid":"2","setttletype":"2","msVenueId":null,"formal":"5","gender":2,"othermajor":"","venueNames":"","coachYear":null,"venueAddress":null,"starttime":1466179200000,"endtime":1467648000000,"id":"1"}
     * consumeCode : 987654321321
     * ticketDetailId : null
     * receiveAccount : null
     * qCommentStatus : 0
     * qCourseCatagoryId : null
     * extraTranscDate : 1466422109000
     * invitationActivity : null
     * consumeCodeVerify : null
     * consumeCodeTime : 1503195264000
     * id : 671
     */

    private DataBean data;
    /**
     * address : 测试地址
     * name : 测试场馆
     * value : 0
     * type : 0
     * distance : null
     * latitude : 
     * longtitude : 
     * sort : 0
     * major : 6
     * courseList : null
     * ticketList : null
     * qDateTime : null
     * city : 
     * district : 
     * street : 
     * qualificid : null
     * cooperatetype : null
     * ownername : null
     * cooperatetime : null
     * gateimage : |/msport-admin/userfiles/1/files/admin/venue/2016/07/02.jpg
     * venuearea : 44
     * settletype : null
     * isapproval : null
     * featurelist : 4444
     * titleImage : 
     * businesshoursstart : 1470642134000
     * businesshoursend : 1472110936000
     * fees : 55
     * telephone : 223424
     * servRange : null
     * lowestPrice : 0
     * highestPrice : 0
     * isaccepttrainning : 
     * id : 26
     */

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
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
        private String customerAddress;
        private String invitationId;
        private String refundStatus;
        private String qCoachName;
        private String coachId;
        private OrderListEntity.DataBean.CourseBean course;
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
        // 门票状态：
        private String verifyStatus;

        public String getTicketCode() {
            return ticketCode;
        }

        public void setTicketCode(String ticketCode) {
            this.ticketCode = ticketCode;
        }

        public String getVerifyStatus() {
            return verifyStatus;
        }

        public void setVerifyStatus(String verifyStatus) {
            this.verifyStatus = verifyStatus;
        }

        // 门票码
        private String ticketCode;

        public String getTicketImage() {
            return ticketImage;
        }

        public void setTicketImage(String ticketImage) {
            this.ticketImage = ticketImage;
        }

        private String ticketImage;
        /**
         * name : 张雅芝
         * value : 0
         * major : 1
         * grade : 三级
         * sort : 0
         * courseCatagoryList : []
         * servIdTimeList : ["null"]
         * availabletimeid : 3
         * qualificationCoachList : []
         * coachExperienceList : []
         * servTime : ,null,
         * courseList : []
         * weight : 90
         * fees : 20
         * telephone : 13476778888
         * isHot : 1
         * avatarimg : |/msport-admin/userfiles/1/files/admin/coach/2016/05/timg.jpeg
         * age : 18
         * height : 180
         * Stringroduce : 李教练是个好人
         * album : |/msport-admin/userfiles/1/files/admin/coach/2016/05/timg.jpeg|/msport-admin/userfiles/1/files/admin/course/2016/04/bd_logo1.png
         * servRange : ,0,1,2,
         * lowestPrice : 0
         * highestPrice : 0
         * cooperatetype : 2
         * cooperatetime : 1459911720000
         * contractimage :
         * isapproval : 1
         * scheduleid : 2
         * setttletype : 2
         * msVenueId : null
         * formal : 5
         * gender : 2
         * othermajor :
         * venueNames :
         * coachYear : null
         * venueAddress : null
         * starttime : 1466179200000
         * endtime : 1467648000000
         * id : 1
         */

        private CoachBean coach;
        private String consumeCode;
        private String ticketDetailId;
        private String receiveAccount;
        private String qCommentStatus;
        private String qCourseCatagoryId;
        private String extraTranscDate;
        private YueQiuBean invitationActivity;
        private String consumeCodeVerify;
        private String consumeCodeTime;
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

        public OrderListEntity.DataBean.CourseBean getCourse() {
            return course;
        }

        public void setCourse(OrderListEntity.DataBean.CourseBean course) {
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

        public CoachBean getCoach() {
            return coach;
        }

        public void setCoach(CoachBean coach) {
            this.coach = coach;
        }

        public String getConsumeCode() {
            return consumeCode;
        }

        public void setConsumeCode(String consumeCode) {
            this.consumeCode = consumeCode;
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

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public static class CoachBean {
            private String name;
            private String value;
            private String major;
            private String grade;
            private String sort;
            private String availabletimeid;
            private String servTime;
            private String weight;
            private String fees;
            private String telephone;
            private String isHot;
            private String avatarimg;
            private String age;
            private String height;
            private String Stringroduce;
            private String album;
            private String servRange;
            private String lowestPrice;
            private String highestPrice;
            private String cooperatetype;
            private String cooperatetime;
            private String contractimage;
            private String isapproval;
            private String scheduleid;
            private String setttletype;
            private String msVenueId;
            private String formal;
            private String gender;
            private String othermajor;
            private String venueNames;
            private String coachYear;
            private String venueAddress;
            private String starttime;
            private String endtime;
            private String id;
            private List<?> courseCatagoryList;
            private List<String> servIdTimeList;
            private List<?> qualificationCoachList;
            private List<?> coachExperienceList;
            private List<?> courseList;

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

            public String getMajor() {
                return major;
            }

            public void setMajor(String major) {
                this.major = major;
            }

            public String getGrade() {
                return grade;
            }

            public void setGrade(String grade) {
                this.grade = grade;
            }

            public String getSort() {
                return sort;
            }

            public void setSort(String sort) {
                this.sort = sort;
            }

            public String getAvailabletimeid() {
                return availabletimeid;
            }

            public void setAvailabletimeid(String availabletimeid) {
                this.availabletimeid = availabletimeid;
            }

            public String getServTime() {
                return servTime;
            }

            public void setServTime(String servTime) {
                this.servTime = servTime;
            }

            public String getWeight() {
                return weight;
            }

            public void setWeight(String weight) {
                this.weight = weight;
            }

            public String getFees() {
                return fees;
            }

            public void setFees(String fees) {
                this.fees = fees;
            }

            public String getTelephone() {
                return telephone;
            }

            public void setTelephone(String telephone) {
                this.telephone = telephone;
            }

            public String getIsHot() {
                return isHot;
            }

            public void setIsHot(String isHot) {
                this.isHot = isHot;
            }

            public String getAvatarimg() {
                return avatarimg;
            }

            public void setAvatarimg(String avatarimg) {
                this.avatarimg = avatarimg;
            }

            public String getAge() {
                return age;
            }

            public void setAge(String age) {
                this.age = age;
            }

            public String getHeight() {
                return height;
            }

            public void setHeight(String height) {
                this.height = height;
            }

            public String getIntroduce() {
                return Stringroduce;
            }

            public void setIntroduce(String Stringroduce) {
                this.Stringroduce = Stringroduce;
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

            public String getCooperatetype() {
                return cooperatetype;
            }

            public void setCooperatetype(String cooperatetype) {
                this.cooperatetype = cooperatetype;
            }

            public String getCooperatetime() {
                return cooperatetime;
            }

            public void setCooperatetime(String cooperatetime) {
                this.cooperatetime = cooperatetime;
            }

            public String getContractimage() {
                return contractimage;
            }

            public void setContractimage(String contractimage) {
                this.contractimage = contractimage;
            }

            public String getIsapproval() {
                return isapproval;
            }

            public void setIsapproval(String isapproval) {
                this.isapproval = isapproval;
            }

            public String getScheduleid() {
                return scheduleid;
            }

            public void setScheduleid(String scheduleid) {
                this.scheduleid = scheduleid;
            }

            public String getSetttletype() {
                return setttletype;
            }

            public void setSetttletype(String setttletype) {
                this.setttletype = setttletype;
            }

            public String getMsVenueId() {
                return msVenueId;
            }

            public void setMsVenueId(String msVenueId) {
                this.msVenueId = msVenueId;
            }

            public String getFormal() {
                return formal;
            }

            public void setFormal(String formal) {
                this.formal = formal;
            }

            public String getGender() {
                return gender;
            }

            public void setGender(String gender) {
                this.gender = gender;
            }

            public String getOthermajor() {
                return othermajor;
            }

            public void setOthermajor(String othermajor) {
                this.othermajor = othermajor;
            }

            public String getVenueNames() {
                return venueNames;
            }

            public void setVenueNames(String venueNames) {
                this.venueNames = venueNames;
            }

            public String getCoachYear() {
                return coachYear;
            }

            public void setCoachYear(String coachYear) {
                this.coachYear = coachYear;
            }

            public String getVenueAddress() {
                return venueAddress;
            }

            public void setVenueAddress(String venueAddress) {
                this.venueAddress = venueAddress;
            }

            public String getStarttime() {
                return starttime;
            }

            public void setStarttime(String starttime) {
                this.starttime = starttime;
            }

            public String getEndtime() {
                return endtime;
            }

            public void setEndtime(String endtime) {
                this.endtime = endtime;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public List<?> getCourseCatagoryList() {
                return courseCatagoryList;
            }

            public void setCourseCatagoryList(List<?> courseCatagoryList) {
                this.courseCatagoryList = courseCatagoryList;
            }

            public List<String> getServIdTimeList() {
                return servIdTimeList;
            }

            public void setServIdTimeList(List<String> servIdTimeList) {
                this.servIdTimeList = servIdTimeList;
            }

            public List<?> getQualificationCoachList() {
                return qualificationCoachList;
            }

            public void setQualificationCoachList(List<?> qualificationCoachList) {
                this.qualificationCoachList = qualificationCoachList;
            }

            public List<?> getCoachExperienceList() {
                return coachExperienceList;
            }

            public void setCoachExperienceList(List<?> coachExperienceList) {
                this.coachExperienceList = coachExperienceList;
            }

            public List<?> getCourseList() {
                return courseList;
            }

            public void setCourseList(List<?> courseList) {
                this.courseList = courseList;
            }
        }
        private VenueBean venue;

        public VenueBean getVenue() {
            return venue;
        }

        public void setVenue(VenueBean venue) {
            this.venue = venue;
        }
    }

}
