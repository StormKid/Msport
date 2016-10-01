package com.msport.clientmaster.entity;

/**
 * Created by like on 2016/8/1.
 */

public class WeiXinPayEntity extends BaseEntity{


    /**
     * appid : wx650886f53c75d5c0
     * trade_type : APP
     * prepay_id : wx2016080117223587f6d69f230921614455
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private String appid;
        private String trade_type;
        private String prepay_id;

        public String getAppid() {
            return appid;
        }

        public void setAppid(String appid) {
            this.appid = appid;
        }

        public String getTrade_type() {
            return trade_type;
        }

        public void setTrade_type(String trade_type) {
            this.trade_type = trade_type;
        }

        public String getPrepay_id() {
            return prepay_id;
        }

        public void setPrepay_id(String prepay_id) {
            this.prepay_id = prepay_id;
        }
    }
}
