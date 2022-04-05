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

@WebServlet("/reset-pwd")
public class ForgotPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static UserService userservice = new UserServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		try {
			String name = request.getParameter("username");
			String password = request.getParameter("password");
			String confirmPassword = request.getParameter("confirm-password");
			String role = request.getParameter("role");
			Role myRole = null;
			if(role.equals("ADMIN")) {
				myRole=Role.ADMIN;
			}else if(role.equals("DOCTOR")) {
				myRole=Role.DOCTOR;
			}else if(role.equals("PATIENT")) {
				myRole=Role.PATIENT;
			}else {
				myRole=null;
			}
			String message=null;
			User user = new User(name,confirmPassword,role);
			if(password.equals(confirmPassword)) {
				if(userservice.isValidUser(name, myRole)) {
					message = userservice.ForgotPassword(user);
					out.print("<html><body style=\"text-align: center;color: green;\">"+message+"</body></html>");
				}else {
					out.println("<html><body style=\"text-align: center; color: red;\">invalid user !</body></html>");
				}
			}else {
				out.println("<html><body style=\"text-align: center; color: red;\">password not match !</body></html>");
			}
			request.getRequestDispatcher("login.html").include(request, response);
		}catch(Exception e ) {
			
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
