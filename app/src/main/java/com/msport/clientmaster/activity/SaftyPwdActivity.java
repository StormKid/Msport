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
public class SaftyPwdActivity extends BaseActivity {

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
    @BindView(R.id.pwd_change_before)
    EditText pwdChangeBefore;
    @BindView(R.id.pwd_change_after)
    EditText pwdChangeAfter;
    @BindView(R.id.pwd_change_after_check)
    EditText pwdChangeAfterCheck;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_safty_pwd);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        mainTitle.setText("修改密码");
        shareBlack.setVisibility(View.GONE);
        titleRightTv.setVisibility(View.VISIBLE);
        titleRightTv.setText("提交");
    }

    @OnClick({R.id.back_black, R.id.title_right_tv})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_black:
                finish();
                break;
            case R.id.title_right_tv:
                break;
        }
    }
}
