package com.msport.clientmaster.util;

import android.annotation.SuppressLint;
import android.text.TextUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * TimeUtils
 * 
 * @author <a href="http://www.trinea.cn" target="_blank">Trinea</a> 2013-8-24
 */
@SuppressLint("SimpleDateFormat")
public class TimeUtils {

	public static final SimpleDateFormat DEFAULT_DATE_FORMAT = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");
	public static final SimpleDateFormat DATE_FORMAT_DATE = new SimpleDateFormat(
			"yyyy-MM-dd");
	public static final SimpleDateFormat DATE_FORMAT_DATE_ = new SimpleDateFormat(
			"yyyy年MM月dd日 HH:mm");
	public static final SimpleDateFormat DATE_FORMAT_DATE_HOUR_MIN = new SimpleDateFormat(
			"HH:mm");
	private static SimpleDateFormat DATE_FORMAT_DATE_D = new SimpleDateFormat("MM月dd日 HH:mm");

	private TimeUtils() {
		throw new AssertionError();
	}

	/**
	 * long time to string
	 * 
	 * @param timeInMillis
	 * @param dateFormat
	 * @return
	 */
	public static String getTime(long timeInMillis, SimpleDateFormat dateFormat) {
		return dateFormat.format(new Date(timeInMillis));
	}

	/**
	 * long time to string, format is {@link #DEFAULT_DATE_FORMAT}
	 * 
	 * @param timeInMillis
	 * @return
	 */
	public static String getTime(long timeInMillis) {
		return getTime(timeInMillis, DEFAULT_DATE_FORMAT);
	}


	public static String getTime(String timeInMillis){
		if (TextUtils.isEmpty(timeInMillis))
			return "";
		long parseLong = Long.parseLong(timeInMillis);
		return getTime(parseLong,DATE_FORMAT_DATE_);
	}

	public static String getTime(String timeInMillis,boolean isHinthour){
		if (TextUtils.isEmpty(timeInMillis))
			return "";
		long parseLong = Long.parseLong(timeInMillis);
		return getTime(parseLong, DATE_FORMAT_DATE_D);
	}


	public static String getTimeDate(String timeInMillis) {
		if (TextUtils.isEmpty(timeInMillis))
			return "";
		long parseLong = Long.parseLong(timeInMillis);
		return getTime(parseLong, DATE_FORMAT_DATE);
	}

	public static String getRealTime(String time){
		String[] split = time.split("\\.");
		String timereal = split[0];
		return timereal;
	}


	public static String  getTime(String startTime , String endTime){
		if (TextUtils.isEmpty(startTime)||TextUtils.isEmpty(endTime)){
			return "";
		}
		long parseStart = Long.parseLong(startTime);
		long parseEnd = Long.parseLong(endTime);
        String startHour = getTime(parseStart, DATE_FORMAT_DATE_HOUR_MIN);
        String endHour = getTime(parseEnd, DATE_FORMAT_DATE_HOUR_MIN);
        return startHour+" - "+endHour;
    }

	public static String  getTimeDate(String startTime , String endTime){
		if (TextUtils.isEmpty(startTime)||TextUtils.isEmpty(endTime)){
			return "";
		}
        Date startHour = null;
        Date endHour = null;
        try {
            startHour = DATE_FORMAT_DATE.parse(startTime);
            endHour = DATE_FORMAT_DATE.parse(endTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return getTime(startHour.getTime()+"",endHour.getTime()+"");
	}

	public static String  getTimeDateReal(String startTime){
		if (TextUtils.isEmpty(startTime)){
			return "";
		}
		Date startDate = null;
		try {
			 startDate = DATE_FORMAT_DATE.parse(startTime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
        long time = startDate.getTime();
        String dateTime = getTimeDate(time + "");
        return dateTime;
	}


	/**
	 * get current time in milliseconds
	 * 
	 * @return
	 */
	public static long getCurrentTimeInLong() {
		return System.currentTimeMillis();
	}

	/**
	 * get current time in milliseconds, format is {@link #DEFAULT_DATE_FORMAT}
	 * 
	 * @return
	 */
	public static String getCurrentTimeInString() {
		return getTime(getCurrentTimeInLong());
	}

	/**
	 * get current time in milliseconds
	 * 
	 * @return
	 */
	public static String getCurrentTimeInString(SimpleDateFormat dateFormat) {
		return getTime(getCurrentTimeInLong(), dateFormat);
	}

	/**
	 * get current data time based on give pattern: yyyyMMdd_HHmmss
	 * 
	 * @param pattern
	 * @return
	 */
	public static String getCurrentDate(String pattern) {
		String currentDate = null;
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		currentDate = format.format(new Date());
		return currentDate;
	}

	/**
	 * 获取两个时间差
	 * 
	 * @param d1
	 * @param d2
	 * @return
	 */
	public TimeItem getTimeCha(Date d1, Date d2) {
		long l = d1.getTime() - d2.getTime();
		long day = l / (24 * 60 * 60 * 1000);
		long hour = (l / (60 * 60 * 1000) - day * 24);
		long min = ((l / (60 * 1000)) - day * 24 * 60 - hour * 60);
		long s = (l / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
		TimeItem item = new TimeItem();
		item.day = day;
		item.hour = hour;
		item.min = min;
		item.s = s;
		return item;
	}

	class TimeItem {
		public int pos;
		public long day;
		public long hour;
		public long min;
		public long s;
	}

	/**
	 * 计算闰年与时间月份对应的日期
	 */
	public static List<String> getDataForDay(String chooseYear,
			String chooseMonth) {
		List<String> listDay = new ArrayList<>();
		String mounth = chooseMonth.substring(0, 2);
		String year = chooseYear.substring(0, 4);
		switch (mounth) {
		case "04":
		case "06":
		case "09":
		case "11":
			if (listDay.size() > 0) {
				listDay.clear();
			}
			for (int i = 1; i <= 30; i++) {
				if (i<10) {
					listDay.add("0"+i + "日");	
				}else{
					listDay.add(i + "日");
				}
			}

			return listDay;
		case "02":
			if (listDay.size() > 0) {
				listDay.clear();
			}
			if (isLeapYear(year)) {
				for (int i = 1; i <= 29; i++) {
					if (i<10) {
						listDay.add("0"+i + "日");	
					}else{
						listDay.add(i + "日");
					}
				}
				return listDay;
			} else {
				for (int i = 1; i <= 28; i++) {
					if (i<10) {
						listDay.add("0"+i + "日");	
					}else{
						listDay.add(i + "日");
					}
				}
				return listDay;
			}
			
		}
		if (listDay.size() > 0) {
			listDay.clear();
		}
		for (int i = 1; i <= 31; i++) {
			if (i<10) {
				listDay.add("0"+i + "日");	
			}else{
				listDay.add(i + "日");
			}
		}

		return listDay;

	}

	/**
	 * 判断是否润年
	 * 
	 * 
	 * @param
	 * @return
	 */
	private static boolean isLeapYear(String out_year) {
		/*
		 * 详细设计： 1.被400整除是闰年，否则： 2.不能被4整除则不是闰年 3.能被4整除同时不能被100整除则是闰年
		 * 3.能被4整除同时能被100整除则不是闰年
		 */
		int year = Integer.parseInt(out_year);
		if ((year % 400) == 0)
			return true;
		else if ((year % 4) == 0) {
			return (year % 100) != 0;
		} else
			return false;
	}

	/**
	 * 获得年月日毫秒
	 * @param time
	 * @return
	 */
	public static long getLongValueTime(String time){
		if (time==null||TextUtils.isEmpty(time)) {
			return 0 ;
		}
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = format.parse(time);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date.getTime();
	}
	/**
	 * 获得年月日时分秒毫秒
	 * @param time
	 * @return
	 */
	public static long getLongValueHour(String time){
		if (time==null||TextUtils.isEmpty(time)) {
			return 0 ;
		}
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date date = null;
		try {
			date = format.parse(time);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date.getTime();
	}
	/**
	 * 获得天与月份
	 * @param time
	 * @return
	 */
	public static String getValueDayMounth(String time){
		if (time==null||TextUtils.isEmpty(time)) {
			return "" ;
		}
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = format.parse(time);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String day = date.getDate()<10?"0"+date.getDate():date.getDate()+"";
		int realMonth = date.getMonth()+1;
		return realMonth+"-"+day;
	}
	/**
	 * 获得天与月份
	 * @param time
	 * @return
	 */
	public static String getDayMounth(long time){
		String value = String.valueOf(time);
		if (value==null||TextUtils.isEmpty(value)) {
			return "" ;
		}

		Date date = new Date(time);
		String day = date.getDate()<10?"0"+date.getDate():date.getDate()+"";
		int realMonth = date.getMonth()+1;
		return realMonth+"月"+day+"日";
	}
	public static String getDayMounth(String time){
		if (time==null||TextUtils.isEmpty(time)) {
			return "" ;
		}

		Date date = new Date(time);
		String day = date.getDate()<10?"0"+date.getDate():date.getDate()+"";
		int realMonth = date.getMonth()+1;
		return realMonth+"月"+day+"日";
	}

	/**
	 * 日期转成星期
	 */
	public static String getFullDateWeekTime(String sDate){
		try{
		String formater = "yyyy-MM-dd HH:mm";
		SimpleDateFormat format = new SimpleDateFormat(formater);
		Date date=format.parse(sDate);
		format.applyPattern("E");
		return format.format(date);
		}catch(Exception ex){
		
		return "";
		}
		}
	
	
	/**
	 * 获得时分
	 * @param startTime
	 * @return
	 */
	public static int getTimeString(String startTime){
		if (startTime==null||TextUtils.isEmpty(startTime)) {
			return 0 ;
		}
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date startValue = null;
		try {
			startValue = format.parse(startTime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return startValue.getHours();
	}
	
	
	/**
	 * 获得时分
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public static String getTimeString(String startTime , String endTime){
		if (startTime==null||TextUtils.isEmpty(startTime)) {
			return "" ;
		}
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date startValue = null;
		Date endValue = null;
		try {
			startValue = format.parse(startTime);
			endValue = format.parse(endTime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return startValue==null?"":startValue.getHours()+":"+getFormatTime(startValue.getMinutes())+"-"+endValue.getHours()+":"+getFormatTime(endValue.getMinutes());
	}
	
	private static String getFormatTime(int time){
		String realTime = "";
		if (time < 10) {
			realTime = "0"+time;
		}else {
			realTime = time+"";
		}
		return realTime;
	}


	public long getAfter24Hour(long preTime){
		long partTime = 24*60*60*1000;
		long resultTime = preTime + partTime;
		return resultTime;
	}


}
