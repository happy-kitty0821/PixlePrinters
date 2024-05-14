package models;

import java.io.Serializable;

public class DisplayAllPurchase implements Serializable{
	   private int purchaseId;
	    private String DateTime;
	    private int quantity;
	    private double totalAmount;
	    private String userName;
	    private String email;
	    private String phoneNumber;
	    private String productName;
	    private String productImage;
	    private double price;
	    private int productQuantity;
	    private String companyName;
	    private String printTechnology;
	    private String color;
	    private String printColor;
	    private String purchaseStatus;
		public DisplayAllPurchase(int purchaseId, String dateTime, int quantity, double totalAmount, String userName,
				String email, String phoneNumber, String productName, String productImage, double price,
				int productQuantity, String companyName, String printTechnology, String color, String printColor,
				String purchaseStatus) {
			super();
			this.purchaseId = purchaseId;
			DateTime = dateTime;
			this.quantity = quantity;
			this.totalAmount = totalAmount;
			this.userName = userName;
			this.email = email;
			this.phoneNumber = phoneNumber;
			this.productName = productName;
			this.productImage = productImage;
			this.price = price;
			this.productQuantity = productQuantity;
			this.companyName = companyName;
			this.printTechnology = printTechnology;
			this.color = color;
			this.printColor = printColor;
			this.purchaseStatus = purchaseStatus;
		}
		public int getPurchaseId() {
			return purchaseId;
		}
		public void setPurchaseId(int purchaseId) {
			this.purchaseId = purchaseId;
		}
		public String getDateTime() {
			return DateTime;
		}
		public void setDateTime(String dateTime) {
			DateTime = dateTime;
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
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPhoneNumber() {
			return phoneNumber;
		}
		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
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
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}
		public int getProductQuantity() {
			return productQuantity;
		}
		public void setProductQuantity(int productQuantity) {
			this.productQuantity = productQuantity;
		}
		public String getCompanyName() {
			return companyName;
		}
		public void setCompanyName(String companyName) {
			this.companyName = companyName;
		}
		public String getPrintTechnology() {
			return printTechnology;
		}
		public void setPrintTechnology(String printTechnology) {
			this.printTechnology = printTechnology;
		}
		public String getColor() {
			return color;
		}
		public void setColor(String color) {
			this.color = color;
		}
		public String getPrintColor() {
			return printColor;
		}
		public void setPrintColor(String printColor) {
			this.printColor = printColor;
		}
		public String getPurchaseStatus() {
			return purchaseStatus;
		}
		public void setPurchaseStatus(String purchaseStatus) {
			this.purchaseStatus = purchaseStatus;
		}

}
