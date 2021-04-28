package com.cg.homeloan.service;

import java.util.List;

import com.cg.homeloan.entities.LoanAgreement;

public interface ILoanAgreementService{
	
	public LoanAgreement addLoanAgreement(LoanAgreement loanAgreement) ;
		
		public LoanAgreement updateLoanAgreement(LoanAgreement loanAgreement);
		public LoanAgreement deleteLoanAgreement(long loanAgreementId);
		public List<LoanAgreement> retrieveAllLoanAgreement();
		public LoanAgreement retrieveLoanAgreementById(long loanAgreementId);
		
		




}
