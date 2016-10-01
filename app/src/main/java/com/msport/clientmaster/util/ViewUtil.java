package com.msport.clientmaster.util;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.msport.clientmaster.R;
import com.msport.clientmaster.view.TwoButtomDialog;

import java.util.List;

/**
 * 关于View的工具类
 * Created by like on 2016/7/14.
 */

public class ViewUtil {
    /**
     * 改造listview高度
     *
     * @param listView
     */
    public static void setListViewHeightBasedOnChildren(ListView listView) {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            return;
        }

        int totalHeight = 0;
        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, listView);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight
                + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
    }


    /**
     * 设置作为对应的状态栏显示的颜色
     *
     * @param activity
     * @param color
     */
    public static void setLoginBgcolor(Activity activity, int color) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
            // 设置状态栏透明色
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            View statusView = createStatusView(activity, color);
            // 添加view到对应 的布局中去
            ViewGroup decorView = (ViewGroup) activity.getWindow().getDecorView();
            decorView.addView(statusView);
            // 设置根布局的参数
            ViewGroup rootView = (ViewGroup) ((ViewGroup) activity.findViewById(android.R.id.content)).getChildAt(0);
            rootView.setFitsSystemWindows(true);
            rootView.setClipToPadding(true);
        }


    }

    /**
     * 设置画好的边框和背景
     *
     * @param activity
     * @param color
     */
    private static View createStatusView(Activity activity, int color) {
        // 获得状态栏的高度
        int resId = activity.getResources().getIdentifier("status_bar_height", "dimen", "android");
        int statusHeight = activity.getResources().getDimensionPixelSize(resId);
        // 绘制一样高度的矩形
        View view = new View(activity);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, statusHeight);
        view.setLayoutParams(params);
        view.setBackgroundColor(color);
        return view;

    }


    /**
     * 使状态栏透明
     * <p>
     * 适用于图片作为背景的界面，可将需要的图片填充到状态栏上
     *
     * @param activity
     */
    public static void setTransparencyLucent(Activity activity) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //设置布局参数
            ViewGroup rootView = (ViewGroup) ((ViewGroup) activity.findViewById(android.R.id.content)).getChildAt(0);
            rootView.setFitsSystemWindows(true);
            rootView.setClipToPadding(true);
        }

    }


    /**
     * 建立textView
     *
     * @param vg
     * @param context
     * @param onClickListener
     */
    public static void createTextview(ViewGroup vg, final Context context, List<String> tagList, boolean tagEdit, View.OnClickListener onClickListener, View.OnClickListener textListener) {
        if (vg.getChildCount() > 0)
            vg.removeAllViews();
        for (int i = 0; i < tagList.size(); i++) {
            TextView textView = new TextView(context);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            layoutParams.setMargins(8, 8, 8, 8);
            textView.setLayoutParams(layoutParams);
            textView.setGravity(Gravity.CENTER);
            textView.setPadding(10, 5, 10, 5);
            textView.setText(tagList.get(i));
            textView.setOnClickListener(textListener);
            textView.setBackgroundResource(R.drawable.shape_categroy_tagnone);
            textView.setTextSize(TypedValue.COMPLEX_UNIT_PX, context.getResources().getDimensionPixelSize(R.dimen.size_12));
            textView.setTextColor(ContextCompat.getColor(context, R.color.text_gray_A3));
            if (i == 0) {
                if (tagEdit) {
                    textView.setBackgroundColor(ContextCompat.getColor(context, R.color.bg_gray_EE));
                    textView.setOnClickListener(onClickListener);
                    textView.setTextColor(ContextCompat.getColor(context, R.color.text_black_5c));
                }
            }
            vg.addView(textView);
        }

    }

    public static void updataTextView(ViewGroup vg, Context context, List<String> tagList, View.OnClickListener listener, View.OnClickListener textListener) {
        vg.removeAllViews();
//		createTextview(vg, context, tagList, true, listener, textListener); TODO 保留添加标签功能
        createTextview(vg, context, tagList, false, listener, textListener);
    }


    /**
     * 创建imageview
     *
     * @param context 上下文
     * @param number  创建多少个
     * @param vg      父控件
     */
    public static void createImageView(Context context, int number, ViewGroup vg, String[] imageUrl) {
        int realSize = context.getResources().getDimensionPixelSize(R.dimen.dp_25);
        createImageView(context,number,realSize,vg,imageUrl);
    }

    /**
     * 创建imageview
     * @param context
     * @param number
     * @param size 多大的图片
     * @param vg
     * @param imageUrl
     */
    public static void createImageView(Context context, int number,int size ,  ViewGroup vg, String[] imageUrl){
        if (vg.getChildCount() > 0) {
            vg.removeAllViews();
        }
        int index = 0;
        if (number < 8) index = number;
        else index = 8;
        for (int i = 0; i < index; i++) {
            ImageView imageView = new ImageView(context);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(size, size);
            layoutParams.setMargins(0, 0, size/4, 0);
            imageView.setLayoutParams(layoutParams);
            imageView.setBackgroundResource(R.mipmap.touxiang);
            if (null != imageUrl) {
                String realImgUrl = StringUtil.getRealImgUrl(imageUrl[i]);
                ImageUtil.getNetImage(context, realImgUrl, imageView,R.mipmap.show_img);
            }
            vg.addView(imageView);
        }
        if (index == 8){
            TextView textView = new TextView(context);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(size, size);
            layoutParams.gravity = Gravity.CENTER_HORIZONTAL|Gravity.BOTTOM;
            textView.setText("...");
            textView.setTextColor(ContextCompat.getColor(context,R.color.black));
            vg.addView(textView);
        }
    }




    /**
     * 显示头部
     *
     * @param view
     * @param dertaY
     * @param tagHeight
     * @param tagY
     */
    public static void tagShow(View view, int dertaY, int tagHeight, int tagY) {

        view.getBackground().setAlpha((int) (Math.abs(new Float(dertaY) / new Float(tagHeight)) * 255));
        view.setAlpha(Math.abs(new Float(dertaY) / new Float(tagHeight)));
        if (dertaY < -tagHeight) {
            view.getBackground().setAlpha(255);
            view.setAlpha(1.0f);
            view.setFocusable(true);
        } else if (dertaY >= -tagY) {
            view.getBackground().setAlpha(0);
            view.setAlpha(0f);
            view.setFocusable(false);
        } else {
            view.setFocusable(false);
        }
    }


    /**
     * 创建确定取消弹窗
     *
     * @param context
     * @param title
     * @param positiveCallback
     * @param visible
     */
    public static void createTwoDialog(Context context, String title, String positive, TwoButtomDialog.OnPositiveButtonDialog positiveCallback, boolean visible) {
        TwoButtomDialog dialog = new TwoButtomDialog(context, title, positive, visible);
        dialog.setOnPositiveDialog(positiveCallback);
        dialog.show();
    }


}
