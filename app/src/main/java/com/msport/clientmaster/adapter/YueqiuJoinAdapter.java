package com.msport.clientmaster.adapter;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.msport.clientmaster.R;
import com.msport.clientmaster.activity.OrderDetailActivity;
import com.msport.clientmaster.constants.Constant;
import com.msport.clientmaster.entity.ActivityEntity;
import com.msport.clientmaster.fragment.OrderButtomFragment;
import com.msport.clientmaster.util.ImageUtil;
import com.msport.clientmaster.util.PublicPreferencesUtils;
import com.msport.clientmaster.util.ViewUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by like on 2016/8/20.
 */
public class YueqiuJoinAdapter extends RecyclerView.Adapter<YueqiuJoinAdapter.ViewHolder> {
    private final int let;
    private final List<ActivityEntity.DataBean> data;
    private final FragmentActivity context;

    public YueqiuJoinAdapter(int let, List<ActivityEntity.DataBean> data, FragmentActivity context) {
        this.let = let;
        this.data = data;
        this.context = context;
    }


    @Override
    public YueqiuJoinAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_activity, null);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(YueqiuJoinAdapter.ViewHolder holder, int position) {
        ActivityEntity.DataBean dataBean = data.get(position);
        String venueName = dataBean.getCustomAddress();
        String createTime = dataBean.getTimeStart();
        String customName = dataBean.getCustomName();
        String name = dataBean.getName();
        String fees = dataBean.getFees();
        String activityId = dataBean.getId();
        final String billId = dataBean.getBillId();

        List<ActivityEntity.DataBean.ExtLstAttendMemberBean> extLstAttendMember = dataBean.getExtLstAttendMember();
        ActivityEntity.DataBean.MemberBean member = dataBean.getMember();
        if (null!=member) {
            String avatarUrl = member.getAvatarUrl();
            ImageUtil.getNetImage(context, avatarUrl, holder.activityYueqiuImage);
        }
        if (extLstAttendMember!=null){
            List<String> urls = new ArrayList<>();
            for (ActivityEntity.DataBean.ExtLstAttendMemberBean attMember : extLstAttendMember) {
                String url = attMember.getAvatarUrl();
                urls.add(url);
            }
            String[] arrays = new String[urls.size()];
            String[] urlss = urls.toArray(arrays);
            int sum = 0;
            if (urlss.length>8)
                sum = 8;
            else {
                sum = urlss.length;
            }
            ViewUtil.createImageView(context, sum, holder.activityAvarstShow, urlss);
        }
        String tag = dataBean.getTag();
        String dispute = dataBean.getDispute();
        checkStatus(tag, dispute, holder, activityId);
        holder.activityYueqiuName.setText(customName);
        holder.activityYueqiuIntroduce.setText(name);
        holder.activityLocation.setText(venueName);
        holder.activityStarttime.setText(createTime);
        holder.activityYueqiuPrice.setText("¥" + fees + "/人");
        String inviteType = dataBean.getInviteType();
        if (null != inviteType && inviteType.equals("1")) {//比赛
            holder.activityYueqiuTitle.setText("比赛");
        } else {//约球
            holder.activityYueqiuTitle.setText("约球");
        }
        holder.select_detail_real.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, OrderDetailActivity.class);
                intent.putExtra(Constant.BILL_ID,billId);
                intent.putExtra(Constant.ORDER_TYPE,Constant.BISAI_TYPE);
                context.startActivity(intent);

            }
        });
        if (let==0) holder.activityYueqiuCommit.setVisibility(View.GONE);
    }

    private void checkStatus(String tag, String dispute, ViewHolder holder, String id) {

        switch (tag) {
            case "1":
                holder.activityYueqiuStatus.setText("未开始");
                holder.activityYueqiuCommit.setVisibility(View.GONE);
                break;
            case "2":
                holder.activityYueqiuStatus.setText("已结束");
                checkJiu(dispute, holder, id);
                break;
            case "3":
                holder.activityYueqiuStatus.setText("已结束");
                holder.activityYueqiuCommit.setVisibility(View.GONE);
                break;
            case "4":
                holder.activityYueqiuStatus.setText("进行中");
                holder.activityYueqiuCommit.setVisibility(View.GONE);
                break;

        }
    }

    private void checkJiu(String dispute, ViewHolder holder, final String activityId) {
        switch (dispute) {
            case "1":
                holder.activityYueqiuCommit.setText("已处理");
                holder.activityYueqiuCommit.setBackgroundResource(R.drawable.shape_categroy_tagnone);
                holder.activityYueqiuCommit.setTextColor(ContextCompat.getColor(context, R.color.text_gray_97));
                break;
            case "2":
                holder.activityYueqiuCommit.setText("发起纠纷");
                holder.activityYueqiuCommit.setTextColor(ContextCompat.getColor(context, R.color.text_blue));
                holder.activityYueqiuCommit.setBackgroundResource(R.drawable.shape_categroy_tagblue);
                holder.activityYueqiuCommit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        PublicPreferencesUtils.putString(context, Constant.ACTIVITY_ID, activityId);
                        OrderButtomFragment dialog = new OrderButtomFragment(R.layout.choose_pop_bottom, Constant.ACTIVITY_JIUFEN, context);
                        dialog.show(context.getSupportFragmentManager(), "1");
                    }
                });
                break;
            case "-1":
                holder.activityYueqiuCommit.setText("处理中");
                holder.activityYueqiuCommit.setBackgroundResource(R.drawable.shape_categroy_tagnone);
                holder.activityYueqiuCommit.setTextColor(ContextCompat.getColor(context, R.color.text_gray_97));

                break;
        }


    }


    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.activity_yueqiu_title)
        TextView activityYueqiuTitle;
        @BindView(R.id.activity_yueqiu_status)
        TextView activityYueqiuStatus;
        @BindView(R.id.activity_yueqiu_image)
        ImageView activityYueqiuImage;
        @BindView(R.id.activity_yueqiu_name)
        TextView activityYueqiuName;
        @BindView(R.id.activity_yueqiu_introduce)
        TextView activityYueqiuIntroduce;
        @BindView(R.id.activity_yueqiu_price)
        TextView activityYueqiuPrice;
        @BindView(R.id.activity_starttime)
        TextView activityStarttime;
        @BindView(R.id.activity_location)
        TextView activityLocation;
        @BindView(R.id.activity_avarst_show)
        LinearLayout activityAvarstShow;
        @BindView(R.id.activity_yueqiu_commit)
        TextView activityYueqiuCommit;
        @BindView(R.id.select_detail_real)
        LinearLayout select_detail_real;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
