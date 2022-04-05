package com.sapient.aem.service;

import java.util.List;

import com.sapient.aem.exception.PatientCaseSheetException;
import com.sapient.aem.model.PatientCaseSheet;

public interface PatientCaseSheetService {
	public abstract PatientCaseSheet getPatientCasesheetById(Integer patientCaseSheetId) throws PatientCaseSheetException ;
	public abstract List<PatientCaseSheet> getPatientCasesheet() throws PatientCaseSheetException;
	public abstract String addPatientCaseSheet(PatientCaseSheet patientCaseSheet) throws PatientCaseSheetException;
	public abstract String updatePatientCaseSheet(PatientCaseSheet patientCaseSheet) throws PatientCaseSheetException;
	public abstract String deletePatientCaseSheet(Integer patientCaseSheetId) throws PatientCaseSheetException;
}
