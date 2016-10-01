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
import com.msport.clientmaster.activity.LoactionDetailActivity;
import com.msport.clientmaster.constants.Constant;
import com.msport.clientmaster.entity.MenPiaoEntity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by like on 2016/8/22.
 */

public class MenPiaoAdapter extends BaseAdapter {

    private Context context;
    private List<MenPiaoEntity.DataBean> dataBeen;

    public MenPiaoAdapter(Context context, List<MenPiaoEntity.DataBean> dataBeen) {
        this.context = context;
        this.dataBeen = dataBeen;
    }


    @Override
    public int getCount() {
        return dataBeen == null ? 0 : dataBeen.size();
    }

    @Override
    public Object getItem(int i) {
        return dataBeen.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_menpiao_list, null);
            holder = new ViewHolder(view);
        } else holder = (ViewHolder) view.getTag();
        MenPiaoEntity.DataBean bean = dataBeen.get(i);
        String address = bean.getFeaturelist();
        String name = bean.getName();
        String amount = bean.getFees();
        final String id = bean.getId();

        holder.menpiaoListPrice.setText(amount);
        holder.menpiaoListTitle.setText(name);
        holder.menpiaoListContent.setText(address);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, LoactionDetailActivity.class);
                intent.putExtra(Constant.MENPIAO_ID, id);
                context.startActivity(intent);
            }
        });
        return view;
    }

    static class ViewHolder {
        @BindView(R.id.menpiao_list_img)
        ImageView menpiaoListImg;
        @BindView(R.id.menpiao_list_title)
        TextView menpiaoListTitle;
        @BindView(R.id.menpiao_list_content)
        TextView menpiaoListContent;
        @BindView(R.id.menpiao_list_price)
        TextView menpiaoListPrice;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
            view.setTag(this);
        }
    }


    public void loadMore(List<MenPiaoEntity.DataBean> data) {
        if (data.size() > 0) {
            this.dataBeen = data;
            notifyDataSetChanged();
        }
    }


}
