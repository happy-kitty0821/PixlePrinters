package models;

import java.io.Serializable;
import java.sql.Date;

public class PurchaseModel implements Serializable{
	private int purchaseId;
	private Date DateTime;
	private int quantity;
	private Double totalAmount;
	private int userId;
	private int productid;
	private String purchaseStatus;
	
	//constructor used for showing purchase histroy to the user
	public PurchaseModel(int purchaseId, Date dateTime, int quantity, Double totalAmount, int userId, int productid,
			String purchaseStatus) {
		super();
		this.purchaseId = purchaseId;
		DateTime = dateTime;
		this.quantity = quantity;
		this.totalAmount = totalAmount;
		this.userId = userId;
		this.productid = productid;
		this.purchaseStatus = purchaseStatus;
	}

	public int getPurchaseId() {
		return purchaseId;
	}

	public void setPurchaseId(int purchaseId) {
		this.purchaseId = purchaseId;
	}

	public Date getDateTime() {
		return DateTime;
	}

	public void setDateTime(Date dateTime) {
		DateTime = dateTime;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public String getPurchaseStatus() {
		return purchaseStatus;
	}

	public void setPurchaseStatus(String purchaseStatus) {
		this.purchaseStatus = purchaseStatus;
	}
	
	//constructor used for adding products to the db
	public PurchaseModel(int quantity, Double totalAmount, int userId, int productid) {
		super();
		this.quantity = quantity;
		this.totalAmount = totalAmount;
		this.userId = userId;
		this.productid = productid;
	}
}
