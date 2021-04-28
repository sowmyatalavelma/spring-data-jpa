package com.cg.homeloan.service;

/**
 * 
 * @author VINAYA SREE
 *
 */

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.homeloan.entities.Customer;
import com.cg.homeloan.entities.LoanApplication;
import com.cg.homeloan.entities.Status;
import com.cg.homeloan.exception.CustomerNotFoundException;
import com.cg.homeloan.exception.LoanApplicationNotFoundException;
import com.cg.homeloan.exception.UserNotFoundException;
import com.cg.homeloan.repository.ILoanApplicationRepository;

@Service
@Transactional
public class LoanApplicationImpl implements ILoanApplicationService {

	@Autowired
	private ILoanApplicationRepository aDao;

	@Override
	public LoanApplication addLoanApplication(LoanApplication loanApplication) {
		LoanApplication la = aDao.save(loanApplication);
		return la;
	}

	@Override
	public LoanApplication updateLoanApplication(LoanApplication loanApplication) {
		Optional<LoanApplication> loanData = this.aDao.findById(loanApplication.getApplicationId());
		if (loanData.isPresent()) {
			LoanApplication loan = loanData.get();
			if (loan.isFinanceVerificationApproval() && loan.isLandVerificationApproval()) {
				loan.setAdminApproval(true);
				loan.setStatus(Status.APPROVED);
			} else if (loan.getStatus().equals(Status.WAITING_FOR_FINANCE_APPROVAL)) {
				loan.setStatus(Status.PENDING);
				loan.setAdminApproval(false);
			}

			else {
				loan.setStatus(Status.REJECTED);
				loan.setAdminApproval(false);
			}

			return aDao.save(loan);
		} else
			throw new LoanApplicationNotFoundException(
					"Invalid Application for Id" + loanApplication.getApplicationId());
	}

	@Override
	public LoanApplication deleteLoanApplication(long loanApplicationId) {
		Optional<LoanApplication> loanData = this.aDao.findById(loanApplicationId);

		if (loanData.isPresent()) {
			LoanApplication loanApp = loanData.get();
			aDao.delete(loanApp);
			return loanApp;
		} else
			throw new LoanApplicationNotFoundException("Customer Not found for id" + loanApplicationId);

	}

	@Override
	public List<LoanApplication> retrieveAllLoanApplication() {
		return aDao.findAll();
	}

	@Override
	public LoanApplication retrieveLoanApplicationById(long loanApplicationId) {

		Optional<LoanApplication> opt = aDao.findById(loanApplicationId);
		if (opt.isPresent())
			return opt.get();
		throw new LoanApplicationNotFoundException("LoanApplication not found for id" + loanApplicationId);
	}

}
