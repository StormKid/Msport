package com.msport.clientmaster.entity;

import java.util.List;

/**
 * Created by like on 2016/8/22.
 */

public class MenPiaoEntity extends  BaseEntity {


    /**
     * address : 湖北省武汉市
     * name : 方案第三
     * value : 0
     * number : 2
     * extraRemainNum : null
     * currentSaleNum : null
     * validStartDate : 1469266261000
     * validEndDate : 1469871063000
     * source : 0
     * sort : 0
     * amount : 50
     * id : 29
     */

    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {


        /**
         * address : 武汉市蔡甸区武汉体育中心
         * name : 111
         * value : 0
         * type : 0
         * sort : 0
         * major : 1
         * cooperatetime : null
         * distance : null
         * latitude : 30.505771
         * longtitude : 114.17823
         * servRange : 0,1
         * lowestPrice : 0
         * highestPrice : 0
         * qDateTime : null
         * city : 武汉市
         * district : 蔡甸区
         * street : 
         * qualificid : null
         * cooperatetype : null
         * ownername : null
         * businesshoursstart : null
         * gateimage : 
         * venuearea : 1
         * settletype : null
         * isapproval : null
         * featurelist : 1
         * titleImage : 
         * courseList : [{"name":"瑜伽课程--汉街运动","value":0,"location":null,"comment":"没有备注","timeScheduleList":[],"sort":0,"status":0,"orgId":"b4e7c365113644b3935984d459cfc140","smsTemplateId":null,"smsTemplate":null,"qDate":null,"distance":null,"latitude":null,"longtitude":null,"courseimage":"","timestart":"14:30","timeend":"15:00","price":"0.01","coursetype":"1","isPrivate":0,"Stringroduce":"没有介绍","totalMember":1,"coachName":null,"album":"","servRange":",0,","subCourseType":"19","lowestPrice":0,"highestPrice":0,"officePhone":null,"totalavailable":"600","courseItemList":[],"coach":null,"activity":null,"billId":"111","isHot":0,"venueName":null,"id":"6"},{"name":"游泳课程","value":0,"location":null,"comment":"12","timeScheduleList":[],"sort":0,"status":0,"orgId":"b4e7c365113644b3935984d459cfc140","smsTemplateId":null,"smsTemplate":null,"qDate":null,"distance":null,"latitude":null,"longtitude":null,"courseimage":"","timestart":"14:00","timeend":"14:30","price":"0.01","coursetype":"1","isPrivate":0,"Stringroduce":"12","totalMember":2,"coachName":null,"album":"","servRange":",null,","subCourseType":"7","lowestPrice":0,"highestPrice":0,"officePhone":null,"totalavailable":"50","courseItemList":[],"coach":null,"activity":null,"billId":null,"isHot":1,"venueName":null,"id":"7"}]
         * fees : 0.01
         * telephone : 444
         * businesshoursend : null
         * isaccepttrainning : 
         * id : 1
         */

        private String address;
        private String name;
        private String value;
        private String type;
        private String sort;
        private String major;
        private String cooperatetime;
        private String distance;
        private String latitude;
        private String longtitude;
        private String servRange;
        private String lowestPrice;
        private String highestPrice;
        private String qDateTime;
        private String city;
        private String district;
        private String street;
        private String qualificid;
        private String cooperatetype;
        private String ownername;
        private String businesshoursstart;
        private String gateimage;
        private String venuearea;
        private String settletype;
        private String isapproval;
        private String featurelist;
        private String titleImage;
        private String fees;
        private String telephone;
        private String businesshoursend;
        private String isaccepttrainning;
        private String id;
        /**
         * name : 瑜伽课程--汉街运动
         * value : 0
         * location : null
         * comment : 没有备注
         * timeScheduleList : []
         * sort : 0
         * status : 0
         * orgId : b4e7c365113644b3935984d459cfc140
         * smsTemplateId : null
         * smsTemplate : null
         * qDate : null
         * distance : null
         * latitude : null
         * longtitude : null
         * courseimage : 
         * timestart : 14:30
         * timeend : 15:00
         * price : 0.01
         * coursetype : 1
         * isPrivate : 0
         * Stringroduce : 没有介绍
         * totalMember : 1
         * coachName : null
         * album : 
         * servRange : ,0,
         * subCourseType : 19
         * lowestPrice : 0
         * highestPrice : 0
         * officePhone : null
         * totalavailable : 600
         * courseItemList : []
         * coach : null
         * activity : null
         * billId : 111
         * isHot : 0
         * venueName : null
         * id : 6
         */

        private List<CourseListBean> courseList;

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

        public String getMajor() {
            return major;
        }

        public void setMajor(String major) {
            this.major = major;
        }

        public String getCooperatetime() {
            return cooperatetime;
        }

        public void setCooperatetime(String cooperatetime) {
            this.cooperatetime = cooperatetime;
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

        public String getQDateTime() {
            return qDateTime;
        }

        public void setQDateTime(String qDateTime) {
            this.qDateTime = qDateTime;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getDistrict() {
            return district;
        }

        public void setDistrict(String district) {
            this.district = district;
        }

        public String getStreet() {
            return street;
        }

        public void setStreet(String street) {
            this.street = street;
        }

        public String getQualificid() {
            return qualificid;
        }

        public void setQualificid(String qualificid) {
            this.qualificid = qualificid;
        }

        public String getCooperatetype() {
            return cooperatetype;
        }

        public void setCooperatetype(String cooperatetype) {
            this.cooperatetype = cooperatetype;
        }

        public String getOwnername() {
            return ownername;
        }

        public void setOwnername(String ownername) {
            this.ownername = ownername;
        }

        public String getBusinesshoursstart() {
            return businesshoursstart;
        }

        public void setBusinesshoursstart(String businesshoursstart) {
            this.businesshoursstart = businesshoursstart;
        }

        public String getGateimage() {
            return gateimage;
        }

        public void setGateimage(String gateimage) {
            this.gateimage = gateimage;
        }

        public String getVenuearea() {
            return venuearea;
        }

        public void setVenuearea(String venuearea) {
            this.venuearea = venuearea;
        }

        public String getSettletype() {
            return settletype;
        }

        public void setSettletype(String settletype) {
            this.settletype = settletype;
        }

        public String getIsapproval() {
            return isapproval;
        }

        public void setIsapproval(String isapproval) {
            this.isapproval = isapproval;
        }

        public String getFeaturelist() {
            return featurelist;
        }

        public void setFeaturelist(String featurelist) {
            this.featurelist = featurelist;
        }

        public String getTitleImage() {
            return titleImage;
        }

        public void setTitleImage(String titleImage) {
            this.titleImage = titleImage;
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

        public String getBusinesshoursend() {
            return businesshoursend;
        }

        public void setBusinesshoursend(String businesshoursend) {
            this.businesshoursend = businesshoursend;
        }

        public String getIsaccepttrainning() {
            return isaccepttrainning;
        }

        public void setIsaccepttrainning(String isaccepttrainning) {
            this.isaccepttrainning = isaccepttrainning;
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

        public static class CourseListBean {
            private String name;
            private String value;
            private String location;
            private String comment;
            private String sort;
            private String status;
            private String orgId;
            private String smsTemplateId;
            private String smsTemplate;
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
            private String Stringroduce;
            private String totalMember;
            private String coachName;
            private String album;
            private String servRange;
            private String subCourseType;
            private String lowestPrice;
            private String highestPrice;
            private String officePhone;
            private String totalavailable;
            private String coach;
            private String activity;
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

            public String getSmsTemplate() {
                return smsTemplate;
            }

            public void setSmsTemplate(String smsTemplate) {
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

            public String getStringroduce() {
                return Stringroduce;
            }

            public void setStringroduce(String Stringroduce) {
                this.Stringroduce = Stringroduce;
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

            public String getTotalavailable() {
                return totalavailable;
            }

            public void setTotalavailable(String totalavailable) {
                this.totalavailable = totalavailable;
            }

            public String getCoach() {
                return coach;
            }

            public void setCoach(String coach) {
                this.coach = coach;
            }

            public String getActivity() {
                return activity;
            }

            public void setActivity(String activity) {
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
        }
    }
}
