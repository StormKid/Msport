package com.msport.clientmaster.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.msport.clientmaster.R;
import com.msport.clientmaster.adapter.InnerMenpiaoAdapter;
import com.msport.clientmaster.base.BaseActivity;
import com.msport.clientmaster.callback.MainCallback;
import com.msport.clientmaster.callback.MyOnScrollYListener;
import com.msport.clientmaster.constants.Constant;
import com.msport.clientmaster.constants.HttpConstant;
import com.msport.clientmaster.entity.LocationDetailEntity;
import com.msport.clientmaster.intef.MyViewCallback;
import com.msport.clientmaster.requestbean.VenueRequestBean;
import com.msport.clientmaster.util.CustomToast;
import com.msport.clientmaster.util.ImageUtil;
import com.msport.clientmaster.util.StringUtil;
import com.msport.clientmaster.util.TimeUtils;
import com.msport.clientmaster.util.ViewUtil;
import com.msport.clientmaster.view.HomeScrollView;
import com.msport.clientmaster.view.InnerListView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Response;

/**
 * Created by like on 2016/8/23.
 */

public class LoactionDetailActivity extends BaseActivity implements MyViewCallback {

    @BindView(R.id.bisai_changguan_detail_img)
    ImageView bisaiChangguanDetailImg;
    @BindView(R.id.back_white)
    ImageView backWhite;
    @BindView(R.id.share_white)
    ImageView shareWhite;
    @BindView(R.id.changguan_detail_title)
    RelativeLayout changguanDetailTitle;
    @BindView(R.id.changguan_detail_title_no_scr)
    RelativeLayout changguanDetailTitleNoScr;
    @BindView(R.id.textView4)
    TextView textView4;
    @BindView(R.id.bisai_changguan_detail_locaition)
    TextView bisaiChangguanDetailLocaition;
    @BindView(R.id.bisai_changguan_detail_address)
    TextView bisaiChangguanDetailAddress;
    @BindView(R.id.changguan_detail_adress)
    LinearLayout changguanDetailAdress;
    @BindView(R.id.bisai_changguan_detail_phonenum)
    TextView bisaiChangguanDetailPhonenum;
    @BindView(R.id.bisai_changguan_detail_cellphone)
    LinearLayout bisaiChangguanDetailCellphone;
    @BindView(R.id.bisai_changguan_detail_time)
    TextView bisaiChangguanDetailTime;
    @BindView(R.id.bisai_changguan_detail_innermenpiao)
    InnerListView bisaiChangguanDetailInnermenpiao;
    @BindView(R.id.textView)
    TextView textView;
    @BindView(R.id.changguan_detail_images)
    LinearLayout changguanDetailImages;
    @BindView(R.id.changguan_detail_scroll_view)
    HomeScrollView changguanDetailScrollView;
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
    @BindView(R.id.changguan_detail_name)
    TextView changguanDetailName;
    @BindView(R.id.location_menpiao_contain)
    TextView locationMenpiaoContain;
    private int tagY;
    private int changeY;
    private MainCallback callback;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_detail);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        changguanDetailScrollView.setBackgroundColor(ContextCompat.getColor(this, R.color.white));
        String menpiaoId = getIntent().getStringExtra(Constant.MENPIAO_ID);
        tagY = changguanDetailTitleNoScr.getHeight();
        changeY = changguanDetailTitleNoScr.getHeight();
        detailTitleChange.getBackground().setAlpha(0);
        detailTitleChange.setAlpha(0);
        changguanDetailScrollView.setOnScrollYListener(new MyOnScrollYListener(detailTitleChange, this, tagY, changeY));
        shareBlack.setVisibility(View.GONE);
        callback = new MainCallback(this, this);
        VenueRequestBean bean = new VenueRequestBean();
        bean.venueId = menpiaoId;
//        bean.venueId = "26";
        callback.getChangGuanDetail(bean);

    }

    @OnClick({R.id.back_white, R.id.back_black})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_white:
            case R.id.back_black:
                finish();
                break;
        }
    }

    @Override
    public void viewMode(Response res, String tag) {
        if (tag.equals(HttpConstant.menPiaoDetail)) {
            LocationDetailEntity entity = (LocationDetailEntity) res.body();
            LocationDetailEntity.DataBean dataBean = entity.getData();
            String gateimage = dataBean.getGateimage();
            String name = dataBean.getName();
            String address = dataBean.getAddress();
            String businesshoursend = dataBean.getBusinesshoursend();
            String businesshoursstart = dataBean.getBusinesshoursstart();
            String telephone = dataBean.getTelephone();
            List<LocationDetailEntity.DataBean.TicketListBean> ticketList = dataBean.getTicketList();
            if (ticketList.size()==0){
                locationMenpiaoContain.setText("该场馆暂无门票");
            }
            String titleImage = dataBean.getTitleImage();
            String realImgUrl = StringUtil.getRealImgUrl(titleImage);
            ImageUtil.getNetImage(this, realImgUrl, bisaiChangguanDetailImg, R.mipmap.menpiao_detail);
            changguanDetailName.setText(name);
            mainTitle.setText(name);
            bisaiChangguanDetailAddress.setText(address);
            bisaiChangguanDetailLocaition.setText(name);
            bisaiChangguanDetailTime.setText(TimeUtils.getTime(businesshoursstart,true) + "-" + TimeUtils.getTime(businesshoursend,true));
            String[] images = gateimage.split("\\|");
            int size = getResources().getDimensionPixelOffset(R.dimen.dp_100);
            ViewUtil.createImageView(this, images.length, size, changguanDetailImages, images);
            InnerMenpiaoAdapter adapter = new InnerMenpiaoAdapter(this, ticketList, name, address, telephone);
            bisaiChangguanDetailInnermenpiao.setAdapter(adapter);
            bisaiChangguanDetailPhonenum.setText(telephone);

        }

    }

    @Override
    public void getFalse(boolean tag, String message) {
        CustomToast.createToast().showFaild(this, "网络不给力，请重新请求网络连接");
        locationMenpiaoContain.setText("该场馆暂无门票");
    }

    @Override
    public void showCode(int code, String string) {

    }
}
