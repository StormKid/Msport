package com.msport.clientmaster.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.msport.clientmaster.R;
import com.msport.clientmaster.adapter.CourseListShowAdapter;
import com.msport.clientmaster.callback.MainCallback;
import com.msport.clientmaster.constants.Constant;
import com.msport.clientmaster.constants.HttpConstant;
import com.msport.clientmaster.entity.CourseListEntity;
import com.msport.clientmaster.entity.CourseTypeEntity;
import com.msport.clientmaster.intef.MyViewCallback;
import com.msport.clientmaster.intef.ScrollListener;
import com.msport.clientmaster.requestbean.CourseRequestBean;
import com.msport.clientmaster.util.AnimationUtil;
import com.msport.clientmaster.util.CustomToast;
import com.msport.clientmaster.util.ImageUtil;
import com.msport.clientmaster.util.StringUtil;
import com.msport.clientmaster.view.ObservableScrollView;

import org.simple.eventbus.Subscriber;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Response;

/**
 * Created by like on 2016/7/13.
 * 显示课程列表
 */
@SuppressLint("ValidFragment")
public class CourseListShowFragment extends BaseListFragment implements ScrollListener, MyViewCallback {

    @BindView(R.id.refresh_layout)
    SwipeRefreshLayout refreshLayout;
    private int type;
    private Context context;
    private String courseType;
    private String subCourseType;
    private CourseTypeEntity entity;
    private Map<CourseTypeEntity.DataBean, List<CourseTypeEntity.DataBean>> listTreeMap;
    @BindView(R.id.show_list)
    ObservableScrollView show_list;

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
    private FragmentDialog dialog;
    private MainCallback callback;
    private CourseListShowAdapter adapter;
    private CourseRequestBean courseRequestBean;
    private String totalIndex = "1";
    private boolean isload;
    private  List<CourseListEntity.DataBean> datas = new ArrayList<>();


    public CourseListShowFragment(Context activity, int i, String courseType, String subCourseType, CourseTypeEntity entity, Map<CourseTypeEntity.DataBean, List<CourseTypeEntity.DataBean>> listTreeMap) {
        this.type = i;
        this.context = activity;
        this.courseType = courseType;
        this.subCourseType = subCourseType;
        this.entity = entity;
        this.listTreeMap = listTreeMap;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View inflate = inflater.inflate(R.layout.fragment_courselistshow, null);
        ButterKnife.bind(this, inflate);
        return inflate;
    }

    private void initView() {
        refreshLayout.setRefreshing(false);
        View view = LayoutInflater.from(context).inflate(R.layout.head_img, null);
        ImageView imageView = (ImageView) view.findViewById(R.id.headView);
        ImageUtil.getCacheImage(context,R.mipmap.course_list,imageView);
        imageView.setClickable(false);
        int headerViewsCount = show_list.getHeaderViewsCount();
        if (headerViewsCount == 0) {
            show_list.addHeaderView(view);
        }
        view.setClickable(false);
        adapter.setOnScrollListenr(this);
        show_list.setAdapter(adapter);
        show_list.setScrollListener(this);
        refreshLayout.setColorSchemeResources(R.color.bg_orange);
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                isload = false;
                totalIndex = "1";
                callback.getCourseList(courseRequestBean, "1",false);
            }
        });
        show_list.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView absListView, int i) {
                // 当不滚动时
                if (i==AbsListView.OnScrollListener.SCROLL_STATE_IDLE) {
                    // 判断滚动到底部
                    if (show_list.getLastVisiblePosition() == (show_list.getCount() - 1)) {
                        totalIndex = StringUtil.addString(totalIndex, "1");
                        isload = true;
                        callback.getCourseList(courseRequestBean, totalIndex,true);
                    }
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
        callback = new MainCallback(this, context);
        courseRequestBean = new CourseRequestBean();
        courseRequestBean.courseType = courseType;
        courseRequestBean.subCourseType = subCourseType;
        callback.getCourseList(courseRequestBean, "1", true);


    }


    @OnClick({R.id.paixu_choose, R.id.shaixuan_choose, R.id.didian_choose, R.id.xiangmu_choose})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.shaixuan_choose:
                createPopView(R.layout.dialog_shaixuan, shaixuan_choose, SHAIXUAN_POP, null);
                break;
            case R.id.didian_choose:
                createPopView(R.layout.dialog_didian, didian_choose, DIDIAN_POP, null);
                break;
            case R.id.xiangmu_choose:
                createPopView(R.layout.dialog_xiangmu, xiangmu_choose, XIANGMU_POP, listTreeMap);
                break;
            case R.id.paixu_choose:
                createPopView(R.layout.dialog_paixu, paixu_choose, PAIXU_POP, null);
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


    private void createPopView(int layout, final ViewGroup viewGroup, String TAG, Map<CourseTypeEntity.DataBean, List<CourseTypeEntity.DataBean>> listTreeMap) {
        dialog = new FragmentDialog(buttom_popcontain.getHeight(), layout, Constant.COURSE_LIST, courseRequestBean, listTreeMap,context);
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


    @Override
    public void setMenuVisibility(boolean menuVisible) {
        super.setMenuVisibility(menuVisible);
        if (buttom_popcontain != null) {
            AnimationUtil.getInstance().showView(buttom_popcontain);
        }
    }

    @Override
    public void viewMode(Response res, String tag) {
        if (HttpConstant.getCourseLiset.equals(tag)) {
            CourseListEntity entity = (CourseListEntity) res.body();
            List<CourseListEntity.DataBean> data = entity.getData();
            if (datas.size()==Integer.parseInt(entity.getCount())){
                CustomToast.createToast().showFaild(context,"已加载到最后");
                totalIndex = StringUtil.musString(totalIndex,"1");
                isload = false;
                return;
            }
            if (isload){
                datas.addAll(data);
                adapter.updateView(datas);
                return;
            }else {
                datas = data;
                adapter = new CourseListShowAdapter(context, datas);
            }
            refreshLayout.setRefreshing(false);
            initView();
        }
    }

    @Override
    public void getFalse(boolean tag, String message) {
        if (tag) {
            CustomToast.createToast().showFaild(getActivity(), "获取课程列表失败，请重新获取请求");
            refreshLayout.setRefreshing(false);
        }
    }

    @Override
    public void showCode(int code, String string) {

    }


    @Subscriber(tag = Constant.COURSE_LIST)
    public void onRerve(CourseRequestBean bean) {
        isload = false;
        totalIndex = "1";
        callback.getCourseList(bean, "1", true);
    }


}
