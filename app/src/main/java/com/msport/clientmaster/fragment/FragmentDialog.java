package com.msport.clientmaster.fragment;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.content.ContextCompat;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.msport.clientmaster.R;
import com.msport.clientmaster.adapter.MySingleSportAdapter;
import com.msport.clientmaster.constants.Constant;
import com.msport.clientmaster.entity.CourseTypeEntity;
import com.msport.clientmaster.requestbean.CoachRequestBean;
import com.msport.clientmaster.requestbean.CourseRequestBean;
import com.msport.clientmaster.requestbean.MenPiaoAddressRequestBean;
import com.msport.clientmaster.util.CustomToast;
import com.msport.clientmaster.util.StringUtil;

import org.simple.eventbus.EventBus;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 底部弹窗控件
 * Created by like on 2016/7/18.
 */
@SuppressLint("ValidFragment")
public class FragmentDialog extends DialogFragment implements View.OnClickListener {
    private String type;
    private final Context context;
    private Map<CourseTypeEntity.DataBean, List<CourseTypeEntity.DataBean>> shaixuans;
    private CourseRequestBean courseRequestBean;
    private int dagHight;
    private int layoutid;
    private LinearLayout pop_sex;
    private LinearLayout pop_week;
    private TextView pop_sex_all;
    private TextView pop_sex_man;
    private TextView pop_sex_woman;
    private TextView pop_one_week;
    private TextView pop_two_week;
    private TextView pop_week_all;
    private boolean pressChange = true;
    private TextView pop_price_all;
    private EditText pop_price_max;
    private EditText pop_price_min;

    private TextView pingjia_categroy;
    private TextView pop_sex_tv;
    private TextView zhineng_category;
    private TextView price_max_categroy;
    private TextView price_min_categroy;
    private TextView renqi_categroy;
    private CoachRequestBean coachRequestBean;
    private MenPiaoAddressRequestBean menPiaoAddressRequestBean ;


    public FragmentDialog(int dagHight, int layoutid, String type, Serializable serializable, Map<CourseTypeEntity.DataBean, List<CourseTypeEntity.DataBean>> shaixuans, Context context) {
        this.dagHight = dagHight;
        this.layoutid = layoutid;
        this.type = type;
        this.context = context;
        if (type.equals(Constant.COACH_LIST)) {
            coachRequestBean = (CoachRequestBean) serializable;
        }  else if (type.equals(Constant.MENPIAO_LIST)){
            menPiaoAddressRequestBean = (MenPiaoAddressRequestBean) serializable;
            coachRequestBean = new CoachRequestBean();
        }else {
            courseRequestBean = (CourseRequestBean) serializable;
        }
        if (shaixuans != null) {
            this.shaixuans = shaixuans;
        }

    }


    @Override
    public void onResume() {
        super.onResume();
        if (listener != null) {
            listener.getDialogState(true);
        }
        EventBus.getDefault().register(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        if (listener != null) {
            listener.getDialogState(false);
        }
        EventBus.getDefault().unregister(this);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // 使用不带theme的构造器，获得的dialog边框距离屏幕仍有几毫米的缝隙。
        // Dialog dialog = new Dialog(getActivity());
        Dialog dialog = new Dialog(getActivity(), R.style.CustomDatePickerDialog);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); // must be called before set content
        dialog.setContentView(layoutid);
        dialog.setCanceledOnTouchOutside(true);
        // 设置宽度为屏宽、靠近屏幕底部。
        Window window = dialog.getWindow();
        WindowManager.LayoutParams wlp = window.getAttributes();
        wlp.y = dagHight;
        wlp.width = WindowManager.LayoutParams.MATCH_PARENT;
        wlp.gravity = Gravity.BOTTOM;
        wlp.dimAmount = 0f;
        window.setAttributes(wlp);
        initEvent(dialog);
        return dialog;
    }

    private void initEvent(Dialog dialog) {
        switch (layoutid) {
            case R.layout.dialog_didian:
                final ListView left_showrange = (ListView) dialog.findViewById(R.id.left_show);
                final ListView right_showrange = (ListView) dialog.findViewById(R.id.right_show);
                right_showrange.setVisibility(View.GONE);
                List<String> locationRange = StringUtil.getLocationRange();
                ShowSingleStringAdaper showSingleStringAdaper = new ShowSingleStringAdaper(locationRange);
                left_showrange.setAdapter(showSingleStringAdaper);
                left_showrange.setSmoothScrollbarEnabled(true);
                left_showrange.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        if (type.equals(Constant.COURSE_LIST)) {
                            courseRequestBean.servRange = i + "";
                            commit();
                        } else {
                            coachRequestBean.servRange = i + "";
                            commit();
                        }
                    }
                });
                right_showrange.setBackgroundColor(ContextCompat.getColor(context,R.color.white));
                break;
            case R.layout.dialog_shaixuan:
                pop_price_all = (TextView) dialog.findViewById(R.id.pop_price_all);
                pop_price_max = (EditText) dialog.findViewById(R.id.pop_price_max);
                pop_price_min = (EditText) dialog.findViewById(R.id.pop_price_min);
                View pop_yes = dialog.findViewById(R.id.pop_yes);
                View pop_reset = dialog.findViewById(R.id.pop_reset);
                View well_contain = dialog.findViewById(R.id.well_contain);
                pop_sex_all = (TextView) dialog.findViewById(R.id.pop_sex_all);
                pop_sex_man = (TextView) dialog.findViewById(R.id.pop_sex_man);
                pop_sex_woman = (TextView) dialog.findViewById(R.id.pop_sex_woman);
                pop_sex = (LinearLayout) dialog.findViewById(R.id.pop_sex);
                pop_week = (LinearLayout) dialog.findViewById(R.id.pop_week);
                pop_one_week = (TextView) dialog.findViewById(R.id.pop_one_week);
                pop_two_week = (TextView) dialog.findViewById(R.id.pop_two_week);
                pop_week_all = (TextView) dialog.findViewById(R.id.pop_week_all);
                pop_sex_tv = (TextView) dialog.findViewById(R.id.pop_sex_tv);
                if (!type.equals(Constant.COACH_LIST)) {
                    pop_sex.setVisibility(View.GONE);
                    pop_sex_tv.setVisibility(View.GONE);
                }
                pop_price_all.setOnClickListener(this);
                pop_sex_all.setOnClickListener(this);
                pop_one_week.setOnClickListener(this);
                pop_two_week.setOnClickListener(this);
                pop_week_all.setOnClickListener(this);
                pop_sex_woman.setOnClickListener(this);
                pop_sex_man.setOnClickListener(this);
                pop_yes.setOnClickListener(this);
                pop_reset.setOnClickListener(this);
                well_contain.setBackgroundColor(ContextCompat.getColor(context,R.color.white));
                pop_price_min.addTextChangedListener(new MyTextChangeListener(pop_price_min));
                pop_price_max.addTextChangedListener(new MyTextChangeListener(pop_price_max));
                break;
            case R.layout.dialog_paixu:
                pingjia_categroy = (TextView) dialog.findViewById(R.id.pingjia_categroy);
                zhineng_category = (TextView) dialog.findViewById(R.id.zhineng_category);
                price_max_categroy = (TextView) dialog.findViewById(R.id.price_max_categroy);
                price_min_categroy = (TextView) dialog.findViewById(R.id.price_min_categroy);
                renqi_categroy = (TextView) dialog.findViewById(R.id.renqi_categroy);
                pingjia_categroy.setOnClickListener(this);
                zhineng_category.setOnClickListener(this);
                price_max_categroy.setOnClickListener(this);
                price_min_categroy.setOnClickListener(this);
                renqi_categroy.setOnClickListener(this);

                break;
            case R.layout.dialog_xiangmu:
                ListView leftlv = (ListView) dialog.findViewById(R.id.left_show);
                final ListView rightlv = (ListView) dialog.findViewById(R.id.right_show);
                Set<CourseTypeEntity.DataBean> dataBeen = shaixuans.keySet();
                final List<CourseTypeEntity.DataBean> data = new ArrayList<>(dataBeen);
                MySingleSportAdapter parent = new MySingleSportAdapter(data, getActivity());
                leftlv.setAdapter(parent);
                if (!type.equals(Constant.COURSE_LIST)) {
                    rightlv.setVisibility(View.GONE);
                    parent.setonDataDoneListener(new MySingleSportAdapter.DataDoneListener() {
                        @Override
                        public void getdata(String parentId, String childId, int position) {
                            coachRequestBean.major = childId;
                            commit();
                        }
                    });
                }else {
                    parent.setonDataDoneListener(new MySingleSportAdapter.DataDoneListener() {
                        @Override
                        public void getdata(String parentId, String childId, int position) {
                            CourseTypeEntity.DataBean dataBean = data.get(position);
                            List<CourseTypeEntity.DataBean> bean = shaixuans.get(dataBean);
                            MySingleSportAdapter child = new MySingleSportAdapter(bean,getActivity());
                            rightlv.setAdapter(child);
                            child.setonDataDoneListener(new MySingleSportAdapter.DataDoneListener() {
                                @Override
                                public void getdata(String parentId, String childId, int position) {
                                    courseRequestBean.courseType = parentId;
                                    courseRequestBean.subCourseType = childId;
                                    courseRequestBean.position = position;
                                    commit();
                                }
                            });
                        }
                    });
                }

                break;


        }

    }


    public void setOnDialogStateListener(onDialogStateListener listener) {
        this.listener = listener;
    }

    public onDialogStateListener listener;

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.pop_sex_all:
                choiceColorChange(pop_sex, pop_sex_all, true);
                coachRequestBean.gender = "0";
                break;
            case R.id.pop_sex_man:
                choiceColorChange(pop_sex, pop_sex_man, true);
                coachRequestBean.gender = "1";
                break;
            case R.id.pop_sex_woman:
                choiceColorChange(pop_sex, pop_sex_woman, true);
                coachRequestBean.gender = "2";
                break;

            case R.id.pop_price_all:
                if (pressChange) {
                    pop_price_all.setTextColor(ContextCompat.getColor(getActivity(), R.color.text_orange));
                    pop_price_all.setBackgroundResource(R.drawable.shape_categroy_tagdo);
                    pop_price_min.clearFocus();
                    pop_price_max.clearFocus();
                    pop_price_max.setFocusable(false);
                    pop_price_min.setFocusable(false);
                    pressChange = false;
                    pop_price_max.setText("");
                    pop_price_min.setText("");
                } else {
                    pop_price_all.setTextColor(ContextCompat.getColor(getActivity(), R.color.text_gray_7c));
                    pop_price_all.setBackgroundResource(R.drawable.shape_categroy_tagnone);
                    pop_price_max.setFocusable(true);
                    pop_price_min.setFocusable(true);
                    pop_price_min.setFocusableInTouchMode(true);
                    pop_price_max.setFocusableInTouchMode(true);
                    pop_price_min.requestFocus();
                    pop_price_max.requestFocus();
                    pop_price_max.findFocus();
                    pop_price_min.findFocus();
                    pressChange = true;

                }


                break;

            case R.id.pop_yes:
                //TODO 将数据填充到bean中通过eventbus 传递出去
                if (!pressChange) {
                    if (type.equals(Constant.COACH_LIST)) {
                        coachRequestBean.highestPrice = "-1";
                        coachRequestBean.lowestPrice = "-1";
                    } else {
                        courseRequestBean.highestPrice = "-1";
                        courseRequestBean.lowestPrice = "-1";
                    }
                } else {
                    String pop_price_max_value = pop_price_max.getText().toString().trim();
                    String pop_price_min_value = pop_price_min.getText().toString().trim();
                    if (TextUtils.isEmpty(pop_price_max_value) || TextUtils.isEmpty(pop_price_min_value)) {
                        CustomToast.createToast().showFaild(getActivity(), "请输入价格");
                        return;
                    }
                    if (!type.equals(Constant.COURSE_LIST)) {
                        coachRequestBean.highestPrice = pop_price_max_value;
                        coachRequestBean.lowestPrice = pop_price_min_value;
                    } else {
                        courseRequestBean.highestPrice = pop_price_max_value;
                        courseRequestBean.lowestPrice = pop_price_min_value;
                    }
                }
                commit();
                break;
            case R.id.pop_reset:
                pop_price_max.setText("");
                pop_price_min.setText("");
                pop_price_all.setSelected(true);
                pop_sex_all.setSelected(true);
                break;

            case R.id.pop_week_all:
                choiceColorChange(pop_week, pop_week_all, true);
                break;
            case R.id.pop_one_week:
                choiceColorChange(pop_week, pop_one_week, true);
                break;
            case R.id.pop_two_week:
                choiceColorChange(pop_week, pop_two_week, true);
                break;
            case R.id.pingjia_categroy:
                if (!type.equals(Constant.COURSE_LIST)) coachRequestBean.value = "6";
                else courseRequestBean.value = "6";
                commit();

                break;
            case R.id.zhineng_category:
                if (!type.equals(Constant.COURSE_LIST)) coachRequestBean.value = "1";
                else courseRequestBean.value = "1";
                commit();
                break;
            case R.id.price_max_categroy:
                if (!type.equals(Constant.COURSE_LIST)) coachRequestBean.value = "4";
                else courseRequestBean.value = "4";
                commit();

                break;
            case R.id.price_min_categroy:
                if (!type.equals(Constant.COURSE_LIST)) coachRequestBean.value = "3";
                else courseRequestBean.value = "3";
                commit();
                break;
            case R.id.renqi_categroy:
                if (!type.equals(Constant.COURSE_LIST)) coachRequestBean.value = "5";
                else courseRequestBean.value = "5";
                commit();
                break;


        }
    }

    private void commit() {
        if (type.equals(Constant.COURSE_LIST)) {
            EventBus.getDefault().post(courseRequestBean, Constant.COURSE_LIST);
        } else if (type.equals(Constant.COACH_LIST)) {
            EventBus.getDefault().post(coachRequestBean, Constant.COACH_LIST);
        }else {
            menPiaoAddressRequestBean.highestPrice = coachRequestBean.highestPrice;
            menPiaoAddressRequestBean.lowestPrice = coachRequestBean.lowestPrice;
            menPiaoAddressRequestBean.major = coachRequestBean.major;
            menPiaoAddressRequestBean.servRange = coachRequestBean.servRange;
            menPiaoAddressRequestBean.value = coachRequestBean.value;
            EventBus.getDefault().post(menPiaoAddressRequestBean,Constant.MENPIAO_LIST);
        }
        dismiss();
    }


    public interface onDialogStateListener {
        void getDialogState(boolean tag);
    }

    /**
     * 页面显示对应的布局变化
     *
     * @param vg
     * @param choiceTv
     * @param tag
     */
    private void choiceColorChange(ViewGroup vg, TextView choiceTv, boolean tag) {

        for (int i = 0; i < vg.getChildCount(); i++) {
            TextView tv = (TextView) vg.getChildAt(i);
            tv.setTextColor(ContextCompat.getColor(getActivity(), R.color.text_gray_7c));
            tv.setBackgroundResource(R.drawable.shape_categroy_tagnone);
        }
        if (tag) {
            choiceTv.setTextColor(ContextCompat.getColor(getActivity(), R.color.text_orange));
            choiceTv.setBackgroundResource(R.drawable.shape_categroy_tagdo);
        }
    }


    public interface SaveOutputListener {
        void getOutPut(Serializable bean);
    }

    private SaveOutputListener saveOutputListener;

    public void setOnSaveOutputListener(SaveOutputListener listener) {
        this.saveOutputListener = listener;
    }


    private class ShowSingleStringAdaper extends BaseAdapter {

        private List<String> list;

        public ShowSingleStringAdaper(List<String> list) {
            this.list = list;
        }

        @Override
        public int getCount() {
            return list == null ? 0 : list.size();
        }

        @Override
        public Object getItem(int i) {
            return list.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            if (view == null) {
                view = LayoutInflater.from(getActivity()).inflate(R.layout.item_sigleworld, null);
            }
            TextView show_category_text = (TextView) view.findViewById(R.id.show_category_text);
            show_category_text.setText(list.get(i));

            return view;
        }
    }


    private class MyTextChangeListener implements TextWatcher {
        private EditText textView;

        public MyTextChangeListener(EditText textView) {
            this.textView = textView;
        }

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            StringUtil.editPoint(textView, charSequence);

        }

        @Override
        public void afterTextChanged(Editable editable) {


        }
    }


}
