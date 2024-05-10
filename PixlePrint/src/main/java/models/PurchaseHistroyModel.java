package models;

import java.io.Serializable;
import java.sql.Timestamp;

public class PurchaseHistroyModel implements Serializable{
    private int purchaseId;
    private Timestamp dateTime;
    private int quantity;
    private double totalAmount;
    private String productName;
    private double price;
    private String purchaseStatus;
    private String productImage;
	public PurchaseHistroyModel(int purchaseId, Timestamp dateTime, int quantity, double totalAmount,
			String productName, double price, String purchaseStatus, String productImage) {
		super();
		this.purchaseId = purchaseId;
		this.dateTime = dateTime;
		this.quantity = quantity;
		this.totalAmount = totalAmount;
		this.productName = productName;
		this.price = price;
		this.purchaseStatus = purchaseStatus;
		this.productImage = productImage;
	}
	public int getPurchaseId() {
		return purchaseId;
	}
	public void setPurchaseId(int purchaseId) {
		this.purchaseId = purchaseId;
	}
	public Timestamp getDateTime() {
		return dateTime;
	}
	public void setDateTime(Timestamp dateTime) {
		this.dateTime = dateTime;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public String getPurchaseStatus() {
		return purchaseStatus;
	}
	public void setPurchaseStatus(String purchaseStatus) {
		this.purchaseStatus = purchaseStatus;
	}
	public String getProductImage() {
		return productImage;
	}
	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

    
}
