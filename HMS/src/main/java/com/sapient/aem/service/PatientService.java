package com.sapient.aem.service;

import java.util.List;

import com.sapient.aem.exception.PatientException;
import com.sapient.aem.model.Patient;

public interface PatientService {
	public abstract Patient getPatientById(Integer patientId) throws PatientException;
	public abstract List<Patient> getAllPatients() throws PatientException;
    public abstract Integer  addPatient(Patient patient) throws PatientException;
    public abstract String updatePatient(Patient patient) throws PatientException;
    public abstract String deletePatient(Integer patientId) throws PatientException;
    
}
