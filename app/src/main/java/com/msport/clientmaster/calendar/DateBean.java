package com.msport.clientmaster.calendar;

public class DateBean implements Comparable<DateBean>{

	private long keyValue ;
	private String weekend;
	private String day;
	private String mounth;
	
	public long getKeyValue() {
		return keyValue;
	}
	public void setKeyValue(long keyValue) {
		this.keyValue = keyValue;
	}
	public String getWeekend() {
		return weekend;
	}
	public void setWeekend(String weekend) {
		this.weekend = weekend;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getMounth() {
		return mounth;
	}
	public void setMounth(String mounth) {
		this.mounth = mounth;
	}
	@Override
	public int compareTo(DateBean another) {
		if (another!=null) {
		if (this.keyValue<another.getKeyValue()) {
			return -1;
		}else if (this.keyValue==another.getKeyValue()) {
			return 0;
		}else if (this.keyValue>another.getKeyValue()) {
			return 1;
		}
		}
		return -1;
	}
	
	
}
