package com.msport.clientmaster.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.msport.clientmaster.R;
import com.msport.clientmaster.entity.MyMessageEntity;
import com.msport.clientmaster.util.TimeUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by like on 2016/8/16.
 */
public class MyMessageAdapter extends BaseAdapter {
    private Context context;
    private List<MyMessageEntity.DataBean> data;

    public MyMessageAdapter(Context context, List<MyMessageEntity.DataBean> data) {
        this.context = context;
        this.data = data;
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
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_mesaage_list, null);
            holder = new ViewHolder(view);
        }else holder = (ViewHolder) view.getTag();

        MyMessageEntity.DataBean dataBean = data.get(i);
        String createTime = dataBean.getCreateTime();
        String title = dataBean.getTitle();
        String type = dataBean.getType();
        if ("1".equals(type)){
            holder.itemMassageImg.setImageResource(R.mipmap.xitong_massage);
            holder.itemMassageTitle.setText("系统通知");
        }else{
            holder.itemMassageImg.setImageResource(R.mipmap.activity_massage);
            holder.itemMassageTitle.setText("活动通知");
        }
        holder.itemMassageContent.setText(title);
        String timeDate = TimeUtils.getTimeDate(createTime);
        holder.itemMassageTime.setText(timeDate);
        return view;
    }

    static class ViewHolder {
        @BindView(R.id.item_massage_img)
        ImageView itemMassageImg;
        @BindView(R.id.item_massage_title)
        TextView itemMassageTitle;
        @BindView(R.id.item_massage_content)
        TextView itemMassageContent;
        @BindView(R.id.item_massage_time)
        TextView itemMassageTime;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
            view.setTag(this);
        }
    }
}
