package com.msport.clientmaster.adapter;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.msport.clientmaster.R;
import com.msport.clientmaster.activity.YueQiuDetailActivity;
import com.msport.clientmaster.bean.YueQiuBean;
import com.msport.clientmaster.constants.Constant;
import com.msport.clientmaster.util.LogUtils;
import com.msport.clientmaster.util.ViewUtil;

import java.util.List;

/**
 * 控制约球的list显示的view
 */
public class YueQiuListShowAdapter
        extends
        BaseAdapter {
    private Context context;
    private List<YueQiuBean> listData;

    public YueQiuListShowAdapter(Context context, List<YueQiuBean> listDay) {
        this.context = context;
        this.listData = listDay;
    }


    @Override
    public int getCount() {
        return listData == null ? 0 : listData.size();
    }

    @Override
    public Object getItem(int i) {
        return listData.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if (view == null) {
            holder = new ViewHolder();
            view = LayoutInflater.from(context).inflate(R.layout.item_yueqiu, null);
            holder.yueqiu_list_price = (TextView) view.findViewById(R.id.yueqiu_list_price);
            holder.yueqiu_list_content = (TextView) view.findViewById(R.id.yueqiu_list_content);
            holder.yueqiu_list_timestart = (TextView) view.findViewById(R.id.yueqiu_list_timestart);
            holder.yueqiu_list_location = (TextView) view.findViewById(R.id.yueqiu_list_location);
            holder.yueqiu_list_wtitle_name = (TextView) view.findViewById(R.id.yueqiu_list_wtitle_name);
            holder.yueqiu_list_join = (TextView) view.findViewById(R.id.yueqiu_list_join);
            holder.create_image_container = (LinearLayout) view.findViewById(R.id.create_image_container);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        YueQiuBean yueQiuBean = listData.get(i);
        String fees = yueQiuBean.getFees();
        String activiNotice = yueQiuBean.getActiviNotice();
        String activiComment = yueQiuBean.getActiviComment();
        String createTime = yueQiuBean.getCreateTime();
        String timeStart = yueQiuBean.getTimeStart();
        String customAddress = yueQiuBean.getCustomAddress();
        String name = yueQiuBean.getName();
        String avatarList = yueQiuBean.getAvatarList();
        String[] avartListshow = new String[]{};
        if (avatarList != null) {
            avartListshow = avatarList.split("\\|")
            ;
        }
        String currentParticipants = yueQiuBean.getCurrentParticipants();
        String totalParticipants = yueQiuBean.getTotalParticipants();
        String customName = yueQiuBean.getCustomName();
        final String id = yueQiuBean.getId();

        holder.yueqiu_list_price.setText("¥" + fees + "/人");
        holder.yueqiu_list_content.setText(customName);
        holder.yueqiu_list_wtitle_name.setText(name);
        holder.yueqiu_list_location.setText(customAddress);
        holder.yueqiu_list_timestart.setText(timeStart);
        holder.yueqiu_list_join.setText(currentParticipants + "/" + totalParticipants + "人");
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, YueQiuDetailActivity.class);
                intent.putExtra(Constant.INVITEID, id);
                LogUtils.e("id", id);
                context.startActivity(intent);
            }
        });
        int length = avartListshow.length;
        ViewUtil.createImageView(context, length, holder.create_image_container, avartListshow);


        return view;
    }

    private class ViewHolder {
        /**
         * 约球标题
         */
        TextView yueqiu_list_wtitle_name;

        /**
         * 约球内容
         */
        TextView yueqiu_list_content;

        /**
         * 约球显示价格
         */
        TextView yueqiu_list_price;

        /**
         * 约球地点
         */
        TextView yueqiu_list_location;

        /**
         * 开始时间按
         */
        TextView yueqiu_list_timestart;

        /**
         * 参加人数
         */
        TextView yueqiu_list_join;
        /**
         * 显示下面的图标
         */
        LinearLayout create_image_container;

    }


    public void loadMore(List<YueQiuBean> listDay) {
        this.listData = listDay;
        notifyDataSetChanged();
    }


}
