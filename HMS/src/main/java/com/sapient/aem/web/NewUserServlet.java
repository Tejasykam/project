package com.sapient.aem.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.sapient.aem.model.Role;
import com.sapient.aem.service.UserService;
import com.sapient.aem.service.UserServiceImpl;


@WebServlet("/new-user")
public class NewUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger logger= Logger.getLogger(NewUserServlet.class);
	private UserService userService= new UserServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out= response.getWriter();
		String role= request.getParameter("role");
		Role myRole=null;
		if(role.equals("doctor")) {
			myRole= Role.DOCTOR;
		}else if(role.equals("patient")) {
			myRole=Role.PATIENT;
		}
	
		if(role.equals("doctor")) {
			request.getRequestDispatcher("WEB-INF/views/doctor-reg-form.html")
											.forward(request, response);
		}else if(role.equals("patient")) {
			request.getRequestDispatcher("WEB-INF/views/patient-reg-form.html")
			.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
