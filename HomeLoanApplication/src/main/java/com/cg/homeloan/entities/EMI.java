package com.cg.homeloan.entities;

/**
 * 
 * @author VINAYA SREE
 *
 */

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.cg.homeloan.dto.EMIDetails;

@Entity
@Table(name = "EMI_DETATLS")
public class EMI {

	@Id
	@GeneratedValue
	private long EMIId;
	private LocalDate dueDate;
	private double emiAmount;
	private double loanAmount;
	private double interestAmount;
	@OneToOne(mappedBy = "emi")
	private LoanAgreement loanAgreement;

	public EMI() {
	}

	public EMI(LocalDate dueDate, double emiAmount, double loanAmount, double interestAmount,
			LoanAgreement loanAgreement) {
		// this.EMIId = eMIId;
		this.dueDate = dueDate;
		this.emiAmount = emiAmount;
		this.loanAmount = loanAmount;
		this.interestAmount = interestAmount;
		this.loanAgreement = loanAgreement;
	}

	public EMI(long eMIId, LocalDate dueDate, double emiAmount, double loanAmount, double interestAmount,
			LoanAgreement loanAgreement) {
		super();
		this.EMIId = eMIId;
		this.dueDate = dueDate;
		this.emiAmount = emiAmount;
		this.loanAmount = loanAmount;
		this.interestAmount = interestAmount;
		this.loanAgreement = loanAgreement;
	}

	public EMI(long eMIId, LocalDate dueDate, double emiAmount, double loanAmount, double interestAmount) {
		super();
		this.EMIId = eMIId;
		this.dueDate = dueDate;
		this.emiAmount = emiAmount;
		this.loanAmount = loanAmount;
		this.interestAmount = interestAmount;

	}

	public EMI(EMIDetails emid) {
		this.EMIId = emid.getEMIId();
		this.dueDate = emid.getDueDate();
		this.emiAmount = emid.getEmiAmount();
		this.loanAmount = emid.getLoanAmount();
		this.interestAmount = emid.getInterestAmount();

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

	public LoanAgreement getLoanAgreement() {
		return loanAgreement;
	}

	public void setLoanAgreement(LoanAgreement loanAgreement) {
		this.loanAgreement = loanAgreement;
	}

	@Override
	public String toString() {
		return "EMI [EMIId=" + EMIId + ", dueDate=" + dueDate + ", emiAmount=" + emiAmount + ", loanAmount="
				+ loanAmount + ", interestAmount=" + interestAmount + "]";
	}

}
