package com.msport.clientmaster.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.msport.clientmaster.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by like on 2016/8/27.
 */
public class VanueAddressSingleChooseAdapter extends BaseAdapter {
    private final Context context;
    private final String[] vanueLocationList;
    private final String[] vanueAddressList;
    private static ImageView olderview;

    public VanueAddressSingleChooseAdapter(Context context, String[] vanueLocationList, String[] vanueAddressList) {
        this.context = context;
        this.vanueLocationList = vanueLocationList;
        this.vanueAddressList = vanueAddressList;
    }

    @Override
    public int getCount() {
        return vanueLocationList == null || vanueAddressList == null ? 0 : vanueLocationList.length;
    }

    @Override
    public Object getItem(int i) {
        return vanueAddressList[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_location_choose, null);
            holder = new ViewHolder(view);
        } else holder = (ViewHolder) view.getTag();
        final String vanueAddress = vanueAddressList[i];
        final String vanueLocation = vanueLocationList[i];
        holder.locationAddress.setText(vanueAddress);
        holder.locationLocation.setText(vanueLocation);
        final ImageView imageView = holder.locationGou ;
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (olderview==null){
                    imageView.setVisibility(View.VISIBLE);
                    olderview = imageView;
                }else {
                    olderview.setVisibility(View.GONE);
                    imageView.setVisibility(View.VISIBLE);
                    olderview = imageView;
                }
                if (lisener!=null){
                    lisener.getLocation(vanueLocation,vanueAddress);
                }
            }
        });
        return view;
    }

    static class ViewHolder {
        @BindView(R.id.location_location)
        TextView locationLocation;
        @BindView(R.id.location_address)
        TextView locationAddress;
        @BindView(R.id.location_gou)
        ImageView locationGou;


        ViewHolder(View view) {
            ButterKnife.bind(this, view);
            view.setTag(this);
        }
    }


    public interface getLocationMethod{
        void getLocation(String vanueLocation, String address);
    }
    private getLocationMethod lisener;
    public  void  setgetLocationMethod(getLocationMethod lisener){
        this.lisener = lisener;
    }

}
