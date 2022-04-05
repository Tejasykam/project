package com.sapient.aem.exception;

public class PatientHistoryException extends Exception{

	private static final long serialVersionUID = 1L;
	public PatientHistoryException() {
		super("PatientHistory Exception");
	}
	public PatientHistoryException(String message) {
		super(message);
	}
	public PatientHistoryException(String message,Throwable t) {
		super(message,t);
	}

	

}