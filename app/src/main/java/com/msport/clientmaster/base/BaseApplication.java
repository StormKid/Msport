package com.msport.clientmaster.base;

import android.app.Application;

import com.msport.clientmaster.constants.Constant;
import com.umeng.socialize.PlatformConfig;

import cn.jpush.android.api.JPushInterface;

/**
 * Created by like on 2016/8/2.
 */

public class BaseApplication extends Application {


    public static boolean GLOBAL_DEBUG;

    static {

        PlatformConfig.setWeixin(Constant.WEIXIN_APPID,
                Constant.WEIXIN_APPSECRET);
        PlatformConfig.setSinaWeibo(Constant.XINLANG_APPID,
                Constant.XINLANG_APPSECRET);
        PlatformConfig.setQQZone(Constant.QQ_APPID, Constant.QQ_APPSECRET);

    }

    @Override
    public void onCreate() {
        super.onCreate();
        JPushInterface.setDebugMode(true);
        JPushInterface.init(this);
    }
}
