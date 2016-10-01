package com.msport.clientmaster.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.msport.clientmaster.R;
import com.msport.clientmaster.base.BaseActivity;
import com.msport.clientmaster.util.Tools;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 关于我们
 *
 * @author like
 *         2016-6-18
 */
public class MyAboutActivity extends BaseActivity {

    @BindView(R.id.my_version)
    TextView my_version;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        ButterKnife.bind(this);
        initView();

    }

    private void initView() {
        shareBlack.setVisibility(View.GONE);
        mainTitle.setText("关于我们");
        String appVersion = Tools.getAppVersion(this);
        my_version.setText("版本号：" + appVersion);
    }


    @OnClick(R.id.back_black)
    public void onClick() {
        finish();
    }
}
