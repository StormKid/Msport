package com.msport.clientmaster.adapter;


import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.msport.clientmaster.R;

import java.util.List;

public class YueQiuCategroyAdapter
        extends
        RecyclerView.Adapter<YueQiuCategroyAdapter.MyViewHolder> {
    private int clickTemp;
    private Context context;
    private List<String> listData;
    private OnGetPositionListener listener;

    // 标识选择的Item
    public void setSeclection(int position) {
        clickTemp = position;
    }

    public YueQiuCategroyAdapter(Context context, List<String> listDay) {
        this.context = context;
        this.listData = listDay;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView down_time;
        public TextView up_time;

        public MyViewHolder(View view) {
            super(view);
            up_time = (TextView) view.findViewById(R.id.up_time);
            down_time = (TextView) view.findViewById(R.id.down_time);

        }

    }

    @Override
    public long getItemId(int position) {

        return position;
    }

    @Override
    public int getItemCount() {
        return listData == null ? 0 : listData.size();
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        String courseCategroy = listData.get(position);
        if (clickTemp == position) {
            holder.up_time.setTextColor(ContextCompat.getColor(context, R.color.text_orange));
            holder.down_time.setTextColor(ContextCompat.getColor(context, R.color.text_orange));
        } else {
            holder.up_time.setTextColor(ContextCompat.getColor(context, R.color.text_black_5c));
            holder.down_time.setTextColor(ContextCompat.getColor(context, R.color.text_black_5c));
        }
        String[] strings = courseCategroy.split("-");
        String date = strings[0];
        String time = strings[1];
        holder.up_time.setText(date);
        holder.down_time.setText(time);
        holder.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                clickTemp = position;
                if (listener != null) {
                    listener.getPosition(v, position);
                }
                notifyDataSetChanged();
            }
        });


    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int arg1) {
        View v = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item_yuyue_string, parent, false);
        MyViewHolder holder = new MyViewHolder(v);
        return holder;
    }

    public interface OnGetPositionListener {
        void getPosition(View v, int position);
    }

    public void setOnGetPositionListener(OnGetPositionListener listener) {
        this.listener = listener;

    }


}
