package com.msport.clientmaster.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.msport.clientmaster.R;
import com.msport.clientmaster.base.BaseActivity;
import com.msport.clientmaster.bean.ShareBean;
import com.msport.clientmaster.bean.YueQiuDetailBean;
import com.msport.clientmaster.callback.MainCallback;
import com.msport.clientmaster.callback.ShareListener;
import com.msport.clientmaster.constants.Constant;
import com.msport.clientmaster.constants.HttpConstant;
import com.msport.clientmaster.entity.YueQiuDetaiEntity;
import com.msport.clientmaster.intef.MyViewCallback;
import com.msport.clientmaster.util.CustomToast;
import com.msport.clientmaster.util.TimeUtils;
import com.msport.clientmaster.util.Tools;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.shareboard.SnsPlatform;
import com.umeng.socialize.utils.ShareBoardlistener;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Response;

/**
 * Created by like on 2016/7/27.
 */

public class YueQiuDetailActivity extends BaseActivity implements MyViewCallback {
    @BindView(R.id.yueqiu_detail_content)
    TextView yueqiu_detail_content;

    @BindView(R.id.yueqiu_detail_title)
    TextView yueqiu_detail_title;

    @BindView(R.id.yueqiu_detail_price)
    TextView yueqiu_detail_price;

    @BindView(R.id.yueqiu_detail_location)
    TextView yueqiu_detail_location;

    @BindView(R.id.yueqiu_detail_time)
    TextView yueqiu_detail_time;

    @BindView(R.id.yueqiu_detail_about)
    TextView yueqiu_detail_about;
    @BindView(R.id.title_right_tv)
    TextView titleRightTv;
    @BindView(R.id.detail_title_change)
    LinearLayout detailTitleChange;
    @BindView(R.id.yueqiu_detail_image_container)
    LinearLayout yueqiuDetailImageContainer;
    @BindView(R.id.go_to_pay)
    Button goToPay;
    @BindView(R.id.title_up_down)
    ImageView titleUpDown;
    @BindView(R.id.contain_alls)
    LinearLayout containAlls;


    private MainCallback callback;
    private String inviteid;


    @BindView(R.id.back_black)
    ImageView back_black;

    @BindView(R.id.share_black)
    ImageView share_black;

    @BindView(R.id.main_title)
    TextView main_title;

    @BindView(R.id.course_detail_jieshao)
    TextView course_detail_jieshao;

    private Context context;
    private YueQiuDetailBean data;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yueqiu_detail);
        context = this;
        ButterKnife.bind(this);
        initView();
        callback = new MainCallback(this, this);
        inviteid = getIntent().getStringExtra(Constant.INVITEID);
        containAlls.setBackgroundColor(ContextCompat.getColor(context,R.color.white));
        callback.getYueQiuDetail(inviteid);
        share_black.setOnClickListener(new MyShareOnclickListener());
    }

    private void initView() {
        main_title.setText("约球信息");
    }


    @OnClick({R.id.back_black, R.id.go_to_pay})
    public void onClick(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {
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
        super.Do();
        Intent intent = new Intent();
        intent.setClass(this, PrepayActivity.class);
        intent.putExtra("YueQiuDetailBean", data);
        intent.putExtra(Constant.PROPAY_TYPE, "3");
        startActivity(intent);
    }

    @Override
    public void viewMode(Response res, String tag) {
        if (HttpConstant.getYueQiuDetail.equals(tag)) {
            YueQiuDetaiEntity entity = (YueQiuDetaiEntity) res.body();
            data = entity.getData();
            String name = data.getName();
            String activiComment = data.getActiviComment();
            String fees = data.getFees();
            String timeStart = data.getTimeStart();
            String minParticipants = data.getMinParticipants();
            String currentParticipants = data.getCurrentParticipants();
            String customAddress = data.getCustomAddress();
            String timeEnd = data.getTimeEnd();
            String telephone = data.getTelephone();
            String totalParticipants = data.getTotalParticipants();
            String customName = data.getCustomName();
            yueqiu_detail_title.setText(name);
            yueqiu_detail_price.setText("¥" + fees);
            yueqiu_detail_content.setText(customName);
            yueqiu_detail_location.setText("活动地点：" + customAddress);
            String realStart = TimeUtils.getRealTime(timeStart);
            String real= TimeUtils.getRealTime(timeEnd);
            String[] split = real.split("\\s+");
            String realEnd = split[1];
            yueqiu_detail_time.setText("活动时间：" + realStart + " 至 " + realEnd);
            yueqiu_detail_about.setText("报名情况" + currentParticipants + "/" + totalParticipants + "人");
            course_detail_jieshao.setText(activiComment);
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
    private class MyShareOnclickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            ShareAction showShare = Tools.showShare(YueQiuDetailActivity.this);
            showShare.setShareboardclickCallback(new ShareBoardlistener() {

                @Override
                public void onclick(SnsPlatform arg0, SHARE_MEDIA arg1) {
                    ShareBean share = new ShareBean();
                    share.content = "微动体育，单单立减，福利来袭！";
                    share.title = "微动体育APP";
                    share.url = HttpConstant.shareUrl;
                    share.image = new UMImage(context, R.mipmap.msport);
                    Tools.toShare(YueQiuDetailActivity.this, share, new ShareListener(context) {
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
