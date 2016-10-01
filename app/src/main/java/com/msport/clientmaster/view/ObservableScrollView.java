package com.msport.clientmaster.view;

/**
 * Created by like on 2016/7/13.
 */

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ListView;

import com.msport.clientmaster.constants.Constant;
import com.msport.clientmaster.intef.ScrollListener;


public class ObservableScrollView extends ListView {

    private ScrollListener mListener;


    public ObservableScrollView(Context context) {
        this(context, null);
    }

    public ObservableScrollView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ObservableScrollView(Context context, AttributeSet attrs,
                                int defStyle) {
        super(context, attrs, defStyle);

    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        switch (ev.getAction()){
            case MotionEvent.ACTION_DOWN:
                if (mListener != null){
                    mListener.scrollOritention(Constant.SCROLL_DOWN);
                }
                break;
            case MotionEvent.ACTION_UP:
                if (mListener!=null){
                    mListener.scrollOritention(Constant.SCROLL_UP);}
                break;
        }
        return super.onTouchEvent(ev);
    }




    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);

    }

    public void setScrollListener(ScrollListener l) {
        this.mListener = l;
    }
}