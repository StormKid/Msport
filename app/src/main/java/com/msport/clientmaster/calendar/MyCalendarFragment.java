package com.msport.clientmaster.calendar;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.msport.clientmaster.R;
import com.msport.clientmaster.constants.Constant;
import com.msport.clientmaster.fragment.BaseListFragment;

import org.simple.eventbus.EventBus;
import org.simple.eventbus.Subscriber;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

@SuppressLint("ValidFragment")
public class MyCalendarFragment extends BaseListFragment {
	/**
	 * 外部传递进来的数据
	 */
	private List<GetTimeBean> listData;
	/**
	 * 显示对应的课程
	 */
	@BindView(R.id.calendar_list_view)
    MyCalendarView calendar_list_view;
	private MyTimerChooseAdapter chooseAdapter;
	private Map<Integer,List<GetTimeBean>> maps = new HashMap<Integer, List<GetTimeBean>>();
	
	private Handler handler = new Handler(){
		@SuppressWarnings("unchecked")
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case Constant.GET_TIME_CHOOSER:
				listData = (List<GetTimeBean>) msg.obj;
				maps.put(i, listData);
				EventBus.getDefault().post(maps, Constant.GET_TIME_CHOOSER_);
				break;
			}
		}
	};
	private int i;
	
	public MyCalendarFragment(List<GetTimeBean> listData, int i) {
		super();
		this.listData = listData;
		this.i = i;
	}
	
	
	@Override
	@Nullable
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_calendar, null);
		ButterKnife.bind(this,view);
		initView();
		return view;
	}
	
	private void initView() {
		LinearLayoutManager manager = new LinearLayoutManager(getActivity());
		calendar_list_view.setLayoutManager(manager);
		chooseAdapter = new MyTimerChooseAdapter(getActivity(), listData, handler);
		calendar_list_view.setAdapter(chooseAdapter);
	}


	@Override
	protected void initData() {
		super.initData();
		
	}
	
	@Subscriber(tag = Constant.FULL_CHECKED_)
	public void getFullCheck(boolean tag){
		chooseAdapter.getTag(tag);
	}
	
}
