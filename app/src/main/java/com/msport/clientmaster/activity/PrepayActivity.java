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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.msport.clientmaster.R;
import com.msport.clientmaster.base.BaseActivity;
import com.msport.clientmaster.bean.CoachLocationBean;
import com.msport.clientmaster.bean.YueQiuDetailBean;
import com.msport.clientmaster.calendar.ChooseDateActivity;
import com.msport.clientmaster.callback.MainCallback;
import com.msport.clientmaster.constants.Constant;
import com.msport.clientmaster.constants.HttpConstant;
import com.msport.clientmaster.entity.BaseEntity;
import com.msport.clientmaster.entity.BisaiListEntity;
import com.msport.clientmaster.entity.CoachOrderEntity;
import com.msport.clientmaster.entity.CourseDetailEntity;
import com.msport.clientmaster.entity.CourseOrderEntity;
import com.msport.clientmaster.entity.CripEntity;
import com.msport.clientmaster.entity.MenPiaoOrderEntity;
import com.msport.clientmaster.entity.ProyueqiuPayEntity;
import com.msport.clientmaster.fragment.OrderButtomFragment;
import com.msport.clientmaster.intef.MyViewCallback;
import com.msport.clientmaster.requestbean.CoachOrderRequestBean;
import com.msport.clientmaster.requestbean.CourseOrderRequestBean;
import com.msport.clientmaster.util.CustomToast;
import com.msport.clientmaster.util.ImageUtil;
import com.msport.clientmaster.util.PublicPreferencesUtils;
import com.msport.clientmaster.util.StringUtil;
import com.msport.clientmaster.util.ViewUtil;
import com.msport.clientmaster.view.MyTagViewGroup;
import com.msport.clientmaster.view.PubulicPopSingleChoicerDialog;

import org.simple.eventbus.Subscriber;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Response;

/**
 * Created by like on 2016/7/29.
 */

public class PrepayActivity extends BaseActivity implements MyViewCallback {


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
    @BindView(R.id.prepay_img)
    ImageView prepayImg;
    @BindView(R.id.prepay_title)
    TextView prepayTitle;
    @BindView(R.id.prepay_content)
    TextView prepayContent;
    @BindView(R.id.prepay_price)
    TextView prepayPrice;
    @BindView(R.id.propay_first_choose_tv)
    TextView propayFirstChooseTv;
    @BindView(R.id.propay_first_choose_tv_to)
    TextView propayFirstChooseTvTo;
    @BindView(R.id.propay_first_choose)
    LinearLayout propayFirstChoose;
    @BindView(R.id.propay_second_choose_tv)
    TextView propaySecondChooseTv;
    @BindView(R.id.propay_second_choose_tv_to)
    TextView propaySecondChooseTvTo;
    @BindView(R.id.propay_second_choose)
    LinearLayout propaySecondChoose;
    @BindView(R.id.prepay_choose_youhui)
    LinearLayout prepayChooseYouhui;
    @BindView(R.id.propay_four_choose_tv)
    TextView propayFourChooseTv;
    @BindView(R.id.propay_four_choose_tv_to)
    TextView propayFourChooseTvTo;
    @BindView(R.id.propay_four_choose)
    LinearLayout propayFourChoose;
    @BindView(R.id.prepay_activity_price)
    TextView prepayActivityPrice;
    @BindView(R.id.prepay_need_price)
    TextView prepayNeedPrice;
    @BindView(R.id.prepay_should_know)
    LinearLayout prepayShouldKnow;
    @BindView(R.id.go_to_pay)
    Button goToPay;
    @BindView(R.id.hint_view)
    View hintView;

    @BindView(R.id.order_finish_type_tv)
    TextView order_finish_type_tv;

    @BindView(R.id.prepay_tag)
    MyTagViewGroup prepay_tag;
    @BindView(R.id.order_finish_total_pay)
    TextView orderFinishTotalPay;
    @BindView(R.id.prepay_choose_youhui_result)
    TextView prepayChooseYouhuiResult;
    @BindView(R.id.title_up_down)
    ImageView titleUpDown;
    @BindView(R.id.contain_alls)
    ViewGroup containAlls;


    private String TAG = "YOUHUIQUAN";
    private MainCallback callback;
    private String memberId;
    private YueQiuDetailBean data;
    /**
     * 1[课程、比赛] 2【私教】 3【约球】 4[门票]
     */
    private String propayType;
    private CourseDetailEntity.DataBean courseBean;
    private String price;

    private boolean isReadyToPay = true;
    private final int checkDone = -111;
    private Handler handler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case checkDone:
                    if (propayFourChooseTvTo.getText().toString().trim().equals("15分钟") || propayFirstChooseTvTo.getText().toString().trim().equals("选择人数")
                            || propayFirstChooseTvTo.equals("进入选择") || propaySecondChooseTvTo.equals("进入选择")) {
                        hintView.setVisibility(View.VISIBLE);
                        return;
                    } else {
                        hintView.setVisibility(View.GONE);
                    }
                    break;
            }
        }
    };
    private CourseOrderRequestBean courseOrderRequestBean;
    private CoachOrderRequestBean coachOrderRequestBean;
    private String memberNum = "";
    private String menpiaoId;
    private String coursetype;
    private CripEntity.DataBean crips;
    private Intent intent;
    private String coachId;
    private CoachLocationBean coachLocationBean;
    private Context context;
    private int length;
    private String resultPrice;
    private String dataId;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_queren_order);
        ButterKnife.bind(this);
        context = this;
        intent = new Intent(this, OrderPayActivity.class);
        detailTitleChange.setBackgroundColor(ContextCompat.getColor(this, R.color.white));
        callback = new MainCallback(this, this);
        titleRightTv.setVisibility(View.GONE);
        shareBlack.setVisibility(View.GONE);
        mainTitle.setText("确认订单");
        memberId = PublicPreferencesUtils.getString(this, Constant.NUTZER_ID);
        propayType = getIntent().getStringExtra(Constant.PROPAY_TYPE);
        containAlls.setBackgroundColor(ContextCompat.getColor(this, R.color.white));
        propayFirstChooseTvTo.setText("1人");
        propayFourChooseTvTo.setText("15分钟");

        memberNum = "1";
        switch (propayType) {
            case "1":
                initCourse();
                break;
            case "2":
                initCoah();
                break;
            case "3":
                initEvent();
                break;
            case "4":
                initMenPiao();
                break;
            case "5":
                initBisai();
                break;

        }
        resultPrice = price;
    }

    private void initBisai() {

        BisaiListEntity.DataBean data = (BisaiListEntity.DataBean) getIntent().getSerializableExtra("BisaiBean");
        propaySecondChoose.setVisibility(View.GONE);
        String fees = data.getFees();
        propayFourChoose.setVisibility(View.GONE);
        prepayChooseYouhui.setVisibility(View.GONE);
        price = fees;
        String name = data.getName();
        dataId = data.getId();
        String customName = data.getCustomName();
        prepayTitle.setText(name);
        prepayContent.setText(customName);
        prepayPrice.setText("¥" + price);
        prepayActivityPrice.setText("¥" + price);
        propayFirstChooseTv.setText("报名人数");
        orderFinishTotalPay.setText("总计¥" + price);
        String imageUrl = StringUtil.getRealImgUrl(data.getAvatarList());
        ImageUtil.getNetImage(this, imageUrl, prepayImg);
    }

    /**
     * 门票
     */
    private void initMenPiao() {
        menpiaoId = getIntent().getStringExtra(Constant.MENPIAO_ID);
        price = getIntent().getStringExtra(Constant.PRICE);
        String address = getIntent().getStringExtra("address");
        String imageUrl = getIntent().getStringExtra("imageUrl");
        String name = getIntent().getStringExtra("name");
        propayFirstChoose.setVisibility(View.GONE);
        propayFirstChooseTv.setText("报名人数");
        propayFourChooseTv.setText("课程提醒");
        propayFourChooseTvTo.setText("15分钟");
        orderFinishTotalPay.setText("¥" + price);
        propaySecondChoose.setVisibility(View.GONE);
        prepayPrice.setText("¥" + price);
        prepayActivityPrice.setText("¥" + price);
        prepayTitle.setText(name);
        prepayContent.setText("场馆：" + address);
        ImageUtil.getNetImage(this, imageUrl, prepayImg);

    }

    /**
     * 私教
     */
    private void initCoah() {
        coachLocationBean = (CoachLocationBean) getIntent().getSerializableExtra(Constant.COACH_LOCATION);
        coachId = getIntent().getStringExtra(Constant.COACH_ID);
        price = coachLocationBean.price;
        propayFirstChooseTv.setText("地址选择");
        propayFirstChooseTvTo.setText("进入选择");
        propaySecondChooseTv.setText("时间选择");
        propaySecondChooseTvTo.setText("进入选择");
        prepayContent.setVisibility(View.GONE);
        List<String> tagList = new ArrayList<>();
        tagList.add("阳光");
        tagList.add("负责");
        tagList.add("棒棒哒");
        ViewUtil.createTextview(prepay_tag, this, tagList, false, null, null);
        coachOrderRequestBean = new CoachOrderRequestBean();
        propayFourChooseTv.setText("课程提醒");
        propayFourChooseTvTo.setText("15分钟");
        orderFinishTotalPay.setText("总计¥" + price);
        prepayActivityPrice.setText("¥" + price);
        prepayPrice.setText("¥" + price);
        ImageUtil.getNetImage(this, coachLocationBean.realUrl, prepayImg);
        coachOrderRequestBean.setCoachId(coachId);
        coachOrderRequestBean.setName(coachLocationBean.name);
        coachOrderRequestBean.setAmount(price);
        coursetype = coachLocationBean.courseType;
        coachOrderRequestBean.setPayerId(memberId);
        coachOrderRequestBean.setPaymentmode("1");
        prepayTitle.setText(coachLocationBean.name);

    }

    /**
     * 课程
     */
    private void initCourse() {
        courseBean = (CourseDetailEntity.DataBean) getIntent().getSerializableExtra(Constant.COURSE_DETAIL);
        String name = courseBean.getName();
        price = courseBean.getPrice();
        String comment = courseBean.getComment();
        String courseimage = courseBean.getCourseimage();
        String realImgUrl = StringUtil.getRealImgUrl(courseimage);
        coursetype = courseBean.getCoursetype();
        ImageUtil.getNetImage(this, realImgUrl, prepayImg);
        prepayContent.setText(comment);
        order_finish_type_tv.setText("课程价格");
        propaySecondChoose.setVisibility(View.GONE);
        prepay_tag.setVisibility(View.GONE);
        prepayPrice.setText("¥" + price);
        prepayActivityPrice.setText("¥" + price);
        prepayTitle.setText(name);
        propayFirstChooseTv.setText("报名人数");
        propayFourChooseTv.setText("课程提醒");
        propayFourChooseTvTo.setText("15分钟");
        orderFinishTotalPay.setText("总计¥" + price);
        courseOrderRequestBean = CourseOrderRequestBean.getInstance();
        courseOrderRequestBean.courseId = courseBean.getId();
        courseOrderRequestBean.paymentMode = "1";
        courseOrderRequestBean.number = "1";
        if (TextUtils.isEmpty(courseBean.getActivity().getId())) {
            courseOrderRequestBean.billType = "0";
            courseOrderRequestBean.activityId = "-1";
        } else {
            courseOrderRequestBean.activityId = courseBean.getActivity().getId();
            courseOrderRequestBean.billType = "0";
        }
        courseOrderRequestBean.memberId = memberId;
        courseOrderRequestBean.extraOpenId = "-1";


    }

    /**
     * 约球
     */
    private void initEvent() {
        data = (YueQiuDetailBean) getIntent().getSerializableExtra("YueQiuDetailBean");
        price = data.getFees();
        prepayTitle.setText(data.getName());
        prepayContent.setText(data.getCustomName());
        prepayPrice.setText("¥" + data.getFees());
        prepayActivityPrice.setText("¥" + data.getFees());
        propaySecondChoose.setVisibility(View.GONE);
        propayFourChoose.setVisibility(View.GONE);
        propayFirstChooseTv.setText("报名人数");
        prepay_tag.setVisibility(View.GONE);
        orderFinishTotalPay.setText("总计¥" + price);
        ImageUtil.getNetImage(this, StringUtil.getRealImgUrl(data.getAvatarList()), prepayImg);
    }

    @Override
    public void viewMode(Response res, String tag) {
        String cripsCode = "-1";
        if (crips == null) cripsCode = "-1";
        else cripsCode = crips.getCouponCode();
        intent.putExtra("renshu", memberNum);
        intent.putExtra("RealPay", resultPrice);
        if (tag.equals(HttpConstant.joinYueQiu)) {
            ProyueqiuPayEntity entity = (ProyueqiuPayEntity) res.body();
            if (!entity.getCode().equals("0")) {
                CustomToast.createToast().showFaild(this, "参与失败，请重新申请");
                return;
            }
            intent.putExtra(Constant.ENTITY_PAY, entity);
            if (propayType.equals("3")) {
                intent.putExtra(Constant.ORDER_TYPE, Constant.YUEQIU_ORDER);
                callback.checkCoupons(memberId, cripsCode, entity.getData().getBillid(), StringUtil.multipString(resultPrice, "100"));
            } else {
                intent.putExtra(Constant.ORDER_TYPE, Constant.BISAI_TYPE);
                startActivity(intent);
            }
        } else if (tag.equals(HttpConstant.createCourseOrder)) {
            CourseOrderEntity entity = (CourseOrderEntity) res.body();
            CourseOrderEntity.DataBean data = entity.getData();
            intent.putExtra(Constant.ORDER_TYPE, Constant.COUSE_TYPE);
            intent.putExtra(Constant.COURSE_PAY, data);
            callback.checkCoupons(memberId, cripsCode, data.getBillId(), StringUtil.multipString(resultPrice, "100"));
        } else if (tag.equals(HttpConstant.createOrderMenpiao)) {
            MenPiaoOrderEntity e = (MenPiaoOrderEntity) res.body();
            MenPiaoOrderEntity.DataBean.BillInfoBean billInfo = e.getData().getBillInfo();
            intent.putExtra(Constant.ORDER_TYPE, Constant.MENPIAO_PAY);
            intent.putExtra(Constant.MENPIAO_DETAIL, billInfo);
            callback.checkCoupons(memberId, cripsCode, billInfo.getBillid(), StringUtil.multipString(resultPrice, "100"));
        } else if (tag.equals(HttpConstant.checkCoupons)) {
            BaseEntity entity = (BaseEntity) res.body();
            String code = entity.getCode();
            switch (code) {
                case "-52":
                    CustomToast.createToast().showFaild(this, "您的订单不满足优惠条件");
                    return;
                case "-51":
                    CustomToast.createToast().showFaild(this, "您选的优惠券已锁定，请重新选择");
                    return;
                case "-1":
                case "-33":
                case "-53":
                    CustomToast.createToast().showFaild(this, "您的订单信息有误，请重新生成订单");
                    return;
            }
            startActivity(intent);
        } else if (tag.equals(HttpConstant.createCoachOrder)) {
            CoachOrderEntity entity = (CoachOrderEntity) res.body();
            if (entity.getCode().equals("-64"))
            {
                CustomToast.createToast().showFaild(this,"门票已售完，请选择其他场馆相关门票");
                return;
            }
            CoachOrderEntity.DataBean data = entity.getData();
            intent.putExtra(Constant.ORDER_TYPE, Constant.COACH_TYPE);
            intent.putExtra(Constant.COACH_PAY, data);
            callback.checkCoupons(memberId, cripsCode, data.getBillid(), StringUtil.multipString(resultPrice, "100"));
        }


    }

    @Override
    public void getFalse(boolean tag, String message) {
        if (tag) {
            CustomToast.createToast().showFaild(this, "网络链接异常，请检查网络链接");
        }
    }

    @Override
    public void showCode(int code, String string) {

    }

    @OnClick(R.id.back_black)
    public void onClick() {
        finish();
    }

    @OnClick({R.id.propay_first_choose, R.id.prepay_choose_youhui, R.id.propay_four_choose, R.id.go_to_pay, R.id.propay_second_choose,R.id.prepay_should_know})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.propay_first_choose:
                final PubulicPopSingleChoicerDialog choicerDialog = new PubulicPopSingleChoicerDialog(this, Constant.SHOW_MEMBER);
                switch (propayType) {
                    case "4":
                    case "1":
                    case "3":
                        choicerDialog.setBirthdayListener(new MyResetLisener(price));
                        choicerDialog.show();
                        break;
                    case "2":
                        OrderButtomFragment fragment = new OrderButtomFragment(R.layout.choose_pop_bottom, Constant.LOCATION, this, coachLocationBean);
                        fragment.show(getSupportFragmentManager(), TAG);
                        break;
                }
                break;
            case R.id.prepay_choose_youhui:
                OrderButtomFragment fragment = new OrderButtomFragment(R.layout.choose_pop_bottom, Constant.YOUHUIQUAN, this, coursetype, price);
                fragment.show(getSupportFragmentManager(), TAG);
                break;
            case R.id.propay_four_choose:
                PubulicPopSingleChoicerDialog dialog = new PubulicPopSingleChoicerDialog(this, Constant.SHOW_MIN);
                dialog.setBirthdayListener(new PubulicPopSingleChoicerDialog.OnBirthListener() {
                    @Override
                    public void onClick(String value) {
                        propayFourChooseTvTo.setText(value);
                        handler.obtainMessage(checkDone).sendToTarget();
                    }
                });
                dialog.show();
                break;
            case R.id.go_to_pay:
                if (isReadyToPay) {
                    switch (propayType) {
                        case "1":
                            callback.getCourseOrder(courseOrderRequestBean, this);
                            break;
                        case "2":
                            callback.getCoachOrder(coachOrderRequestBean, this);
                            break;
                        case "3":
                            callback.joinYueqiu(memberId, data.getId(), memberNum);
                            break;
                        case "4":
                            callback.createMenpiaoOrder(memberId, menpiaoId, "1", this);
                            break;
                        case "5":
                            callback.joinYueqiu(memberId, dataId, memberNum);
                            break;
                    }
                } else CustomToast.createToast().showFaild(this, "请填写或选择完毕再进行支付");

                break;
            case R.id.propay_second_choose:
                Intent intent = new Intent(this, ChooseDateActivity.class);
                intent.putExtra(Constant.COACH_ID, coachId);
                startActivity(intent);
                break;
            case R.id.prepay_should_know:
                switch (propayType) {
                    case "1":
                    case "2":
                    case "4":
                    case "5":
                        Intent intent1 = new Intent(this,XieYiActivity.class);
                        startActivity(intent1);
                        break;
                    case "3":
                        Intent intented= new Intent(this,YueQiuXieyiActivity.class);
                        startActivity(intented);
                        break;
                }
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        hintView.setVisibility(View.VISIBLE);

    }


    private class MyResetLisener implements PubulicPopSingleChoicerDialog.OnBirthListener {

        private String money;

        public MyResetLisener(String money) {
            this.money = money;
        }

        @Override
        public void onClick(String value) {
            propayFirstChooseTvTo.setText(value + "人");
            String totalPay = StringUtil.multipString(value, money);
            resultPrice = totalPay;
            orderFinishTotalPay.setText("总计¥" + totalPay);
            handler.obtainMessage(checkDone).sendToTarget();
            if (null != courseOrderRequestBean) {
                courseOrderRequestBean.number = value;
            }
            memberNum = value;
            prepayChooseYouhuiResult.setText("未使用优惠券");

        }

    }


    @Subscriber(tag = Constant.CRIPS)
    public void getCrips(CripEntity.DataBean crips) {
        this.crips = crips;
        prepayChooseYouhuiResult.setText(crips.getName());
        String abatement = crips.getAbatement();
        String div = StringUtil.multipString(abatement, "1");
        String totalNum = StringUtil.musString(resultPrice, div);
        orderFinishTotalPay.setText("总计¥" + totalNum);
        prepayNeedPrice.setText("¥" + div);
        resultPrice = totalNum;


    }

    @Subscriber(tag = Constant.COACH_TIME)
    public void getCoachTime(String timeId) {
        String[] split = timeId.split(",");
        length = split.length;
        propaySecondChooseTvTo.setText("已选择" + length + "节课");
        resultPrice = StringUtil.multipString(price, length + "");
        coachOrderRequestBean.setqScheduleList(timeId);
        coachOrderRequestBean.setAmount(resultPrice);
        orderFinishTotalPay.setText("总计¥" + resultPrice);
        prepayChooseYouhuiResult.setText("进入选择");
        prepayChooseYouhuiResult.setText("未使用优惠券");
    }


    @Subscriber(tag = Constant.COACH_LOCATION)
    public void getCoachLocation(String addresses) {
        String[] split = addresses.split(",");
        String location = split[0];
        String address = split[1];
        propayFirstChooseTvTo.setText(location);
        coachOrderRequestBean.setCustomerAddress(address);
        prepayChooseYouhuiResult.setText("未使用优惠券");
    }


}
