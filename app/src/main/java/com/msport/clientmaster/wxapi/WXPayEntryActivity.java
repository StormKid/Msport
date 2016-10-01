package com.msport.clientmaster.wxapi;

import android.content.Intent;
import android.os.Bundle;

import com.msport.clientmaster.activity.OrderDetailActivity;
import com.msport.clientmaster.base.BaseActivity;
import com.msport.clientmaster.constants.Constant;
import com.msport.clientmaster.pay.PayConstant;
import com.msport.clientmaster.util.CustomToast;
import com.msport.clientmaster.util.LogUtils;
import com.tencent.mm.sdk.constants.ConstantsAPI;
import com.tencent.mm.sdk.modelbase.BaseReq;
import com.tencent.mm.sdk.modelbase.BaseResp;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.sdk.openapi.WXAPIFactory;

/**
 * 微信回调接口
 * @author like
 * 2016-7-8
 */
public class WXPayEntryActivity extends BaseActivity implements IWXAPIEventHandler{

	private IWXAPI api;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		api = WXAPIFactory.createWXAPI(this, PayConstant.WEIXIN_APP_ID);
		api.handleIntent(getIntent(), this);
	}

	@Override
	protected void onNewIntent(Intent intent) {
		super.onNewIntent(intent);
		setIntent(intent);
		api.handleIntent(intent, this);
	}

	@Override
	public void onReq(BaseReq req) {
		switch (req.getType()) {
		case ConstantsAPI.COMMAND_GETMESSAGE_FROM_WX:
			break;
		case ConstantsAPI.COMMAND_SHOWMESSAGE_FROM_WX:
			break;
		case ConstantsAPI.COMMAND_LAUNCH_BY_WX:
			break;
		}
	}

	/**
	 * 微信支付回调
	 */
	@Override
	public void onResp(BaseResp resp) {
		LogUtils.e("WXPAY", "微信支付结果回调: " + resp);
		// 0 成功 展示成功页面
		// -1 错误 可能的原因：签名错误、未注册APPID、项目设置APPID不正确、注册的APPID与设置的不匹配、其他异常等。
		// -2 用户取消 无需处理。发生场景：用户不支付了，点击取消，返回APP。
		if (resp.getType() == ConstantsAPI.COMMAND_PAY_BY_WX) {
			switch (resp.errCode) {
			case 0:
				if (isqianbao){
					CustomToast.createToast().showSuccess(this,"微信支付成功");
					finish();
					return;
				}
				CustomToast.createToast().showSuccess(this,"微信支付成功");
				Intent intent = new Intent(this , OrderDetailActivity.class);
				intent.putExtra(Constant.ORDER_TYPE,billType);
				intent.putExtra(Constant.BILL_ID,baseBillId);
				startActivity(intent);
				break;
			case -1:
				CustomToast.createToast().showFaild(this, "微信支付失败");
				finish();
				break;
			case -2:
				CustomToast.createToast().showFaild(this, "用户取消");
				finish();
				break;
			}
		}
	}

}