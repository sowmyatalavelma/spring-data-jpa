package com.cg.homeloan.entities;

/**
 * 
 * @author VINAYA SREE
 *
 */

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.cg.homeloan.dto.AdminDetails;

@Entity
@Table(name = "admin_details")
public class Admin {

	@Id
	@GeneratedValue
	private int userId;
	private String adminName;
	private String adminContact;
	@OneToOne(mappedBy = "admin")
	private User user;

	public Admin() {

	}

	public Admin(String adminName, String adminContact, User user) {
		super();
		this.adminName = adminName;
		this.adminContact = adminContact;
		this.user = user;
	}
	public Admin(String adminName, String adminContact) {
		super();
		this.adminName = adminName;
		this.adminContact = adminContact;
		
	}

	public Admin(int userId, String adminName, String adminContact) {

		this.userId = userId;
		this.adminName = adminName;
		this.adminContact = adminContact;
	}

	public Admin(int userId, String adminName, String adminContact, User user) {
		super();
		this.userId = userId;
		this.adminName = adminName;
		this.adminContact = adminContact;
		this.user = user;
	}

	public Admin(AdminDetails admindetails) {
		this.userId = admindetails.getUserId();
		this.adminName = admindetails.getAdminName();
		this.adminContact = admindetails.getAdminContact();
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Admin [userId=" + userId + ", adminName=" + adminName + ", adminContact=" + adminContact + "]";
	}

}
