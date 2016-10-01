package com.msport.clientmaster.entity;


import com.msport.clientmaster.bean.HotBean;

import java.util.List;

/**
 * Created by like on 2016/7/4.
 */
public class HotEntity extends BaseEntity{

    public List<HotBean> getData() {
        return data;
    }

    public void setData(List<HotBean> data) {
        this.data = data;
    }

    private List<HotBean> data;

}
