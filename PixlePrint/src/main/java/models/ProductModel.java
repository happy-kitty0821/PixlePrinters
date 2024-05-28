package models;

import java.io.File;

import javax.servlet.http.Part;

import utils.Utilities;

public class ProductModel{
	private int productId;
	private String productName;
	private String productDescription;
	private double price;
	private int quantity;
	private String companyName;
	private String productImage;
	private String printTechnology;
	private String printSpeed;
	private String printResulotion;
	private String weight;
	private String dimensions;
	private String operatingSystem;
	private String supportedPageSize;
	private String color;
	private String printColor;
	

	private String getProductPicUrl(Part part) {//part is an imterface not a class
		String imageSavePath = Utilities.Product_Picture_Store_Dir;
		File imageSaveDir = new File(imageSavePath);
		String profilePicUrlFromPath = null;
		if(!imageSaveDir.exists()) {
			imageSaveDir.mkdir();
		}
		String contentDisp = part.getHeader("content-disposition");
		String []items = contentDisp.split(";");
		for(String s : items) {
			if(s.trim().startsWith("filename")) {
				profilePicUrlFromPath = s.substring(s.indexOf("=") + 2, s.length() -1);
			}
		}	
		if(profilePicUrlFromPath == null || profilePicUrlFromPath.isEmpty()) {
			profilePicUrlFromPath = "default.png";
		}
		return profilePicUrlFromPath;
	}
	
	public ProductModel(int productId, String productName) {
		super();
		this.productId = productId;
		this.productName = productName;
	}

	public ProductModel(String productName, String productDescription, double price, int quantity, String companyName, Part imagePart,
			String printTechnology, String printSpeed, String printResulotion, String weight,
			String dimensions, String operatingSystem, String supportedPageSize, String color, String printColor) {
		super();
		this.productName = productName;
		this.productDescription = productDescription;
		this.price = price;
		this.quantity = quantity;
		this.companyName = companyName;
		this.productImage = getProductPicUrl(imagePart);
		this.printTechnology = printTechnology;
		this.printSpeed = printSpeed;
		this.printResulotion = printResulotion;
		this.weight = weight;
		this.dimensions = dimensions;
		this.operatingSystem = operatingSystem;
		this.supportedPageSize = supportedPageSize;
		this.color = color;
		this.printColor = printColor;
	}
	public ProductModel(int productId, String productName, String productDescription, double price, String printSpeed,
			String dimensions, String color) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productDescription = productDescription;
		this.price = price;
		this.printSpeed = printSpeed;
		this.dimensions = dimensions;
		this.color = color;
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

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(Part part) {
	    this.productImage = getProductPicUrl(part);
	}

	public String getPrintTechnology() {
		return printTechnology;
	}

	public void setPrintTechnology(String printTechnology) {
		this.printTechnology = printTechnology;
	}

	public String getPrintSpeed() {
		return printSpeed;
	}

	public void setPrintSpeed(String printSpeed) {
		this.printSpeed = printSpeed;
	}

	public String getPrintResolution() {
		return printResulotion;
	}

	public void setPrintResulotion(String printResulotion) {
		this.printResulotion = printResulotion;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getDimensions() {
		return dimensions;
	}

	public void setDimensions(String dimensions) {
		this.dimensions = dimensions;
	}

	public String getOperatingSystem() {
		return operatingSystem;
	}

	public void setOperatingSystem(String operatingSystem) {
		this.operatingSystem = operatingSystem;
	}

	public String getSupportedPageSize() {
		return supportedPageSize;
	}

	public void setSupportedPageSize(String supportedPageSize) {
		this.supportedPageSize = supportedPageSize;
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

	public ProductModel(int productId, String productName, String productDescription, double price, int quantity,
			String companyName, String productImage, String printTechnology, String printSpeed, String printResulotion,
			String weight, String dimensions, String operatingSystem, String supportedPageSize, String color,
			String printColor) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productDescription = productDescription;
		this.price = price;
		this.quantity = quantity;
		this.companyName = companyName;
		this.productImage = productImage;
		this.printTechnology = printTechnology;
		this.printSpeed = printSpeed;
		this.printResulotion = printResulotion;
		this.weight = weight;
		this.dimensions = dimensions;
		this.operatingSystem = operatingSystem;
		this.supportedPageSize = supportedPageSize;
		this.color = color;
		this.printColor = printColor;
	}

	public ProductModel(int productId, String productName, String productDescription, double price, int quantity,
			String companyName, String productImage) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productDescription = productDescription;
		this.price = price;
		this.quantity = quantity;
		this.companyName = companyName;
		this.productImage = productImage;
	}

	public ProductModel(int productId, String productName, String productDescription, double price, int quantity,
			String printSpeed, String dimensions, String color) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productDescription = productDescription;
		this.price = price;
		this.quantity = quantity;
		this.printSpeed = printSpeed;
		this.dimensions = dimensions;
		this.color = color;
	}

//	public void setProductImage(String productImage) {
//		this.productImage = productImage;
//	}
	//use for search
	
}