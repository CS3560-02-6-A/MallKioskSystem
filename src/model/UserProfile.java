package src.model;
public class UserProfile {
	private int profileID;	
	private int sessionID;
	private String gender;
	private String colorPallette;
	private String topSize;
	private String bottomSize;
	private float shoeSize;
	public UserProfile(int profileId, int sessionID) {
		setProfileID(profileID);
		setSessionID(sessionID);
	}
	public UserProfile(int profileID, int sessionID, String gender,
	String colorPallette, String topSize, String bottomSize, float shoeSize) {
		setProfileID(profileID);
		setSessionID(sessionID);
		setGender(gender);
		setColorPallette(colorPallette);
		setTopSize(topSize);
		setBottomSize(bottomSize);
		setShoeSize(shoeSize);
	}
	public void setProfileID(int profileID) {this.profileID = profileID;}
	public void setSessionID(int sessionID) {this.sessionID = sessionID;}
	public void setGender(String gender) {this.gender = gender;}
	public void setColorPallette(String colorPallette) {this.colorPallette = colorPallette;}
	public void setTopSize(String topSize) {this.topSize = topSize;}
	public void setBottomSize(String bottomSize) {this.bottomSize = bottomSize;}
	public void setShoeSize(float shoeSize) {this.shoeSize = shoeSize;}
	public int getProfileID() {return profileID;}
	public int getSessionID() {return sessionID;}
	public String getGender() {return gender;}
	public String getColorPallette() {return colorPallette;}
	public String getTopSize() {return topSize;}
	public String getBottomSize() {return bottomSize;}
	public float getShoeSize() {return shoeSize;}
}