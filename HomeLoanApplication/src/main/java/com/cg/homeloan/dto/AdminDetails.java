package com.cg.homeloan.dto;

import com.cg.homeloan.entities.Admin;

/**
 * 
 * @author VINAYA SREE
 *
 */

public class AdminDetails {
	private int userId;
	private String adminName;
	private String adminContact;

	public AdminDetails() {
		super();

	}

	public AdminDetails(int userId, String adminName, String adminContact) {
		super();
		this.userId = userId;
		this.adminName = adminName;
		this.adminContact = adminContact;
	}

	public AdminDetails(Admin admin) {
		this.userId = admin.getUserId();
		this.adminName = admin.getAdminName();
		this.adminContact = admin.getAdminContact();
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminContact() {
		return adminContact;
	}

	public void setAdminContact(String adminContact) {
		this.adminContact = adminContact;
	}

	@Override
	public String toString() {
		return "AdminDetails [userId=" + userId + ", adminName=" + adminName + ", adminContact=" + adminContact + "]";
	}

}
