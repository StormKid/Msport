package com.msport.clientmaster.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.msport.clientmaster.R;
import com.msport.clientmaster.base.BaseActivity;
import com.msport.clientmaster.constants.Constant;
import com.msport.clientmaster.requestbean.BindQianbaoRequestBean;

import org.simple.eventbus.Subscriber;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by like on 2016/8/15.
 */

public class BindListAcitivity extends BaseActivity {

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
    @BindView(R.id.fagnshi_weixin)
    LinearLayout fagnshiWeixin;
    @BindView(R.id.fangshi_zhifubao)
    LinearLayout fangshiZhifubao;
    @BindView(R.id.title_up_down)
    ImageView titleUpDown;
    @BindView(R.id.all_contain)
    LinearLayout allContain;
    private BindQianbaoRequestBean bean;
    private String walletId;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bind_qianbao_list);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        mainTitle.setText("绑定");
        bean = new BindQianbaoRequestBean();
        shareBlack.setVisibility(View.GONE);
        allContain.setBackgroundColor(ContextCompat.getColor(this,R.color.white));
        walletId = getIntent().getStringExtra("walletId");

    }

    @OnClick({R.id.back_black, R.id.fagnshi_weixin, R.id.fangshi_zhifubao})
    public void onClick(View view) {
        Intent intent = new Intent(this, BindQianbaoActivity.class);
        switch (view.getId()) {
            case R.id.back_black:
                finish();
                break;
            case R.id.fagnshi_weixin:
                bean.accountType = "1";

                break;
            case R.id.fangshi_zhifubao:
                bean.accountType = "2";
                break;
        }
        intent.putExtra(Constant.BIND_QIANBAO, bean);
        intent.putExtra("walletId",walletId);
        startActivity(intent);
    }

    @Subscriber(tag = Constant.ACTIVITY_FINISH)
    public void getFinish() {
        finish();
    }

}
