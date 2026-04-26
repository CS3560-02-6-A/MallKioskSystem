package src.model;
import java.time.LocalDateTime;
public class Receipt {
	private int receiptID;
	private int sessionID;
	private int outfitID;
	private LocalDateTime generatedAt;
	private double totalPrice;
	public Receipt(int receiptID) {
		setReceiptID(receiptID);
	}
	public Receipt(int receiptID, int sessionID, int outfitID, LocalDateTime generatedAt, double totalPrice) {
		setReceiptID(receiptID);
		setSessionID(sessionID);
		setOutfitID(outfitID);
		setGeneratedAt(generatedAt);
		setTotalPrice(totalPrice);
	}
	public Receipt(int receiptID, int sessionID, int outfitID, double totalPrice) {
		setReceiptID(receiptID);
		setSessionID(sessionID);
		setOutfitID(outfitID);
		setGeneratedAt(LocalDateTime.now());
		setTotalPrice(totalPrice);
	}
	public void setReceiptID(int receiptID) {this.receiptID = receiptID;}
	public void setSessionID(int sessionID) {this.sessionID = sessionID;}
	public void setOutfitID(int outfitID) {this.outfitID = outfitID;}
	public void setGeneratedAt(LocalDateTime generatedAt) {this.generatedAt = generatedAt;}
	public void setTotalPrice(double totalPrice) {this.totalPrice = totalPrice;}
	public int getReceiptID() {return receiptID;}
	public int getSessionID() {return sessionID;}
	public int getOutfitID() {return outfitID;}
	public int getGeneratedAt() {return generatedAt;}
	public int getTotalPrice() {return totalPrice;}
}