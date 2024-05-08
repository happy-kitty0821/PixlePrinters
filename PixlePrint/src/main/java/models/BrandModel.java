package models;

import java.io.Serializable;

public class BrandModel implements Serializable {
    private int brandId;
    private String companyName;
    private String country;
    private String contactInformation;
    private String website;
	public BrandModel(String companyName, String country, String contactInformation, String website) {
		super();
		this.companyName = companyName;
		this.country = country;
		this.contactInformation = contactInformation;
		this.website = website;
	}
	public int getBrandId() {
		return brandId;
	}
	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getContactInformation() {
		return contactInformation;
	}
	public void setContactInformation(String contactInformation) {
		this.contactInformation = contactInformation;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	
}
