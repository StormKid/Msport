package com.msport.clientmaster.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.msport.clientmaster.R;
import com.msport.clientmaster.adapter.ChangePagerAdapter;
import com.msport.clientmaster.adapter.YueQiuCategroyAdapter;
import com.msport.clientmaster.util.TimeUtils;

import org.simple.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 约球页面
 * Created by like on 2016/7/21.
 */
@SuppressLint("ValidFragment")
public class YueQiuFragment extends Fragment {


    @BindView(R.id.course_category_contain)
    ViewPager course_category_contain;

    @BindView(R.id.course_category_contain_text)
    RecyclerView course_category_contain_text;
    private YueQiuCategroyAdapter adapter;
    private List<String> listD;
    private static long time = System.currentTimeMillis();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_courselist,null);
        EventBus.getDefault().register(this);
        ButterKnife.bind(this,view);
        initView();
        return view;
    }


    private void initView() {
        listD = new ArrayList<>();
        List<Fragment> setFragments = setFragment(4);
        adapter = new YueQiuCategroyAdapter(getActivity(), listD);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setSmoothScrollbarEnabled(true);
        layoutManager.setOrientation(LinearLayout.HORIZONTAL);
        final RecyclerView.State state = new RecyclerView.State();
        course_category_contain_text.setLayoutManager(layoutManager);
        course_category_contain_text.setAdapter(adapter);
        course_category_contain.setAdapter(new ChangePagerAdapter(
                getActivity().getSupportFragmentManager(), setFragments));
        course_category_contain.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int arg0) {
                adapter.setSeclection(arg0);
                layoutManager.smoothScrollToPosition(course_category_contain_text, state, arg0);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int arg0) {

            }
        });
        course_category_contain.setOffscreenPageLimit(setFragments.size());
        adapter.setOnGetPositionListener(new YueQiuCategroyAdapter.OnGetPositionListener() {

            @Override
            public void getPosition(View v, int position) {
                // TODO 设为false来关闭滑动，只用于显示
                course_category_contain.setCurrentItem(position, true);
            }
        });
    }


    private List<Fragment> setFragment(int total){
        List<Fragment> params = new ArrayList<>();
        long valueTime = time;
        for (int i =0;i<total;i++){
            Fragment fragment = new YueQiuListFragment(getActivity(),i,valueTime/1000);
            String dayMounth = TimeUtils.getDayMounth(valueTime);
            switch (i){
                case 0:
                    listD.add(dayMounth+"-今天");
                    break;
                case 1:
                    listD.add(dayMounth+"-明天");
                    break;
                case 2:
                    listD.add(dayMounth+"-后天");
                    break;
                case 3:
                    listD.add(dayMounth+"-两天后");
                    break;
            }
            valueTime  = valueTime + 24*60*60*1000;
            params.add(fragment);
        }
        return params;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

}
