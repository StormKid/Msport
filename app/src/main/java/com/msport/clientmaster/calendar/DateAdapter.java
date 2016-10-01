package com.msport.clientmaster.calendar;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup;
import android.widget.TextView;

import com.msport.clientmaster.R;

import java.util.List;


public class DateAdapter
		extends
		RecyclerView.Adapter<DateAdapter.MyViewHolder> {
	private int clickTemp;
	private Context context;
	private List<DateBean> listData;
	private OnGetPositionListener listener;
	private OnGetMounthListener onGetMounthListener;

	// 标识选择的Item
	public void setSeclection(int position) {
		clickTemp = position;
	}

	public DateAdapter(Context context, List<DateBean> listDay) {
		this.context = context;
		this.listData = listDay;
	}

	class MyViewHolder extends RecyclerView.ViewHolder {

		private View view;
		public TextView tv_calendar;
		public TextView tv_week;

		public MyViewHolder(View view) {
			super(view);
			this.view = view;
			this.itemView.addOnLayoutChangeListener(new OnLayoutChangeListener() {
				
				@Override
				public void onLayoutChange(View v,int left,int top,int right,
						int bottom, int oldLeft,int oldTop,int oldRight,int oldBottom) {
					
				}
			});
			tv_calendar = (TextView) view.findViewById(R.id.tv_calendar);
			tv_week = (TextView) view.findViewById(R.id.tv_week);
		}

	}

	@Override
	public long getItemId(int position) {

		return super.getItemId(position);
	}

	@Override
	public int getItemCount() {
		return listData == null ? 0 : listData.size();
	}

	@Override
	public void onBindViewHolder(MyViewHolder holder, final int position) {

		DateBean dateBean = listData.get(position);
		if (clickTemp == position) {
			holder.tv_calendar.setSelected(true);
			holder.tv_week.setSelected(true);
			holder.tv_calendar.setTextColor(context.getResources().getColor(
					R.color.text_orange));
			holder.tv_week.setTextColor(context.getResources().getColor(
					R.color.text_orange));
			if (onGetMounthListener !=null) {
				onGetMounthListener.getMounth(dateBean.getMounth());
			}
		} else {
			holder.tv_calendar.setSelected(false);
			holder.tv_week.setSelected(false);
			holder.tv_calendar.setTextColor(context.getResources().getColor(
					R.color.text_gray_B0));
			holder.tv_week.setTextColor(context.getResources().getColor(
					R.color.text_gray_B0));
		}
		holder.tv_calendar.setText(dateBean.getDay());
		holder.tv_week.setText(dateBean.getWeekend());
		holder.itemView.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				clickTemp = position;
				if (listener != null) {
					listener.getPosition(v, position);
				}
				notifyDataSetChanged();
			}
		});
		

	}

	@Override
	public MyViewHolder onCreateViewHolder(ViewGroup parent, int arg1) {
		View v = LayoutInflater.from(parent.getContext()).inflate(
				R.layout.item_calendar, parent, false);
		MyViewHolder holder = new MyViewHolder(v);

		return holder;
	}

	public interface OnGetPositionListener {
		void getPosition(View v, int position);
	}

	public void setOnGetPositionListener(OnGetPositionListener listener) {
		this.listener = listener;

	}
	
	
	public interface OnGetMounthListener{
		void getMounth(String mounth);
	}
	public void setOnGetMounthListener(OnGetMounthListener onGetMounthListener){
		this.onGetMounthListener = onGetMounthListener;
		
	}
	

}
