package com.msport.clientmaster.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.msport.clientmaster.R;
import com.msport.clientmaster.base.BaseActivity;
import com.msport.clientmaster.callback.MainCallback;
import com.msport.clientmaster.constants.Constant;
import com.msport.clientmaster.constants.HttpConstant;
import com.msport.clientmaster.entity.MenPiaoDetailEntity;
import com.msport.clientmaster.intef.MyViewCallback;
import com.msport.clientmaster.util.CustomToast;
import com.msport.clientmaster.util.ImageUtil;
import com.msport.clientmaster.util.StringUtil;
import com.msport.clientmaster.view.HomeScrollView;
import com.msport.clientmaster.view.JustifyTextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Response;

/**
 * Created by like on 2016/8/22.
 */

public class MenPiaoDetailActivity extends BaseActivity implements MyViewCallback {

    @BindView(R.id.bisai_menpiao_detail_img)
    ImageView bisaiMenpiaoDetailImg;
    @BindView(R.id.menpiao_detail_title)
    RelativeLayout menpiaoDetailTitle;
    @BindView(R.id.menpiao_detail_title_no_scr)
    RelativeLayout menpiaoDetailTitleNoScr;
    @BindView(R.id.textView4)
    TextView textView4;
    @BindView(R.id.bisai_menpiao_detail_locaition)
    TextView bisaiMenpiaoDetailLocaition;
    @BindView(R.id.bisai_menpiao_detail_address)
    TextView bisaiMenpiaoDetailAddress;
    @BindView(R.id.bisai_menpiao_detail_cellphone)
    LinearLayout bisaiMenpiaoDetailCellphone;
    @BindView(R.id.textView)
    TextView textView;
    @BindView(R.id.menpiao_detail_name)
    TextView menpiaoDetailName;
    @BindView(R.id.menpiao_detail_cishu)
    TextView menpiaoDetailCishu;
    @BindView(R.id.menpiao_detail_fee)
    TextView menpiaoDetailFee;
    @BindView(R.id.bisai_menpiao_detail_notice)
    JustifyTextView bisaiMenpiaoDetailNotice;
    @BindView(R.id.menpiao_detail_scroll_view)
    HomeScrollView menpiaoDetailScrollView;
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
    @BindView(R.id.go_to_pay)
    Button goToPay;
    @BindView(R.id.menpiao_detail_adress)
    ViewGroup menpiao_detail_adress;
    @BindView(R.id.menpiao_detail_phonenum)
    TextView menpiaoDetailPhonenum;
    private MainCallback callback;
    private String menpId;
    private String amount;
    private String address;
    private String location;
    private String telephone;
    private MenPiaoDetailEntity.DataBean data;
    private String name;
    private String realImgUrl;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitvity_menpiao_detail);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        detailTitleChange.setBackgroundColor(ContextCompat.getColor(this,R.color.white));
        String tickId = getIntent().getStringExtra(Constant.MENPIAO_ID);
        shareBlack.setVisibility(View.GONE);
        callback = new MainCallback(this,this);
        callback.getMenPiaoDetail(tickId);
        address = getIntent().getStringExtra("address");
        location = getIntent().getStringExtra("location");
        telephone = getIntent().getStringExtra("telephone");
        menpiaoDetailScrollView.setBackgroundColor(ContextCompat.getColor(this,R.color.white));
        mainTitle.setText("门票详情");
        shareBlack.setVisibility(View.GONE);

    }

    @OnClick({ R.id.bisai_menpiao_detail_cellphone, R.id.back_black, R.id.go_to_pay, R.id.menpiao_detail_adress})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_black:
                finish();
                break;
            case R.id.bisai_menpiao_detail_cellphone:
                break;
            case R.id.go_to_pay:
                checkMember(this);
                break;
            case R.id.menpiao_detail_adress:
                break;
        }
    }


    @Override
    protected void Do() {
        super.Do();
        Intent intent  = new Intent(this,PrepayActivity.class);
        intent.putExtra(Constant.PROPAY_TYPE,"4");
        intent.putExtra(Constant.MENPIAO_ID,menpId);
        intent.putExtra(Constant.PRICE,amount);
        intent.putExtra("address",location);
        intent.putExtra("name",name);
        intent.putExtra("imageUrl",realImgUrl);
        startActivity(intent);
    }

    @Override
    public void viewMode(Response res, String tag) {
        if (tag.equals(HttpConstant.getMenpiaoDetail)) {
            MenPiaoDetailEntity entity = (MenPiaoDetailEntity) res.body();
            data = entity.getData();
            name = data.getName();
            String unit = data.getUnit();
            String image = data.getImage();
            String source = data.getSource();
            String comment = data.getComment();
            menpId = data.getId();
            realImgUrl = StringUtil.getRealImgUrl(image);
            ImageUtil.getNetImage(this, realImgUrl, bisaiMenpiaoDetailImg, R.mipmap.menpiao_detail);
            bisaiMenpiaoDetailAddress.setText(address);
            bisaiMenpiaoDetailLocaition.setText(location);
            menpiaoDetailPhonenum.setText(telephone);
            amount = data.getAmount();
            mainTitle.setText(name);
            menpiaoDetailFee.setText("¥"+ amount);
            menpiaoDetailCishu.setText(unit);
            menpiaoDetailName.setText(name);
            bisaiMenpiaoDetailNotice.setText(comment);


        }


    }

    @Override
    public void getFalse(boolean tag, String message) {

        CustomToast.createToast().showFaild(this,"门票获取失败啦");

    }

    @Override
    public void showCode(int code, String string) {

    }
}
