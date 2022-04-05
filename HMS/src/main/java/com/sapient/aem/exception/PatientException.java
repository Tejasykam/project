package com.sapient.aem.exception;

public class PatientException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public PatientException() {
		super("Patient Exception");
	}
	public PatientException(String message) {
		super(message);
	}
	public PatientException(String message,Throwable t) {
		super(message,t);
	}


}