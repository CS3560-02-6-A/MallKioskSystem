package src.model;
public class Outfit {
	private int outfitID;
	private int occasionID;
	private int topItemID;
	private int bottomItemID;
	private int shoesItemID;
	private int accessoryItemID;
	public Outfit(int OutfitID) {
		setOutfitID(outfitID);
	}
	public Outfit(int outfitID, int occasionID, int topItemID, int bottomItemID, int shoesItemID, int accessoryItemID) {
		setOutfitID(outfitID);
		setOccasionID(occasionID);
		setTopItemID(topItemID);
		setBottomItemID(bottomItemID);
		setShoesItemID(shoesItemID);
		setAccessoryItemID(accessoryItemID);
	}
	public void setOutfitID(int outfitID) {this.outfitID = outfitID;}
	public void setOccasionID(int occasionID) {this.occasionID = occasionID;}
	public void setTopItemID(int topItemID) {this.topItemID = topItemID;}
	public void setBottomItemID(int bottomItemID) {this.bottomItemID = bottomItemID;}
	public void setShoesItemID(int shoesItemID) {this.shoesItemID = shoesItemID;}
	public void setAccessoryItemID(int accessoryItemID) {this.accessoryItemID = accessoryItemID;}
	public int getOutfitID() {return outfitID;}
	public int getOccasionID() {return occasionID;}
	public int getTopItemID() {return topItemID;}
	public int getBottomItemID() {return bottomItemID;}
	public int getShoesItemID() {return shoesItemID;}
	public int getAccessoryItemID() {return accessoryItemID;}
	
};