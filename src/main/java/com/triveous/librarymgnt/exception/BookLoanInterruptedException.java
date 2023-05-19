package com.triveous.librarymgnt.exception;

public class BookLoanInterruptedException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BookLoanInterruptedException() {
		super();
	}
	
	public BookLoanInterruptedException(String s) {
		super(s);
	}
}
