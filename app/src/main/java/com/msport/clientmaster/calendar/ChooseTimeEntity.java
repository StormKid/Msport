package com.msport.clientmaster.calendar;

import com.msport.clientmaster.entity.BaseEntity;

import java.util.List;

public class ChooseTimeEntity extends BaseEntity {

	private List<ChooseTimeBean> data;

	public List<ChooseTimeBean> getData() {
		return data;
	}

	public void setData(List<ChooseTimeBean> data) {
		this.data = data;
	}
	
	
	
}
