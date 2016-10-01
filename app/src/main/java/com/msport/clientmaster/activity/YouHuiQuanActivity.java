package com.msport.clientmaster.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.msport.clientmaster.R;
import com.msport.clientmaster.adapter.CripsAdapter;
import com.msport.clientmaster.base.BaseActivity;
import com.msport.clientmaster.callback.MainCallback;
import com.msport.clientmaster.callback.MyOnScrollYListener;
import com.msport.clientmaster.constants.Constant;
import com.msport.clientmaster.constants.HttpConstant;
import com.msport.clientmaster.entity.CripEntity;
import com.msport.clientmaster.intef.MyViewCallback;
import com.msport.clientmaster.util.CustomToast;
import com.msport.clientmaster.util.PublicPreferencesUtils;
import com.msport.clientmaster.view.HomeScrollView;
import com.msport.clientmaster.view.InnerListView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Response;

/**
 * Created by like on 2016/8/24.
 */

public class YouHuiQuanActivity extends BaseActivity implements MyViewCallback {

    @BindView(R.id.youhuiquan_image)
    ImageView youhuiquanImage;
    @BindView(R.id.back_white)
    ImageView backWhite;
    @BindView(R.id.youhuiquan_contain)
    RelativeLayout youhuiquanContain;
    @BindView(R.id.men_piao_container)
    InnerListView menPiaoContainer;
    @BindView(R.id.youhuiquan_scorll)
    HomeScrollView youhuiquanScorll;
    @BindView(R.id.hint_show)
    View hintShow;
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
    @BindView(R.id.refresh_layout)
    SwipeRefreshLayout refreshLayout;
    private int tagY;
    private int changeY;
    private MainCallback callback;
    private String memberId;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youhuiquan);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        memberId = PublicPreferencesUtils.getString(this,Constant.NUTZER_ID);
        tagY = youhuiquanContain.getHeight();
        changeY = youhuiquanContain.getHeight();
        detailTitleChange.getBackground().setAlpha(0);
        detailTitleChange.setAlpha(0);
        youhuiquanScorll.setOnScrollYListener(new MyOnScrollYListener(detailTitleChange, this, tagY, changeY));
        callback = new MainCallback(this, this);
        shareBlack.setVisibility(View.GONE);
        mainTitle.setText("优惠券");
        callback.getYouhuiQuan(true, memberId);
        refreshLayout.setColorSchemeResources(R.color.bg_orange);
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                callback.getYouhuiQuan(false, memberId);
            }
        });
        youhuiquanScorll.setOnLoadMoreListener(new HomeScrollView.onLoadMoreListener() {
            @Override
            public void loadMore() {

            }
        });
        youhuiquanScorll.setBackgroundColor(ContextCompat.getColor(this,R.color.white));

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
        if (tag.equals(HttpConstant.youhuilist)) {
            CripEntity entity = (CripEntity) res.body();
            List<CripEntity.DataBean> been = entity.getData();
            CripsAdapter huiAdapter = new CripsAdapter(this, been);
            menPiaoContainer.setAdapter(huiAdapter);
            refreshLayout.setRefreshing(false);
        }

    }

    @Override
    public void getFalse(boolean tag, String message) {
        CustomToast.createToast().showFaild(this, "优惠券列表查不到啦，请重新刷新");
        refreshLayout.setRefreshing(false);
    }

    @Override
    public void showCode(int code, String string) {

    }
}
