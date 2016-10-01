package com.msport.clientmaster.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.msport.clientmaster.R;
import com.msport.clientmaster.adapter.ChangePagerAdapter;
import com.msport.clientmaster.adapter.CourseCategroyAdapter;
import com.msport.clientmaster.callback.MainCallback;
import com.msport.clientmaster.constants.Constant;
import com.msport.clientmaster.constants.HttpConstant;
import com.msport.clientmaster.entity.CourseTypeEntity;
import com.msport.clientmaster.intef.MyViewCallback;
import com.msport.clientmaster.requestbean.CourseRequestBean;

import org.simple.eventbus.EventBus;
import org.simple.eventbus.Subscriber;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Response;

/**
 * Created by like on 2016/7/13.
 */
@SuppressLint("ValidFragment")
public class CourseListFragment extends Fragment implements MyViewCallback {
    @BindView(R.id.course_category_contain)
    ViewPager course_category_contain;

    @BindView(R.id.course_category_contain_text)
    RecyclerView course_category_contain_text;
    private CourseCategroyAdapter adapter;
    private MainCallback callback;
    private String courseType;
    private CourseTypeEntity entity;
    private Map<CourseTypeEntity.DataBean, List<CourseTypeEntity.DataBean>> listTreeMap;
    private List<String> listD;
    private List<String> listT;
    private List<CourseTypeEntity.DataBean> entityData;
    private int postition;
    private boolean isRequest;

    public CourseListFragment(String courseType, CourseTypeEntity entity, Map<CourseTypeEntity.DataBean, List<CourseTypeEntity.DataBean>> listTreeMap) {
        this.courseType = courseType;
        this.entity = entity;
        this.listTreeMap = listTreeMap;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_courselist, null);
        EventBus.getDefault().register(this);
        ButterKnife.bind(this, view);
        callback = new MainCallback(this,getActivity());
        callback.getCourseType(courseType, false);
        return view;
    }


    private void initView() {

        adapter = new CourseCategroyAdapter(getActivity(), listD);
        List<Fragment> setFragments = setFragment(listD.size());
        final LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setSmoothScrollbarEnabled(true);
        layoutManager.setOrientation(LinearLayout.HORIZONTAL);
        course_category_contain_text.setLayoutManager(layoutManager);
        course_category_contain_text.setAdapter(adapter);
        course_category_contain.setAdapter(new ChangePagerAdapter(
                getActivity().getSupportFragmentManager(), setFragments));
        course_category_contain.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int arg0) {
                adapter.setSeclection(arg0);
                layoutManager.setSmoothScrollbarEnabled(true);
                layoutManager.scrollToPosition(arg0);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int arg0) {

            }
        });

        adapter.setOnGetPositionListener(new CourseCategroyAdapter.OnGetPositionListener() {

            @Override
            public void getPosition(View v, int position) {
                course_category_contain.setCurrentItem(position, true);
            }
        });

        course_category_contain.setOffscreenPageLimit(listD.size());
    }


    private List<Fragment> setFragment(int total) {
        List<Fragment> params = new ArrayList<>();
        for (int i = 0; i < total; i++) {
            Fragment fragment = new CourseListShowFragment(getActivity(), i, courseType, listT.get(i), entity, listTreeMap);
            params.add(fragment);
        }
        return params;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }


    @Override
    public void viewMode(Response res, String tag) {
        if (HttpConstant.getCourseType.equals(tag)) {
            CourseTypeEntity entity = (CourseTypeEntity) res.body();
            entityData = entity.getData();
            listD = new ArrayList<>();
            listT = new ArrayList<>();
            for (CourseTypeEntity.DataBean bean : entityData
                    ) {
                String name = bean.getName();
                String subCourseType = bean.getId();
                listT.add(subCourseType);
                listD.add(name);
            }
            initView();
            if (isRequest) {
                course_category_contain.setCurrentItem(postition, true);
                adapter.setSeclection(postition);
                adapter.notifyDataSetChanged();
            }
        }


    }

    @Override
    public void getFalse(boolean tag, String message) {

    }

    @Override
    public void showCode(int code, String string) {

    }


    @Subscriber(tag = Constant.COURSE_LIST)
    private void getData(CourseRequestBean bean) {
        postition = bean.position;
        courseType = bean.courseType;
        isRequest = true;
        callback.getCourseType(courseType, false);
    }
}
