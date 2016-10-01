package com.msport.clientmaster.calendar;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.msport.clientmaster.R;
import com.msport.clientmaster.adapter.ChangePagerAdapter;
import com.msport.clientmaster.base.BaseActivity;
import com.msport.clientmaster.callback.MainCallback;
import com.msport.clientmaster.constants.Constant;
import com.msport.clientmaster.constants.HttpConstant;
import com.msport.clientmaster.intef.MyViewCallback;
import com.msport.clientmaster.util.CustomToast;
import com.msport.clientmaster.util.TimeUtils;
import com.msport.clientmaster.util.ViewUtil;
import com.msport.clientmaster.view.TwoButtomDialog;

import org.simple.eventbus.EventBus;
import org.simple.eventbus.Subscriber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Response;


/**
 * 选择日期的页面
 *
 * @author like
 *         2016-5-17
 */
public class ChooseDateActivity extends BaseActivity implements MyViewCallback {
    /**
     * 显示日期
     */
    @BindView(R.id.flipper)
    MyCalendarView flipper;
    @BindView(R.id.back_black)
    ImageView backBlack;
    @BindView(R.id.main_title)
    TextView mainTitle;
    @BindView(R.id.share_black)
    ImageView shareBlack;
    @BindView(R.id.title_right_tv)
    TextView titleRightTv;

    private DateAdapter adapter;
    private TreeSet<DateBean> listDay = new TreeSet<DateBean>();
    /**
     * 显示底部栏目
     */
    @BindView(R.id.listen_list_contain)
    ViewPager listen_list_contain;

    private List<GetTimeBean> listData;


    private int size;
    /**
     * 用于收集选中的条目时间从而通过解析上传给服务器
     */
    private Map<Integer, List<GetTimeBean>> checked = new HashMap<Integer, List<GetTimeBean>>();
    /**
     * 用户选择的课程数量
     */
    @BindView(R.id.choosed_jie)
    TextView choosed_jie;
    /**
     * 可以最大选择的课程数量
     */
    @BindView(R.id.choose_could)
    TextView choose_could;
    /**
     * 提交订单
     */
    @BindView(R.id.commit_order)
    TextView commit_order;

    /**
     * 显示月份
     */
    @BindView(R.id.tv_date)
    TextView tv_date;

    private String chooseCouldNum;

    private String timeId = "";

    private Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case Constant.FULL_CHECKED:
                    boolean could = (boolean) msg.obj;
                    EventBus.getDefault().post(could, Constant.FULL_CHECKED_);
                    break;
            }
        }

    };


    private List<DateBean> listD;

    @SuppressWarnings("deprecation")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_date);
        ButterKnife.bind(this);
        MainCallback callback = new MainCallback(this,this);
        String coachId = getIntent().getStringExtra(Constant.COACH_ID);
        callback.getCoachTime(coachId);
        shareBlack.setVisibility(View.GONE);

    }


    @SuppressWarnings("deprecation")
    private void initView(List<GetTimeBean> collect) {
        mainTitle.setText("选择时间");
        choose_could.setText("20");
        listD = new ArrayList<DateBean>();
        List<Fragment> setFragments = new ArrayList<Fragment>();
        for (DateBean bean : listDay) {
            listD.add(bean);
        }
        for (int i = 0; i < listD.size(); i++) {
            long key = listD.get(i).getKeyValue();
            listData = new ArrayList<>();
            for (GetTimeBean getTimeBean : collect) {
                if (getTimeBean.getKey() == key) {
                    listData.add(getTimeBean);
                }
            }

            Collections.sort(listData);
            Fragment fragment = new MyCalendarFragment(listData, i);
            setFragments.add(fragment);
        }

        adapter = new DateAdapter(this, listD);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setSmoothScrollbarEnabled(true);
        layoutManager.setOrientation(LinearLayout.HORIZONTAL);
        final State state = new State();
        flipper.setLayoutManager(layoutManager);
        flipper.setAdapter(adapter);


        listen_list_contain.setAdapter(new ChangePagerAdapter(
                getSupportFragmentManager(), setFragments));
        listen_list_contain.setOnPageChangeListener(new OnPageChangeListener() {

            @Override
            public void onPageSelected(int arg0) {
                adapter.setSeclection(arg0);
                layoutManager.smoothScrollToPosition(flipper, state, arg0);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int arg0) {

            }
        });

        adapter.setOnGetPositionListener(new DateAdapter.OnGetPositionListener() {

            @Override
            public void getPosition(View v, int position) {
                // TODO 设为false来关闭滑动，只用于显示
                listen_list_contain.setCurrentItem(position, true);
            }
        });
        listen_list_contain.setOffscreenPageLimit(size);
        chooseCouldNum = choose_could.getText().toString().trim();
        adapter.setOnGetMounthListener(new DateAdapter.OnGetMounthListener() {

            @Override
            public void getMounth(String mounth) {
                tv_date.setText(mounth + "月");

            }
        });
    }

    @OnClick({R.id.commit_order,R.id.back_black, R.id.title_right_tv})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.commit_order:
                if (choosed_jie.getText().toString().trim().equals("0")) {
                    CustomToast.createToast().showFaild(this, "请选择私教课时");
                    break;
                }
                EventBus.getDefault().post(timeId,Constant.COACH_TIME);
                finish();
                break;
            case R.id.back_black:
                finish();
                break;
            case R.id.title_right_tv:
                break;
        }
    }


    @Override
    protected void onPause() {
        super.onPause();
    }

    /**
     * 控制viewPager所有选择的时间
     *
     * @param time
     */
    @Subscriber(tag = Constant.GET_TIME_CHOOSER_)
    public void getTimeChoose(Map<Integer, List<GetTimeBean>> time) {
        //////////////////////初始化开始/////////////////////////////
        timeId = "";
        int couldChecked = Integer.parseInt(chooseCouldNum);
        int checkedSize = 0;
        ///////////////////////初始化完毕////////////////////////

        ////////////////////获取点击到的时间key///////////////////////////
        Set<Integer> set = time.keySet();
        for (Integer showArgs : set) {
            List<GetTimeBean> showrealArgs = time.get(showArgs);
            checked.put(showArgs, showrealArgs);//重组map集合
        }
        //////////////////////获取重组的时间key///////////////////////////
        Set<Integer> keySet = checked.keySet();
        ///////////////////////遍历所有选择的时间///////////////////////////////
        for (Integer total : keySet) {
            List<GetTimeBean> checkedArgs = checked.get(total);
            for (GetTimeBean getTimeBean : checkedArgs) {
                if (getTimeBean.isChecked()) {
                    if (checkedSize == 0) {
                        timeId = getTimeBean.getId();
                    } else {
                        timeId = timeId + "," + getTimeBean.getId();
                    }
                    TimeShowBean bean = new TimeShowBean();
                    bean.setShowTime(getTimeBean.getShowTime());
                    bean.setWeekendShow(TimeUtils.getFullDateWeekTime(getTimeBean.getStartTime()));
                    checkedSize++;

                }
            }
        }
        /////////////////////////////控制dialog显示///////////////////////////////////////////////
        if (couldChecked == checkedSize) {
            ViewUtil.createTwoDialog(this, "您的课程已选满", "确定", new TwoButtomDialog.OnPositiveButtonDialog() {
                @Override
                public void positiveMethod() {

                }
            }, false);
            handler.obtainMessage(Constant.FULL_CHECKED, true).sendToTarget();
        } else {
            handler.obtainMessage(Constant.FULL_CHECKED, false).sendToTarget();
        }
        choosed_jie.setText(" " + checkedSize + " ");

    }


    @Override
    public void viewMode(Response res, String tag) {
        if (HttpConstant.getCoahTime.equals(tag)) {
            ChooseTimeEntity entity = (ChooseTimeEntity) res.body();
            List<ChooseTimeBean> data = entity.getData();
            List<GetTimeBean> collect = new ArrayList<GetTimeBean>();
            for (ChooseTimeBean chooseTimeBean : data) {
                long valueTime = TimeUtils.getLongValueTime(chooseTimeBean.getTimestart());
                String valueDayMounth = TimeUtils.getValueDayMounth(chooseTimeBean.getTimestart());
                String weekTime = TimeUtils.getFullDateWeekTime(chooseTimeBean.getTimestart());
                String[] split = valueDayMounth.split("-");
                int hour = TimeUtils.getTimeString(chooseTimeBean.getTimestart());
                String pa = "";
                if (hour < 12) {
                    pa = "上午";
                } else if (hour < 19) {
                    pa = "下午";
                } else {
                    pa = "晚上";
                }
                String showTime = TimeUtils.getTimeString(chooseTimeBean.getTimestart(), chooseTimeBean.getTimeend());
                long valueHour = TimeUtils.getLongValueHour(chooseTimeBean.getTimeend());
                DateBean dateBean = new DateBean();
                dateBean.setDay(split[1]);
                dateBean.setMounth(split[0]);
                dateBean.setWeekend(weekTime);
                dateBean.setKeyValue(valueTime);
                listDay.add(dateBean);
                //创建条目
                GetTimeBean timeBean = new GetTimeBean();
                timeBean.setAm_pm(pa);
                timeBean.setKey(valueTime);
                timeBean.setKeyValue(valueHour);
                timeBean.setShowTime(showTime);
                timeBean.setId(chooseTimeBean.getId());
                timeBean.setStartTime(chooseTimeBean.getTimestart());
                collect.add(timeBean);
            }
            size = listDay.size();
            initView(collect);
        }
    }

    @Override
    public void getFalse(boolean tag, String message) {

    }

    @Override
    public void showCode(int code, String string) {

    }

}
