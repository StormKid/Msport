package com.msport.clientmaster.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.msport.clientmaster.R;
import com.msport.clientmaster.entity.QianbaoListEntity;
import com.msport.clientmaster.util.TimeUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by like on 2016/8/16.
 */
public class QianBaoListAdapter extends RecyclerView.Adapter<QianBaoListAdapter.QianBaoHolder> {


    private int type;
    private List<QianbaoListEntity.DataBean> listOut;
    private Context context;

    public QianBaoListAdapter(int type, List<QianbaoListEntity.DataBean> listOut, Context context) {
        this.type = type;
        this.listOut = listOut;
        this.context = context;
    }

    public void onLoad( List<QianbaoListEntity.DataBean> listOut){
        this.listOut = listOut;
        notifyDataSetChanged();
    }

    @Override
    public QianBaoHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_qianbao_list, null);
        QianBaoHolder holder = new QianBaoHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(QianBaoHolder holder, int position) {
        QianbaoListEntity.DataBean dataBean = listOut.get(position);
        if (type==0){
            holder.qianbaoListBillid.setText("支出订单："+dataBean.getBillId());
            holder.qianbaoListPaymoney.setText("支付成功：¥"+dataBean.getAmount());
            holder.qianbaoListPaytime.setText(TimeUtils.getTime(dataBean.getCreateTime()));
        }else{
            holder.qianbaoListBillid.setText("提现到账订单号：："+dataBean.getBillId());
            holder.qianbaoListPaymoney.setText("提现成功：¥"+dataBean.getAmount());
            holder.qianbaoListPaytime.setText(TimeUtils.getTime(dataBean.getCreateTime()));
        }


    }

    @Override
    public int getItemCount() {
            return  listOut==null?0:listOut.size();
    }

    class QianBaoHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.qianbao_list_billid)
        TextView qianbaoListBillid;
        @BindView(R.id.qianbao_list_paymoney)
        TextView qianbaoListPaymoney;
        @BindView(R.id.qianbao_list_paytime)
        TextView qianbaoListPaytime;
        public QianBaoHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


}
