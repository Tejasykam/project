package com.sapient.aem.exception;

public class DoctorException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public DoctorException() {
		super("Doctor Exception");
	}
	public DoctorException(String message) {
		super(message);
	}
	public DoctorException(String message,Throwable t) {
		super(message,t);
	}


}
