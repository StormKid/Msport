package com.msport.clientmaster.entity;

import java.util.List;

/**
 * Created by like on 2016/8/23.
 */

public class LocationDetailEntity extends BaseEntity {

    /**
     * address : 测试地址
     * name : 测试场馆
     * value : 0
     * type : 0
     * major : 6
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
     * courseList : []
     * ticketList : [{"address":"111","name":"ceshi1","value":0,"number":111,"comment":"没有备注","source":1,"validEndDate":1472110936000,"unit":"月卡","marketPrice":"13.00","venueId":"26","image":null,"extraRemainNum":null,"currentSaleNum":null,"validStartDate":1470642134000,"sort":0,"amount":"11.00","id":"37"},{"address":null,"name":"822测试","value":0,"number":null,"comment":"没有备注","source":null,"validEndDate":1473475546000,"unit":"次卡","marketPrice":"123.00","venueId":"26","image":null,"extraRemainNum":null,"currentSaleNum":null,"validStartDate":1471920344000,"sort":0,"amount":"12.00","id":"38"}]
     * sort : 0
     * fees : 55
     * telephone : 223424
     * distance : null
     * latitude : 
     * Stringtitude : 
     * servRange : null
     * lowestPrice : 0
     * highestPrice : 0
     * qDateTime : null
     * businesshoursstart : 1471918275000
     * businesshoursend : 1471965079000
     * isaccepttrainning : 
     * id : 26
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private String address;
        private String name;
        private String value;
        private String type;
        private String major;
        private String city;
        private String district;
        private String street;
        private String qualificid;
        private String cooperatetype;
        private String ownername;
        private String cooperatetime;
        private String gateimage;
        private String venuearea;
        private String settletype;
        private String isapproval;
        private String featurelist;
        private String titleImage;
        private String sort;
        private String fees;
        private String telephone;
        private String distance;
        private String latitude;
        private String Stringtitude;
        private String servRange;
        private String lowestPrice;
        private String highestPrice;
        private String qDateTime;
        private String businesshoursstart;
        private String businesshoursend;
        private String isaccepttrainning;
        private String id;
        private List<?> courseList;
        /**
         * address : 111
         * name : ceshi1
         * value : 0
         * number : 111
         * comment : 没有备注
         * source : 1
         * validEndDate : 1472110936000
         * unit : 月卡
         * marketPrice : 13.00
         * venueId : 26
         * image : null
         * extraRemainNum : null
         * currentSaleNum : null
         * validStartDate : 1470642134000
         * sort : 0
         * amount : 11.00
         * id : 37
         */

        private List<TicketListBean> ticketList;

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

        public String getMajor() {
            return major;
        }

        public void setMajor(String major) {
            this.major = major;
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

        public String getCooperatetime() {
            return cooperatetime;
        }

        public void setCooperatetime(String cooperatetime) {
            this.cooperatetime = cooperatetime;
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

        public String getSort() {
            return sort;
        }

        public void setSort(String sort) {
            this.sort = sort;
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
            return Stringtitude;
        }

        public void setLongtitude(String Stringtitude) {
            this.Stringtitude = Stringtitude;
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

        public String getBusinesshoursstart() {
            return businesshoursstart;
        }

        public void setBusinesshoursstart(String businesshoursstart) {
            this.businesshoursstart = businesshoursstart;
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

        public List<?> getCourseList() {
            return courseList;
        }

        public void setCourseList(List<?> courseList) {
            this.courseList = courseList;
        }

        public List<TicketListBean> getTicketList() {
            return ticketList;
        }

        public void setTicketList(List<TicketListBean> ticketList) {
            this.ticketList = ticketList;
        }

        public static class TicketListBean {
            private String address;
            private String name;
            private String value;
            private String number;
            private String comment;
            private String source;
            private String validEndDate;
            private String unit;
            private String marketPrice;
            private String venueId;
            private String image;
            private String extraRemainNum;
            private String currentSaleNum;
            private String validStartDate;
            private String sort;
            private String amount;
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

            public String getSort() {
                return sort;
            }

            public void setSort(String sort) {
                this.sort = sort;
            }

            public String getAmount() {
                return amount;
            }

            public void setAmount(String amount) {
                this.amount = amount;
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
