package com.msport.clientmaster.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.msport.clientmaster.R;
import com.msport.clientmaster.activity.CourseDetailActivity;
import com.msport.clientmaster.constants.Constant;
import com.msport.clientmaster.entity.CourseListEntity;
import com.msport.clientmaster.intef.ScrollListener;
import com.msport.clientmaster.util.ImageUtil;
import com.msport.clientmaster.util.StringUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by like on 2016/7/13.
 */

public class CourseListShowAdapter extends BaseAdapter {

    private Context context;
    private List<CourseListEntity.DataBean> listBeen;

    public CourseListShowAdapter(Context context, List<CourseListEntity.DataBean> listBeen) {
        this.context = context;
        this.listBeen = listBeen;
    }

    @Override
    public int getCount() {
        return listBeen == null ? 0 : listBeen.size();
    }

    @Override
    public Object getItem(int i) {
        return listBeen.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_course_list, null);
            holder = new ViewHolder(view);

        } else {
            holder = (ViewHolder) view.getTag();
        }
        CourseListEntity.DataBean dataBean = listBeen.get(i);

        holder.itemCourseContent.setText(dataBean.getComment());
        holder.itemCourseLocation.setText(dataBean.getLocation());
        holder.itemCoursePrice.setText("¥" + dataBean.getPrice());
        holder.itemCourseStarttime.setText(dataBean.getTimestart());
        holder.itemCourseTitle.setText(dataBean.getName());
        final String id = dataBean.getId();
        String realImgUrl = StringUtil.getRealImgUrl(dataBean.getAlbum());
        ImageUtil.getNetImage(context, realImgUrl, holder.itemCourseImg);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, CourseDetailActivity.class);
                intent.putExtra(Constant.COURSE_ID, id);
                context.startActivity(intent);
            }
        });

        view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        if (listener != null) {
                            listener.scrollOritention(Constant.SCROLL_DOWN);
                        }
                        break;
                    case MotionEvent.ACTION_UP:
                        if (listener != null) {
                            listener.scrollOritention(Constant.SCROLL_UP);
                        }
                        break;
                }
                return false;
            }
        });

        return view;
    }

    private ScrollListener listener;

    public void setOnScrollListenr(ScrollListener scrollListener) {
        this.listener = scrollListener;
    }


    public void updateView(List<CourseListEntity.DataBean> listData) {
        this.listBeen = listData;
        notifyDataSetChanged();

    }

    static class ViewHolder {
        @BindView(R.id.item_course_img)
        ImageView itemCourseImg;
        @BindView(R.id.item_course_title)
        TextView itemCourseTitle;
        @BindView(R.id.item_course_content)
        TextView itemCourseContent;
        @BindView(R.id.item_course_location)
        TextView itemCourseLocation;
        @BindView(R.id.item_course_price)
        TextView itemCoursePrice;
        @BindView(R.id.item_course_starttime)
        TextView itemCourseStarttime;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
            view.setTag(this);
        }
    }
}
