package com.msport.clientmaster.fragment;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ListView;
import android.widget.TextView;

import com.msport.clientmaster.R;
import com.msport.clientmaster.adapter.MyCripsAdapter;
import com.msport.clientmaster.adapter.MySingleTextAdapter;
import com.msport.clientmaster.adapter.VanueAddressSingleChooseAdapter;
import com.msport.clientmaster.bean.CoachLocationBean;
import com.msport.clientmaster.callback.MainCallback;
import com.msport.clientmaster.constants.Constant;
import com.msport.clientmaster.constants.HttpConstant;
import com.msport.clientmaster.entity.CripEntity;
import com.msport.clientmaster.intef.MyViewCallback;
import com.msport.clientmaster.requestbean.JiufenRequestBean;
import com.msport.clientmaster.util.CustomToast;
import com.msport.clientmaster.util.PublicPreferencesUtils;
import com.msport.clientmaster.util.Tools;

import org.simple.eventbus.EventBus;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Response;

/**
 * 选择地点与选择优惠券弹出页面
 * Created by user on 2016/8/11.
 */
@SuppressLint("ValidFragment")
public class OrderButtomFragment extends DialogFragment implements MyViewCallback, View.OnClickListener {
    private int layout;
    private CoachLocationBean coachLocationBean;
    private int layoutid;
    private String type;
    private ListView pop_container;
    private TextView pop_introduce;
    private TextView pop_title;
    private View pop_can;
    private View pop_cancel;
    private final MainCallback callback;
    private Context context;
    private String coursetype;
    private String amount;
    private MySingleTextAdapter mySingleTextAdapter;
    private String content;
    private CripEntity.DataBean cripsBean;
    private TextView pop_none_contain;
    private String Realaddress;
    private final int WRITE_EXTERNAL_STORAGE_REQUEST_CODE = 102;
    private final int WRITE_EXTERNAL_CAMARE_REQUEST_CODE = 103;
    private final int getPictureCode = 104;
    private final int getCamareCode = 105;
    private Bitmap bitmap;
    private Handler hanlder = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == Constant.PHOTO_FINISH){
                EventBus.getDefault().post("123",Constant.PHOTO_FINISH+"");
                dismiss();
            }


        }
    };
    public OrderButtomFragment(int layout, String type, Context context) {
        this(layout, type, context, null, null);
    }


    public OrderButtomFragment(int layout, String type, Context context, CoachLocationBean coachLocationBean) {
        this(layout, type, context, null, null);
        this.coachLocationBean = coachLocationBean;
    }

    /**
     * 带参构造
     *
     * @param layout
     * @param type
     * @param coursetype
     */
    public OrderButtomFragment(int layout, String type, Context context, String coursetype, String Amount) {
        callback = new MainCallback(this, context);
        this.layoutid = layout;
        this.type = type;
        this.context = context;
        this.coursetype = coursetype;
        this.amount = Amount;
    }


    @Override
    public void onStart() {
        EventBus.getDefault().register(this);
        super.onStart();
    }

    @Override
    public void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = new Dialog(getActivity(), R.style.CustomDatePickerDialog);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); // must be called before set content
        dialog.setContentView(layoutid);
        dialog.setCanceledOnTouchOutside(true);
        // 设置宽度为屏宽、靠近屏幕底部。
        Window window = dialog.getWindow();
        WindowManager.LayoutParams wlp = window.getAttributes();
        wlp.width = WindowManager.LayoutParams.MATCH_PARENT;
        wlp.gravity = Gravity.BOTTOM;
        window.setAttributes(wlp);
        initEvent(dialog);
        return dialog;
    }

    private void initEvent(final Dialog dialog) {
        MainCallback callback = new MainCallback(this, context);
        switch (layoutid) {
            case R.layout.choose_pop_bottom:
                pop_can = dialog.findViewById(R.id.pop_can);
                pop_cancel = dialog.findViewById(R.id.pop_cancel);
                pop_container = (ListView) dialog.findViewById(R.id.pop_container);
                pop_introduce = (TextView) dialog.findViewById(R.id.pop_introduce);
                pop_title = (TextView) dialog.findViewById(R.id.pop_title);
                pop_none_contain = (TextView) dialog.findViewById(R.id.pop_none_contain);
                View contain_alls = dialog.findViewById(R.id.contain_alls);
                contain_alls.setBackgroundColor(ContextCompat.getColor(context,R.color.white));
                if (type.equals(Constant.LOCATION)) {
                    pop_introduce.setText("每笔订单只能选择一个场馆");
                    pop_title.setText("请现在选择上课地点");
                    if (TextUtils.isEmpty(coachLocationBean.vanueAddress) || TextUtils.isEmpty(coachLocationBean.vanueLocation)) {
                        pop_none_contain.setText("您选择的私教尚未有地址");
                        pop_none_contain.setVisibility(View.VISIBLE);
                        return;
                    }
                    pop_none_contain.setVisibility(View.GONE);
                    String vanueLocation = coachLocationBean.vanueLocation;
                    String vanueAddress = coachLocationBean.vanueAddress;
                    String[] vanueAddressList = vanueAddress.split(",");
                    String[] vanueLocationList = vanueLocation.split(",");
                    VanueAddressSingleChooseAdapter addressSingleChooseAdapter = new VanueAddressSingleChooseAdapter(context, vanueLocationList, vanueAddressList);
                    pop_container.setAdapter(addressSingleChooseAdapter);
                    addressSingleChooseAdapter.setgetLocationMethod(new VanueAddressSingleChooseAdapter.getLocationMethod() {
                        @Override
                        public void getLocation(String vanueLocation, String address) {
                            Realaddress = vanueLocation+","+address;
                        }
                    });

                } else if (type.equals(Constant.YOUHUIQUAN)) {
                    pop_introduce.setText("每笔订单只能使用一张优惠卷");
                    pop_title.setText("请现在要使用的优惠卷");
                    String memberId = PublicPreferencesUtils.getString(context, Constant.NUTZER_ID);
                    callback.getUsingTypeCrips(memberId, coursetype, amount);

                } else if (type.equals(Constant.ACTIVITY_JIUFEN)) {
                    pop_title.setText("请您选择纠纷问题");
                    pop_introduce.setText("我们会在你第一时间联系您");
                    List<String> arrays = new ArrayList<>();
                    arrays.add("没按照说明待遇对待");
                    arrays.add("组织者没有预定场地");
                    arrays.add("找不到组织者");
                    arrays.add("意外事故说明");
                    arrays.add("临时收费");
                    arrays.add("其他问题");
                    mySingleTextAdapter = new MySingleTextAdapter(arrays, context);
                    pop_container.setAdapter(mySingleTextAdapter);
                    mySingleTextAdapter.setOnSetText(new MySingleTextAdapter.OnSetTextListener() {
                        @Override
                        public void onSetText(String result) {
                            content = result;
                        }
                    });
                }

                pop_cancel.setOnClickListener(this);
                pop_can.setOnClickListener(this);


                break;
            case R.layout.my_pop_camareview:
                View cancel = dialog.findViewById(R.id.camera_cancel);
                View paizhao = dialog.findViewById(R.id.camera_one);
                View xiangche = dialog.findViewById(R.id.camera_two);
                cancel.setOnClickListener(this);
                paizhao.setOnClickListener(this);
                xiangche.setOnClickListener(this);
                break;

        }

    }

    @Override
    public void viewMode(Response res, String tag) {

        if (tag.equals(HttpConstant.addJiufen)) {
            CustomToast.createToast().showSuccess(context, "发起成功，客服人员会在3天之内为您解决纠纷");
            dismiss();
            EventBus.getDefault().post("", Constant.ACTIVITY_FINISH);
        } else if (tag.equals(HttpConstant.getUsingTypeCrips)) {
            CripEntity entity = (CripEntity) res.body();
            List<CripEntity.DataBean> data = entity.getData();
            if (data.size() == 0 || null == data) {
                pop_none_contain.setText("暂时没有可用的优惠券");
                pop_none_contain.setVisibility(View.VISIBLE);
            } else {
                pop_none_contain.setVisibility(View.GONE);
                MyCripsAdapter adapter = new MyCripsAdapter(context, data);
                pop_container.setAdapter(adapter);
                adapter.setOnChooseMyCripsListener(new MyCripsAdapter.OnChooseMyCripsListener() {
                    @Override
                    public void onChoose(CripEntity.DataBean bean, int position) {
                        cripsBean = bean;
                    }
                });
            }

        }


    }

    @Override
    public void getFalse(boolean tag, String message) {
        if (message.equals(HttpConstant.addJiufen)) {
            CustomToast.createToast().showFaild(context, "网络链接不给力，请重新获取数据");
            dismiss();
        }
    }

    @Override
    public void showCode(int code, String string) {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.pop_cancel:
                dismiss();
                break;
            case R.id.pop_can:
                if (type.equals(Constant.LOCATION)&&null!=Realaddress) {
                    EventBus.getDefault().post(Realaddress, Constant.COACH_LOCATION);
                    dismiss();
                } else if (type.equals(Constant.YOUHUIQUAN)) {
                    if (cripsBean != null)
                        EventBus.getDefault().post(cripsBean, Constant.CRIPS);
                    dismiss();
                } else if (type.equals(Constant.ACTIVITY_JIUFEN)) {

                    if (!TextUtils.isEmpty(content)) {
                        JiufenRequestBean bean = new JiufenRequestBean();
                        String memberId = PublicPreferencesUtils.getString(context, Constant.NUTZER_ID);
                        String activityId = PublicPreferencesUtils.getString(context, Constant.ACTIVITY_ID);
                        bean.setName(content);
                        bean.setInviteActiveId(activityId);
                        bean.setMemberid(memberId);
                        callback.addJiufen(bean);
                    }

                }
                break;
            case R.id.camera_one://拍照
                checkCamare();
                break;
            case R.id.camera_two://相册
                checkStorage();
                break;
            case R.id.camera_cancel:
                dismiss();
                break;
        }
    }


    private void checkStorage() { // 申请相册权限
        if (ContextCompat.checkSelfPermission(context, Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                    WRITE_EXTERNAL_STORAGE_REQUEST_CODE);
        } else {
            getPhoto();
        }
    }


    private void checkCamare() { // 申请拍照权限
        if (ContextCompat.checkSelfPermission(context, Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.CAMERA},
                    WRITE_EXTERNAL_CAMARE_REQUEST_CODE);
        } else {
            getCamera();
        }
    }


    private void getCamera() {
        Intent camera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(camera, getCamareCode);
    }

    private void getPhoto() {
        Intent intent = new Intent(
                Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, getPictureCode);
    }


    //动态申请照相权限：
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        if (requestCode == WRITE_EXTERNAL_CAMARE_REQUEST_CODE) {//拍照

            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
              getCamera();
            } else {
                CustomToast.createToast().showFaild(context,"请打开权限，上传图像");
            }


        } else if (requestCode == WRITE_EXTERNAL_STORAGE_REQUEST_CODE) {//相册
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
               getPhoto();
            } else {
                CustomToast.createToast().showFaild(context,"请打开权限，上传图像");
            }

        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);


    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent result) {
        super.onActivityResult(requestCode, resultCode, result);

        if (requestCode == getPictureCode && resultCode == Activity.RESULT_OK
                && null != result) {
            Uri selectedImage = geturi(result);
            String[] filePathColumns = {MediaStore.Images.Media.DATA};
            ContentResolver contentResolver = context.getContentResolver();
            Cursor cursor = contentResolver.query(selectedImage, filePathColumns, null, null, null);
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex(filePathColumns[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close();
            File file = new File(picturePath);
            Tools.uploadFile(context, file,hanlder);


        } else if (requestCode == getCamareCode
                && resultCode == Activity.RESULT_OK && null != result) {
            Bundle extras = result.getExtras();
            bitmap = (Bitmap) extras.get("data");
            Tools.savePhoto(bitmap, context, hanlder);
        } else {
            CustomToast.createToast().showFaild(context, "获取头像失败");
        }


    }


    public Uri geturi(android.content.Intent intent) {
        Uri uri = intent.getData();
        String type = intent.getType();
        if (uri.getScheme().equals("file") && (type.contains("image/"))) {
            String path = uri.getEncodedPath();
            if (path != null) {
                path = Uri.decode(path);
                ContentResolver cr = context.getContentResolver();
                StringBuffer buff = new StringBuffer();
                buff.append("(").append(MediaStore.Images.ImageColumns.DATA).append("=")
                        .append("'" + path + "'").append(")");
                Cursor cur = cr.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                        new String[] { MediaStore.Images.ImageColumns._ID },
                        buff.toString(), null, null);
                int index = 0;
                for (cur.moveToFirst(); !cur.isAfterLast(); cur.moveToNext()) {
                    index = cur.getColumnIndex(MediaStore.Images.ImageColumns._ID);
                    index = cur.getInt(index);
                }
                if (index == 0) {
                } else {
                    Uri uri_temp = Uri
                            .parse("content://media/external/images/media/"
                                    + index);
                    if (uri_temp != null) {
                        uri = uri_temp;
                    }
                }
            }
        }
        return uri;
    }


}
