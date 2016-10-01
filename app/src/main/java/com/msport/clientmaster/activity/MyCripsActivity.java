package com.msport.clientmaster.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.msport.clientmaster.R;
import com.msport.clientmaster.adapter.MyCripseAdapter;
import com.msport.clientmaster.base.BaseActivity;
import com.msport.clientmaster.callback.MainCallback;
import com.msport.clientmaster.constants.Constant;
import com.msport.clientmaster.constants.HttpConstant;
import com.msport.clientmaster.entity.MyCripsEntity;
import com.msport.clientmaster.intef.MyViewCallback;
import com.msport.clientmaster.util.PublicPreferencesUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Response;

/**
 * Created by like on 2016/8/25.
 */

public class MyCripsActivity extends BaseActivity implements MyViewCallback {


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
    @BindView(R.id.youhuiquan_my_list)
    RecyclerView youhuiquanMyList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mycrips);
        ButterKnife.bind(this);
        MainCallback callback = new MainCallback(this, this);
        String memberId = PublicPreferencesUtils.getString(this, Constant.NUTZER_ID);
        callback.getMyCrips(memberId);
        mainTitle.setText("我的优惠券");
        shareBlack.setVisibility(View.GONE);
        youhuiquanMyList.setBackgroundColor(ContextCompat.getColor(this,R.color.bg_gray_f0f2f5));
    }


    @OnClick(R.id.back_black)
    public void onClick() {
        finish();
    }

    @Override
    public void viewMode(Response res, String tag) {
        if (tag.equals(HttpConstant.getYouhuilist)) {
            MyCripsEntity entity = (MyCripsEntity) res.body();
            MyCripsEntity.DataBean data = entity.getData();
            List<MyCripsEntity.DataBean.CouponBean> coupon = data.getCoupon();
            MyCripseAdapter adapter = new MyCripseAdapter(coupon,this);
                    LinearLayoutManager manager = new LinearLayoutManager(this);
            manager.setOrientation(LinearLayoutManager.VERTICAL);
            youhuiquanMyList.setLayoutManager(manager);
            youhuiquanMyList.setAdapter(adapter);
        }

    }

    @Override
    public void getFalse(boolean tag, String message) {

    }

    @Override
    public void showCode(int code, String string) {

    }
}
