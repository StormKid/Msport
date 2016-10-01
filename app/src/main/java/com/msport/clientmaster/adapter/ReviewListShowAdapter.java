package com.msport.clientmaster.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.msport.clientmaster.R;
import com.msport.clientmaster.entity.DetailReviewEntity;
import com.msport.clientmaster.util.ImageUtil;
import com.msport.clientmaster.util.StringUtil;
import com.msport.clientmaster.view.JustifyTextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by like on 2016/7/25.
 */

public class ReviewListShowAdapter extends BaseAdapter {

    private Context context;
    private List<DetailReviewEntity.DataBean> listData;

    public ReviewListShowAdapter(Context context, List<DetailReviewEntity.DataBean> listData) {
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
            view = LayoutInflater.from(context).inflate(R.layout.item_review, null);
            holder = new ViewHolder(view);
        }else{
            holder = (ViewHolder) view.getTag();
        }
        if (listData==null)
            return view;
        DetailReviewEntity.DataBean dataBean = listData.get(i);
        String createTime = dataBean.getCreateTime();
        String extraCoachName = dataBean.getExtraCoachName();
        String content = dataBean.getContent();
        String extraMemberImage = dataBean.getExtraMemberImage();
        String coachDegree = dataBean.getCoachDegree();
        int coachInt = Integer.parseInt(coachDegree);
        holder.reviewListContent.setText(content);
        holder.reviewListName.setText(extraCoachName);
        holder.reviewListCreate.setText(createTime);
        String realImgUrl = StringUtil.getRealImgUrl(extraMemberImage);
        ImageUtil.getNetImage(context,realImgUrl,holder.reviewListImg);
        getViewStar(holder.addReviewCoachdegree,coachInt);

        return view;
    }

    public void updateMore(List<DetailReviewEntity.DataBean> listData) {
        this.listData = listData;
        notifyDataSetChanged();
    }


    /**
     * 显示评论多少
     */
    private void getViewStar(ViewGroup vg, int max) {
        for (int i = 0; i < max; i++) {
            ImageView iv = (ImageView) vg.getChildAt(i);
            iv.setVisibility(View.VISIBLE);
        }
    }


    static class ViewHolder {
        @BindView(R.id.review_list_img)
        ImageView reviewListImg;
        @BindView(R.id.review_list_name)
        TextView reviewListName;
        @BindView(R.id.add_review_coachdegree)
        LinearLayout addReviewCoachdegree;
        @BindView(R.id.review_list_create)
        TextView reviewListCreate;
        @BindView(R.id.review_list_content)
        JustifyTextView reviewListContent;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
            view.setTag(this);
        }
    }

}
