package com.msport.clientmaster.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.msport.clientmaster.R;
import com.msport.clientmaster.view.wheelview.adapters.AbstractWheelTextAdapter;
import com.msport.clientmaster.view.wheelview.views.OnWheelChangedListener;
import com.msport.clientmaster.view.wheelview.views.OnWheelScrollListener;
import com.msport.clientmaster.view.wheelview.views.WheelView;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by like on 1950/7/28.
 */

public class PubulicPopTimeDialog extends Dialog implements View.OnClickListener {

    /**
     * 时
     */
    private WheelView wvBirthHour;
    /**
     * 分
     */
    private WheelView wvBirthMin;
    private Context context;
    private WheelView wvYear;
    private WheelView wvMonth;
    private WheelView wvDay;


    private TextView btnSure;
    private TextView btnCancel;

    private ArrayList<String> arry_years = new ArrayList<String>();
    private ArrayList<String> arry_months = new ArrayList<String>();
    private ArrayList<String> arry_days = new ArrayList<String>();
    private CalendarTextAdapter mYearAdapter;
    private CalendarTextAdapter mMonthAdapter;
    private CalendarTextAdapter mDaydapter;

    private int month;
    private int day;

    private int currentYear = getYear();
    private int currentMonth = 1;
    private int currentDay = 1;
    private int currentHour = 0;
    private int currentMin = 0;


    private int maxTextSize = 14;
    private int minTextSize = 11;

    private boolean issetdata = false;

    private String selectYear;
    private String selectMonth;
    private String selectDay;

    private OnBirthListener onBirthListener;
    private View vChangeBirth;
    private View vChangeBirthChild;
    private CalendarTextAdapter mHourAdapter;
    private ArrayList<String> arry_hour = new ArrayList<>();
    private ArrayList<String> arry_min = new ArrayList<>();
    private String selectMin;
    private String selectHour;
    private int min;
    private CalendarTextAdapter mMinAdapter;
    private int hour;
    private View contain_alls;
    private View all_contain;

    public PubulicPopTimeDialog(Context context) {
        super(context, R.style.MyDialogStyleBottom);
        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buttom_popview);
        wvYear = (WheelView) findViewById(R.id.wv_birth_year);

        wvMonth = (WheelView) findViewById(R.id.wv_birth_month);
        wvDay = (WheelView) findViewById(R.id.wv_birth_day);
        wvBirthHour = (WheelView) findViewById(R.id.wv_birth_hour);
        wvBirthMin = (WheelView) findViewById(R.id.wv_birth_min);
        vChangeBirth = findViewById(R.id.titile_banner);
        vChangeBirthChild = findViewById(R.id.contain_alls);
        btnSure = (TextView) findViewById(R.id.one_yes);
        btnCancel = (TextView) findViewById(R.id.one_no);
        contain_alls = findViewById(R.id.contain_alls);
        all_contain = findViewById(R.id.all_contain);
        vChangeBirth.setOnClickListener(this);
        vChangeBirthChild.setOnClickListener(this);
        btnSure.setOnClickListener(this);
        btnCancel.setOnClickListener(this);
        contain_alls.setOnClickListener(this);
        all_contain.setBackgroundColor(ContextCompat.getColor(context,R.color.white));
        if (!issetdata) {
            initData();
        }
        initYears();
        initEvent();
        mYearAdapter = new CalendarTextAdapter(context, arry_years, setYear(currentYear), maxTextSize, minTextSize);
        wvYear.setVisibleItems(5);
        wvYear.setViewAdapter(mYearAdapter);
        wvYear.setCurrentItem(setYear(currentYear));
        if (month == getMonth()) {
            initMonths(month, true);
        } else {
            initMonths(month, false);
        }
        mMonthAdapter = new CalendarTextAdapter(context, arry_months, setMonth(currentMonth), maxTextSize, minTextSize);
        wvMonth.setVisibleItems(5);
        wvMonth.setViewAdapter(mMonthAdapter);
        wvMonth.setCurrentItem(setMonth(currentMonth));
        if (Integer.parseInt(selectMonth) == getMonth() && Integer.parseInt(selectYear) == getYear()) {
            initDays(day, true);
        } else {
            initDays(day, false);
        }
        mDaydapter = new CalendarTextAdapter(context, arry_days, currentDay - 1, maxTextSize, minTextSize);
        wvDay.setVisibleItems(5);
        wvDay.setViewAdapter(mDaydapter);
        wvDay.setCurrentItem(currentDay - 1);

        mHourAdapter = new CalendarTextAdapter(context, arry_hour, setHour(currentHour), maxTextSize, minTextSize);
        wvBirthHour.setVisibleItems(5);
        wvBirthHour.setViewAdapter(mHourAdapter);
        wvBirthHour.setCurrentItem(Integer.parseInt(selectHour));
        initHours(hour);

        mMinAdapter = new CalendarTextAdapter(context, arry_min, currentMin, maxTextSize, minTextSize);
        wvBirthMin.setVisibleItems(5);
        wvBirthMin.setViewAdapter(mMinAdapter);
        wvBirthMin.setCurrentItem(Integer.parseInt(selectMin));
        initMin(min);

    }

    private void initEvent() {
        wvYear.addChangingListener(new OnWheelChangedListener() {

            @Override
            public void onChanged(WheelView wheel, int oldValue, int newValue) {
                // TODO Auto-generated method stub
                String currentText = (String) mYearAdapter.getItemText(wheel.getCurrentItem());
                selectYear = currentText;
                setTextviewSize(currentText, mYearAdapter);
                currentYear = Integer.parseInt(currentText);
                setYear(currentYear);
                showRealC(currentText);
                mMonthAdapter = new CalendarTextAdapter(context, arry_months, 0, maxTextSize, minTextSize);
                wvMonth.setVisibleItems(5);
                wvMonth.setViewAdapter(mMonthAdapter);
                wvMonth.setCurrentItem(0);
            }
        });

        wvYear.addScrollingListener(new OnWheelScrollListener() {

            @Override
            public void onScrollingStarted(WheelView wheel) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onScrollingFinished(WheelView wheel) {
                // TODO Auto-generated method stub
                String currentText = (String) mYearAdapter.getItemText(wheel.getCurrentItem());
                setTextviewSize(currentText, mYearAdapter);
                selectYear = currentText;
                selectMonth = currentMonth + "";
                selectDay = currentDay + "";
                showRealC(currentText);

            }
        });

        wvMonth.addChangingListener(new OnWheelChangedListener() {

            @Override
            public void onChanged(WheelView wheel, int oldValue, int newValue) {
                // TODO Auto-generated method stub
                String currentText = (String) mMonthAdapter.getItemText(wheel.getCurrentItem());
                selectMonth = currentText;
                setTextviewSize(currentText, mMonthAdapter);
                setMonth(Integer.parseInt(currentText));
                showRealC(currentText);
                mDaydapter = new CalendarTextAdapter(context, arry_days, 0, maxTextSize, minTextSize);
                wvDay.setVisibleItems(5);
                wvDay.setViewAdapter(mDaydapter);
                wvDay.setCurrentItem(0);

            }
        });

        wvMonth.addScrollingListener(new OnWheelScrollListener() {

            @Override
            public void onScrollingStarted(WheelView wheel) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onScrollingFinished(WheelView wheel) {
                // TODO Auto-generated method stub
                String currentText = (String) mMonthAdapter.getItemText(wheel.getCurrentItem());
                setTextviewSize(currentText, mMonthAdapter);
                selectMonth = currentText;
                selectDay = currentDay + "";
                showRealC(currentText);
            }
        });

        wvDay.addChangingListener(new OnWheelChangedListener() {

            @Override
            public void onChanged(WheelView wheel, int oldValue, int newValue) {
                String currentText = (String) mDaydapter.getItemText(wheel.getCurrentItem());
                setTextviewSize(currentText, mDaydapter);
                selectDay = currentText;
            }
        });

        wvDay.addScrollingListener(new OnWheelScrollListener() {

            @Override
            public void onScrollingStarted(WheelView wheel) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onScrollingFinished(WheelView wheel) {
                // TODO Auto-generated method stub
                String currentText = (String) mDaydapter.getItemText(wheel.getCurrentItem());
                setTextviewSize(currentText, mDaydapter);
            }
        });
        wvBirthHour.addChangingListener(new OnWheelChangedListener() {
            @Override
            public void onChanged(WheelView wheel, int oldValue, int newValue) {
                String currentText = (String) mHourAdapter.getItemText(wheel.getCurrentItem());
                setTextviewSize(currentText, mHourAdapter);
            }
        });
        wvBirthHour.addScrollingListener(new OnWheelScrollListener() {
            @Override
            public void onScrollingStarted(WheelView wheel) {

            }

            @Override
            public void onScrollingFinished(WheelView wheel) {
                String currentText = mHourAdapter.getItemText(wheel.getCurrentItem()).toString();
                setTextviewSize(currentText, mHourAdapter);
                selectHour = currentText;
            }
        });

        wvBirthMin.addChangingListener(new OnWheelChangedListener() {
            @Override
            public void onChanged(WheelView wheel, int oldValue, int newValue) {
                String currentText = (String) mMinAdapter.getItemText(wheel.getCurrentItem());
                setTextviewSize(currentText, mMinAdapter);
                selectMin = currentText;
            }
        });

        wvBirthMin.addScrollingListener(new OnWheelScrollListener() {
            @Override
            public void onScrollingStarted(WheelView wheel) {

            }

            @Override
            public void onScrollingFinished(WheelView wheel) {
                String currentText = (String) mMinAdapter.getItemText(wheel.getCurrentItem());
                setTextviewSize(currentText, mMinAdapter);
                selectMin = currentText;
            }
        });


    }

    public void initYears() {
        for (int i = getYear(); i < 2100; i++) {
            arry_years.add(i + "");
        }
    }

    public void initMonths(int months, boolean tag) {
        arry_months.clear();
        if (tag) {
            for (int i = getMonth(); i <= 12; i++) {
                if (i < 10) {
                    arry_months.add("0" + i);
                } else {
                    arry_months.add(i + "");
                }
            }
        } else {
            for (int i = 1; i <= months; i++) {
                if (i < 10) {
                    arry_months.add("0" + i);
                } else {
                    arry_months.add(i + "");
                }
            }
        }
    }

    public void initDays(int days, boolean tag) {
        arry_days.clear();
        if (tag) {
            for (int i = getDay(); i <= callday(); i++) {
                if (i < 10) {
                    arry_days.add("0" + i);
                } else {
                    arry_days.add(i + "");
                }
            }
        } else {
            for (int i = 1; i <= days; i++) {
                if (i < 10) {
                    arry_days.add("0" + i);
                } else {
                    arry_days.add(i + "");
                }
            }
        }
    }


    public void initHours(int hours) {
        arry_hour.clear();
        if ((getDay()+"").equals(selectDay)){
            for (int i = hours; i < 24; i++) {
                if (i >= 10)
                    arry_hour.add(i + "");
                else
                    arry_hour.add("0" + i);
            }
        }else {
            for (int i = 0; i < 24; i++) {
                if (i >= 10)
                    arry_hour.add(i + "");
                else
                    arry_hour.add("0" + i);
            }
        }
    }

    public void initMin(int min) {
        arry_min.clear();
        if (selectDay.equals(getDay()+"")){
            for (int i = min; i < 60; i++) {
                if (i >= 10)
                    arry_min.add(i + "");
                else
                    arry_min.add("0" + i);
            }
        }else {
            for (int i = 0; i < 60; i++) {
                if (i >= 10)
                    arry_min.add(i + "");
                else
                    arry_min.add("0" + i);
            }
        }

    }

    public int setHour(int hour) {
        int resultHour = 0;
        if (selectDay .equals( getDay()+"")) {
            resultHour = getHour();
        } else {
            resultHour = 0;
        }
        return resultHour;
    }

    public int setMin(int min) {
        int resultMin = 0;
        if (selectDay.equals(getDay()+""))
            return getMin();
        else
            return resultMin;
    }


    private class CalendarTextAdapter extends AbstractWheelTextAdapter {
        ArrayList<String> list;

        protected CalendarTextAdapter(Context context, ArrayList<String> list, int currentItem, int maxsize, int minsize) {
            super(context, R.layout.item_birth_year, NO_RESOURCE, currentItem, maxsize, minsize);
            this.list = list;
            setItemTextResource(R.id.tempValue);
        }

        @Override
        public View getItem(int index, View cachedView, ViewGroup parent) {
            View view = super.getItem(index, cachedView, parent);
            return view;
        }

        @Override
        public int getItemsCount() {
            return list.size();
        }

        @Override
        protected CharSequence getItemText(int index) {
            return list.get(index) + "";
        }
    }

    public void setBirthdayListener(OnBirthListener onBirthListener) {
        this.onBirthListener = onBirthListener;
    }

    @Override
    public void onClick(View v) {

        if (v == btnSure) {
            if (onBirthListener != null) {
                onBirthListener.onClick(selectYear, selectMonth, selectDay, selectHour, selectMin);
            }
        } else if (v == btnCancel) {

        } else if (v == vChangeBirthChild) {
            return;
        } else {
            dismiss();
        }
        dismiss();

    }

    public interface OnBirthListener {
        void onClick(String year, String month, String day, String hour, String min);
    }

    /**
     * 设置字体大小
     *
     * @param curriteItemText
     * @param adapter
     */
    public void setTextviewSize(String curriteItemText, CalendarTextAdapter adapter) {
        ArrayList<View> arrayList = adapter.getTestViews();
        int size = arrayList.size();
        String currentText;
        for (int i = 0; i < size; i++) {
            TextView textvew = (TextView) arrayList.get(i);
            currentText = textvew.getText().toString();
            if (curriteItemText.equals(currentText)) {
                textvew.setTextSize(maxTextSize);
            } else {
                textvew.setTextSize(minTextSize);
            }
        }
    }

    public int getYear() {
        Calendar c = Calendar.getInstance();
        return c.get(Calendar.YEAR);
    }

    public int getMonth() {
        Calendar c = Calendar.getInstance();
        return c.get(Calendar.MONTH) + 1;
    }

    public int getDay() {
        Calendar c = Calendar.getInstance();
        return c.get(Calendar.DATE);
    }

    /**
     * 获得当前的小时
     *
     * @return
     */
    public int getHour() {
        Calendar c = Calendar.getInstance();
        return c.get(Calendar.HOUR_OF_DAY);
    }


    /**
     * 获得当前的分钟
     *
     * @return
     */
    public int getMin() {
        Calendar c = Calendar.getInstance();
        return c.get(Calendar.MINUTE);
    }


    public void initData() {
        setDate(getYear(), getMonth(), getDay());
        this.currentDay = 1;
        this.currentMonth = 1;
        this.currentMin = 0;
        this.currentHour = 0;

    }

    /**
     * 设置年月日
     *
     * @param year
     * @param month
     * @param day
     */
    public void setDate(int year, int month, int day) {
        selectYear = year + "";
        selectMonth = month + "";
        selectDay = day + "";
        issetdata = true;
        this.currentYear = year;
        this.currentMonth = month;
        this.currentDay = day;
        if (year == getYear()) {
            this.month = getMonth();
        } else {
            this.month = 12;
        }
        selectHour = "00";
        selectMin = "00";
        currentHour = 0;
        currentMin = 0;

        calDays(year, month);
    }

    /**
     * 设置年份
     *
     * @param year
     */
    public int setYear(int year) {
        int yearIndex = 0;
        if (year != getYear()) {
            this.month = 12;
        } else {
            this.month = getMonth();
        }
        for (int i = getYear(); i <= 2100; i++) {
            if (i == year) {
                return yearIndex;
            }
            yearIndex++;
        }
        return yearIndex;
    }

    /**
     * 设置月份
     *
     * @param month
     * @return
     */
    public int setMonth(int month) {
        int monthIndex = 0;
        calDays(currentYear, month);
        for (int i = 1; i < this.month; i++) {
            if (month == i) {
                return monthIndex;
            } else {
                monthIndex++;
            }
        }
        return monthIndex;
    }

    /**
     * 计算每月多少天
     *
     * @param month
     */
    public void calDays(int year, int month) {
        boolean leayyear = false;
        leayyear = year % 4 == 0 && year % 100 != 0;
        for (int i = 1; i <= 12; i++) {
            switch (month) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    this.day = 31;
                    break;
                case 2:
                    if (leayyear) {
                        this.day = 29;
                    } else {
                        this.day = 28;
                    }
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    this.day = 30;
                    break;
            }
        }
        if (year == getYear() && month == getMonth()) {
            this.day = getDay();
        }

    }

    /**
     * 计算天数
     */
    public int callday() {
        int totalday = 0;
        boolean leayyear = false;
        leayyear = getYear() % 4 == 0 && getYear() % 100 != 0;
        for (int i = 1; i <= 12; i++) {
            switch (getMonth()) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    totalday = 31;
                    break;
                case 2:
                    if (leayyear) {
                        totalday = 29;
                    } else {
                        totalday = 28;
                    }
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    totalday = 30;
                    break;
            }
        }
        return totalday;
    }

    /**
     * 显示联动
     *
     * @param currentText
     */
    private void showRealC(String currentText) {
        if (month == getMonth()) {
            initMonths(month, true);
        } else {
            initMonths(month, false);
        }
        if (Integer.parseInt(currentText) == getMonth() && Integer.parseInt(selectYear) == getYear()) {
            initDays(day, true);
        } else {
            initDays(day, false);
        }

    }

}
