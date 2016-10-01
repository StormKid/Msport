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
import com.msport.clientmaster.fragment.ReviewListFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by like on 2016/8/17.
 */

public class MyReviewListActivity extends BaseActivity {

    @BindView(R.id.back_black)
    ImageView backBlack;
    @BindView(R.id.main_title)
    TextView mainTitle;
    @BindView(R.id.share_black)
    ImageView shareBlack;
    @BindView(R.id.title_right_tv)
    TextView titleRightTv;
    @BindView(R.id.detail_title_change)
    LinearLayout detailTitleChange;
    @BindView(R.id.review_list_outer)
    TextView reviewListOuter;
    @BindView(R.id.review_list_inner)
    TextView reviewListInner;
    @BindView(R.id.order_fragment_view)
    ViewPager orderFragmentView;

    private final int DONE_REVIEW = 0;
    private final int NO_REVUEW = 1;
    @BindView(R.id.title_up_down)
    ImageView titleUpDown;
    @BindView(R.id.contain_alls)
    LinearLayout containAlls;
    private Context context;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myreview);
        ButterKnife.bind(this);
        context = this;
        initView();

    }

    private void initView() {
        containAlls.setBackgroundColor(ContextCompat.getColor(context,R.color.white));
        mainTitle.setText("我的点评");
        shareBlack.setVisibility(View.GONE);
        List<Fragment> fragments = setFragments();
        orderFragmentView.setAdapter(new ChangePagerAdapter(getSupportFragmentManager(), fragments));
        orderFragmentView.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (position == DONE_REVIEW) {
                    changeColor(reviewListOuter);
                } else if (position == NO_REVUEW) {
                    changeColor(reviewListInner);
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

    private void changeColor(TextView tv) {
        reviewListInner.setTextColor(ContextCompat.getColor(this, R.color.text_black_5c));
        reviewListOuter.setTextColor(ContextCompat.getColor(this, R.color.text_black_5c));
        tv.setTextColor(ContextCompat.getColor(this, R.color.text_orange));
    }


    private List<Fragment> setFragments() {
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(DONE_REVIEW, new ReviewListFragment(DONE_REVIEW, context));
        fragments.add(NO_REVUEW, new ReviewListFragment(NO_REVUEW, context));
        return fragments;
    }

    @OnClick({R.id.back_black, R.id.review_list_outer, R.id.review_list_inner})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_black:
                finish();
                break;
            case R.id.review_list_outer:
                changeColor(reviewListOuter);
                orderFragmentView.setCurrentItem(DONE_REVIEW);
                break;
            case R.id.review_list_inner:
                changeColor(reviewListInner);
                orderFragmentView.setCurrentItem(NO_REVUEW);
                break;
        }
    }
}
