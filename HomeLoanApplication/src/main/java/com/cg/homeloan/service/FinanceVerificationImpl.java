package com.cg.homeloan.service;

/**
 * 
 * @author VINAYA SREE
 *
 */

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.homeloan.entities.FinanceVerificationOfficer;

import com.cg.homeloan.entities.LoanApplication;
import com.cg.homeloan.entities.Status;
import com.cg.homeloan.exception.FinanceVerificationException;
import com.cg.homeloan.repository.IFinanceVerificationRepository;
import com.cg.homeloan.repository.ILoanApplicationRepository;

@Service
@Transactional
public class FinanceVerificationImpl implements IFinanceVerificationService {

	@Autowired
	private IFinanceVerificationRepository fDao;
	@Autowired
	private ILoanApplicationRepository lDao;

	@Override
	public LoanApplication updateStatus(LoanApplication loanApplication) {
		Optional<LoanApplication> loanData = this.lDao.findById(loanApplication.getApplicationId());
		if (loanData.isPresent()) {
			LoanApplication lapp = loanData.get();
			if (lapp.getStatus().equals(Status.PENDING)) {
				lapp.setStatus(Status.WAITING_FOR_LAND_VERIFICATION_OFFICE_APPROVAL);
			} else if (lapp.isLandVerificationApproval()) {
				lapp.setFinanceVerificationApproval(true);
				lapp.setStatus(Status.APPROVED);
			} else if (!lapp.isLandVerificationApproval()) {
				lapp.setFinanceVerificationApproval(false);
				lapp.setStatus(Status.REJECTED);
			}
			// LoanApplication updatedLoanApp=lDao.save(lapp);
			return lDao.save(lapp);
		}

		else {
			throw new FinanceVerificationException(
					"Could not update status of finance officer for id " + loanApplication.getApplicationId());
		}

	}

	@Override
	public FinanceVerificationOfficer addOfficer(FinanceVerificationOfficer financeOfficer) {

		// FinanceVerificationOfficer fOfficer=fDao.save(financeOfficer);
		return fDao.save(financeOfficer);
	}

}
