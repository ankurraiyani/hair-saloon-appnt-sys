package com.SalonSphereServer.dto;

public class ShopOwnerDTO {

	private String fullName;
	private String email;
	private String contactNumber;
	private int numberOfShops;
	
	
	//parameterized constructor
	public ShopOwnerDTO(String fullName, String email, String contactNumber, int numberOfShops) {
		super();
		this.fullName = fullName;
		this.email = email;
		this.contactNumber = contactNumber;
		this.numberOfShops = numberOfShops;
	}
	
	public ShopOwnerDTO() {
		
	}
	
	@Override
	public String toString() {
		return "ShopOwnerDTO [fullName=" + fullName + ", email=" + email + ", contactNumber=" + contactNumber
				+ ", numberOfShops=" + numberOfShops + "]";
	}

	//setters and getters
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
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public int getNumberOfShops() {
		return numberOfShops;
	}
	public void setNumberOfShops(int numberOfShops) {
		this.numberOfShops = numberOfShops;
	}
	
	
}
