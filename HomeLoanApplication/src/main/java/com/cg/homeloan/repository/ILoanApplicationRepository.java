package com.cg.homeloan.repository;

/**
 * 
 * @author VINAYA SREE
 *
 */

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.homeloan.entities.LoanApplication;

public interface ILoanApplicationRepository extends JpaRepository<LoanApplication, Long> {

//	public LoanApplication addLoanApplication(LoanApplication loanApplication);
//	
//	public LoanApplication updateLoanApplication(LoanApplication loanApplication);
//	public LoanApplication deleteLoanApplication(long loanApplicationId);
//	public List<LoanApplication> retrieveAllLoanApplication();
//	public LoanApplication retrieveLoanApplicationById(long loanApplicationId);

}
