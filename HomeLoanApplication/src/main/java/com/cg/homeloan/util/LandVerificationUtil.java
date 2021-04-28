package com.cg.homeloan.util;

/**
 * 
 * @author VINAYA SREE
 *
 */

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cg.homeloan.dto.LandVerificationOfficerDetails;
import com.cg.homeloan.dto.UserDetails;
import com.cg.homeloan.entities.LandVerificationOfficer;
import com.cg.homeloan.entities.User;

@Component
public class LandVerificationUtil {
	public LandVerificationOfficerDetails toDetails(LandVerificationOfficer landOfficer) {

		User user = landOfficer.getUser();
		UserDetails ud = new UserDetails(user);
		LandVerificationOfficerDetails lDetails = new LandVerificationOfficerDetails(landOfficer.getUserId(),
				landOfficer.getOfficerName(), landOfficer.getOfficerContact(), ud);
		return lDetails;
	}

	public List<LandVerificationOfficerDetails> toDetails(List<LandVerificationOfficer> list) {
		List<LandVerificationOfficerDetails> lDetails = new ArrayList<>();
		for (LandVerificationOfficer lList : list) {
			lDetails.add(toDetails(lList));
		}
		return lDetails;
	}
}