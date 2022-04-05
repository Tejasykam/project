package com.sapient.aem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.sapient.aem.model.Doctor;
import com.sapient.aem.model.PatientHistory;

public class PatientSearchDaoImpl implements PatientSearchDAO{

	@Override
	public List<Doctor> searchByDoctorName(String doctorName) throws SQLException {
		String sql= "select * from doctor where doctor_name=?";
		Connection connection=null;
		try {

			Context envContext = (Context) new InitialContext().lookup("java:comp/env");		
			DataSource dataSource = (DataSource) envContext.lookup("jdbc/hmsDB");
			connection= dataSource.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, doctorName);
			ResultSet resultSet = preparedStatement.executeQuery();
			List<Doctor> doctorList=new ArrayList<>();	
			while(resultSet.next()) {
				Doctor doctor= new Doctor();
				populateDoctor(resultSet,doctor);
				doctorList.add(doctor);				
			}

			return doctorList;

		}catch(SQLException e) {
			throw e;
		}catch(Exception e) {
			throw new SQLException(e.getMessage());
		}
		
	}
	private void populateDoctor(ResultSet resultSet, Doctor doctor) throws SQLException {
		doctor.setDoctorId(resultSet.getInt("doctor_id"));
		doctor.setDoctorName(resultSet.getString("doctor_name"));
		doctor.setSpecialization(resultSet.getString("specialization"));
		doctor.setAvailableTiming(resultSet.getString("available_timings"));
		doctor.setQualification(resultSet.getString("qualification"));
		doctor.setExperienceInYears(resultSet.getString("experience_in_years"));
		doctor.setMobile(resultSet.getString("mobile"));
		doctor.setEmail(resultSet.getString("email"));
		
	}
		

	@Override
	public List<Doctor> searchBySpecialization(String specialization) throws SQLException {
		String sql= "select * from doctor where specialization=? or qualification=? or doctor_name=?";
		Connection connection=null;
		try {

			Context envContext = (Context) new InitialContext().lookup("java:comp/env");		
			DataSource dataSource = (DataSource) envContext.lookup("jdbc/hmsDB");
			connection= dataSource.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, specialization);
			preparedStatement.setString(2, specialization);
			preparedStatement.setString(3, specialization);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			List<Doctor> doctorList=new ArrayList<>();	
			while(resultSet.next()) {
				Doctor doctor= new Doctor();
				populateDoctor(resultSet,doctor);
				doctorList.add(doctor);				
			}

			return doctorList;

		}catch(SQLException e) {
			throw e;
		}catch(Exception e) {
			throw new SQLException(e.getMessage());
		}
		
	
	}

	@Override
	public List<PatientHistory> getHistroyByPatientId(Integer patientId) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
