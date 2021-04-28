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

import com.cg.homeloan.dto.LoanApplicationDetails;
import com.cg.homeloan.entities.LoanApplication;
import com.cg.homeloan.service.ILoanApplicationService;
/**
 * 
 * @author VINAYA SREE
 *
 */

@RestController
@RequestMapping("/loanapplication")
public class LoanApplicationController {
	@Autowired
	private ILoanApplicationService service;

	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("/add")
	public LoanApplication addLoanApplication(@RequestBody LoanApplication loanApplication) {
		LoanApplication lapp = service.addLoanApplication(loanApplication);
		return lapp;

	}

	@ResponseStatus(code=HttpStatus.OK)
	@GetMapping("/find/{id}")
	public LoanApplication retrieveLoanApplicationById(@PathVariable("id") Long id) {
		LoanApplication loanApp = service.retrieveLoanApplicationById(id);
		return loanApp;
	}

	@ResponseStatus(code=HttpStatus.OK)
	@PutMapping("/update")
	public LoanApplication updateLoanApplication(@RequestBody LoanApplication loanApplication) {
		return service.updateLoanApplication(loanApplication);
	}
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping("/findall")
	public List<LoanApplication> findAll()
	{
		
		return service.retrieveAllLoanApplication();
	}
	@ResponseStatus(code = HttpStatus.OK)
	@DeleteMapping("/delete/{id}")
	public LoanApplication deleteLoanApplication(long loanapplicationId)
	{
		return service.deleteLoanApplication(loanapplicationId);
	}

}
