package com.msport.clientmaster.entity;

import java.io.Serializable;

/**
 * Created by like on 2016/7/4.
 */
public class BaseEntity implements Serializable {

    private String code;
    private String status;
    private String count;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

}
