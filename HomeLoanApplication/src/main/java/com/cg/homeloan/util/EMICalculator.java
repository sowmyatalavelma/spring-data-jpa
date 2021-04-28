package com.cg.homeloan.util;

/**
 * 
 * @author VINAYA SREE
 *
 */

import org.springframework.stereotype.Component;

import com.cg.homeloan.entities.EMI;

@Component
public class EMICalculator {

	public double getEMIAmount(EMI emi) {
		double rateOfInterest = 12.0;
		int tenure = 24;
		double emiAmount = (emi.getLoanAmount() * rateOfInterest * Math.pow(1 + rateOfInterest, tenure))
				/ (Math.pow(1 + rateOfInterest, tenure) - 1);
		return emiAmount;

	}

}
