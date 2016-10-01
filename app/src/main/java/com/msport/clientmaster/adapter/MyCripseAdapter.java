package com.msport.clientmaster.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.msport.clientmaster.R;
import com.msport.clientmaster.entity.MyCripsEntity;
import com.msport.clientmaster.util.StringUtil;
import com.msport.clientmaster.util.TimeUtils;
import com.msport.clientmaster.util.Tools;

import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by like on 2016/8/25.
 */
public class MyCripseAdapter extends RecyclerView.Adapter<MyCripseAdapter.MycripViewHolder> {

    private List<MyCripsEntity.DataBean.CouponBean> coupon;
    private Context myCripsActivity;
    private final Map<String, String> courseType;

    public MyCripseAdapter(List<MyCripsEntity.DataBean.CouponBean> coupon, Context myCripsActivity) {
        this.coupon = coupon;
        this.myCripsActivity = myCripsActivity;
        courseType = Tools.getCourseType();
    }

    @Override
    public MycripViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(myCripsActivity).inflate(R.layout.item_youhuiquan, null);
        MycripViewHolder holder = new MycripViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MycripViewHolder holder, int position) {

        MyCripsEntity.DataBean.CouponBean couponBean = coupon.get(position);
        String name = couponBean.getName();
        String type = couponBean.getCourseType();
        String typeName = "仅限购买"+courseType.get(type)+"课程使用";
        String endTime = couponBean.getEndTime();
        String timeDate = TimeUtils.getTimeDate(endTime)+"到期";
        String abatement = couponBean.getAbatement();
        int amount = StringUtil.multipInt(abatement, "1");
        holder.cripsName.setText(name);
        holder.cripsTime.setText(timeDate);
        holder.cripsTitle.setText(typeName);
        holder.cripsAmount.setText(amount+"");

    }

    @Override
    public int getItemCount() {
        return coupon==null?0:coupon.size();
    }


    class MycripViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.crips_title)
        TextView cripsTitle;
        @BindView(R.id.crips_name)
        TextView cripsName;
        @BindView(R.id.crips_time)
        TextView cripsTime;
        @BindView(R.id.crips_amount)
        TextView cripsAmount;
        public MycripViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }


}
