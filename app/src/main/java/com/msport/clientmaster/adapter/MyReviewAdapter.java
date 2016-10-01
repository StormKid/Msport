package com.msport.clientmaster.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.msport.clientmaster.R;
import com.msport.clientmaster.activity.ReviewDetailActivity;
import com.msport.clientmaster.constants.Constant;
import com.msport.clientmaster.entity.CoachDetailEntity;
import com.msport.clientmaster.entity.ReViewListEntity;
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
 * Created by like on 2016/8/17.
 */

public class MyReviewAdapter extends RecyclerView.Adapter<MyReviewAdapter.ReViewHolder> {


    private int type;
    private final List<ReViewListEntity.DataBean> listOut;
    private Context context;
    private final int courseType = 0;
    private final int coachType = 1;
    private List<String> list  = new ArrayList<>();

    public MyReviewAdapter(int type, List<ReViewListEntity.DataBean> listOut, Context context) {
        this.type = type;
        this.listOut = listOut;
        this.context = context;
        if (list.size()>0){
            list.clear();
        }
        list.add("帅气");
        list.add("阳光");
        list.add("教学严谨");
    }


    @Override
    public int getItemViewType(int position) {
        ReViewListEntity.DataBean dataBean = listOut.get(position);
        String billType = dataBean.getBillType();
        if (billType.equals("0")) {
            return courseType;
        } else {
            return coachType;
        }
    }

    @Override
    public ReViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case coachType:
                View view = LayoutInflater.from(context).inflate(R.layout.item_coach_review, null);
                CoachViewHolder holder = new CoachViewHolder(view);
                return holder;
            case courseType:
                View contentView = LayoutInflater.from(context).inflate(R.layout.item_course_review, null);
                CourseViewHolder courseHolder = new CourseViewHolder(contentView);
                return  courseHolder;
        }
        View view = LayoutInflater.from(context).inflate(R.layout.item_qianbao_list, null);
        ReViewHolder holder = new ReViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ReViewHolder holder, int position) {
        ReViewListEntity.DataBean dataBean = listOut.get(position);
        Intent intent = new Intent(context, ReviewDetailActivity.class);
        String billid = dataBean.getBillid();
        ReviewRequestBean bean = new ReviewRequestBean();
        bean.setBillId(billid);

        if (holder instanceof CourseViewHolder){
            CourseViewHolder courseHolder = (CourseViewHolder) holder;
            ReViewListEntity.DataBean.CourseBean course = dataBean.getCourse();
            String name = course.getName();
            String comment = course.getComment();
            int size = course.getTimeScheduleList().size();
            String album = course.getAlbum();
            String price = course.getPrice();
            String realImgUrl = StringUtil.getRealImgUrl(album);
            if (type==0){
                courseHolder.reviewCourseCommit.setText("查看评论");
            }else {
                courseHolder.reviewCourseCommit.setText("立即评论");
            }
            courseHolder.reviewCourseName.setText(name);
            courseHolder.reviewCourseTitle.setText(dataBean.getName());
            courseHolder.reviewCourseIntroduce.setText(comment);
            courseHolder.reviewCourseHour.setText("#"+size+"课时");
            courseHolder.reviewCoursePrice.setText("¥"+price);
            courseHolder.reviewCourseTotleMoney.setText("¥"+dataBean.getAmount());
            ImageUtil.getNetImage(context,realImgUrl,courseHolder.reviewCourseImage);
            bean.setType(courseType+"");
            bean.setTitle(name);
            bean.setCourseId(course.getId());
            bean.setCoachId("-1");
            courseHolder.reviewCourseCommit.setOnClickListener(new onReviewedListener(intent,type,billid,bean));
        }else {
            CoachViewHolder coachViewHolder = (CoachViewHolder) holder;
            CoachDetailEntity.DataBean.QualificationCoachListBean.CoachBean coachBean = dataBean.getCoach();
            String avatarimg = coachBean.getAvatarimg();
            String name = coachBean.getName();
            String introduce = coachBean.getIntroduce();
            String fees = coachBean.getFees();
            String realImgUrl = StringUtil.getRealImgUrl(avatarimg);
            ViewUtil.createTextview(coachViewHolder.reviewCoachTag,context, list,false,null,null);
            coachViewHolder.reviewCoachIntroduce.setText(introduce);
            coachViewHolder.reviewCoachName.setText(name);
            coachViewHolder.reviewCoachPrice.setText("¥"+fees+"/课时");
            coachViewHolder.reviewCoachTotleMoney.setText("¥"+dataBean.getAmount());
            coachViewHolder.reviewCoachTitle.setText(dataBean.getName());
            ImageUtil.getNetImage(context,realImgUrl,coachViewHolder.reviewCoachImage);
            if (type==0){
                coachViewHolder.reviewCoachCommit.setText("查看评论");
            }else {
                coachViewHolder.reviewCoachCommit.setText("立即评论");
            }
            bean.setType(coachType+"");
            bean.setTitle(name);
            bean.setCourseId(coachBean.getId());
            bean.setCourseId("-1");
            coachViewHolder.reviewCoachCommit.setOnClickListener(new onReviewedListener(intent,type,billid,bean));
        }

    }

    @Override
    public int getItemCount() {
        return listOut == null ? 0 : listOut.size();
    }

    class ReViewHolder extends RecyclerView.ViewHolder {

        public ReViewHolder(View itemView) {
            super(itemView);
        }
    }


     class CoachViewHolder extends ReViewHolder{
        @BindView(R.id.review_coach_title)
        TextView reviewCoachTitle;
        @BindView(R.id.review_coach_image)
        ImageView reviewCoachImage;
        @BindView(R.id.review_coach_name)
        TextView reviewCoachName;
        @BindView(R.id.review_coach_tag)
        MyTagViewGroup reviewCoachTag;
        @BindView(R.id.review_coach_introduce)
        TextView reviewCoachIntroduce;
        @BindView(R.id.review_coach_price)
        TextView reviewCoachPrice;
        @BindView(R.id.zhongjia)
        TextView zhongjia;
        @BindView(R.id.review_coach_totle_money)
        TextView reviewCoachTotleMoney;
        @BindView(R.id.review_coach_commit)
        TextView reviewCoachCommit;


         public CoachViewHolder(View itemView) {
             super(itemView);
             ButterKnife.bind(this,itemView);
         }
     }

     class CourseViewHolder extends ReViewHolder{
        @BindView(R.id.review_course_title)
        TextView reviewCourseTitle;
        @BindView(R.id.review_course_image)
        ImageView reviewCourseImage;
        @BindView(R.id.review_course_name)
        TextView reviewCourseName;
        @BindView(R.id.review_course_introduce)
        TextView reviewCourseIntroduce;
        @BindView(R.id.review_course_hour)
        TextView reviewCourseHour;
        @BindView(R.id.review_course_price)
        TextView reviewCoursePrice;
        @BindView(R.id.zhongjia)
        TextView zhongjia;
        @BindView(R.id.review_course_totle_money)
        TextView reviewCourseTotleMoney;
        @BindView(R.id.review_course_commit)
        TextView reviewCourseCommit;

        public CourseViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }


    private class onReviewedListener implements View.OnClickListener{

        private Intent intent;
        private int type;
        private String billid;
        private ReviewRequestBean bean;

        public onReviewedListener(Intent intent, int type, String billid, ReviewRequestBean bean){
            this.intent = intent;
            this.type = type;
            this.billid = billid;
            this.bean = bean;
        }

        @Override
        public void onClick(View view) {
            intent.putExtra(Constant.ADDREVIEW,bean);
            intent.putExtra(Constant.REVIEW_TYPE,type+"");
            intent.putExtra(Constant.BILL_ID ,billid);
            context.startActivity(intent);
        }
    }




}
