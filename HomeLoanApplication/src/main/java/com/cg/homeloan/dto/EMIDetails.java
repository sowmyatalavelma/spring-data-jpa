package com.cg.homeloan.dto;

import java.time.LocalDate;

import com.cg.homeloan.entities.EMI;

/**
 * 
 * @author VINAYA SREE
 *
 */

public class EMIDetails {

	private long EMIId;
	private LocalDate dueDate;
	private double emiAmount;
	private double loanAmount;
	private double interestAmount;

	public EMIDetails() {

	}

	public EMIDetails(long eMIId, LocalDate dueDate, double emiAmount, double loanAmount, double interestAmount) {
		super();
		this.EMIId = eMIId;
		this.dueDate = dueDate;
		this.emiAmount = emiAmount;
		this.loanAmount = loanAmount;
		this.interestAmount = interestAmount;
	}

	public EMIDetails(EMI emi) {
		this.EMIId = emi.getEMIId();
		this.dueDate = emi.getDueDate();
		this.emiAmount = emi.getEmiAmount();
		this.loanAmount = emi.getLoanAmount();
		this.interestAmount = emi.getInterestAmount();
	}

	public long getEMIId() {
		return EMIId;
	}

	public void setEMIId(long eMIId) {
		EMIId = eMIId;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public double getEmiAmount() {
		return emiAmount;
	}

	public void setEmiAmount(double emiAmount) {
		this.emiAmount = emiAmount;
	}

	public double getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}

	public double getInterestAmount() {
		return interestAmount;
	}

	public void setInterestAmount(double interestAmount) {
		this.interestAmount = interestAmount;
	}

	@Override
	public String toString() {
		return "EMIDetails [EMIId=" + EMIId + ", dueDate=" + dueDate + ", emiAmount=" + emiAmount + ", loanAmount="
				+ loanAmount + ", interestAmount=" + interestAmount + "]";
	}

}
