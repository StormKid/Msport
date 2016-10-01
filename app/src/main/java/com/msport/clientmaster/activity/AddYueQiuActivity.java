package com.msport.clientmaster.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.msport.clientmaster.R;
import com.msport.clientmaster.base.BaseActivity;
import com.msport.clientmaster.callback.MainCallback;
import com.msport.clientmaster.constants.Constant;
import com.msport.clientmaster.constants.HttpConstant;
import com.msport.clientmaster.intef.MyViewCallback;
import com.msport.clientmaster.requestbean.AddYueQiuBean;
import com.msport.clientmaster.util.CustomToast;
import com.msport.clientmaster.util.PublicPreferencesUtils;
import com.msport.clientmaster.util.StringUtil;
import com.msport.clientmaster.view.PubulicPopSingleChoicerDialog;
import com.msport.clientmaster.view.PubulicPopTimeDialog;

import org.simple.eventbus.Subscriber;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Response;

/**
 * Created by like on 2016/7/27.
 */

public class AddYueQiuActivity extends BaseActivity implements MyViewCallback {

    @BindView(R.id.detail_title_change)
    LinearLayout detailTitleChange;
    @BindView(R.id.add_title)
    EditText addTitle;
    @BindView(R.id.add_phone)
    EditText addPhone;
    @BindView(R.id.add_member)
    EditText addMember;
    @BindView(R.id.add_introduce)
    TextView addIntroduce;
    @BindView(R.id.add_min_member)
    LinearLayout addMinMember;
    @BindView(R.id.add_max_member)
    LinearLayout addMaxMember;
    @BindView(R.id.add_start_time)
    LinearLayout addStartTime;
    @BindView(R.id.add_end_time)
    LinearLayout addEndTime;
    @BindView(R.id.add_must_know)
    LinearLayout addMustKnow;
    /**
     * 发布约球
     */
    @BindView(R.id.title_right_tv)
    TextView titleRightTv;
    @BindView(R.id.add_min_member_result)
    TextView addMinMemberResult;
    @BindView(R.id.add_max_member_result)
    TextView addMaxMemberResult;
    @BindView(R.id.add_start_time_result)
    TextView addStartTimeResult;
    @BindView(R.id.add_end_time_result)
    TextView addEndTimeResult;
    @BindView(R.id.add_location)
    EditText addLocation;
    @BindView(R.id.textView8)
    TextView textView8;
    @BindView(R.id.add_username)
    EditText addUsername;
    @BindView(R.id.textView6)
    TextView textView6;
    @BindView(R.id.title_up_down)
    ImageView titleUpDown;
    @BindView(R.id.go_to_pay)
    Button goToPay;
    @BindView(R.id.contain_alls)
    LinearLayout containAlls;
    private Context context;
    @BindView(R.id.back_black)
    ImageView back_black;

    @BindView(R.id.share_black)
    ImageView share_black;

    @BindView(R.id.main_title)
    TextView main_title;

    @BindView(R.id.show_yinying)
    View show_yinying;

    private final String checkString = "未选择";

    private Handler handler = new Handler();
    private MainCallback callback;
    private String courseType;
    private int inviteType;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_yueqiu);
        context = this;
        ButterKnife.bind(this);
        callback = new MainCallback(this, this);
        initView();
    }

    private void initView() {
        main_title.setText("创建约球");
        share_black.setVisibility(View.GONE);
        courseType = getIntent().getStringExtra(Constant.COURSE_CHOOSE_TYPE);
        int defalt = 0;
        inviteType = getIntent().getIntExtra(Constant.YUEQIU_BISAI, defalt);
        addMember.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                StringUtil.editPoint(addMember, charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        containAlls.setBackgroundColor(ContextCompat.getColor(context,R.color.white));
    }

    /**
     * 书写后显示或隐藏阴影
     */
    private void isShowY(final boolean tag) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                if (tag) {
                    show_yinying.setVisibility(View.VISIBLE);
                } else {
                    show_yinying.setVisibility(View.GONE);
                }

            }
        });
    }


    @Override
    public void viewMode(Response res, String tag) {
        if (tag.equals(HttpConstant.addYueQiu)) {
            CustomToast.createToast().showSuccess(this, "添加约球成功");
            finish();
        }
    }

    @Override
    public void getFalse(boolean tag, String message) {
        if (tag) {
            CustomToast.createToast().showFaild(this, "添加约球失败，检查网络链接");
        }
    }

    @Override
    public void showCode(int code, String string) {

    }

    @OnClick({R.id.add_min_member, R.id.add_max_member, R.id.add_start_time, R.id.add_end_time, R.id.add_introduce, R.id.add_must_know, R.id.go_to_pay, R.id.back_black})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.add_min_member:
                PubulicPopSingleChoicerDialog dialog = new PubulicPopSingleChoicerDialog(this, Constant.SHOW_MEMBER);
                dialog.show();
                dialog.setBirthdayListener(new PubulicPopSingleChoicerDialog.OnBirthListener() {
                    @Override
                    public void onClick(String value) {
                        addMinMemberResult.setText(value);
                    }
                });
                break;
            case R.id.add_max_member:
                PubulicPopSingleChoicerDialog mdialog = new PubulicPopSingleChoicerDialog(this, Constant.SHOW_MEMBER);
                mdialog.show();
                mdialog.setBirthdayListener(new PubulicPopSingleChoicerDialog.OnBirthListener() {
                    @Override
                    public void onClick(String value) {
                        addMaxMemberResult.setText(value);
                    }
                });
                break;
            case R.id.add_start_time:
                PubulicPopTimeDialog mChangeBirthDialog = new PubulicPopTimeDialog(
                        this);
                mChangeBirthDialog.show();
                mChangeBirthDialog.setBirthdayListener(new PubulicPopTimeDialog.OnBirthListener() {

                    @Override
                    public void onClick(String year, String month, String day, String hour, String min) {
                        addStartTimeResult.setText(year + "." + month + "." + day + " " + hour + ":" + min);
                    }
                });
                break;
            case R.id.add_end_time:
                PubulicPopTimeDialog changeDialog = new PubulicPopTimeDialog(
                        this);
                changeDialog.show();
                changeDialog.setBirthdayListener(new PubulicPopTimeDialog.OnBirthListener() {

                    @Override
                    public void onClick(String year, String month, String day, String hour, String min) {
                        addEndTimeResult.setText(year + "." + month + "." + day + " " + hour + ":" + min);
                    }
                });
                break;
            case R.id.add_must_know:
                Intent intented = new Intent(this,YueQiuAddXieYiActivity.class);
                startActivity(intented);
                break;
            case R.id.go_to_pay:
                AddYueQiuBean bean = new AddYueQiuBean();
                commit(bean);
                break;
            case R.id.back_black:
                finish();
                break;
            case R.id.add_introduce:
                Intent intent = new Intent(this, ActionIntroduceActivity.class);
                startActivity(intent);
                break;
        }
    }

    private void commit(AddYueQiuBean bean) {
        String title = addTitle.getText().toString().trim();
        String phone = addPhone.getText().toString().trim();
        String price = addMember.getText().toString().trim();
        String location = addLocation.getText().toString().trim();
        String introduce = addIntroduce.getText().toString().trim();
        String username = addUsername.getText().toString().trim();
        String minMenber = addMinMemberResult.getText().toString().trim();
        String maxMenber = addMaxMemberResult.getText().toString().trim();
        String startTime = addStartTimeResult.getText().toString().trim();
        String endTime = addEndTimeResult.getText().toString().trim();
        String id = PublicPreferencesUtils.getString(this, Constant.NUTZER_ID);
        if (TextUtils.isEmpty(title)) {
            CustomToast.createToast().showFaild(this, "请输入活动标题");
            return;
        } else if (TextUtils.isEmpty(phone)) {
            CustomToast.createToast().showFaild(this, "请输入电话号码");
            return;
        } else if (TextUtils.isEmpty(location)) {
            CustomToast.createToast().showFaild(this, "请输入活动地址");
            return;
        } else if (TextUtils.isEmpty(price)) {
            CustomToast.createToast().showFaild(this, "请输入活动金额");
            return;
        } else if ("请填写".equals(introduce)) {
            CustomToast.createToast().showFaild(this, "请输入您的活动介绍");
            return;
        } else if (checkString.equals(minMenber)) {
            CustomToast.createToast().showFaild(this, "请选择活动参加最少人数");
            return;
        } else if (checkString.equals(maxMenber)) {
            CustomToast.createToast().showFaild(this, "情选择活动参加最多人数");
        } else if (checkString.equals(startTime)) {
            CustomToast.createToast().showFaild(this, "请输选择您的开始时间");
            return;
        } else if (checkString.equals(endTime)) {
            CustomToast.createToast().showFaild(this, "请选择您的结束时间");
            return;
        } else {
            bean.setFees(price);
            bean.setName(title);
            bean.setActiviComment(introduce);
            bean.setCustomAddress(location);
            bean.setCustomName(username);
            bean.setMinParticipants(minMenber);
            bean.setTotalParticipants(maxMenber);
            bean.setTimeStart(startTime);
            bean.setTimeEnd(endTime);
            bean.setInitiator(id);
            bean.setTelephone(phone);
            bean.setType(courseType);////4或者5为羽毛球与网球的
            bean.setInviteType(inviteType + "");
            callback.addYueQiu(bean);
        }


    }


    @Subscriber(tag = Constant.FINISHED)
    public void getIntroduce(String introduce) {
        addIntroduce.setText(introduce);
        isShowY(false);
    }


}
