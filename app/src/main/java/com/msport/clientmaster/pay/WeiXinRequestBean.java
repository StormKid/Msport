package com.msport.clientmaster.pay;

/**
 * Created by like on 2016/8/16.
 */

public class WeiXinRequestBean extends InitPayOrderBean {

    public String getPrepayId() {
        return prepayId;
    }

    public void setPrepayId(String prepayId) {
        this.prepayId = prepayId;
    }

    private String prepayId;

}
