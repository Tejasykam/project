package com.sapient.aem.service;

import java.sql.SQLException;
import java.util.List;

import com.sapient.aem.dao.PatientDAO;
import com.sapient.aem.dao.PatientDaoImpl;
import com.sapient.aem.exception.DoctorException;
import com.sapient.aem.exception.PatientException;
import com.sapient.aem.model.Doctor;
import com.sapient.aem.model.Patient;

public class PatientServiceImpl implements PatientService{

	private PatientDAO patientDao=new PatientDaoImpl(); 
	
	@Override
	public Patient getPatientById(Integer patientId) throws PatientException {
		try {
			Patient patient=  patientDao.getPatientById(patientId);
			return patient; 
		}catch(SQLException e) {
			
			throw new PatientException(e.getMessage(),e);
		}
	}
	
	@Override
	public List<Patient> getAllPatients() throws PatientException {
		try {
			List<Patient> patientList= patientDao.getAllPatients();
			return patientList; 
		}catch(SQLException e) {
			
			throw new PatientException(e.getMessage(),e);
		}
	}

	
	@Override
	public Integer addPatient(Patient patient) throws PatientException {
		try {
			Integer patientId=patientDao.addPatient(patient);
			return patientId;
		}catch(SQLException e) {
			throw new PatientException(e.getMessage(),e);
		}
		
	}


	

	@Override
	public String updatePatient(Patient patient) throws PatientException {
		try {
			String result= patientDao.updatePatient(patient);
			return result; 
		}catch(SQLException e) {
			throw new PatientException(e.getMessage(),e);
		}
	}

	@Override
	public String deletePatient(Integer patientId) throws PatientException {
		try {
			String result= patientDao.deletePatient(patientId);			
			return result; 
		}catch(SQLException e) {
			//converting SQLException to EmployeeException
			throw new PatientException(e.getMessage(),e);
		}
	}

	

}
