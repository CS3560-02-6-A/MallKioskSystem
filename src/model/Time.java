package src.model;
public class Time {
	int hour;
	int minute;
	public Time(int hour, int minute) {
		setHour(hour);
		setMinute(minute);
	}
	public void setHour(int hour) {
		if (hour >= 0 && hour < 24) {
			this.hour = hour;
		}else{throw new IllegalArgumentException("Illegal minute. The range of minute is 0<=minute<=59");}
	}
	public void setMinute(int minute) {
		if (minute >= 0 && minute < 60) {
			this.minute = minute;
		}else{throw new IllegalArgumentException("Illegal hour. The range of hour is 0<=hour<=23");}
	}
	public int getHour() {
		return hour;
	}
	public int getMinute() {
		return minute;
	}
}
