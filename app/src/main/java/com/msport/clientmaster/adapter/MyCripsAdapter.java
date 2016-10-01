package com.msport.clientmaster.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.msport.clientmaster.R;
import com.msport.clientmaster.entity.CripEntity;
import com.msport.clientmaster.util.StringUtil;
import com.msport.clientmaster.util.TimeUtils;
import com.msport.clientmaster.util.Tools;

import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by like on 2016/8/26.
 */
public class MyCripsAdapter extends BaseAdapter {
    private final Context context;
    private final List<CripEntity.DataBean> data;
    private final Map<String, String> courseType;
    private static View  oldView;

    public MyCripsAdapter(Context context, List<CripEntity.DataBean> data) {
        this.context = context;
        this.data = data;
        courseType = Tools.getCourseType();
    }

    @Override
    public int getCount() {
        return data == null ? 0 : data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_youhuiquan, null);
            holder = new ViewHolder(view);
        } else holder = (ViewHolder) view.getTag();
        final CripEntity.DataBean dataBean = data.get(i);
        String abatement = dataBean.getAbatement();
        String endTime = dataBean.getEndTime();
        String timeDate = TimeUtils.getTimeDate(endTime);
        String name = dataBean.getName();
        String courseTypeKey = dataBean.getCourseType();
        String courseTypeValue = courseType.get(courseTypeKey);
        String[] split = abatement.split("\\.");
        String price = "";
        if (split[1].equals("00")){
            int i1 = StringUtil.multipInt(abatement, "1");
            price = i1+"";
        }else {
            price = StringUtil.multipString(abatement, "1");
        }
        holder.cripsTitle.setText("仅限购买" + courseTypeValue + "课程使用");
        holder.cripsName.setText(name);
        holder.cripsAmount.setText(price+"");
        holder.cripsTime.setText(timeDate + "到期");
        final ImageView imageView = holder.cripsChoose;
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener !=null){
                    listener.onChoose(dataBean,i);
                }
                if (oldView ==null){
                    imageView.setVisibility(View.VISIBLE);
                    oldView = imageView;
                }else {
                    oldView.setVisibility(View.GONE);
                    imageView.setVisibility(View.VISIBLE);
                    oldView = imageView;
                }
            }
        });
        return view;
    }


    static class ViewHolder {
        @BindView(R.id.crips_title)
        TextView cripsTitle;
        @BindView(R.id.crips_name)
        TextView cripsName;
        @BindView(R.id.crips_time)
        TextView cripsTime;
        @BindView(R.id.crips_amount)
        TextView cripsAmount;
        @BindView(R.id.crips_choose)
        ImageView cripsChoose;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
            view.setTag(this);
        }
    }


    public interface OnChooseMyCripsListener{
        void  onChoose(CripEntity.DataBean bean , int position);
    }

    private OnChooseMyCripsListener listener ;

    public void setOnChooseMyCripsListener(OnChooseMyCripsListener listener){
        this.listener = listener;
    }


}
