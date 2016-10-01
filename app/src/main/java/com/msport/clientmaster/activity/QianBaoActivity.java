package com.msport.clientmaster.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.msport.clientmaster.R;
import com.msport.clientmaster.base.BaseActivity;
import com.msport.clientmaster.callback.MainCallback;
import com.msport.clientmaster.constants.Constant;
import com.msport.clientmaster.constants.HttpConstant;
import com.msport.clientmaster.entity.QianBaoEntity;
import com.msport.clientmaster.intef.MyViewCallback;
import com.msport.clientmaster.util.CustomToast;
import com.msport.clientmaster.util.PublicPreferencesUtils;
import com.msport.clientmaster.util.ViewUtil;
import com.msport.clientmaster.view.TwoButtomDialog;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Response;

/**
 * Created by like on 2016/8/15.
 */

public class QianBaoActivity extends BaseActivity implements MyViewCallback {


    @BindView(R.id.qianbao_back)
    ImageView qianbaoBack;
    @BindView(R.id.qianbao_agree)
    ImageView qianbaoAgree;
    @BindView(R.id.qianbao_money)
    TextView qianbaoMoney;
    @BindView(R.id.qianbao_xiaofei)
    TextView qianbaoXiaofei;
    @BindView(R.id.qianbao_detail)
    ViewGroup qianbaoDetail;
    @BindView(R.id.qianbao_chongzhi)
    LinearLayout qianbaoChongzhi;
    @BindView(R.id.qianbao_tixian)
    LinearLayout qianbaoTixian;
    @BindView(R.id.refresh_layout)
    SwipeRefreshLayout refreshLayout;
    private MainCallback callback;
    private Context context;
    private boolean isBind;
    private String balance;
    private String walletId;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qianbao);
        ButterKnife.bind(this);
        callback = new MainCallback(this, this);
        final String menberId = PublicPreferencesUtils.getString(this, Constant.NUTZER_ID);
        context = this;
        callback.getQianbao(menberId, context, true);
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                callback.getQianbao(menberId, context,false);
            }
        });
        refreshLayout.setColorSchemeColors(ContextCompat.getColor(context,R.color.bg_orange));
    }

    @OnClick({R.id.qianbao_back, R.id.qianbao_agree, R.id.qianbao_xiaofei, R.id.qianbao_detail, R.id.qianbao_chongzhi, R.id.qianbao_tixian})
    public void onClick(View view) {
        final Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.qianbao_back:
                finish();
                break;
            case R.id.qianbao_agree:

                break;
            case R.id.qianbao_xiaofei:

                break;
            case R.id.qianbao_detail:
                intent.setClass(context, QianBaoListActivity.class);
                startActivity(intent);
                break;
            case R.id.qianbao_chongzhi:
                intent.setClass(context, QianBaoRealdoActivity.class);
                intent.putExtra(Constant.QIANBAO_TYPE, "1");
                startActivity(intent);

                break;
            case R.id.qianbao_tixian:
                if (isBind) {
                    intent.setClass(context, QianBaoRealdoActivity.class);
                    intent.putExtra(Constant.QIANBAO_TYPE, "2");
                    intent.putExtra("qian", balance);
                    startActivity(intent);
                } else {
                    ViewUtil.createTwoDialog(context, "是否绑定钱包", "确定", new TwoButtomDialog.OnPositiveButtonDialog() {
                        @Override
                        public void positiveMethod() {
                            intent.setClass(context, BindListAcitivity.class);
                            intent.putExtra("walletId",walletId);
                            startActivity(intent);
                        }
                    }, true);

                }
                break;
        }
    }

    @Override
    public void viewMode(Response res, String tag) {

        if (HttpConstant.getQIANBAO.equals(tag)) {
            QianBaoEntity entity = (QianBaoEntity) res.body();
            if (entity.getCode().equals("-39")) {
                CustomToast.createToast().showFaild(this, "您的钱包已冻结，请联系客服");
                return;
            }
            QianBaoEntity.DataBean data = entity.getData();
            balance = data.getBalance();
            walletId = data.getId();
            if (null != data.getAccount() && !TextUtils.isEmpty(data.getAccount()))
                isBind = true;
            qianbaoMoney.setText(balance);
        }
        refreshLayout.setRefreshing(false);

    }

    @Override
    public void getFalse(boolean tag, String message) {

        if (message.equals(HttpConstant.getQIANBAO)) {
            CustomToast.createToast().showFaild(this, "钱包获取失败，请重新检查网络链接");
        }
        refreshLayout.setRefreshing(false);
    }

    @Override
    public void showCode(int code, String string) {

    }
}
