package com.sapient.aem.dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;



import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.sapient.aem.model.Patient;
import com.sapient.aem.model.Role;
import com.sapient.aem.model.User;



public class UserDaoImpl implements UserDAO{
	@Override
	public Boolean isValidUser(String userName, String password, Role role) throws Exception{
		String sql="select * from user where user_name=? and password=? and role=?";
		Connection connection=null;
		try {
			Context envContext = (Context) new InitialContext().lookup("java:comp/env");
			DataSource dataSource = (DataSource) envContext.lookup("jdbc/hmsDB");
			connection= dataSource.getConnection();
			PreparedStatement preparedStatement= connection.prepareStatement(sql);
			preparedStatement.setString(1, userName);
			preparedStatement.setString(2, password);
			preparedStatement.setString(3, role.toString());
			ResultSet resultSet= preparedStatement.executeQuery();
			if(resultSet.next()) {
				return true;
			}else {
				return false;
			}
		}catch(Exception e) {
			throw e;
		}finally {
			connection.close();
		}



	}
	@Override
	public Integer getUserId(User user) throws SQLException {
		String sql="select user_id from user where user_name=? and password=? and role=?";
		Connection connection=null;
		try {
			Context envContext = (Context) new InitialContext().lookup("java:comp/env");
			DataSource dataSource = (DataSource) envContext.lookup("jdbc/hmsDB");
			connection= dataSource.getConnection();
			PreparedStatement preparedStatement= connection.prepareStatement(sql);
			preparedStatement.setString(1, user.getUserName());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setString(3, user.getRole().toString());
			ResultSet resultSet= preparedStatement.executeQuery();
			if(resultSet.next()) {
				return resultSet.getInt("user_id");
			}else {
				return null;
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
	public Integer addUser(User user) throws SQLException {
		String sql = "insert into user(user_name,password,role) values(?,?,?)";
		Connection connection = null;
		try {
			Context envContext = (Context) new InitialContext().lookup("java:comp/env");
			DataSource dataSource = (DataSource) envContext.lookup("jdbc/hmsDB");
			connection= dataSource.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1,user.getUserName());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setString(3, user.getRole().toString());
			int n=preparedStatement.executeUpdate();
			if(n>0) {
				return this.getMaxId();
			}else {
				throw new SQLException("Unable to add record");
			}
//			if(n>0) {
//				return "Added user to database";
//			}else {
//				return "Unable to add user to database";
//			}
		}catch(SQLException e) {
			throw e;
		}catch(Exception e) {
			throw new SQLException(e.getMessage());
		}finally {
			connection.close();
		}
	}



	@Override
	public String deleteUser(Integer userId) throws SQLException {
		String sql = "delete from user where user_id=?";
		Connection connection = null;
		try {
			Context envContext = (Context) new InitialContext().lookup("java:comp/env");
			DataSource dataSource = (DataSource) envContext.lookup("jdbc/hmsDB");
			connection= dataSource.getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, userId);
			int n = ps.executeUpdate();
			if(n>0) {
				return "User id:"+userId+" deleted from database";
			}else {
				return "Unable to delete userId: "+userId;
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
	public User getUserById(Integer userId) throws SQLException {
		String sql = "select * from user where user_id=?";
		Connection connection = null;
		try {
			Context context = (Context) new InitialContext().lookup("java:com/env");
			DataSource dataSource = (DataSource) context.lookup("jdbc/hmsDB");
			connection=dataSource.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, userId);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				User u = new User();
				populateUser(resultSet,u);
				return u;
			}else {
				return null;
			}
		}catch(SQLException e) {
			throw e;
		}catch(Exception e) {
			throw new SQLException(e.getMessage());
		}finally {
			connection.close();
		}
	}


	private void populateUser(ResultSet resultSet, User u) throws SQLException {
		u.setUserName(resultSet.getString("user_name"));
		u.setPassword(resultSet.getString("password"));
		u.setUserId(resultSet.getInt("user_id"));
		u.setRole(resultSet.getString("role"));
	}



	@Override
	public List<User> getUser() throws SQLException {
		return null;
	}



	@Override
	public String updateUser(User user) throws SQLException {
		String sql = "update user set user_name=?,password=? where user_id=?";
		Connection connection = null;
		try {
			Context context = (Context) new InitialContext().lookup("java:comp/env");
			DataSource ds=(DataSource) context.lookup("jdbc/hmsDB");
			connection = ds.getConnection();
			PreparedStatement ps=connection.prepareStatement(sql);
			ps.setString(1, user.getUserName());
			ps.setString(2,user.getPassword());
			int n = ps.executeUpdate();
			if(n>0) {
				return "User id: "+ user.getUserId()+" updated";
			}else {
				return "Unable to update user id: "+ user.getUserId();
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
		String sql="select max(user_id) from user";
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
	public Boolean isValidUser(String userName, Role role) throws Exception {

		String sql="select * from user where user_name=? and role=?";
		Connection connection=null;
		try {
			Context envContext = (Context) new InitialContext().lookup("java:comp/env");		
			DataSource dataSource = (DataSource) envContext.lookup("jdbc/hmsDB");
			connection= dataSource.getConnection();
			PreparedStatement preparedStatement= connection.prepareStatement(sql);
			preparedStatement.setString(1, userName);
			preparedStatement.setString(2, role.toString());
			ResultSet resultSet= preparedStatement.executeQuery();
			if(resultSet.next()) {
				return true;
			}else {
				return false;
			}
		}catch(Exception e) {
			throw e;
		}finally {
			connection.close();
		}

	
	}
	@Override
	public String ForgotPassword(User user) throws SQLException {
		String sql = "update user set password=? where user_name=? and role=?";
		Connection connection = null;
		try {
			Context context = (Context) new InitialContext().lookup("java:comp/env");
			DataSource ds=(DataSource) context.lookup("jdbc/hmsDB");
			connection = ds.getConnection();
			PreparedStatement ps=connection.prepareStatement(sql);
			ps.setString(1,user.getPassword());
			ps.setString(2, user.getUserName());
			ps.setString(3, user.getRole().toString());
			int n = ps.executeUpdate();
			if(n>0) {
				return "password updated .";
			}else {
				return "Unable to update password .";
			}
		}catch(SQLException e) {
			throw e;
		}catch(Exception e) {
			throw new SQLException(e.getMessage());
		}finally {
			connection.close();
		}
	
		
	}


}

