package com.msport.clientmaster.calendar;

import android.content.Context;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.msport.clientmaster.R;
import com.msport.clientmaster.constants.Constant;
import com.msport.clientmaster.util.ViewUtil;
import com.msport.clientmaster.view.TwoButtomDialog;

import java.util.List;


public class MyTimerChooseAdapter extends RecyclerView.Adapter<MyTimerChooseAdapter.MyTimeHolder>{

	private Context context;
	private List<GetTimeBean> listData;
	private Handler handler;
	private boolean tag;
	public MyTimerChooseAdapter(Context context, List<GetTimeBean> listData,Handler handler) {
		super();
		this.context = context;
		this.listData = listData;
		this.handler = handler;
	}
	
	public void getTag(boolean tag){
		this.tag  = tag;
		notifyDataSetChanged();
	}
	
	
	public class MyTimeHolder extends RecyclerView.ViewHolder{
		/**
		 * 选择的时间上午或者下午
		 */
	    TextView choose_time_ap;
	    /**
	     * 选择的具体时间
	     */
		TextView choose_time_time;
		/**
		 * 选择时间的图标
		 */
		ImageView choose_time_gou;
		
		public MyTimeHolder(View view) {
			super(view);
			choose_time_ap = (TextView) view.findViewById(R.id.choose_time_ap);
			choose_time_time = (TextView) view.findViewById(R.id.choose_time_time);
			choose_time_gou = (ImageView) view.findViewById(R.id.choose_time_gou);
		}
		
	}
	
	@Override
	public int getItemCount() {
		return listData==null?0:listData.size();
	}

	@Override
	public void onBindViewHolder(final MyTimeHolder holder, final int position) {
		final GetTimeBean timeBean = listData.get(position);
		if (timeBean.isChecked()) {
			holder.choose_time_ap.setTextColor(context.getResources().getColor(R.color.text_orange));
			holder.choose_time_time.setTextColor(context.getResources().getColor(R.color.text_orange));
			holder.choose_time_gou.setImageResource(R.mipmap.xuanhoushijian);
		
		}else {
			holder.choose_time_ap.setTextColor(context.getResources().getColor(R.color.text_gray_B0));
			holder.choose_time_time.setTextColor(context.getResources().getColor(R.color.text_gray_B0));
			holder.choose_time_gou.setImageResource(R.mipmap.meixuanshijian);
			
		}
		holder.itemView.setOnClickListener(new OnClickListener() {
		

			@Override
			public void onClick(View v) {
				boolean checked = timeBean.isChecked();
				if (!checked) {
					if (tag) {
						ViewUtil.createTwoDialog(context, "您的课程已选满", "确定", new TwoButtomDialog.OnPositiveButtonDialog() {
							@Override
							public void positiveMethod() {

							}
						}, false);
						return;
					}
					checked = true;
					changeChoosed(checked, timeBean, position, holder);
				}else{
					checked = false;
					changeChoosed(checked, timeBean, position, holder);
				}
			}
		});
		GetTimeBean getTimeBean = listData.get(position);
		holder.choose_time_ap.setText(getTimeBean.getAm_pm());
		holder.choose_time_time.setText(getTimeBean.getShowTime());
	}

	@Override
	public MyTimeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View conventView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_choose_time, parent,false);
		MyTimeHolder holder = new MyTimeHolder(conventView);
		return holder;
	}

	/**
	 * 选定
	 */
	private void changeChoosed(boolean tag,GetTimeBean timeBean,int position,MyTimeHolder holder){
		if (tag) {
			holder.choose_time_ap.setTextColor(context.getResources().getColor(R.color.text_orange));
			holder.choose_time_time.setTextColor(context.getResources().getColor(R.color.text_orange));
			holder.choose_time_gou.setImageResource(R.mipmap.xuanhoushijian);
		}else {
			holder.choose_time_ap.setTextColor(context.getResources().getColor(R.color.text_gray_B0));
			holder.choose_time_time.setTextColor(context.getResources().getColor(R.color.text_gray_B0));
			holder.choose_time_gou.setImageResource(R.mipmap.meixuanshijian);
		}
		
		timeBean.setChecked(tag);
		timeBean.setPosition(position);
		handler.obtainMessage(Constant.GET_TIME_CHOOSER, listData).sendToTarget();
	}
	
	
	
	
	
}
