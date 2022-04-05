package com.sapient.aem.exception;

public class PatientCaseSheetException extends Exception{
	private static final long serialVersionUID = 1L;
	public PatientCaseSheetException() {
		super();
	}
	
	public PatientCaseSheetException(String message) {
		super(message);
	}
	
	public PatientCaseSheetException(String message,Throwable t) {
		super(message,t);
	}
}