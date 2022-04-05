package com.sapient.aem.dao;

import java.sql.SQLException;
import java.util.List;

import com.sapient.aem.model.Patient;

public interface PatientDAO {
	 public abstract String  addPatient(Patient patient) throws SQLException;
     public abstract List<Patient> getPatient() throws SQLException;
     public abstract String updatePatient(Patient patient) throws SQLException;
     public abstract String deletePatient(Integer patientId) throws SQLException;
     public abstract Patient getPatientById(Integer PatientId) throws SQLException;

}
