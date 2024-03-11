package com.SalonSphereServer.dto;

import org.springframework.stereotype.Component;

@Component
public class CustomerDTO {
	
	private String fullName;
	private String email;
	private String contactNumber;
	
	public CustomerDTO(String fullName, String email, String contactNumber) {
		super();
		this.fullName = fullName;
		this.email = email;
		this.contactNumber = contactNumber;

	}
	public CustomerDTO() {
		
	}
	
	@Override
	public String toString() {
		return "UserDTO [fullName=" + fullName + ", email=" + email + ", contactNumber=" + contactNumber + "]";
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
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	
	
	
	
	
	
	

}
