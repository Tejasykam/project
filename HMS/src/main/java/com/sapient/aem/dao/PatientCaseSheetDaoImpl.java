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

import com.sapient.aem.model.PatientCaseSheet;

public class PatientCaseSheetDaoImpl implements PatientCaseSheetDAO {
	@Override
	public PatientCaseSheet getPatientCaseSheetById(Integer patientCaseSheetId) throws SQLException {
		String sql="select * from patient_case_sheet where patientCaseSheetId= ?";
		Connection connection=null;
		try {
			//JNDI
			Context envContext = (Context) new InitialContext().lookup("java:comp/env");		
			DataSource dataSource = (DataSource) envContext.lookup("jdbc/hmsDB");
			connection= dataSource.getConnection();
			PreparedStatement preparedStatement= connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, patientCaseSheetId);
			ResultSet resultSet= preparedStatement.executeQuery();
			if(resultSet.next()) {
				PatientCaseSheet patientCaseSheet= new PatientCaseSheet();
				//copy contents contents of resultset object into employee object
				populatePatientCaseSheet(resultSet,patientCaseSheet);
				return patientCaseSheet;				
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
	
	private void populatePatientCaseSheet(ResultSet resultSet, PatientCaseSheet patientCaseSheet) throws SQLException{
		//here empno is column name
		patientCaseSheet.setPatientCaseSheetId(resultSet.getInt("patientCaseSheetId"));
		patientCaseSheet.setPatientName(resultSet.getString("patientName"));
		patientCaseSheet.setCaseSheetOpenDate(resultSet.getDate("caseSheetOpenDate").toLocalDate());
		patientCaseSheet.setCaseSheetCloseDate(resultSet.getDate("caseSheetCloseDate").toLocalDate());
		patientCaseSheet.setHostipalDetails(resultSet.getString("hostipalDetails"));
		patientCaseSheet.setHealthStatistics(resultSet.getString("healthStatistics"));
		patientCaseSheet.setSymptoms(resultSet.getString("symptoms"));
		patientCaseSheet.setPrescription(resultSet.getString("prescription"));
		patientCaseSheet.setDiet(resultSet.getString("diet"));
		patientCaseSheet.setStatus(resultSet.getString("status"));
		patientCaseSheet.setPatientId(resultSet.getInt("patientId"));
		patientCaseSheet.setDoctorId(resultSet.getInt("doctorId"));

	}
	
	@Override
	public List<PatientCaseSheet> getPatientCasesheet() throws SQLException {
		String sql= "select * from patient_case_sheet";
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
			List<PatientCaseSheet> patientCaseSheetList=new ArrayList<>();			
			while(resultSet.next()) {
				PatientCaseSheet patientCaseSheet= new PatientCaseSheet();
				populatePatientCaseSheet(resultSet,patientCaseSheet);
				patientCaseSheetList.add(patientCaseSheet);				
			}

			return patientCaseSheetList;

		}catch(SQLException e) {
			throw e;
		}catch(Exception e) {
			throw new SQLException(e.getMessage());
		}finally {
			connection.close();
		}
	}

	@Override
	public String addPatientCaseSheet(PatientCaseSheet patientCaseSheet) throws SQLException {
		String sql= "insert into patient_case_sheet(patientCaseSheetId,patientName,caseSheetOpenDate,caseSheetCloseDate,hostipalDetails,healthStatistics,symptoms,prescription,diet,status,patientId,doctorId) values(?,?,?,?,?,?,?,?,?,?,?,?)";
		Connection connection=null;
		try{
			Context envContext = (Context) new InitialContext().lookup("java:comp/env");		
			DataSource dataSource = (DataSource) envContext.lookup("jdbc/hmsDB");
			connection= dataSource.getConnection();
			PreparedStatement preparedStatement= connection.prepareStatement(sql);

			//replace the place holders
			preparedStatement.setString(1, patientCaseSheet.getPatientName());
			preparedStatement.setDate(2,java.sql.Date.valueOf(patientCaseSheet.getCaseSheetOpenDate()));
			preparedStatement.setDate(3,java.sql.Date.valueOf(patientCaseSheet.getCaseSheetCloseDate()));
			preparedStatement.setDate(4, java.sql.Date.valueOf(patientCaseSheet.getHostipalDetails()));
			preparedStatement.setString(5, patientCaseSheet.getHealthStatistics());
			preparedStatement.setString(6, patientCaseSheet.getDiet());
			preparedStatement.setString(7, patientCaseSheet.getStatus());
			preparedStatement.setInt(8, patientCaseSheet.getPatientId());
			preparedStatement.setInt(9, patientCaseSheet.getDoctorId());
			preparedStatement.setString(10, patientCaseSheet.getPrescription());
			int n= preparedStatement.executeUpdate();
			if(n>0) {
				return "Added PatientCaseSheet to database";
			}else {
				return "Unable to add PatientCaseSheet to database";
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
	public String updatePatientCaseSheet(PatientCaseSheet patientCaseSheet) throws SQLException {
		String sql="update patient_case_sheet set caseSheetOpenDate=?,caseSheetCloseDate=?,hostipalDetails=?,healthStatistics=?, symptoms=?,prescription=?,diet=?,status=?,patientId=?,doctorId=? where patientCaseSheetId=?";
		Connection connection=null;
		try {
			Context envContext = (Context) new InitialContext().lookup("java:comp/env");		
			DataSource dataSource = (DataSource) envContext.lookup("jdbc/hmsDB");
			connection= dataSource.getConnection();
			PreparedStatement preparedStatement= connection.prepareStatement(sql);

			preparedStatement.setString(1, patientCaseSheet.getPatientName());
			preparedStatement.setDate(2,java.sql.Date.valueOf(patientCaseSheet.getCaseSheetOpenDate()));
			preparedStatement.setDate(3,java.sql.Date.valueOf(patientCaseSheet.getCaseSheetCloseDate()));
			preparedStatement.setDate(4, java.sql.Date.valueOf(patientCaseSheet.getHostipalDetails()));
			preparedStatement.setString(5, patientCaseSheet.getHealthStatistics());
			preparedStatement.setString(6, patientCaseSheet.getDiet());
			preparedStatement.setString(7, patientCaseSheet.getStatus());
			preparedStatement.setInt(8, patientCaseSheet.getPatientId());
			preparedStatement.setInt(9, patientCaseSheet.getDoctorId());
			preparedStatement.setString(10, patientCaseSheet.getPrescription());

			int n = preparedStatement.executeUpdate();
			if(n>0) {
				return "PatientCaseSheetId: "+ patientCaseSheet.getPatientCaseSheetId()+" updated";
			}else {
				return "Unable to update patientCaseSheetId: "+ patientCaseSheet.getPatientCaseSheetId();
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
	public String deletePatientCaseSheet(Integer patientCaseSheetId) throws SQLException {
		String sql="delete from patient_case_sheet where patientCaseSheetId=?";
		Connection connection=null;
		try{
			Context envContext = (Context) new InitialContext().lookup("java:comp/env");		
			DataSource dataSource = (DataSource) envContext.lookup("jdbc/hmsDB");
			connection= dataSource.getConnection();
			PreparedStatement preparedStatement= connection.prepareStatement(sql);

			preparedStatement.setInt(1, patientCaseSheetId);
			int n= preparedStatement.executeUpdate();
			if(n>0) {
				return "PatientCaseSheetId"+patientCaseSheetId+" deleted from database";
			}else {
				return "Unable to delete empno: "+patientCaseSheetId;
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
	public List<PatientCaseSheet> getPatientCasesheetByDoctorId(Integer doctorId) throws SQLException {
		String sql= "select * from patient_case_sheet where doctor_id=?";
		Connection connection=null;
		try {

			Context envContext = (Context) new InitialContext().lookup("java:comp/env");		
			DataSource dataSource = (DataSource) envContext.lookup("jdbc/hmsDB");
			connection= dataSource.getConnection();
			PreparedStatement preparedStatement= connection.prepareStatement(sql);
			preparedStatement.setInt(1,doctorId);

			ResultSet resultSet= preparedStatement.executeQuery();
			
			List<PatientCaseSheet> patientCaseSheetList=new ArrayList<>();			
			while(resultSet.next()) {
				PatientCaseSheet patientCaseSheet= new PatientCaseSheet();
				populatePatientCaseSheet(resultSet,patientCaseSheet);
				patientCaseSheetList.add(patientCaseSheet);				
			}

			return patientCaseSheetList;

		}catch(SQLException e) {
			throw e;
		}catch(Exception e) {
			throw new SQLException(e.getMessage());
		}finally {
			connection.close();
		}
		
	}
}
