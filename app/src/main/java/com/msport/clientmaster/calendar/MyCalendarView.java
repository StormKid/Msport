package com.msport.clientmaster.calendar;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
/**
 * 自定义显示日期控件
 * @author like
 * 2016-5-11
 */
public class MyCalendarView extends RecyclerView {
	/**
	 * recyclerView 总共显示的长度
	 */
	private int size;
	/**
	 * recyclerView 的子view
	 */
	private View child;
	/**
	 * recyclerView 的position
	 */
	private int position;
	private Context context;

	public MyCalendarView(Context context, @Nullable AttributeSet arg1, int arg2) {
		super(context, arg1, arg2);
		init(context);
	}

	private void init(Context context) {
		this.context = context;
		
	}

	public MyCalendarView(Context context, @Nullable AttributeSet attrs) {
		this(context, attrs,0);
	}

	public MyCalendarView(Context context) {
		this(context,null);
		
	}

	public void initView(final int position) {
		this.position = position;
		
	}


}
