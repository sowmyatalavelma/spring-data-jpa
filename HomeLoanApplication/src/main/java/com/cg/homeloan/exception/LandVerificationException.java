package com.cg.homeloan.exception;

public class LandVerificationException extends RuntimeException{

	/**
	 * @author VINAYA SREE
	 */
	private static final long serialVersionUID = 1L;

	public LandVerificationException(String msg) {
		super(msg);
		
	}

	public LandVerificationException(String message, Throwable cause) {
		super(message, cause);

	}
	
	

}
