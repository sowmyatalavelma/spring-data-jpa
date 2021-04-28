package com.cg.homeloan.entities;

/**
 * 
 * @author VINAYA SREE
 *
 */

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.cg.homeloan.dto.LandVerificationOfficerDetails;

@Entity
@Table(name = "landofficer_details")
public class LandVerificationOfficer {

	@Id
	@GeneratedValue
	private int userId;
	private String officerName;
	private String officerContact;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "lofficeruser_id")
	private User user;

	public LandVerificationOfficer() {

	}

	public LandVerificationOfficer(String officerName, String officerContact) {

		this.officerName = officerName;
		this.officerContact = officerContact;
	}

	public LandVerificationOfficer(String officerName, String officerContact, User user) {
		super();
		this.officerName = officerName;
		this.officerContact = officerContact;
		this.user = user;
	}

	public LandVerificationOfficer(int userId, String officerName, String officerContact, User user) {
		super();
		this.userId = userId;
		this.officerName = officerName;
		this.officerContact = officerContact;
		this.user = user;
	}

	public LandVerificationOfficer(LandVerificationOfficerDetails ld) {
		this.userId = ld.getUserId();
		this.officerName = ld.getOfficerName();
		this.officerContact = ld.getOfficerContact();
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	// public Set<User> getUsers() {
//		return users;
//	}
//	public void setUsers(Set<User> users) {
//		this.users = users;
//	}
	@Override
	public String toString() {
		return "LandVerificationOfficer [userId=" + userId + ", officerName=" + officerName + ", officerContact="
				+ officerContact + "]";
	}

}
