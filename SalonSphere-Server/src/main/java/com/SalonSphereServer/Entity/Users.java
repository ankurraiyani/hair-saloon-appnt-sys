package com.SalonSphereServer.Entity;


import com.SalonSphereServer.common.Role;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Users {

	@Id
	@Column(name = "user_id")
	private String user_Id;
	
	@Column(name="first_name")
	private String first_name;
	
	@Column(name="last_name")
	private String last_name;

	@Column(name = "password")
	private String password;
	
	@Column(name="contact_number")
	private String contact_number;

	@Column(name = "user_role")
	private Role role;

	@Column(name="gender")
	private String gender;

	@Column(name="created_date")
	private String created_date;

	@Column(name="modify_date")
	private String modify_date;

	@Column(name="isdeleted")
	private boolean isdeleted;

	//non-parameterized Constructor
	public Users() {
		
	}
	
	//Parameterized Constructor

	public Users(String user_Id, String first_name, String last_name, String password, String contact_number, Role role,
			String gender, String created_date, String modify_date, boolean isdeleted) {
		this.user_Id = user_Id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.password = password;
		this.contact_number = contact_number;
		this.role = role;
		this.gender = gender;
		this.created_date = created_date;
		this.modify_date = modify_date;
		this.isdeleted = isdeleted;
	}


	public String getUser_Id() {
		return user_Id;
	}

	public void setUser_Id(String user_Id) {
		this.user_Id = user_Id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getContact_number() {
		return contact_number;
	}

	public void setContact_number(String contact_number) {
		this.contact_number = contact_number;
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

	public String getCreated_date() {
		return created_date;
	}

	public void setCreated_date(String created_date) {
		this.created_date = created_date;
	}

	public String getModify_date() {
		return modify_date;
	}

	public void setModify_date(String modify_date) {
		this.modify_date = modify_date;
	}

	public boolean getIsdeleted() {
		return isdeleted;
	}

	public void setIsdeleted(boolean isdeleted) {
		this.isdeleted = isdeleted;
	}

	@Override
	public String toString() {
		return "Users [user_Id=" + user_Id + ", first_name=" + first_name + ", last_name=" + last_name + ", password="
				+ password + ", contact_number=" + contact_number + ", role=" + role + ", gender=" + gender
				+ ", created_date=" + created_date + ", modify_date=" + modify_date + ", isdeleted=" + isdeleted + "]";
	}
	
}
