package com.sapient.aem.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sapient.aem.model.Role;
import com.sapient.aem.model.User;
import com.sapient.aem.service.UserService;
import com.sapient.aem.service.UserServiceImpl;

/**
 * Servlet implementation class UserRegisterServlet
 */
@WebServlet("/UserRegisterServlet")
public class UserRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static UserService userService =new UserServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		try {
			String name=request.getParameter("username");
			String password=request.getParameter("password");
			String confirmPassword=request.getParameter("confirm-password");
			String role=request.getParameter("role");
			Role myRole = null;
			if(role.equals("DOCTOR")) myRole=Role.DOCTOR;
			else if(role.equals("ADMIN")) myRole=Role.ADMIN;
			else if(role.equals("PATIENT")) myRole=Role.PATIENT;
			else myRole = null;
			User user = new User(name,confirmPassword,myRole);
			String string =userService.addUser(user);
			if(string!=null) {
				out.print("<html><body><h6 align=\"center\" style=\"color: green;\">"+string+"</h6></body><html>");
			}
			request.getRequestDispatcher("login.html").include(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
