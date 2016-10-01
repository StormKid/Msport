package com.msport.clientmaster.requestbean;

import java.io.Serializable;

/**
 * Created by like on 2016/7/26.
 */
public class YueQiuRequestBean implements Serializable {

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(String timeStart) {
        this.timeStart = timeStart;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    private String timeStart;
    private String sort;
    private String value;


}
