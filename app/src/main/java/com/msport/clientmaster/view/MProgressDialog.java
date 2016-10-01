package com.msport.clientmaster.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

import com.msport.clientmaster.R;

/**
 * Created by like on 2016/8/24.
 */

public class MProgressDialog extends Dialog {

    public MProgressDialog(Context context) {
        super(context, R.style.trans_dialog);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.progress_dialog);
        setCanceledOnTouchOutside(false);
    }
}
