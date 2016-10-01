package com.msport.clientmaster.calendar;
/**
 * 显示课程时间
 * @author like
 * 2016-5-30
 */
public class TimeShowBean implements Comparable<TimeShowBean>{

	private long keyValue;
	private String showTime;
	private String weekendShow;
	private String startShow;
	private String endShow;
	
	public String getShowTime() {
		return showTime;
	}

	public void setShowTime(String showTime) {
		this.showTime = showTime;
	}

	public String getWeekendShow() {
		return weekendShow;
	}

	public void setWeekendShow(String weekendShow) {
		this.weekendShow = weekendShow;
	}

	public long getKeyValue() {
		return keyValue;
	}

	public void setKeyValue(long keyValue) {
		this.keyValue = keyValue;
	}
	
	@Override
	public int compareTo(TimeShowBean another) {
		if (another!=null) {
			if (this.getKeyValue()<another.getKeyValue()) {
				return -1;
			}else if (this.getKeyValue()==another.getKeyValue()) {
				return 0;
			}else if (this.getKeyValue()>another.getKeyValue()) {
				return 1;
			}
			}
			return -1;
	}


	public String getStartShow() {
		return startShow;
	}

	public void setStartShow(String startShow) {
		this.startShow = startShow;
	}

	public String getEndShow() {
		return endShow;
	}

	public void setEndShow(String endShow) {
		this.endShow = endShow;
	}

}
