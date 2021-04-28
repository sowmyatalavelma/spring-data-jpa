package com.cg.homeloan.dto;

import com.cg.homeloan.entities.FinanceVerificationOfficer;

/**
 * 
 * @author VINAYA SREE
 *
 */

public class FinanceVerificationDetails {
	private int userId;
	private String finOfficerName;
	private String finOfficerContact;
	private UserDetails details;

	public FinanceVerificationDetails() {

	}

	public FinanceVerificationDetails(int userId, String finOfficerName, String finOfficerContact,
			UserDetails details) {
		super();
		this.userId = userId;
		this.finOfficerName = finOfficerName;
		this.finOfficerContact = finOfficerContact;
		this.details = details;
	}

	public FinanceVerificationDetails(FinanceVerificationOfficer fd) {
		this.userId = fd.getUserId();
		this.finOfficerName = fd.getFinOfficerName();
		this.finOfficerContact = fd.getFinOfficerContact();
		this.details = new UserDetails(fd.getUser());
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

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

	public UserDetails getUsers() {
		return details;
	}

	public void setUsers(UserDetails details) {
		this.details = details;
	}

	@Override
	public String toString() {
		return "FinanceVerificationDetails [userId=" + userId + ", finOfficerName=" + finOfficerName
				+ ", finOfficerContact=" + finOfficerContact + "]";
	}

}