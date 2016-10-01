package com.msport.clientmaster.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;

import com.msport.clientmaster.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by like on 2016/8/24.
 */

public class YouhuiquanDialog extends Dialog {

    @BindView(R.id.youhuiquan_get_name)
    TextView youhuiquanGetName;
    @BindView(R.id.youhuiquan_name)
    TextView youhuiquanName;
    @BindView(R.id.learned)
    TextView learned;
    private Context context;
    private String name;
    private String getName;

    public YouhuiquanDialog(Context context, String name, String getName ) {
        super(context,R.style.no_trans_dialog);
        this.context = context;
        this.name = name;
        this.getName = getName;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_choose_youhuiquan);
        ButterKnife.bind(this);
        youhuiquanName.setText(name);
        youhuiquanGetName.setText("获得"+getName+"优惠券");
    }


    @OnClick({R.id.learned})
    public void onClick(){
        dismiss();
    }
}
