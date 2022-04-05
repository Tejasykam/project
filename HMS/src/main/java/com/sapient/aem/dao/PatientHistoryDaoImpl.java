package com.sapient.aem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.sapient.aem.model.Doctor;
import com.sapient.aem.model.PatientHistory;

public class PatientHistoryDaoImpl implements PatientHistoryDAO {
	@Override
	public PatientHistory getPatientHistoryById(Integer patient_history_id) throws SQLException {
		String sql= "select * from  patient_history  where patient_history_id=?";
		Connection connection=null;
		try{
			Context envContext = (Context) new InitialContext().lookup("java:comp/env");		
			DataSource dataSource = (DataSource) envContext.lookup("jdbc/hmsDB");
			connection= dataSource.getConnection();
			PreparedStatement preparedStatement= connection.prepareStatement(sql);
			preparedStatement.setInt(1,patient_history_id);
			ResultSet resultSet= preparedStatement.executeQuery();
			if(resultSet.next()) {
				PatientHistory patientHistory= new PatientHistory();

				populatePatientHistory(resultSet,patientHistory);
				return patientHistory;				
			}else {
				return null;
			}

		}catch(SQLException e) {
			//			e.printStackTrace();
			throw e;
		}catch(Exception e) {
			throw new SQLException(e.getMessage());
		}finally {
			connection.close();
		}
	}

	@Override
	public   List<PatientHistory> getPatientHistory() throws SQLException {
		String sql="select * from patient_history";
		Connection connection=null;
		try {
			Context envContext = (Context) new InitialContext().lookup("java:comp/env");		
			DataSource dataSource = (DataSource) envContext.lookup("jdbc/hmsDB");
			connection= dataSource.getConnection();
			Statement statement= 
					connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
							ResultSet.CONCUR_UPDATABLE);
			ResultSet resultSet= statement.executeQuery(sql);
			int rowcount=0;
			if ( resultSet.last()) {
				rowcount =  resultSet.getRow();
				resultSet.beforeFirst(); // not  resultSet.first() because the  resultSet.next() below will move on, missing the first element
			}
			List<PatientHistory> patienthistoryList=new ArrayList<>();			
			while(resultSet.next()) {
				PatientHistory patientHistory=new PatientHistory();
				populatePatientHistory(resultSet,patientHistory);
				patienthistoryList.add(patientHistory);		
			}
			return patienthistoryList;	
		}catch(SQLException e) {
			throw e;
		}catch(Exception e) {
			throw new SQLException(e.getMessage());
		}finally {
			connection.close();
		}
	}
	private void populatePatientHistory(ResultSet resultSet, PatientHistory patienthistory) throws SQLException {
		patienthistory.setPatientHistoryId(resultSet.getInt("patient_history_id"));
		patienthistory.setPatientName(resultSet.getString("patient_name"));
		patienthistory.setCaseSheetOpenDate(resultSet.getDate("case_sheet_open_date").toLocalDate());
		patienthistory.setCaseSheetCloseDate(resultSet.getDate("case_sheet_close_date").toLocalDate());		
		patienthistory.setHostipalDetails(resultSet.getString("hostipal_details"));
		patienthistory.setHealthStatistics(resultSet.getString("health_statistics"));
		patienthistory.setSymptoms(resultSet.getString("symptoms"));
		patienthistory.setPrescription(resultSet.getString("prescription"));
		patienthistory.setDiet(resultSet.getString("diet"));
		patienthistory.setPatientId(resultSet.getInt("patient_id"));
	}
	
	@Override
	public Integer addPatientHistory(PatientHistory patienthistory) throws SQLException {
		String sql="insert into patient_history (patient_name,case_sheet_open_date ,case_sheet_close_date,hostipal_details,health_statistics,symptoms,prescription ,diet ,patient_id) values (?,?,?,?,?,?,?,?,?)";
		Connection connection=null;
		try{
			Context envContext = (Context) new InitialContext().lookup("java:comp/env");		
			DataSource dataSource = (DataSource) envContext.lookup("jdbc/hmsDB");
			connection= dataSource.getConnection();
			PreparedStatement preparedStatement= connection.prepareStatement(sql);
			preparedStatement.setString(1, patienthistory.getPatientName());
			preparedStatement.setDate(2,java.sql.Date.valueOf(patienthistory.getCaseSheetOpenDate()));
			preparedStatement.setDate(3,java.sql.Date.valueOf(patienthistory.getCaseSheetCloseDate()));
			preparedStatement.setString(4,patienthistory.getHostipalDetails());
			preparedStatement.setString(5,patienthistory.getHealthStatistics());
			preparedStatement.setString(6, patienthistory.getSymptoms());
			preparedStatement.setString(7,patienthistory.getPrescription());
			preparedStatement.setString(8,patienthistory.getDiet());
			preparedStatement.setInt(9, patienthistory.getPatientId());
			int n= preparedStatement.executeUpdate();
			if(n>0) {
				return this.getMaxId();
			}else {
				throw new SQLException("Unable to add record");
			}

		}catch(SQLException e) {
			throw e;
		}catch(Exception e) {
			throw new SQLException(e.getMessage());
		}finally {
			connection.close();
		}
	}

	@Override
	public String updatePatientHistory(PatientHistory patienthistory) throws SQLException {
		String sql="update patient_history set hostipal_details=?, health_statistics=?, symptoms=?, prescription=?, diet=?  where patient_history_id=?";
		Connection connection=null;
		try {
			Context envContext = (Context) new InitialContext().lookup("java:comp/env");		
			DataSource dataSource = (DataSource) envContext.lookup("jdbc/hmsDB");
			connection= dataSource.getConnection();
			PreparedStatement preparedStatement= connection.prepareStatement(sql);
		
			preparedStatement.setString(1, patienthistory.getHostipalDetails());
			preparedStatement.setString(2, patienthistory.getHealthStatistics());
			preparedStatement.setString(3, patienthistory.getSymptoms());
			preparedStatement.setString(4,patienthistory.getPrescription());
			preparedStatement.setString(5,patienthistory.getDiet());
			int n = preparedStatement.executeUpdate();
			if(n>0) {
				return "Empno: "+ patienthistory.getPatientHistoryId()+" updated";
			}else {
				return "Unable to update empno: "+ patienthistory.getPatientHistoryId();
			}

		}catch(SQLException e) {
			throw e;
		}catch(Exception e) {
			throw new SQLException(e.getMessage());
		}finally {
			connection.close();
		}
	}
	@Override
	public String deletePatientHistory(Integer patientHistoryId) throws SQLException {
		String sql="delete from patient_history where patient_history_id=?";
		Connection connection=null;
		try{
			Context envContext = (Context) new InitialContext().lookup("java:comp/env");		
			DataSource dataSource = (DataSource) envContext.lookup("jdbc/hmsDB");
			connection= dataSource.getConnection();
			PreparedStatement preparedStatement= connection.prepareStatement(sql);
			preparedStatement.setInt(1, patientHistoryId);
			int n= preparedStatement.executeUpdate();
			if(n>0) {
				return "PatientHistory:"+patientHistoryId+" deleted from database";
			}else {
				return "Unable to delete PatientHistory: "+patientHistoryId;
			}
		}catch(SQLException e) {
			throw e;
		}catch(Exception e) {
			throw new SQLException(e.getMessage());
		}finally {
			connection.close();
		}
	}
	private Integer getMaxId()  throws SQLException{
		String sql="select max(patient_history_id ) from patient_history";
		Connection connection=null;
		try {
			Context envContext = (Context) new InitialContext().lookup("java:comp/env");		
			DataSource dataSource = (DataSource) envContext.lookup("jdbc/hmsDB");
			connection= dataSource.getConnection();
			Statement statement= connection.createStatement();
			ResultSet resultSet=statement.executeQuery(sql);
			
			if(resultSet.next()) {
				return resultSet.getInt(1);
			}else {
				throw new SQLException("No records in the table");
			}
		}catch(SQLException e) {
			throw e;
		}catch(Exception e) {
			throw new SQLException(e.getMessage());
		}finally {
			connection.close();
		}
	}

	@Override
	public List<PatientHistory> SearchPatientHistory(String message) throws SQLException {
		
		String sql="select * from patient_history where patient_name=?";
		Connection connection=null;
		try {

			Context envContext = (Context) new InitialContext().lookup("java:comp/env");		
			DataSource dataSource = (DataSource) envContext.lookup("jdbc/hmsDB");
			connection= dataSource.getConnection();
			PreparedStatement preparedStatement= connection.prepareStatement(sql);
			preparedStatement.setString(1,message);

			ResultSet resultSet= preparedStatement.executeQuery(sql);

			List<PatientHistory> patientHistoryList=new ArrayList<>();			
			while(resultSet.next()) {
				PatientHistory patientHistory=new PatientHistory();
				populatePatientHistory(resultSet,patientHistory);
				patientHistoryList.add(patientHistory);		
			}

			return patientHistoryList;

		}catch(SQLException e) {
			throw e;
		}catch(Exception e) {
			throw new SQLException(e.getMessage());
		}finally {
			connection.close();
		}

	}
	
	
}
