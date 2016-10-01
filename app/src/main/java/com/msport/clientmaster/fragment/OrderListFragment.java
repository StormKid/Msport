package com.msport.clientmaster.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.msport.clientmaster.R;
import com.msport.clientmaster.adapter.OrderListAdapter;
import com.msport.clientmaster.callback.MainCallback;
import com.msport.clientmaster.constants.Constant;
import com.msport.clientmaster.constants.HttpConstant;
import com.msport.clientmaster.entity.OrderListEntity;
import com.msport.clientmaster.intef.MyViewCallback;
import com.msport.clientmaster.util.CustomToast;
import com.msport.clientmaster.util.PublicPreferencesUtils;
import com.msport.clientmaster.util.StringUtil;
import com.msport.clientmaster.view.MyLoadMoreRecyclerView;

import org.simple.eventbus.Subscriber;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Response;


/**
 * Created by like on 2016/8/18.
 */
@SuppressLint("ValidFragment")
public class OrderListFragment extends BaseListFragment implements MyViewCallback {
    @BindView(R.id.qianbao_list_contain)
    MyLoadMoreRecyclerView qianbaoListContain;
    @BindView(R.id.refresh_layout)
    SwipeRefreshLayout refreshLayout;
    private int type;
    private Context context;
    private String ORDER_TYPE;
    private List<OrderListEntity.DataBean> list = new ArrayList<>();
    private MainCallback callback;
    private String memberId;
    private String totalIndex = "1";
    private boolean isload;
    private OrderListEntity entity;
    private OrderListAdapter orderListAdapter;
    private List<OrderListEntity.DataBean> listdata = new ArrayList<>();


    public OrderListFragment(int type, Context context, String ORDER_TYPE) {
        this.type = type;
        this.context = context;
        this.ORDER_TYPE = ORDER_TYPE;
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
        qianbaoListContain.setBackgroundColor(ContextCompat.getColor(context, R.color.white));
        refreshLayout.setColorSchemeResources(R.color.bg_orange);
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                totalIndex = "1";
                isload = false;
                callback.getAllListOrder(memberId, ORDER_TYPE, type + "", "1", context, false);
            }
        });
        qianbaoListContain.setOnLoadDataListener(new MyLoadMoreRecyclerView.LoadData() {
            @Override
            public void onLoadMore() {
                totalIndex = StringUtil.addString(totalIndex, "1");
                isload = true;
                callback.getAllListOrder(memberId, ORDER_TYPE, type + "", totalIndex, context, true);
            }
        });
    }

    private void initView(List<OrderListEntity.DataBean> listdata) {
        LinearLayoutManager manager = new LinearLayoutManager(context);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        qianbaoListContain.setLayoutManager(manager);
    }


    @Override
    protected void initData() {
        super.initData();
        callback = new MainCallback(this, context);
        memberId = PublicPreferencesUtils.getString(context, Constant.NUTZER_ID);
        callback.getAllListOrder(memberId, ORDER_TYPE, type + "", "1", context, true);
    }

    @Subscriber(tag = Constant.ORDER_TYPE)
    public void getOrderType(String orderType) {
        ORDER_TYPE = orderType;
        callback = new MainCallback(this, context);
        callback.getAllListOrder(memberId, ORDER_TYPE, type + "", "1", context, true);
    }


    @Override
    public void viewMode(Response res, String tag) {
        if (tag.equals(HttpConstant.orderList)) {
            entity = (OrderListEntity) res.body();
            List<OrderListEntity.DataBean> list = entity.getData();
            list = removed(list);
            if (isload) {
                if (listdata.size() == Integer.parseInt(entity.getCount())) {
                    CustomToast.createToast().showFaild(context, "已经加载全部啦");
                    totalIndex = StringUtil.musString(totalIndex, "1");
                    isload = false;
                    return;
                }
                listdata.addAll(list);
                orderListAdapter.loadMore(listdata);
                return;
            } else {
                listdata = list;
                int orderType = 0;
                switch (ORDER_TYPE) {
                    case "0":
                        orderType = 0;
                        break;
                    case "2":
                        orderType = 1;
                        break;
                    case "4":
                        orderType = 2;
                        break;
                    case "7":
                        orderType = 3;
                        break;
                }
                orderListAdapter = new OrderListAdapter(orderType, context, this.listdata);
                initView(list);
                qianbaoListContain.setAdapter(orderListAdapter);
                totalIndex = "1";
            }
            refreshLayout.setRefreshing(false);
        }


    }

    @Override
    public void getFalse(boolean tag, String message) {
        refreshLayout.setRefreshing(false);
        if (tag)
            CustomToast.createToast().showFaild(context, "网络连接异常，请重新请求");
    }

    @Override
    public void showCode(int code, String string) {

    }


    private List<OrderListEntity.DataBean> removed(List<OrderListEntity.DataBean> zero) {
        List<OrderListEntity.DataBean> list = new ArrayList<>();
        for (OrderListEntity.DataBean bean :
                zero) {
            if (!bean.getStatus().equals("8")){
                list.add(bean);
            }
        }
        return list;

    }


}
