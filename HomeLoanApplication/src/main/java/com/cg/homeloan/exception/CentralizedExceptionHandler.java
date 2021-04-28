package com.cg.homeloan.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author VINAYA SREE
 */

@RestControllerAdvice
public class CentralizedExceptionHandler {
	@ResponseStatus(code=HttpStatus.NOT_FOUND)
	@ExceptionHandler(CustomerNotFoundException.class)
	public String handleCustomerNotFound(CustomerNotFoundException e)
	{
		return e.getMessage();
	}
	@ResponseStatus(code=HttpStatus.NOT_FOUND)
	@ExceptionHandler(FinanceVerificationException.class)
	public String handleFinanceVerification(FinanceVerificationException e)
	{
		return e.getMessage();
	}
	@ResponseStatus(code=HttpStatus.NOT_FOUND)
	@ExceptionHandler(LandVerificationException.class)
	public String handleLandVerification(LandVerificationException e)
	{
		return e.getMessage();
	}
	@ResponseStatus(code=HttpStatus.NOT_FOUND)
	@ExceptionHandler(LoanAgreementException.class)
	public String handleLoanAgreement(LoanAgreementException e)
	{
		return e.getMessage();
	}
	@ResponseStatus(code=HttpStatus.NOT_FOUND)
	@ExceptionHandler(LoanApplicationNotFoundException.class)
	public String handleLandVerification(LoanApplicationNotFoundException e)
	{
		return e.getMessage();
	}
	
	@ResponseStatus(code=HttpStatus.NOT_FOUND)
	@ExceptionHandler(UserNotFoundException.class)
	public String handleUserNotFound(UserNotFoundException e)
	{
		return e.getMessage();
	}
}
