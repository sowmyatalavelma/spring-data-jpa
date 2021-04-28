package com.cg.homeloan.dto;

import com.cg.homeloan.entities.User;

/**
 * 
 * @author VINAYA SREE
 *
 */

public class CreateFinanceVerificationRequest {

	private int userId;
	private String finOfficerName;
	private String finOfficerContact;

	private User user;

	public String getFinOfficerName() {
		return finOfficerName;
	}

	public void setFinOfficerName(String finOfficerName) {
		this.finOfficerName = finOfficerName;
	}

	public String getFinOfficerContact() {
		return finOfficerContact;
	}

	public void setFinOfficerContact(String finOfficerContact) {
		this.finOfficerContact = finOfficerContact;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "CreateFinanceVerificationRequest [ finOfficerName=" + finOfficerName + ", finOfficerContact="
				+ finOfficerContact + ", users=" + user + "]";
	}
}
