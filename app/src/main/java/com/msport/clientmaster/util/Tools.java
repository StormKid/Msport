package com.msport.clientmaster.util;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Environment;
import android.os.Handler;

import com.msport.clientmaster.activity.LoginActivity;
import com.msport.clientmaster.bean.ShareBean;
import com.msport.clientmaster.callback.MainCallback;
import com.msport.clientmaster.constants.Constant;
import com.msport.clientmaster.constants.HttpConstant;
import com.msport.clientmaster.entity.PhotoEntity;
import com.msport.clientmaster.intef.MyViewCallback;
import com.msport.clientmaster.view.MProgressDialog;
import com.msport.clientmaster.view.TwoButtomDialog;
import com.umeng.socialize.Config;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Response;

/**
 * Created by like on 2016/8/6.
 */

public class Tools {



    /**
     * 数组变集合
     * @return
     */
    public static List<String> getList(String[] data){
        List<String> list = new ArrayList<>();
        for (String value:
             data) {
            list.add(value);
        }
        return list;

    }


    /**
     * 集合变数组
     */
    public static String[] getArray(List<String> list){
        String[] arrays  = new String[list.size()];
        String[] array = list.toArray(arrays);
        return array;
    }


    /**
     * 获取课程type列表
     */
    public static Map<String,String> getCourseType(){
        Map<String,String> map = new HashMap<>();
        map.put("1","游泳");
        map.put("3","瑜伽");
        map.put("4","羽毛球");
        map.put("5","网球");
        map.put("5","舞蹈");
        return map;

    }

    /**
     * 单独的分享
     * @param context
     * @param share
     * @param umShareListener
     * @param type
     */
    public static void toShare(Activity context, ShareBean share, UMShareListener umShareListener, SHARE_MEDIA type){
        MProgressDialog progressDialog = new MProgressDialog(context);
        Config.dialog = progressDialog;
        new ShareAction(context).setPlatform(type).setCallback(umShareListener)
                .withText(share.content)
                .withMedia(share.image)
                .withTitle(share.title)
                .withTargetUrl(share.url)
                .share();
    }


    /**
     * 调用全部分享按钮
     * @param context
     */
    public static ShareAction showShare(Activity context){

        ShareAction shareAction = new ShareAction(context);
        shareAction.setDisplayList(SHARE_MEDIA.WEIXIN,SHARE_MEDIA.WEIXIN_CIRCLE,SHARE_MEDIA.QQ,SHARE_MEDIA.QZONE,SHARE_MEDIA.SMS);
        return shareAction;
    }

    /**
     * 存储时，获得相册的名字
     * @return
     */
    @SuppressLint("SimpleDateFormat")
    public static String getPhotoName(){
        String fileName = "";
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
        String time = dateFormat.format(date);
        fileName = "IMG_"+time+".png";
        return fileName;
    }

    /**
     * 判斷是否有相關的存儲地址
     */
    @SuppressLint("NewApi")
    public static void savePhoto(Bitmap photo, Context context, Handler hanlder){

        String photoName = getPhotoName();
        if (android.os.Environment.getExternalStorageState().equals(android.os.Environment.MEDIA_MOUNTED)) {
            String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath()+ Constant.MY_PATH;
            File dir = new File(absolutePath);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            File file = new File(absolutePath,photoName);
            outputFile(photo, file, context, hanlder);
        }else{
            String path = context.getCacheDir().getAbsolutePath()+Constant.MY_PATH;
            File dir = new File(path);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            File file = new File(path,photoName);
            outputFile(photo, file, context, hanlder);
        }


    }


    /**
     * 保存文件
     * @param photo
     * @param file
     * @param context
     * @param hanlder
     */
    public static void outputFile(Bitmap photo, File file, Context context, Handler hanlder){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            if (photo!=null) {
                if (photo.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream)) {
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    uploadFile(context, file , hanlder);
                }else{
                    fileOutputStream.close();
                }
            }else{
                fileOutputStream.close();
            }
        } catch (Exception e) {
            file.delete();
            CustomToast.createToast().showFaild(context,"保存文件失败");
        }
    }

    public static void uploadFile(final Context context, File file, Handler handler){
        RequestBody requestBody =
                RequestBody.create(MediaType.parse("multipart/form-data"), file);
        String path = file.getPath();
        MainCallback callback = new MainCallback(new MyViewCallback() {
            @Override
            public void viewMode(Response res, String tag) {
                PhotoEntity entity = (PhotoEntity) res.body();
                String url = entity.getData();
                CustomToast.createToast().showSuccess(context,"头像上传成功");
                String realImgUrl = HttpConstant.IMG_MAIN+url;
                LogUtils.e("imgUrl" , realImgUrl);
                PublicPreferencesUtils.putString(context,Constant.NUTZER_PHOTOURL,realImgUrl);

            }

            @Override
            public void getFalse(boolean tag, String message) {
                CustomToast.createToast().showFaild(context,"上传图像失败，请检查网络连接");

            }

            @Override
            public void showCode(int code, String string) {

            }
        }, context);
        callback.upPhoto(requestBody,path);

    }



    /**
     * 获取程序app标准版本号信息
     */
    public static String getAppVersion(Context context){

        PackageManager packageManager = context.getPackageManager();
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
            String versionName = packageInfo.versionName;
            return versionName;

        } catch (PackageManager.NameNotFoundException e) {
            return "";
        }



    }

    /**
     * 判断是否登陆
     * @param context
     * @param clazz
     */
    public static void checkMember(final Context context, Class<?> clazz) {
        boolean userFirst = PublicPreferencesUtils.getBoolean(context, Constant.USER_FIRST);
        if (userFirst) {// true 为登陆了，false为未登陆
            Intent intent = new Intent(context, clazz);
           context.startActivity(intent);
        } else {
            ViewUtil.createTwoDialog(context, "您还尚未登陆，是否登陆", "确定", new TwoButtomDialog.OnPositiveButtonDialog() {
                @Override
                public void positiveMethod() {
                    Intent intent = new Intent();
                    intent.setClass(context, LoginActivity.class);
                    context.startActivity(intent);
                }
            }, true);

        }
    }

}
