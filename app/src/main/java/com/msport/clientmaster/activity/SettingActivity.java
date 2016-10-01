package com.msport.clientmaster.activity;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.msport.clientmaster.R;
import com.msport.clientmaster.base.BaseActivity;
import com.msport.clientmaster.constants.Constant;
import com.msport.clientmaster.util.CustomToast;
import com.msport.clientmaster.util.DataCleanUtil;
import com.msport.clientmaster.util.PublicPreferencesUtils;
import com.msport.clientmaster.util.ViewUtil;
import com.msport.clientmaster.view.TwoButtomDialog;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.jpush.android.api.JPushInterface;

/**
 * Created by like on 2016/8/6.
 */
public class SettingActivity extends BaseActivity {


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
    @BindView(R.id.push_open)
    ImageView pushOpen;
    @BindView(R.id.my_safety)
    LinearLayout mySafety;
    @BindView(R.id.setting_cache)
    TextView settingCache;
    @BindView(R.id.setting_decache)
    LinearLayout settingDecache;
    /////////////////////////////////////////////////////////////
    /**
     * 赐予好评
     */
    @BindView(R.id.setting_about_us)
    LinearLayout settingAboutUs;
    /////////////////////////////////////////////////////////////
    @BindView(R.id.setting_xieyi)
    LinearLayout settingXieyi;
    @BindView(R.id.setting_pingfen)
    LinearLayout settingPingfen;
    @BindView(R.id.exit_member)
    TextView exitMember;
    @BindView(R.id.setting_phone)
    TextView settingPhone;
    @BindView(R.id.contain_alls)
    LinearLayout containAlls;
    private Context context;
    private boolean pushwell;
    private int MY_PERMISSIONS_REQUEST_CALL_PHONE = 0;
    private String phoneNum;

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case GET_DECACHE:
                    settingCache.setText(DataCleanUtil
                            .getTotalCacheSize(context));
                    CustomToast.createToast().showSuccess(context, "您已清理缓存");
            }
        }
    };
    private final int GET_DECACHE = -10086;
    private Intent intent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        ButterKnife.bind(this);
        context = this;
        initView();
    }

    private void initView() {
        shareBlack.setVisibility(View.GONE);
        pushwell = PublicPreferencesUtils.getBoolean(this, Constant.PUSH_WELL);
        if (!pushwell) {
            pushOpen.setImageResource(R.mipmap.on);
        } else {
            pushOpen.setImageResource(R.mipmap.off);
        }
        phoneNum = settingPhone.getText().toString().trim();
        settingCache.setText(DataCleanUtil
                .getTotalCacheSize(context));
        mainTitle.setText("设置");
        containAlls.setBackgroundColor(ContextCompat.getColor(context,R.color.white));

    }

    @OnClick({R.id.back_black, R.id.share_black, R.id.push_open, R.id.my_safety, R.id.setting_decache, R.id.setting_about_us, R.id.setting_xieyi, R.id.setting_pingfen, R.id.exit_member, R.id.setting_phone})
    public void onClick(View view) {
        intent = new Intent();
        switch (view.getId()) {
            case R.id.back_black:
                finish();
                break;
            case R.id.push_open:
                if (pushwell) {
                    pushOpen.setImageResource(R.mipmap.on);
                    pushwell = false;
                    JPushInterface.onResume(getApplicationContext());
                } else {
                    pushOpen.setImageResource(R.mipmap.off);
                    pushwell = true;
                    JPushInterface.onPause(getApplicationContext());
                }
                break;
            case R.id.my_safety:
                intent.setClass(context,SaftyActivity.class);
                startActivity(intent);
                break;
            case R.id.setting_decache:
                ViewUtil.createTwoDialog(context, "是否清理缓存", "确定", new TwoButtomDialog.OnPositiveButtonDialog() {
                    @Override
                    public void positiveMethod() {
                        DataCleanUtil
                                .clearAllCache(context);
                        handler.obtainMessage(GET_DECACHE)
                                .sendToTarget();
                    }
                }, true);
                break;
            case R.id.setting_about_us:
                intent.setClass(this, XieYiActivity.class);
                startActivity(intent);
                break;
            case R.id.setting_xieyi:
                intent.setClass(this, MyAboutActivity.class);
                startActivity(intent);
                break;
            case R.id.setting_pingfen:
                break;
            case R.id.exit_member:
                ViewUtil.createTwoDialog(this, "是否退出当前用户", "确定", new TwoButtomDialog.OnPositiveButtonDialog() {
                    @Override
                    public void positiveMethod() {
                        boolean isLogin = PublicPreferencesUtils.getBoolean(context, Constant.USER_FIRST);
                        boolean removeAll = PublicPreferencesUtils.removeAll(context);
                        if (isLogin) {
                            if (removeAll) {
                                intent.setClass(context, MainActivity.class);
                                startActivity(intent);
                                CustomToast.createToast().showSuccess(context, "退出成功");
                                isLogin = false;
                            } else {
                                CustomToast.createToast().showFaild(context, "退出失败");
                            }
                        }
                        PublicPreferencesUtils.putBoolean(context, Constant.USER_FIRST, isLogin);
                    }
                },true);

                break;
            case R.id.setting_phone:
                toPhoneCall(this, phoneNum);
                break;
        }
    }


    private void toPhoneCall(Activity context, String phone) {
        if (ContextCompat.checkSelfPermission(context,
                Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(context,
                    new String[]{Manifest.permission.CALL_PHONE},
                    MY_PERMISSIONS_REQUEST_CALL_PHONE);
        } else {
            Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phone));
            context.startActivity(intent);
        }

    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == MY_PERMISSIONS_REQUEST_CALL_PHONE) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                toPhoneCall(this, phoneNum);
            } else {
                CustomToast.createToast().showFaild(context, "请开通您的拨打电话的权限");
            }
            return;
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}
