package com.msport.clientmaster.wxapi;

import android.os.Bundle;

import com.google.gson.Gson;
import com.msport.clientmaster.R;
import com.msport.clientmaster.bean.WXscreatBean;
import com.msport.clientmaster.callback.MainCallback;
import com.msport.clientmaster.constants.Constant;
import com.msport.clientmaster.constants.HttpConstant;
import com.msport.clientmaster.intef.MyViewCallback;
import com.msport.clientmaster.util.CustomToast;
import com.tencent.mm.sdk.modelbase.BaseReq;
import com.tencent.mm.sdk.modelbase.BaseResp;
import com.tencent.mm.sdk.modelmsg.SendAuth;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.WXAPIFactory;
import com.umeng.socialize.weixin.view.WXCallbackActivity;

import org.simple.eventbus.EventBus;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Response;


/**
 * Created by like on 2016/8/30.
 */

public class WXEntryActivity extends WXCallbackActivity implements MyViewCallback {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_none);
        IWXAPI wxapi = WXAPIFactory.createWXAPI(this, Constant.WEIXIN_APPID, true);
        wxapi.handleIntent(getIntent(), this);
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void onReq(BaseReq baseReq) {

    }

    @Override
    public void onResp(BaseResp baseResp) {
        String code = null;
        switch (baseResp.errCode) {
            case BaseResp.ErrCode.ERR_OK://用户同意,只有这种情况的时候code是有效的
                if (baseResp instanceof SendAuth.Resp){
                code = ((SendAuth.Resp) baseResp).code;
                MainCallback callback = new MainCallback(this, this);
                callback.getScreate(code);
                }else {
                    finish();
                    CustomToast.createToast().showSuccess(this, "微信分享成功");
                }
                break;
            case BaseResp.ErrCode.ERR_AUTH_DENIED://用户拒绝授权
                if (baseResp instanceof SendAuth.Resp){
                CustomToast.createToast().showFaild(this, "用户拒绝授权");
                }
                finish();
                break;
            case BaseResp.ErrCode.ERR_USER_CANCEL://用户取消
                if (baseResp instanceof SendAuth.Resp){
                CustomToast.createToast().showFaild(this, "用户取消");}
                finish();
                break;
            default://发送返回
                finish();
                break;
        }


    }

    @Override
    public void viewMode(Response res, String tag) {
        if (tag.equals(HttpConstant.getWxScreate)) {
            ResponseBody body = (ResponseBody) res.body();
            String bode;
            try {
                bode = body.string();
            } catch (IOException e) {
                bode = "";
            }
            Gson gson = new Gson();
            WXscreatBean bean = gson.fromJson(bode, WXscreatBean.class);
            EventBus.getDefault().post(bean,Constant.WXSCBEAN);
            finish();
        }

    }

    @Override
    public void getFalse(boolean tag, String message) {

        if (message.equals(HttpConstant.getWxScreate)) {
            CustomToast.createToast().showFaild(this,"登陆网络异常，请检查网络连接");
            finish();
        }

    }

    @Override
    public void showCode(int code, String string) {

    }
}
