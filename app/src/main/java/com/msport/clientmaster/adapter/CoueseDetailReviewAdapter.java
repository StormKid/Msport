package com.msport.clientmaster.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * 显示课程详情的评论的适配器
 * Created by like on 2016/7/23.
 */

public class CoueseDetailReviewAdapter extends BaseAdapter {

    private List<?> listData;

    private Context context ;

    public CoueseDetailReviewAdapter(Context context, List<?> listData) {
        this.context = context;
        this.listData = listData;
    }


    @Override
    public int getCount() {
        return listData==null?1:listData.size();
    }

    @Override
    public Object getItem(int i) {
        return listData.size();
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }
}
