package com.msport.clientmaster.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.msport.clientmaster.R;
import com.msport.clientmaster.adapter.MyReviewAdapter;
import com.msport.clientmaster.callback.MainCallback;
import com.msport.clientmaster.constants.Constant;
import com.msport.clientmaster.constants.HttpConstant;
import com.msport.clientmaster.entity.ReViewListEntity;
import com.msport.clientmaster.intef.MyViewCallback;
import com.msport.clientmaster.util.CustomToast;
import com.msport.clientmaster.util.PublicPreferencesUtils;

import org.simple.eventbus.Subscriber;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Response;

/**
 * Created by like on 2016/8/17.
 */
@SuppressLint("ValidFragment")
public class ReviewListFragment extends BaseListFragment implements MyViewCallback {
    @BindView(R.id.qianbao_list_contain)
    RecyclerView qianbaoListContain;
    @BindView(R.id.refresh_layout)
    SwipeRefreshLayout refreshLayout;
    private int done_review;
    private Context context;
    private List<ReViewListEntity.DataBean> list;
    private MainCallback callback;
    private String memberId;

    public ReviewListFragment(int done_review, Context context) {
        this.done_review = done_review;
        this.context = context;
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
                if (done_review == 0)
                    callback.getReviewList(memberId, 1 + "",false);
                else callback.getReviewList(memberId, 0 + "", false);
            }
        });

    }

    private void initView() {
        refreshLayout.setRefreshing(false);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        qianbaoListContain.setLayoutManager(manager);
        qianbaoListContain.setAdapter(new MyReviewAdapter(done_review, list, context));
    }

    @Override
    protected void initData() {
        super.initData();
        callback = new MainCallback(this, context);
        memberId = PublicPreferencesUtils.getString(context, Constant.NUTZER_ID);
        if (done_review == 0)
            callback.getReviewList(memberId, 1 + "", true);
        else callback.getReviewList(memberId, 0 + "", true);
    }

    @Override
    public void viewMode(Response res, String tag) {

        if (tag.equals(HttpConstant.reviewList)) {
            ReViewListEntity entity = (ReViewListEntity) res.body();
            list = entity.getData();
            initView();

        }

    }

    @Override
    public void getFalse(boolean tag, String message) {
        refreshLayout.setRefreshing(false);
        CustomToast.createToast().showFaild(context,"网络不给力，请检查网络连接");
    }

    @Override
    public void showCode(int code, String string) {

    }


    @Subscriber(tag = Constant.REVIEW_REFRESH)
    public void refresh(String tag){
        initData();
    }


}
