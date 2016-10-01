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
import com.msport.clientmaster.adapter.QianBaoListAdapter;
import com.msport.clientmaster.callback.MainCallback;
import com.msport.clientmaster.constants.Constant;
import com.msport.clientmaster.constants.HttpConstant;
import com.msport.clientmaster.entity.QianbaoListEntity;
import com.msport.clientmaster.intef.MyViewCallback;
import com.msport.clientmaster.util.CustomToast;
import com.msport.clientmaster.util.PublicPreferencesUtils;
import com.msport.clientmaster.util.StringUtil;
import com.msport.clientmaster.view.MyLoadMoreRecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Response;

/**
 * Created by like on 2016/8/16.
 */
@SuppressLint("ValidFragment")
public class QianBaoListFragment extends BaseListFragment implements MyViewCallback {
    @BindView(R.id.qianbao_list_contain)
    MyLoadMoreRecyclerView qianbaoListContain;
    @BindView(R.id.refresh_layout)
    SwipeRefreshLayout refreshLayout;
    private int type;
    private final String memberId;
    private Context context;
    private List<QianbaoListEntity.DataBean> list;
    private MainCallback callback;
    private String pageIndex = "1";
    private boolean isLoad ;
    private QianBaoListAdapter qianBaoListAdapter;

    public QianBaoListFragment(int type, Context context) {
        this.type = type;
        this.context = context;
        memberId = PublicPreferencesUtils.getString(context, Constant.NUTZER_ID);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_qianbaolist, null);
        ButterKnife.bind(this, view);
        initEvent();
        return view;
    }

    private void initEvent() {
        refreshLayout.setColorSchemeResources(R.color.bg_orange);
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                pageIndex = "1";
                if (type == 0) {
                    callback.getQianbaoList("1", type + "", memberId, context, false);
                } else {
                    callback.getQianbaoList("1", "2", memberId, context, false);
                }
            }
        });
        qianbaoListContain.setOnLoadDataListener(new MyLoadMoreRecyclerView.LoadData() {
            @Override
            public void onLoadMore() {
                isLoad = true;
                pageIndex = StringUtil.addString(pageIndex, "1");
                if (type == 0) {
                    callback.getQianbaoList(pageIndex, type + "", memberId, context, true);
                } else {
                    callback.getQianbaoList(pageIndex, "2", memberId, context, true);
                }
            }
        });
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        qianbaoListContain.setLayoutManager(manager);
    }

    private void initView() {
        qianBaoListAdapter = new QianBaoListAdapter(type, list, context);
        qianbaoListContain.setAdapter(qianBaoListAdapter);
        refreshLayout.setRefreshing(false);
    }

    @Override
    protected void initData() {
        super.initData();
        callback = new MainCallback(this, context);
        if (type == 0) {
            callback.getQianbaoList("1", type + "", memberId, context, true);
        } else {
            callback.getQianbaoList("1", "2", memberId, context, true);
        }
    }

    @Override
    public void viewMode(Response res, String tag) {
        if (tag.equals(HttpConstant.getQianbaoList)) {
            QianbaoListEntity entity = (QianbaoListEntity) res.body();
            List<QianbaoListEntity.DataBean> data = entity.getData();
            if (isLoad){
                if (list.size()==Integer.parseInt(entity.getCount())){
                    CustomToast.createToast().showFaild(context,"暂无更多加载");
                    StringUtil.musString(pageIndex,"1");
                    return;
                }
                list.addAll(data);
                qianBaoListAdapter.onLoad(list);
            }else {
                list = data;
                initView();
            }
        }
    }

    @Override
    public void getFalse(boolean tag, String message) {
        CustomToast.createToast().showFaild(context,"网络连接异常，请重新查看网络连接");
        refreshLayout.setRefreshing(false);
    }

    @Override
    public void showCode(int code, String string) {

    }
}
