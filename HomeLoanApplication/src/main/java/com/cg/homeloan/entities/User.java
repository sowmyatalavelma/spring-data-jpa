package com.cg.homeloan.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.cg.homeloan.dto.UserDetails;

/**
 * 
 * @author VINAYA SREE
 *
 */

@Entity
@Table(name = "user_loan")
public class User {

	@Id
	private int userId;
	private String password;
	private String role;
	@OneToOne(mappedBy = "user")
	private Customer customer;

	@OneToOne(mappedBy = "user")
	private FinanceVerificationOfficer officer;

	@OneToOne(mappedBy = "user")
	private LandVerificationOfficer lOfficer;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "admin_id", referencedColumnName = "userId")
	private Admin admin;

	public User() {

	}

	public User(int userId, String password, String role) {

		this.userId = userId;
		this.password = password;
		this.role = role;
	}

	public User(int userId, String password, String role, Customer customer) {
		super();
		this.userId = userId;
		this.password = password;
		this.role = role;
		this.customer = customer;
	}

	public User(int userId, String password, String role, FinanceVerificationOfficer officer) {
		this.userId = userId;
		this.password = password;
		this.role = role;
		this.officer = officer;
	}

	public User(int userId, String password, String role, LandVerificationOfficer lOfficer) {
		super();
		this.userId = userId;
		this.password = password;
		this.role = role;
		this.lOfficer = lOfficer;
	}

	public User(int userId, String password, String role, Admin admin) {
		super();
		this.userId = userId;
		this.password = password;
		this.role = role;
		this.admin = admin;
	}

	public User(UserDetails usd) {

		this.userId = usd.getUserId();
		this.password = usd.getPassword();
		this.role = usd.getRole();
	}

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

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public FinanceVerificationOfficer getOfficer() {
		return officer;
	}

	public void setOfficer(FinanceVerificationOfficer officer) {
		this.officer = officer;
	}

	public LandVerificationOfficer getlOfficer() {
		return lOfficer;
	}

	public void setlOfficer(LandVerificationOfficer lOfficer) {
		this.lOfficer = lOfficer;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", password=" + password + ", role=" + role + "]";
	}

}
