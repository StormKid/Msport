package com.msport.clientmaster.util;

import android.util.Log;

/**
 * 土司工具类
 * @author like
 * 2016-5-17
 */
public class LogUtils {
	private static boolean isLogOpen = true;

	public static boolean isLogOpen() {
		return isLogOpen;
	}

	public static void setLogOpen(boolean isLogOpen) {
		LogUtils.isLogOpen = isLogOpen;
	}

	public static void i(String tag, String msg) {
		if (isLogOpen) {
			Log.i(tag, msg == null ? "null" : msg.toString());
		}
	}

	public static void i(String tag, Object msg) {
		if (isLogOpen) {
			Log.i(tag, msg == null ? "null" : msg.toString());
		}
	}

	public static void i(String tag, int msg) {
		if (isLogOpen) {
			Log.i(tag, String.valueOf(msg));
		}
	}

	public static void e(String tag, String msg) {
		if (isLogOpen) {
			Log.e(tag, msg == null ? "null" : msg.toString());
		}
	}

	public static void e(String tag, Object msg) {
		if (isLogOpen) {
			Log.e(tag, msg == null ? "null" : msg.toString());
		}
	}

	public static void e(String tag, int msg) {
		if (isLogOpen) {
			Log.e(tag, String.valueOf(msg));
		}
	}

	public static void d(String tag, String msg) {
		if (isLogOpen) {
			Log.d(tag, msg);
		}
		
	}
}
