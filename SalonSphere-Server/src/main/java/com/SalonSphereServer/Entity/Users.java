package com.SalonSphereServer.Entity;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "user_information")
public class Users implements UserDetails {

	@Id
	@Column(name = "user_id")
	private String userId;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "password")
	private String password;

	@Column(name = "contact_number")
	private String contactNumber;

	@Column(name = "user_role")
	private String role;

	@Column(name = "gender")
	private String gender;

	@Column(name = "created_date")
	private String createdDate;

	@Column(name = "modify_date")
	private String modifyDate;

	@Column(name = "isdeleted")
	private boolean isDeleted;

	public Users(String userId, String firstName, String lastName, String password, String contactNumber, String role,
			String gender, String createdDate, String modifyDate, boolean isDeleted, String email) {
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.contactNumber = contactNumber;
		this.role = role;
		this.gender = gender;
		this.createdDate = createdDate;
		this.modifyDate = modifyDate;
		this.isDeleted = isDeleted;
		this.email = email;
	}

	@Column(name = "email")
	private String email;

	public Users() {
	}

	public String getUserId() {
		return userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getPassword() {
		return password;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public String getRole() {
		return role;
	}

	public String getGender() {
		return gender;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public String getModifyDate() {
		return modifyDate;
	}

	public boolean getIsDeleted() {
		return isDeleted;
	}

	public String getEmail(){
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}

	public void setIsDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		throw new UnsupportedOperationException("Unimplemented method 'getAuthorities'");
	}

	@Override
	public String getUsername() {
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
