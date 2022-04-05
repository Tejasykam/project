package com.sapient.aem.service;

import java.util.List;

import com.sapient.aem.exception.UserException;
import com.sapient.aem.model.Role;
import com.sapient.aem.model.User;

public interface UserService {
	public abstract Boolean isValidUser(String userName,String password, Role role) throws UserException;
	public abstract Integer addUser(User user)throws UserException;
	public abstract String deleteUser(Integer userId)throws UserException;
	public abstract User getUserById(Integer userId)throws UserException;
	public abstract List<User> getUser()throws UserException;
	public abstract String updateUser(User user)throws UserException;
	public abstract Integer getUserId(User user) throws UserException;
	public abstract Boolean isValidUser(String userName, Role role) throws UserException;
	public abstract String ForgotPassword(User user) throws UserException;


}
