package com.sapient.aem.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.sapient.aem.service.PatientService;
import com.sapient.aem.service.PatientServiceImpl;


@WebServlet("/delete-patient")
public class DeletePatientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger logger= Logger.getLogger(DeletePatientServlet.class);
	private PatientService patientService= new PatientServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Integer patientId= Integer.parseInt(request.getParameter("id"));
			String status=patientService.deletePatient(patientId);
			response.getWriter().println("<html><body><h4>"+status+"</h4></body></html>");
			
			request.getRequestDispatcher("all-patient")
						.include(request, response);
		}catch(Exception e) {
			logger.error(e.getMessage(), e);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
