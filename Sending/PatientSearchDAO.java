package com.sapient.aem.dao;

import java.sql.SQLException;
import java.util.List;

import com.sapient.aem.model.Doctor;
import com.sapient.aem.model.PatientHistory;

public interface PatientSearchDAO {
	public abstract  List<Doctor> searchByDoctorName(String doctorName) throws SQLException;
	public abstract  List<Doctor> searchBySpecialization(String specialization) throws SQLException;
	public abstract  List<PatientHistory> getHistroyByPatientId(Integer patientId) throws SQLException;

}
