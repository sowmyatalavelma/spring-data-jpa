package com.cg.homeloan.util;

/**
 * 
 * @author VINAYA SREE
 *
 */

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cg.homeloan.dto.CustomerDetails;
import com.cg.homeloan.dto.LoanApplicationDetails;
import com.cg.homeloan.dto.UserDetails;
import com.cg.homeloan.entities.Customer;
import com.cg.homeloan.entities.LoanApplication;
import com.cg.homeloan.entities.User;

@Component
public class LoanApplicationUtil {
	public LoanApplicationDetails toDetails(LoanApplication loanApplication) {
		Customer cust = loanApplication.getCustomer();
		CustomerDetails cd = new CustomerDetails(cust);
		User user = loanApplication.getCustomer().getUser();
		UserDetails ud = new UserDetails(user);

		LoanApplicationDetails loanAppDetails = new LoanApplicationDetails(loanApplication.getApplicationId(),
				loanApplication.getApplicationDate(), loanApplication.getLoanAppliedAmount(),
				loanApplication.getLoanApprovedAmount(), loanApplication.isLandVerificationApproval(),
				loanApplication.isFinanceVerificationApproval(), loanApplication.isAdminApproval(),
				loanApplication.getStatus(), cd);
		return loanAppDetails;

	}

	public List<LoanApplicationDetails> toDetails(List<LoanApplication> list) {
		List<LoanApplicationDetails> loanAppDetails = new ArrayList<>();
		for (LoanApplication loanApp : list) {
			loanAppDetails.add(toDetails(loanApp));
		}
		return loanAppDetails;
	}
}