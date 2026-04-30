package src.model;
public class StoreHours {
	private int hoursID;
	private int storeID;
	private String dayOfWeek;
	private Time openTime;
	private Time closeTime;

	public StoreHours(int hoursID, int storeID) 
	{
		this.hoursID = hoursID;
		this.storeID = storeID;
	}
	public StoreHours(int hoursID, int storeID, String dayOfWeek, Time openTime, Time closeTime) 
	{
		this.hoursID = hoursID;
		this.storeID = storeID;
		this.dayOfWeek = dayOfWeek;
		this.openTime = openTime;
		this.closeTime = closeTime;
	}
	
	public void setHoursID(int hoursID) {
		//We must make sure that this hours ID is not the same
		//as any other hours ID connected to a particular store.
		//Where may I find a function to check for this?
		this.hoursID = hoursID;
	}
	public void setStoreID(int storeID) {
		//We must make sure that this store ID is not the same
		//as any other store ID. Where may I find a function to
		//check for this?
		this.storeID = storeID;
	}
	public void setDayOfWeek(String dayOfWeek) {
		//Store can make sure that it does not have multiple
		//operation hours on the same day of week.
		switch (dayOfWeek.toLowerCase()) {
			case "monday":
			case "tuesday":
			case "wednesday":
			case "thursday":
			case "friday":
			case "saturday":
			case "sunday":
				this.dayOfWeek = dayOfWeek.toLowerCase();
				break;
			default:
				throw new IllegalArgumentException("Not a real day of the week.");
		}
	}
	public void setOpenTime(Time openTime) {
		this.openTime = openTime;
	}
	public void setCloseTime(Time closeTime) {
		this.closeTime = closeTime;
	}
	public int getHoursID() {
		return hoursID;
	}
	public int getStoreID() {
		return storeID;
	}
	public String getDayOfWeek() {
		return dayOfWeek;
	}
	public Time getOpenTime() {
		return new Time(openTime.getHour(), openTime.getMinute());
	}
	public Time getCloseTime() {
		return new Time(closeTime.getHour(), closeTime.getMinute());
	}
}
