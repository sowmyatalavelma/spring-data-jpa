package com.cg.homeloan.exception;

public class FinanceVerificationException extends RuntimeException {

	/**
	 * @author VINAYA SREE
	 */
	private static final long serialVersionUID = 1L;



	public FinanceVerificationException(String msg) {
		super(msg);
		
	}

	

	public FinanceVerificationException(String message, Throwable cause) {
		super(message, cause);
		
	}


	
}
