package com.msport.clientmaster.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.msport.clientmaster.R;
import com.msport.clientmaster.adapter.MyMessageAdapter;
import com.msport.clientmaster.base.BaseActivity;
import com.msport.clientmaster.callback.MainCallback;
import com.msport.clientmaster.constants.HttpConstant;
import com.msport.clientmaster.entity.MyMessageEntity;
import com.msport.clientmaster.intef.MyViewCallback;
import com.msport.clientmaster.util.CustomToast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Response;

/**
 * Created by like on 2016/8/16.
 */

public class MyMessageActivity extends BaseActivity implements MyViewCallback {

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
    @BindView(R.id.my_message_contain)
    ListView myMessageContain;
    @BindView(R.id.refresh_layout)
    SwipeRefreshLayout refreshLayout;
    private MainCallback callback;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mymessage);
        ButterKnife.bind(this);
        iniView();
    }

    private void iniView() {
        mainTitle.setText("消息中心");
        shareBlack.setVisibility(View.GONE);
        callback = new MainCallback(this, this);
        callback.getXiaoxi("1", true);
        refreshLayout.setColorSchemeResources(R.color.bg_orange);
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                    callback.getXiaoxi("1", false);
            }
        });
    }

    @OnClick(R.id.back_black)
    public void onClick() {
        finish();
    }

    @Override
    public void viewMode(Response res, String tag) {
        if (HttpConstant.xiaoxi.equals(tag)) {
            MyMessageEntity entity = (MyMessageEntity) res.body();
            List<MyMessageEntity.DataBean> data = entity.getData();
            myMessageContain.setAdapter(new MyMessageAdapter(this, data));
            refreshLayout.setRefreshing(false);
        }


    }

    @Override
    public void getFalse(boolean tag, String message) {
        if (message.equals(HttpConstant.xiaoxi)) {
            CustomToast.createToast().showFaild(this, "获得消息列表失败，请重新获取");
            refreshLayout.setRefreshing(false);
        }


    }

    @Override
    public void showCode(int code, String string) {

    }
}
