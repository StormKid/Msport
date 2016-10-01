package com.msport.clientmaster.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
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
import com.msport.clientmaster.constants.Constant;
import com.msport.clientmaster.constants.HttpConstant;
import com.msport.clientmaster.entity.BaseEntity;
import com.msport.clientmaster.intef.MyViewCallback;
import com.msport.clientmaster.requestbean.BindQianbaoRequestBean;
import com.msport.clientmaster.util.CustomToast;

import org.simple.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Response;

/**
 * Created by like on 2016/8/15.
 */

public class BindQianbaoActivity extends BaseActivity implements MyViewCallback {

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
    @BindView(R.id.bind_account_number)
    EditText bindAccountNumber;
    @BindView(R.id.bind_telephone)
    EditText bindTelephone;
    @BindView(R.id.bind_name)
    EditText bindName;
    @BindView(R.id.bind_commit)
    TextView bindCommit;
    @BindView(R.id.title_up_down)
    ImageView titleUpDown;
    @BindView(R.id.contain_alls)
    LinearLayout containAlls;
    private MainCallback callback;
    private BindQianbaoRequestBean bindQianbaoRequestBean;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bind_qianbao);
        ButterKnife.bind(this);
        callback = new MainCallback(this, this);
        initView();
    }

    private void initView() {
        String walletId = getIntent().getStringExtra("walletId");
        containAlls.setBackgroundColor(ContextCompat.getColor(this,R.color.white));
        mainTitle.setText("绑定钱包");
        shareBlack.setVisibility(View.GONE);
        bindQianbaoRequestBean = (BindQianbaoRequestBean) getIntent().getSerializableExtra(Constant.BIND_QIANBAO);
        if (bindQianbaoRequestBean.accountType.equals("1")) {//微信
            bindAccountNumber.setHint("请输入您的微信账号");
        } else {//支付宝
            bindAccountNumber.setHint("请输入您的支付宝账号");
        }
        bindQianbaoRequestBean.walletId = walletId;
    }

    @OnClick({R.id.back_black, R.id.bind_commit})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_black:
                finish();
                break;
            case R.id.bind_commit:
                String bindAccount = bindAccountNumber.getText().toString().trim();
                String name = bindName.getText().toString().trim();
                String telephone = bindTelephone.getText().toString().trim();
                if (TextUtils.isEmpty(bindAccount)) {
                    CustomToast.createToast().showFaild(this, "请输入您所要绑定的平台账号");
                    break;
                } else if (TextUtils.isEmpty(telephone)) {
                    CustomToast.createToast().showFaild(this, "请输入您的电话号码");
                    break;
                } else if (TextUtils.isEmpty(name)) {
                    CustomToast.createToast().showFaild(this, "请输入您的昵称");
                    break;
                }
                bindQianbaoRequestBean.name = name;
                bindQianbaoRequestBean.account = bindAccount;
                bindQianbaoRequestBean.telephone = telephone;
                callback.bindQianbao(bindQianbaoRequestBean, this);
                break;
        }
    }

    @Override
    public void viewMode(Response res, String tag) {
        if (HttpConstant.bindQianbao.equals(tag)) {
            BaseEntity entity = (BaseEntity) res.body();
            String code = entity.getCode();
            if (code.equals("-39")){
                CustomToast.createToast().showFaild(this,"钱包已冻结,请联系客服");
                return;
            }
            CustomToast.createToast().showSuccess(this, "绑定钱包成功");
            finish();
            EventBus.getDefault().post(Constant.ACTIVITY_FINISH);
        }

    }

    @Override
    public void getFalse(boolean tag, String message) {

        if (message.equals(HttpConstant.bindQianbao) && tag) {
            CustomToast.createToast().showFaild(this, "绑定钱包失败，请链接网络");
        }

    }

    @Override
    public void showCode(int code, String string) {

    }
}
