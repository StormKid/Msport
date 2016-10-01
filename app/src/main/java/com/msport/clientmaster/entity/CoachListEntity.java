package com.msport.clientmaster.entity;

import java.util.List;

/**
 * Created by like on 2016/8/8.
 */

public class CoachListEntity extends BaseEntity {


    /**
     * name : 张雅芝
     * value : 0
     * cooperatetype : 2
     * cooperatetime : 1459911720000
     * contractimage : 
     * isapproval : 1
     * major : 0
     * album : |/msport-admin/userfiles/1/files/admin/coach/2016/05/timg.jpeg|/msport-admin/userfiles/1/files/admin/course/2016/04/bd_logo1.png
     * courseCatagoryList : [{"type":"1","courseUnit":"10","price":"1000","days":"60","id":"1"},{"type":"0","courseUnit":"1","price":"0.01","days":"60","id":"2"}]
     * servIdTimeList : ["null"]
     * availabletimeid : 3
     * qualificationCoachList : []
     * coachExperienceList : []
     * age : 18
     * height : 180
     * introduce : 李教练是个好人
     * sort : 0
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
     * lowestPrice : 0
     * highestPrice : 0
     * fees : 20
     * telephone : 4
     * isHot : 1
     * courseList : []
     * weight : 90
     * id : 1
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
        private String value;
        private String cooperatetype;
        private String cooperatetime;
        private String contractimage;
        private String isapproval;
        private String major;
        private String album;
        private String availabletimeid;
        private String age;
        private String height;
        private String introduce;
        private String sort;
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
        private String lowestPrice;
        private String highestPrice;
        private String fees;
        private String telephone;
        private String isHot;
        private String weight;
        private String id;
        /**
         * type : 1
         * courseUnit : 10
         * price : 1000
         * days : 60
         * id : 1
         */

        private List<CourseCatagoryListBean> courseCatagoryList;
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

        public String getMajor() {
            return major;
        }

        public void setMajor(String major) {
            this.major = major;
        }

        public String getAlbum() {
            return album;
        }

        public void setAlbum(String album) {
            this.album = album;
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

        public String getIntroduce() {
            return introduce;
        }

        public void setIntroduce(String introduce) {
            this.introduce = introduce;
        }

        public String getSort() {
            return sort;
        }

        public void setSort(String sort) {
            this.sort = sort;
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

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
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

        public static class CourseCatagoryListBean {
            private String type;
            private String courseUnit;
            private String price;
            private String days;
            private String id;

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
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

            public String getDays() {
                return days;
            }

            public void setDays(String days) {
                this.days = days;
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
