package com.msport.clientmaster.callback;

import android.app.Activity;
import android.view.ViewGroup;

import com.msport.clientmaster.util.ViewUtil;
import com.msport.clientmaster.view.HomeScrollView;

/**
 * Created by like on 2016/8/22.
 */

public class MyOnScrollYListener implements HomeScrollView.OnScrollGetYListener {
  private   ViewGroup parent;
   private Activity context;
    private int changeY;
    private int tagY;

    public MyOnScrollYListener(ViewGroup parent, Activity context, int changeY, int tagY) {
        this.parent = parent;
        this.context = context;
        this.changeY = changeY;
        this.tagY = tagY;
    }

    @Override
    public void getScrollY(int y) {
        int dertaY = changeY - y;
        int tagHeight = context.getWindowManager().getDefaultDisplay().getHeight() / 5;
        int scrolledHeight = context.getWindowManager().getDefaultDisplay().getHeight() / 6;
        ViewUtil.tagShow(parent, dertaY, tagHeight, tagY);
    }

}