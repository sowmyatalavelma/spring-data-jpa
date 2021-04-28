package com.cg.homeloan.service;

/**
 * 
 * @author VINAYA SREE
 *
 */

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.homeloan.entities.EMI;
import com.cg.homeloan.entities.LoanAgreement;
import com.cg.homeloan.entities.LoanApplication;
import com.cg.homeloan.entities.Status;
import com.cg.homeloan.exception.CustomerNotFoundException;
import com.cg.homeloan.exception.LoanAgreementException;
import com.cg.homeloan.exception.UserNotFoundException;
import com.cg.homeloan.repository.ILoanAgreementRepository;
import com.cg.homeloan.repository.ILoanApplicationRepository;
import com.cg.homeloan.util.EMICalculator;

@Service
@Transactional
public class LoanAgreementImpl implements ILoanAgreementService {

	@Autowired
	private ILoanAgreementRepository lDao;
	@Autowired
	private ILoanApplicationRepository aDao;
	@Autowired
	private EMICalculator eCal;

	@Override
	public LoanAgreement addLoanAgreement(LoanAgreement loanAgreement) {

		return lDao.save(loanAgreement);
	}

	@Override
	public LoanAgreement updateLoanAgreement(LoanAgreement loanAgreement) {

		Optional<LoanAgreement> loanOpt = lDao.findById(loanAgreement.getLoanAgreementId());
		if (loanOpt.isPresent()) {
			LoanAgreement loanAgmt = loanOpt.get();
			System.out.println("printing " + loanAgmt);
			Optional<LoanApplication> opt = aDao.findById(loanAgreement.getLoanapplicationId());
			if (opt.isPresent()) {
				LoanApplication loanApp = opt.get();
				System.out.println("printng " + loanApp);
				if (loanApp.getStatus().equals(Status.APPROVED)) {

					EMI emi = loanAgmt.getEmi();
					emi.setLoanAmount(loanApp.getLoanAppliedAmount());
					emi.setEmiAmount(eCal.getEMIAmount(emi));
					emi.setInterestAmount(emi.getEmiAmount() * 12);
					System.out.println("printing " + emi);

					return lDao.save(loanAgmt);
				}

			}
		} else {
			throw new LoanAgreementException("Application rejected for id " + loanAgreement.getLoanapplicationId());
		}
		return loanAgreement;

	}

	@Override
	public List<LoanAgreement> retrieveAllLoanAgreement() {

		return lDao.findAll();
	}

	@Override
	public LoanAgreement retrieveLoanAgreementById(long loanAgreementId) {
		Optional<LoanAgreement> opt = lDao.findById(loanAgreementId);

		if (opt.isPresent())
			return opt.get();
		throw new LoanAgreementException("LoanAgreement not found for id" + loanAgreementId);
	}

	@Override
	public LoanAgreement deleteLoanAgreement(long loanAgreementId) {
		Optional<LoanAgreement> loanData = lDao.findById(loanAgreementId);

		if (loanData.isPresent()) {
			LoanAgreement loanAgr = loanData.get();
			lDao.delete(loanAgr);
			return loanAgr;
		} else
			throw new LoanAgreementException("Customer Not found for id" + loanAgreementId);

	}

}
