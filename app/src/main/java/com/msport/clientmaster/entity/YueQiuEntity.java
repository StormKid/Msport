package com.msport.clientmaster.entity;

import com.msport.clientmaster.bean.YueQiuBean;

import java.util.List;

/**
 * Created by like on 2016/7/26.
 */

public class YueQiuEntity extends BaseEntity {

    public List<YueQiuBean> getData() {
        return data;
    }

    public void setData(List<YueQiuBean> data) {
        this.data = data;
    }

    private List<YueQiuBean> data;
}
