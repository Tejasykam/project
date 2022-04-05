package com.sapient.aem.service;

import java.sql.SQLException;
import java.util.List;

import com.sapient.aem.dao.PatientDAO;
import com.sapient.aem.dao.PatientDaoImpl;
import com.sapient.aem.exception.PatientException;
import com.sapient.aem.model.Patient;

public class PatientServiceImpl implements PatientService{
	private PatientDAO patientDao=new PatientDaoImpl(); 

	@Override
	public String addPatient(Patient patient) throws PatientException {
		try {
			String result=patientDao.addPatient(patient);
			return result;
		}catch(SQLException e) {
			throw new PatientException(e.getMessage(),e);
		}
		
	}

	
	@Override
	public List<Patient> getPatient() throws PatientException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updatePatient(Patient patient) throws PatientException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deletePatient(Patient patient) throws PatientException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Patient getPatientById(Integer patientId) throws PatientException {
		// TODO Auto-generated method stub
		return null;
	}

}
