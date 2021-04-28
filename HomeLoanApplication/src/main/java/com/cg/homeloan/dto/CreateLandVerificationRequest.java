package com.cg.homeloan.dto;

import com.cg.homeloan.entities.User;

/**
 * 
 * @author VINAYA SREE
 *
 */

public class CreateLandVerificationRequest {

	private int userId;
	private String officerName;
	private String officerContact;
	private User user;

	public String getOfficerName() {
		return officerName;
	}

	public void setOfficerName(String officerName) {
		this.officerName = officerName;
	}

	public String getOfficerContact() {
		return officerContact;
	}

	public void setOfficerContact(String officerContact) {
		this.officerContact = officerContact;
	}

	public User getUsers() {
		return user;
	}

	public void setUsers(User user) {
		this.user = user;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "CreateLandVerificationRequest [officerName=" + officerName + ", officerContact=" + officerContact
				+ ", users=" + user + "]";
	}

}
