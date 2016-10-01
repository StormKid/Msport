package com.msport.clientmaster.callback;

import android.content.Context;

import com.msport.clientmaster.intef.MyViewCallback;
import com.msport.clientmaster.util.LogUtils;
import com.msport.clientmaster.view.MProgressDialog;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 自己封装的retrofit callback
 * Created by like on 2016/7/9.
 */

public class BaseCallback implements Callback{

    MyViewCallback myViewCallback;
    private String type;
    private MProgressDialog progressDialog;

    public BaseCallback(MyViewCallback myViewCallback, String type, Context context){
      this(myViewCallback,type,context, true);
    }

    public BaseCallback(MyViewCallback myViewCallback, String type, Context context, boolean showDialog){
        this.myViewCallback = myViewCallback;
        this.type = type;
        if (showDialog){
            progressDialog = new MProgressDialog(context);
            progressDialog.show();
        }
    }

    @Override
    public void onResponse(Call call, Response response) {
        if (progressDialog!=null)
        progressDialog.dismiss();
       final int code = response.code();
        okhttp3.Response raw = response.raw();
        String rawString = raw.toString();
        LogUtils.e("url",rawString);
        if (myViewCallback!=null){
            if (response.isSuccessful()) {
                myViewCallback.viewMode(response, type);
            }else {
                String string = "";
                try {
                    string = response.errorBody().string();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                myViewCallback.showCode(code,string);
            }
        }

    }

    @Override
    public void onFailure(Call call, Throwable t) {
        if (progressDialog!=null)
        progressDialog.dismiss();
        myViewCallback.getFalse(true,type);

    }
}
