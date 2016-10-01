package com.msport.clientmaster.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.ImageView;

import com.msport.clientmaster.R;
import com.msport.clientmaster.constants.Constant;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;

/**
 * Created by like on 2016/7/7.
 */

public class ImageUtil {
    /**
     * 自设定站位图的工具类
     * @param context 上下文
     * @param url 图片地址
     * @param iv 目标显示的ImageView
     * @param drawable 自定义站位图的图片地址
     */
    public static void getNetImage(Context context, String url, ImageView iv, int drawable){
        if (!TextUtils.isEmpty(url))
        Picasso.with(context).load(url).fit().placeholder(drawable).error(drawable).into(iv);
    }


    /**
     * 固定占位图的工具类
     * @param context
     * @param url
     * @param iv
     */
    public static void getNetImage(Context context,String url,ImageView iv){
        getNetImage(context,url,iv, R.mipmap.show_img);
    }


    /**
     * 加载本地图片的工具类
     * @param context
     * @param drawable  目标图片的地址
     * @param iv  显示图片的ImageView
     */
    public static void getCacheImage(Context context,int drawable,ImageView iv){
        Picasso.with(context).load(drawable).fit().into(iv);
    }


    /**
     * 获取裁剪的图片
     * @param context
     * @param uri  图片的地址
     * @param dups 缩小的多少倍数
     */
    public static void getImgCrop(Context context, String uri,int dups,ImageView iv){
        if (!TextUtils.isEmpty(uri))
        Picasso.with(context).load(uri).transform(new CropSquare(dups)).placeholder(R.mipmap.show_img).error(R.mipmap.show_img).into(iv);
    }

    /**
     * 剪裁内部类
     */
    private static class CropSquare implements Transformation{

        private int dups;
        private static CropSquare done;

        public static CropSquare getInstance(int dups) {
            if(done==null){
                done = new CropSquare(dups);
            }
            return done;
        }

        private CropSquare(int dups){
            this.dups = dups;
        }


        @Override
        public Bitmap transform(Bitmap source) {
            int size = Math.min(source.getWidth(),source.getHeight());
            int resultX = (source.getWidth()-size)/dups;
            int resultY = (source.getHeight()-size)/dups;
            Bitmap result = Bitmap.createBitmap(source,resultX,resultY,size,size);
            if (result!=source){
                source.recycle();//释放资源
            }
            return result;
        }

        @Override
        public String key() {
            return Constant.SCORPE_IMG;
        }
    }


}
