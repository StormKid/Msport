package com.msport.clientmaster.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.msport.clientmaster.R;

import org.simple.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by like on 2016/8/8.
 */

public class TwoButtomDialog extends Dialog {

    private final String spositive;
    private boolean visible;
    @BindView(R.id.dialog_title)
    TextView dialogTitle;
    @BindView(R.id.dialog_yes)
    Button dialogYes;
    @BindView(R.id.dialog_no)
    Button dialogNo;
    @BindView(R.id.dialog_all)
    LinearLayout dialogAll;

    private String stitle;

    public TwoButtomDialog(Context context, String title, String positive,boolean Visible) {
        super(context, R.style.normalDialog);
        this.stitle = title;
        this.spositive = positive;
        this.visible = Visible;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_teobutton);
        ButterKnife.bind(this);
        dialogTitle.setText(stitle);
        dialogYes.setText(spositive);
        if (!visible)
            dialogNo.setVisibility(View.GONE);
        EventBus.getDefault().register(this);

    }

    @OnClick({R.id.dialog_yes, R.id.dialog_no,R.id.dialog_all})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.dialog_yes:
                if (listener != null) {
                    listener.positiveMethod();
                }
                dismiss();
                break;
            case R.id.dialog_no:
                dismiss();
                break;
            case R.id.dialog_all:
                dismiss();
                break;
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().post("12","loadDown");
        EventBus.getDefault().unregister(this);
    }


    public interface OnPositiveButtonDialog {
        void positiveMethod();
    }

    private OnPositiveButtonDialog listener;

    public void setOnPositiveDialog(OnPositiveButtonDialog listener) {
        this.listener = listener;
    }

}
