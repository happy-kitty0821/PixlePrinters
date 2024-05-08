package models;

import java.io.Serializable;

public class UserCartModel implements Serializable{
	int userId;
	int productId;
	String productName;
	String  productImage;
	Double price;
	int quantity;
	Double totalAmount;
	public UserCartModel(int userId, int productId, String productName, String productImage, Double price, int quantity,
			Double totalAmount) {
		super();
		this.userId = userId;
		this.productId = productId;
		this.productName = productName;
		this.productImage = productImage;
		this.price = price;
		this.quantity = quantity;
		this.totalAmount = totalAmount;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductImage() {
		return productImage;
	}
	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
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
}