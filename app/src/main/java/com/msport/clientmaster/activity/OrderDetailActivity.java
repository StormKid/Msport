package com.msport.clientmaster.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.msport.clientmaster.R;
import com.msport.clientmaster.base.BaseActivity;
import com.msport.clientmaster.bean.YueQiuBean;
import com.msport.clientmaster.callback.MainCallback;
import com.msport.clientmaster.constants.Constant;
import com.msport.clientmaster.constants.HttpConstant;
import com.msport.clientmaster.entity.OrderDetailEntity;
import com.msport.clientmaster.entity.OrderListEntity;
import com.msport.clientmaster.intef.MyViewCallback;
import com.msport.clientmaster.util.CustomToast;
import com.msport.clientmaster.util.ImageUtil;
import com.msport.clientmaster.util.PublicPreferencesUtils;
import com.msport.clientmaster.util.StringUtil;
import com.msport.clientmaster.util.TimeUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Response;

/**
 * Created by like on 2016/8/19.
 */
public class OrderDetailActivity extends BaseActivity implements MyViewCallback {

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
    @BindView(R.id.order_finish_img)
    ImageView orderFinishImg;
    @BindView(R.id.order_finish_title)
    TextView orderFinishTitle;
    @BindView(R.id.order_finish_course_img)
    ImageView orderFinishCourseImg;
    @BindView(R.id.order_finish_course_name)
    TextView orderFinishCourseName;
    @BindView(R.id.order_finish_course_introduce)
    TextView orderFinishCourseIntroduce;
    @BindView(R.id.order_finish_course_keshi)
    TextView orderFinishCourseKeshi;
    @BindView(R.id.course_vg)
    LinearLayout courseVg;
    @BindView(R.id.order_finish_yueqiu_img)
    ImageView orderFinishYueqiuImg;
    @BindView(R.id.order_finish_yueqiu_name)
    TextView orderFinishYueqiuName;
    @BindView(R.id.order_finish_yueqiu_introduce)
    TextView orderFinishYueqiuIntroduce;
    @BindView(R.id.yuewqiu_vg)
    LinearLayout yuewqiuVg;
    @BindView(R.id.yuqiu_vg)
    LinearLayout yuqiuVg;
    @BindView(R.id.order_finish_coach_img)
    ImageView orderFinishCoachImg;
    @BindView(R.id.order_finish_coach_name)
    TextView orderFinishCoachName;
    @BindView(R.id.order_finish_coach_introduce)
    TextView orderFinishCoachIntroduce;
    @BindView(R.id.order_finish_coach_price)
    TextView orderFinishCoachPrice;
    @BindView(R.id.coach_vg)
    LinearLayout coachVg;
    @BindView(R.id.order_finish_change_vg)
    FrameLayout orderFinishChangeVg;
    @BindView(R.id.order_finish_total_price)
    TextView orderFinishTotalPrice;
    @BindView(R.id.order_finish_youhui_price)
    TextView orderFinishYouhuiPrice;
    @BindView(R.id.order_finish_pay_price)
    TextView orderFinishPayPrice;
    @BindView(R.id.order_finish_location)
    TextView orderFinishLocation;
    @BindView(R.id.order_finish_tosee_location)
    LinearLayout orderFinishToseeLocation;
    @BindView(R.id.order_finish_time)
    TextView orderFinishTime;
    @BindView(R.id.order_finish_tosee_time)
    LinearLayout orderFinishToseeTime;
    @BindView(R.id.order_finish_billid)
    TextView orderFinishBillid;
    @BindView(R.id.order_finish_username)
    TextView orderFinishUsername;
    @BindView(R.id.order_finish_paytype)
    TextView orderFinishPaytype;
    @BindView(R.id.order_finish_paytime)
    TextView orderFinishPaytime;
    @BindView(R.id.zhongjia)
    TextView zhongjia;
    @BindView(R.id.order_totle_money)
    TextView orderTotleMoney;
    @BindView(R.id.order_commit)
    TextView orderCommit;
    @BindView(R.id.order_show_commit)
    RelativeLayout orderShowCommit;
    @BindView(R.id.order_finish_code)
    LinearLayout orderFinishCode;
    @BindView(R.id.order_finish_phonenum)
    TextView orderFinishPhonenum;
    @BindView(R.id.order_finish_phone)
    LinearLayout orderFinishPhone;
    @BindView(R.id.order_code_time)
    TextView orderCodeTime;
    @BindView(R.id.order_code_use)
    TextView orderCodeUse;
    @BindView(R.id.order_code_num)
    TextView orderCodeNum;
    @BindView(R.id.order_type_tv)
    TextView orderTypeTv;
    @BindView(R.id.order_menpiao_image)
    ImageView orderMenpiaoImage;
    @BindView(R.id.order_menpiao_name)
    TextView orderMenpiaoName;
    @BindView(R.id.order_menpiao_introduce)
    TextView orderMenpiaoIntroduce;
    @BindView(R.id.order_menpiao_hour)
    TextView orderMenpiaoHour;
    @BindView(R.id.order_menpiao_price)
    TextView orderMenpiaoPrice;
    @BindView(R.id.menpiao_vg)
    LinearLayout menpiaoVg;
    @BindView(R.id.contain_alls)
    ScrollView containAlls;
    @BindView(R.id.look_course_list_tv)
    TextView lookCourseListTv;
    @BindView(R.id.look_course_list_tv_to)
    ImageView lookCourseListTvTo;
    @BindView(R.id.look_title)
    TextView lookTitle;
    @BindView(R.id.look_location)
    TextView lookLocation;
    @BindView(R.id.textView5)
    TextView textView5;
    @BindView(R.id.code_titile)
    TextView codeTitile;
    private MainCallback callback;
    private Context context;
    private String orderType;
    private String reviewType;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_finish);
        ButterKnife.bind(this);
        context = this;
        initView();
    }

    private void initView() {
        detailTitleChange.setBackgroundColor(ContextCompat.getColor(context, R.color.white));
        containAlls.setBackgroundColor(ContextCompat.getColor(context, R.color.white));
        orderShowCommit.setBackgroundColor(ContextCompat.getColor(context, R.color.white));
        shareBlack.setVisibility(View.GONE);
        orderShowCommit.setVisibility(View.VISIBLE);
        callback = new MainCallback(this, this);
        orderFinishTotalPrice.setVisibility(View.GONE);
        orderType = getIntent().getStringExtra(Constant.ORDER_TYPE);
        String billId = getIntent().getStringExtra(Constant.BILL_ID);
        switch (orderType) {
            case Constant.COUSE_TYPE:
                callback.getOrderDetail(billId, "0", this);
                courseVg.setVisibility(View.VISIBLE);
                mainTitle.setText("课程订单");
                break;
            case Constant.COACH_TYPE:
                callback.getOrderDetail(billId, "1", this);
                coachVg.setVisibility(View.VISIBLE);
                mainTitle.setText("私教订单");
                lookCourseListTv.setVisibility(View.VISIBLE);
                lookCourseListTvTo.setVisibility(View.VISIBLE);
                break;
            case Constant.YUEQIU_ORDER:
                callback.getOrderDetail(billId, "2", this);
                yuqiuVg.setVisibility(View.VISIBLE);
                mainTitle.setText("约球订单");
                lookTitle.setText("约球安排");
                lookLocation.setText("约球地址");
                break;
            case Constant.BISAI_TYPE:
                callback.getOrderDetail(billId, "3", this);
                yuqiuVg.setVisibility(View.VISIBLE);
                mainTitle.setText("比赛订单");
                lookLocation.setText("比赛场馆");
                lookTitle.setText("比赛安排");
                break;
            case Constant.MENPIAO_TYPE:
                callback.getOrderDetail(billId, "4", this);
                mainTitle.setText("门票订单");
                lookLocation.setText("赛事场馆");
                lookTitle.setText("赛事安排");
                break;


        }
    }

    @OnClick({R.id.back_black, R.id.order_commit})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_black:
                finish();
                break;
            case R.id.order_commit:

                break;
        }
    }


    @Override
    public void viewMode(Response res, String tag) {
        if (HttpConstant.orderDetail.equals(tag)) {

            OrderDetailEntity entity = (OrderDetailEntity) res.body();
            OrderDetailEntity.DataBean data = entity.getData();
            final String status = data.getStatus();
            final String qCommentStatus = data.getQCommentStatus();
            String valueName = "";
            if (qCommentStatus.equals("0")) {
                valueName = "立即评价";
                reviewType = "1";
            } else {
                valueName = "查看评价";
                reviewType = "0";
            }
            final String number = data.getNumber();
            // 门票
            String ticketCode = data.getTicketCode();
            String verifyStatus = data.getVerifyStatus();

            String amount = data.getAmount();
            final String billid = data.getBillid();
            String name = data.getName();
            // 微动券
            final String consumeCode = data.getConsumeCode();
            String consumeCodeTime = data.getConsumeCodeTime();
            final String actualAmount = data.getActualAmount();
            String createTime = TimeUtils.getTimeDate(consumeCodeTime);
            // 0 is nouse  1 is used
            String consumeCodeVerify = data.getConsumeCodeVerify();
            String userName = PublicPreferencesUtils.getString(context, Constant.NUTZER_NAME);
            //  0 微信 3 支付宝 4钱包
            String extraTranscDate = data.getExtraTranscDate();
            String paymentmode = data.getPaymentmode();
            String timeDate = TimeUtils.getTimeDate(extraTranscDate);
            String customerAddress = data.getCustomerAddress();
            String payType = "";
            if (null != paymentmode) {
                switch (paymentmode) {
                    case "0":
                        payType = "支付方式：微信";
                        break;
                    case "3":
                        payType = "支付方式：支付宝";
                        break;
                    case "4":
                        payType = "支付方式：钱包";
                        break;
                }
            }
            orderFinishPaytype.setText(payType);
            orderCodeTime.setText(timeDate);
            if (null != consumeCodeVerify) {
                if (consumeCodeVerify.equals("0")) orderCodeUse.setText("未使用");
                else if (consumeCodeVerify.equals("1"))orderCodeUse.setText("已使用");
                else ;
            } else {
                orderFinishCode.setVisibility(View.GONE);
            }
            orderFinishUsername.setText("付款人：" + userName);
            orderFinishBillid.setText(billid);
            orderFinishLocation.setText(customerAddress);
            orderFinishTotalPrice.setText("¥" + amount);
            orderTotleMoney.setText("¥" + amount);
            orderCodeNum.setText(consumeCode);
            orderCodeTime.setText(createTime);
            orderFinishPayPrice.setText("实际支付¥" + actualAmount);
            orderFinishTitle.setText(name);


            if (null != data.getCourse()) {
                courseVg.setVisibility(View.VISIBLE);
                OrderListEntity.DataBean.CourseBean course = data.getCourse();
                String courseName = course.getName();
                String courseimage = course.getCourseimage();
                String realImgUrl = StringUtil.getRealImgUrl(courseimage);
                ImageUtil.getNetImage(this, realImgUrl, orderFinishCourseImg);
                String comment = course.getComment();
                List<?> timeScheduleList = course.getTimeScheduleList();
                int size = 0;
                if (timeScheduleList == null) size = 0;
                else size = timeScheduleList.size();
                orderFinishCourseKeshi.setText("#" + size + "课时");
                orderFinishCourseName.setText(courseName);
                orderFinishCourseIntroduce.setText(comment);
                orderFinishPhonenum.setText(data.getQTelephone());
            } else if (null != data.getCoach()) {
                coachVg.setVisibility(View.VISIBLE);
                OrderDetailEntity.DataBean.CoachBean coach = data.getCoach();
                String coachName = coach.getName();
                String introduce = coach.getIntroduce();
                String avatarimg = coach.getAvatarimg();
                String realImgUrl = StringUtil.getRealImgUrl(avatarimg);
                ImageUtil.getNetImage(context, realImgUrl, orderFinishCoachImg);
                orderFinishCoachName.setText(coachName);
                orderFinishCoachIntroduce.setText(introduce);
                orderFinishPhonenum.setText(data.getQTelephone());
                orderFinishCode.setVisibility(View.GONE);

            } else if (null != data.getInvitationActivity()) {
                yuewqiuVg.setVisibility(View.VISIBLE);
                YueQiuBean invitationActivity = data.getInvitationActivity();
                String invitationActivityName = invitationActivity.getName();
                String customName = invitationActivity.getCustomName();
                String list = invitationActivity.getAvatarList();
                String realImgUrl = StringUtil.getRealImgUrl(list);
                ImageUtil.getNetImage(context, realImgUrl, orderFinishYueqiuImg);
                orderFinishYueqiuName.setText(customName);
                orderFinishYueqiuIntroduce.setText(invitationActivityName);
                orderFinishPhonenum.setText(data.getQTelephone());
                orderFinishCode.setVisibility(View.GONE);
                valueName = null;

            } else if (null != data.getVenue()) {// 门票
                menpiaoVg.setVisibility(View.VISIBLE);
                String ticketImage = data.getTicketImage();
                String realImgUrl = StringUtil.getRealImgUrl(ticketImage);
                ImageUtil.getNetImage(this, realImgUrl, orderMenpiaoImage);
                orderMenpiaoIntroduce.setText("场馆：" + data.getVenue().getName());
                orderMenpiaoName.setText(name);
                orderMenpiaoPrice.setText("¥" + amount);
                orderCodeNum.setText(ticketCode);
                codeTitile.setText("门票号码");
                if ("1".equals(verifyStatus))
                    orderCodeUse.setText("已使用");
                else orderCodeUse.setText("未使用");
                valueName = null;
            }

            checkChange(status, orderCommit, valueName, new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, OrderPayActivity.class);
                    intent.putExtra(Constant.ORDER_TYPE, orderType);
                    intent.putExtra("renshu", number);
                    intent.putExtra("RealPay", actualAmount);
                    intent.putExtra("do",billid);
                    startActivity(intent);
                }
            }, new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, ReviewDetailActivity.class);
                    intent.putExtra(Constant.REVIEW_TYPE, reviewType);
                    intent.putExtra(Constant.BILL_ID, billid);
                    startActivity(intent);
                }
            });

        }

    }

    @Override
    public void getFalse(boolean tag, String message) {
        if (tag) {
            if (message.equals(HttpConstant.orderDetail))
                CustomToast.createToast().showFaild(context, "订单详情获取失败，请检查网络状况");
        }
    }

    @Override
    public void showCode(int code, String string) {

    }

    private void checkChange(String status, TextView tv, String value, View.OnClickListener orderPayListener, View.OnClickListener orderOtherListener) {
        if (status.equals("-1")) {// 未完成订单
            tv.setText("立即支付");
            tv.setTextColor(ContextCompat.getColor(context, R.color.text_orange));
            tv.setBackgroundResource(R.drawable.shape_categroy_tagdo);
            tv.setOnClickListener(orderPayListener);
            orderFinishImg.setImageResource(R.mipmap.unfinish);
            orderFinishPhone.setVisibility(View.GONE);
            zhongjia.setVisibility(View.VISIBLE);
            orderTotleMoney.setVisibility(View.VISIBLE);
            orderFinishPaytype.setText("支付方式：未支付");
            orderTypeTv.setText("您的订单尚未完成支付");
        } else {
            if (value == null)
                orderShowCommit.setVisibility(View.GONE);
            tv.setText(value);
            tv.setTextColor(ContextCompat.getColor(context, R.color.text_blue));
            tv.setBackgroundResource(R.drawable.shape_categroy_tagblue);
            tv.setOnClickListener(orderOtherListener);
            orderFinishImg.setImageResource(R.mipmap.order_finish);
            orderFinishPhone.setVisibility(View.VISIBLE);
            zhongjia.setVisibility(View.GONE);
            orderTotleMoney.setVisibility(View.GONE);
            orderTypeTv.setText("您的订单已完成");
            orderShowCommit.setVisibility(View.GONE);

        }
    }
}
