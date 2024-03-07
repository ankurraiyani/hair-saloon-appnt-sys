package com.SalonSphereServer.entity;


import java.util.Date;
import java.util.Collection;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_information")
public class Users implements UserDetails{

	@Id
	@Column(name = "user_id")
	private String userId;
	
	@Column(name = "first_name")
	private  String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "contact_number")
	private String contactNumber;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "user_role")
	private String role;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "data_created")
	private Date dataCreated;
	
	@Column(name = "data_modify")
	private Date dataModify;
	
	@Column(name = "isdeleted")
	private boolean isDeleted;

	public Users() {
		
	}
	
	
	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getFirstName() {
		return firstName;
	}
	
	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role=role;
	}


	public Users(String userId, String firstName, String lastName, String contactNumber, String email, String password,
			Date dataCreated, Date dataModify, boolean isDeleted,String role) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.contactNumber = contactNumber;
		this.email = email;
		this.password = password;
		this.dataCreated = dataCreated;
		this.dataModify = dataModify;
		this.isDeleted = isDeleted;
		this.role= role;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getContactNumber() {
		return contactNumber;
	}


	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Date getDataCreated() {
		return dataCreated;
	}


	public void setDataCreated(Date dataCreated) {
		this.dataCreated = dataCreated;
	}


	public Date getDataModify() {
		return dataModify;
	}


	public void setDataModify(Date dataModify) {
		this.dataModify = dataModify;
	}


	public boolean isDeleted() {
		return isDeleted;
	}


	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}


	@Override
	public String toString() {
		return "Users [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", contactNumber="
				+ contactNumber + ", email=" + email + ", password=" + password + ", dataCreated=" + dataCreated
				+ ", dataModify=" + dataModify + ", isDeleted=" + isDeleted + ", role =" + role + "]";
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
