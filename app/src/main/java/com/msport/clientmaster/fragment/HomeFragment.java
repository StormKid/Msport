package com.msport.clientmaster.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.msport.clientmaster.R;
import com.msport.clientmaster.activity.CourseCoachActivity;
import com.msport.clientmaster.activity.MenPiaoActivity;
import com.msport.clientmaster.activity.YouHuiQuanActivity;
import com.msport.clientmaster.adapter.HomeHotListAdapter;
import com.msport.clientmaster.bean.HomeJsonBean;
import com.msport.clientmaster.callback.MainCallback;
import com.msport.clientmaster.constants.Constant;
import com.msport.clientmaster.constants.HttpConstant;
import com.msport.clientmaster.entity.CourseTypeEntity;
import com.msport.clientmaster.entity.MainEntity;
import com.msport.clientmaster.intef.MyViewCallback;
import com.msport.clientmaster.util.CustomToast;
import com.msport.clientmaster.util.Tools;
import com.msport.clientmaster.util.ViewUtil;
import com.msport.clientmaster.view.HomeScrollView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Response;

/**
 * 首页布局
 * Created by like on 2016/7/19.
 */
@SuppressLint("ValidFragment")
public class HomeFragment extends Fragment implements MyViewCallback {

    /**
     * 滑动的view
     */
    @BindView(R.id.home_contain)
    HomeScrollView home_contain;

    /**
     * 未滚动的时候显示的布局
     */
    @BindView(R.id.no_scroll_search)
    ViewGroup no_scroll_search;

    /**
     * 滑动的时候显示的搜索框
     */
    @BindView(R.id.scrolled_show)
    ViewGroup scrolled_show;

    @BindView(R.id.title_tag_contain)
    ViewGroup title_tag_contain;

    @BindView(R.id.home_hot_list)
    ListView home_hot_list;


    /**
     * 点击进入羽毛球私教界面
     */
    @BindView(R.id.yumaoqiu_home)
    ViewGroup yumaoqiu_home;
    @BindView(R.id.pengrang_xingdong)
    TextView pengrangXingdong;
    @BindView(R.id.youyong_home)
    LinearLayout youyongHome;
    @BindView(R.id.wangqiu_home)
    LinearLayout wangqiuHome;
    @BindView(R.id.wudao_home)
    LinearLayout wudaoHome;
    @BindView(R.id.yujia_home)
    LinearLayout yujiaHome;
    @BindView(R.id.home_annoment)
    TextView homeAnnoment;
    @BindView(R.id.home_youhui_one_iv)
    ImageView homeYouhuiOneIv;
    @BindView(R.id.home_youhui_one)
    LinearLayout homeYouhuiOne;
    @BindView(R.id.home_youhui_two_iv)
    ImageView homeYouhuiTwoIv;
    @BindView(R.id.home_youhui_two)
    LinearLayout homeYouhuiTwo;
    @BindView(R.id.home_youhui_three_iv)
    ImageView homeYouhuiThreeIv;
    @BindView(R.id.home_youhui_three)
    LinearLayout homeYouhuiThree;
    @BindView(R.id.home_youhui)
    LinearLayout homeYouhui;
    @BindView(R.id.get_home_crips)
    ImageView getHomeCrips;
    @BindView(R.id.home_menpiao)
    LinearLayout homeMenpiao;
    @BindView(R.id.refresh_layout)
    SwipeRefreshLayout refreshLayout;


    private int tagY;
    private int changeY;
    private MainCallback callback;
    private List<CourseTypeEntity.DataBean> data;
    private CourseTypeEntity courseTypeEntity;
    private Context context;
    private Map<String, String> courseTypes;
    private boolean homerefresh = true;
    private List<String> activitys;
    private String priceOne;
    private String priceTwd;
    private String priceThree;

    public HomeFragment(Context context) {
        this.context = context;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, null);
        ButterKnife.bind(this, view);
        callback = new MainCallback(this, context);
        callback.getCourseType("0", false);
        initEvent();
        return view;
    }

    private void initEvent() {
        home_contain.setBackgroundColor(ContextCompat.getColor(context,R.color.white));
        tagY = no_scroll_search.getHeight();
        changeY = title_tag_contain.getHeight();
        scrolled_show.getBackground().setAlpha(0);
        ViewGroup vg = (ViewGroup) scrolled_show.getChildAt(0);
        vg.getBackground().setAlpha(0);
        scrolled_show.setAlpha(0);
        vg.setAlpha(0);
        home_contain.setOnScrollYListener(new MyOnScrollYListener(scrolled_show, vg));
        refreshLayout.setColorSchemeResources(R.color.bg_orange);
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                callback.getCourseType("0", false);
                homerefresh = false;
            }
        });
        home_hot_list.setFocusable(false);
        home_hot_list.setFocusableInTouchMode(false);
    }

    @Override
    public void viewMode(Response res, String tag) {

        if (HttpConstant.home.equals(tag)) {
            MainEntity entity = (MainEntity) res.body();
            MainEntity.DataBean data = entity.getData();
            List<MainEntity.DataBean.CoachBean> coach = data.getCoach() == null ? (coach = new ArrayList<>()) : (coach = data.getCoach());
            List<MainEntity.DataBean.CourseBean> course = data.getCourse() == null ? (course = new ArrayList<>()) : (course = data.getCourse());
            List<MainEntity.DataBean.InvitationActivityBean> invitationActivity = data.getInvitationActivity() == null ? (invitationActivity = new ArrayList<>()) : (invitationActivity = data.getInvitationActivity());
            MainEntity.DataBean.CourseTypeBean courseType = data.getCourseType();
            List<MainEntity.DataBean.AnnouncementBean> announcement = data.getAnnouncement();
            List<MainEntity.BeanActivity> activity = data.getActivity();
            if (null != activity&& activity.size()>0) {
                MainEntity.BeanActivity beanActivity = activity.get(0);
                String remark = beanActivity.getRemark();
                if (!TextUtils.isEmpty(remark)) {
                    String replace = remark.replace("&quot;", "\"");
                    String[] split = replace.split(",");
                    String s = split[0];
                    String sre = s.replace("[", "");
                    String a = split[1];
                    String b = split[2];
                    String bre = b.replace("]", "");
                    Gson gson = new Gson();
                    priceOne = getJsonString(sre, gson);
                    priceTwd = getJsonString(a, gson);
                    priceThree = getJsonString(bre, gson);
                }
            }
            if (announcement.size() > 0) {
                MainEntity.DataBean.AnnouncementBean announcementBean = announcement.get(0);
                homeAnnoment.setText(announcementBean.getContent());
            }
            HomeHotListAdapter homeHotListAdapter = new HomeHotListAdapter(getActivity(), course, coach, invitationActivity);
            home_hot_list.setAdapter(homeHotListAdapter);
            refreshLayout.setRefreshing(false);
        } else if (HttpConstant.getCourseType.equals(tag)) {
            courseTypeEntity = (CourseTypeEntity) res.body();
            data = courseTypeEntity.getData();
            courseTypes = new HashMap<>();
            for (CourseTypeEntity.DataBean bean : data
                    ) {
                String valueId = bean.getId();
                courseTypes.put(bean.getId(), bean.getName());
                switch (valueId) {
                    case "1":
                        youyongHome.setVisibility(View.VISIBLE);
                        break;
                    case "4":
                        yumaoqiu_home.setVisibility(View.VISIBLE);
                        break;
                    case "3":
                        yujiaHome.setVisibility(View.VISIBLE);
                        break;
                    case "5":
                        wangqiuHome.setVisibility(View.VISIBLE);
                        break;
                    case "6":
                        wudaoHome.setVisibility(View.VISIBLE);
                        break;
                }

            }
            callback.HomeGet(homerefresh);

        }
        home_contain.smoothScrollTo(0, 0);
    }

    @Override
    public void getFalse(boolean tag, String message) {
        if (tag) {
            CustomToast.createToast().showFaild(context, "网络不给力，请检查网络链接");
            refreshLayout.setRefreshing(false);
        }

    }

    @Override
    public void showCode(int code, String string) {

    }

    @OnClick({R.id.yumaoqiu_home, R.id.youyong_home, R.id.wangqiu_home, R.id.wudao_home, R.id.yujia_home, R.id.get_home_crips, R.id.home_menpiao, R.id.home_youhui_one_iv, R.id.home_youhui_two_iv, R.id.home_youhui_three_iv})
    public void onClick(View view) {
        Intent intent = new Intent();
        intent.setClass(getActivity(), CourseCoachActivity.class);
        switch (view.getId()) {
            case R.id.yumaoqiu_home:
                intent.putExtra(Constant.COUSE_TYPE, "4");
                intent.putExtra(Constant.COUSE_TYPE_NAME, courseTypeEntity);
                getActivity().startActivity(intent);
                break;
            case R.id.youyong_home:
                intent.putExtra(Constant.COUSE_TYPE, "1");
                intent.putExtra(Constant.COUSE_TYPE_NAME, courseTypeEntity);
                startActivity(intent);
                break;
            case R.id.wangqiu_home:
                intent.putExtra(Constant.COUSE_TYPE, "5");
                intent.putExtra(Constant.COUSE_TYPE_NAME, courseTypeEntity);
                startActivity(intent);
                break;
            case R.id.wudao_home:
                intent.putExtra(Constant.COUSE_TYPE, "6");
                intent.putExtra(Constant.COUSE_TYPE_NAME, courseTypeEntity);
                startActivity(intent);
                break;
            case R.id.yujia_home:
                intent.putExtra(Constant.COUSE_TYPE, "3");
                intent.putExtra(Constant.COUSE_TYPE_NAME, courseTypeEntity);
                startActivity(intent);
                break;
            case R.id.get_home_crips:
                Tools.checkMember(context, YouHuiQuanActivity.class);
                break;
            case R.id.home_menpiao:
                intent.setClass(context, MenPiaoActivity.class);
                startActivity(intent);
                break;
            case R.id.home_youhui_one_iv:
                intent.setClass(context, MenPiaoActivity.class);
                intent.putExtra(Constant.MAX_PRICE, "20");
                intent.putExtra(Constant.MIN_PRICE, "0");
                startActivity(intent);
                break;
            case R.id.home_youhui_two_iv:
                intent.setClass(context, MenPiaoActivity.class);
                intent.putExtra(Constant.MAX_PRICE, "30");
                intent.putExtra(Constant.MIN_PRICE, "20");
                startActivity(intent);
                break;
            case R.id.home_youhui_three_iv:
                intent.setClass(context, MenPiaoActivity.class);
                intent.putExtra(Constant.MAX_PRICE, "40");
                intent.putExtra(Constant.MIN_PRICE, "30");
                startActivity(intent);
                break;
        }
    }


    private class MyOnScrollYListener implements HomeScrollView.OnScrollGetYListener {
        ViewGroup parent;
        ViewGroup child;

        public MyOnScrollYListener(ViewGroup parent, ViewGroup child) {
            this.parent = parent;
            this.child = child;
        }

        @Override
        public void getScrollY(int y) {
            int dertaY = changeY - y;
            int tagHeight = getActivity().getWindowManager().getDefaultDisplay().getHeight() / 5;
            int scrolledHeight = getActivity().getWindowManager().getDefaultDisplay().getHeight() / 6;
            ViewUtil.tagShow(parent, dertaY, tagHeight, tagY);
            ViewUtil.tagShow(child, dertaY, tagHeight, tagY);
        }


    }


    private String getJsonString(String json, Gson gson) {
        HomeJsonBean homeJsonBean = gson.fromJson(json, HomeJsonBean.class);
        String price = homeJsonBean.getPrice();
        return price;
    }


}
