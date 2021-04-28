package com.cg.homeloan.dto;

/**
 * 
 * @author VINAYA SREE
 *
 */

public class CreateLoanAgreement {

	private long loanAgreementId;
	private long loanapplicationId;
	private EMIDetails emi;

	public long getLoanAgreementId() {
		return loanAgreementId;
	}

	public void setLoanAgreementId(long loanAgreementId) {
		this.loanAgreementId = loanAgreementId;
	}

	public long getLoanapplicationId() {
		return loanapplicationId;
	}

	public void setLoanapplicationId(long loanapplicationId) {
		this.loanapplicationId = loanapplicationId;
	}

	public EMIDetails getEmi() {
		return emi;
	}

	public void setEmi(EMIDetails emi) {
		this.emi = emi;
	}

	@Override
	public String toString() {
		return "CreateLoanAgreement [loanAgreementId=" + loanAgreementId + ", loanapplicationId=" + loanapplicationId
				+ ", emi=" + emi + "]";
	}

}
