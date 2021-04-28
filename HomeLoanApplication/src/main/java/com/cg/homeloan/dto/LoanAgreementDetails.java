package com.cg.homeloan.dto;

/**
 * 
 * @author VINAYA SREE
 *
 */

import com.cg.homeloan.entities.LoanAgreement;

public class LoanAgreementDetails {
	private long loanAgreementId;
	private long loanapplicationId;
	private EMIDetails emi;

	public LoanAgreementDetails() {

	}

	public LoanAgreementDetails(long loanAgreementId, long loanapplicationId, EMIDetails emi) {
		super();
		this.loanAgreementId = loanAgreementId;
		this.loanapplicationId = loanapplicationId;
		this.emi = emi;
	}

	public LoanAgreementDetails(LoanAgreement loanAgreement) {
		this.loanAgreementId = loanAgreement.getLoanAgreementId();
		this.loanapplicationId = loanAgreement.getLoanapplicationId();
		this.emi = new EMIDetails(loanAgreement.getEmi());
	}

	public long getLoanapplicationId() {
		return loanapplicationId;
	}

	public void setLoanapplicationId(long loanapplicationId) {
		this.loanapplicationId = loanapplicationId;
	}

	public long getLoanAgreementId() {
		return loanAgreementId;
	}

	public void setLoanAgreementId(long loanAgreementId) {
		this.loanAgreementId = loanAgreementId;
	}

	public EMIDetails getEmi() {
		return emi;
	}

	public void setEmi(EMIDetails emi) {
		this.emi = emi;
	}

	@Override
	public String toString() {
		return "LoanAgreementDetails [loanAgreementId=" + loanAgreementId + ", loanapplication=" + loanapplicationId
				+ ", emi=" + emi + "]";
	}

}
