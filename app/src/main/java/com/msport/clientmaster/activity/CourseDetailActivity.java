package com.msport.clientmaster.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.LayoutAnimationController;
import android.view.animation.TranslateAnimation;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.msport.clientmaster.R;
import com.msport.clientmaster.adapter.CourseListShowAdapter;
import com.msport.clientmaster.adapter.CourseShowListAdapter;
import com.msport.clientmaster.adapter.ReviewListShowAdapter;
import com.msport.clientmaster.base.BaseActivity;
import com.msport.clientmaster.bean.ShareBean;
import com.msport.clientmaster.callback.MainCallback;
import com.msport.clientmaster.callback.ShareListener;
import com.msport.clientmaster.constants.Constant;
import com.msport.clientmaster.constants.HttpConstant;
import com.msport.clientmaster.entity.CourseDetailEntity;
import com.msport.clientmaster.entity.DetailReviewEntity;
import com.msport.clientmaster.intef.MyViewCallback;
import com.msport.clientmaster.util.CustomToast;
import com.msport.clientmaster.util.StringUtil;
import com.msport.clientmaster.util.Tools;
import com.msport.clientmaster.util.ViewUtil;
import com.msport.clientmaster.view.HomeScrollView;
import com.msport.clientmaster.view.JustifyTextView;
import com.msport.clientmaster.view.MyTagViewGroup;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.shareboard.SnsPlatform;
import com.umeng.socialize.utils.ShareBoardlistener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Response;

/**
 * 课程详情
 * Created by like on 2016/7/22.
 */

public class CourseDetailActivity extends BaseActivity implements MyViewCallback {

    /**
     * 相关课程列表
     */
    @BindView(R.id.detail_about_listcourse)
    ListView detail_about_listcourse;

    /**
     * 立即购买
     */
    @BindView(R.id.go_to_pay)
    Button go_to_pay;

    /**
     * 显示点评
     */
    @BindView(R.id.review_show_list)
    ListView review_show_list;
    /**
     * 显示更多课程
     */
    @BindView(R.id.course_detail_show)
    ListView course_detail_show;

    /**
     * 显示标签的view
     */
    @BindView(R.id.detail_tag_show)
    MyTagViewGroup detail_tag_show;

    @BindView(R.id.detail_scroll_view)
    HomeScrollView detail_scroll_view;

    @BindView(R.id.detail_title_change)
    ViewGroup detail_title_change;

    @BindView(R.id.detail_title_no_scr)
    ViewGroup detail_title_no_scr;


    /**
     * 分享
     */

    @BindView(R.id.share_white)
    ImageView share_white;

    @BindView(R.id.share_black)
    ImageView share_black;


    /**
     * 返回
     */
    @BindView(R.id.back_black)
    ImageView back_black;

    @BindView(R.id.back_white)
    ImageView back_white;
    @BindView(R.id.course_detail_name)
    TextView courseDetailName;
    @BindView(R.id.course_detail_address)
    TextView courseDetailAddress;
    @BindView(R.id.course_detail_price)
    TextView courseDetailPrice;
    @BindView(R.id.course_detail_joinmax)
    TextView courseDetailJoinmax;
    @BindView(R.id.course_detail_current)
    TextView courseDetailCurrent;
    @BindView(R.id.course_detail_location)
    TextView courseDetailLocation;
    @BindView(R.id.course_detail_location_value)
    TextView courseDetailLocationValue;
    @BindView(R.id.course_detail_images)
    LinearLayout courseDetailImages;
    @BindView(R.id.course_detail_jieshao)
    JustifyTextView courseDetailJieshao;
    @BindView(R.id.course_detail_introduce)
    TextView courseDetailIntroduce;
    @BindView(R.id.main_title)
    TextView mainTitle;
    @BindView(R.id.title_right_tv)
    TextView titleRightTv;
    @BindView(R.id.detail_all_review)
    TextView detailAllReview;
    @BindView(R.id.detail_review_title)
    LinearLayout detailReviewTitle;


    private ReviewListShowAdapter reviewListShowAdapter;
    private Context context;
    private CourseShowListAdapter courseListShowAdapter;
    private int tagY;
    private int changeY;
    private MainCallback callback;
    private String courseId;
    private CourseDetailEntity.DataBean data;
    private String realImgUrl;
    private List<CourseDetailEntity.DataBean.TimeScheduleListBean> listTime = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_detail);
        ButterKnife.bind(this);
        context = this;
        callback = new MainCallback(this, this);
        courseId = getIntent().getStringExtra(Constant.COURSE_ID);
        callback.getCourseDetail(courseId);
        initView();
        initEvent();

    }

    private void initEvent() {
        tagY = detail_title_no_scr.getHeight();
        changeY = detail_title_no_scr.getHeight();
        detail_title_change.getBackground().setAlpha(0);
        detail_title_change.setAlpha(0);
        detail_scroll_view.setOnScrollYListener(new MyOnScrollYListener(detail_title_change));
        detail_scroll_view.setBackgroundColor(ContextCompat.getColor(context, R.color.white_high));
        List<String> listTag = new ArrayList<>();
        listTag.add("小学生");
        listTag.add("秒杀");
        listTag.add("态度很好");
        listTag.add("质量很高");
        listTag.add("帅气");
        listTag.add("长腿");
        listTag.add("大神");
        listTag.add("很好");
        listTag.add("棒棒哒");
        ViewUtil.createTextview(detail_tag_show, context, listTag, false, null, null);
        back_white.setOnClickListener(new MyReturnBackClickListener());
        back_black.setOnClickListener(new MyReturnBackClickListener());
        share_black.setOnClickListener(new MyShareOnclickListener());
        share_white.setOnClickListener(new MyShareOnclickListener());

    }

    private void initView() {
        detail_about_listcourse.setAdapter(new CourseListShowAdapter(context, null));
        reviewListShowAdapter = new ReviewListShowAdapter(context, null);

    }


    private void initMoreViewList(ListView lv, String text, View.OnClickListener listener, BaseAdapter adapter) {
        View ListFootView = LayoutInflater.from(context).inflate(R.layout.item_detail_list_show_foot, null);
        TextView footView = (TextView) ListFootView.findViewById(R.id.get_more_list);
        footView.setText(text);
        lv.addFooterView(ListFootView);
        lv.setAdapter(adapter);
        footView.setOnClickListener(listener);
    }


    @OnClick({R.id.go_to_pay})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.go_to_pay:
                checkMember(this);
                break;
        }
    }

    @Override
    protected void Do() {
        Intent intent = new Intent(this, PrepayActivity.class);
        intent.putExtra(Constant.PROPAY_TYPE, "1");
        intent.putExtra(Constant.COURSE_DETAIL, data);
        startActivity(intent);
    }

    private void showListAnimation(ListView lv, BaseAdapter adapter) {
        int width = getWindowManager().getDefaultDisplay().getWidth();
        Animation animation = new TranslateAnimation(-width, 0f, 0f, 0f);
        animation.setDuration(500);
        //1f为延时
        LayoutAnimationController controller = new LayoutAnimationController(animation, 0.5f);
        controller.setOrder(LayoutAnimationController.ORDER_NORMAL);
        lv.setLayoutAnimation(controller);
    }

    @Override
    public void viewMode(Response res, String tag) {
        if (HttpConstant.showCourseDetail.equals(tag)) {
            CourseDetailEntity courseDetailEntity = (CourseDetailEntity) res.body();
            data = courseDetailEntity.getData();
            String name = data.getName();
            String comment = data.getComment();
            String introduce = data.getIntroduce();
            String location = data.getLocation();
            String album = data.getAlbum();
            String venueName = data.getVenueName();
            String timeend = data.getTimeend();
            String timestart = data.getTimestart();
            String price = data.getPrice();
            String totalMember = data.getTotalMember();
            String totalavailable = data.getTotalavailable();
            if (TextUtils.isEmpty(totalavailable)){
                totalavailable = "1";
            }
            String orgName = data.getOrgName();
            final List<CourseDetailEntity.DataBean.TimeScheduleListBean> timeScheduleList = data.getTimeScheduleList();
            courseDetailName.setText(name);
            mainTitle.setText(name);
            if (TextUtils.isEmpty(introduce))
                courseDetailJieshao.setText("暂无介绍");
            else courseDetailJieshao.setText(introduce);
            courseDetailIntroduce.setText(comment);
            courseDetailPrice.setText("￥" + price);
            courseDetailCurrent.setText("已报名" + totalMember + "人");
            courseDetailJoinmax.setText("班级人数" + totalavailable + "人");
            courseDetailLocation.setText(venueName);
            courseDetailAddress.setText(orgName);
            courseDetailLocationValue.setText(location);
            realImgUrl = StringUtil.getRealImgUrl(album);
            if (null != timeScheduleList) {
                if (timeScheduleList.size() < 2) {
                    courseListShowAdapter = new CourseShowListAdapter(context, timeScheduleList);
                    course_detail_show.setAdapter(courseListShowAdapter);
                } else {
                    listTime.add(timeScheduleList.get(0));
                    courseListShowAdapter = new CourseShowListAdapter(context, listTime);
                    initMoreViewList(course_detail_show, "点击查看更多课程", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            showListAnimation(course_detail_show, courseListShowAdapter);
                            listTime = timeScheduleList;
                            courseListShowAdapter.updateMore(listTime);
                            TextView tv = (TextView) view;
                            tv.setText("已显示全部");
                            tv.setTextColor(ContextCompat.getColor(context, R.color.text_black_5c));
                            view.setClickable(false);
                        }
                    }, courseListShowAdapter);
                }
            }
            callback.getCourseReview(courseId, "1");
        } else if (HttpConstant.courseReview.equals(tag)) {
            DetailReviewEntity enti = (DetailReviewEntity) res.body();
            final List<DetailReviewEntity.DataBean> data = enti.getData();
            if (data.size() <= 2) {
                review_show_list.setAdapter(reviewListShowAdapter);
            } else {
                initMoreViewList(review_show_list, "点击查看更多评论", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        showListAnimation(review_show_list, reviewListShowAdapter);
                        reviewListShowAdapter.updateMore(data);
                        TextView tv = (TextView) view;
                        tv.setText("已显示全部");
                        tv.setTextColor(ContextCompat.getColor(context, R.color.text_black_5c));
                        view.setClickable(false);
                    }
                }, reviewListShowAdapter);
            }
            if (data.size() == 0) {
                detailReviewTitle.setVisibility(View.GONE);
            }
            detailAllReview.setText("#共" + data.size() + "评论");

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

    private class MyOnScrollYListener implements HomeScrollView.OnScrollGetYListener {
        ViewGroup parent;

        public MyOnScrollYListener(ViewGroup parent) {
            this.parent = parent;
        }

        @Override
        public void getScrollY(int y) {
            int dertaY = changeY - y;
            int tagHeight = getWindowManager().getDefaultDisplay().getHeight() / 5;
            int scrolledHeight = getWindowManager().getDefaultDisplay().getHeight() / 6;
            ViewUtil.tagShow(parent, dertaY, tagHeight, tagY);
        }

    }

    private class MyReturnBackClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            finish();
        }
    }

    private class MyShareOnclickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            ShareAction showShare = Tools.showShare(CourseDetailActivity.this);
            showShare.setShareboardclickCallback(new ShareBoardlistener() {

                @Override
                public void onclick(SnsPlatform arg0, SHARE_MEDIA arg1) {
                    ShareBean share = new ShareBean();
                    share.content = "微动体育，单单立减，福利来袭！";
                    share.title = "微动体育APP";
                    share.url = HttpConstant.shareUrl;
                    share.image = new UMImage(CourseDetailActivity.this, R.mipmap.msport);
                    Tools.toShare(CourseDetailActivity.this, share, new ShareListener(context) {
                        @Override
                        protected void mySuccess() {
                            CustomToast.createToast().showSuccess(context, "课程分享成功");
                        }
                    }, arg1);

                }
            }).open();
        }
    }


}
