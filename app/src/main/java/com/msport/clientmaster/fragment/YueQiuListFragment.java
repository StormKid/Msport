package com.msport.clientmaster.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;

import com.msport.clientmaster.R;
import com.msport.clientmaster.adapter.YueQiuListShowAdapter;
import com.msport.clientmaster.bean.YueQiuBean;
import com.msport.clientmaster.callback.MainCallback;
import com.msport.clientmaster.constants.HttpConstant;
import com.msport.clientmaster.entity.YueQiuEntity;
import com.msport.clientmaster.intef.MyViewCallback;
import com.msport.clientmaster.requestbean.YueQiuRequestBean;
import com.msport.clientmaster.util.CustomToast;
import com.msport.clientmaster.util.ImageUtil;
import com.msport.clientmaster.util.LogUtils;
import com.msport.clientmaster.util.SignUtil;
import com.msport.clientmaster.util.StringUtil;
import com.msport.clientmaster.view.ObservableScrollView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.RequestBody;
import retrofit2.Response;

/**
 * Created by like on 2016/7/21.
 */
@SuppressLint("ValidFragment")
public class YueQiuListFragment extends BaseListFragment implements MyViewCallback {

    @BindView(R.id.refresh_layout)
    SwipeRefreshLayout refreshLayout;
    private FragmentActivity activity;
    private int ID;
    @BindView(R.id.show_list)
    ObservableScrollView show_list;
    @BindView(R.id.buttom_show)
    View buttom_show;
    private MainCallback callback;
    private long TimeTag;
    private RequestBody body;
    private Context context;
    private String totalIndex = "1";
    private boolean isload ;
    private List<YueQiuBean> datas  = new ArrayList<>();
    private YueQiuListShowAdapter adapter;

    public YueQiuListFragment(FragmentActivity activity, int i, long TimeTag) {
        this.activity = activity;
        this.ID = i;
        this.TimeTag = TimeTag;
        callback = new MainCallback(this, activity);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View inflate = inflater.inflate(R.layout.fragment_courselistshow, null);
        ButterKnife.bind(this, inflate);
        context = getActivity();
        initView();
        return inflate;
    }

    private void initView() {
        View view = LayoutInflater.from(activity).inflate(R.layout.head_img, null);
        ImageView imageView = (ImageView) view.findViewById(R.id.headView);
        ImageUtil.getCacheImage(context,R.mipmap.yueqiu_list,imageView);
        show_list.addHeaderView(view);
        buttom_show.setVisibility(View.GONE);
        refreshLayout.setColorSchemeResources(R.color.bg_orange);
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                totalIndex = "1";
                isload = false;
                callback.getYueQiuList("1", body,false);
            }
        });
        show_list.setBackgroundColor(ContextCompat.getColor(context,R.color.white));
        show_list.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView absListView, int i) {
                // 判断滚动到底部
                if (show_list.getLastVisiblePosition() == (show_list.getCount() - 1)) {
                    totalIndex = StringUtil.addString(totalIndex, "1");
                    isload = true;
                    callback.getYueQiuList(totalIndex, body,true);
                }
            }

            @Override
            public void onScroll(AbsListView absListView, int i, int i1, int i2) {

            }
        });
    }

    @Override
    protected void initData() {
        super.initData();
        YueQiuRequestBean bean =   new YueQiuRequestBean();
        bean.setSort("0");
        bean.setValue("0");
        bean.setTimeStart(TimeTag + "");
        body = SignUtil.Urljson(bean);
        callback.getYueQiuList("1", body, true);
    }

    @Override
    public void viewMode(Response res, String tag) {
        if (HttpConstant.getYueQiu.equals(tag)) {
            YueQiuEntity entity = (YueQiuEntity) res.body();
            List<YueQiuBean> data = entity.getData();
            if (datas.size()==Integer.parseInt(entity.getCount())){
                CustomToast.createToast().showFaild(context,"已加载到最后");
                totalIndex = StringUtil.musString(totalIndex,"1");
                isload = false;
                return;
            }
            if (isload){
                datas.addAll(data);
                adapter.loadMore(datas);
            }else {
                if (data.size()==0) {
                    CustomToast.createToast().showFaild(context,"此日期暂无约球，请重新选择其他日期的约球项目");
                }
                datas = data;
                adapter = new YueQiuListShowAdapter(activity, datas);

            }
            show_list.setAdapter(adapter);
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
        LogUtils.i("code", code);
    }
}
