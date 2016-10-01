package com.msport.clientmaster.entity;

import java.io.Serializable;

/**
 * Created by like on 2016/8/23.
 */

public class MenPiaoDetailEntity extends  BaseEntity {

    /**
     * address : null
     * name : 822测试
     * value : 0
     * number : null
     * comment : 没有备注
     * source : null
     * validEndDate : null
     * unit : 次卡
     * marketPrice : 123.00
     * venueId : 26
     * image : |/msport-admin/userfiles/c07bd4b956034129b09d04ee7c095822/files/admin/venueTicket/2016/08/lALOYiGV_M0B8c0CAA_512_497.png
     * extraRemainNum : null
     * currentSaleNum : null
     * validStartDate : null
     * sort : 0
     * amount : 12.00
     * id : 38
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean implements Serializable{
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
