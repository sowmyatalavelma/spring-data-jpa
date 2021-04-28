package com.cg.homeloan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cg.homeloan.dto.CreateLoanAgreement;
import com.cg.homeloan.dto.EMIDetails;
import com.cg.homeloan.dto.LoanAgreementDetails;
import com.cg.homeloan.entities.EMI;
import com.cg.homeloan.entities.LoanAgreement;
import com.cg.homeloan.service.ILoanAgreementService;
import com.cg.homeloan.util.LoanAgreementUtil;
/**
 * 
 * @author VINAYA SREE
 *
 */

@RestController
@RequestMapping("/loanagreement")
public class LoanAgreementController {

	@Autowired
	private ILoanAgreementService service;
	@Autowired
	private LoanAgreementUtil lUtil;

	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("/add")
	public LoanAgreementDetails addLoanAgreement(@RequestBody CreateLoanAgreement reqAgreement) {
		System.out.println("reqdata " + reqAgreement);
		LoanAgreement loanAgreement = new LoanAgreement(reqAgreement.getLoanAgreementId(),
				reqAgreement.getLoanapplicationId());
		EMIDetails emiDetails = reqAgreement.getEmi();
		EMI emi = new EMI(emiDetails);
		emi.setLoanAgreement(loanAgreement);
		loanAgreement.setEmi(emi);

		LoanAgreement loanAgmnt = service.addLoanAgreement(loanAgreement);
		System.out.println("added data " + loanAgmnt);
		return lUtil.toDetails(loanAgreement);
	}

	@ResponseStatus(code = HttpStatus.OK)
	@PutMapping("/update")
	public LoanAgreementDetails updateLoanAgreement(@RequestBody CreateLoanAgreement reqAgreement) {
		System.out.println("reqAgreement " + reqAgreement);
		LoanAgreement loanAgreement = new LoanAgreement(reqAgreement.getLoanAgreementId(),
				reqAgreement.getLoanapplicationId());
		EMIDetails emidetails = reqAgreement.getEmi();
		EMI emi = new EMI(emidetails);
		emi.setLoanAgreement(loanAgreement);
		loanAgreement.setEmi(emi);
		LoanAgreement loanAgmnt = service.updateLoanAgreement(loanAgreement);
		System.out.println("updated Data " + loanAgmnt);
		return lUtil.toDetails(loanAgmnt);
	}

	@ResponseStatus(code = HttpStatus.OK)
	@DeleteMapping("/delete/{id}")
	public LoanAgreementDetails deleteAgreement(@PathVariable("id") long loanAgreementId) {
		LoanAgreement loanAgmnt = service.deleteLoanAgreement(loanAgreementId);
		return lUtil.toDetails(loanAgmnt);
	}
	
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping("/view/{id}")
	public LoanAgreementDetails retrieveLoanAgreementById(@PathVariable("id") long loanAgreementById)
	{
		LoanAgreement loanAgmnt=service.retrieveLoanAgreementById(loanAgreementById);
		return lUtil.toDetails(loanAgmnt);
	}
	
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping("/findall")
	public List<LoanAgreementDetails> retrieveAllLoanAgreement()
	{
		List<LoanAgreement> list=service.retrieveAllLoanAgreement();
		return lUtil.toDetails(list);
	}
}
