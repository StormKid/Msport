package com.msport.clientmaster.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.msport.clientmaster.R;
import com.msport.clientmaster.base.BaseActivity;
import com.msport.clientmaster.constants.Constant;
import com.msport.clientmaster.util.AnimationUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by like on 2016/7/20.
 */

public class ButtomPopActivity extends BaseActivity {

    /**
     * 羽毛球弹出
     */
    @BindView(R.id.home_yumaoqiu)
    ViewGroup home_yumaoqiu;
    /**
     * 网球弹出
     */
    @BindView(R.id.home_youyong)
    ViewGroup home_youyong;


    /**
     * 设置高度的viewGroup
     */
    @BindView(R.id.height_contain)
    ViewGroup height_contain;

    /**
     * 底部显示的圆圈
     */
    @BindView(R.id.home_buttom_changed)
    ImageView home_buttom_changed;

    /**
     * 整体页面
     */
    @BindView(R.id.pop_context)
    ViewGroup pop_context;

    private Handler handler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case Constant.HIDE_LAYOUT:
                    finish();
                    break;

                default:
                    break;
            }
        }

    };
    private int transY;
    private String type = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popbuttom);
        ButterKnife.bind(this);
        initpopButton();
    }

    @SuppressWarnings("deprecation")
    private void initpopButton() {
        transY = 1 * getWindowManager().getDefaultDisplay().getHeight() / 4;
        AnimationUtil.getInstance().doButtomShow(home_yumaoqiu, transY);
        handler.postDelayed(new Runnable() {

            @Override
            public void run() {
                AnimationUtil.getInstance().doButtomShow(home_youyong, transY);

            }
        }, 200);
        AnimationUtil.getInstance().rotate_LIKE_ZHAILIJUAN(home_buttom_changed);
        home_youyong.setOnTouchListener(new MOVE_EVENT());
        home_yumaoqiu.setOnTouchListener(new MOVE_EVENT());
    }

    @OnClick({R.id.pop_context})
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.pop_context:
                pop_context.setClickable(false);
                home_youyong.setOnTouchListener(null);
                home_yumaoqiu.setOnTouchListener(null);
                AnimationUtil.getInstance().rotate_ZHAILIJUAN_LIKE(
                        home_buttom_changed);
                handler.postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        AnimationUtil.getInstance().doButtomHide(home_youyong,
                                null, transY);

                    }
                }, 100);
                handler.postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        AnimationUtil.getInstance().doButtomHide(home_yumaoqiu,
                                handler, transY);

                    }
                }, 200);
                handler.postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        finish();

                    }
                }, 550);
                break;

        }
    }


    private class MOVE_EVENT implements View.OnTouchListener {

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    AnimationUtil.getInstance().scaleBIG(v);
                    break;

                case MotionEvent.ACTION_UP:
                    switch (v.getId()) {
                        case R.id.home_youyong:
                            AnimationUtil.getInstance().scaleSHORT(v, "5", ButtomPopActivity.this, handler);
                            break;
                        case R.id.home_yumaoqiu:
                            AnimationUtil.getInstance().scaleSHORT(v, "4", ButtomPopActivity.this, handler);
                            break;
                    }

                    home_youyong.setOnTouchListener(null);
                    home_yumaoqiu.setOnTouchListener(null);
                    home_buttom_changed.setOnTouchListener(null);
                    break;
            }
            return true;
        }

    }
}
