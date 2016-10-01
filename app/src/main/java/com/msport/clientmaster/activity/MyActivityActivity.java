package com.msport.clientmaster.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.msport.clientmaster.R;
import com.msport.clientmaster.adapter.ChangePagerAdapter;
import com.msport.clientmaster.base.BaseActivity;
import com.msport.clientmaster.fragment.ActivityFrament;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by like on 2016/8/20.
 */

public class MyActivityActivity extends BaseActivity {

    @BindView(R.id.back_black)
    ImageView backBlack;
    @BindView(R.id.main_title)
    TextView mainTitle;
    @BindView(R.id.title_up_down)
    ImageView titleUpDown;
    @BindView(R.id.share_black)
    ImageView shareBlack;
    @BindView(R.id.title_right_tv)
    TextView titleRightTv;
    @BindView(R.id.detail_title_change)
    LinearLayout detailTitleChange;
    @BindView(R.id.activity_list_join)
    TextView activityListJoin;
    @BindView(R.id.activity_list_provide)
    TextView activityListProvide;
    @BindView(R.id.activity_fragment_view)
    ViewPager activityFragmentView;
    @BindView(R.id.contain_alls)
    LinearLayout containAlls;
    private Context context;
    private final int JOIN = 0;
    private final int LET = 1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_activity);
        ButterKnife.bind(this);
        context = this;
        initView();
    }

    private void initView() {
        containAlls.setBackgroundColor(ContextCompat.getColor(context,R.color.white));
        mainTitle.setText("我的活动");
        shareBlack.setVisibility(View.GONE);
        List<Fragment> fragments = setFragments();
        activityFragmentView.setAdapter(new ChangePagerAdapter(getSupportFragmentManager(), fragments));
        activityFragmentView.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (position == JOIN) {
                    changeColor(activityListJoin);
                } else if (position == LET) {
                    changeColor(activityListProvide);
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }


    @OnClick({R.id.back_black, R.id.activity_list_join, R.id.activity_list_provide})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_black:
                finish();
                break;
            case R.id.activity_list_join:
                activityFragmentView.setCurrentItem(JOIN);
                break;
            case R.id.activity_list_provide:
                activityFragmentView.setCurrentItem(LET);
                break;
        }
    }

    private List<Fragment> setFragments() {
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(JOIN, new ActivityFrament(JOIN, context));
        fragments.add(LET, new ActivityFrament(LET, context));
        return fragments;
    }

    private void changeColor(TextView tv) {
        activityListJoin.setTextColor(ContextCompat.getColor(this, R.color.text_black_5c));
        activityListProvide.setTextColor(ContextCompat.getColor(this, R.color.text_black_5c));
        tv.setTextColor(ContextCompat.getColor(this, R.color.text_orange));
    }
}
