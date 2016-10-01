package com.msport.clientmaster.view;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * 阻隔事件的ViewGroup
 * Created by like on 2016/7/13.
 */

public class MyLayoutView extends LinearLayout {
    public MyLayoutView(Context context) {
        super(context);
    }


    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return true;
    }
}
