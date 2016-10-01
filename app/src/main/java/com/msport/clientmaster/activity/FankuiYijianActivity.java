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
import com.msport.clientmaster.callback.MainCallback;
import com.msport.clientmaster.constants.HttpConstant;
import com.msport.clientmaster.intef.MyViewCallback;
import com.msport.clientmaster.util.CustomToast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Response;

/**
 * 意见反馈
 *
 * @author like
 *         2016-5-3
 */
public class FankuiYijianActivity extends BaseActivity implements MyViewCallback {

    @BindView(R.id.fankui_et)
    EditText fankui_et;
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
    private MainCallback callback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fankui);
        ButterKnife.bind(this);
        callback = new MainCallback(this, this);
        initView();
    }

    private void initView() {
        mainTitle.setText("意见反馈");
        titleRightTv.setText("提交");
        shareBlack.setVisibility(View.GONE);
        titleRightTv.setVisibility(View.VISIBLE);
        fankui_et.setBackgroundColor(ContextCompat.getColor(this,R.color.white));
    }


    @Override
    public void viewMode(Response res, String tag) {
        if (HttpConstant.YIJIAN_FANGKUI.equals(tag)) {
            CustomToast.createToast().showSuccess(this, "反馈成功,我们会尽快完善");
            fankui_et.setText("");
            finish();
        }
    }

    @Override
    public void getFalse(boolean tag, String message) {

        CustomToast.createToast().showFaild(this,"");


    }

    @Override
    public void showCode(int code, String string) {

    }

    @OnClick({R.id.back_black, R.id.title_right_tv})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_black:
                finish();
                break;
            case R.id.title_right_tv:
                String fankui = fankui_et.getText().toString().trim();
                if (TextUtils.isEmpty(fankui) || fankui == null) {
                    CustomToast.createToast().showFaild(FankuiYijianActivity.this, "请输入您的反馈信息");
                    return;
                } else if (fankui.length() < 5) {
                    CustomToast.createToast().showFaild(FankuiYijianActivity.this, "请输入5个字以上的反馈信息");
                    return;
                }
                callback.FanKui(fankui);
                break;
        }
    }
}
