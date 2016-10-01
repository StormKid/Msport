package com.msport.clientmaster.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.msport.clientmaster.R;
import com.msport.clientmaster.activity.LoginActivity;
import com.msport.clientmaster.callback.MainCallback;
import com.msport.clientmaster.constants.Constant;
import com.msport.clientmaster.constants.HttpConstant;
import com.msport.clientmaster.entity.BaseEntity;
import com.msport.clientmaster.entity.CripEntity;
import com.msport.clientmaster.intef.MyViewCallback;
import com.msport.clientmaster.util.CustomToast;
import com.msport.clientmaster.util.PublicPreferencesUtils;
import com.msport.clientmaster.util.StringUtil;
import com.msport.clientmaster.util.TimeUtils;
import com.msport.clientmaster.util.Tools;
import com.msport.clientmaster.util.ViewUtil;
import com.msport.clientmaster.view.TwoButtomDialog;
import com.msport.clientmaster.view.YouhuiquanDialog;

import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Response;

/**
 * Created by like on 2016/8/24.
 */

public class CripsAdapter extends BaseAdapter implements MyViewCallback {

    private Context context;
    private List<CripEntity.DataBean> list;
    private final Map<String, String> map;
    private String name;
    private String coursetype;
    private final MainCallback calbal;

    public CripsAdapter(Context context, List<CripEntity.DataBean> list) {
        this.context = context;
        this.list = list;
        map = Tools.getCourseType();
        calbal = new MainCallback(this,context);
    }

    @Override
    public int getCount() {
        return list == null ? 1 : list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_youhuiquan_list, null);
            holder = new ViewHolder(view);
        }else holder = (ViewHolder) view.getTag();
        CripEntity.DataBean dataBean = list.get(i);
        name = dataBean.getName();
        String endTime = TimeUtils.getTimeDate(dataBean.getEndTime())+"到期";
        final int canGet = StringUtil.multipInt(dataBean.getCondi(),"1");
        final String id = dataBean.getId();
        int abatement = StringUtil.multipInt(dataBean.getAbatement(),"1");
        String courseType = dataBean.getCourseType();
        coursetype = map.get(courseType);
        holder.youhuiquanAmount.setText(abatement+"");
        holder.youhuiquanTiaojian.setText("满"+canGet+"元可用");
        holder.youhuiquanTitle.setText(name);
        holder.youhuiquanContent.setText("仅限购买"+coursetype+"课程使用");
        holder.youhuiquanTime.setText(endTime);
        holder.youhuiquanTime.setText(endTime);
        holder.youhuiquanGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkMember(context,id);
            }
        });
        return view;
    }

    @Override
    public void viewMode(Response res, String tag) {
        if (tag.equals(HttpConstant.hadCrips)){
            BaseEntity entity = (BaseEntity) res.body();
            switch (entity.getCode()){
                case "-50":
                    CustomToast.createToast().showFaild(context,"您已领取优惠券");
                    return;
                case "-49":
                    CustomToast.createToast().showFaild(context,"优惠券已发完");
                    return;
            }
            YouhuiquanDialog dialog = new YouhuiquanDialog(context,name,coursetype);
            dialog.show();
        }


    }

    @Override
    public void getFalse(boolean tag, String message) {
            if (message.equals(HttpConstant.hadCrips)){
                CustomToast.createToast().showFaild(context,"获取优惠券失败啦");
            }
    }

    @Override
    public void showCode(int code, String string) {

    }

    static class ViewHolder {
        @BindView(R.id.youhuiquan_amount)
        TextView youhuiquanAmount;
        @BindView(R.id.youhuiquan_tiaojian)
        TextView youhuiquanTiaojian;
        @BindView(R.id.youhuiquan_title)
        TextView youhuiquanTitle;
        @BindView(R.id.youhuiquan_content)
        TextView youhuiquanContent;
        @BindView(R.id.youhuiquan_time)
        TextView youhuiquanTime;
        @BindView(R.id.youhuiquan_get)
        TextView youhuiquanGet;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
            view.setTag(this);
        }
    }

    protected void  checkMember(final Context context,String id){
        boolean userFirst = PublicPreferencesUtils.getBoolean(context, Constant.USER_FIRST);
        if (userFirst){// true 为登陆了，false为未登陆
            String memberId = PublicPreferencesUtils.getString(context, Constant.NUTZER_ID);
            calbal.hadCrips(memberId,id);
        }else {
            ViewUtil.createTwoDialog(context, "您还尚未登陆，是否登陆", "确定", new TwoButtomDialog.OnPositiveButtonDialog() {
                @Override
                public void positiveMethod() {
                    Intent intent = new Intent();
                    intent.setClass(context, LoginActivity.class);
                    context.startActivity(intent);
                }
            }, true);

        }
    }
}
