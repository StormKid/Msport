package com.msport.clientmaster.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.msport.clientmaster.activity.LoginActivity;
import com.msport.clientmaster.activity.RegisteActivity;
import com.msport.clientmaster.callback.AutLoginCallback;
import com.msport.clientmaster.constants.Constant;
import com.msport.clientmaster.util.PublicPreferencesUtils;
import com.msport.clientmaster.util.ViewUtil;
import com.msport.clientmaster.view.TwoButtomDialog;
import com.umeng.analytics.MobclickAgent;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import org.simple.eventbus.EventBus;

/**
 * Created by like on 2016/6/29.
 * activity基类，用于注册相关组件
 */

public class BaseActivity extends AppCompatActivity {

    private UMShareAPI shareAPI;
    protected static String baseBillId;
    protected static String billType;
    protected static boolean isqianbao;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);
        shareAPI = UMShareAPI.get(this.getApplicationContext());
    }

    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }


    protected synchronized  void  checkMember(final Context context){
        boolean userFirst = PublicPreferencesUtils.getBoolean(context,Constant.USER_FIRST);
        if (userFirst){// true 为登陆了，false为未登陆
            checkPhone(context);
        }else {
            ViewUtil.createTwoDialog(context, "您还尚未登陆，是否登陆", "确定", new TwoButtomDialog.OnPositiveButtonDialog() {
                @Override
                public void positiveMethod() {
                    Intent intent = new Intent();
                    intent.setClass(context, LoginActivity.class);
                    startActivity(intent);
                }
            }, true);
        }
    }


    /**
     * 判断用户是否有电话
     * @param context
     */
    protected  synchronized void checkPhone (final Context context){
        String telephone = PublicPreferencesUtils.getString(context, Constant.NUTZER_TELEPHONE);
        if (TextUtils.isEmpty(telephone)){
            ViewUtil.createTwoDialog(context, "您还尚未绑定手机号，请绑定", "确定", new TwoButtomDialog.OnPositiveButtonDialog() {
                @Override
                public void positiveMethod() {
                    Intent intent = new Intent();
                    intent.setClass(context,RegisteActivity.class);
                    intent.putExtra("auto","QQxWX");
                    startActivity(intent);
                }
            },true);
        }else {
            Do();
        }

    }

    protected synchronized void Do() {
        /**
         * 如果有判断是否登陆的信息的时候必须重写此方法
         */
    }


    /**
     * 注册第三方登陆
     *
     * @param plantinfo
     */
    protected boolean initYouLogin(SHARE_MEDIA plantinfo,
                                   AutLoginCallback callback,Activity context) {
        shareAPI.doOauthVerify(context, plantinfo, callback);
        boolean install = shareAPI.isInstall(context, plantinfo);
        return install;
    }

    protected void onPause() {
        super.onPause();
        MobclickAgent.onPause(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        shareAPI.onActivityResult(requestCode, resultCode, data);

    }

    @Override
    protected void onResume() {
        super.onResume();
        MobclickAgent.onResume(this);
    }



    @Override
    public Resources getResources() {
        Resources res = super.getResources();
        Configuration config=new Configuration();
        config.setToDefaults();
        res.updateConfiguration(config,res.getDisplayMetrics() );
        return res;

    }




    //页面跳转
    public void startActivity(Class<?> className){
        Intent intent = new Intent(this,className);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
    //页面带参数跳转
    public void startActivity(Class<?> className,String[] flags,String[] values){
        Intent intent = new Intent(this,className);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        if(flags != null && flags.length > 0){
            for(int i=0;i<flags.length;i++){
                intent.putExtra(flags[i], values[i]);
            }
        }
        startActivity(intent);
    }

    /** 点击空白隐藏软键盘 */
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev)
    {
        if (ev.getAction() == MotionEvent.ACTION_DOWN)
        {

            // 获得当前得到焦点的View，一般情况下就是EditText（特殊情况就是轨迹求或者实体案件会移动焦点）
            View v = getCurrentFocus();

            if (isShouldHideInput(v, ev))
            {
                hideSoftInput(v.getWindowToken());
            }
        }
        return super.dispatchTouchEvent(ev);
    }

    /**
     * 根据EditText所在坐标和用户点击的坐标相对比，来判断是否隐藏键盘，因为当用户点击EditText时没必要隐藏
     *
     * @param v
     * @param event
     * @return
     */
    private boolean isShouldHideInput(View v, MotionEvent event)
    {
        if (v != null && (v instanceof EditText))
        {
            int[] l = { 0, 0 };
            v.getLocationInWindow(l);
            int left = l[0], top = l[1], bottom = top + v.getHeight(), right = left
                    + v.getWidth();
            return !(event.getX() > left && event.getX() < right
                    && event.getY() > top && event.getY() < bottom);
        }
        // 如果焦点不是EditText则忽略，这个发生在视图刚绘制完，第一个焦点不在EditView上，和用户用轨迹球选择其他的焦点
        return false;
    }

    /**
     * 多种隐藏软件盘方法的其中一种
     *
     * @param token
     */
    private void hideSoftInput(IBinder token)
    {
        if (token != null)
        {
            InputMethodManager im = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            im.hideSoftInputFromWindow(token,
                    InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }




}
