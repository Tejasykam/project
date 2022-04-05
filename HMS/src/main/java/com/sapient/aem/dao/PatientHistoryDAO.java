package com.sapient.aem.dao;

import java.sql.SQLException;
import java.util.List;

import com.sapient.aem.model.PatientHistory;

public interface PatientHistoryDAO {
	public abstract PatientHistory getPatientHistoryById(Integer phid) throws SQLException;
    public abstract List<PatientHistory> getPatientHistory() throws SQLException;
    public abstract Integer addPatientHistory(PatientHistory ph) throws SQLException;
    public abstract String updatePatientHistory(PatientHistory ph) throws SQLException;
    public abstract String deletePatientHistory(Integer phid) throws SQLException;
    public abstract List<PatientHistory> SearchPatientHistory(String message)  throws SQLException;
}
