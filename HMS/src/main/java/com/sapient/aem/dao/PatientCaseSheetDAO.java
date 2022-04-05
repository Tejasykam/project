package com.sapient.aem.dao;

import java.sql.SQLException;
import java.util.List;

import com.sapient.aem.model.PatientCaseSheet;

public interface PatientCaseSheetDAO {
	public abstract PatientCaseSheet getPatientCaseSheetById(Integer patientCaseSheetId) throws SQLException;
	public abstract List<PatientCaseSheet> getPatientCasesheet() throws SQLException;
	public abstract String addPatientCaseSheet(PatientCaseSheet patientCaseSheetId) throws SQLException;
	public abstract String updatePatientCaseSheet(PatientCaseSheet patientCaseSheetId) throws SQLException;
	public abstract String deletePatientCaseSheet(Integer patientCaseSheetId) throws SQLException;
	public abstract List<PatientCaseSheet> getPatientCasesheetByDoctorId(Integer doctorId) throws SQLException;
}
