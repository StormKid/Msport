package com.msport.clientmaster.view;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;

/**
 * Created by like on 2016/7/20.
 */

public class HomeScrollView extends ScrollView {
    private OnScrollGetYListener listener;
    private int lastScrollY;
    private int flag = 0;

    public HomeScrollView(Context context) {
        super(context);
    }

    public HomeScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public HomeScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private Handler handler = new Handler() {

        public void handleMessage(android.os.Message msg) {
            flag = 0;
            int scrollY = HomeScrollView.this.getScrollY();
            //此时的距离和记录下的距离不相等，在隔5毫秒给handler发送消息
            if (lastScrollY != scrollY) {
                lastScrollY = scrollY;
                handler.sendMessageDelayed(handler.obtainMessage(), 5);
            }
            if (listener != null) {
                listener.getScrollY(scrollY);
            }

        }

    };


    @Override
    public boolean onTouchEvent(MotionEvent ev) {

        if (listener != null) {
            listener.getScrollY(lastScrollY = this.getScrollY());
        }
        switch (ev.getAction()) {
            case MotionEvent.ACTION_UP:
                handler.sendMessageDelayed(handler.obtainMessage(), 20);
                break;
            case MotionEvent.ACTION_MOVE:

                break;
        }

        return super.onTouchEvent(ev);
    }

    public void setOnScrollYListener(OnScrollGetYListener listener) {
        this.listener = listener;
    }

    public interface OnScrollGetYListener {
        void getScrollY(int y);
    }

    public interface onLoadMoreListener {
        void loadMore();
    }

    private onLoadMoreListener loadMore;

    public void setOnLoadMoreListener(onLoadMoreListener loadMore) {
        this.loadMore = loadMore;
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        View view = this.getChildAt(0);
        //如果scrollview滑动到底部并且并发控制符为0，回调接口向服务器端请求数据
        if (this.getHeight() + this.getScrollY() == view.getHeight() && flag == 0) {
            flag = 1;//一进来就将并发控制符置为1，虽然onScrollChanged执行多次，但是由于并发控制符的值为1，不满足条件就不会执行到这;
            if (loadMore != null) {
                loadMore.loadMore();
            }

        }

    }
}
