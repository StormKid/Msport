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
import com.msport.clientmaster.fragment.QianBaoListFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by like on 2016/8/15.
 */

public class QianBaoListActivity extends BaseActivity {

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
    @BindView(R.id.qianbao_list_outer)
    TextView qianbaoListOuter;
    @BindView(R.id.qianbao_list_inner)
    TextView qianbaoListInner;
    @BindView(R.id.order_fragment_view)
    ViewPager orderFragmentView;

    private final int ZHICHU = 0;
    private final int SHOURU = 1;
    @BindView(R.id.title_up_down)
    ImageView titleUpDown;
    @BindView(R.id.contain_alls)
    LinearLayout containAlls;
    private Context context;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qianbao_detail);
        ButterKnife.bind(this);
        context = this;
        initView();
    }

    private void initView() {
        mainTitle.setText("交易记录");
        shareBlack.setVisibility(View.GONE);
        List<Fragment> fragments = setFragments();
        orderFragmentView.setAdapter(new ChangePagerAdapter(getSupportFragmentManager(), fragments));
        orderFragmentView.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (position == ZHICHU) {
                    changeColor(qianbaoListOuter);
                } else if (position == SHOURU) {
                    changeColor(qianbaoListInner);
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        containAlls.setBackgroundColor(ContextCompat.getColor(this,R.color.white));

    }

    @OnClick({R.id.back_black, R.id.qianbao_list_outer, R.id.qianbao_list_inner})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_black:
                finish();
                break;
            case R.id.qianbao_list_outer:
                changeColor(qianbaoListOuter);
                orderFragmentView.setCurrentItem(ZHICHU);
                break;
            case R.id.qianbao_list_inner:
                changeColor(qianbaoListInner);
                orderFragmentView.setCurrentItem(SHOURU);
                break;
        }
    }


    private void changeColor(TextView tv) {
        qianbaoListInner.setTextColor(ContextCompat.getColor(this, R.color.text_black_5c));
        qianbaoListOuter.setTextColor(ContextCompat.getColor(this, R.color.text_black_5c));
        tv.setTextColor(ContextCompat.getColor(this, R.color.text_orange));
    }


    private List<Fragment> setFragments() {
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(ZHICHU, new QianBaoListFragment(ZHICHU, context));
        fragments.add(SHOURU, new QianBaoListFragment(SHOURU, context));
        return fragments;
    }


}
