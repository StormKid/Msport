package com.msport.clientmaster.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.msport.clientmaster.R;
import com.msport.clientmaster.base.BaseActivity;
import com.msport.clientmaster.callback.MainCallback;
import com.msport.clientmaster.constants.Constant;
import com.msport.clientmaster.constants.HttpConstant;
import com.msport.clientmaster.entity.BaseEntity;
import com.msport.clientmaster.entity.CoachOrderEntity;
import com.msport.clientmaster.entity.CourseOrderEntity;
import com.msport.clientmaster.entity.MenPiaoOrderEntity;
import com.msport.clientmaster.entity.ProyueqiuPayEntity;
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
import com.msport.clientmaster.util.ViewUtil;
import com.msport.clientmaster.view.TwoButtomDialog;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Response;

/**
 * Created by like on 2016/8/1.
 */

public class OrderPayActivity extends BaseActivity implements MyViewCallback {

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
    @BindView(R.id.order_id)
    TextView orderId;
    @BindView(R.id.order_name)
    TextView orderName;
    @BindView(R.id.order_member)
    TextView orderMember;
    @BindView(R.id.order_price)
    TextView orderPrice;
    @BindView(R.id.order_qianbao)
    LinearLayout orderQianbao;
    @BindView(R.id.order_weixin)
    LinearLayout orderWeixin;
    @BindView(R.id.order_zhifubao)
    LinearLayout orderZhifubao;
    @BindView(R.id.title_up_down)
    ImageView titleUpDown;
    @BindView(R.id.textView3)
    TextView textView3;
    @BindView(R.id.contain_alls)
    ViewGroup containAlls;
    private MainCallback callback;
    private String billid;
    private InitPayOrderBean bean = new InitPayOrderBean();
    private Context context;
    private String name;
    private String number;
    private String amount;
    private Handler hander = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == PayConstant.ALIPAY_SDK_PAY_FLAG) {
                PayResult result = (PayResult) msg.obj;
                Boolean isSuccess = result.getIsSuccess();
                if (isSuccess) {
                    baseBillId = null;
                    Intent intent = new Intent(context, OrderDetailActivity.class);
                    intent.putExtra(Constant.ORDER_TYPE, orderRealType);
                    intent.putExtra(Constant.BILL_ID, billid);
                    startActivity(intent);
                } else {
                    CustomToast.createToast().showFaild(context, "支付宝支付失败");
                }
            }
        }
    };
    /**
     * 订单生成的订单类型转换
     * 0、课程订单 ， 1、私教订单 ， 2、约球订单 ， 3、比赛订单 ，4、门票订单
     */
    private String orderRealType;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_pay);
        ButterKnife.bind(this);
        callback = new MainCallback(this, this);
        context = this;
        containAlls.setBackgroundColor(ContextCompat.getColor(this,R.color.white));
        initData();
    }

    private void initData() {
        String orderType = getIntent().getStringExtra(Constant.ORDER_TYPE);
        String renshu = getIntent().getStringExtra("renshu");
        String realPay = getIntent().getStringExtra("RealPay");
        String aDo = getIntent().getStringExtra("do");// 是否从订单详情过来支付
        amount = realPay;
        mainTitle.setText("订单支付");
        shareBlack.setVisibility(View.GONE);
        isqianbao = false;
        if (TextUtils.isEmpty(aDo)){
        switch (orderType) {
            case Constant.YUEQIU_ORDER:
                ProyueqiuPayEntity entity = (ProyueqiuPayEntity) getIntent().getSerializableExtra(Constant.ENTITY_PAY);
                ProyueqiuPayEntity.DataBean data = entity.getData();
                billid = data.getBillid();
                name = data.getName();
                number = renshu;
                orderRealType = Constant.YUEQIU_ORDER;
                break;
            case Constant.COUSE_TYPE:
                CourseOrderEntity.DataBean courseData = (CourseOrderEntity.DataBean) getIntent().getSerializableExtra(Constant.COURSE_PAY);
                billid = courseData.getBillId();
                name = courseData.getName();
                if (null == courseData.getTotalMember()) number = "1";
                else number = renshu;
                orderRealType = Constant.COUSE_TYPE;
                break;
            case Constant.COACH_TYPE:
                CoachOrderEntity.DataBean coachBean = (CoachOrderEntity.DataBean) getIntent().getSerializableExtra(Constant.COACH_PAY);
                billid = coachBean.getBillid();
                number = "1";
                name = coachBean.getName();
                orderRealType = Constant.COACH_TYPE;
                break;
            case Constant.MENPIAO_PAY:
                MenPiaoOrderEntity.DataBean.BillInfoBean bean = (MenPiaoOrderEntity.DataBean.BillInfoBean) getIntent().getSerializableExtra(Constant.MENPIAO_DETAIL);
                number = renshu;
                name = bean.getName();
                billid = bean.getBillid();
                orderRealType = Constant.MENPIAO_DETAIL;
                break;
            case Constant.BISAI_TYPE:
                ProyueqiuPayEntity payEntity = (ProyueqiuPayEntity) getIntent().getSerializableExtra(Constant.ENTITY_PAY);
                ProyueqiuPayEntity.DataBean paydata = payEntity.getData();
                billid = paydata.getBillid();
                name = paydata.getName();
                number = paydata.getNumber();
                amount = paydata.getAmount();
                orderRealType = Constant.BISAI_TYPE;
                break;
        }

        }else{
            billid = aDo;
            number = renshu;
            amount = realPay;
        }
        orderId.setText(billid);
        orderMember.setText(number + "人");
        orderPrice.setText("¥" + amount);
        orderName.setText(name);
        baseBillId = billid;
        billType = orderRealType;
    }

    @OnClick({R.id.order_qianbao, R.id.order_weixin, R.id.order_zhifubao, R.id.back_black})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.order_qianbao:
                ViewUtil.createTwoDialog(context, "是否使用钱包支付", "确定", new TwoButtomDialog.OnPositiveButtonDialog() {
                    @Override
                    public void positiveMethod() {
                        callback.qianbaoFinish(billid,"-1");
                    }
                },true);
                break;
            case R.id.order_weixin:
                callback.prePay(billid);
                break;
            case R.id.order_zhifubao:
                bean.setBillid(billid);
                bean.setAmount(amount);
                bean.setName(name);
                bean.setCustomerAddress("微动体育订单：" + name);
                callback.aliPay(bean, this);
                break;
            case R.id.back_black:
                finish();
                break;
        }
    }

    @Override
    public void viewMode(Response res, String tag) {
        Intent intent = new Intent(context, OrderDetailActivity.class);
        switch (tag) {
            case HttpConstant.weiPropay:
                WeiXinPayEntity entity = (WeiXinPayEntity) res.body();
                WeiXinPayEntity.DataBean data = entity.getData();
                String appid = data.getAppid();
                String prepay_id = data.getPrepay_id();
                String trade_type = data.getTrade_type();
                WeiXinRequestBean wbean = new WeiXinRequestBean();
                wbean.setPrepayId(prepay_id);
                IPay iPay = PayReal.creatPayMethod(Constant.PayType_WeiXin, wbean, this, null, null);
                iPay.Pay();
                if (entity.getCode().equals("38")) {
                    CustomToast.createToast().showFaild(context, "您报的课程已报满");
                }
                break;

            case HttpConstant.alipay:
                AliPayEntity e = (AliPayEntity) res.body();
                String eData = e.getData();
                PayReal.creatPayMethod(Constant.PayType_ZhiFuBao, bean, this, hander, eData);
                break;
            case HttpConstant.qianbaoFinish:
                BaseEntity eqian  = (BaseEntity) res.body();
                String code = eqian.getCode();
                if (code.equals("-63")){
                    CustomToast.createToast().showFaild(context,"钱包未绑定");
                    return;
                }
                baseBillId = null;
                CustomToast.createToast().showSuccess(context,"钱包支付完成");
                intent.putExtra(Constant.ORDER_TYPE, orderRealType);
                intent.putExtra(Constant.BILL_ID, billid);
                startActivity(intent);
                break;

        }


    }

    @Override
    public void getFalse(boolean tag, String message) {
        if (message.equals(HttpConstant.alipay)) {
            CustomToast.createToast().showFaild(this, "支付宝生成支付订单失败，请检查网络连接");
        } else if (message.equals(HttpConstant.weiPropay)) {
            CustomToast.createToast().showFaild(this, "微信生成支付订单失败，请检查网络连接");
        } else if (message.equals(HttpConstant.qianbaoFinish)) {
            CustomToast.createToast().showFaild(this, "钱包生成支付订单失败，请检查网络连接");
        }else {
            CustomToast.createToast().showFaild(this,"支付失败，请检查网络连接");
        }
    }

    @Override
    public void showCode(int code, String string) {

    }
}
