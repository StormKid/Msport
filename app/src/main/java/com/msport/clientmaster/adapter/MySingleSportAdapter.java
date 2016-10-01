package com.msport.clientmaster.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.msport.clientmaster.R;
import com.msport.clientmaster.entity.CourseTypeEntity;

import java.util.List;

/**
 * Created by like on 2016/8/10.
 */

public class MySingleSportAdapter extends BaseAdapter {

    private List<CourseTypeEntity.DataBean> listDatas;
    private Context context;
    private static View oldView;

    public MySingleSportAdapter(List<CourseTypeEntity.DataBean> listDatas, Context activity) {
        this.listDatas = listDatas;
        this.context = activity;
    }

    @Override
    public int getCount() {
        return listDatas == null ? 0 : listDatas.size();
    }

    @Override
    public Object getItem(int i) {
        return listDatas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_sigleword, null);
        }
        TextView show_category_text = (TextView) view.findViewById(R.id.show_category_text);
        final CourseTypeEntity.DataBean dataBean = listDatas.get(i);
        show_category_text.setText(dataBean.getName());
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (listener != null) {
                    listener.getdata(dataBean.getParentId(), dataBean.getId(), i);
                }
                if (oldView == null) {
                    view.setBackgroundResource(R.color.white);
                    oldView = view;
                } else {
                    oldView.setBackgroundResource(R.color.transparent);
                    view.setBackgroundResource(R.color.white);
                    oldView = view;
                }
            }
        });
        return view;
    }

    public void update(List<CourseTypeEntity.DataBean> listData) {
        this.listDatas = listData;
        notifyDataSetChanged();
    }

    public interface DataDoneListener {
        void getdata(String parentId, String childId, int position);
    }

    private DataDoneListener listener;

    public void setonDataDoneListener(DataDoneListener listener) {
        this.listener = listener;
    }


}
