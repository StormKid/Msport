package com.msport.clientmaster.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.msport.clientmaster.R;
import com.msport.clientmaster.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by like on 2016/8/9.
 */
public class SaftyPhoneActivity extends BaseActivity {

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
    @BindView(R.id.phone_change_phonecell)
    EditText phoneChangePhonecell;
    @BindView(R.id.phone_change_yanzhengma)
    EditText phoneChangeYanzhengma;
    @BindView(R.id.phone_change_get_yanzhengma)
    TextView phoneChangeGetYanzhengma;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_safty_phone);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        titleRightTv.setVisibility(View.VISIBLE);
        mainTitle.setText("账号设置");
        shareBlack.setVisibility(View.GONE);
    }

    @OnClick({R.id.back_black, R.id.title_right_tv, R.id.phone_change_get_yanzhengma})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_black:
                finish();
                break;
            case R.id.title_right_tv:
                // TODO 提交内容
                break;
            case R.id.phone_change_get_yanzhengma:
                // TODO 获取验证码

                break;
        }
    }
}
