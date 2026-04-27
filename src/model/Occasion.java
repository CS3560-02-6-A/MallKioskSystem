package src.model;
public class Occasion {
	private int occasionID;
	private String name;
	private String description;
	public Occasion(int occasionID) {
		setOccasionID(occasionID);
	}
	public Occasion(int occasionID, String name, String description) {
		setOccasionID(occasionID);
		setName(name);
		setDescription(description);
	}
	public void setOccasionID(int occasionID) {this.occasionID = occasionID;}
	public void setName(String name) {this.name = name;}
	public void setDescription(String description) {this.description = description;}
	public int getOccasionID() {return occasionID;}
	public String getName() {return name;}
	public String getDescription() {return description;}
}