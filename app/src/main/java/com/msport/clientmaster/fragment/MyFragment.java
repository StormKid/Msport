package com.msport.clientmaster.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.msport.clientmaster.R;
import com.msport.clientmaster.activity.FankuiYijianActivity;
import com.msport.clientmaster.activity.LoginActivity;
import com.msport.clientmaster.activity.MyActivityActivity;
import com.msport.clientmaster.activity.MyCripsActivity;
import com.msport.clientmaster.activity.MyMessageActivity;
import com.msport.clientmaster.activity.MyPropertiesActivity;
import com.msport.clientmaster.activity.MyReviewListActivity;
import com.msport.clientmaster.activity.OrderListActivity;
import com.msport.clientmaster.activity.QianBaoActivity;
import com.msport.clientmaster.activity.SettingActivity;
import com.msport.clientmaster.constants.Constant;
import com.msport.clientmaster.util.ImageUtil;
import com.msport.clientmaster.util.PublicPreferencesUtils;
import com.msport.clientmaster.util.Tools;
import com.msport.clientmaster.view.CircleImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 我的页面
 * Created by like on 2016/7/19.
 */
@SuppressLint("ValidFragment")
public class MyFragment extends Fragment {

    @BindView(R.id.my_img)
    CircleImageView myImg;
    @BindView(R.id.my_name)
    TextView myName;
    @BindView(R.id.my_telephone)
    TextView myTelephone;
    @BindView(R.id.my_message)
    ImageView myMessage;
    @BindView(R.id.my_properties)
    ImageView myProperties;
    @BindView(R.id.my_order)
    LinearLayout myOrder;
    @BindView(R.id.my_bag)
    LinearLayout myBag;
    @BindView(R.id.my_crips)
    LinearLayout myCrips;
    @BindView(R.id.my_activity)
    LinearLayout myActivity;
    @BindView(R.id.my_review)
    LinearLayout myReview;
    @BindView(R.id.imageView2)
    ImageView imageView2;
    @BindView(R.id.my_fankui)
    LinearLayout myFankui;
    @BindView(R.id.imageView3)
    ImageView imageView3;
    @BindView(R.id.my_setting)
    LinearLayout mySetting;
    @BindView(R.id.my_login_to)
    ViewGroup my_login_to;
    @BindView(R.id.contain_alls)
    LinearLayout containAlls;


    private Context context;
    private boolean isLogin;

    public MyFragment(Context context) {
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(context).inflate(R.layout.fragment_my, null);
        ButterKnife.bind(this, view);
        containAlls.setBackgroundColor(ContextCompat.getColor(context,R.color.white));
        return view;
    }

    @OnClick({R.id.my_message, R.id.my_properties, R.id.my_order, R.id.my_bag, R.id.my_crips, R.id.my_activity, R.id.my_review, R.id.my_fankui, R.id.my_setting, R.id.my_login_to, R.id.my_img})
    public void onClick(View view) {
        final Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.my_message:
                intent.setClass(context, MyMessageActivity.class);
                startActivity(intent);
                break;
            case R.id.my_properties:
                Tools.checkMember(context, MyPropertiesActivity.class);
                break;
            case R.id.my_order:
                Tools.checkMember(context, OrderListActivity.class);
                break;
            case R.id.my_bag:
                Tools.checkMember(context, QianBaoActivity.class);
                break;
            case R.id.my_crips:
                Tools.checkMember(context, MyCripsActivity.class);
                break;
            case R.id.my_activity:
                Tools.checkMember(context, MyActivityActivity.class);
                break;
            case R.id.my_review:
                Tools.checkMember(context, MyReviewListActivity.class);
                break;
            case R.id.my_fankui:
                Tools.checkMember(context, FankuiYijianActivity.class);
                break;
            case R.id.my_setting:
                intent.setClass(context, SettingActivity.class);
                startActivity(intent);
                break;
            case R.id.my_img:
            case R.id.my_login_to:
                boolean userFirst = PublicPreferencesUtils.getBoolean(context, Constant.USER_FIRST);
                if (userFirst) {
                    break;
                } else {
                    intent.setClass(context, LoginActivity.class);
                    startActivity(intent);
                    break;
                }
        }
    }



    @Override
    public void onResume() {
        super.onResume();
        isLogin = PublicPreferencesUtils.getBoolean(context,
                Constant.USER_FIRST);
        String url = PublicPreferencesUtils.getString(context,
                Constant.NUTZER_PHOTOURL);
        ImageUtil.getNetImage(context, url, myImg);
        String name = PublicPreferencesUtils.getString(context,
                Constant.NUTZER_NAME);
        String telephone = PublicPreferencesUtils.getString(context, Constant.NUTZER_TELEPHONE);
        if (isLogin) {
            myName.setText(name);
            myTelephone.setVisibility(View.VISIBLE);
            myTelephone.setText("手机："+telephone);
        } else {
            myName.setText("请登陆");
            myTelephone.setVisibility(View.GONE);
        }
    }
}
