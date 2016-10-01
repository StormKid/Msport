package com.msport.clientmaster.view;

/**
 * Created by like on 2016/7/13.
 */

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ExpandableListView;

import com.msport.clientmaster.constants.Constant;
import com.msport.clientmaster.intef.ScrollListener;

/**
 * ObservableScrollExpendableView
 */
public class ObservableScrollExpendableView extends ExpandableListView {

    private ScrollListener mListener;
    private boolean flag;

    public ObservableScrollExpendableView(Context context) {
        this(context, null);
    }

    public ObservableScrollExpendableView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ObservableScrollExpendableView(Context context, AttributeSet attrs,
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


    public void setScrollListener(ScrollListener l) {
        this.mListener = l;
    }



}