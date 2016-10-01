package com.msport.clientmaster.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.msport.clientmaster.R;
import com.msport.clientmaster.activity.BisaiDetailActivity;
import com.msport.clientmaster.adapter.BisaiListAdapter;
import com.msport.clientmaster.callback.MainCallback;
import com.msport.clientmaster.constants.Constant;
import com.msport.clientmaster.constants.HttpConstant;
import com.msport.clientmaster.entity.BisaiListEntity;
import com.msport.clientmaster.intef.MyViewCallback;
import com.msport.clientmaster.util.CustomToast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Response;

/**
 * Created by like on 2016/7/22.
 */
@SuppressLint("ValidFragment")
public class BisaiFragment extends BaseListFragment implements MyViewCallback {

    @BindView(R.id.bisai_list)
    RecyclerView bisai_list;
    @BindView(R.id.refresh_layout)
    SwipeRefreshLayout refreshLayout;
    private BisaiListAdapter bisaiListAdapter;
    private Context context;
    private MainCallback call;

    public BisaiFragment(Context context) {
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bisai, null);
        ButterKnife.bind(this, view);
        initView();
        refreshLayout.setColorSchemeResources(R.color.bg_orange);
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                call.getBisaiList("1", false);
            }
        });
        return view;
    }

    private void initView() {
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setAutoMeasureEnabled(true);
        bisai_list.setLayoutManager(manager);
        call = new MainCallback(this, context);
        call.getBisaiList("1", true);

    }


    @Override
    public void viewMode(Response res, String tag) {
        if (HttpConstant.queryBisaiList.equals(tag)) {
            BisaiListEntity entity = (BisaiListEntity) res.body();
            List<BisaiListEntity.DataBean> data = entity.getData();
            bisaiListAdapter = new BisaiListAdapter(getActivity(), data);
            bisai_list.setAdapter(bisaiListAdapter);
            bisaiListAdapter.setOnViewClickListener(new BisaiListAdapter.OnViewClickListener() {
                @Override
                public void onclickListener(BisaiListEntity.DataBean listData, int position) {
                    Intent intent = new Intent(context, BisaiDetailActivity.class);
                    intent.putExtra(Constant.BISAI_CONS, listData);
                    startActivity(intent);
                }
            });
            refreshLayout.setRefreshing(false);
        }

    }

    @Override
    public void getFalse(boolean tag, String message) {
        if (tag) {
            CustomToast.createToast().showFaild(getActivity(), "网络链接异常，请检查网络链接");
            refreshLayout.setRefreshing(false);
        }
    }

    @Override
    public void showCode(int code, String string) {

    }
}
