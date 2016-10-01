package com.msport.clientmaster.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.msport.clientmaster.R;
import com.msport.clientmaster.base.BaseActivity;
import com.msport.clientmaster.bean.HotBean;
import com.msport.clientmaster.constants.Constant;
import com.msport.clientmaster.entity.HotEntity;
import com.msport.clientmaster.fragment.HomeFragment;
import com.msport.clientmaster.fragment.MyFragment;
import com.msport.clientmaster.intef.MyViewCallback;
import com.msport.clientmaster.util.PublicPreferencesUtils;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Response;

/**
 * 测试主页面
 */
public class MainActivity extends BaseActivity implements MyViewCallback {


    @BindView(R.id.activity_main)
    LinearLayout activityMain;


    /**
     * 进入首页fragment
     */
    @BindView(R.id.home_button)
    ViewGroup home_button;

    @BindView(R.id.home_button_tv)
    TextView home_button_tv;

    @BindView(R.id.home_button_iv)
    ImageView home_button_iv;

    /**
     * 弹出窗口【待定】
     */
    @BindView(R.id.pop_button)
    ViewGroup pop_button;

    /**
     * 我的fragment
     */
    @BindView(R.id.my_button)
    ViewGroup my_button;

    @BindView(R.id.my_button_tv)
    TextView my_button_tv;

    @BindView(R.id.my_button_iv)
    ImageView my_button_iv;

    /**
     * 跳入主页
     */
    private final int HOME_PAGE = 0;
    /**
     * 跳入我的页面
     */
    private final int MY_PAGE = 1;

    private Map<Integer, Fragment> fragments = new HashMap<Integer, Fragment>();

    private FragmentTransaction transaction;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        createFragment();
        changeIndex(0);
        activityMain.setBackgroundColor(ContextCompat.getColor(this,R.color.white));
        PublicPreferencesUtils.putBoolean(this, Constant.IS_FIRST, true);
    }


    /**
     * 建造fragment
     */
    private void createFragment() {
        transaction = getSupportFragmentManager().beginTransaction();
        fragments.put(HOME_PAGE, new HomeFragment(this));
        fragments.put(MY_PAGE, new MyFragment(this));
        for (int i = 0; i < fragments.size(); i++) {
            transaction.add(R.id.main_view, fragments.get(i));
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
        if (index == HOME_PAGE) {
            changeColor(home_button_tv, home_button_iv);
        } else if (index == MY_PAGE) {
            changeColor(my_button_tv, my_button_iv);
        }
        for (int i = 0; i < fragments.size(); i++) {
            transaction.hide(fragments.get(i));
        }
        transaction.show(fragment).commitAllowingStateLoss();
    }

    private void changeColor(TextView tv, ImageView iv) {
        home_button_tv.setTextColor(getResources().getColor(
                R.color.text_black_5c));
        my_button_tv.setTextColor(getResources().getColor(
                R.color.text_black_5c));
        home_button_iv.setImageResource(R.mipmap.home_none);
        my_button_iv.setImageResource(R.mipmap.my_none);
        tv.setTextColor(ContextCompat.getColor(this, R.color.text_orange));
        int id = iv.getId();
        if (id == R.id.home_button_iv) {
            iv.setImageResource(R.mipmap.home_select);
        } else if (id == R.id.my_button_iv) {
            iv.setImageResource(R.mipmap.my_select);
        }
    }

    @OnClick({R.id.home_button, R.id.my_button, R.id.pop_button})
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.home_button:
                changeIndex(HOME_PAGE);
                break;
            case R.id.my_button:
                changeIndex(MY_PAGE);
                break;
            case R.id.pop_button:
                intent.setClass(this, ButtomPopActivity.class);
//                intent.setClass(this,TestActvity.class);
//                intent.setClass(this,MenPiaoActivity.class);
                startActivity(intent);
                break;
        }
    }

    public static long firstTime = 0;

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.KEYCODE_BACK) {
            if (event.getAction() == KeyEvent.ACTION_DOWN) {
                long secondTime = System.currentTimeMillis();
                if (secondTime - firstTime > 800) {// 如果两次按键时间间隔大于800毫秒，则不退出
                    Toast.makeText(MainActivity.this, "再按一次  退出程序",
                            Toast.LENGTH_SHORT).show();
                    firstTime = secondTime;// 更新firstTime
                    return true;
                } else {
                    Intent intent = new Intent(Intent.ACTION_MAIN);
                    intent.addCategory(Intent.CATEGORY_HOME);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                    finish();
                }
            }
        }
        return super.dispatchKeyEvent(event);
    }


    @Override
    public void viewMode(Response res, String tag) {
        HotEntity entity = (HotEntity) res.body();
        HotBean hotBean = entity.getData().get(0);
        //mainTv.setText(hotBean.getName());
    }

    @Override
    public void getFalse(boolean tag, String message) {
        if (tag) {
            // mainTv.setText("网络异常");
        }
    }

    @Override
    public void showCode(int code, String string) {
        //mainTv.setText(code+"");
    }
}
