package com.cg.homeloan.util;

/**
 * 
 * @author VINAYA SREE
 *
 */

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cg.homeloan.dto.FinanceVerificationDetails;
import com.cg.homeloan.dto.UserDetails;
import com.cg.homeloan.entities.FinanceVerificationOfficer;
import com.cg.homeloan.entities.User;

@Component
public class FinanceVerificationUtil {
	public FinanceVerificationDetails toDetails(FinanceVerificationOfficer finOfficer) {

		User user = finOfficer.getUser();
		UserDetails ud = new UserDetails(user);
		FinanceVerificationDetails fDetails = new FinanceVerificationDetails(finOfficer.getUserId(),
				finOfficer.getFinOfficerName(), finOfficer.getFinOfficerContact(), ud);

		return fDetails;
	}

	public List<FinanceVerificationDetails> toDetails(List<FinanceVerificationOfficer> list) {
		List<FinanceVerificationDetails> fDetails = new ArrayList<>();
		for (FinanceVerificationOfficer flist : list) {
			fDetails.add(toDetails(flist));
		}
		return fDetails;

	}

}
