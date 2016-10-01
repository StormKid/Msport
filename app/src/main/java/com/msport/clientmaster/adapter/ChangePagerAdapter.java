package com.msport.clientmaster.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;
/**
 * 让viewpager适用fragment的适配器
 * @author like
 * 2016-5-17
 */
public class ChangePagerAdapter extends FragmentPagerAdapter {
	private List<Fragment> fragments;
	public ChangePagerAdapter(FragmentManager fm, List<Fragment> Fragments) {
		super(fm);
		this.fragments = Fragments;
	}

	@Override
	public Fragment getItem(int arg0) {
		return fragments.get(arg0);
	}

	@Override
	public int getCount() {
		return fragments.size();
	}

}
