package com.SalonSphereServer.Entity;


import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.SalonSphereServer.common.Role;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_information")
public class Users implements UserDetails{

	@Id
	@Column(name = "userId")
	private String userId;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;

	@Column(name = "password")
	private String password;
	
	@Column(name="contact_number")
	private String contactNumber;

	@Column(name = "user_role")
	private Role role;

	@Column(name="gender")
	private String gender;

	@Column(name="created_date")
	private String createdDate;

	@Column(name="modify_date")
	private String modifyDate;

	@Column(name="isdeleted")
	private boolean isdeleted;

	@Column(name="email")
	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Users(String userId, String firstName, String lastName, String password, String contactNumber, Role role,
			String gender, String createdDate, String modifyDate, boolean isdeleted, String email) {
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.contactNumber = contactNumber;
		this.role = role;
		this.gender = gender;
		this.createdDate = createdDate;
		this.modifyDate = modifyDate;
		this.isdeleted = isdeleted;
		this.email = email;
	}

	//non-parameterized Constructor
	public Users() {
		
	}
	
	

	@Override
	public String toString() {
		return "Users [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", password="
				+ password + ", contactNumber=" + contactNumber + ", role=" + role + ", gender=" + gender
				+ ", createdDate=" + createdDate + ", modifyDate=" + modifyDate + ", isdeleted=" + isdeleted
				+ ", email=" + email + "]";
	}

	public String getuserId() {
		return userId;
	}

	public void setuserId(String userId) {
		this.userId = userId;
	}

	public String getfirstName() {
		return firstName;
	}

	public void setfirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getlastName() {
		return lastName;
	}

	public void setlastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getcontactNumber() {
		return contactNumber;
	}

	public void setcontactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getcreatedDate() {
		return createdDate;
	}

	public void setcreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getmodifyDate() {
		return modifyDate;
	}

	public void setmodifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}

	public boolean getIsdeleted() {
		return isdeleted;
	}

	public void setIsdeleted(boolean isdeleted) {
		this.isdeleted = isdeleted;
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
