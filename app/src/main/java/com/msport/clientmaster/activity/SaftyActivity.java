package com.msport.clientmaster.activity;

import android.content.Context;
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
import com.msport.clientmaster.util.PublicPreferencesUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by like on 2016/8/9.
 */

public class SaftyActivity extends BaseActivity {

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
    @BindView(R.id.user_safty_phone)
    TextView userSaftyPhone;
    @BindView(R.id.user_safty_phone_change)
    LinearLayout userSaftyPhoneChange;
    @BindView(R.id.user_safty_password)
    TextView userSaftyPassword;
    @BindView(R.id.user_safty_password_change)
    LinearLayout userSaftyPasswordChange;
    @BindView(R.id.title_up_down)
    ImageView titleUpDown;
    @BindView(R.id.contain_alls)
    LinearLayout containAlls;
    private Context context;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_safty);
        ButterKnife.bind(this);
        context = this;
        initView();
    }

    private void initView() {
        containAlls.setBackgroundColor(ContextCompat.getColor(context,R.color.white));
        shareBlack.setVisibility(View.GONE);
        userSaftyPassword.setText(PublicPreferencesUtils.getString(context, Constant.USER_PWD));
        userSaftyPhone.setText(PublicPreferencesUtils.getString(context, Constant.USER_PHONE));
    }

    @OnClick({R.id.user_safty_phone_change, R.id.user_safty_password_change, R.id.back_black})
    public void onClick(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.user_safty_phone_change:
//                intent.setClass(context, SaftyPhoneActivity.class);
//                startActivity(intent);
                break;
            case R.id.user_safty_password_change:
                intent.setClass(this, RegisteActivity.class);
                intent.putExtra("change_pwd","cpwd");
                startActivity(intent);
                break;
            case R.id.back_black:
                finish();
                break;
        }
    }
}
