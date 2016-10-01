package com.msport.clientmaster.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.msport.clientmaster.R;
import com.msport.clientmaster.base.BaseActivity;
import com.msport.clientmaster.bean.LoginBean;
import com.msport.clientmaster.bean.WXscreatBean;
import com.msport.clientmaster.callback.AutLoginCallback;
import com.msport.clientmaster.callback.MainCallback;
import com.msport.clientmaster.constants.Constant;
import com.msport.clientmaster.constants.HttpConstant;
import com.msport.clientmaster.entity.LoginEntity;
import com.msport.clientmaster.intef.MyViewCallback;
import com.msport.clientmaster.util.CustomToast;
import com.msport.clientmaster.util.PublicPreferencesUtils;
import com.msport.clientmaster.util.ShaUtil;
import com.msport.clientmaster.util.Sptools;
import com.umeng.socialize.bean.SHARE_MEDIA;

import org.simple.eventbus.Subscriber;

import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Response;

/**
 * 用户登陆页面
 *
 * @author like 2016-3-29
 */
public class LoginActivity extends BaseActivity implements MyViewCallback {

    /**
     * 登陸的时候输入的手机号
     */
    @BindView(R.id.login_phone)
    EditText login_phone;

    /**
     * 登陆的时候输入的密码
     */
    @BindView(R.id.login_pwd)
    EditText login_pwd;
    /**
     * 进入忘记密码的页面
     */
    @BindView(R.id.login_lose_pwd)
    TextView login_lose_pwd;

    /**
     * 登陆
     */
    @BindView(R.id.login_start)
    Button login_start;

    /**
     * 注册登陆
     */
    @BindView(R.id.login_to_register)
    TextView login_to_register;
    @BindView(R.id.login_weixin)
    ImageView loginWeixin;
    @BindView(R.id.login_qq)
    ImageView loginQq;
    @BindView(R.id.back_black)
    ImageView backBlack;
    @BindView(R.id.main_title)
    TextView mainTitle;
    @BindView(R.id.share_black)
    ImageView shareBlack;

    private Handler handler = new Handler();
    /**
     *
     */
    private String telephone;
    private String pwd;
    private String extra;
    private MainCallback callback;
    private String welcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        initEvent();
        callback = new MainCallback(this, this);
    }


    private void initEvent() {
        edittextAll(login_phone);
        edittextAll(login_pwd);
        extra = getIntent().getStringExtra("thisPage");
        mainTitle.setText("登陆");
        shareBlack.setVisibility(View.GONE);
        welcome = getIntent().getStringExtra(Constant.WELL_COME);
    }


    @OnClick({R.id.login_lose_pwd, R.id.login_start, R.id.login_to_register, R.id.login_weixin, R.id.login_qq})
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.login_lose_pwd:
			intent.setClass(this, RegisteActivity.class);
                intent.putExtra("change_pwd","cpwd");
			startActivity(intent);
                break;
            case R.id.login_start:
                if (checkInfo()) {
                    String sha = ShaUtil.SHA1(pwd);
                    callback.login(telephone, sha);
                }
                break;
            case R.id.login_to_register:
                intent.setClass(this, RegisteActivity.class);
                startActivity(intent);
                break;
            case R.id.login_weixin:
                initYouLogin(SHARE_MEDIA.WEIXIN, new AutLoginCallback(this) {

                    @Override
                    public void onSuccess(Map<String, String> arg2) {
                        CustomToast.createToast().showSuccess(LoginActivity.this,
                                "登陆成功");
                    }
                }, this);
                break;
            case R.id.login_qq:
                initYouLogin(SHARE_MEDIA.QQ, new AutLoginCallback(this) {

                    @Override
                    public void onSuccess(Map<String, String> arg2) {
                        String openid = arg2.get("openid");
                        String access_token = arg2.get("access_token");
                        callback.autoLoginQQ(openid,access_token, "1");
                    }
                }, this);
                break;

        }
    }

    private boolean checkInfo() {

        telephone = login_phone.getText().toString().trim();
        pwd = login_pwd.getText().toString().trim();
        if (TextUtils.isEmpty(telephone)) {
            CustomToast.createToast().showFaild(this, "请输入您的用户名");
            return false;
        } else if (TextUtils.isEmpty(pwd)) {
            CustomToast.createToast().showFaild(this, "请输入您的密码");
            return false;
        } else if (pwd.length() < 6) {
            CustomToast.createToast().showFaild(LoginActivity.this, "密码需要在6-16位之间");
            return false;
        } else {
            return true;
        }

    }

    private void edittextAll(final EditText et) {
        et.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                et.setSelection(s.length());
            }


        });

    }

    @Override
    public void viewMode(Response res, String tag) {
        Intent intent = new Intent(this,MainActivity.class);
        if (HttpConstant.LOGIN_USER.equals(tag)) {
            LoginEntity loginEntity = (LoginEntity) res.body();
            String code = loginEntity.getCode();
            if (code.equals("-16")){
                CustomToast.createToast().showFaild(this,"您的账户不存在，请注册");
                return;
            }
            CustomToast.createToast().showSuccess(LoginActivity.this, "登陆成功");
            Sptools.putInLogin(this, telephone, pwd);
            PublicPreferencesUtils.putBoolean(this, Constant.USER_FIRST, true);
            Sptools.putInProperties(loginEntity.getData(), this);
            if (null==welcome||TextUtils.isEmpty(welcome)){
                finish();
                return;
            }
            startActivity(intent);
            finish();
        }else if (tag.equals(HttpConstant.userAutoLoginQQ)){
            LoginEntity entity = (LoginEntity) res.body();
            LoginBean data = entity.getData();
            Sptools.putInProperties(data,this);
            String telephone = data.getTelephone();
            PublicPreferencesUtils.putBoolean(this,Constant.USER_FIRST,true);
            intent.putExtra("auto","QQ");
            if (TextUtils.isEmpty(telephone)) {
                intent.setClass(this,RegisteActivity.class);
                startActivity(intent);
            } else {
                if (null==welcome||TextUtils.isEmpty(welcome)){
                    finish();
                    return;
                }
                intent.setClass(this,MainActivity.class);
                startActivity(intent);
            }


        }else if (tag.equals(HttpConstant.userAutoLoginWx)){
            LoginEntity entity = (LoginEntity) res.body();
            LoginBean data = entity.getData();
            Sptools.putInProperties(data,this);
            PublicPreferencesUtils.putBoolean(this,Constant.USER_FIRST,true);
            intent.putExtra("auto","WX");
            String telephone = data.getTelephone();
            if (TextUtils.isEmpty(telephone)) {
                intent.setClass(this,RegisteActivity.class);
                startActivity(intent);
            } else {
                if (null==welcome||TextUtils.isEmpty(welcome)){
                    finish();
                    return;
                }
                intent.setClass(this,MainActivity.class);
                startActivity(intent);
            }
        }
    }

    @Override
    public void getFalse(boolean tag, String message) {
        if (tag) {
            CustomToast.createToast().showFaild(this, "登陆失败，请重试");
        }

    }

    @Override
    public void showCode(int code, String string) {

    }

    @OnClick(R.id.back_black)
    public void onClick() {
        finish();
    }


    @Subscriber(tag = Constant.WXSCBEAN)
    public void getSC (WXscreatBean bean){
        callback.autoLoginWX(bean.getOpenid(),bean.getAccess_token());
    }


}
