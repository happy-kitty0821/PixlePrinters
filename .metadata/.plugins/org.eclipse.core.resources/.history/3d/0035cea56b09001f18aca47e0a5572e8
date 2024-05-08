package models;

import java.io.File;
import java.io.Serializable;

import javax.servlet.http.Part;

import utilities.Utilities;

public class UserModel implements Serializable{//implements Serializable to create a bean object
	private String fullName;
	private String email;
	private String userName;
	private String accountType;
	private String password;
	private String phoneNumber;
	private String profilePicture;
	
	public UserModel(String fullName, String email, String userName, String phoneNumber, String profilePicture) {
		super();
		this.fullName = fullName;
		this.email = email;
		this.userName = userName;
		this.phoneNumber = phoneNumber;
		this.profilePicture = profilePicture;
	}

	private String getProfilePicUrl(Part part) {//part is an imterface not a class
		String imageSavePath = Utilities.Profile_Picture_Store_Dir;
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

	public UserModel(String fullName, String email, String userName, String password,
			String phoneNumber, Part imagePart) {
		super();
		this.fullName = fullName;
		this.email = email;
		this.userName = userName;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.profilePicture = getProfilePicUrl(imagePart);
	}
	
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getProfilePicture() {
		return profilePicture;
	}
	public void setProfilePicture(Part part) {
		this.profilePicture = getProfilePicUrl(part);
	}
	
}