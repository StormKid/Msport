package com.msport.clientmaster.adapter;


import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.msport.clientmaster.R;

import java.util.List;

public class CourseCategroyAdapter
        extends
        RecyclerView.Adapter<CourseCategroyAdapter.MyViewHolder> {
    private int clickTemp;
    private Context context;
    private List<String> listData;
    private OnGetPositionListener listener;

    // 标识选择的Item
    public void setSeclection(int position) {
        clickTemp = position;
    }

    public CourseCategroyAdapter(Context context, List<String> listDay) {
        this.context = context;
        this.listData = listDay;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView show_category_text;

        public MyViewHolder(View view) {
            super(view);
            show_category_text = (TextView) view.findViewById(R.id.show_category_text);
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
            holder.show_category_text.setTextSize(TypedValue.COMPLEX_UNIT_PX, context.getResources().getDimensionPixelSize(R.dimen.size_16));
            holder.show_category_text.setTextColor(ContextCompat.getColor(context, R.color.text_orange));
        } else {
            holder.show_category_text.setTextSize(TypedValue.COMPLEX_UNIT_PX, context.getResources().getDimensionPixelSize(R.dimen.size_14));
            holder.show_category_text.setTextColor(ContextCompat.getColor(context, R.color.text_black_5c));
        }
        holder.show_category_text.setText(courseCategroy);
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
                R.layout.item_string, parent, false);
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
