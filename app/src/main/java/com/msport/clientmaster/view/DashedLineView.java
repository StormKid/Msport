package com.msport.clientmaster.view;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;

import com.msport.clientmaster.R;

/**
 * Created by like on 2016/8/12.
 */

public class DashedLineView extends View {

    private Context context;

    public DashedLineView(Context context, AttributeSet attrs) {
        super(context, attrs);

        this.context = context;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        // TODO Auto-generated method stub
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(ContextCompat.getColor(context, R.color.line_bg_d9));//颜色可以自己设置
        Path path = new Path();
        path.moveTo(0, 0);//起始坐标
        path.lineTo(0,500);//终点坐标
        PathEffect effects = new DashPathEffect(new float[]{8,8,8,8},1);//设置虚线的间隔和点的长度
        paint.setPathEffect(effects);
        canvas.drawPath(path, paint);
    }
}