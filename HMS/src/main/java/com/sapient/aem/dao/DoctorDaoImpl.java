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

public class DoctorDaoImpl implements DoctorDAO{
                     //ADDING DOCTOR
	@Override
	public Integer addDoctor(Doctor doctor) throws SQLException {
		String sql="insert into doctor(doctor_name,specialization,available_timings,qualification,experience_in_years,mobile,email) values(?,?,?,?,?,?,?)";
		Connection connection=null;
		try {
			Context envContext = (Context) new InitialContext().lookup("java:comp/env");		
			DataSource dataSource = (DataSource) envContext.lookup("jdbc/hmsDB");
			connection= dataSource.getConnection();
			PreparedStatement preparedStatement= connection.prepareStatement(sql);
			
			preparedStatement.setString(1,doctor.getDoctorName());
			preparedStatement.setString(2,doctor.getSpecialization());
			preparedStatement.setString(3,doctor.getAvailableTiming());
			preparedStatement.setString(4,doctor.getQualification());
			preparedStatement.setString(5,doctor.getExperienceInYears());
			preparedStatement.setString(6,doctor.getMobile());
			preparedStatement.setString(7,doctor.getEmail());
			
			int n=preparedStatement.executeUpdate();
			
			if(n>0) {
				return this.getMaxId();
			}else {
				throw new SQLException("Unable to add doctor");
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
		String sql="select max(doctor_id) from doctor";
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
                        //DELETE DOCTOR
	@Override
	public String deleteDoctor(Integer doctorId) throws SQLException {
		String sql="delete from doctor where doctor_id=?";
		Connection connection=null;
		try{
			Context envContext = (Context) new InitialContext().lookup("java:comp/env");		
			DataSource dataSource = (DataSource) envContext.lookup("jdbc/hmsDB");
			connection= dataSource.getConnection();
			PreparedStatement preparedStatement= connection.prepareStatement(sql);

			preparedStatement.setInt(1, doctorId);
			int n= preparedStatement.executeUpdate();
			if(n>0) {
				return "Doctorid:"+doctorId+" deleted from database";
			}else {
				return "Unable to delete Doctorid: "+doctorId;
			}

		}catch(SQLException e) {
			throw e;
		}catch(Exception e) {
			throw new SQLException(e.getMessage());
		}
	}

	@Override
	public Doctor getDoctorById(Integer doctorId) throws SQLException {
		String sql="select * from doctor doctor_id=?";
		Connection connection = null;
		try {
			Context envContext = (Context) new InitialContext().lookup("java:comp/env");
			DataSource dataSource = (DataSource) envContext.lookup("jdbc/hmsDB");
			connection=dataSource.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, doctorId);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				Doctor d = new Doctor();
				populateDoctor(resultSet,d);
				return d;
			}else {
				return null;
			}
		}catch(SQLException e) {
			throw e;
		}catch(Exception e) {
			throw new SQLException(e.getMessage());
		}
	}

	private void populateDoctor(ResultSet resultSet, Doctor d) throws SQLException {
		d.setDoctorId(resultSet.getInt("doctor_id"));
		d.setDoctorName(resultSet.getString("doctor_name"));
		d.setSpecialization(resultSet.getString("specialization"));
		d.setAvailableTiming(resultSet.getString("available_timings"));
		d.setQualification(resultSet.getString("qualification"));
		d.setExperienceInYears(resultSet.getString("experience_in_years"));
		d.setMobile(resultSet.getString("mobile"));
		d.setEmail(resultSet.getString("email"));
		
	}

	@Override
	public List<Doctor> getAllDoctorDetails() throws SQLException {
		String sql= "select * from doctor";
		Connection connection=null;
		try {

			Context envContext = (Context) new InitialContext().lookup("java:comp/env");		
			DataSource dataSource = (DataSource) envContext.lookup("jdbc/hmsDB");
			connection= dataSource.getConnection();
			Statement statement= 
					connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
							ResultSet.CONCUR_UPDATABLE);

			ResultSet resultSet= statement.executeQuery(sql);
			if ( resultSet.last()) {
				resultSet.beforeFirst();
			}
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
	public String updateDoctor(Doctor doctor) throws SQLException {
		String sql="update doctor set available_timings=?,experience_in_years=?,mobile=?,email=? where doctor_id=?";
		Connection connection=null;
		try {
			Context envContext = (Context) new InitialContext().lookup("java:comp/env");		
			DataSource dataSource = (DataSource) envContext.lookup("jdbc/hmsDB");
			connection= dataSource.getConnection();
			PreparedStatement preparedStatement= connection.prepareStatement(sql);
			preparedStatement.setString(1, doctor.getAvailableTiming());
			preparedStatement.setString(2, doctor.getExperienceInYears());
			preparedStatement.setString(3, doctor.getMobile());
			preparedStatement.setString(4, doctor.getEmail());
			preparedStatement.setInt(5, doctor.getDoctorId());

			int n = preparedStatement.executeUpdate();
			if(n>0) {
				return "Doctor id: "+ doctor.getDoctorId()+" updated";
			}else {
				return "Unable to update doctor id: "+ doctor.getDoctorId();
			}

		}catch(SQLException e) {
			throw e;
		}catch(Exception e) {
			throw new SQLException(e.getMessage());
		}
	}

}
