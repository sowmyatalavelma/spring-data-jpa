package com.cg.homeloan.dto;

import javax.validation.constraints.NotNull;

/**
 * 
 * @author VINAYA SREE
 *
 */

public class CreateUser {
	private int userId;
	@NotNull
	private String password;
	private String role;

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

	@Override
	public String toString() {
		return "CreateUser [userId=" + userId + ", password=" + password + ", role=" + role + "]";
	}

}
