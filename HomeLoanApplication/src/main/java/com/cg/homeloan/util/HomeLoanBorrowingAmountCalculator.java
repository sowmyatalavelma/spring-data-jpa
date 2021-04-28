package com.cg.homeloan.util;

import com.cg.homeloan.entities.LoanApplication;

public class HomeLoanBorrowingAmountCalculator {

	LoanApplication loanApplication;
	private double loanAmount;
	private double rateOfInterest;
	private int tenure;
	private double totalAnnualIncome;
	private double monthlyExpenses;
	private double otherMonthlyExpenses;
	
	public HomeLoanBorrowingAmountCalculator() {
		
	}

	

	public HomeLoanBorrowingAmountCalculator(LoanApplication loanApplication, double loanAmount, double rateOfInterest,
			int tenure, double totalAnnualIncome, double monthlyExpenses, double otherMonthlyExpenses) {
		super();
		this.loanApplication = loanApplication;
		this.loanAmount = loanAmount;
		this.rateOfInterest = rateOfInterest;
		this.tenure = tenure;
		this.totalAnnualIncome = totalAnnualIncome;
		this.monthlyExpenses = monthlyExpenses;
		this.otherMonthlyExpenses = otherMonthlyExpenses;
	}



//	public LoanApplication getLoanApplication() {
//		return loanApplication;
//	}
//
//	public void setLoanApplication(LoanApplication loanApplication) {
//		this.loanApplication = loanApplication;
//	}

	public double getLoanAmount() {
		return loanAmount;
	}
	
	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanApplication.getLoanAppliedAmount();
	}




	public double getRateOfInterest() {
		return rateOfInterest;
	}




	public void setRateOfInterest(double rateOfInterest) {
		this.rateOfInterest = rateOfInterest;
	}




	public int getTenure() {
		return tenure;
	}




	public void setTenure(int tenure) {
		this.tenure = tenure;
	}




	public double getTotalAnnualIncome() {
		return totalAnnualIncome;
	}




	public void setTotalAnnualIncome(double totalAnnualIncome) {
		this.totalAnnualIncome = totalAnnualIncome;
	}




	public double getMonthlyExpenses() {
		return monthlyExpenses;
	}




	public void setMonthlyExpenses(double monthlyExpenses) {
		this.monthlyExpenses = monthlyExpenses;
	}




	public double getOtherMonthlyExpenses() {
		return otherMonthlyExpenses;
	}




	public void setOtherMonthlyExpenses(double otherMonthlyExpenses) {
		this.otherMonthlyExpenses = otherMonthlyExpenses;
	}




	public double getHomeLoanBorrowingAmount() {return 0;}
	
}
