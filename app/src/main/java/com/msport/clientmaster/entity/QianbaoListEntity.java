package com.msport.clientmaster.entity;

import java.util.List;

/**
 * Created by like on 2016/8/16.
 */

public class QianbaoListEntity extends BaseEntity {

    /**
     * type : 1
     * memberId : 80
     * walletId : 1
     * paymentMode : 1
     * billId : null
     * createTime : 1469067218000
     * amount : 100
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
        private String type;
        private String memberId;
        private String walletId;
        private String paymentMode;
        private String billId;
        private String createTime;
        private String amount;
        private String id;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getMemberId() {
            return memberId;
        }

        public void setMemberId(String memberId) {
            this.memberId = memberId;
        }

        public String getWalletId() {
            return walletId;
        }

        public void setWalletId(String walletId) {
            this.walletId = walletId;
        }

        public String getPaymentMode() {
            return paymentMode;
        }

        public void setPaymentMode(String paymentMode) {
            this.paymentMode = paymentMode;
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
