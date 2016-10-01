package com.msport.clientmaster.intef;

import retrofit2.Response;

/**
 * Created by like on 2016/7/4.
 * 动态接口，用于传输类
 */

public interface MyViewCallback {
    /**
     * view显示的接口，用于动态切换
     * @param tag 区分多链接的
     * @param res
     */
    void viewMode(Response res, String tag);


    /**
     * 如果请求失败，tag为true，提示失败的信息
     *
     * @param tag
     * @param message type 用来判断来的是什么链接
     */
    void getFalse(boolean tag, String message);

    /**
     * 请求回来的code
     * 用于测试判断内容显示弹窗
     * @param code
     * @param string
     */
    void showCode(int code, String string);
}
