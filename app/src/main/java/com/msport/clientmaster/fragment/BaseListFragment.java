package com.msport.clientmaster.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import org.simple.eventbus.EventBus;
/**
 * 基本的内部列表主fragment`
 * @author like
 * 2016-4-1
 */
public class BaseListFragment extends Fragment {
	
	private boolean isFirstLoad = true;
	
	/**
	 * 控制内嵌的fragment预加载
	 */
	@Override
	public void setUserVisibleHint(boolean isVisibleToUser) {
		super.setUserVisibleHint(isVisibleToUser);
		if (isVisibleToUser) {
			if (isFirstLoad) {
				initData();
				isFirstLoad = false;
			}
		}
	}
	

	protected void initData() {
	}


	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		EventBus.getDefault().register(this);
		
	}
	  
	
	@Override
	public void onDestroy() {
		super.onDestroy();
		EventBus.getDefault().unregister(this);
	}
	
	
}
