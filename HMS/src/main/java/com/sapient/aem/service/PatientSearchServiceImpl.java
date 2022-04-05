package com.sapient.aem.service;

import java.sql.SQLException;
import java.util.List;

import com.sapient.aem.dao.PatientSearchDAO;
import com.sapient.aem.dao.PatientSearchDaoImpl;
import com.sapient.aem.exception.PatientSearchException;
import com.sapient.aem.model.Doctor;
import com.sapient.aem.model.PatientHistory;

public class PatientSearchServiceImpl implements PatientSearchService{
	private PatientSearchDAO patientSearchDAO = new PatientSearchDaoImpl();


	

	@Override
	public List<Doctor> searchedDoctors(String search) throws PatientSearchException {


		try {
		
			List<Doctor> doctorList= patientSearchDAO.searchedDoctors(search);
			
			return doctorList;
		}catch(SQLException e) {
			
			throw new PatientSearchException(e.getMessage(),e);
		}
		
	
		
		
	}




	@Override
	public List<PatientHistory> getHistroyByPatientId(Integer patientId) throws PatientSearchException {



		try {
		
			List<PatientHistory> patientHistoryList= patientSearchDAO.getHistroyByPatientId(patientId);
			
			return patientHistoryList;
		}catch(SQLException e) {
			
			throw new PatientSearchException(e.getMessage(),e);
		}
		
	
		
		
	
		
	}

	
	
	
	

}
