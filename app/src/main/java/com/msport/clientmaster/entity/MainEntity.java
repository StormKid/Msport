package com.msport.clientmaster.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by like on 2016/7/28.
 */

public class MainEntity extends BaseEntity {


    /**
     * courseType : {"count":0,"data":[{"value":"0","description":"ms_course","orderBy":null,"label":"游泳","id":"ca3f7b9648124135be24ec63907a4387"},{"value":"1","description":"ms_course","orderBy":null,"label":"羽毛球","id":"323f4ed0ed474580b325843f93dd9057"},{"value":"2","description":"ms_course","orderBy":null,"label":"瑜伽","id":"9f4786b815684186bdfed6705f426923"}],"status":"success","code":0}
     * activity : [{"name":"29.9","endTime":1469846460000,"startTime":1469587260000,"isEnable":1,"id":"2"}]
     * course : [{"name":"测试非私教课程","value":0,"location":null,"comment":"没备注","activity":{"name":null,"endTime":null,"startTime":null,"isEnable":null,"id":"-1"},"status":0,"sort":0,"smsTemplateId":null,"smsTemplate":{"name":null,"content":null,"courseId":null,"createTime":null,"id":"-1"},"qDate":null,"distance":null,"coach":null,"latitude":null,"Stringtitude":null,"courseimage":"|/msport-admin/userfiles/c07bd4b956034129b09d04ee7c095822/files/admin/course/2016/07/lALOYiGV_M0B8c0CAA_512_497.png","timestart":"2016-07-30","timeend":"2016-07-31","price":"1","coursetype":"0","isPrivate":null,"courseItemList":[],"billId":null,"isHot":null,"timeScheduleList":[{"name":"测试","content":"测试","endTime":"2016-07-30 14:50","startTime":"2016-07-30 14:49","status":1,"course":null,"courseid":"25","coachid":null,"createtime":null,"id":"42"}],"totalavailable":"12","id":"25"}]
     * coach : [{"name":"李教练","value":0,"major":"50","courseList":[],"sort":0,"courseCatagoryList":[],"servIdTimeList":["2","1"],"availabletimeid":null,"qualificationCoachList":[],"fees":50,"telephone":"1231312313","isHot":1,"weight":80,"cooperatetype":"2","cooperatetime":1462949820000,"contractimage":"","isapproval":"1","age":null,"height":170,"Stringroduce":"","album":"","servTime":",2,1,","servRange":",0,1,","avatarimg":"","scheduleid":null,"setttletype":"1","msVenueId":null,"formal":"4","gender":"1","othermajor":"","venueNames":"洪山广场,汉街","id":"10"}]
     * invitationActivity : [{"name":"打文海","value":null,"type":0,"sort":null,"payMode":null,"customName":"李可","billId":"201607261701418918345205","inviteAccount":"awdawd","customAddress":"小操场","inviteType":null,"avatarList":null,"timeStart":"2016-07-30 16:59:00.0","timeEnd":"2016-07-30 20:59:00.0","fees":"0.01","initiator":"123","telephone":"18574965284","activiNotice":"-1","activiComment":"一起打","isHot":1,"createTime":null,"activiDateTime":null,"currentParticipants":"1","minParticipants":"4","extLstAttendMember":[],"totalParticipants":"4","id":"56"},{"name":"打文海","value":null,"type":0,"sort":null,"payMode":null,"customName":"李可","billId":"201607261702278932178673","inviteAccount":"awdawd","customAddress":"小操场","inviteType":null,"avatarList":null,"timeStart":"2016-07-30 16:59:00.0","timeEnd":"2016-07-30 20:59:00.0","fees":"0.01","initiator":"123","telephone":"18574965284","activiNotice":"-1","activiComment":"一起打","isHot":1,"createTime":null,"activiDateTime":null,"currentParticipants":"0","minParticipants":"4","extLstAttendMember":[],"totalParticipants":"4","id":"57"}]
     * announcement : [{"content":"我是测试公告信息","validTimeStart":1469690967000,"createTime":1469690974000,"validTimeEnd":1469950168000,"isTop":1,"isEnable":1,"nowTime":null,"title":"测试公告信息","id":"2"}]
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean implements Serializable {
        /**
         * count : 0
         * data : [{"value":"0","description":"ms_course","orderBy":null,"label":"游泳","id":"ca3f7b9648124135be24ec63907a4387"},{"value":"1","description":"ms_course","orderBy":null,"label":"羽毛球","id":"323f4ed0ed474580b325843f93dd9057"},{"value":"2","description":"ms_course","orderBy":null,"label":"瑜伽","id":"9f4786b815684186bdfed6705f426923"}]
         * status : success
         * code : 0
         */

        private CourseTypeBean courseType;
        /**
         * name : 29.9
         * endTime : 1469846460000
         * startTime : 1469587260000
         * isEnable : 1
         * id : 2
         */

        private List<BeanActivity> activity;
        /**
         * name : 测试非私教课程
         * value : 0
         * location : null
         * comment : 没备注
         * activity : {"name":null,"endTime":null,"startTime":null,"isEnable":null,"id":"-1"}
         * status : 0
         * sort : 0
         * smsTemplateId : null
         * smsTemplate : {"name":null,"content":null,"courseId":null,"createTime":null,"id":"-1"}
         * qDate : null
         * distance : null
         * coach : null
         * latitude : null
         * Stringtitude : null
         * courseimage : |/msport-admin/userfiles/c07bd4b956034129b09d04ee7c095822/files/admin/course/2016/07/lALOYiGV_M0B8c0CAA_512_497.png
         * timestart : 2016-07-30
         * timeend : 2016-07-31
         * price : 1
         * coursetype : 0
         * isPrivate : null
         * courseItemList : []
         * billId : null
         * isHot : null
         * timeScheduleList : [{"name":"测试","content":"测试","endTime":"2016-07-30 14:50","startTime":"2016-07-30 14:49","status":1,"course":null,"courseid":"25","coachid":null,"createtime":null,"id":"42"}]
         * totalavailable : 12
         * id : 25
         */

        private List<CourseBean> course;
        /**
         * name : 李教练
         * value : 0
         * major : 50
         * courseList : []
         * sort : 0
         * courseCatagoryList : []
         * servIdTimeList : ["2","1"]
         * availabletimeid : null
         * qualificationCoachList : []
         * fees : 50
         * telephone : 1231312313
         * isHot : 1
         * weight : 80
         * cooperatetype : 2
         * cooperatetime : 1462949820000
         * contractimage :
         * isapproval : 1
         * age : null
         * height : 170
         * Stringroduce :
         * album :
         * servTime : ,2,1,
         * servRange : ,0,1,
         * avatarimg :
         * scheduleid : null
         * setttletype : 1
         * msVenueId : null
         * formal : 4
         * gender : 1
         * othermajor :
         * venueNames : 洪山广场,汉街
         * id : 10
         */

        private List<CoachBean> coach;
        /**
         * name : 打文海
         * value : null
         * type : 0
         * sort : null
         * payMode : null
         * customName : 李可
         * billId : 201607261701418918345205
         * inviteAccount : awdawd
         * customAddress : 小操场
         * inviteType : null
         * avatarList : null
         * timeStart : 2016-07-30 16:59:00.0
         * timeEnd : 2016-07-30 20:59:00.0
         * fees : 0.01
         * initiator : 123
         * telephone : 18574965284
         * activiNotice : -1
         * activiComment : 一起打
         * isHot : 1
         * createTime : null
         * activiDateTime : null
         * currentParticipants : 1
         * minParticipants : 4
         * extLstAttendMember : []
         * totalParticipants : 4
         * id : 56
         */

        private List<InvitationActivityBean> invitationActivity;
        /**
         * content : 我是测试公告信息
         * validTimeStart : 1469690967000
         * createTime : 1469690974000
         * validTimeEnd : 1469950168000
         * isTop : 1
         * isEnable : 1
         * nowTime : null
         * title : 测试公告信息
         * id : 2
         */

        private List<AnnouncementBean> announcement;

        public CourseTypeBean getCourseType() {
            return courseType;
        }

        public void setCourseType(CourseTypeBean courseType) {
            this.courseType = courseType;
        }

        public List<BeanActivity> getActivity() {
            return activity;
        }

        public void setActivity(List<BeanActivity> activity) {
            this.activity = activity;
        }

        public List<CourseBean> getCourse() {
            return course;
        }

        public void setCourse(List<CourseBean> course) {
            this.course = course;
        }

        public List<CoachBean> getCoach() {
            return coach;
        }

        public void setCoach(List<CoachBean> coach) {
            this.coach = coach;
        }

        public List<InvitationActivityBean> getInvitationActivity() {
            return invitationActivity;
        }

        public void setInvitationActivity(List<InvitationActivityBean> invitationActivity) {
            this.invitationActivity = invitationActivity;
        }

        public List<AnnouncementBean> getAnnouncement() {
            return announcement;
        }

        public void setAnnouncement(List<AnnouncementBean> announcement) {
            this.announcement = announcement;
        }

        public static class CourseTypeBean {
            private String count;
            private String status;
            private String code;
            /**
             * value : 0
             * description : ms_course
             * orderBy : null
             * label : 游泳
             * id : ca3f7b9648124135be24ec63907a4387
             */

            private List<CourseValueBean> data;

            public String getCount() {
                return count;
            }

            public void setCount(String count) {
                this.count = count;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getCode() {
                return code;
            }

            public void setCode(String code) {
                this.code = code;
            }

            public List<CourseValueBean> getData() {
                return data;
            }

            public void setData(List<CourseValueBean> data) {
                this.data = data;
            }

            public static class CourseValueBean {
                private String value;
                private String description;
                private String orderBy;
                private String label;
                private String id;

                public String getValue() {
                    return value;
                }

                public void setValue(String value) {
                    this.value = value;
                }

                public String getDescription() {
                    return description;
                }

                public void setDescription(String description) {
                    this.description = description;
                }

                public String getOrderBy() {
                    return orderBy;
                }

                public void setOrderBy(String orderBy) {
                    this.orderBy = orderBy;
                }

                public String getLabel() {
                    return label;
                }

                public void setLabel(String label) {
                    this.label = label;
                }

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }
            }
        }

        public static class CourseBean implements Serializable {
            private String name;
            private String value;
            private String location;
            private String comment;
            /**
             * name : null
             * endTime : null
             * startTime : null
             * isEnable : null
             * id : -1
             */

            private ActivityBean activity;
            private String status;
            private String sort;
            private String smsTemplateId;
            /**
             * name : null
             * content : null
             * courseId : null
             * createTime : null
             * id : -1
             */

            private SmsTemplateBean smsTemplate;
            private String qDate;
            private String distance;
            private String coach;
            private String latitude;
            private String Stringtitude;
            private String courseimage;
            private String timestart;
            private String timeend;
            private String price;
            private String coursetype;
            private String isPrivate;
            private String billId;
            private String isHot;
            private String totalavailable;
            private String id;
            private List<?> courseItemList;
            /**
             * name : 测试
             * content : 测试
             * endTime : 2016-07-30 14:50
             * startTime : 2016-07-30 14:49
             * status : 1
             * course : null
             * courseid : 25
             * coachid : null
             * createtime : null
             * id : 42
             */

            private List<TimeScheduleListBean> timeScheduleList;

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

            public ActivityBean getActivity() {
                return activity;
            }

            public void setActivity(ActivityBean activity) {
                this.activity = activity;
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

            public String getIsPrivate() {
                return isPrivate;
            }

            public void setIsPrivate(String isPrivate) {
                this.isPrivate = isPrivate;
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

            public String getTotalavailable() {
                return totalavailable;
            }

            public void setTotalavailable(String totalavailable) {
                this.totalavailable = totalavailable;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public List<?> getCourseItemList() {
                return courseItemList;
            }

            public void setCourseItemList(List<?> courseItemList) {
                this.courseItemList = courseItemList;
            }

            public List<TimeScheduleListBean> getTimeScheduleList() {
                return timeScheduleList;
            }

            public void setTimeScheduleList(List<TimeScheduleListBean> timeScheduleList) {
                this.timeScheduleList = timeScheduleList;
            }

            public static class ActivityBean {
                private String name;
                private String endTime;
                private String startTime;
                private String isEnable;
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
                private String courseId;
                private String createTime;
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
                private String status;
                private String course;
                private String courseid;
                private String coachid;
                private String createtime;
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

                public String getStatus() {
                    return status;
                }

                public void setStatus(String status) {
                    this.status = status;
                }

                public String getCourse() {
                    return course;
                }

                public void setCourse(String course) {
                    this.course = course;
                }

                public String getCourseid() {
                    return courseid;
                }

                public void setCourseid(String courseid) {
                    this.courseid = courseid;
                }

                public String getCoachid() {
                    return coachid;
                }

                public void setCoachid(String coachid) {
                    this.coachid = coachid;
                }

                public String getCreatetime() {
                    return createtime;
                }

                public void setCreatetime(String createtime) {
                    this.createtime = createtime;
                }

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }
            }
        }

        public static class CoachBean implements Serializable {
            private String name;
            private String value;
            private String major;
            private String sort;
            private String availabletimeid;
            private String fees;
            private String telephone;
            private String isHot;
            private String weight;
            private String cooperatetype;
            private String cooperatetime;
            private String contractimage;
            private String isapproval;
            private String age;
            private String height;
            private String Stringroduce;
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
            private String id;
            private List<?> courseList;
            private List<?> courseCatagoryList;
            private List<String> servIdTimeList;
            private List<?> qualificationCoachList;
            private String introduce;

            public String getIntroduce() {
                return introduce;
            }

            public void setIntroduce(String introduce) {
                this.introduce = introduce;
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

            public String getMajor() {
                return major;
            }

            public void setMajor(String major) {
                this.major = major;
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

            public String getWeight() {
                return weight;
            }

            public void setWeight(String weight) {
                this.weight = weight;
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

            public String getStringroduce() {
                return Stringroduce;
            }

            public void setStringroduce(String Stringroduce) {
                this.Stringroduce = Stringroduce;
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
        }

        public static class InvitationActivityBean implements Serializable {
            private String name;
            private String value;
            private String type;
            private String sort;
            private String payMode;
            private String customName;
            private String billId;
            private String inviteAccount;
            private String customAddress;
            private String inviteType;
            private String avatarList;
            private String timeStart;
            private String timeEnd;
            private String fees;
            private String initiator;
            private String telephone;
            private String activiNotice;
            private String activiComment;
            private String isHot;
            private String createTime;
            private String activiDateTime;
            private String currentParticipants;
            private String minParticipants;
            private String totalParticipants;
            private String id;
            private List<?> extLstAttendMember;

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

            public String getSort() {
                return sort;
            }

            public void setSort(String sort) {
                this.sort = sort;
            }

            public String getPayMode() {
                return payMode;
            }

            public void setPayMode(String payMode) {
                this.payMode = payMode;
            }

            public String getCustomName() {
                return customName;
            }

            public void setCustomName(String customName) {
                this.customName = customName;
            }

            public String getBillId() {
                return billId;
            }

            public void setBillId(String billId) {
                this.billId = billId;
            }

            public String getInviteAccount() {
                return inviteAccount;
            }

            public void setInviteAccount(String inviteAccount) {
                this.inviteAccount = inviteAccount;
            }

            public String getCustomAddress() {
                return customAddress;
            }

            public void setCustomAddress(String customAddress) {
                this.customAddress = customAddress;
            }

            public String getInviteType() {
                return inviteType;
            }

            public void setInviteType(String inviteType) {
                this.inviteType = inviteType;
            }

            public String getAvatarList() {
                return avatarList;
            }

            public void setAvatarList(String avatarList) {
                this.avatarList = avatarList;
            }

            public String getTimeStart() {
                return timeStart;
            }

            public void setTimeStart(String timeStart) {
                this.timeStart = timeStart;
            }

            public String getTimeEnd() {
                return timeEnd;
            }

            public void setTimeEnd(String timeEnd) {
                this.timeEnd = timeEnd;
            }

            public String getFees() {
                return fees;
            }

            public void setFees(String fees) {
                this.fees = fees;
            }

            public String getInitiator() {
                return initiator;
            }

            public void setInitiator(String initiator) {
                this.initiator = initiator;
            }

            public String getTelephone() {
                return telephone;
            }

            public void setTelephone(String telephone) {
                this.telephone = telephone;
            }

            public String getActiviNotice() {
                return activiNotice;
            }

            public void setActiviNotice(String activiNotice) {
                this.activiNotice = activiNotice;
            }

            public String getActiviComment() {
                return activiComment;
            }

            public void setActiviComment(String activiComment) {
                this.activiComment = activiComment;
            }

            public String getIsHot() {
                return isHot;
            }

            public void setIsHot(String isHot) {
                this.isHot = isHot;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public String getActiviDateTime() {
                return activiDateTime;
            }

            public void setActiviDateTime(String activiDateTime) {
                this.activiDateTime = activiDateTime;
            }

            public String getCurrentParticipants() {
                return currentParticipants;
            }

            public void setCurrentParticipants(String currentParticipants) {
                this.currentParticipants = currentParticipants;
            }

            public String getMinParticipants() {
                return minParticipants;
            }

            public void setMinParticipants(String minParticipants) {
                this.minParticipants = minParticipants;
            }

            public String getTotalParticipants() {
                return totalParticipants;
            }

            public void setTotalParticipants(String totalParticipants) {
                this.totalParticipants = totalParticipants;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public List<?> getExtLstAttendMember() {
                return extLstAttendMember;
            }

            public void setExtLstAttendMember(List<?> extLstAttendMember) {
                this.extLstAttendMember = extLstAttendMember;
            }
        }

        public static class AnnouncementBean {
            private String content;
            private String validTimeStart;
            private String createTime;
            private String validTimeEnd;
            private String isTop;
            private String isEnable;
            private String nowTime;
            private String title;
            private String id;

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getValidTimeStart() {
                return validTimeStart;
            }

            public void setValidTimeStart(String validTimeStart) {
                this.validTimeStart = validTimeStart;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public String getValidTimeEnd() {
                return validTimeEnd;
            }

            public void setValidTimeEnd(String validTimeEnd) {
                this.validTimeEnd = validTimeEnd;
            }

            public String getIsTop() {
                return isTop;
            }

            public void setIsTop(String isTop) {
                this.isTop = isTop;
            }

            public String getIsEnable() {
                return isEnable;
            }

            public void setIsEnable(String isEnable) {
                this.isEnable = isEnable;
            }

            public String getNowTime() {
                return nowTime;
            }

            public void setNowTime(String nowTime) {
                this.nowTime = nowTime;
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


    public static class BeanActivity implements Serializable {

        private String name;
        private String isEnable;
        private String activityImage;
        private String remark;
        private String endTime;
        private String startTime;
        private String id;

        public String getActivityImage() {
            return activityImage;
        }

        public void setActivityImage(String activityImage) {
            this.activityImage = activityImage;
        }

        public String getEndTime() {
            return endTime;
        }

        public void setEndTime(String endTime) {
            this.endTime = endTime;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getIsEnable() {
            return isEnable;
        }

        public void setIsEnable(String isEnable) {
            this.isEnable = isEnable;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public String getStartTime() {
            return startTime;
        }

        public void setStartTime(String startTime) {
            this.startTime = startTime;
        }
    }


}
