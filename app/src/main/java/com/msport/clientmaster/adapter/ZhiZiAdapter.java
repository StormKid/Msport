package com.msport.clientmaster.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.msport.clientmaster.R;
import com.msport.clientmaster.bean.CoachExperienceList;
import com.msport.clientmaster.util.TimeUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by like on 2016/8/3.
 */

public class ZhiZiAdapter extends BaseAdapter {

    private Context context;
    private List<CoachExperienceList> listData;

    public ZhiZiAdapter(Context context, List<CoachExperienceList> listData) {
        this.context = context;
        this.listData = listData;
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
            view = LayoutInflater.from(context).inflate(R.layout.item_zizhi, null);
            holder = new ViewHolder(view);
        }else {
            holder = (ViewHolder) view.getTag();
        }
        CoachExperienceList coachExperienceList = listData.get(i);
        String content = coachExperienceList.getContent();
        String timeStart = coachExperienceList.getTimeStart();
        String timeEnd = coachExperienceList.getTimeEnd();
        String type = coachExperienceList.getType();
        if ("0".equals(type)){
            holder.zizhiTitle.setText("比赛经历");
        }else {
            holder.zizhiTitle.setText("教学经历");
        }
        String startTimer = TimeUtils.getTime(Long.parseLong(timeStart));
        String endTimer= TimeUtils.getTime(Long.parseLong(timeEnd));
        holder.zizhiTime.setText(startTimer +"至"+endTimer);
        holder.zizhiDetail.setText(content);
        return view;
    }

    public void updateMore(List<CoachExperienceList> list) {
        this.listData = list;
        notifyDataSetChanged();
    }


    static class ViewHolder {
        @BindView(R.id.zizhi_title)
        TextView zizhiTitle;
        @BindView(R.id.zizhi_time)
        TextView zizhiTime;
        @BindView(R.id.zizhi_detail)
        TextView zizhiDetail;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
            view.setTag(this);
        }
    }
}
