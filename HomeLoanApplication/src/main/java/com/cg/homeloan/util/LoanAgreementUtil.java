package com.cg.homeloan.util;

/**
 * 
 * @author VINAYA SREE
 *
 */

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cg.homeloan.dto.EMIDetails;
import com.cg.homeloan.dto.LoanAgreementDetails;
import com.cg.homeloan.entities.EMI;
import com.cg.homeloan.entities.LoanAgreement;

@Component
public class LoanAgreementUtil {
	public LoanAgreementDetails toDetails(LoanAgreement loanAgreement) {

		EMI emi = loanAgreement.getEmi();
		EMIDetails emiDetails = new EMIDetails(emi);
		LoanAgreementDetails loanAgmtDetails = new LoanAgreementDetails(loanAgreement.getLoanAgreementId(),
				loanAgreement.getLoanapplicationId(), emiDetails);
		return loanAgmtDetails;
	}

	public List<LoanAgreementDetails> toDetails(List<LoanAgreement> list) {
		List<LoanAgreementDetails> loanAgreementDetails = new ArrayList<>();
		for (LoanAgreement loanAgree : list) {
			loanAgreementDetails.add(toDetails(loanAgree));
		}
		return loanAgreementDetails;
	}
}