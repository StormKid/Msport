package com.msport.clientmaster.activity;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.msport.clientmaster.R;
import com.msport.clientmaster.base.BaseActivity;
import com.msport.clientmaster.bean.LoadBean;
import com.msport.clientmaster.callback.MainCallback;
import com.msport.clientmaster.constants.Constant;
import com.msport.clientmaster.constants.HttpConstant;
import com.msport.clientmaster.intef.MyViewCallback;
import com.msport.clientmaster.util.CustomToast;
import com.msport.clientmaster.util.PublicPreferencesUtils;
import com.msport.clientmaster.util.Tools;
import com.msport.clientmaster.util.UpdateManage;
import com.msport.clientmaster.util.ViewUtil;
import com.msport.clientmaster.view.TwoButtomDialog;

import org.simple.eventbus.Subscriber;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.ResponseBody;
import retrofit2.Response;

/**
 * Created by like on 2016/9/1.
 */

public class WelComeActivity extends BaseActivity implements MyViewCallback {

    @BindView(R.id.wel_other_in)
    ImageView welOtherIn;
    @BindView(R.id.wel_first_in)
    RelativeLayout welFirstIn;
    @BindView(R.id.wel_login)
    TextView welLogin;
    @BindView(R.id.wel_registe)
    TextView welRegiste;
    @BindView(R.id.wel_tomain)
    TextView welTomain;
    private boolean isfirst;
    private boolean startMain = true;
    private final int REQUEST_CODE_CONTACT = -1211;


    private int SETINTO_MAIN = -1001;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == SETINTO_MAIN) {
                if (startMain) {

                    Intent intent = new Intent(context, MainActivity.class);
                    startActivity(intent);
                    finish();
                    context.overridePendingTransition(R.anim.fade,
                            R.anim.hold);
                }

            }
        }
    };
    private Activity context;
    private String apkUrl;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        ButterKnife.bind(this);
        context = this;
        MainCallback callback = new MainCallback(this, this);
        callback.getDownload(false);
        initView();
    }

    private void initView() {
        isfirst = PublicPreferencesUtils.getBoolean(context, Constant.IS_FIRST);
        if (!isfirst) {
            welOtherIn.setVisibility(View.GONE);
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    handler.obtainMessage(SETINTO_MAIN).sendToTarget();
                }
            }, 7000);
        } else {
            welFirstIn.setVisibility(View.GONE);
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    handler.obtainMessage(SETINTO_MAIN).sendToTarget();
                }
            }, 2500);
        }

    }


    @OnClick({R.id.wel_login, R.id.wel_registe, R.id.wel_tomain})
    public void onClick(View view) {
        Intent intent = new Intent();
        startMain = false;
        switch (view.getId()) {
            case R.id.wel_login:
                intent.setClass(context, LoginActivity.class);
                intent.putExtra(Constant.WELL_COME,"1");
                startActivity(intent);
                finish();
                break;
            case R.id.wel_registe:
                intent.setClass(context, RegisteActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.wel_tomain:
                intent.setClass(context, MainActivity.class);
                startActivity(intent);
                finish();
                break;
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        handler.removeMessages(SETINTO_MAIN);

    }

    @Override
    public void viewMode(Response res, String tag) {
        ResponseBody body = (ResponseBody) res.body();
        String response = null;
        try {
            response = body.string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Gson gson = new Gson();
        LoadBean bean = gson.fromJson(response, LoadBean.class);
        apkUrl = bean.apkUrl;
        String version = bean.version;
        String appVersion = Tools.getAppVersion(this);
        if (appVersion.equals(version)) {
            handler.obtainMessage(SETINTO_MAIN);
        } else {
            startMain = false;
            ViewUtil.createTwoDialog(this, "当前有版本更新，为了有更好的体验，请您下载", "下载", new TwoButtomDialog.OnPositiveButtonDialog() {
                @Override
                public void positiveMethod() {
                    if (Build.VERSION.SDK_INT >= 23) {
                        String[] permisstions = {Manifest.permission.WRITE_EXTERNAL_STORAGE};
                        for (String str : permisstions) {
                            if (WelComeActivity.this.checkSelfPermission(str) != PackageManager.PERMISSION_GRANTED) {
                                WelComeActivity.this.requestPermissions(permisstions, REQUEST_CODE_CONTACT);
                                return;
                            }else {
                                loadNewFile(apkUrl);
                                return;
                            }
                        }
                    } else {
                        loadNewFile(apkUrl);
                    }
                }
            }, false);
        }

    }

    @Override
    public void getFalse(boolean tag, String message) {
//            CustomToast.createToast().showFaild(context,"网络不给力，请检查网络连接");
        //TODO
    }

    @Override
    public void showCode(int code, String string) {

    }


    private void loadNewFile(String url) {
        UpdateManage update = new UpdateManage(context, HttpConstant.MAIN_LOAD + url);
        update.showDownloadDialog();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case REQUEST_CODE_CONTACT: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    loadNewFile(apkUrl);
                } else {
                    CustomToast.createToast().showFaild(context,"为了保证正常使用，请为此应用开通存储权限");
                }
                return;
            }

        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);


    }


    @Subscriber(tag = "loadDown")
    public void getDown(String string){
        finish();
    }
}
