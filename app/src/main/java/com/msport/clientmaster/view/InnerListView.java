package com.msport.clientmaster.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;
/**
 * 嵌套的listview
 * @author like
 * 2016-5-17
 */
public class InnerListView extends ListView {

	public InnerListView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		int expandSpec = MeasureSpec.makeMeasureSpec(       
                Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
	}


}
