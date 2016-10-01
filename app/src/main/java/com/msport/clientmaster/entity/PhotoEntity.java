package com.msport.clientmaster.entity;

/**
 * Created by like on 2016/9/6.
 */

public class PhotoEntity extends BaseEntity {


    /**
     * data : userfiles/216/images/admin/mobile/2016/9/1473153306989.png"
     * result : success
     */

    private String data;
    private String result;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
