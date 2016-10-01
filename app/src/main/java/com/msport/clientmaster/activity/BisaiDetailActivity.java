package com.msport.clientmaster.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.msport.clientmaster.R;
import com.msport.clientmaster.base.BaseActivity;
import com.msport.clientmaster.bean.ShareBean;
import com.msport.clientmaster.callback.ShareListener;
import com.msport.clientmaster.constants.Constant;
import com.msport.clientmaster.constants.HttpConstant;
import com.msport.clientmaster.entity.BisaiListEntity;
import com.msport.clientmaster.util.CustomToast;
import com.msport.clientmaster.util.ImageUtil;
import com.msport.clientmaster.util.StringUtil;
import com.msport.clientmaster.util.TimeUtils;
import com.msport.clientmaster.util.Tools;
import com.msport.clientmaster.util.ViewUtil;
import com.msport.clientmaster.view.HomeScrollView;
import com.msport.clientmaster.view.JustifyTextView;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.shareboard.SnsPlatform;
import com.umeng.socialize.utils.ShareBoardlistener;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by like on 2016/8/5.
 */

public class BisaiDetailActivity extends BaseActivity {

    @BindView(R.id.back_white)
    ImageView backWhite;
    @BindView(R.id.share_white)
    ImageView shareWhite;
    @BindView(R.id.detail_title)
    RelativeLayout detailTitle;
    @BindView(R.id.detail_title_no_scr)
    RelativeLayout detailTitleNoScr;
    @BindView(R.id.bisai_detail_title)
    TextView bisaiDetailTitle;
    @BindView(R.id.bisai_detail_member)
    TextView bisaiDetailMember;
    @BindView(R.id.bisai_detial_price)
    TextView bisaiDetialPrice;
    @BindView(R.id.bisai_detail_locaition)
    TextView bisaiDetailLocaition;
    @BindView(R.id.bisai_detail_address)
    TextView bisaiDetailAddress;
    @BindView(R.id.bisai_detail_time)
    TextView bisaiDetailTime;
    @BindView(R.id.textView)
    TextView textView;
    @BindView(R.id.bisai_detail_notice)
    JustifyTextView bisaiDetailNotice;
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
    @BindView(R.id.bisai_detail_img)
    ImageView bisaiDetailImg;
    private BisaiListEntity.DataBean data;
    private int changeY;
    private int tagY;
    private Context context;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bisai_detail);
        ButterKnife.bind(this);
        data = (BisaiListEntity.DataBean) getIntent().getSerializableExtra(Constant.BISAI_CONS);
        context=this;
        InitView();
    }

    /**
     * 填充页面
     */
    private void InitView() {
        detailScrollView.setBackgroundColor(ContextCompat.getColor(this,R.color.white));
        if (data != null) {
            String name = data.getName();
            String fees = data.getFees();
            String timeEnd = data.getTimeEnd();
            String timeStart = data.getTimeStart();
            String totalParticipants = data.getTotalParticipants();
            String avatarList = data.getAvatarList();
            String customAddress = data.getCustomAddress();
            String venueName = data.getVenueName();
            String activiNotice = data.getActiviNotice();
            String realImgUrl = StringUtil.getRealImgUrl(avatarList);

            bisaiDetailTitle.setText(name);
            mainTitle.setText(name);
            bisaiDetailLocaition.setText(venueName);
            bisaiDetailAddress.setText(customAddress);
            bisaiDetialPrice.setText("￥" + fees);
            String startReal = TimeUtils.getRealTime(timeStart);
            String realData = TimeUtils.getRealTime(timeEnd);
            String[] endReal = realData.split("\\s+");
            bisaiDetailTime.setText("时间：" + startReal + "至" + endReal[1]);
            bisaiDetailNotice.setText(activiNotice);
            ImageUtil.getNetImage(this,realImgUrl,bisaiDetailImg,R.mipmap.see);
            bisaiDetailMember.setText("比赛人数："+totalParticipants+"人");
        }
        tagY = detailTitleNoScr.getHeight();
        changeY = detailTitleNoScr.getHeight();
        detailTitleChange.getBackground().setAlpha(0);
        detailTitleChange.setAlpha(0);
        detailScrollView.setOnScrollYListener(new MyOnScrollYListener(detailTitleChange));
        shareBlack.setOnClickListener(new MyShareOnclickListener());
        shareWhite.setOnClickListener(new MyShareOnclickListener());
    }

    @OnClick({R.id.back_white, R.id.go_to_pay, R.id.back_black})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_black:
            case R.id.back_white:
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
        Intent intent = new Intent(this,PrepayActivity.class);
        intent.setClass(this, PrepayActivity.class);
        intent.putExtra("BisaiBean", data);
        intent.putExtra(Constant.PROPAY_TYPE, "5");
        startActivity(intent);
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

    private class MyShareOnclickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            ShareAction showShare = Tools.showShare(BisaiDetailActivity.this);
            showShare.setShareboardclickCallback(new ShareBoardlistener() {

                @Override
                public void onclick(SnsPlatform arg0, SHARE_MEDIA arg1) {
                    ShareBean share = new ShareBean();
                    share.content = "微动体育，单单立减，福利来袭！";
                    share.title = "微动体育APP";
                    share.url = HttpConstant.shareUrl;
                    share.image = new UMImage(BisaiDetailActivity.this, R.mipmap.msport);
                    Tools.toShare(BisaiDetailActivity.this, share, umShareListener, arg1);

                }
            }).open();


        }
    }
    private UMShareListener umShareListener = new ShareListener(this) {

        @Override
        protected void mySuccess() {
            CustomToast.createToast().showSuccess(context, "分享成功");
        }
    };


}
