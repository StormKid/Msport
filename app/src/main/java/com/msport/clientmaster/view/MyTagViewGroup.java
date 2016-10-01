package com.msport.clientmaster.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * 标签自定义ViewGroup
 * 
 * @author like 2016-7-11
 */
public class MyTagViewGroup extends ViewGroup {
	
	/** 
     * 存储所有的View，按行记录 
     */  
    private List<List<View>> mAllViews = new ArrayList<List<View>>();  
    /** 
     * 记录每一行的最大高度 
     */  
    private List<Integer> mLineHeight = new ArrayList<Integer>();  
	
	public MyTagViewGroup(Context context) {
		this(context,null);
	}
	
	

	public MyTagViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
	}



	public MyTagViewGroup(Context context, AttributeSet attrs) {
		this(context, attrs,0);
	}



	@SuppressLint("DrawAllocation") @Override
	protected void onLayout(boolean changed, int l, int t, int r, int b) {
		 mAllViews.clear();  
	        mLineHeight.clear();  
	  
	        int width = getWidth();  
	  
	        int lineWidth = 0;  
	        int lineHeight = 0;  
	        // 存储每一行所有的childView  
	        List<View> lineViews = new ArrayList<View>();  
	        int cCount = getChildCount();  
	        // 遍历所有的孩子  
	        for (int i = 0; i < cCount; i++)  
	        {  
	            View child = getChildAt(i);  
	            MarginLayoutParams lp = (MarginLayoutParams) child  
	                    .getLayoutParams();  
	            int childWidth = child.getMeasuredWidth();  
	            int childHeight = child.getMeasuredHeight();  
	  
	            // 如果已经需要换行  
	            if (childWidth + lp.leftMargin + lp.rightMargin + lineWidth > width)  
	            {  
	                // 记录这一行所有的View以及最大高度  
	                mLineHeight.add(lineHeight);  
	                // 将当前行的childView保存，然后开启新的ArrayList保存下一行的childView  
	                mAllViews.add(lineViews);  
	                lineWidth = 0;// 重置行宽  
	                lineViews = new ArrayList<View>();  
	            }  
	            /** 
	             * 如果不需要换行，则累加 
	             */  
	            lineWidth += childWidth + lp.leftMargin + lp.rightMargin;  
	            lineHeight = Math.max(lineHeight, childHeight + lp.topMargin  
	                    + lp.bottomMargin);  
	            lineViews.add(child);  
	        }  
	        // 记录最后一行  
	        mLineHeight.add(lineHeight);  
	        mAllViews.add(lineViews);  
	  
	        int left = 0;  
	        int top = 0;  
	        // 得到总行数  
	        int lineNums = mAllViews.size();  
	       
	        for (int i = 0; i < lineNums; i++)  
	        {  
	            // 每一行的所有的views  
	            lineViews = mAllViews.get(i);  
	            // 当前行的最大高度  
	            lineHeight = mLineHeight.get(i);  
	            // 遍历当前行所有的View  
	            for (int j = 0; j < lineViews.size(); j++)  
	            {  
	                View child = lineViews.get(j);  
	                if (child.getVisibility() == View.GONE)  
	                {  
	                    continue;  
	                }  
	                MarginLayoutParams lp = (MarginLayoutParams) child  
	                        .getLayoutParams();  
	  
	                //计算childView的left,top,right,bottom  
	                int lc = left + lp.leftMargin;  
	                int tc = top + lp.topMargin;  
	                int rc =lc + child.getMeasuredWidth();  
	                int bc = tc + child.getMeasuredHeight();  
	  
	  
	                child.layout(lc, tc, rc, bc);  
	                  
	                left += child.getMeasuredWidth() + lp.rightMargin  
	                        + lp.leftMargin;  
	            }  
	            left = 0;  
	            top += lineHeight;  
	        }  
	  
	}

	/**
	 * 用maggin算法来计算两种对应的布局
	 */
	@Override
	public LayoutParams generateLayoutParams(AttributeSet attrs) {
		return new MarginLayoutParams(getContext(), attrs);
	}

	/**
	 * 根据子控件的大小来实现自动换行
	 */
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		// 获取父容器为它设置的测量大小
		int sizeWidth = MeasureSpec.getSize(widthMeasureSpec);
		int sizeHeight = MeasureSpec.getSize(heightMeasureSpec);
		// 获取父容器的设置的测量模式
		int modeWidth = MeasureSpec.getMode(widthMeasureSpec);
		int modeHeight = MeasureSpec.getMode(heightMeasureSpec);

		// warpcontent情况下记录宽高
		int width = 0;
		int height = 0;

		// 记录每一行宽度，添加进viewGroup里面
		int lineWidth = 0;

		// 记录每一行高度，添加进ViewGroup里面
		int lineHeight = 0;

		// 获取子控件
		int childCount = getChildCount();

		// 遍历每个子元素
		for (int i = 0; i < childCount; i++) {
			View child = getChildAt(i);
			// 测量每一个child的宽和高
			measureChild(child, widthMeasureSpec, heightMeasureSpec);
			// 得到child的lp
			MarginLayoutParams lp = (MarginLayoutParams) child
					.getLayoutParams();
			// 当前子空间实际占据的宽度
			int childWidth = child.getMeasuredWidth() + lp.leftMargin
					+ lp.rightMargin;
			// 当前子空间实际占据的高度
			int childHeight = child.getMeasuredHeight() + lp.topMargin
					+ lp.bottomMargin;
			/**
			 * 如果加入当前child，则超出最大宽度，则的到目前最大宽度给width，类加height 然后开启新行
			 */
			if (lineWidth + childWidth > sizeWidth) {
				width = Math.max(lineWidth, childWidth);// 取最大的
				lineWidth = childWidth; // 重新开启新行，开始记录
				// 叠加当前高度，
				height += lineHeight;
				// 开启记录下一行的高度
				lineHeight = childHeight;
			} else
			// 否则累加值lineWidth,lineHeight取最大高度
			{
				lineWidth += childWidth;
				lineHeight = Math.max(lineHeight, childHeight);
			}
			// 如果是最后一个，则将当前记录的最大宽度和当前lineWidth做比较
			if (i == childCount - 1) {
				width = Math.max(width, lineWidth);
				height += lineHeight;
			}
		}
		 setMeasuredDimension((modeWidth == MeasureSpec.EXACTLY) ? sizeWidth  
	                : width, (modeHeight == MeasureSpec.EXACTLY) ? sizeHeight  
	                : height);  
	}
	
}
