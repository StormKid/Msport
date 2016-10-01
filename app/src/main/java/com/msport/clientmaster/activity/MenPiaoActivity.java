package com.msport.clientmaster.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.msport.clientmaster.R;
import com.msport.clientmaster.adapter.MenPiaoAdapter;
import com.msport.clientmaster.base.BaseActivity;
import com.msport.clientmaster.callback.MainCallback;
import com.msport.clientmaster.callback.MyOnScrollYListener;
import com.msport.clientmaster.constants.Constant;
import com.msport.clientmaster.constants.HttpConstant;
import com.msport.clientmaster.entity.CourseTypeEntity;
import com.msport.clientmaster.entity.MenPiaoEntity;
import com.msport.clientmaster.fragment.FragmentDialog;
import com.msport.clientmaster.intef.MyViewCallback;
import com.msport.clientmaster.requestbean.MenPiaoAddressRequestBean;
import com.msport.clientmaster.util.CustomToast;
import com.msport.clientmaster.util.StringUtil;
import com.msport.clientmaster.view.HomeScrollView;
import com.msport.clientmaster.view.InnerListView;

import org.simple.eventbus.Subscriber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Response;

/**
 * Created by like on 2016/8/22.
 */

public class MenPiaoActivity extends BaseActivity implements MyViewCallback {

    @BindView(R.id.menpiao_image)
    ImageView menpiaoImage;
    @BindView(R.id.back_white)
    ImageView backWhite;
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
    @BindView(R.id.men_piao_container)
    InnerListView menPiaoContainer;
    @BindView(R.id.menpiao_scorll)
    HomeScrollView menpiaoScorll;
    @BindView(R.id.xiangmu_choose)
    LinearLayout xiangmuChoose;
    @BindView(R.id.didian_choose)
    LinearLayout didianChoose;
    @BindView(R.id.paixu_choose)
    LinearLayout paixuChoose;
    @BindView(R.id.shaixuan_choose)
    LinearLayout shaixuanChoose;
    @BindView(R.id.hint_show)
    View hint_show;

    private final String XIANGMU_POP = "XIANGMU_POP";
    private final String DIDIAN_POP = "DIDIAN_POP";
    private final String SHAIXUAN_POP = "SHAIXUAN_POP";
    private final String PAIXU_POP = "PAIXU_POP";
    @BindView(R.id.menpiao_contain)
    RelativeLayout menpiaoContain;
    @BindView(R.id.buttom_popcontain)
    LinearLayout buttomPopcontain;
    @BindView(R.id.refresh_layout)
    SwipeRefreshLayout refreshLayout;

    private boolean isLoadMore;

    private FragmentDialog dialog;
    private Map<CourseTypeEntity.DataBean, List<CourseTypeEntity.DataBean>> listTreeMap;
    private int tagY;
    private int changeY;
    private MainCallback callback;
    private MenPiaoAddressRequestBean menpiaoBean = new MenPiaoAddressRequestBean();
    private List<MenPiaoEntity.DataBean> datas = new ArrayList<>();
    private MenPiaoAdapter adapter;
    private String totalIndex = "1";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menpiao);
        ButterKnife.bind(this);
        initView();
        callback.getCourseType("-1",false);
        detailTitleChange.setBackgroundColor(ContextCompat.getColor(this,R.color.white));
    }

    private void initView() {
        tagY = menpiaoContain.getHeight();
        changeY = menpiaoContain.getHeight();
        detailTitleChange.getBackground().setAlpha(0);
        detailTitleChange.setAlpha(0);
        menpiaoScorll.setOnScrollYListener(new MyOnScrollYListener(detailTitleChange, this, tagY, changeY));
        callback = new MainCallback(this, this);
        String maxPrice = getIntent().getStringExtra(Constant.MAX_PRICE);
        String minPrice = getIntent().getStringExtra(Constant.MIN_PRICE);
        if (!TextUtils.isEmpty(maxPrice)||!TextUtils.isEmpty(minPrice)){
            menpiaoBean.highestPrice = maxPrice;
            menpiaoBean.lowestPrice = minPrice;
        }
        callback.queryMenpiaoList("1", menpiaoBean, true);
        shareBlack.setVisibility(View.GONE);
        mainTitle.setText("门票");
        refreshLayout.setColorSchemeResources(R.color.bg_orange);
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                isLoadMore = false;
                totalIndex = "1";
                callback.queryMenpiaoList("1", menpiaoBean, false);
            }
        });
        menpiaoScorll.setOnLoadMoreListener(new HomeScrollView.onLoadMoreListener() {
            @Override
            public void loadMore() {
                isLoadMore = true;
                totalIndex= StringUtil.addString(totalIndex,"1");
                callback.queryMenpiaoList(totalIndex,menpiaoBean,true);
            }
        });
        menpiaoScorll.setBackgroundColor(ContextCompat.getColor(this,R.color.white));

    }

    @OnClick({R.id.back_white, R.id.back_black, R.id.xiangmu_choose, R.id.didian_choose, R.id.paixu_choose, R.id.shaixuan_choose})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_white:
            case R.id.back_black:
                finish();
                break;
            case R.id.xiangmu_choose:
                createPopView(R.layout.dialog_xiangmu, xiangmuChoose, XIANGMU_POP, listTreeMap);
                break;
            case R.id.didian_choose:
                createPopView(R.layout.dialog_didian, didianChoose, DIDIAN_POP, null);
                break;
            case R.id.paixu_choose:
                createPopView(R.layout.dialog_paixu, paixuChoose, PAIXU_POP, null);
                break;
            case R.id.shaixuan_choose:
                createPopView(R.layout.dialog_shaixuan, shaixuanChoose, SHAIXUAN_POP, null);
                break;
        }
    }


    private void createPopView(int layout, final ViewGroup viewGroup, String TAG, Map<CourseTypeEntity.DataBean, List<CourseTypeEntity.DataBean>> listTreeMap) {
        dialog = new FragmentDialog(buttomPopcontain.getHeight(), layout, Constant.MENPIAO_LIST, menpiaoBean, listTreeMap,this);
        dialog.show(this.getSupportFragmentManager(), TAG);
        dialog.setOnDialogStateListener(new FragmentDialog.onDialogStateListener() {
            @Override
            public void getDialogState(boolean tag) {
                if (tag) {
                    hint_show.setVisibility(View.VISIBLE);
                    changeBackGround(viewGroup);
                } else {
                    hint_show.setVisibility(View.GONE);
                    changeBackGround(null);
                }
            }
        });
    }

    private void changeBackGround(ViewGroup viewGroup) {
        xiangmuChoose.setBackgroundColor(ContextCompat.getColor(this, R.color.bg_black_E54));
        didianChoose.setBackgroundColor(ContextCompat.getColor(this, R.color.bg_black_E54));
        paixuChoose.setBackgroundColor(ContextCompat.getColor(this, R.color.bg_black_E54));
        shaixuanChoose.setBackgroundColor(ContextCompat.getColor(this, R.color.bg_black_E54));
        if (viewGroup != null) {
            viewGroup.setBackgroundColor(ContextCompat.getColor(this, R.color.bg_black_D42));
        }
    }


    @Override
    public void viewMode(Response res, String tag) {
        if (HttpConstant.queryMenPiao.equals(tag)) {
            MenPiaoEntity entity = (MenPiaoEntity) res.body();
            List<MenPiaoEntity.DataBean> data = entity.getData();
            if (isLoadMore){
                if (datas.size()== Integer.parseInt(entity.getCount())){
                    CustomToast.createToast().showFaild(this,"已经加载到最后");
                    totalIndex = StringUtil.musString(totalIndex,"1");
                    return;
                }else{
                    datas.addAll(data);
                    adapter.loadMore(datas);
                }
            }else {
                if (null!=data||datas.size()>0)
                    datas.clear();
                datas = data;
                adapter = new MenPiaoAdapter(this, datas);
            }
            menPiaoContainer.setAdapter(adapter);
            refreshLayout.setRefreshing(false);

        } else if (HttpConstant.getCourseType.equals(tag)) {
            xiangmuChoose.setClickable(true);
            CourseTypeEntity entity = (CourseTypeEntity) res.body();
            List<CourseTypeEntity.DataBean> data = entity.getData();
            listTreeMap = new HashMap<>();
            List<CourseTypeEntity.DataBean> parent = new ArrayList<>();
            List<CourseTypeEntity.DataBean> child = new ArrayList<>();
            for (CourseTypeEntity.DataBean bean : data
                    ) {
                if (bean.getParentId().equals("0")) {
                    parent.add(bean);
                } else {
                    child.add(bean);
                }

            }
            for (CourseTypeEntity.DataBean bean : parent) {
                List<CourseTypeEntity.DataBean> children = new ArrayList<>();
                for (CourseTypeEntity.DataBean value : child) {
                    if (bean.getId().equals(value.getParentId())) {
                        children.add(value);
                    }
                }
                listTreeMap.put(bean, children);

            }
        }

    }

    @Override
    public void getFalse(boolean tag, String message) {
        if (message.equals(HttpConstant.queryMenPiao)) {
            CustomToast.createToast().showFaild(this, "门票列表查不到啦，请重新刷新");
        } else {
            xiangmuChoose.setClickable(false);
        }
        refreshLayout.setRefreshing(false);
    }

    @Override
    public void showCode(int code, String string) {

    }


    @Subscriber(tag = Constant.MENPIAO_LIST)
    public void getMenp(MenPiaoAddressRequestBean bean) {
        isLoadMore = false;
        totalIndex = "1";
        callback.queryMenpiaoList("1", bean,true);
    }

}
