package com.msport.clientmaster.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
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
import com.msport.clientmaster.requestbean.ReserPwdRequestBean;
import com.msport.clientmaster.util.CustomToast;
import com.msport.clientmaster.util.ShaUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Response;

/**
 * Created by like on 2016/8/29.
 */
public class RegisteResultActivity extends BaseActivity implements MyViewCallback{

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
    @BindView(R.id.pwd_do)
    EditText pwdDo;
    @BindView(R.id.pwd_pwd)
    EditText pwdPwd;
    @BindView(R.id.pwd_start)
    Button pwdStart;
    private String yanzhengma;
    private String telephone;
    private MainCallback callback;
    private String change_pwd;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registe_result);
        ButterKnife.bind(this);
        initView();
        yanzhengma = getIntent().getStringExtra(Constant.YANZHEMGMA);
        telephone = getIntent().getStringExtra(Constant.TELEPHONE);
        change_pwd = getIntent().getStringExtra("change_pwd");
        callback = new MainCallback(this,this);

    }

    private void initView() {
        shareBlack.setVisibility(View.GONE);
        mainTitle.setText("创建密码");

    }


    @OnClick({R.id.back_black, R.id.pwd_start})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_black:
                finish();
                break;
            case R.id.pwd_start:
                String prePwd = pwdDo.getText().toString().trim();
                String pwdDone = pwdPwd.getText().toString().trim();
                if (prePwd.equals(pwdDone)) {
                    if (change_pwd!=null){
                        ReserPwdRequestBean bean = new ReserPwdRequestBean();
                        bean.password = ShaUtil.SHA1(pwdDone);
                        bean.telephone = telephone;
                        bean.vcode = yanzhengma;
                        callback.resetPwd(bean);
                    }else {
                        RegisterRequestBean bean = new RegisterRequestBean();
                        bean.name = "";
                        bean.password = ShaUtil.SHA1(pwdDone);
                        bean.telephone = telephone;
                        bean.vcode = yanzhengma;
                        callback.register(bean);

                    }

                }else {
                    CustomToast.createToast().showFaild(this,"两次密码不一致，请重新输入");
                }

                break;
        }
    }

    @Override
    public void viewMode(Response res, String tag) {
        if (tag.equals(HttpConstant.register)){
            BaseEntity entity = (BaseEntity) res.body();
            String code = entity.getCode();
            if (code.equals("-4")){
                CustomToast.createToast().showFaild(this,"您使用的验证码失效");
                return;
            }
            CustomToast.createToast().showSuccess(this,"恭喜您，注册成功");
            Intent intent = new Intent(this,LoginActivity.class);
            intent.putExtra(Constant.WELL_COME,"2");
            startActivity(intent);

        }else if (tag.equals(HttpConstant.reset_pwd)){
            BaseEntity entity = (BaseEntity) res.body();
            String code = entity.getCode();
            if (code.equals("-4")){
                CustomToast.createToast().showFaild(this,"验证码超时");
                return;
            }
            CustomToast.createToast().showSuccess(this,"恭喜您，修改密码成功");
            Intent intent = new Intent(this,LoginActivity.class);
            startActivity(intent);
        }

    }

    @Override
    public void getFalse(boolean tag, String message) {
        CustomToast.createToast().showFaild(this,"网络不给力，请检查网络连接");
    }

    @Override
    public void showCode(int code, String string) {

    }
}
