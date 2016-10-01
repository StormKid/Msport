package com.msport.clientmaster.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.msport.clientmaster.R;
import com.msport.clientmaster.constants.Constant;
import com.msport.clientmaster.view.wheelview.adapters.AbstractWheelTextAdapter;
import com.msport.clientmaster.view.wheelview.views.OnWheelChangedListener;
import com.msport.clientmaster.view.wheelview.views.OnWheelScrollListener;
import com.msport.clientmaster.view.wheelview.views.WheelView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by like on 1950/7/28.
 */

public class PubulicPopSingleChoicerDialog extends Dialog implements View.OnClickListener {


    private final Context context;
    /**
     * 根据传递进来的类型，来组装数据
     */
    private final String type;
    @BindView(R.id.one_no)
    TextView oneNo;
    @BindView(R.id.one_yes)
    TextView oneYes;
    @BindView(R.id.titile_banner)
    RelativeLayout titileBanner;
    @BindView(R.id.buttom_single)
    WheelView buttomSingle;
    @BindView(R.id.contain_alls)
    LinearLayout containAlls;
    @BindView(R.id.all_contain)
    LinearLayout allContain;
    private OnBirthListener onBirthListener;
    private int maxTextSize = 18;
    private int minTextSize = 13;
    private ArrayList<String> aryys = new ArrayList<>();
    private CalendarTextAdapter adapter;
    private String select;

    public PubulicPopSingleChoicerDialog(Context context, String type) {
        super(context, R.style.MyDialogStyleBottom);
        this.context = context;
        this.type = type;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buttom_single_popview);
        ButterKnife.bind(this);
        initArrays();
        adapter = new CalendarTextAdapter(context, aryys, maxTextSize, minTextSize);
        buttomSingle.setCurrentItem(0);
        buttomSingle.setViewAdapter(adapter);
        select = aryys.get(0);
        allContain.setBackgroundColor(ContextCompat.getColor(context,R.color.white));
        initEvent();
    }

    private void initArrays() {
        switch (type) {
            case Constant.SHOW_MEMBER:
                for (int i = 1; i <= 50; i++) {
                    aryys.add(i + "");
                }
                select = aryys.get(0);
                break;
            case Constant.SHOW_MIN:
                aryys.add("15分钟");
                aryys.add("30分钟");
                aryys.add("45分钟");
                aryys.add("60分钟");
                select = aryys.get(0);
                break;
            case Constant.QIANBAO_TYPE:
                aryys.add("支付宝");
                aryys.add("微信");
                break;
            case Constant.PRO_GENDER:
                aryys.add("男");
                aryys.add("女");
                break;
        }

    }

    private void initEvent() {
        buttomSingle.addScrollingListener(new OnWheelScrollListener() {
            @Override
            public void onScrollingStarted(WheelView wheel) {

            }

            @Override
            public void onScrollingFinished(WheelView wheel) {
                String current = adapter.getItemText(wheel.getCurrentItem()).toString();
                setTextviewSize(current, adapter);
                select = current;

            }
        });

        buttomSingle.addChangingListener(new OnWheelChangedListener() {
            @Override
            public void onChanged(WheelView wheel, int oldValue, int newValue) {
                String current = adapter.getItemText(wheel.getCurrentItem()).toString();
                setTextviewSize(current, adapter);
                select = current;
            }
        });

    }

    /**
     * 控制点击消失
     *
     * @param view
     */
    @OnClick({R.id.one_no, R.id.one_yes, R.id.titile_banner, R.id.contain_alls})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.one_no:
                dismiss();
                break;
            case R.id.one_yes:
                if (onBirthListener != null) {
                    onBirthListener.onClick(select);
                }
                dismiss();
                break;
            case R.id.titile_banner:
                break;
            case R.id.contain_alls:
                dismiss();
                break;
        }
    }


    private class CalendarTextAdapter extends AbstractWheelTextAdapter {
        ArrayList<String> list;

        protected CalendarTextAdapter(Context context, ArrayList<String> list, int maxsize, int minsize) {
            super(context, R.layout.item_birth_year, NO_RESOURCE, 0, maxsize, minsize);
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


    public interface OnBirthListener {
        void onClick(String value);
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


}
