package com.SalonSphereServer.Entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Users {

	@Id
	@Column(name = "user_id")
	private String userId;
	
	@Column(name="user_name")
	private String userName;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "user_role")
	private Role role;

	//non-parameterized Constructor
	public Users() {
		
	}
	
	//Parameterized Constructor
	public Users(String userId, String userName, String password, Role role) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.role = role;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Users [userId=" + userId + ", userName=" + userName + ", password=" + password + ", role=" + role + "]";
	}
	
}
