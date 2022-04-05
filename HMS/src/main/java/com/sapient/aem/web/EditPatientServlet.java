package com.sapient.aem.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.sapient.aem.model.Patient;
import com.sapient.aem.service.PatientService;
import com.sapient.aem.service.PatientServiceImpl;


@WebServlet("/edit-patient")
public class EditPatientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(EditPatientServlet.class);
	private PatientService patientService=new PatientServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Integer patientId= Integer.parseInt(request.getParameter("id"));
			Patient patient= patientService.getPatientById(patientId);
			request.setAttribute("p", patient);
			
			request.getRequestDispatcher("WEB-INF/views/edit-patient.jsp")
								.forward(request, response);
			
		}catch(Exception e) {
			logger.error(e.getMessage(), e);
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
