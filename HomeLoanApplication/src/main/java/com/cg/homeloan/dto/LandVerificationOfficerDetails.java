package com.cg.homeloan.dto;

import com.cg.homeloan.entities.LandVerificationOfficer;

/**
 * 
 * @author VINAYA SREE
 *
 */

public class LandVerificationOfficerDetails {
	private int userId;
	private String officerName;
	private String officerContact;
	private UserDetails users;

	public LandVerificationOfficerDetails() {

	}

	public LandVerificationOfficerDetails(int userId, String officerName, String officerContact, UserDetails users) {
		super();
		this.userId = userId;
		this.officerName = officerName;
		this.officerContact = officerContact;
		this.users = users;
	}

	public LandVerificationOfficerDetails(LandVerificationOfficer lo) {
		this.userId = lo.getUserId();
		this.officerName = lo.getOfficerName();
		this.officerContact = lo.getOfficerContact();
		this.users = new UserDetails(lo.getUser());
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

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

	public UserDetails getUsers() {
		return users;
	}

	public void setUsers(UserDetails users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "LandVerificationOfficerDetails [userId=" + userId + ", officerName=" + officerName + ", officerContact="
				+ officerContact + ", users=" + users + "]";
	}

}
