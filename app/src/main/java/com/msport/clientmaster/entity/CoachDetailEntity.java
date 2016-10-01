package com.msport.clientmaster.entity;

import com.msport.clientmaster.bean.CoachExperienceList;

import java.util.List;

/**
 * Created by like on 2016/8/1.
 */

public class CoachDetailEntity extends  BaseEntity {

    /**
     * name : 张雅芝
     * value : 0
     * sort : 0
     * weight : 90
     * fees : 20
     * telephone : 4
     * isHot : 1
     * major : 二级教练
     * courseList : [{"name":"瑜伽课程--汉街运动","value":0,"location":"33","comment":null,"sort":0,"status":0,"billId":null,"isHot":1,"activity":{"name":null,"endTime":null,"startTime":null,"isEnable":null,"activityImage":null,"id":"1"},"timeScheduleList":[],"totalavailable":"600","courseItemList":[],"smsTemplateId":null,"smsTemplate":{"name":null,"content":null,"createTime":null,"courseId":null,"id":"2"},"qDate":null,"distance":null,"coach":null,"latitude":null,"longtitude":null,"courseimage":"","timestart":"14:30","timeend":"15:00","price":"0.01","coursetype":"2","isPrivate":1,"id":"6"},{"name":"游泳课程","value":0,"location":"武汉市武昌区徐东路钢材市场","comment":null,"sort":0,"status":0,"billId":null,"isHot":1,"activity":{"name":null,"endTime":null,"startTime":null,"isEnable":null,"activityImage":null,"id":"-1"},"timeScheduleList":[],"totalavailable":"50","courseItemList":[],"smsTemplateId":null,"smsTemplate":{"name":null,"content":null,"createTime":null,"courseId":null,"id":"1"},"qDate":null,"distance":null,"coach":null,"latitude":null,"longtitude":null,"courseimage":"","timestart":"14:00","timeend":"14:30","price":"0.01","coursetype":"0","isPrivate":0,"id":"7"},{"name":"羽毛球课程11","value":0,"location":"武汉市洪山区蓝晶绿洲","comment":null,"sort":0,"status":0,"billId":null,"isHot":1,"activity":{"name":null,"endTime":null,"startTime":null,"isEnable":null,"activityImage":null,"id":"-1"},"timeScheduleList":[],"totalavailable":"200","courseItemList":[],"smsTemplateId":null,"smsTemplate":null,"qDate":null,"distance":null,"coach":null,"latitude":null,"longtitude":null,"courseimage":"","timestart":"16:00","timeend":"15:30","price":"300","coursetype":"0","isPrivate":null,"id":"8"},{"name":"羽毛球课程","value":0,"location":"武汉市洪山区蓝晶绿洲","comment":null,"sort":0,"status":0,"billId":null,"isHot":0,"activity":{"name":null,"endTime":null,"startTime":null,"isEnable":null,"activityImage":null,"id":"-1"},"timeScheduleList":[],"totalavailable":"6","courseItemList":[],"smsTemplateId":null,"smsTemplate":{"name":null,"content":null,"createTime":null,"courseId":null,"id":"-1"},"qDate":null,"distance":null,"coach":null,"latitude":null,"longtitude":null,"courseimage":"","timestart":"18:00","timeend":"20:00","price":"150","coursetype":"1","isPrivate":null,"id":"9"},{"name":"东西湖游泳课程","value":0,"location":"北京市海淀区如家快捷酒店(北京紫竹桥店)","comment":null,"sort":0,"status":0,"billId":null,"isHot":1,"activity":{"name":null,"endTime":null,"startTime":null,"isEnable":null,"activityImage":null,"id":"-1"},"timeScheduleList":[],"totalavailable":"50","courseItemList":[],"smsTemplateId":null,"smsTemplate":null,"qDate":null,"distance":null,"coach":null,"latitude":null,"longtitude":null,"courseimage":"|/msport-admin/userfiles/1/files/admin/course/2016/04/timg.jpeg","timestart":"04-21","timeend":"04-30","price":"700","coursetype":"0","isPrivate":1,"id":"11"},{"name":"最新19.9优惠活动","value":0,"location":"武汉市武昌区徐东路钢材市场","comment":null,"sort":0,"status":0,"billId":null,"isHot":0,"activity":{"name":null,"endTime":null,"startTime":null,"isEnable":null,"activityImage":null,"id":"1"},"timeScheduleList":[],"totalavailable":"500","courseItemList":[],"smsTemplateId":null,"smsTemplate":null,"qDate":null,"distance":null,"coach":null,"latitude":null,"longtitude":null,"courseimage":"","timestart":"05-03","timeend":"05-04","price":"19.9","coursetype":"0","isPrivate":0,"id":"12"},{"name":"体验课","value":0,"location":null,"comment":null,"sort":0,"status":0,"billId":null,"isHot":null,"activity":null,"timeScheduleList":[],"totalavailable":"30","courseItemList":[],"smsTemplateId":null,"smsTemplate":null,"qDate":null,"distance":null,"coach":null,"latitude":null,"longtitude":null,"courseimage":null,"timestart":"2016-05-07 16:44","timeend":"2016-05-18 16:44","price":"30","coursetype":null,"isPrivate":1,"id":"13"},{"name":"张雅芝的课程02","value":0,"location":null,"comment":null,"sort":0,"status":0,"billId":null,"isHot":0,"activity":{"name":null,"endTime":null,"startTime":null,"isEnable":null,"activityImage":null,"id":"-1"},"timeScheduleList":[],"totalavailable":"20","courseItemList":[],"smsTemplateId":null,"smsTemplate":{"name":null,"content":null,"createTime":null,"courseId":null,"id":"1"},"qDate":null,"distance":null,"coach":null,"latitude":null,"longtitude":null,"courseimage":"","timestart":"2016-05-07 19:26","timeend":"2016-05-09 19:26","price":"40","coursetype":"0","isPrivate":1,"id":"14"},{"name":"瑜伽课程","value":0,"location":"武汉市洪山区蓝晶绿洲","comment":null,"sort":0,"status":0,"billId":null,"isHot":1,"activity":{"name":null,"endTime":null,"startTime":null,"isEnable":null,"activityImage":null,"id":"-1"},"timeScheduleList":[],"totalavailable":"76","courseItemList":[],"smsTemplateId":null,"smsTemplate":null,"qDate":null,"distance":null,"coach":null,"latitude":null,"longtitude":null,"courseimage":"","timestart":"05-09","timeend":"05-11","price":"23","coursetype":"2","isPrivate":1,"id":"15"},{"name":"111","value":0,"location":null,"comment":null,"sort":0,"status":0,"billId":null,"isHot":1,"activity":{"name":null,"endTime":null,"startTime":null,"isEnable":null,"activityImage":null,"id":"-1"},"timeScheduleList":[],"totalavailable":"33","courseItemList":[],"smsTemplateId":null,"smsTemplate":null,"qDate":null,"distance":null,"coach":null,"latitude":null,"longtitude":null,"courseimage":"","timestart":"2016-05-12 10:49","timeend":"2016-05-13 10:49","price":"22","coursetype":"0","isPrivate":1,"id":"16"}]
     * courseCatagoryList : [{"type":"1","days":"60","courseUnit":"10","price":"1000","id":"1"},{"type":"0","days":"60","courseUnit":"1","price":"0.01","id":"2"}]
     * servIdTimeList : ["null"]
     * availabletimeid : 3
     * qualificationCoachList : [{"name":"2","value":"3","type":"0","attaches":"","coach":{"name":null,"value":0,"sort":0,"weight":null,"fees":null,"telephone":null,"isHot":null,"major":null,"courseList":[],"courseCatagoryList":[],"servIdTimeList":[],"availabletimeid":null,"qualificationCoachList":[],"coachExperienceList":[],"clientCommentList":[],"age":null,"height":null,"cooperatetype":null,"cooperatetime":null,"contractimage":null,"isapproval":null,"introduce":null,"album":null,"servTime":null,"servRange":null,"avatarimg":null,"scheduleid":null,"setttletype":null,"msVenueId":null,"formal":null,"gender":null,"othermajor":null,"venueNames":null,"coachYear":null,"venueAddress":null,"id":"1"},"id":"1"},{"name":"4","value":"","type":"0","attaches":"","coach":{"name":null,"value":0,"sort":0,"weight":null,"fees":null,"telephone":null,"isHot":null,"major":null,"courseList":[],"courseCatagoryList":[],"servIdTimeList":[],"availabletimeid":null,"qualificationCoachList":[],"coachExperienceList":[],"clientCommentList":[],"age":null,"height":null,"cooperatetype":null,"cooperatetime":null,"contractimage":null,"isapproval":null,"introduce":null,"album":null,"servTime":null,"servRange":null,"avatarimg":null,"scheduleid":null,"setttletype":null,"msVenueId":null,"formal":null,"gender":null,"othermajor":null,"venueNames":null,"coachYear":null,"venueAddress":null,"id":"1"},"id":"2"}]
     * coachExperienceList : []
     * clientCommentList : [{"type":"0","content":"1112223334445556667778888899r688eede dyrsshhy5","billId":"201606161650111466067011958126","createTime":null,"extraMemberName":"换手机号说说","extraCoachName":"张雅芝","extraCourseName":null,"coachId":"1","courseId":null,"memberId":80,"commentIds":"0","courseDegree":"5","coachDegree":"2","billName":null,"title":"羽毛球(1课时)","id":"6"},{"type":"0","content":"244565","billId":"201607041503301467615810890534","createTime":null,"extraMemberName":"换手机号说说","extraCoachName":"张雅芝","extraCourseName":null,"coachId":"1","courseId":null,"memberId":80,"commentIds":"0","courseDegree":"3","coachDegree":"4","billName":null,"title":"(null)(1课时)","id":"15"},{"type":"0","content":"1234567","billId":"201607041500441467615644365121","createTime":null,"extraMemberName":"换手机号说说","extraCoachName":"张雅芝","extraCourseName":null,"coachId":"1","courseId":null,"memberId":80,"commentIds":"1,0115711","courseDegree":"3","coachDegree":"4","billName":null,"title":"(null)(1课时)","id":"16"},{"type":"0","content":"12345","billId":"201606161713551466068435202659","createTime":null,"extraMemberName":"换手机号说说","extraCoachName":"张雅芝","extraCourseName":null,"coachId":"1","courseId":null,"memberId":80,"commentIds":"2,1","courseDegree":"4","coachDegree":"4","billName":null,"title":"羽毛球(1课时)","id":"17"},{"type":"0","content":"34","billId":"201607041456271467615387555402","createTime":null,"extraMemberName":"换手机号说说","extraCoachName":"张雅芝","extraCourseName":null,"coachId":"1","courseId":null,"memberId":80,"commentIds":"1,0","courseDegree":"4","coachDegree":"5","billName":null,"title":"(null)(1课时)","id":"18"},{"type":"0","content":"德玛西亚","billId":"201606211638561466498336042124","createTime":null,"extraMemberName":"换手机号说说","extraCoachName":"张雅芝","extraCourseName":null,"coachId":"1","courseId":null,"memberId":80,"commentIds":"2,0115711","courseDegree":"3","coachDegree":"4","billName":null,"title":"(null)(1课时)","id":"22"}]
     * age : 18
     * height : 180
     * cooperatetype : 2
     * cooperatetime : 1459911720000
     * contractimage : 
     * isapproval : 1
     * introduce : 李教练是个好人
     * album : |/msport-admin/userfiles/1/files/admin/coach/2016/05/timg.jpeg|/msport-admin/userfiles/1/files/admin/course/2016/04/bd_logo1.png
     * servTime : ,null,
     * servRange : ,0,1,2,
     * avatarimg : |/msport-admin/userfiles/1/files/admin/coach/2016/05/timg.jpeg
     * scheduleid : 2
     * setttletype : 2
     * msVenueId : null
     * formal : 5
     * gender : 2
     * othermajor : 
     * venueNames : 
     * coachYear : null
     * venueAddress : null
     * id : 1
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private String name;
        private String value;
        private String sort;
        private String weight;
        private String fees;
        private String telephone;
        private String isHot;
        private String major;
        private String availabletimeid;
        private String age;
        private String height;
        private String cooperatetype;
        private String cooperatetime;
        private String contractimage;
        private String isapproval;
        private String introduce;
        private String album;
        private String servTime;
        private String servRange;
        private String avatarimg;
        private String scheduleid;
        private String setttletype;
        private String msVenueId;
        private String formal;
        private String gender;
        private String othermajor;
        private String venueNames;
        private String coachYear;
        private String venueAddress;
        private String id;
        /**
         * name : 瑜伽课程--汉街运动
         * value : 0
         * location : 33
         * comment : null
         * sort : 0
         * status : 0
         * billId : null
         * isHot : 1
         * activity : {"name":null,"endTime":null,"startTime":null,"isEnable":null,"activityImage":null,"id":"1"}
         * timeScheduleList : []
         * totalavailable : 600
         * courseItemList : []
         * smsTemplateId : null
         * smsTemplate : {"name":null,"content":null,"createTime":null,"courseId":null,"id":"2"}
         * qDate : null
         * distance : null
         * coach : null
         * latitude : null
         * longtitude : null
         * courseimage : 
         * timestart : 14:30
         * timeend : 15:00
         * price : 0.01
         * coursetype : 2
         * isPrivate : 1
         * id : 6
         */

        private List<CourseListBean> courseList;
        /**
         * type : 1
         * days : 60
         * courseUnit : 10
         * price : 1000
         * id : 1
         */

        private List<CourseCatagoryListBean> courseCatagoryList;
        private List<String> servIdTimeList;
        /**
         * name : 2
         * value : 3
         * type : 0
         * attaches : 
         * coach : {"name":null,"value":0,"sort":0,"weight":null,"fees":null,"telephone":null,"isHot":null,"major":null,"courseList":[],"courseCatagoryList":[],"servIdTimeList":[],"availabletimeid":null,"qualificationCoachList":[],"coachExperienceList":[],"clientCommentList":[],"age":null,"height":null,"cooperatetype":null,"cooperatetime":null,"contractimage":null,"isapproval":null,"introduce":null,"album":null,"servTime":null,"servRange":null,"avatarimg":null,"scheduleid":null,"setttletype":null,"msVenueId":null,"formal":null,"gender":null,"othermajor":null,"venueNames":null,"coachYear":null,"venueAddress":null,"id":"1"}
         * id : 1
         */

        private List<QualificationCoachListBean> qualificationCoachList;
        private List<CoachExperienceList> coachExperienceList;
        /**
         * type : 0
         * content : 1112223334445556667778888899r688eede dyrsshhy5
         * billId : 201606161650111466067011958126
         * createTime : null
         * extraMemberName : 换手机号说说
         * extraCoachName : 张雅芝
         * extraCourseName : null
         * coachId : 1
         * courseId : null
         * memberId : 80
         * commentIds : 0
         * courseDegree : 5
         * coachDegree : 2
         * billName : null
         * title : 羽毛球(1课时)
         * id : 6
         */

        private List<ClientCommentListBean> clientCommentList;

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

        public String getSort() {
            return sort;
        }

        public void setSort(String sort) {
            this.sort = sort;
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

        public String getMajor() {
            return major;
        }

        public void setMajor(String major) {
            this.major = major;
        }

        public String getAvailabletimeid() {
            return availabletimeid;
        }

        public void setAvailabletimeid(String availabletimeid) {
            this.availabletimeid = availabletimeid;
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

        public String getIntroduce() {
            return introduce;
        }

        public void setIntroduce(String introduce) {
            this.introduce = introduce;
        }

        public String getAlbum() {
            return album;
        }

        public void setAlbum(String album) {
            this.album = album;
        }

        public String getServTime() {
            return servTime;
        }

        public void setServTime(String servTime) {
            this.servTime = servTime;
        }

        public String getServRange() {
            return servRange;
        }

        public void setServRange(String servRange) {
            this.servRange = servRange;
        }

        public String getAvatarimg() {
            return avatarimg;
        }

        public void setAvatarimg(String avatarimg) {
            this.avatarimg = avatarimg;
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

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public List<CourseListBean> getCourseList() {
            return courseList;
        }

        public void setCourseList(List<CourseListBean> courseList) {
            this.courseList = courseList;
        }

        public List<CourseCatagoryListBean> getCourseCatagoryList() {
            return courseCatagoryList;
        }

        public void setCourseCatagoryList(List<CourseCatagoryListBean> courseCatagoryList) {
            this.courseCatagoryList = courseCatagoryList;
        }

        public List<String> getServIdTimeList() {
            return servIdTimeList;
        }

        public void setServIdTimeList(List<String> servIdTimeList) {
            this.servIdTimeList = servIdTimeList;
        }

        public List<QualificationCoachListBean> getQualificationCoachList() {
            return qualificationCoachList;
        }

        public void setQualificationCoachList(List<QualificationCoachListBean> qualificationCoachList) {
            this.qualificationCoachList = qualificationCoachList;
        }

        public List<CoachExperienceList> getCoachExperienceList() {
            return coachExperienceList;
        }

        public void setCoachExperienceList(List<CoachExperienceList> coachExperienceList) {
            this.coachExperienceList = coachExperienceList;
        }

        public List<ClientCommentListBean> getClientCommentList() {
            return clientCommentList;
        }

        public void setClientCommentList(List<ClientCommentListBean> clientCommentList) {
            this.clientCommentList = clientCommentList;
        }

        public static class CourseListBean {
            private String name;
            private String value;
            private String location;
            private String comment;
            private String sort;
            private String status;
            private String billId;
            private String isHot;
            /**
             * name : null
             * endTime : null
             * startTime : null
             * isEnable : null
             * activityImage : null
             * id : 1
             */

            private ActivityBean activity;
            private String totalavailable;
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
            private String coach;
            private String latitude;
            private String longtitude;
            private String courseimage;
            private String timestart;
            private String timeend;
            private String price;
            private String coursetype;
            private String isPrivate;
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

            public String getSort() {
                return sort;
            }

            public void setSort(String sort) {
                this.sort = sort;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
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

            public String getCoach() {
                return coach;
            }

            public void setCoach(String coach) {
                this.coach = coach;
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
        }

        public static class CourseCatagoryListBean {
            private String type;
            private String days;
            private String courseUnit;
            private String price;
            private String id;

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getDays() {
                return days;
            }

            public void setDays(String days) {
                this.days = days;
            }

            public String getCourseUnit() {
                return courseUnit;
            }

            public void setCourseUnit(String courseUnit) {
                this.courseUnit = courseUnit;
            }

            public String getPrice() {
                return price;
            }

            public void setPrice(String price) {
                this.price = price;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }
        }

        public static class QualificationCoachListBean {
            private String name;
            private String value;
            private String type;
            private String attaches;
            /**
             * name : null
             * value : 0
             * sort : 0
             * weight : null
             * fees : null
             * telephone : null
             * isHot : null
             * major : null
             * courseList : []
             * courseCatagoryList : []
             * servIdTimeList : []
             * availabletimeid : null
             * qualificationCoachList : []
             * coachExperienceList : []
             * clientCommentList : []
             * age : null
             * height : null
             * cooperatetype : null
             * cooperatetime : null
             * contractimage : null
             * isapproval : null
             * introduce : null
             * album : null
             * servTime : null
             * servRange : null
             * avatarimg : null
             * scheduleid : null
             * setttletype : null
             * msVenueId : null
             * formal : null
             * gender : null
             * othermajor : null
             * venueNames : null
             * coachYear : null
             * venueAddress : null
             * id : 1
             */

            private CoachBean coach;
            private String id;

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

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getAttaches() {
                return attaches;
            }

            public void setAttaches(String attaches) {
                this.attaches = attaches;
            }

            public CoachBean getCoach() {
                return coach;
            }

            public void setCoach(CoachBean coach) {
                this.coach = coach;
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
                private String sort;
                private String weight;
                private String fees;
                private String telephone;
                private String isHot;
                private String major;
                private String availabletimeid;
                private String age;
                private String height;
                private String cooperatetype;
                private String cooperatetime;
                private String contractimage;
                private String isapproval;
                private String introduce;
                private String album;
                private String servTime;
                private String servRange;
                private String avatarimg;
                private String scheduleid;
                private String setttletype;
                private String msVenueId;
                private String formal;
                private String gender;
                private String othermajor;
                private String venueNames;
                private String coachYear;
                private String venueAddress;
                private String id;
                private List<?> courseList;
                private List<?> courseCatagoryList;
                private List<?> servIdTimeList;
                private List<?> qualificationCoachList;
                private List<?> coachExperienceList;
                private List<?> clientCommentList;

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

                public String getSort() {
                    return sort;
                }

                public void setSort(String sort) {
                    this.sort = sort;
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

                public String getMajor() {
                    return major;
                }

                public void setMajor(String major) {
                    this.major = major;
                }

                public String getAvailabletimeid() {
                    return availabletimeid;
                }

                public void setAvailabletimeid(String availabletimeid) {
                    this.availabletimeid = availabletimeid;
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

                public String getIntroduce() {
                    return introduce;
                }

                public void setIntroduce(String introduce) {
                    this.introduce = introduce;
                }

                public String getAlbum() {
                    return album;
                }

                public void setAlbum(String album) {
                    this.album = album;
                }

                public String getServTime() {
                    return servTime;
                }

                public void setServTime(String servTime) {
                    this.servTime = servTime;
                }

                public String getServRange() {
                    return servRange;
                }

                public void setServRange(String servRange) {
                    this.servRange = servRange;
                }

                public String getAvatarimg() {
                    return avatarimg;
                }

                public void setAvatarimg(String avatarimg) {
                    this.avatarimg = avatarimg;
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

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public List<?> getCourseList() {
                    return courseList;
                }

                public void setCourseList(List<?> courseList) {
                    this.courseList = courseList;
                }

                public List<?> getCourseCatagoryList() {
                    return courseCatagoryList;
                }

                public void setCourseCatagoryList(List<?> courseCatagoryList) {
                    this.courseCatagoryList = courseCatagoryList;
                }

                public List<?> getServIdTimeList() {
                    return servIdTimeList;
                }

                public void setServIdTimeList(List<?> servIdTimeList) {
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

                public List<?> getClientCommentList() {
                    return clientCommentList;
                }

                public void setClientCommentList(List<?> clientCommentList) {
                    this.clientCommentList = clientCommentList;
                }
            }
        }

        public static class ClientCommentListBean {
            private String type;
            private String content;
            private String billId;
            private String createTime;
            private String extraMemberName;
            private String extraCoachName;
            private String extraCourseName;
            private String coachId;
            private String courseId;
            private String memberId;
            private String commentIds;
            private String courseDegree;
            private String coachDegree;
            private String billName;
            private String title;
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

            public String getBillId() {
                return billId;
            }

            public void setBillId(String billId) {
                this.billId = billId;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public String getExtraMemberName() {
                return extraMemberName;
            }

            public void setExtraMemberName(String extraMemberName) {
                this.extraMemberName = extraMemberName;
            }

            public String getExtraCoachName() {
                return extraCoachName;
            }

            public void setExtraCoachName(String extraCoachName) {
                this.extraCoachName = extraCoachName;
            }

            public String getExtraCourseName() {
                return extraCourseName;
            }

            public void setExtraCourseName(String extraCourseName) {
                this.extraCourseName = extraCourseName;
            }

            public String getCoachId() {
                return coachId;
            }

            public void setCoachId(String coachId) {
                this.coachId = coachId;
            }

            public String getCourseId() {
                return courseId;
            }

            public void setCourseId(String courseId) {
                this.courseId = courseId;
            }

            public String getMemberId() {
                return memberId;
            }

            public void setMemberId(String memberId) {
                this.memberId = memberId;
            }

            public String getCommentIds() {
                return commentIds;
            }

            public void setCommentIds(String commentIds) {
                this.commentIds = commentIds;
            }

            public String getCourseDegree() {
                return courseDegree;
            }

            public void setCourseDegree(String courseDegree) {
                this.courseDegree = courseDegree;
            }

            public String getCoachDegree() {
                return coachDegree;
            }

            public void setCoachDegree(String coachDegree) {
                this.coachDegree = coachDegree;
            }

            public String getBillName() {
                return billName;
            }

            public void setBillName(String billName) {
                this.billName = billName;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
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
