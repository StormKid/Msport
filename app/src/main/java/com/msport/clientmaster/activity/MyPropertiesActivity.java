package com.msport.clientmaster.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
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
import com.msport.clientmaster.fragment.OrderButtomFragment;
import com.msport.clientmaster.intef.MyViewCallback;
import com.msport.clientmaster.requestbean.PropertiesRequestBean;
import com.msport.clientmaster.util.CustomToast;
import com.msport.clientmaster.util.ImageUtil;
import com.msport.clientmaster.util.PublicPreferencesUtils;
import com.msport.clientmaster.view.ChangeAddressDialog;
import com.msport.clientmaster.view.ChangeBirthDialog;
import com.msport.clientmaster.view.PubulicPopSingleChoicerDialog;

import org.simple.eventbus.Subscriber;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Response;

/**
 * Created by like on 2016/8/30.
 */

public class MyPropertiesActivity extends BaseActivity implements MyViewCallback {


    private static final String TAG = "camare";
    @BindView(R.id.back_black)
    ImageView backBlack;
    @BindView(R.id.main_title)
    TextView mainTitle;
    @BindView(R.id.title_up_down)
    ImageView titleUpDown;
    @BindView(R.id.share_black)
    ImageView shareBlack;
    @BindView(R.id.title_right_tv)
    TextView titleRightTv;
    @BindView(R.id.detail_title_change)
    LinearLayout detailTitleChange;
    @BindView(R.id.propertie_gender)
    LinearLayout propertieGender;
    @BindView(R.id.propertie_birth)
    LinearLayout propertieBirth;
    @BindView(R.id.prepay_location)
    LinearLayout prepayLocation;
    @BindView(R.id.property_start)
    Button propertyStart;
    @BindView(R.id.nick_name)
    EditText nickName;
    @BindView(R.id.user_gender)
    TextView userGender;
    @BindView(R.id.user_birth)
    TextView userBirth;
    @BindView(R.id.user_address)
    TextView userAddress;
    @BindView(R.id.user_icon)
    ImageView userIcon;
    private MainCallback callback;
    private PropertiesRequestBean propertiesBean;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_properties);
        ButterKnife.bind(this);
        initView();

    }

    private void initView() {
        callback = new MainCallback(this,this);
        shareBlack.setVisibility(View.GONE);
        mainTitle.setText("编辑资料");
        String sexTag = PublicPreferencesUtils.getString(this,
                Constant.NUTZER_SEX);
        if (sexTag.equals("0")) {
            userGender.setText("男");
        } else if (sexTag.equals("1")) {
            userGender.setText("女");
        }
        nickName.setText(PublicPreferencesUtils.getString(this, Constant.NUTZER_NAME));
        userAddress.setText(PublicPreferencesUtils.getString(this, Constant.NUTZER_LOCATION));
        userBirth.setText(PublicPreferencesUtils.getString(this, Constant.NUTZER_BIETHDAY));
    }

    @OnClick({R.id.back_black, R.id.property_start, R.id.propertie_gender, R.id.propertie_birth, R.id.prepay_location,R.id.user_icon})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_black:
                finish();
                break;
            case R.id.property_start:
                propertiesBean = new PropertiesRequestBean();
                String gender = userGender.getText().toString();
                if (gender.equals("男")) {
                    propertiesBean.sex = "0";
                } else {
                    propertiesBean.sex = "1";
                }
                propertiesBean.location = userAddress.getText().toString().trim();
                propertiesBean.age = userBirth.getText().toString().trim();
                propertiesBean.id = PublicPreferencesUtils.getString(this, Constant.NUTZER_ID);
                propertiesBean.name = nickName.getText().toString();
                callback.getRequestProperties(propertiesBean);
                break;
            case R.id.propertie_gender:
                PubulicPopSingleChoicerDialog dialog = new PubulicPopSingleChoicerDialog(this, Constant.PRO_GENDER);
                dialog.setBirthdayListener(new PubulicPopSingleChoicerDialog.OnBirthListener() {
                    @Override
                    public void onClick(String value) {
                        userGender.setText(value);
                    }
                });
                dialog.show();
                break;
            case R.id.propertie_birth:
                ChangeBirthDialog birth = new ChangeBirthDialog(this);
                birth.setBirthdayListener(new ChangeBirthDialog.OnBirthListener() {
                    @Override
                    public void onClick(String year, String month, String day) {
                        userBirth.setText(year + "." + month + "." + day);
                    }
                });
                birth.show();
                break;
            case R.id.prepay_location:
                ChangeAddressDialog dialogLocation = new ChangeAddressDialog(this);
                dialogLocation.setAddress("湖北", "武汉","武昌区");
                dialogLocation.setAddresskListener(new ChangeAddressDialog.OnAddressCListener() {
                    @Override
                    public void onClick(String province, String city) {
                        userAddress.setText(province + city);
                    }
                });
                dialogLocation.show();
                break;
            case R.id.user_icon:
                OrderButtomFragment orderButtomFragment = new OrderButtomFragment(R.layout.my_pop_camareview,null,this);
                orderButtomFragment.show(getSupportFragmentManager(),TAG);
                break;

        }
    }

    @Override
    public void viewMode(Response res, String tag) {
        if (tag.equals(HttpConstant.getUserProperties)) {
            CustomToast.createToast().showSuccess(this, "用户信息填写完成");
            PublicPreferencesUtils.putString(this, Constant.NUTZER_LOCATION, propertiesBean.location);
            PublicPreferencesUtils.putString(this, Constant.NUTZER_BIETHDAY, propertiesBean.age);
            PublicPreferencesUtils.putString(this, Constant.NUTZER_NAME, propertiesBean.name);
            PublicPreferencesUtils.putString(this, Constant.NUTZER_SEX, propertiesBean.sex);
            finish();
        }
    }

    @Override
    public void getFalse(boolean tag, String message) {
        CustomToast.createToast().showFaild(this,"网络连接不上啦，请重新检查网络连接");
    }

    @Override
    public void showCode(int code, String string) {

    }

    @Override
    protected void onResume() {
        super.onResume();
        String url = PublicPreferencesUtils.getString(this, Constant.NUTZER_PHOTOURL);
        ImageUtil.getNetImage(this, url, userIcon);
    }



    @Subscriber(tag = Constant.PHOTO_FINISH+"")
    public void photoFinish(String TAG){
        String url = PublicPreferencesUtils.getString(this, Constant.NUTZER_PHOTOURL);
        ImageUtil.getNetImage(this, url, userIcon);
    }


}
