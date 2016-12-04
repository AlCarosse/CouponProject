package com.anton.coupons.exceptions;

import com.anton.coupons.enums.ErrorType;

public class ApplicationException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ErrorType errorType;
	
	public ErrorType getErrorType() {
		return errorType;
	}

	public void setErrorType(ErrorType errorType) {
		this.errorType = errorType;
	}

	public ApplicationException(ErrorType errorType, Throwable cause, String messege){
		super(messege, cause);
		this.errorType = errorType;
	}
	

	
	

}
