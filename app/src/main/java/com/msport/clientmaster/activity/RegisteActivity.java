package com.msport.clientmaster.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
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
import com.msport.clientmaster.requestbean.RegisterRequestBean;
import com.msport.clientmaster.util.CustomToast;
import com.msport.clientmaster.util.PublicPreferencesUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Response;

/**
 * Created by like on 2016/8/13.
 */

public class RegisteActivity extends BaseActivity implements MyViewCallback {

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
    @BindView(R.id.register_phone)
    EditText registerPhone;
    @BindView(R.id.register_pwd)
    EditText registerPwd;
    @BindView(R.id.register_yanzhengma)
    TextView registerYanzhengma;
    @BindView(R.id.register_start)
    Button registerStart;
    private static long currentTIME;
    private final int DAOJISHI = -102;
    @BindView(R.id.register_bpwd)
    EditText registerBpwd;
    @BindView(R.id.register_onepwd)
    LinearLayout registerOnepwd;
    @BindView(R.id.register_check_pwd)
    EditText registerCheckPwd;
    @BindView(R.id.register_checkpwd)
    LinearLayout registerCheckpwd;
    private Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            if (msg.what == DAOJISHI) {
                long nowDate = System.currentTimeMillis();
                long calc = (nowDate - currentTIME) / 1000;
                if (calc >= 60) {
                    registerYanzhengma.setClickable(true);
                    registerYanzhengma.setText("获取验证码");
                    isTrue = false;
                    handler.removeMessages(0);
                } else {
                    registerYanzhengma
                            .setText("" + (60 - calc) + "秒后重新获取");
                    registerYanzhengma.setClickable(false);
                }
                handler.sendEmptyMessageDelayed(DAOJISHI, 1000);
            }
        }
    };
    private MainCallback callback;
    private static boolean isTrue;
    private String auto;
    private String change_pwd;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registe);
        ButterKnife.bind(this);
        callback = new MainCallback(this, this);
        initView();
    }

    private void initView() {
        shareBlack.setVisibility(View.GONE);
        titleRightTv.setVisibility(View.VISIBLE);
        titleRightTv.setText("登陆");
        mainTitle.setText("注册");
        auto = getIntent().getStringExtra("auto");
        change_pwd = getIntent().getStringExtra("change_pwd");
        if (auto != null) {
            titleRightTv.setVisibility(View.GONE);
            mainTitle.setText("绑定手机号");
            registerStart.setText("完成");
        } else if (change_pwd != null) {
            titleRightTv.setVisibility(View.GONE);
            mainTitle.setText("修改密码");
            registerStart.setText("下一步");
        }
    }

    @OnClick({R.id.back_black, R.id.title_right_tv, R.id.register_yanzhengma, R.id.register_start})
    public void onClick(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.back_black:
                finish();
                break;
            case R.id.title_right_tv:
                intent.setClass(this, LoginActivity.class);
                intent.putExtra(Constant.WELL_COME, "2");
                startActivity(intent);
                break;
            case R.id.register_yanzhengma:
                String phone = registerPhone.getText().toString().trim();
                if (TextUtils.isEmpty(phone)) {
                    CustomToast.createToast().showFaild(this, "请输入您的手机号码");
                } else if (phone.length() < 11) {
                    CustomToast.createToast().showFaild(this, "请输入正确的手机号码");
                } else {
                    if (change_pwd != null)
                        callback.getRepwd(phone);
                    else
                        callback.yanzhengmaGet(phone);
                }
                break;
            case R.id.register_start:
                if (isTrue) {
                    String yanzhengma = registerPwd.getText().toString().trim();
                    String telephone = registerPhone.getText().toString().trim();
                    if (TextUtils.isEmpty(yanzhengma) || yanzhengma.length() < 6) {
                        CustomToast.createToast().showFaild(this, "请输入正确的验证码");
                        break;
                    }
                    if (!TextUtils.isEmpty(auto)) {
                        RegisterRequestBean bean = new RegisterRequestBean();
                        bean.name = PublicPreferencesUtils.getString(this, Constant.NUTZER_NAME);
                        bean.telephone = telephone;
                        bean.password = PublicPreferencesUtils.getString(this, Constant.NUTZER_OPENID);
                        bean.vcode = yanzhengma;
                        callback.registerBindTelephone(bean);
                        break;
                    } else if (change_pwd != null) {
                        intent.putExtra("change_pwd", change_pwd);
                    }
                    intent.setClass(this, RegisteResultActivity.class);
                    intent.putExtra(Constant.YANZHEMGMA, yanzhengma);
                    intent.putExtra(Constant.TELEPHONE, telephone);
                    startActivity(intent);
                    isTrue = false;
                }

                break;
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (handler != null) {
            handler.removeMessages(DAOJISHI);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (handler != null)
            handler.sendEmptyMessage(DAOJISHI);
    }

    @Override
    public void viewMode(Response res, String tag) {
        if (tag.equals(HttpConstant.getYanzhengma) || tag.equals(HttpConstant.getSMS_pwdRecode)) {
            BaseEntity entity = (BaseEntity) res.body();
            String code = entity.getCode();
            if (code.equals("-5")) {
                CustomToast.createToast().showFaild(this, "发送过于频繁");
                return;
            } else if (code.equals("-6")) {
                CustomToast.createToast().showFaild(this, "此用户已注册");
                return;
            }
            currentTIME = System.currentTimeMillis();
            handler.sendEmptyMessageDelayed(DAOJISHI, 1000);
            CustomToast.createToast().showSuccess(this, "验证码获取成功");
            isTrue = true;
        } else {
            Intent intent = new Intent(this, MainActivity.class);
            BaseEntity entity = (BaseEntity) res.body();
            if (entity.getCode().equals("-57")) {
                CustomToast.createToast().showFaild(this, "未绑定成功，请重试");
                return;
            }
            CustomToast.createToast().showSuccess(this, "电话号码绑定成功");
            startActivity(intent);
            finish();
        }

    }

    @Override
    public void getFalse(boolean tag, String message) {
        CustomToast.createToast().showFaild(this, "网络不给力，请检查网络连接");
    }

    @Override
    public void showCode(int code, String string) {

    }
}
