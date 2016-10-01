package com.msport.clientmaster.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by like on 2016/8/13.
 */

public class CourseOrderEntity extends BaseEntity {


    /**
     * name : 课程详情测试测试
     * value : 0
     * location : 武昌雄楚大道立信生鲜大超市4楼
     * comment : 课程短介绍课程短介绍课程短介绍课程短介绍课程短介绍课程短介绍课程短介绍课程短介绍课程短介绍
     * sort : 0A
     * status : 0
     * activity : {"name":null,"endTime":null,"startTime":null,"isEnable":null,"activityImage":null,"id":"-1"}
     * coach : null
     * timeScheduleList : [{"name":"第一章测试","content":"无","endTime":"2016-08-04 16:13","startTime":"2016-08-04 14:13","status":1,"course":null,"memberId":null,"courseid":"29","createtime":null,"coachid":null,"isPush":0,"id":"48"},{"name":"第二章测试","content":"无","endTime":"2016-08-05 16:13","startTime":"2016-08-05 14:13","status":1,"course":null,"memberId":null,"courseid":"29","createtime":null,"coachid":null,"isPush":0,"id":"49"}]
     * totalavailable : 100
     * courseItemList : []
     * billId : 201608131100012856411773
     * isHot : null
     * venueName : 立信羽毛球馆
     * smsTemplateId : null
     * smsTemplate : {"name":null,"content":null,"courseId":null,"createTime":null,"id":"-1"}
     * qDate : null
     * distance : null
     * latitude :
     * longtitude :
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
     * id : 29
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean implements Serializable{
        private String name;
        private int value;
        private String location;
        private String comment;
        private int sort;
        private int status;
        /**
         * name : null
         * endTime : null
         * startTime : null
         * isEnable : null
         * activityImage : null
         * id : -1
         */

        private ActivityBean activity;
        private String coach;
        private String totalavailable;
        private String billId;
        private String isHot;
        private String venueName;
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
        private int lowestPrice;
        private int highestPrice;
        private String id;
        /**
         * name : 第一章测试
         * content : 无
         * endTime : 2016-08-04 16:13
         * startTime : 2016-08-04 14:13
         * status : 1
         * course : null
         * memberId : null
         * courseid : 29
         * createtime : null
         * coachid : null
         * isPush : 0
         * id : 48
         */

        private List<TimeScheduleListBean> timeScheduleList;
        private List<?> courseItemList;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
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

        public int getSort() {
            return sort;
        }

        public void setSort(int sort) {
            this.sort = sort;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public ActivityBean getActivity() {
            return activity;
        }

        public void setActivity(ActivityBean activity) {
            this.activity = activity;
        }

        public String getCoach() {
            return coach;
        }

        public void setCoach(String coach) {
            this.coach = coach;
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

        public int getLowestPrice() {
            return lowestPrice;
        }

        public void setLowestPrice(int lowestPrice) {
            this.lowestPrice = lowestPrice;
        }

        public int getHighestPrice() {
            return highestPrice;
        }

        public void setHighestPrice(int highestPrice) {
            this.highestPrice = highestPrice;
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

        public List<?> getCourseItemList() {
            return courseItemList;
        }

        public void setCourseItemList(List<?> courseItemList) {
            this.courseItemList = courseItemList;
        }

        public static class ActivityBean implements Serializable{
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

        public static class SmsTemplateBean implements Serializable{
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

        public static class TimeScheduleListBean implements Serializable{
            private String name;
            private String content;
            private String endTime;
            private String startTime;
            private int status;
            private String course;
            private String memberId;
            private String courseid;
            private String createtime;
            private String coachid;
            private int isPush;
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

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
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

            public String getCourseid() {
                return courseid;
            }

            public void setCourseid(String courseid) {
                this.courseid = courseid;
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

            public int getIsPush() {
                return isPush;
            }

            public void setIsPush(int isPush) {
                this.isPush = isPush;
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
