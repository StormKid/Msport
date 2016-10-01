package com.msport.clientmaster.activity;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
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
import com.msport.clientmaster.entity.ChongZhiEntity;
import com.msport.clientmaster.entity.WeiXinPayEntity;
import com.msport.clientmaster.intef.MyViewCallback;
import com.msport.clientmaster.pay.AliPayEntity;
import com.msport.clientmaster.pay.IPay;
import com.msport.clientmaster.pay.InitPayOrderBean;
import com.msport.clientmaster.pay.PayConstant;
import com.msport.clientmaster.pay.PayReal;
import com.msport.clientmaster.pay.PayResult;
import com.msport.clientmaster.pay.WeiXinRequestBean;
import com.msport.clientmaster.util.CustomToast;
import com.msport.clientmaster.util.PublicPreferencesUtils;
import com.msport.clientmaster.util.StringUtil;
import com.msport.clientmaster.view.PubulicPopSingleChoicerDialog;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Response;

/**
 * Created by like on 2016/8/16.
 */
public class QianBaoRealdoActivity extends BaseActivity implements MyViewCallback {

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
    @BindView(R.id.qianbao_choose_paytype)
    LinearLayout qianbaoChoosePaytype;
    @BindView(R.id.qianbao_done_money)
    EditText qianbaoDoneMoney;
    @BindView(R.id.qianbao_request_money)
    TextView qianbaoRequestMoney;
    @BindView(R.id.qianbao_commit)
    TextView qianbaoCommit;
    @BindView(R.id.qianbao_paytype)
    TextView qianbaoPaytype;
    @BindView(R.id.title_up_down)
    ImageView titleUpDown;
    @BindView(R.id.contain_alls)
    LinearLayout containAlls;
    private String qianbao_type;
    private MainCallback mainCallback;
    private String memberId;
    /**
     * 转换成的支付方法
     */
    private String PAYTYPE;
    private Handler handler = new Handler() {

        @Override
        public void handleMessage(Message msg) {

            if (msg.what == PayConstant.ALIPAY_SDK_PAY_FLAG) {
                PayResult result = (PayResult) msg.obj;
                Boolean isSuccess = result.getIsSuccess();
                if (isSuccess) {
                    CustomToast.createToast().showSuccess(context, "支付宝充值成功");
                    finish();
                } else {
                    CustomToast.createToast().showFaild(context, "支付宝充值失败，请检查网络");
                }
            }

        }
    };
    private Context context;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tixian_detail);
        ButterKnife.bind(this);
        context = this;
        mainCallback = new MainCallback(this, this);
        initView();
    }

    private void initView() {
        isqianbao = true;
        containAlls.setBackgroundColor(ContextCompat.getColor(context,R.color.white));
        String qian = getIntent().getStringExtra("qian");
        qianbao_type = getIntent().getStringExtra(Constant.QIANBAO_TYPE);
        memberId = PublicPreferencesUtils.getString(this, Constant.NUTZER_ID);
        shareBlack.setVisibility(View.GONE);
        switch (qianbao_type) {
            case "1":
                mainTitle.setText("充值");
                qianbaoRequestMoney.setVisibility(View.GONE);
                break;
            case "2":
                mainTitle.setText("提现");
                break;

        }
        qianbaoRequestMoney.setText("钱包可用余额：" + qian);
        qianbaoDoneMoney.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                StringUtil.editPoint(qianbaoDoneMoney, charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {


            }
        });


    }

    @OnClick({R.id.back_black, R.id.qianbao_choose_paytype, R.id.qianbao_commit})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_black:
                finish();
                break;
            case R.id.qianbao_choose_paytype:
                PubulicPopSingleChoicerDialog dialog = new PubulicPopSingleChoicerDialog(this, Constant.QIANBAO_TYPE);
                dialog.setBirthdayListener(new PubulicPopSingleChoicerDialog.OnBirthListener() {
                    @Override
                    public void onClick(String value) {
                        qianbaoPaytype.setText(value);

                    }
                });
                dialog.show();
                break;
            case R.id.qianbao_commit:
                String money = qianbaoDoneMoney.getText().toString().trim();
                if (TextUtils.isEmpty(money)) {
                    CustomToast.createToast().showFaild(this, "请输入您所要交易的金额");
                    return;
                }
                String payType = qianbaoPaytype.getText().toString().trim();
                if (payType.equals("微信")) {
                    PAYTYPE = "1";
                } else {
                    PAYTYPE = "2";
                }
                if (qianbao_type.equals("1")) {
                    mainCallback.goChongZhi(memberId, "5", StringUtil.multipInt(money, "100") + "", this);
                } else {
                    mainCallback.goTiXian(memberId, "6", StringUtil.multipInt(money, "100") + "", this, PAYTYPE);
                }
                break;
        }
    }

    @Override
    public void viewMode(Response res, String tag) {

        if (tag.equals(HttpConstant.chongZhi)) {
            ChongZhiEntity entity = (ChongZhiEntity) res.body();
            ChongZhiEntity.DataBean data = entity.getData();
            String amount = data.getAmount();
           String price = StringUtil.multipString(amount, "100");
            switch (PAYTYPE) {
                case "1"://微信支付
                    mainCallback.prePay(data.getBillid());
                    break;
                case "2":// 支付宝支付
                    InitPayOrderBean bean = new InitPayOrderBean();
                    bean.setAmount(price);
                    bean.setCustomerAddress("充值订单");
                    bean.setName("充值订单");
                    bean.setBillid(data.getBillid());
                    mainCallback.aliPay(bean, this);
                    break;
            }


        } else if (tag.equals(HttpConstant.alipay)) {
            AliPayEntity e = (AliPayEntity) res.body();
            String url = e.getData();
            IPay pay = PayReal.creatPayMethod(Constant.PayType_ZhiFuBao, null, this, handler, url);
        } else if (tag.equals(HttpConstant.weiPropay)) {
            WeiXinPayEntity entity = (WeiXinPayEntity) res.body();
            WeiXinPayEntity.DataBean data = entity.getData();
            WeiXinRequestBean bean = new WeiXinRequestBean();
            bean.setPrepayId(data.getPrepay_id());
            IPay iPay = PayReal.creatPayMethod(Constant.PayType_WeiXin, bean, this, handler, null);
            iPay.Pay();
        } else if (tag.equals(HttpConstant.tiXian)) {
            CustomToast.createToast().showSuccess(this, "提现成功，我们会在三天内完成交易");
            finish();
        }


    }

    @Override
    public void getFalse(boolean tag, String message) {

        if (message.equals(HttpConstant.chongZhi)) {
            CustomToast.createToast().showFaild(this, "充值订单失败，请重新生成订单");
        }else {
            CustomToast.createToast().showFaild(this,"钱包操作不成功，请检查网络或直接咨询客服");
        }


    }

    @Override
    public void showCode(int code, String string) {

    }
}
