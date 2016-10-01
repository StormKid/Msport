package com.msport.clientmaster.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.msport.clientmaster.R;
import com.msport.clientmaster.adapter.CoachListAdapter;
import com.msport.clientmaster.callback.MainCallback;
import com.msport.clientmaster.constants.Constant;
import com.msport.clientmaster.constants.HttpConstant;
import com.msport.clientmaster.entity.CoachListEntity;
import com.msport.clientmaster.entity.CourseTypeEntity;
import com.msport.clientmaster.intef.MyViewCallback;
import com.msport.clientmaster.intef.ScrollListener;
import com.msport.clientmaster.requestbean.CoachRequestBean;
import com.msport.clientmaster.util.AnimationUtil;
import com.msport.clientmaster.util.CustomToast;
import com.msport.clientmaster.util.ImageUtil;
import com.msport.clientmaster.util.StringUtil;
import com.msport.clientmaster.util.Tools;
import com.msport.clientmaster.view.ObservableScrollExpendableView;

import org.simple.eventbus.EventBus;
import org.simple.eventbus.Subscriber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Response;

/**
 * Created by like on 2016/7/13.
 */
@SuppressLint("ValidFragment")
public class CoachListFragment extends BaseListFragment implements ScrollListener, MyViewCallback {
    @BindView(R.id.coach_contain)
    ObservableScrollExpendableView coach_contain;
    /**
     * 项目
     */
    @BindView(R.id.xiangmu_choose)
    LinearLayout xiangmu_choose;

    /**
     * 地点
     */
    @BindView(R.id.didian_choose)
    LinearLayout didian_choose;
    /**
     * 筛选
     */
    @BindView(R.id.shaixuan_choose)
    LinearLayout shaixuan_choose;

    /**
     * 排序
     */
    @BindView(R.id.paixu_choose)
    LinearLayout paixu_choose;

    /**
     * 全部的view
     */
    @BindView(R.id.buttom_popcontain)
    LinearLayout buttom_popcontain;

    @BindView(R.id.hint_show)
    ViewGroup hint_show;


    private final String XIANGMU_POP = "XIANGMU_POP";
    private final String DIDIAN_POP = "DIDIAN_POP";
    private final String SHAIXUAN_POP = "SHAIXUAN_POP";
    private final String PAIXU_POP = "PAIXU_POP";
    @BindView(R.id.refresh_layout)
    SwipeRefreshLayout refreshLayout;
    private FragmentDialog dialog;
    private MainCallback callback;
    private CoachListAdapter adapter;
    private Context context;
    private String type;
    private CourseTypeEntity entity;
    private Map<CourseTypeEntity.DataBean, List<CourseTypeEntity.DataBean>> listTreeMap;
    private CoachRequestBean coachRequestBean;
    private List<String> shaixuans = new ArrayList<>();
    private String totalIndex = "1";
    private boolean isload;
    private List<CoachListEntity.DataBean> datas = new ArrayList<>();

    public CoachListFragment(String type, CourseTypeEntity entity, Map<CourseTypeEntity.DataBean, List<CourseTypeEntity.DataBean>> listTreeMap, Context context) {
        this.type = type;
        this.entity = entity;
        this.listTreeMap = listTreeMap;
        this.context = context;
        initDatas();
    }


    private void initDatas() {
        List<CourseTypeEntity.DataBean> data = entity.getData();
        for (CourseTypeEntity.DataBean value : data
                ) {
            String name = value.getName();
            shaixuans.add(name);
        }

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_coach_list, null);
        ButterKnife.bind(this, view);
        EventBus.getDefault().register(this);
        callback = new MainCallback(this, context);
        coachRequestBean = new CoachRequestBean();
        coachRequestBean.major = type;
        callback.getCoachList("1", coachRequestBean, true);
        initRefresh();
        return view;

    }

    private void initRefresh() {

        refreshLayout.setColorSchemeResources(R.color.bg_orange);
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                totalIndex = "1";
                callback.getCoachList("1", coachRequestBean, false);
                isload = false;
            }
        });
        coach_contain.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView absListView, int scrollState) {
                switch (scrollState) {
                    // 当不滚动时
                    case AbsListView.OnScrollListener.SCROLL_STATE_IDLE:
                        // 判断滚动到底部
                        if (coach_contain.getLastVisiblePosition() == (coach_contain.getCount() - 1)) {
                            totalIndex = StringUtil.addString(totalIndex, "1");
                            isload = true;
                            callback.getCoachList(totalIndex, coachRequestBean, true);
                        }

                        break;
                }

            }

            @Override
            public void onScroll(AbsListView absListView, int i, int i1, int i2) {

            }
        });

    }

    private void initView() {
        refreshLayout.setRefreshing(false);
        View viewImg = LayoutInflater.from(getActivity()).inflate(R.layout.head_img, null);
        ImageView imageView = (ImageView) viewImg.findViewById(R.id.headView);
        ImageUtil.getCacheImage(context,R.mipmap.coach_list,imageView);
        imageView.setClickable(false);
        if (coach_contain.getHeaderViewsCount() == 0) {
            coach_contain.addHeaderView(viewImg);
        }
        coach_contain.setGroupIndicator(null);
        coach_contain.setAdapter(adapter);
        adapter.setOnScrollListener(this);
//        coach_contain
//                .setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
//
//                    @Override
//                    public void onGroupExpand(int groupPosition) {
//                        for (int i = 0, count = coach_contain
//                                .getExpandableListAdapter().getGroupCount(); i < count; i++) {
//                            if (groupPosition != i) {// 关闭其他分组
//                                coach_contain.collapseGroup(i);
//                            }
//                        }
//                    }
//                });
        adapter.setOnShowChildListener(new CoachListAdapter.showChildListener() {
            @Override
            public void getPosition(int groupPosition, View view) {
                boolean groupExpanded = coach_contain.isGroupExpanded(groupPosition);
                if (groupExpanded) {
                    coach_contain.collapseGroup(groupPosition);
                    AnimationUtil.getInstance().rolate_90_redo(view);
                } else {
                    coach_contain.expandGroup(groupPosition, true);
                    AnimationUtil.getInstance().rolate_90_do(view);
                }
            }
        });

        coach_contain.setScrollListener(this);

    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void scrollOritention(int oritention) {
        if (Constant.SCROLL_DOWN == oritention) { //滑动时候隐藏Layout
            AnimationUtil.getInstance().hintView(buttom_popcontain);
        } else if (Constant.SCROLL_UP == oritention) {
            AnimationUtil.getInstance().showView(buttom_popcontain);
        }
    }


    private void changeBackGround(ViewGroup viewGroup) {
        xiangmu_choose.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.bg_black_E54));
        didian_choose.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.bg_black_E54));
        paixu_choose.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.bg_black_E54));
        shaixuan_choose.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.bg_black_E54));
        if (viewGroup != null) {
            viewGroup.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.bg_black_D42));
        }
    }

    @OnClick({R.id.paixu_choose, R.id.shaixuan_choose, R.id.didian_choose, R.id.xiangmu_choose})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.shaixuan_choose:
                createPopView(R.layout.dialog_shaixuan, shaixuan_choose, SHAIXUAN_POP);
                break;
            case R.id.didian_choose:
                createPopView(R.layout.dialog_didian, didian_choose, DIDIAN_POP);
                break;
            case R.id.xiangmu_choose:
                createPopView(R.layout.dialog_xiangmu, xiangmu_choose, XIANGMU_POP);
                break;
            case R.id.paixu_choose:
                createPopView(R.layout.dialog_paixu, paixu_choose, PAIXU_POP);
                break;
        }
    }


    @Override
    public void onResume() {
        super.onResume();
        if (dialog != null) {
            if (dialog.isHidden()) {
                hint_show.setVisibility(View.GONE);
            }
        }

    }

    private void createPopView(int layout, final ViewGroup viewGroup, String TAG) {
        dialog = new FragmentDialog(buttom_popcontain.getHeight(), layout, Constant.COACH_LIST, coachRequestBean, listTreeMap,context);
        dialog.show(getActivity().getSupportFragmentManager(), TAG);
        dialog.setOnDialogStateListener(new FragmentDialog.onDialogStateListener() {
            @Override
            public void getDialogState(boolean tag) {
                if (tag) {
                    hint_show.setVisibility(View.VISIBLE);
                    changeBackGround(viewGroup);
                } else {
                    hint_show.setVisibility(View.GONE);
                    changeBackGround(null);
                }
            }
        });
    }


    @Override
    public void viewMode(Response res, String tag) {
        if (HttpConstant.categroyCoachList.equals(tag)) {
            CoachListEntity entity = (CoachListEntity) res.body();
            List<CoachListEntity.DataBean> data = entity.getData();
            if (datas.size()==Integer.parseInt(entity.getCount())){
                CustomToast.createToast().showFaild(context,"已经加载到最后");
                totalIndex = StringUtil.musString(totalIndex,"1");
                isload = false;
                return;
            }
            if (isload) {
                datas.addAll(data);
            } else {
                datas.clear();
                datas = data;
            }
            List<String> list = new ArrayList<>();
            Map<String, List<String>> params = new HashMap<>();
            for (CoachListEntity.DataBean bean :
                    datas) {
                String id = bean.getId();
                String venueNames = bean.getVenueNames();
                String venueAddress = bean.getVenueAddress();
                List<String> locations = new ArrayList<>();
                if (!TextUtils.isEmpty(venueAddress)) {
                    String[] split = venueAddress.split(",");
                    locations = Tools.getList(split);
                }
                params.put(id, locations);
            }
            if (isload) {
                adapter.onLoad(datas,params);
                return;
            } else {
                adapter = new CoachListAdapter(getActivity(), datas, params);
            }
            initView();
        }


    }

    @Override
    public void getFalse(boolean tag, String message) {

        if (tag) {
            CustomToast.createToast().showFaild(context, "获取私教列表失败，请重新请求");
            refreshLayout.setRefreshing(false);
        }

    }

    @Override
    public void showCode(int code, String string) {

    }


    @Subscriber(tag = Constant.COACH_LIST)
    public void getCoachRealList(CoachRequestBean bean) {
        totalIndex = "1";
        isload = false;
        callback.getCoachList("1", bean, true);
    }




}
