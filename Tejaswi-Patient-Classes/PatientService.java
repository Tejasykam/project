package com.sapient.aem.service;

import java.util.List;

import com.sapient.aem.exception.PatientException;
import com.sapient.aem.model.Patient;

public interface PatientService {
	public abstract String  addPatient(Patient patient) throws PatientException;
    public abstract List<Patient> getPatient() throws PatientException;
    public abstract String updatePatient(Patient patient) throws PatientException;
    public abstract String deletePatient(Patient patient) throws PatientException;
    public abstract Patient getPatientById(Integer patientId) throws PatientException;
}
