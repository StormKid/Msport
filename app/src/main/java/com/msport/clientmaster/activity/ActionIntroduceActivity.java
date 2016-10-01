package com.msport.clientmaster.activity;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.msport.clientmaster.R;
import com.msport.clientmaster.base.BaseActivity;
import com.msport.clientmaster.constants.Constant;
import com.msport.clientmaster.util.CustomToast;
import com.msport.clientmaster.util.PublicPreferencesUtils;

import org.simple.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 活动介绍
 *
 * @author like
 *         2016-5-3
 */
public class ActionIntroduceActivity extends BaseActivity {

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
    @BindView(R.id.user_in)
    EditText userIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_introduce);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        mainTitle.setText("活动介绍");
        shareBlack.setVisibility(View.GONE);
        String finish = PublicPreferencesUtils.getString(this, Constant.FINISHED);
        if (TextUtils.isEmpty(finish)){
            userIn.setText("");
        }else {
            userIn.setText(finish);
        }
        titleRightTv.setVisibility(View.VISIBLE);
        detailTitleChange.setBackgroundColor(ContextCompat.getColor(this,R.color.white));
        userIn.setBackgroundColor(ContextCompat.getColor(this,R.color.white));

    }


    @OnClick({R.id.back_black, R.id.title_right_tv})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_black:
                finish();
                break;
            case R.id.title_right_tv:
                String introduce = userIn.getText().toString().trim();
                if (TextUtils.isEmpty(introduce)){
                    CustomToast.createToast().showFaild(this,"请输入活动介绍");
                    return;
                }else {
                    EventBus.getDefault().post(introduce,Constant.FINISHED);
                    CustomToast.createToast().showSuccess(this,"收集完成");
                    finish();
                }
                break;
        }
    }
}
