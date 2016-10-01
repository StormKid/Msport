package com.msport.clientmaster.entity;

/**
 * Created by like on 2016/8/3.
 */

public class WeiPayEntity extends BaseEntity {
    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    private DataBean data;


    public static class DataBean {
        public String getSign() {
            return sign;
        }

        public void setSign(String sign) {
            this.sign = sign;
        }

        private String sign;
    }
}
