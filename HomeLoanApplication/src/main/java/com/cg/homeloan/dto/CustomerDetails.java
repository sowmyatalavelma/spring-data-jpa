package com.cg.homeloan.dto;

import java.time.LocalDate;

import com.cg.homeloan.entities.Customer;

/**
 * 
 * @author VINAYA SREE
 *
 */

public class CustomerDetails {
	private String userId;
	private String customerName;
	private String mobileNumber;
	private String emailId;
	private LocalDate dateOfBirth;
	private String gender;
	private String nationality;
	private String aadharNumber;
	private String panNumber;

	private UserDetails user;

	public CustomerDetails() {
		super();

	}

	public CustomerDetails(String userId, String customerName, String mobileNumber, String emailId,
			LocalDate dateOfBirth, String gender, String nationality, String aadharNumber, String panNumber,
			UserDetails user) {
		super();
		this.userId = userId;
		this.customerName = customerName;
		this.mobileNumber = mobileNumber;
		this.emailId = emailId;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.nationality = nationality;
		this.aadharNumber = aadharNumber;
		this.panNumber = panNumber;
		this.user = user;
	}

	public CustomerDetails(Customer cust) {
		this.userId = cust.getUserId();
		this.customerName = cust.getCustomerName();
		this.mobileNumber = cust.getMobileNumber();
		this.emailId = cust.getEmailId();
		this.dateOfBirth = cust.getDateOfBirth();
		this.gender = cust.getGender();
		this.nationality = cust.getNationality();
		this.aadharNumber = cust.getAadharNumber();
		this.panNumber = cust.getPanNumber();
		this.user = new UserDetails(cust.getUser());
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getAadharNumber() {
		return aadharNumber;
	}

	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}

	public String getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

	public UserDetails getUser() {
		return user;
	}

	public void setUser(UserDetails user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "CustomerDetails [userId=" + userId + ", customerName=" + customerName + ", mobileNumber=" + mobileNumber
				+ ", emailId=" + emailId + ", dateOfBirth=" + dateOfBirth + ", gender=" + gender + ", nationality="
				+ nationality + ", aadharNumber=" + aadharNumber + ", panNumber=" + panNumber + ", user=" + user + "]";
	}

}
