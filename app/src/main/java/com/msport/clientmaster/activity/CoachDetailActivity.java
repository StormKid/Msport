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
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.msport.clientmaster.R;
import com.msport.clientmaster.adapter.ReviewListShowAdapter;
import com.msport.clientmaster.adapter.ZhiZiAdapter;
import com.msport.clientmaster.base.BaseActivity;
import com.msport.clientmaster.bean.CoachExperienceList;
import com.msport.clientmaster.bean.CoachLocationBean;
import com.msport.clientmaster.bean.ShareBean;
import com.msport.clientmaster.callback.MainCallback;
import com.msport.clientmaster.callback.ShareListener;
import com.msport.clientmaster.constants.Constant;
import com.msport.clientmaster.constants.HttpConstant;
import com.msport.clientmaster.entity.CoachDetailEntity;
import com.msport.clientmaster.entity.DetailReviewEntity;
import com.msport.clientmaster.intef.MyViewCallback;
import com.msport.clientmaster.util.CustomToast;
import com.msport.clientmaster.util.ImageUtil;
import com.msport.clientmaster.util.StringUtil;
import com.msport.clientmaster.util.Tools;
import com.msport.clientmaster.util.ViewUtil;
import com.msport.clientmaster.view.HomeScrollView;
import com.msport.clientmaster.view.InnerListView;
import com.msport.clientmaster.view.MyTagViewGroup;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
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
 * Created by like on 2016/8/2.
 */

public class CoachDetailActivity extends BaseActivity implements MyViewCallback {


    @BindView(R.id.back_white)
    ImageView backWhite;
    @BindView(R.id.share_white)
    ImageView shareWhite;
    @BindView(R.id.detail_title)
    RelativeLayout detailTitle;
    @BindView(R.id.yueqiu_detail_img)
    ImageView yueqiuDetailImg;
    @BindView(R.id.detail_title_no_scr)
    RelativeLayout detailTitleNoScr;
    @BindView(R.id.zizhi_show_list)
    InnerListView zizhiShowList;
    @BindView(R.id.review_show_list)
    InnerListView reviewShowList;
    @BindView(R.id.detail_tag_show)
    MyTagViewGroup detailTagShow;
    @BindView(R.id.detail_about_listcourse)
    InnerListView detailAboutListcourse;
    @BindView(R.id.detail_scroll_view)
    HomeScrollView detailScrollView;
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
    @BindView(R.id.go_to_pay)
    Button goToPay;
    @BindView(R.id.coach_name)
    TextView coachName;
    @BindView(R.id.coach_introduce)
    TextView coachIntroduce;
    @BindView(R.id.coach_gender)
    TextView coachGender;
    @BindView(R.id.coach_year)
    TextView coachYear;
    @BindView(R.id.coach_location)
    TextView coachLocation;
    @BindView(R.id.coach_address)
    TextView coachAddress;
    @BindView(R.id.coach_phone)
    TextView coachPhone;
    @BindView(R.id.resource_images)
    LinearLayout resource_images;
    @BindView(R.id.detail_all_review)
    TextView detailAllReview;
    @BindView(R.id.detail_review_title)
    LinearLayout detailReviewTitle;


    private MainCallback callback;

    private int changeY;

    private int tagY;
    private Context context;
    private ReviewListShowAdapter reviewListShowAdapter;
    private String coachId;
    private String id;
    private CoachLocationBean coachLocationBean;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coachdetail);
        ButterKnife.bind(this);
        context = this;
        callback = new MainCallback(this, this);
        coachId = getIntent().getStringExtra(Constant.COACH_ID);
        callback.getCoachDetail(coachId);
        initEvent();
    }

    private void initEvent() {
        detailScrollView.setBackgroundColor(ContextCompat.getColor(context,R.color.white));
        tagY = detailTitleNoScr.getHeight();
        changeY = detailTitleNoScr.getHeight();
        detailTitleChange.getBackground().setAlpha(0);
        detailTitleChange.setAlpha(0);
        detailScrollView.setOnScrollYListener(new MyOnScrollYListener(detailTitleChange));
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
        ViewUtil.createTextview(detailTagShow, this, listTag, false, null, null);
        shareBlack.setOnClickListener(new MyShareOnclickListener());
        shareWhite.setOnClickListener(new MyShareOnclickListener());
    }

    @OnClick({R.id.back_white, R.id.share_white, R.id.back_black, R.id.share_black, R.id.go_to_pay})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_white:
                finish();
                break;
            case R.id.back_black:
                finish();
                break;
            case R.id.go_to_pay:
                checkMember(this);
                break;
        }
    }

    @Override
    protected void Do() {
        Intent intent = new Intent(this, PrepayActivity.class);
        intent.putExtra(Constant.COACH_ID, id);
        intent.putExtra(Constant.COACH_LOCATION, coachLocationBean);
        intent.putExtra(Constant.PROPAY_TYPE, "2");
        startActivity(intent);
    }

    @Override
    public void viewMode(Response res, String tag) {
        if (tag.equals(HttpConstant.coachDetail)) {
            CoachDetailEntity entity = (CoachDetailEntity) res.body();
            CoachDetailEntity.DataBean data = entity.getData();
            String age = data.getAge();
            String fees = data.getFees();
            String name = data.getName();
            String introduce = data.getIntroduce();
            String avatarimg = data.getAvatarimg();
            String realImgUrl = StringUtil.getRealImgUrl(avatarimg);
            String gender = data.getGender();
            String Year = "";
            if (TextUtils.isEmpty(data.getCoachYear())){
                Year = "1";
            }else {
                Year = data.getCoachYear();
            }
            String venueNames = data.getVenueNames();
            String venueAddress = data.getVenueAddress();
            String album = data.getAlbum();
            id = data.getId();
            ImageUtil.getNetImage(context, realImgUrl, yueqiuDetailImg);
            String[] split = album.split("\\|");
            ViewUtil.createImageView(this, split.length, getResources().getDimensionPixelOffset(R.dimen.dp_95), resource_images, split);
            /**
             * 评论
             */
            List<CoachDetailEntity.DataBean.ClientCommentListBean> clientCommentList = data.getClientCommentList();
            /**
             * 执教经历
             */
            final List<CoachExperienceList> coachExperienceList = data.getCoachExperienceList();
            mainTitle.setText(name);
            coachName.setText(name);
            if ("1".equals(gender)) {
                coachGender.setText("性别男");
            } else {
                coachGender.setText("性别女");
            }
            coachIntroduce.setText(introduce);
            coachLocation.setText(venueNames);
            coachAddress.setText(venueAddress);
            coachYear.setText("执教" + Year + "年");

            List<CoachExperienceList> listData = new ArrayList<>();

            if (coachExperienceList.size() > 1) {
                listData.add(coachExperienceList.get(0));
                listData.add(coachExperienceList.get(1));
            } else if (coachExperienceList.size() == 1) {
                listData.add(coachExperienceList.get(0));
            }
            final ZhiZiAdapter zhiZiAdapter = new ZhiZiAdapter(context, listData);
            zizhiShowList.setAdapter(zhiZiAdapter);
            if (coachExperienceList.size() > 2) {
                initMoreViewList(zizhiShowList, "点击查看更多资质", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        showListAnimation(zizhiShowList, zhiZiAdapter);
                        zhiZiAdapter.updateMore(coachExperienceList);
                        TextView tv = (TextView) view;
                        tv.setText("已显示全部");
                        tv.setTextColor(ContextCompat.getColor(context, R.color.text_black_5c));
                        view.setClickable(false);
                    }
                }, zhiZiAdapter);
            }
            detailScrollView.smoothScrollTo(0, 0);
            coachLocationBean = new CoachLocationBean();
            coachLocationBean.vanueAddress = venueAddress;
            coachLocationBean.vanueLocation = venueNames;
            coachLocationBean.name = name;
            coachLocationBean.id = coachId;
            coachLocationBean.price = fees;
            coachLocationBean.courseType = data.getMajor();
            coachLocationBean.realUrl = realImgUrl;
            callback.getCoachReview(coachId, "1");
        } else if (HttpConstant.coachReview.equals(tag)) {
            DetailReviewEntity entity = (DetailReviewEntity) res.body();
            final List<DetailReviewEntity.DataBean> data = entity.getData();
            reviewListShowAdapter = new ReviewListShowAdapter(context, data);
            if (data.size() <= 2) {
                reviewShowList.setAdapter(reviewListShowAdapter);
            } else if (data.size() > 2) {
                initMoreViewList(reviewShowList, "点击查看更多评论", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        showListAnimation(reviewShowList, reviewListShowAdapter);
                        reviewListShowAdapter.updateMore(data);
                        TextView tv = (TextView) view;
                        tv.setText("已显示全部");
                        tv.setTextColor(ContextCompat.getColor(context, R.color.text_black_5c));
                        view.setClickable(false);
                    }
                }, reviewListShowAdapter);
            }
            detailAllReview.setText("#共" + data.size() + "评论");
            detailScrollView.smoothScrollTo(0, 0);
            if (data.size() == 0) {
                detailReviewTitle.setVisibility(View.GONE);
            }
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

    private void showListAnimation(ListView lv, BaseAdapter adapter) {
        int width = getWindowManager().getDefaultDisplay().getWidth();
        Animation animation = new TranslateAnimation(-width, 0f, 0f, 0f);
        animation.setDuration(500);
        //1f为延时
        LayoutAnimationController controller = new LayoutAnimationController(animation, 0.5f);
        controller.setOrder(LayoutAnimationController.ORDER_NORMAL);
        lv.setLayoutAnimation(controller);
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
            ShareAction showShare = Tools.showShare(CoachDetailActivity.this);
            showShare.setShareboardclickCallback(new ShareBoardlistener() {

                @Override
                public void onclick(SnsPlatform arg0, SHARE_MEDIA arg1) {
                    ShareBean share = new ShareBean();
                    share.content = "微动体育，单单立减，福利来袭！";
                    share.title = "微动体育APP";
                    share.url = HttpConstant.shareUrl;
                    share.image = new UMImage(CoachDetailActivity.this, R.mipmap.msport);
                    Tools.toShare(CoachDetailActivity.this, share, umShareListener, arg1);

                }
            }).open();


        }
    }

    private void initMoreViewList(ListView lv, String text, View.OnClickListener listener, BaseAdapter adapter) {
        View ListFootView = LayoutInflater.from(context).inflate(R.layout.item_detail_list_show_foot, null);
        TextView footView = (TextView) ListFootView.findViewById(R.id.get_more_list);
        footView.setText(text);
        lv.addFooterView(ListFootView);
        lv.setAdapter(adapter);
        footView.setOnClickListener(listener);
    }

    private UMShareListener umShareListener = new ShareListener(this) {

        @Override
        protected void mySuccess() {
            CustomToast.createToast().showSuccess(context, "分享成功");
        }
    };

}
