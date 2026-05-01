package src.model;
import java.time.LocalDateTime;
public class Receipt {
	private int receiptID;
	private int sessionID;
	private int outfitID;
	private LocalDateTime generatedAt;
	private double totalPrice;
	public Receipt(int receiptID, int sessionID) {
		this.receiptID = receiptID;
		this.sessionID = sessionID;
	}
	public Receipt(int receiptID, int sessionID, int outfitID, LocalDateTime generatedAt, double totalPrice) {
		this.receiptID = receiptID;
		this.sessionID = sessionID;
		this.outfitID = outfitID;
		this.generatedAt = generatedAt;
		this.totalPrice = totalPrice;
	}
	public Receipt(int receiptID, int sessionID, int outfitID, double totalPrice) {
		this.receiptID = receiptID;
		this.sessionID = sessionID;
		this.outfitID = outfitID;
		this.generatedAt = LocalDateTime.now();
		this.totalPrice = totalPrice;
	}
	public void setReceiptID(int receiptID) {this.receiptID = receiptID;}
	public void setSessionID(int sessionID) {this.sessionID = sessionID;}
	public void setOutfitID(int outfitID) {this.outfitID = outfitID;}
	public void setGeneratedAt(LocalDateTime generatedAt) {this.generatedAt = generatedAt;}
	public void setTotalPrice(double totalPrice) {this.totalPrice = totalPrice;}
	public int getReceiptID() {return receiptID;}
	public int getSessionID() {return sessionID;}
	public int getOutfitID() {return outfitID;}
	public LocalDateTime getGeneratedAt() {return generatedAt;}
	public double getTotalPrice() {return totalPrice;}
}