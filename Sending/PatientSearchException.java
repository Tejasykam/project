package com.sapient.aem.exception;

public class PatientSearchException extends Exception{
private static final long serialVersionUID = 1L;
	
	public PatientSearchException() {
		super("Patient Search Exception");
	}
	public PatientSearchException(String message) {
		super(message);
	}
	public PatientSearchException(String message,Throwable t) {
		super(message,t);
	}

}
