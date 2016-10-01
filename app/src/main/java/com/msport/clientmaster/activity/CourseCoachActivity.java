package com.msport.clientmaster.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.msport.clientmaster.R;
import com.msport.clientmaster.base.BaseActivity;
import com.msport.clientmaster.callback.MainCallback;
import com.msport.clientmaster.constants.Constant;
import com.msport.clientmaster.constants.HttpConstant;
import com.msport.clientmaster.entity.CourseTypeEntity;
import com.msport.clientmaster.fragment.CoachListFragment;
import com.msport.clientmaster.fragment.CourseListFragment;
import com.msport.clientmaster.intef.MyViewCallback;
import com.msport.clientmaster.util.CustomToast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Response;

/**
 * 显示课程或者私教的页面
 * Created by like on 2016/7/12.
 */

public class CourseCoachActivity extends BaseActivity implements MyViewCallback {
    @BindView(R.id.choice_course)
    TextView choice_course;

    @BindView(R.id.choice_coach)
    TextView choice_coach;

    @BindView(R.id.show_container)
    FrameLayout show_container;

    @BindView(R.id.left_done)
    ImageView left_done;


    /**
     * 进入课程页面
     */
    private final int COURSE_PAGE = 0;
    /**
     * 进入私教页面
     */
    private final int COACH_PAGE = 1;
    @BindView(R.id.main_contain)
    LinearLayout mainContain;
    private FragmentTransaction transaction;

    private Map<Integer, Fragment> fragments = new HashMap<Integer, Fragment>();


    /**
     * 显示
     */
    private PopupWindow m_popWindow;

    private FragmentTransaction fragmentTransaction;
    private String type;
    private CourseTypeEntity centity;
    private Map<CourseTypeEntity.DataBean, List<CourseTypeEntity.DataBean>> listTreeMap;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_coach);
        ButterKnife.bind(this);
        mainContain.setBackgroundColor(ContextCompat.getColor(this,R.color.white));
        MainCallback callback = new MainCallback(this, this);
        callback.getCourseType("-1", false);
    }

    @OnClick({R.id.choice_coach, R.id.choice_course, R.id.left_done})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.choice_coach:
                changeIndex(COACH_PAGE);
                break;
            case R.id.choice_course:
                changeIndex(COURSE_PAGE);
                break;
            case R.id.left_done:
                finish();
                break;
        }
    }


    private void changeChoice(TextView textView) {
        choice_coach.setTextColor(ContextCompat.getColor(this, R.color.text_orange));
        choice_course.setTextColor(ContextCompat.getColor(this, R.color.text_orange));
        textView.setTextColor(ContextCompat.getColor(this, R.color.text_white));
        choice_coach.setBackgroundResource(R.drawable.shape_choice_unselector_right);
        choice_course.setBackgroundResource(R.drawable.shape_choice_unselector_left);
        int id = textView.getId();
        if (R.id.choice_coach == id) {
            textView.setBackgroundResource(R.drawable.shape_choice_selector_right);
        } else {
            textView.setBackgroundResource(R.drawable.shape_choice_selector_left);
        }
    }


    /**
     * 建造fragment
     */
    private void createFragment() {
        transaction = getSupportFragmentManager().beginTransaction();
        fragments.put(COURSE_PAGE, new CourseListFragment(type, centity, listTreeMap));
        fragments.put(COACH_PAGE, new CoachListFragment(type, centity, listTreeMap, this));
        for (int i = 0; i < fragments.size(); i++) {
            transaction.add(R.id.show_container, fragments.get(i)).hide(
                    fragments.get(i));
        }
        transaction.commitAllowingStateLoss();
    }

    /**
     * 点击改变页面
     *
     * @param index
     */
    private void changeIndex(int index) {
        Fragment fragment = fragments.get(index);
        transaction = getSupportFragmentManager().beginTransaction();
        if (index == COURSE_PAGE) {
            changeChoice(choice_course);
        } else if (index == COACH_PAGE) {
            changeChoice(choice_coach);
        }
        for (int i = 0; i < fragments.size(); i++) {
            transaction.hide(fragments.get(i));
        }
        transaction.show(fragment).commitAllowingStateLoss();
    }

    @Override
    public void viewMode(Response res, String tag) {

        if (tag.equals(HttpConstant.getCourseType)) {
            CourseTypeEntity entity = (CourseTypeEntity) res.body();
            List<CourseTypeEntity.DataBean> data = entity.getData();
            listTreeMap = new HashMap<>();
            List<CourseTypeEntity.DataBean> parent = new ArrayList<>();
            List<CourseTypeEntity.DataBean> child = new ArrayList<>();
            for (CourseTypeEntity.DataBean bean : data
                    ) {
                if (bean.getParentId().equals("0")) {
                    parent.add(bean);
                } else {
                    child.add(bean);
                }

            }
            for (CourseTypeEntity.DataBean bean : parent) {
                List<CourseTypeEntity.DataBean> children = new ArrayList<>();
                for (CourseTypeEntity.DataBean value : child) {
                    if (bean.getId().equals(value.getParentId())) {
                        children.add(value);
                    }
                }
                listTreeMap.put(bean, children);

            }
            type = getIntent().getStringExtra(Constant.COUSE_TYPE);
            centity = (CourseTypeEntity) getIntent().getSerializableExtra(Constant.COUSE_TYPE_NAME);
            createFragment();
            changeIndex(COURSE_PAGE);
            choice_coach.setText("私教");
            choice_course.setText("课程");

        }
    }

    @Override
    public void getFalse(boolean tag, String message) {
        if (tag) {
            CustomToast.createToast().showFaild(this, "网络链接异常，请检查网络链接");
        }
    }

    @Override
    public void showCode(int code, String string) {

    }
}
