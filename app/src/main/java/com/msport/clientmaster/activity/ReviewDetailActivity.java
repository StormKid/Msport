package com.msport.clientmaster.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.msport.clientmaster.R;
import com.msport.clientmaster.base.BaseActivity;
import com.msport.clientmaster.callback.MainCallback;
import com.msport.clientmaster.constants.Constant;
import com.msport.clientmaster.constants.HttpConstant;
import com.msport.clientmaster.entity.ReviewDetailEntity;
import com.msport.clientmaster.intef.MyViewCallback;
import com.msport.clientmaster.requestbean.ReviewRequestBean;
import com.msport.clientmaster.util.CustomToast;
import com.msport.clientmaster.util.ImageUtil;
import com.msport.clientmaster.util.PublicPreferencesUtils;
import com.msport.clientmaster.util.StringUtil;
import com.msport.clientmaster.view.MyTagViewGroup;
import com.msport.clientmaster.view.SimpleRatingBar;

import org.simple.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Response;

/**
 * Created by like on 2016/8/17.
 */

public class ReviewDetailActivity extends BaseActivity implements MyViewCallback {

    @BindView(R.id.review_image)
    ImageView reviewImage;
    @BindView(R.id.review_rating)
    SimpleRatingBar reviewRating;
    @BindView(R.id.review_left_back)
    ImageView reviewLeftBack;
    @BindView(R.id.review_commit)
    TextView reviewCommit;
    @BindView(R.id.review_content)
    EditText reviewContent;
    @BindView(R.id.review_tag)
    MyTagViewGroup reviewTag;
    @BindView(R.id.contain_alls)
    ViewGroup contain_alls;
    private Context context;
    private String coachDegree;

    private ReviewRequestBean bean = new ReviewRequestBean();
    private MainCallback callback;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity_reviewdetail);
        ButterKnife.bind(this);
        context = this;
        InitView();
        contain_alls.setBackgroundColor(ContextCompat.getColor(context, R.color.white));

    }

    private void InitView() {
        reviewRating.setStepSize(1);
        String type = getIntent().getStringExtra(Constant.REVIEW_TYPE);
        String billId = getIntent().getStringExtra(Constant.BILL_ID);
        callback = new MainCallback(this, context);
        switch (type) {
            case "1"://点评
                reviewRating.setOnRatingBarChangeListener(new SimpleRatingBar.OnRatingBarChangeListener() {
                    @Override
                    public void onRatingChanged(SimpleRatingBar simpleRatingBar, float rating, boolean fromUser) {
                        int round = Math.round(rating);
                        coachDegree = round + "";
                    }
                });
                bean = (ReviewRequestBean) getIntent().getSerializableExtra(Constant.ADDREVIEW);
                reviewRating.setRating(3);
                break;
            case "0": //查看评论
                reviewCommit.setVisibility(View.GONE);
                callback.getReviewDetail(billId);
//                List<String> list = new ArrayList<>();
//                list.add("教学严谨");
//                list.add("安静");
//                ViewUtil.createTextview(reviewTag, this, list, false, null, new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        TextView textView = (TextView) view;
//                        boolean showTag = false;
//                        if (textView.getTag() == null) {
//                            showTag = true;
//                        } else {
//                            showTag = (boolean) textView.getTag();
//                        }
//                        if (showTag) {
//                            textView.setBackgroundResource(R.drawable.shape_categroy_tagdo);
//                            textView.setTextColor(ContextCompat.getColor(context, R.color.text_orange));
//                            showTag = false;
//                        } else {
//                            textView.setBackgroundResource(R.drawable.shape_categroy_tagnone);
//                            textView.setTextColor(ContextCompat.getColor(context, R.color.text_gray_A3));
//                            showTag = true;
//                        }
//                        textView.setTag(showTag);
//                    }
//                });
                break;
        }


    }

    @OnClick({R.id.review_left_back, R.id.review_commit})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.review_left_back:
                finish();
                break;
            case R.id.review_commit:
                coachDegree = Math.round(reviewRating.getRating()) + "";
                String content = reviewContent.getText().toString();
                if (TextUtils.isEmpty(content)) {
                    CustomToast.createToast().showFaild(context, "请输入对教练的评价");
                    break;
                }
                String memberId = PublicPreferencesUtils.getString(context, Constant.NUTZER_ID);
                bean.setMemberId(memberId);
                bean.setCreateTime(System.currentTimeMillis() + "");
                String type = bean.getType();
                switch (type) {
                    case "0":
                        bean.setCourseDegree(coachDegree);
                        break;
                    case "1":
                        bean.setCoachDegree(coachDegree);

                        break;
                }
                bean.setCommentIds("-1");
                callback.addReview(bean);
                break;
        }
    }

    @Override
    public void viewMode(Response res, String tag) {

        if (HttpConstant.reviewDetail.equals(tag)) {
            ReviewDetailEntity entity = (ReviewDetailEntity) res.body();
            ReviewDetailEntity.DataBean data = entity.getData();
            String coachDegree = data.getCoachDegree();
            String extraMemberImage = data.getExtraMemberImage();
            String realImgUrl = StringUtil.getRealImgUrl(extraMemberImage);
            String extraMemberName = data.getExtraMemberName();
            String content = data.getContent();
            ImageUtil.getNetImage(this, realImgUrl, reviewImage);
            if (coachDegree == null)
                coachDegree = "0";
            int coachDegreed = Integer.parseInt(coachDegree);
            reviewRating.setRating(coachDegreed);
            reviewRating.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    return true;
                }
            });
            reviewContent.setText(content);
            reviewContent.clearFocus();
            reviewContent.setFocusable(false);
        } else if (tag.equals(HttpConstant.addReview)) {
            CustomToast.createToast().showSuccess(context, "添加评论成功");
            EventBus.getDefault().post("!2",Constant.REVIEW_REFRESH);
            finish();
        }

    }

    @Override
    public void getFalse(boolean tag, String message) {
        if (message.equals(HttpConstant.addReview)) {
            CustomToast.createToast().showFaild(context, "添加评论失败，请重新获取评论信息");
            finish();
        } else {
            CustomToast.createToast().showFaild(context, "查询评论失败，请检查网络链接");
            finish();
        }

    }

    @Override
    public void showCode(int code, String string) {

    }
}
