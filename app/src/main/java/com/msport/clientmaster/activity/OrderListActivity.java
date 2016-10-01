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
import com.msport.clientmaster.constants.Constant;
import com.msport.clientmaster.fragment.OrderFragmentDialog;
import com.msport.clientmaster.fragment.OrderListFragment;
import com.msport.clientmaster.util.AnimationUtil;

import org.simple.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by like on 2016/8/18.
 */

public class OrderListActivity extends BaseActivity {

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
    @BindView(R.id.order_list_all)
    TextView orderListAll;
    @BindView(R.id.order_list_will)
    TextView orderListWill;
    @BindView(R.id.order_list_done)
    TextView orderListDone;
    @BindView(R.id.order_fragment_view)
    ViewPager orderFragmentView;
    @BindView(R.id.order_list_fide)
    View order_list_fide;
    @BindView(R.id.title_up_down)
    ImageView title_up_down;
    @BindView(R.id.contain_alls)
    LinearLayout containAlls;


    private Context context;
    private int ALL_ORDER = 0;
    private int WILL_ORDER = 1;
    private int DONE_ORDER = 2;
    private String ORDER_TYPE = "0";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_list);
        ButterKnife.bind(this);
        context = this;
        initView();
    }

    @OnClick({R.id.back_black, R.id.detail_title_change, R.id.order_list_all, R.id.order_list_will, R.id.order_list_done})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_black:
                finish();
                break;
            case R.id.detail_title_change:
                OrderFragmentDialog fragmentDialog = new OrderFragmentDialog(detailTitleChange.getHeight(), R.layout.order_list_pop_layout, "!",this);
                fragmentDialog.setOnDialogStateListener(new OrderFragmentDialog.onDialogStateListener() {
                    @Override
                    public void getDialogState(boolean tag) {
                        if (tag) {
                            order_list_fide.setVisibility(View.VISIBLE);
                            AnimationUtil.getInstance().rolate_180_do(title_up_down);
                        } else {
                            order_list_fide.setVisibility(View.GONE);
                            AnimationUtil.getInstance().rolate_180_redo(title_up_down);
                        }
                    }
                });
                fragmentDialog.setOnSaveOutputListener(new OrderFragmentDialog.OnSaveOutputListener() {
                    @Override
                    public void getOutPut(String type, String value) {
                        ORDER_TYPE = type;
                        mainTitle.setText(value);
                        setList();
                        EventBus.getDefault().post(ORDER_TYPE, Constant.ORDER_TYPE);
                    }
                });
                fragmentDialog.show(getSupportFragmentManager(), "1");
                break;
            case R.id.order_list_all:
                changeColor(orderListAll);
                orderFragmentView.setCurrentItem(ALL_ORDER);
                break;
            case R.id.order_list_will:
                changeColor(orderListWill);
                orderFragmentView.setCurrentItem(WILL_ORDER);
                break;
            case R.id.order_list_done:
                changeColor(orderListDone);
                orderFragmentView.setCurrentItem(DONE_ORDER);
                break;
        }
    }

    private void initView() {
        containAlls.setBackgroundColor(ContextCompat.getColor(context,R.color.white));
        mainTitle.setText("课程订单");
        shareBlack.setVisibility(View.GONE);
        title_up_down.setVisibility(View.VISIBLE);
        setList();

    }


    private void setList() {
        List<Fragment> fragments = setFragments();
        orderFragmentView.setOffscreenPageLimit(3);
        orderFragmentView.setAdapter(new ChangePagerAdapter(getSupportFragmentManager(), fragments));
        orderFragmentView.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (position == ALL_ORDER) {
                    changeColor(orderListAll);
                } else if (position == WILL_ORDER) {
                    changeColor(orderListWill);
                } else {
                    changeColor(orderListDone);
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
        orderListAll.setTextColor(ContextCompat.getColor(this, R.color.text_black_5c));
        orderListDone.setTextColor(ContextCompat.getColor(this, R.color.text_black_5c));
        orderListWill.setTextColor(ContextCompat.getColor(this, R.color.text_black_5c));
        tv.setTextColor(ContextCompat.getColor(this, R.color.text_orange));
    }


    private List<Fragment> setFragments() {
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(ALL_ORDER, new OrderListFragment(0, context, ORDER_TYPE));
        fragments.add(WILL_ORDER, new OrderListFragment(-1, context, ORDER_TYPE));
        fragments.add(DONE_ORDER, new OrderListFragment(1, context, ORDER_TYPE));
        return fragments;
    }
}
