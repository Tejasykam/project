package com.sapient.aem.service;

import java.util.List;

import com.sapient.aem.exception.PatientHistoryException;
import com.sapient.aem.model.PatientHistory;

public interface PatientHistoryService {
	public abstract PatientHistory getPatientHistoryById(Integer phid) throws PatientHistoryException;
	public abstract List<PatientHistory> getPatientHistory() throws PatientHistoryException;
    public abstract Integer  addPatientHistory(PatientHistory ph) throws PatientHistoryException;
    public abstract String updatePatientHistory(PatientHistory ph) throws PatientHistoryException;
    public abstract String deletePatientHistory(Integer phid) throws PatientHistoryException;
    public abstract List<PatientHistory> SearchPatientHistory(String message)  throws PatientHistoryException;


}
