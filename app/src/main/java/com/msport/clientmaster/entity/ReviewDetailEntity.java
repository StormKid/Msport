package com.msport.clientmaster.entity;

/**
 * Created by like on 2016/8/18.
 */

public class ReviewDetailEntity extends BaseEntity {

    /**
     * type : 1
     * content : 9089989
     * commentIds : 1,0
     * courseDegree : 4
     * coachDegree : 4
     * billName : 瑜伽课程--汉街运动
     * title : 瑜伽课程--汉街运动
     * courseId : 29
     * coachId : 10
     * memberId : 80
     * extraMemberName : 换手机号说说
     * extraCoachName : 李教练
     * extraCourseName : 课程详情测试测试
     * extraMemberImage : userfiles/80/images/admin/mobile/2016/7/1468219038750.png
     * billId : 201607041517321467616652281101
     * createTime : null
     * id : 14
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private String type;
        private String content;
        private String commentIds;
        private String courseDegree;
        private String coachDegree;
        private String billName;
        private String title;
        private String courseId;
        private String coachId;
        private String memberId;
        private String extraMemberName;
        private String extraCoachName;
        private String extraCourseName;
        private String extraMemberImage;
        private String billId;
        private String createTime;
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

        public String getCourseId() {
            return courseId;
        }

        public void setCourseId(String courseId) {
            this.courseId = courseId;
        }

        public String getCoachId() {
            return coachId;
        }

        public void setCoachId(String coachId) {
            this.coachId = coachId;
        }

        public String getMemberId() {
            return memberId;
        }

        public void setMemberId(String memberId) {
            this.memberId = memberId;
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

        public String getExtraMemberImage() {
            return extraMemberImage;
        }

        public void setExtraMemberImage(String extraMemberImage) {
            this.extraMemberImage = extraMemberImage;
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

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }
}
