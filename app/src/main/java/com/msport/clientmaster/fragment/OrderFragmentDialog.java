package com.msport.clientmaster.fragment;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.content.ContextCompat;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.msport.clientmaster.R;

/**
 * 顶部
 * Created by like on 2016/7/18.
 */
@SuppressLint("ValidFragment")
public class OrderFragmentDialog extends DialogFragment implements View.OnClickListener {
    private String type;
    private int dagHight;
    private int layoutid;
    private boolean pressChange = true;
    private Context context;


    public OrderFragmentDialog(int dagHight, int layoutid, String type,Context context) {
        this.dagHight = dagHight;
        this.layoutid = layoutid;
        this.type = type;
        this.context = context;

    }


    @Override
    public void onResume() {
        super.onResume();
        if (listener != null) {
            listener.getDialogState(true);
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (listener != null) {
            listener.getDialogState(false);
        }
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // 使用不带theme的构造器，获得的dialog边框距离屏幕仍有几毫米的缝隙。
        // Dialog dialog = new Dialog(getActivity());
        Dialog dialog = new Dialog(getActivity(), R.style.MyTopDialog);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); // must be called before set content
        dialog.setContentView(layoutid);
        dialog.setCanceledOnTouchOutside(true);
        // 设置宽度为屏宽、靠近屏幕底部。
        Window window = dialog.getWindow();
        WindowManager.LayoutParams wlp = window.getAttributes();
        wlp.gravity = Gravity.NO_GRAVITY;
        wlp.width = WindowManager.LayoutParams.MATCH_PARENT;
        wlp.dimAmount = 0f;
        window.setAttributes(wlp);
        initView(dialog);
        return dialog;
    }

    private void initView(Dialog dialog) {
        switch (layoutid){
            case R.layout.order_list_pop_layout:
                View title = dialog.findViewById(R.id.title);
                title.setOnClickListener(this);
                View view = dialog.findViewById(R.id.contain_alls);
                view.setOnClickListener(this);
                View all_contain = dialog.findViewById(R.id.all_contain);
                View menpiao_type = dialog.findViewById(R.id.menpiao_type);
                View yueqiu_type =   dialog.findViewById(R.id.yueqiu_type);
                View coach_type = dialog.findViewById(R.id.coach_type);
                View course_type =  dialog.findViewById(R.id.course_type);
                menpiao_type.setOnClickListener(this);
                yueqiu_type.setOnClickListener(this);
                coach_type.setOnClickListener(this);
                course_type.setOnClickListener(this);
                all_contain.setBackgroundColor(ContextCompat.getColor(context,R.color.white));
                break;
        }
    }


    public void setOnDialogStateListener(onDialogStateListener listener) {
        this.listener = listener;
    }
    public onDialogStateListener listener;

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.title :
                dismiss();
                break;
            case R.id.contain_alls:
                dismiss();
                break;
            case R.id.course_type:
                setOutPut("0","课程订单");
                break;
            case R.id.coach_type:
                setOutPut("2","私教订单");
                break;
            case R.id.yueqiu_type:
                setOutPut("4","约球订单");
                break;
            case R.id.menpiao_type:
                setOutPut("7","门票订单");
                break;
        }

    }
    public interface onDialogStateListener {
        void getDialogState(boolean tag);
    }

    public interface OnSaveOutputListener {
        void getOutPut( String type,String value);
    }
    private OnSaveOutputListener slistener;
    public void setOnSaveOutputListener (OnSaveOutputListener slistener){
        this.slistener = slistener;
    }

    private void setOutPut(String sType,String value){
        if (slistener!=null){
            slistener.getOutPut(sType,value);
        }
        dismiss();
    }

}
