package com.sapient.aem.service;

import java.sql.SQLException;
import java.util.List;

import com.sapient.aem.exception.PatientSearchException;
import com.sapient.aem.model.Doctor;
import com.sapient.aem.model.PatientHistory;

public interface PatientSearchService {
	public abstract  List<Doctor> searchByDoctorName(String doctorName) throws  PatientSearchException;
	public abstract  List<Doctor> searchBySpecialization(String specialization) throws PatientSearchException;
	public abstract  List<PatientHistory> getHistroyByPatientId(Integer patientId) throws PatientSearchException;

}
