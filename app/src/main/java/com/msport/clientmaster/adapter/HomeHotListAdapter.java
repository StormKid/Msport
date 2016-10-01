package com.msport.clientmaster.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.msport.clientmaster.R;
import com.msport.clientmaster.activity.CoachDetailActivity;
import com.msport.clientmaster.activity.CourseDetailActivity;
import com.msport.clientmaster.activity.YueQiuDetailActivity;
import com.msport.clientmaster.constants.Constant;
import com.msport.clientmaster.entity.MainEntity;
import com.msport.clientmaster.util.ImageUtil;
import com.msport.clientmaster.util.StringUtil;
import com.msport.clientmaster.util.ViewUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by like on 2016/7/20.
 */

public class HomeHotListAdapter extends BaseAdapter {

    private Context context;
    private List<MainEntity.DataBean.CourseBean> courses;
    private List<MainEntity.DataBean.CoachBean> coachs;
    private List<MainEntity.DataBean.InvitationActivityBean> invitationActivitys;

    private static final int COURSE_TYPE = 0;
    private static final int COACH_TYPE = 1;
    private static final int YUEWQIU_TYPE = 2;

    public HomeHotListAdapter(Context context, List<MainEntity.DataBean.CourseBean> courses, List<MainEntity.DataBean.CoachBean> coachs, List<MainEntity.DataBean.InvitationActivityBean> invitationActivitys) {
        this.context = context;
        this.courses = courses;
        this.coachs = coachs;
        this.invitationActivitys = invitationActivitys;
    }

    @Override
    public int getCount() {
        if (coachs == null && courses == null && invitationActivitys == null)
            return 0;
        else if (coachs == null)
            return courses.size() + invitationActivitys.size();
        else if (courses == null)
            return coachs.size() + invitationActivitys.size();
        else if (invitationActivitys == null)
            return coachs.size() + courses.size();
        else if (courses == null && coachs == null)
            return invitationActivitys.size();
        else if (coachs == null && invitationActivitys == null)
            return courses.size();
        else if (invitationActivitys == null && courses == null)
            return coachs.size();
        else
            return coachs.size() + courses.size() + invitationActivitys.size();
    }

    @Override
    public Object getItem(int i) {
        int viewType = getItemViewType(i);
        switch (viewType) {
            case COURSE_TYPE:
                return courses.get(i);
            case COACH_TYPE:
                return coachs.get(i);
            case YUEWQIU_TYPE:
                return invitationActivitys.get(i);
        }
        return 0;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public int getViewTypeCount() {
        return 3;
    }

    @Override
    public int getItemViewType(int position) {


        if (invitationActivitys == null) {
            if (position < courses.size()) {
                return COURSE_TYPE;
            } else if (courses.size() <= position && position < courses.size() + coachs.size()) {
                return COACH_TYPE;
            }
        } else if (courses == null) {
            if (position < coachs.size()) {
                return COACH_TYPE;
            } else if (coachs.size() <= position && position < coachs.size() + invitationActivitys.size()) {
                return YUEWQIU_TYPE;
            }
        } else if (coachs == null) {
            if (position < courses.size()) {
                return COURSE_TYPE;
            } else if (courses.size() <= position && position < courses.size() + invitationActivitys.size()) {
                return YUEWQIU_TYPE;
            }
        } else if (courses == null && coachs == null) {
            return YUEWQIU_TYPE;
        } else if (courses == null && invitationActivitys == null) {
            return COACH_TYPE;
        } else if (coachs == null && invitationActivitys == null)
            return COURSE_TYPE;
        else {
            if (position < courses.size()) {
                return COURSE_TYPE;
            } else if (courses.size() <= position && position < courses.size() + coachs.size()) {
                return COACH_TYPE;
            } else if (courses.size() + coachs.size() <= position && position < coachs.size() + courses.size() + invitationActivitys.size()) {
                return YUEWQIU_TYPE;
            }
        }

        return super.getItemViewType(position);
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        int viewType = getItemViewType(i);
        switch (viewType) {
            case COURSE_TYPE:
                CouseHolder couseHolder = null;
                if (view == null) {
                    view = LayoutInflater.from(context).inflate(R.layout.item_course_list, null);
                    couseHolder = new CouseHolder(view);
                } else {
                    couseHolder = (CouseHolder) view.getTag();
                }
                MainEntity.DataBean.CourseBean courseBean = courses.get(i);
                String name = courseBean.getName();
                String location = courseBean.getLocation();
                String comment = courseBean.getComment();
                String price = courseBean.getPrice();
                String courseUrl = StringUtil.getRealImgUrl(courseBean.getCourseimage());
                String timestart = courseBean.getTimestart();
                final String courseId = courseBean.getId();
                couseHolder.itemCourseTitle.setText(name);
                couseHolder.itemCourseContent.setText(comment);
                couseHolder.itemCourseLocation.setText(location);
                couseHolder.itemCourseStarttime.setText(timestart);
                couseHolder.itemCoursePrice.setText("¥" + price);
                ImageUtil.getNetImage(context, courseUrl, couseHolder.itemCourseImg);
                view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(context, CourseDetailActivity.class);
                        intent.putExtra(Constant.COURSE_ID, courseId);
                        context.startActivity(intent);
                    }
                });
                return view;
            case COACH_TYPE:
                CoahHolder coahHolder = null;
                if (view == null) {
                    view = LayoutInflater.from(context).inflate(R.layout.item_coach_parent, null);
                    coahHolder = new CoahHolder(view);
                } else {
                    coahHolder = (CoahHolder) view.getTag();
                }
                MainEntity.DataBean.CoachBean coachBean = coachs.get(i - courses.size());
                String fees = coachBean.getFees();
                String coachName = coachBean.getName();
                String availabletimeid = coachBean.getAvailabletimeid();
                String venueNames = coachBean.getVenueNames();
                String introduce = coachBean.getIntroduce();
                final String id = coachBean.getId();

                coahHolder.coachBaseLine.setVisibility(View.GONE);
                coahHolder.itemCoachPrice.setText("¥" + fees);
                coahHolder.itemCoachTitle.setText(coachName);
                coahHolder.itemCoachLocation.setText(venueNames);
                coahHolder.itemCoachRightIv.setVisibility(View.GONE);
                coahHolder.itemCoachContent.setText(introduce);

                ImageUtil.getNetImage(context, StringUtil.getRealImgUrl(availabletimeid), coahHolder.item_coach_img);
                view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(context, CoachDetailActivity.class);
                        intent.putExtra(Constant.COACH_ID, id);
                        context.startActivity(intent);
                    }
                });
                return view;
            case YUEWQIU_TYPE:
                YueQiuHolder yueQiuHolder = null;
                if (view == null) {
                    view = LayoutInflater.from(context).inflate(R.layout.item_yueqiu, null);
                    yueQiuHolder = new YueQiuHolder(view);
                } else {
                    yueQiuHolder = (YueQiuHolder) view.getTag();
                }
                MainEntity.DataBean.InvitationActivityBean invitationActivityBean = invitationActivitys.get(i - coachs.size() - courses.size());
                String activityName = invitationActivityBean.getName();
                String activiComment = invitationActivityBean.getActiviComment();
                String timeStart = invitationActivityBean.getTimeStart();
                String customAddress = invitationActivityBean.getCustomAddress();
                String yueqiuFees = invitationActivityBean.getFees();
                String currentParticipants = invitationActivityBean.getCurrentParticipants();
                String minParticipants = invitationActivityBean.getMinParticipants();
                String customName = invitationActivityBean.getCustomName();
                final String invitationId = invitationActivityBean.getId();
                yueQiuHolder.yueqiuListContent.setText(customName);
                yueQiuHolder.yueqiuListPrice.setText("¥" + yueqiuFees);
                yueQiuHolder.yueqiuListLocation.setText(customAddress);
                yueQiuHolder.yueqiuListTimestart.setText(timeStart);
                yueQiuHolder.yueqiuListWtitleName.setText(activityName);
                yueQiuHolder.yueqiuListJoin.setText(minParticipants + "/" + currentParticipants + "人");
                final ViewGroup create_image_container = (ViewGroup) view.findViewById(R.id.create_image_container);
                String avatarList = invitationActivityBean.getAvatarList();
                String[] split = avatarList.split("\\|");
                ViewUtil.createImageView(context, split.length, create_image_container,split);
                view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(context, YueQiuDetailActivity.class);
                        intent.putExtra(Constant.INVITEID, invitationId);
                        context.startActivity(intent);
                    }
                });

                return view;
        }
        return view;
    }


    static class CouseHolder {
        @BindView(R.id.item_course_title)
        TextView itemCourseTitle;
        @BindView(R.id.item_course_content)
        TextView itemCourseContent;
        @BindView(R.id.item_course_location)
        TextView itemCourseLocation;
        @BindView(R.id.item_course_price)
        TextView itemCoursePrice;
        @BindView(R.id.item_course_starttime)
        TextView itemCourseStarttime;
        @BindView(R.id.item_course_img)
        ImageView itemCourseImg;

        CouseHolder(View view) {
            ButterKnife.bind(this, view);
            view.setTag(this);
        }

    }

    static class CoahHolder {
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
        @BindView(R.id.item_coach_img)
        ImageView item_coach_img;

        CoahHolder(View view) {
            ButterKnife.bind(this, view);
            view.setTag(this);
        }
    }

    static class YueQiuHolder {
        @BindView(R.id.yueqiu_touxiang)
        ImageView yueqiuTouxiang;
        @BindView(R.id.yueqiu_list_wtitle_name)
        TextView yueqiuListWtitleName;
        @BindView(R.id.yueqiu_list_content)
        TextView yueqiuListContent;
        @BindView(R.id.yueqiu_list_price)
        TextView yueqiuListPrice;
        @BindView(R.id.yueqiu_list_timestart)
        TextView yueqiuListTimestart;
        @BindView(R.id.yueqiu_list_location)
        TextView yueqiuListLocation;
        @BindView(R.id.create_image_container)
        LinearLayout createImageContainer;
        @BindView(R.id.yueqiu_list_join)
        TextView yueqiuListJoin;

        YueQiuHolder(View view) {
            ButterKnife.bind(this, view);
            view.setTag(this);
        }
    }

}
