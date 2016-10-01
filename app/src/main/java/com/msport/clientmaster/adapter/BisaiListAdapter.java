package com.msport.clientmaster.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.msport.clientmaster.R;
import com.msport.clientmaster.entity.BisaiListEntity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by like on 2016/7/22.
 */

public class BisaiListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private Context context;
    private List<BisaiListEntity.DataBean> listData;
    private static final int ONE_TYPE = 0;
    private static final int TWO_TYPE = 1;

    public BisaiListAdapter(Context context, List<BisaiListEntity.DataBean> listData) {
        this.context = context;
        this.listData = listData;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case ONE_TYPE:
                View viewOne = LayoutInflater.from(context).inflate(R.layout.item_bisai_one, null);
                OneViewHolder oneHolder = new OneViewHolder(viewOne);
                return oneHolder;
            case TWO_TYPE:
                View viewTwo = LayoutInflater.from(context).inflate(R.layout.item_bisai_two, null);
                TwoViewHolder twoHolder = new TwoViewHolder(viewTwo);
                return twoHolder;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        final BisaiListEntity.DataBean dataBean = listData.get(position);
        if (holder instanceof OneViewHolder) {
            OneViewHolder oneHoder = (OneViewHolder) holder;
            String fees = dataBean.getFees();
            String minParticipants = dataBean.getMinParticipants();
            String totalParticipants = dataBean.getTotalParticipants();
            oneHoder.bisaiPrice.setText(fees+"/人");
            oneHoder.bisaiJoinmember.setText(totalParticipants + "人参加");
        } else if (holder instanceof TwoViewHolder) {
            TwoViewHolder twoHolder = (TwoViewHolder) holder;
            String fees = dataBean.getFees();
            String activiNotice = dataBean.getActiviNotice();
            String activiComment = dataBean.getActiviComment();
            String minParticipants = dataBean.getMinParticipants();
            String name = dataBean.getName();
            twoHolder.bisaiTitle.setText(name);
            twoHolder.bisaiContent.setText(activiNotice);
            twoHolder.bisaiMemberPrice.setText(fees+"/人");
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (lisenter!=null){
                    lisenter.onclickListener(dataBean,position);
                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return listData == null ? 0 : listData.size();
    }


    @Override
    public int getItemViewType(int position) {
        BisaiListEntity.DataBean dataBean = listData.get(position);
        String inviteType = dataBean.getMatchStyle();
        if (null!=inviteType){
        if (inviteType.equals("0")) {
            return ONE_TYPE;
        } else {
            return TWO_TYPE;
        }}
        return  ONE_TYPE;
    }

    static class OneViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.bisai_joinmember)
        TextView bisaiJoinmember;
        @BindView(R.id.bisai_price)
        TextView bisaiPrice;
        @BindView(R.id.center_contain)
        LinearLayout centerContain;

        public OneViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    static class TwoViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.bisai_laber)
        TextView bisaiLaber;
        @BindView(R.id.bisai_type)
        TextView bisaiType;
        @BindView(R.id.bisai_title)
        TextView bisaiTitle;
        @BindView(R.id.bisai_content)
        TextView bisaiContent;
        @BindView(R.id.bisai_member_price)
        TextView bisaiMemberPrice;
        @BindView(R.id.bisai_list_share)
        ImageView bisaiListShare;

        public TwoViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public interface  OnViewClickListener{
        void  onclickListener( BisaiListEntity.DataBean listData , int position);
    }

    public void setOnViewClickListener(OnViewClickListener listener){
        this.lisenter = listener;
    }

    private  OnViewClickListener lisenter;

}
