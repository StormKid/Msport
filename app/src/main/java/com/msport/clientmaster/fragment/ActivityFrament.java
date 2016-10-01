package com.msport.clientmaster.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.msport.clientmaster.R;
import com.msport.clientmaster.adapter.YueqiuJoinAdapter;
import com.msport.clientmaster.callback.MainCallback;
import com.msport.clientmaster.constants.Constant;
import com.msport.clientmaster.constants.HttpConstant;
import com.msport.clientmaster.entity.ActivityEntity;
import com.msport.clientmaster.intef.MyViewCallback;
import com.msport.clientmaster.util.CustomToast;
import com.msport.clientmaster.util.PublicPreferencesUtils;
import com.msport.clientmaster.view.MyLoadMoreRecyclerView;

import org.simple.eventbus.Subscriber;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Response;

/**
 * Created by like on 2016/8/20.
 */
@SuppressLint("ValidFragment")
public class ActivityFrament extends BaseListFragment implements MyViewCallback {
    @BindView(R.id.qianbao_list_contain)
    MyLoadMoreRecyclerView qianbaoListContain;
    @BindView(R.id.refresh_layout)
    SwipeRefreshLayout refreshLayout;
    private int let;
    private Context context;
    private List<ActivityEntity.DataBean> data;
    private String memberId;
    private MainCallback callback;

    public ActivityFrament(int let, Context context) {
        this.let = let;
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_qianbaolist, null);
        ButterKnife.bind(this, view);
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                callback.getMyActivity(memberId, let + "", context,false);
            }
        });

        return view;
    }

    private void initView() {
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        qianbaoListContain.setLayoutManager(manager);
        qianbaoListContain.setAdapter(new YueqiuJoinAdapter(let, data, getActivity()));
        refreshLayout.setColorSchemeResources(R.color.bg_orange);


    }

    @Override
    protected void initData() {
        super.initData();
        callback = new MainCallback(this, context);
        memberId = PublicPreferencesUtils.getString(context, Constant.NUTZER_ID);
        callback.getMyActivity(memberId, let + "", context, true);

    }

    @Override
    public void viewMode(Response res, String tag) {
        if (HttpConstant.myActivity.equals(tag)) {
            ActivityEntity ae = (ActivityEntity) res.body();
            data = ae.getData();
            initView();
            refreshLayout.setRefreshing(false);
        }

    }

    @Override
    public void getFalse(boolean tag, String message) {
        CustomToast.createToast().showFaild(context,"网络不给力，请检查网络连接");
        refreshLayout.setRefreshing(false);
    }

    @Override
    public void showCode(int code, String string) {

    }

    @Subscriber(tag = Constant.ACTIVITY_FINISH)
    public void repeak(String u) {
        initData();
    }
}
