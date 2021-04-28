package com.cg.homeloan.service;

/**
 * 
 * @author VINAYA SREE
 *
 */

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.homeloan.entities.LandVerificationOfficer;
import com.cg.homeloan.entities.LoanApplication;
import com.cg.homeloan.entities.Status;
import com.cg.homeloan.exception.LandVerificationException;
import com.cg.homeloan.repository.ILandVerificationRepository;
import com.cg.homeloan.repository.ILoanApplicationRepository;

@Service
@Transactional
public class LandVerificationImpl implements ILandVerificationService {

	@Autowired
	private ILandVerificationRepository landDao;
	@Autowired
	private ILoanApplicationRepository loanDao;

	@Override
	public LoanApplication updateStatus(LoanApplication loanApplication) {
		Optional<LoanApplication> loanData = this.loanDao.findById(loanApplication.getApplicationId());
		if (loanData.isPresent()) {
			LoanApplication lapp = loanData.get();
			if (lapp.getStatus().equals(Status.PENDING)) {

				if (lapp.getCustomer().getAadharNumber().isEmpty() && lapp.getCustomer().getPanNumber().isEmpty()) {
					lapp.setStatus(Status.DOCUMENTS_NOT_UPLOADED);
				} else if (!lapp.getCustomer().getAadharNumber().isEmpty()
						&& !lapp.getCustomer().getPanNumber().isEmpty()) {
					lapp.setStatus(Status.DOCUMENTS_UPLOADED);
				}

			} else if (lapp.getStatus().equals(Status.DOCUMENTS_UPLOADED)) {
				if (lapp.getCustomer().getAadharNumber().length() == 12
						&& lapp.getCustomer().getPanNumber().length() == 10) {
					lapp.setStatus(Status.APPROVED);
					lapp.setLandVerificationApproval(true);
				} else {
					lapp.setStatus(Status.REJECTED);
					lapp.setLandVerificationApproval(false);
				}
			}
			// LoanApplication updatedLoanApp=loanDao.save(lapp);
			return loanDao.save(lapp);
		}

		else {
			throw new LandVerificationException(
					"Could not update status of landverification officer for id " + loanApplication.getApplicationId());
		}
	}

	@Override
	public LandVerificationOfficer addOfficer(LandVerificationOfficer landOfficer) {

		LandVerificationOfficer lOfficer = landDao.save(landOfficer);
		return lOfficer;
	}

}
