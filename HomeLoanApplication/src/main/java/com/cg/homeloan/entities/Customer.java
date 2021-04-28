package com.cg.homeloan.entities;

/**
 * 
 * @author VINAYA SREE
 *
 */

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.cg.homeloan.dto.CustomerDetails;

@Entity
@Table(name = "cust")
public class Customer {

	@Id
	@Column(name = "cust_id")
	private String userId;
	private String customerName;
	@Column(unique = true, nullable = false)
	private String mobileNumber;
	private String emailId;
	private LocalDate dateOfBirth;
	private String gender;
	private String nationality;
	@Column(unique = true, nullable = false)
	private String aadharNumber;
	@Column(unique = true, nullable = false)
	private String panNumber;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private User user;
	@OneToOne(mappedBy = "customer")
	private LoanApplication loanApplication;

	public Customer() {

	}

	public Customer(String userId, String customerName, String mobileNumber, String emailId, LocalDate dateOfBirth,
			String gender, String nationality, String aadharNumber, String panNumber) {
		this.userId = userId;
		this.customerName = customerName;
		this.mobileNumber = mobileNumber;
		this.emailId = emailId;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.nationality = nationality;
		this.aadharNumber = aadharNumber;
		this.panNumber = panNumber;
	}

	public Customer(String userId, String customerName, String mobileNumber, String emailId, LocalDate dateOfBirth,
			String gender, String nationality, String aadharNumber, String panNumber, User user) {
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

	public Customer(String userId, String customerName, String mobileNumber, String emailId, LocalDate dateOfBirth,
			String gender, String nationality, String aadharNumber, String panNumber, User user,
			LoanApplication loanApplication) {
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
		this.loanApplication = loanApplication;
	}

	public Customer(String id) {
		this.userId = id;

	}

	public Customer(CustomerDetails customerDetails) {
		this.userId = customerDetails.getUserId();
		this.customerName = customerDetails.getCustomerName();
		this.mobileNumber = customerDetails.getMobileNumber();
		this.emailId = customerDetails.getEmailId();
		this.dateOfBirth = customerDetails.getDateOfBirth();
		this.gender = customerDetails.getGender();
		this.nationality = customerDetails.getNationality();
		this.aadharNumber = customerDetails.getAadharNumber();
		this.panNumber = customerDetails.getPanNumber();

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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public LoanApplication getLoanApplication() {
		return loanApplication;
	}

	public void setLoanApplication(LoanApplication loanApplication) {
		this.loanApplication = loanApplication;
	}

	@Override
	public String toString() {
		return "Customer [userId=" + userId + ", customerName=" + customerName + ", mobileNumber=" + mobileNumber
				+ ", emailId=" + emailId + ", dateOfBirth=" + dateOfBirth + ", gender=" + gender + ", nationality="
				+ nationality + ", aadharNumber=" + aadharNumber + ", panNumber=" + panNumber + ", user=" + user + "]";
	}

}
