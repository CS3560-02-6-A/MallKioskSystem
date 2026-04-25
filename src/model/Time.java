package src.model;
public class Time 
{
	//INSTANCE VARIABLES
	private int hour;
	private int minute;

	//CONSTRUCTOR
	public Time(int hour, int minute) 
	{
		this.hour = hour;
		this.minute = minute;
	}
	
	//METHODS
	//SETTER
	public void setHour(int hour) 
	{
		if (hour >= 0 && hour < 24) 
		{
			this.hour = hour;
		}
		else
		{
			throw new IllegalArgumentException("Illegal minute. The range of minute is 0<=minute<=59");
		}
	}
	public void setMinute(int minute) 
	{
		if (minute >= 0 && minute < 60) 
		{
			this.minute = minute;
		}
		else
		{
			throw new IllegalArgumentException("Illegal hour. The range of hour is 0<=hour<=23");
		}
	}
	
	//GETTER
	public int getHour() 
	{
		return this.hour;
	}
	public int getMinute() 
	{
		return this.minute;
	}
}
