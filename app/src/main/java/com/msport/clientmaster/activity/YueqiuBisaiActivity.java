package com.msport.clientmaster.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.msport.clientmaster.R;
import com.msport.clientmaster.base.BaseActivity;
import com.msport.clientmaster.constants.Constant;
import com.msport.clientmaster.fragment.BisaiFragment;
import com.msport.clientmaster.fragment.YueQiuFragment;
import com.msport.clientmaster.intef.MyViewCallback;
import com.msport.clientmaster.util.CustomToast;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Response;

/**
 * 显示课程或者私教的页面
 * Created by like on 2016/7/12.
 */

public class YueqiuBisaiActivity extends BaseActivity implements MyViewCallback {
    @BindView(R.id.choice_course)
    TextView choice_course;

    @BindView(R.id.choice_coach)
    TextView choice_coach;

    @BindView(R.id.show_container)
    FrameLayout show_container;

    @BindView(R.id.left_done)
    ImageView left_done;
    /**
     * 右边抬头
     */
    @BindView(R.id.right_tv)
    TextView right_tv;

    /**
     * 进入课程页面
     */
    private final int YUEQIU_PAGE = 0;
    /**
     * 进入私教页面
     */
    private final int BISAI_PAGE = 1;
    @BindView(R.id.main_contain)
    LinearLayout mainContain;
    private FragmentTransaction transaction;

    private Map<Integer, Fragment> fragments = new HashMap<Integer, Fragment>();
    private String courseType;
    private int type;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_coach);
        ButterKnife.bind(this);
        courseType = getIntent().getStringExtra(Constant.COURSE_CHOOSE_TYPE);
        createFragment();
        changeIndex(YUEQIU_PAGE);
        initView();

    }

    private void initView() {
        choice_coach.setText("比赛");
        choice_course.setText("约球");
        right_tv.setText("创建");
        right_tv.setVisibility(View.VISIBLE);
        mainContain.setBackgroundColor(ContextCompat.getColor(this,R.color.white));

    }

    @OnClick({R.id.choice_coach, R.id.choice_course, R.id.left_done, R.id.right_tv})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.choice_coach:
                changeIndex(BISAI_PAGE);
                type = BISAI_PAGE;
                break;
            case R.id.choice_course:
                changeIndex(YUEQIU_PAGE);
                type = YUEQIU_PAGE;
                break;
            case R.id.left_done:
                finish();
                break;
            case R.id.right_tv:
                checkMember(this);
                break;
        }
    }

    @Override
    protected void Do() {
        Intent intent = new Intent(this, AddYueQiuActivity.class);
        intent.putExtra(Constant.COURSE_CHOOSE_TYPE, courseType);
        intent.putExtra(Constant.YUEQIU_BISAI, type);
        startActivity(intent);
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
        fragments.put(YUEQIU_PAGE, new YueQiuFragment());
        fragments.put(BISAI_PAGE, new BisaiFragment(this));
        for (int i = 0; i < fragments.size(); i++) {
            transaction.add(R.id.show_container, fragments.get(i)).hide(
                    fragments.get(i));
        }
        transaction.commit();
    }

    /**
     * 点击改变页面
     *
     * @param index
     */
    private void changeIndex(int index) {
        Fragment fragment = fragments.get(index);
        transaction = getSupportFragmentManager().beginTransaction();
        if (index == YUEQIU_PAGE) {
            changeChoice(choice_course);
        } else if (index == BISAI_PAGE) {
            changeChoice(choice_coach);
        }
        for (int i = 0; i < fragments.size(); i++) {
            transaction.hide(fragments.get(i));
        }
        transaction.show(fragment).commitAllowingStateLoss();
    }

    @Override
    public void viewMode(Response res, String tag) {

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
