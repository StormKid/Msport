package com.msport.clientmaster.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.msport.clientmaster.R;
import com.msport.clientmaster.activity.CoachDetailActivity;
import com.msport.clientmaster.constants.Constant;
import com.msport.clientmaster.entity.CoachListEntity;
import com.msport.clientmaster.intef.ScrollListener;
import com.msport.clientmaster.util.ImageUtil;
import com.msport.clientmaster.util.StringUtil;

import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by like on 2016/7/16.
 * 私教显示列表
 */
public class CoachListAdapter extends BaseExpandableListAdapter {
    private List<CoachListEntity.DataBean> parentCoach;
    private Map<String, List<String>> childCoach;
    private Context context;
    private showChildListener listener;

    public CoachListAdapter(Context context, List<CoachListEntity.DataBean> parentCoach, Map<String, List<String>> childCoach) {
        this.context = context;
        this.childCoach = childCoach;
        this.parentCoach = parentCoach;
    }


    @Override
    public int getGroupCount() {
        return parentCoach == null ? 0 : parentCoach.size();
    }

    @Override
    public int getChildrenCount(int i) {
        CoachListEntity.DataBean dataBean = parentCoach.get(i);
        String id = dataBean.getId();
        List<String> location = childCoach.get(id);
        return location == null ? 0 : location.size()-1;
    }

    @Override
    public Object getGroup(int i) {
        return parentCoach.get(i);
    }

    @Override
    public Object getChild(int parentPosition, int childPosition) {
        String key = parentCoach.get(parentPosition).getId();
        return childCoach.get(key).get(childPosition);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(final int i, boolean b, View view, ViewGroup viewGroup) {
        MyParentHolder myParentHolder = null;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_coach_parent, null);
            myParentHolder = new MyParentHolder(view);
        } else {
            myParentHolder = (MyParentHolder) view.getTag();
        }


        /////////////////////////数据处理///////////////////////////

        CoachListEntity.DataBean dataBean = parentCoach.get(i);
        myParentHolder.itemCoachContent.setText(dataBean.getIntroduce());
        myParentHolder.itemCoachPrice.setText("¥" + dataBean.getFees() + "/课时");
        myParentHolder.itemCoachTitle.setText(dataBean.getName());
        final String id = dataBean.getId();
        String album = dataBean.getAlbum();
        String realImgUrl = StringUtil.getRealImgUrl(album);
        ImageUtil.getNetImage(context, realImgUrl, myParentHolder.itemCoachImg);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, CoachDetailActivity.class);
                intent.putExtra(Constant.COACH_ID, id);
                context.startActivity(intent);
            }
        });
       final ImageView iv = myParentHolder.itemCoachRightIv;
        view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    if (showlistener != null) {
                        showlistener.scrollOritention(Constant.SCROLL_DOWN);
                    }
                } else if (MotionEvent.ACTION_UP == motionEvent.getAction()) {
                    if (showlistener != null) {
                        showlistener.scrollOritention(Constant.SCROLL_UP);
                    }
                }
                return false;
            }
        });
        ViewGroup vg = (ViewGroup) view.findViewById(R.id.show_child);

        if (null!=childCoach.get(id)&&childCoach.get(id).size()>0) {
            String address = childCoach.get(id).get(0);
            myParentHolder.itemCoachLocation.setText(address);
            vg.setClickable(false);
            vg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listener != null) {
                        listener.getPosition(i, iv);
                    }
                }
            });
        }else {
            myParentHolder.itemCoachLocation.setVisibility(View.INVISIBLE);
            vg.setClickable(true);
        }

        return view;
    }
    @Override
    public View getChildView(int i, int childPosition, boolean b, View view, ViewGroup viewGroup) {
        MyChildHolder myChildHolder = null;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_coach_child, null);
            myChildHolder = new MyChildHolder(view);
        } else {
            myChildHolder = (MyChildHolder) view.getTag();
        }
        String id = parentCoach.get(i).getId();
        List<String> strings = childCoach.get(id);
        if (strings.size() > 1) {
            String location = strings.get(childPosition+1);
            myChildHolder.coachChildName.setText(location);
        }
        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }

    public interface showChildListener {
        void getPosition(int position, View view);
    }

    public void setOnShowChildListener(showChildListener listener) {
        this.listener = listener;
    }


    public ScrollListener showlistener;

    public void setOnScrollListener(ScrollListener listener) {
        this.showlistener = listener;

    }

    static class MyChildHolder {
        @BindView(R.id.coach_child_name)
        TextView coachChildName;

        MyChildHolder(View view) {
            ButterKnife.bind(this, view);
            view.setTag(this);
        }
    }

    static class MyParentHolder {
        @BindView(R.id.item_coach_img)
        ImageView itemCoachImg;
        @BindView(R.id.item_coach_title)
        TextView itemCoachTitle;
        @BindView(R.id.item_coach_content)
        TextView itemCoachContent;
        @BindView(R.id.item_coach_price)
        TextView itemCoachPrice;
        @BindView(R.id.item_coach_location)
        TextView itemCoachLocation;
        @BindView(R.id.item_coach_right_iv)
        ImageView itemCoachRightIv;
        @BindView(R.id.show_child)
        LinearLayout showChild;
        @BindView(R.id.coach_base_line)
        View coachBaseLine;

        MyParentHolder(View view) {
            ButterKnife.bind(this, view);
            view.setTag(this);
        }
    }



    public void onLoad(List<CoachListEntity.DataBean> parentCoach, Map<String, List<String>> childCoach){
        this.parentCoach = parentCoach;
        this.childCoach = childCoach;
        notifyDataSetChanged();
    }



    public class MyViewChange implements ExpandableListView.OnGroupExpandListener{

        @Override
        public void onGroupExpand(int groupPosition) {

        }
    }


}
