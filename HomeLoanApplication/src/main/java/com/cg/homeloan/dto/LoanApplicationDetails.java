package com.cg.homeloan.dto;

/**
 * 
 * @author VINAYA SREE
 *
 */

import java.time.LocalDate;

import com.cg.homeloan.entities.LoanApplication;
import com.cg.homeloan.entities.Status;

public class LoanApplicationDetails {
	private long applicationId;
	private LocalDate applicationDate;
	private double loanAppliedAmount;
	private double loanApprovedAmount;
	private boolean landVerificationApproval;
	private boolean financeVerificationApproval;
	private boolean adminApproval;
	private Status status;
	private CustomerDetails customer;

	public LoanApplicationDetails() {

	}

	public LoanApplicationDetails(long applicationId, LocalDate applicationDate, double loanAppliedAmount,
			double loanApprovedAmount, boolean landVerificationApproval, boolean financeVerificationApproval,
			boolean adminApproval, Status status, CustomerDetails customer) {

		this.applicationId = applicationId;
		this.applicationDate = applicationDate;
		this.loanAppliedAmount = loanAppliedAmount;
		this.loanApprovedAmount = loanApprovedAmount;
		this.landVerificationApproval = landVerificationApproval;
		this.financeVerificationApproval = financeVerificationApproval;
		this.adminApproval = adminApproval;
		this.status = status;
		this.customer = customer;
	}

	public LoanApplicationDetails(LoanApplication loanapplication) {
		this.applicationId = loanapplication.getApplicationId();
		this.applicationDate = loanapplication.getApplicationDate();
		this.loanAppliedAmount = loanapplication.getLoanAppliedAmount();
		this.loanApprovedAmount = loanapplication.getLoanApprovedAmount();
		this.landVerificationApproval = loanapplication.isLandVerificationApproval();
		this.financeVerificationApproval = loanapplication.isFinanceVerificationApproval();
		this.adminApproval = loanapplication.isAdminApproval();
		this.status = loanapplication.getStatus();
		this.customer = new CustomerDetails(loanapplication.getCustomer());
	}

	public long getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(long applicationId) {
		this.applicationId = applicationId;
	}

	public LocalDate getApplicationDate() {
		return applicationDate;
	}

	public void setApplicationDate(LocalDate applicationDate) {
		this.applicationDate = applicationDate;
	}

	public double getLoanAppliedAmount() {
		return loanAppliedAmount;
	}

	public void setLoanAppliedAmount(double loanAppliedAmount) {
		this.loanAppliedAmount = loanAppliedAmount;
	}

	public double getLoanApprovedAmount() {
		return loanApprovedAmount;
	}

	public void setLoanApprovedAmount(double loanApprovedAmount) {
		this.loanApprovedAmount = loanApprovedAmount;
	}

	public boolean isLandVerificationApproval() {
		return landVerificationApproval;
	}

	public void setLandVerificationApproval(boolean landVerificationApproval) {
		this.landVerificationApproval = landVerificationApproval;
	}

	public boolean isFinanceVerificationApproval() {
		return financeVerificationApproval;
	}

	public void setFinanceVerificationApproval(boolean financeVerificationApproval) {
		this.financeVerificationApproval = financeVerificationApproval;
	}

	public boolean isAdminApproval() {
		return adminApproval;
	}

	public void setAdminApproval(boolean adminApproval) {
		this.adminApproval = adminApproval;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public CustomerDetails getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerDetails customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "LoanApplicationDetails [applicationId=" + applicationId + ", applicationDate=" + applicationDate
				+ ", loanAppliedAmount=" + loanAppliedAmount + ", loanApprovedAmount=" + loanApprovedAmount
				+ ", landVerificationApproval=" + landVerificationApproval + ", financeVerificationApproval="
				+ financeVerificationApproval + ", adminApproval=" + adminApproval + ", status=" + status
				+ ", customer=" + customer + "]";
	}

}
