package com.msport.clientmaster.adapter;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.msport.clientmaster.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by like on 2016/8/22.
 */

public class MySingleTextAdapter  extends BaseAdapter{

    private List<String> listText;
    private Context context;
    private static TextView oldView;

    public MySingleTextAdapter(List<String> listText, Context context) {
        this.listText = listText;
        this.context = context;
    }


    @Override
    public int getCount() {
        return listText == null ? 0 : listText.size();
    }

    @Override
    public Object getItem(int i) {
        return listText.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_sigleword, null);
            holder = new ViewHolder(view);
        }else {
            holder = (ViewHolder) view.getTag();
        }
        holder.showCategoryText.setText(listText.get(i));
        holder.showCategoryText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView textView = (TextView) view;
                if (oldView == null) {
                    textView.setTextColor(ContextCompat.getColor(context,R.color.text_orange));
                    oldView = (TextView) view;
                } else {
                    textView.setTextColor(ContextCompat.getColor(context,R.color.text_orange));
                    oldView.setTextColor(ContextCompat.getColor(context,R.color.text_black_5c));
                    oldView = (TextView) view;
                }
                String  content = textView.getText().toString().trim();
                if (listener!=null){
                    listener.onSetText(content);
                }
            }
        });
        return view;
    }

    class ViewHolder {
        @BindView(R.id.show_category_text)
        TextView showCategoryText;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
            view.setTag(this);
        }
    }

    public interface  OnSetTextListener{
       void onSetText(String content);
    }

    public void setOnSetText(OnSetTextListener listener){
        this.listener = listener;
    }

    private OnSetTextListener listener;

}
