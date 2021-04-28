package com.cg.homeloan.dto;

import javax.validation.constraints.NotNull;

public class CreateUserAdminRequest {
	
	
	private int userId;
	@NotNull
	private String password;
	private String role;
	private AdminDetails admindetails;
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public AdminDetails getAdmindetails() {
		return admindetails;
	}

	public void setAdmindetails(AdminDetails admindetails) {
		this.admindetails = admindetails;
	}

	@Override
	public String toString() {
		return "CreateUser [userId=" + userId + ", password=" + password + ", role=" + role + ", admindetails="
				+ admindetails + "]";
	}

	
	
}
