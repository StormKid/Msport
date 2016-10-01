package com.msport.clientmaster.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.msport.clientmaster.R;
import com.msport.clientmaster.activity.OrderDetailActivity;
import com.msport.clientmaster.activity.OrderPayActivity;
import com.msport.clientmaster.activity.ReviewDetailActivity;
import com.msport.clientmaster.bean.YueQiuBean;
import com.msport.clientmaster.constants.Constant;
import com.msport.clientmaster.entity.CoachDetailEntity;
import com.msport.clientmaster.entity.CoachOrderEntity;
import com.msport.clientmaster.entity.CourseOrderEntity;
import com.msport.clientmaster.entity.MenPiaoOrderEntity;
import com.msport.clientmaster.entity.OrderListEntity;
import com.msport.clientmaster.entity.ProyueqiuPayEntity;
import com.msport.clientmaster.requestbean.ReviewRequestBean;
import com.msport.clientmaster.util.ImageUtil;
import com.msport.clientmaster.util.StringUtil;
import com.msport.clientmaster.util.ViewUtil;
import com.msport.clientmaster.view.MyTagViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by like on 2016/8/18.
 */

public class OrderListAdapter extends RecyclerView.Adapter<OrderListAdapter.MyViewHolder> {

    private int orderType;
    private Context context;
    private List<OrderListEntity.DataBean> dataBeen;
    private final int courseType = 0;
    private final int coachType = 1;
    private final int yueqiuType = 2;
    private final int menpiaoType = 3;
    private String valueName;
    private String reviewType;

    public OrderListAdapter(int orderType, Context context, List<OrderListEntity.DataBean> dataBeen) {
        this.orderType = orderType;
        this.context = context;
        this.dataBeen = dataBeen;
    }


    @Override
    public int getItemViewType(int position) {
        if (orderType == courseType) {
            return courseType;
        } else if (orderType == coachType) {
            return coachType;
        } else if (orderType == yueqiuType) {
            return yueqiuType;
        } else {
            return menpiaoType;
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        switch (viewType) {
            case courseType:
                view = LayoutInflater.from(context).inflate(R.layout.item_course_order, null);
                CourseViewHolder courseViewHolder = new CourseViewHolder(view);
                return courseViewHolder;
            case coachType:
                view = LayoutInflater.from(context).inflate(R.layout.item_coach_order, null);
                CoachViewHolder coachViewHolder = new CoachViewHolder(view);
                return coachViewHolder;
            case yueqiuType:
                view = LayoutInflater.from(context).inflate(R.layout.item_yueqiu_order, null);
                YueQiuViewHolder yueQiuViewHolder = new YueQiuViewHolder(view);
                return yueQiuViewHolder;
            case menpiaoType:
                view = LayoutInflater.from(context).inflate(R.layout.item_menpiao_order, null);
                MenpiaoViewHolder menpiaoViewHolder = new MenpiaoViewHolder(view);
                return menpiaoViewHolder;
        }


        return null;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final OrderListEntity.DataBean bean = dataBeen.get(position);
        String status = bean.getStatus();
        final Intent intent = new Intent();
        final String billid = bean.getBillid();
        final String amount = bean.getAmount();
        final String qCommentStatus = bean.getQCommentStatus();
        if (qCommentStatus.equals("0")) {
            valueName = "立即评价";
            reviewType = "1";
        } else {
            valueName = "查看评价";
            reviewType = "0";
        }
        final String number = bean.getNumber();
        String ticketImage = bean.getTicketImage();
        final String actualAmount = bean.getActualAmount();
        if (holder instanceof CourseViewHolder) {

            CourseViewHolder courseViewHolder = (CourseViewHolder) holder;
            OrderListEntity.DataBean.CourseBean course = bean.getCourse();
            final String name = course.getName();
            final String comment = course.getComment();
            final String totalMember = course.getTotalMember();
            List<?> timeScheduleList = course.getTimeScheduleList();
            int size = 0;
            if (timeScheduleList == null)
                size = 0;
            else size = timeScheduleList.size();
            String price = "¥" + course.getPrice();
            courseViewHolder.orderCourseName.setText(name);
            courseViewHolder.orderCourseIntroduce.setText(comment);
            courseViewHolder.orderCoursePrice.setText(price);
            intent.putExtra("RealPay" , actualAmount);
            checkStatus(status, courseViewHolder.orderCourseCommit, courseViewHolder.orderCourseStatus, valueName, new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    intent.setClass(context, OrderPayActivity.class);
                    intent.putExtra(Constant.ORDER_TYPE, Constant.COUSE_TYPE);
                    CourseOrderEntity.DataBean coursebean = new CourseOrderEntity.DataBean();
                    coursebean.setBillId(billid);
                    coursebean.setPrice(actualAmount);
                    coursebean.setName(name);
                    coursebean.setTotalMember(number);
                    intent.putExtra(Constant.COURSE_PAY, coursebean);
                    context.startActivity(intent);
                }
            }, new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    intent.setClass(context, ReviewDetailActivity.class);
                    intent.putExtra(Constant.REVIEW_TYPE, reviewType);
                    intent.putExtra(Constant.BILL_ID, billid);
                    context.startActivity(intent);
                }
            });
            String courseimage = course.getCourseimage();
            String realImgUrl = StringUtil.getRealImgUrl(courseimage);
            ImageUtil.getNetImage(context, realImgUrl, courseViewHolder.orderCourseImage);
            courseViewHolder.orderCourseHour.setText("#" + size + "课时");
            courseViewHolder.orderCourseTotleMoney.setText("¥" + actualAmount);
            courseViewHolder.orderCourseTitle.setText(bean.getName());
            courseViewHolder.select_detail.setOnClickListener(new MyDetailClick(position, billid));

        } else if (holder instanceof CoachViewHolder) {
            CoachViewHolder coachViewHolder = (CoachViewHolder) holder;
            CoachDetailEntity.DataBean.QualificationCoachListBean.CoachBean coach = bean.getCoach();
            final String name = coach.getName();
            String introduce = coach.getIntroduce();
            List<String> list = new ArrayList<>();
            list.add("帅气");
            list.add("阳光");
            list.add("教学严谨");
            ViewUtil.createTextview(coachViewHolder.orderCoachTag, context, list, false, null, null);
            String avatarimg = coach.getAvatarimg();
            String realImgUrl = StringUtil.getRealImgUrl(avatarimg);
            ImageUtil.getNetImage(context, realImgUrl, coachViewHolder.orderCoachImage);
            String fees = "¥" + coach.getFees() + "/课时";
            coachViewHolder.orderCoachIntroduce.setText(introduce);
            coachViewHolder.orderCoachName.setText(name);
            coachViewHolder.orderCoachTitle.setText(bean.getName());
            coachViewHolder.orderCoachPrice.setText(fees);
            coachViewHolder.orderCoachTotleMoney.setText("¥" + actualAmount);
            checkStatus(status, coachViewHolder.orderCoachCommit, coachViewHolder.orderCoachStatus, valueName, new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    intent.setClass(context, OrderPayActivity.class);
                    intent.putExtra(Constant.ORDER_TYPE, Constant.COACH_TYPE);
                    CoachOrderEntity.DataBean coachBean = new CoachOrderEntity.DataBean();
                    coachBean.setBillid(billid);
                    coachBean.setAmount(actualAmount);
                    coachBean.setName(name);
                    coachBean.setNumber(number);
                    intent.putExtra(Constant.COACH_PAY, coachBean);
                    context.startActivity(intent);
                }
            }, new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    intent.setClass(context, ReviewDetailActivity.class);
                    intent.putExtra(Constant.REVIEW_TYPE, reviewType);
                    intent.putExtra(Constant.BILL_ID, billid);
                    ReviewRequestBean reviewRequestBean = new ReviewRequestBean();
                    reviewRequestBean.setBillId(billid);
                    context.startActivity(intent);


                }
            });
            coachViewHolder.select_detail.setOnClickListener(new MyDetailClick(position, billid));

        } else if (holder instanceof YueQiuViewHolder) {
            YueQiuViewHolder yueqiuHolder = (YueQiuViewHolder) holder;
            YueQiuBean activity = bean.getInvitationActivity();
            final String name = activity.getName();
            String customName = activity.getCustomName();
            String fees = "¥" + activity.getFees() + "/人";
            String avatarList = activity.getAvatarList();
            String realImgUrl = StringUtil.getRealImgUrl(avatarList);
            final String currentParticipants = activity.getCurrentParticipants();
            ImageUtil.getNetImage(context, realImgUrl, yueqiuHolder.orderYueqiuImage);
            yueqiuHolder.orderYueqiuIntroduce.setText(name);
            yueqiuHolder.orderYueqiuTitle.setText("约球订单");
            yueqiuHolder.orderYueqiuName.setText(customName);
            yueqiuHolder.orderYueqiuPrice.setText(fees);
            yueqiuHolder.orderYueqiuTotleMoney.setText("¥" + actualAmount);
            checkStatus(status, yueqiuHolder.orderYueqiuCommit, yueqiuHolder.orderYueqiuStatus, null, new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ProyueqiuPayEntity.DataBean data = new ProyueqiuPayEntity.DataBean();
                    intent.setClass(context, OrderPayActivity.class);
                    intent.putExtra(Constant.ORDER_TYPE, Constant.YUEQIU_ORDER);
                    data.setName(name);
                    data.setBillid(billid);
                    data.setAmount(actualAmount);
                    data.setNumber(number);
                    intent.putExtra(Constant.ENTITY_PAY, data);
                    context.startActivity(intent);
                }
            }, null);
            yueqiuHolder.select_detail.setOnClickListener(new MyDetailClick(position, billid));

        } else {//门票
            MenpiaoViewHolder viewHolder = (MenpiaoViewHolder) holder;
            final String name = bean.getName();
            viewHolder.orderMenpiaoName.setText(bean.getName());
            viewHolder.orderMenpiaoIntroduce.setText("场馆：" + bean.getCustomerAddress());
            viewHolder.orderMenpiaoTotleMoney.setText("¥" + actualAmount);
            viewHolder.orderMenpiaoPrice.setText("¥" + amount);
            viewHolder.orderMenpiaoTitle.setText("门票订单");
            viewHolder.select_detail.setOnClickListener(new MyDetailClick(position, billid));
            ImageUtil.getNetImage(context, StringUtil.getRealImgUrl(ticketImage), viewHolder.orderMenpiaoImage);
            checkStatus(status, viewHolder.orderMenpiaoCommit, viewHolder.orderMenpiaoStatus, null, new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MenPiaoOrderEntity.DataBean.BillInfoBean data = new MenPiaoOrderEntity.DataBean.BillInfoBean();
                    intent.setClass(context, OrderPayActivity.class);
                    intent.putExtra(Constant.ORDER_TYPE, Constant.MENPIAO_DETAIL);
                    data.setName(name);
                    data.setBillid(billid);
                    data.setAmount(actualAmount);
                    data.setNumber(number);
                    intent.putExtra(Constant.MENPIAO_DETAIL, data);
                    context.startActivity(intent);
                }
            }, null);
        }

    }

    @Override
    public int getItemCount() {
        return dataBeen == null ? 0 : dataBeen.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public MyViewHolder(View itemView) {
            super(itemView);
        }
    }


    class CourseViewHolder extends MyViewHolder {
        @BindView(R.id.order_course_title)
        TextView orderCourseTitle;
        @BindView(R.id.order_course_status)
        TextView orderCourseStatus;
        @BindView(R.id.order_course_image)
        ImageView orderCourseImage;
        @BindView(R.id.order_course_name)
        TextView orderCourseName;
        @BindView(R.id.order_course_introduce)
        TextView orderCourseIntroduce;
        @BindView(R.id.order_course_hour)
        TextView orderCourseHour;
        @BindView(R.id.order_course_price)
        TextView orderCoursePrice;
        @BindView(R.id.zhongjia)
        TextView zhongjia;
        @BindView(R.id.order_course_totle_money)
        TextView orderCourseTotleMoney;
        @BindView(R.id.order_course_commit)
        TextView orderCourseCommit;
        @BindView(R.id.select_detail)
        ViewGroup select_detail;
        @BindView(R.id.contain_alls)
        ViewGroup contain_alls;

        CourseViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    class CoachViewHolder extends MyViewHolder {
        @BindView(R.id.order_coach_title)
        TextView orderCoachTitle;
        @BindView(R.id.order_coach_status)
        TextView orderCoachStatus;
        @BindView(R.id.order_coach_image)
        ImageView orderCoachImage;
        @BindView(R.id.order_coach_name)
        TextView orderCoachName;
        @BindView(R.id.order_coach_tag)
        MyTagViewGroup orderCoachTag;
        @BindView(R.id.order_coach_introduce)
        TextView orderCoachIntroduce;
        @BindView(R.id.order_coach_price)
        TextView orderCoachPrice;
        @BindView(R.id.zhongjia)
        TextView zhongjia;
        @BindView(R.id.order_coach_totle_money)
        TextView orderCoachTotleMoney;
        @BindView(R.id.order_coach_commit)
        TextView orderCoachCommit;
        @BindView(R.id.select_detail)
        ViewGroup select_detail;
        @BindView(R.id.contain_alls)
        ViewGroup contain_alls;

        CoachViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    class YueQiuViewHolder extends MyViewHolder {
        @BindView(R.id.order_yueqiu_title)
        TextView orderYueqiuTitle;
        @BindView(R.id.order_yueqiu_status)
        TextView orderYueqiuStatus;
        @BindView(R.id.order_yueqiu_image)
        ImageView orderYueqiuImage;
        @BindView(R.id.order_yueqiu_name)
        TextView orderYueqiuName;
        @BindView(R.id.order_yueqiu_introduce)
        TextView orderYueqiuIntroduce;
        @BindView(R.id.order_yueqiu_price)
        TextView orderYueqiuPrice;
        @BindView(R.id.zhongjia)
        TextView zhongjia;
        @BindView(R.id.order_yueqiu_totle_money)
        TextView orderYueqiuTotleMoney;
        @BindView(R.id.order_yueqiu_commit)
        TextView orderYueqiuCommit;
        @BindView(R.id.select_detail)
        ViewGroup select_detail;
        @BindView(R.id.contain_alls)
        ViewGroup contain_alls;

        YueQiuViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    class MenpiaoViewHolder extends MyViewHolder {
        @BindView(R.id.order_menpiao_title)
        TextView orderMenpiaoTitle;
        @BindView(R.id.order_menpiao_status)
        TextView orderMenpiaoStatus;
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
        @BindView(R.id.zhongjia)
        TextView zhongjia;
        @BindView(R.id.order_menpiao_totle_money)
        TextView orderMenpiaoTotleMoney;
        @BindView(R.id.order_menpiao_commit)
        TextView orderMenpiaoCommit;
        @BindView(R.id.select_detail)
        ViewGroup select_detail;
        @BindView(R.id.contain_alls)
        ViewGroup contain_alls;

        MenpiaoViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    private void checkStatus(String status, TextView tv, TextView statusTv, String value, View.OnClickListener orderPayListener, View.OnClickListener orderOtherListener) {
        if (status.equals("-1")) {// 未完成订单
            tv.setText("立即支付");
            tv.setTextColor(ContextCompat.getColor(context, R.color.text_orange));
            tv.setBackgroundResource(R.drawable.shape_categroy_tagdo);
            tv.setOnClickListener(orderPayListener);
            statusTv.setText("未完成");
        } else {
            if (value == null)
                tv.setVisibility(View.GONE);
            tv.setText(value);
            tv.setTextColor(ContextCompat.getColor(context, R.color.text_blue));
            tv.setBackgroundResource(R.drawable.shape_categroy_tagblue);
            tv.setOnClickListener(orderOtherListener);
            statusTv.setText("已完成");
        }
    }

    private class MyDetailClick implements View.OnClickListener {

        private int position;
        private String billId;


        public MyDetailClick(int position, String billId) {
            this.position = position;
            this.billId = billId;
        }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(context, OrderDetailActivity.class);
            int itemViewType = getItemViewType(position);
            switch (itemViewType) {
                case courseType:
                    intent.putExtra(Constant.ORDER_TYPE, Constant.COUSE_TYPE);
                    intent.putExtra(Constant.BILL_ID, billId);
                    context.startActivity(intent);
                    break;
                case coachType:
                    intent.putExtra(Constant.ORDER_TYPE, Constant.COACH_TYPE);
                    intent.putExtra(Constant.BILL_ID, billId);
                    context.startActivity(intent);
                    break;
                case yueqiuType:
                    intent.putExtra(Constant.ORDER_TYPE, Constant.YUEQIU_ORDER);
                    intent.putExtra(Constant.BILL_ID, billId);
                    context.startActivity(intent);
                    break;
                case menpiaoType:
                    intent.putExtra(Constant.ORDER_TYPE, Constant.MENPIAO_TYPE);
                    intent.putExtra(Constant.BILL_ID, billId);
                    context.startActivity(intent);
                    break;
            }

        }
    }


    public void loadMore(List<OrderListEntity.DataBean> dataBeen) {
        this.dataBeen = dataBeen;
        notifyDataSetChanged();
    }


}
