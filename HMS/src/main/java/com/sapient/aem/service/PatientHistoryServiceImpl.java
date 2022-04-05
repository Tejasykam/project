package com.sapient.aem.service;

import java.sql.SQLException;
import java.util.List;

import com.sapient.aem.dao.PatientHistoryDAO;
import com.sapient.aem.dao.PatientHistoryDaoImpl;
import com.sapient.aem.exception.PatientHistoryException;
import com.sapient.aem.model.PatientHistory;

public class PatientHistoryServiceImpl implements PatientHistoryService {
	private PatientHistoryDAO patientHistoryDao=new PatientHistoryDaoImpl();

	@Override
	public Integer addPatientHistory(PatientHistory patientHistory) throws PatientHistoryException{
		try {
			Integer result= patientHistoryDao.addPatientHistory(patientHistory);
			return result; 
		}catch(SQLException e) {
			throw new PatientHistoryException(e.getMessage(),e);
		}
	}
	@Override
	public List<PatientHistory> getPatientHistory() throws PatientHistoryException {
		try {
			List<PatientHistory> PatientHistoryList= patientHistoryDao.getPatientHistory();

			return PatientHistoryList; 
		}catch(SQLException e) {

			throw new PatientHistoryException(e.getMessage(),e);
		}
	}
	@Override
	public String updatePatientHistory(PatientHistory patientHistory) throws PatientHistoryException {
		try {
			String result= patientHistoryDao.updatePatientHistory(patientHistory);
			return result; 
		}catch(SQLException e) {
			
			throw new PatientHistoryException(e.getMessage(),e);
		}
	}


	@Override
	public String deletePatientHistory(Integer patient_history_id) throws PatientHistoryException {
		try {
			String result=patientHistoryDao .deletePatientHistory( patient_history_id);			
			return result; 
		}catch(SQLException e) {
		
			throw new PatientHistoryException(e.getMessage(),e);
		}
	}

	@Override
	public PatientHistory getPatientHistoryById(Integer patient_history_id) throws PatientHistoryException {
		try {
			PatientHistory patientHistory= patientHistoryDao.getPatientHistoryById( patient_history_id);
			
			return patientHistory; 
		}catch(SQLException e) {
			
			throw new PatientHistoryException(e.getMessage(),e);
		}
	}
	@Override
	public List<PatientHistory> SearchPatientHistory(String message) throws PatientHistoryException {
		try {
			List<PatientHistory> PatientHistoryList= patientHistoryDao.SearchPatientHistory(message);

			return PatientHistoryList; 
		}catch(SQLException e) {
			throw new PatientHistoryException(e.getMessage(),e);
		}
	}
}
