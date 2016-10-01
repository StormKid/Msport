package com.msport.clientmaster.calendar;

/**
 * 课程选择时间的具体
 * 
 * @author like 2016-5-11
 */
public class GetTimeBean implements Comparable<GetTimeBean> {
	private boolean isChecked;
	private int position;
	private String id;
	private long keyValue;
	private String showTime;
	private String am_pm;
	private long key;
	private String startTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public long getKeyValue() {
		return keyValue;
	}

	public void setKeyValue(long keyValue) {
		this.keyValue = keyValue;
	}

	public boolean isChecked() {
		return isChecked;
	}

	public void setChecked(boolean isChecked) {
		this.isChecked = isChecked;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public String getAm_pm() {
		return am_pm;
	}

	public void setAm_pm(String am_pm) {
		this.am_pm = am_pm;
	}

	public String getShowTime() {
		return showTime;
	}

	public void setShowTime(String showTime) {
		this.showTime = showTime;
	}

	@Override
	public int compareTo(GetTimeBean another) {
		if (another != null) {
			if (this.keyValue < another.getKeyValue()) {
				return -1;
			} else if (this.keyValue == another.getKeyValue()) {
				return 0;
			} else if (this.keyValue > another.getKeyValue()) {
				return 1;
			}
		}
		return -1;
	}

	public long getKey() {
		return key;
	}

	public void setKey(long key) {
		this.key = key;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	

}
