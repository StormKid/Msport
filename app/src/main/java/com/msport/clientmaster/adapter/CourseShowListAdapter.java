package com.msport.clientmaster.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.msport.clientmaster.R;
import com.msport.clientmaster.entity.CourseDetailEntity;
import com.msport.clientmaster.util.TimeUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 课程显示得listView
 * Created by like on 2016/7/25.
 */

public class CourseShowListAdapter extends BaseAdapter {

    private Context context;

    public CourseShowListAdapter(Context context, List<CourseDetailEntity.DataBean.TimeScheduleListBean> listData) {
        this.context = context;
        this.listData = listData;
    }

    private List<CourseDetailEntity.DataBean.TimeScheduleListBean> listData;


    @Override
    public int getCount() {
        return listData == null ? 0: listData.size();
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
            view = LayoutInflater.from(context).inflate(R.layout.item_course_detail_listshow, null);
            holder = new ViewHolder(view);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        CourseDetailEntity.DataBean.TimeScheduleListBean listBean = listData.get(i);
        String startTime = listBean.getStartTime();
        String endTime = listBean.getEndTime();
        int num = i+1;
        holder.timeListNo.setText("课程时间"+num);
        String startTimeDate = TimeUtils.getTimeDateReal(startTime);
        String timePart = TimeUtils.getTimeDate(startTime, endTime);
        holder.timeListDate.setText(startTimeDate);
        holder.timeListTime.setText(timePart);
        return view;
    }


    public void updateMore(List<CourseDetailEntity.DataBean.TimeScheduleListBean> listData) {
        this.listData = listData;
        notifyDataSetChanged();
    }

    static class ViewHolder {
        @BindView(R.id.time_list_no)
        TextView timeListNo;
        @BindView(R.id.time_list_date)
        TextView timeListDate;
        @BindView(R.id.time_list_time)
        TextView timeListTime;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
            view.setTag(this);
        }
    }
}
