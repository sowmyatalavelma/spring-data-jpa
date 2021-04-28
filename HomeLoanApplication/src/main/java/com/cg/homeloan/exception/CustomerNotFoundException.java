package com.cg.homeloan.exception;

public class CustomerNotFoundException extends RuntimeException {


/**
 * @author VINAYA SREE
 */
	private static final long serialVersionUID = 1L;

	public CustomerNotFoundException(String msg) {
		super(msg);
		
	}

	public CustomerNotFoundException(String message, Throwable cause) {
		super(message, cause);

	}

}
