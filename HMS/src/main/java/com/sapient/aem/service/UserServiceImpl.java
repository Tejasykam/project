package com.sapient.aem.service;



import java.sql.SQLException;
import java.util.List;



import com.sapient.aem.dao.UserDAO;
import com.sapient.aem.dao.UserDaoImpl;
import com.sapient.aem.exception.PatientException;
import com.sapient.aem.exception.UserException;
import com.sapient.aem.model.Patient;
import com.sapient.aem.model.Role;
import com.sapient.aem.model.User;



public class UserServiceImpl implements UserService {
	private UserDAO userDao = new UserDaoImpl();
	@Override
	public Boolean isValidUser(String userName, String password, Role role) throws UserException {
		try {
			return userDao.isValidUser(userName, password, role);
		}catch(Exception e){
			throw new UserException(e.getMessage(),e);
		}
	}

	

	@Override
	public Integer addUser(User user) throws UserException {
		try {
			Integer s=userDao.addUser(user);
			return s;
		}catch(Exception e) {
			throw new UserException(e.getMessage(),e);
		}
	}



	@Override
	public String deleteUser(Integer userId) throws UserException {
		try {
			String result= userDao.deleteUser(userId);
			return result;
		}catch(SQLException e) {

			throw new UserException(e.getMessage(),e);
		}

	}



	@Override
	public User getUserById(Integer userId) throws UserException {
		try {
			User user= userDao.getUserById(userId);
			return user;
		}catch(SQLException e) {

			throw new UserException(e.getMessage(),e);
		}

	}



	@Override
	public List<User> getUser() throws UserException {
		try {
			List<User> userList= userDao.getUser();
			return userList;
		}catch(SQLException e) {

			throw new UserException(e.getMessage(),e);
		}
	}



	@Override
	public String updateUser(User user) throws UserException {
		try {
			String result= userDao.updateUser(user);
			return result;
		}catch(SQLException e) {
			throw new UserException(e.getMessage(),e);
		}
	}



	@Override
	public Integer getUserId(User user) throws UserException {
		try {
			Integer userid=userDao.getUserId(user);
			return userid;
		}catch(SQLException e) {
			throw new UserException(e.getMessage(),e);
		}


	}



	@Override
	public Boolean isValidUser(String userName, Role role) throws UserException {
		try {
			return userDao.isValidUser(userName,role);
		}catch(Exception e){
			throw new UserException(e.getMessage(),e);
		}
	}



	@Override
	public String ForgotPassword(User user) throws UserException {
		try {
			String result= userDao.ForgotPassword(user);
			return result; 
		}catch(SQLException e) {
			throw new UserException(e.getMessage(),e);
		}
	}



}