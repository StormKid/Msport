package com.msport.clientmaster.bean;

import java.io.Serializable;

/**
 * Created by like on 2016/9/6.
 */

public class HomeJsonBean implements Serializable {

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    private String price;


}
