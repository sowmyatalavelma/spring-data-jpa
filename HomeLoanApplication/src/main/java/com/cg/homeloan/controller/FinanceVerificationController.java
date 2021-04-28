package com.cg.homeloan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cg.homeloan.dto.CreateFinanceVerificationRequest;
import com.cg.homeloan.dto.CreateLoanApplicationRequest;
import com.cg.homeloan.dto.CustomerDetails;
import com.cg.homeloan.dto.FinanceVerificationDetails;
import com.cg.homeloan.dto.LoanApplicationDetails;
import com.cg.homeloan.dto.UserDetails;
import com.cg.homeloan.entities.Customer;
import com.cg.homeloan.entities.FinanceVerificationOfficer;
import com.cg.homeloan.entities.LoanApplication;
import com.cg.homeloan.entities.User;
import com.cg.homeloan.service.IFinanceVerificationService;
import com.cg.homeloan.util.FinanceVerificationUtil;
import com.cg.homeloan.util.LoanApplicationUtil;

/**
 * 
 * @author VINAYA SREE
 *
 */

@RestController
@RequestMapping("/financeverification")
public class FinanceVerificationController {
	@Autowired
	private IFinanceVerificationService service;
	@Autowired
	private FinanceVerificationUtil fUtil;
	@Autowired
	private LoanApplicationUtil lUtil;

	@ResponseStatus(code=HttpStatus.OK)
	@PutMapping("/update")
	public LoanApplicationDetails updateStatus(@RequestBody CreateLoanApplicationRequest loanApplication) {
		System.out.println("requested Data " + loanApplication);
		LoanApplication loanApp = new LoanApplication(loanApplication.getApplicationId(),
				loanApplication.getApplicationDate(), loanApplication.getLoanAppliedAmount(),
				loanApplication.getLoanApprovedAmount(), loanApplication.isLandVerificationApproval(),
				loanApplication.isFinanceVerificationApproval(), loanApplication.isAdminApproval(),
				loanApplication.getStatus());
		CustomerDetails customerDetails = loanApplication.getCustomer();
		System.out.println("requested Customer Data" + customerDetails);
		Customer cust = new Customer(customerDetails);
		UserDetails ud = customerDetails.getUser();
		User user = new User(ud);
		user.setCustomer(cust);
		cust.setUser(user);
		cust.setLoanApplication(loanApp);
		loanApp.setCustomer(cust);
		System.out.println(loanApp);
		LoanApplication newLoanApp = service.updateStatus(loanApp);
		LoanApplicationDetails details = lUtil.toDetails(newLoanApp);
		System.out.println("updated Data " + newLoanApp);
		return details;
	}

	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("/add")
	public FinanceVerificationDetails addOfficer(@RequestBody CreateFinanceVerificationRequest reqData) {

		FinanceVerificationOfficer financeOfficer = new FinanceVerificationOfficer(reqData.getUserId(),
				reqData.getFinOfficerName(), reqData.getFinOfficerContact(), reqData.getUser());
		FinanceVerificationOfficer fOfficer = service.addOfficer(financeOfficer);

		return fUtil.toDetails(fOfficer);
	}

}
