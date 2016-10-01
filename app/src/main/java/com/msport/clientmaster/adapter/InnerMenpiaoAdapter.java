package com.msport.clientmaster.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.msport.clientmaster.R;
import com.msport.clientmaster.activity.MenPiaoDetailActivity;
import com.msport.clientmaster.constants.Constant;
import com.msport.clientmaster.entity.LocationDetailEntity;
import com.msport.clientmaster.util.ImageUtil;
import com.msport.clientmaster.util.StringUtil;

import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by like on 2016/8/23.
 */
public class InnerMenpiaoAdapter extends BaseAdapter {
    private Context context;
    private List<LocationDetailEntity.DataBean.TicketListBean> ticketList;
    private final String location;
    private final String address;
    private final String telephone;

    public InnerMenpiaoAdapter(Context context, List<LocationDetailEntity.DataBean.TicketListBean> ticketList, String location, String address, String telephone) {

        this.context = context;
        this.ticketList = ticketList;
        this.location = location;
        this.address = address;
        this.telephone = telephone;
    }



    @Override
    public int getCount() {
        return ticketList == null ? 0 : ticketList.size();
    }

    @Override
    public Object getItem(int i) {
        return ticketList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.inner_menpiao, null);
            holder = new ViewHolder(view);
        }else {
            holder = (ViewHolder) view.getTag();
        }
        LocationDetailEntity.DataBean.TicketListBean listBean = ticketList.get(i);
        String amount = listBean.getAmount();
        String currentSaleNum = listBean.getCurrentSaleNum();
        String image = listBean.getImage();
        String name = listBean.getName();
        String marketPrice = listBean.getMarketPrice();
        final String id = listBean.getId();
        String realImgUrl = StringUtil.getRealImgUrl(image);
        holder.innerMenpiaoName.setText(name);
        holder.innerMenpiaoPrice.setText("¥"+amount);
        holder.innerMenpiaoOutprice.setText("门市价：¥"+marketPrice);
        ImageUtil.getNetImage(context,realImgUrl,holder.innerMenpiaoImg);
        holder.innerMenpiaoSalenum.setText("已售："+currentSaleNum);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, MenPiaoDetailActivity.class);
                intent.putExtra(Constant.MENPIAO_ID,id);
                intent.putExtra("address",address);
                intent.putExtra("location",location);
                intent.putExtra("telephone",telephone);
                context.startActivity(intent);
            }
        });
        return view;
    }

    static class ViewHolder {
        @BindView(R.id.inner_menpiao_img)
        ImageView innerMenpiaoImg;
        @BindView(R.id.inner_menpiao_name)
        TextView innerMenpiaoName;
        @BindView(R.id.inner_menpiao_price)
        TextView innerMenpiaoPrice;
        @BindView(R.id.inner_menpiao_outprice)
        TextView innerMenpiaoOutprice;
        @BindView(R.id.inner_menpiao_salenum)
        TextView innerMenpiaoSalenum;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
            view.setTag(this);
        }
    }
}
