package com.sapient.aem.web;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.sapient.aem.exception.PatientException;
import com.sapient.aem.model.Patient;
import com.sapient.aem.service.PatientService;
import com.sapient.aem.service.PatientServiceImpl;


@WebServlet("/post-edit")
public class UpdatePatientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger logger= Logger.getLogger(UpdatePatientServlet.class);
	private PatientService patientService= new PatientServiceImpl();

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// read the form data
			Integer patientId= Integer.parseInt(request.getParameter("patient_id"));
			
			String patientname= request.getParameter("patient_name");
			String gender= request.getParameter("gender");
			String birthdate= request.getParameter("birthdate");
			String bloodgroup=request.getParameter("blood_group");
		    String mobile=request.getParameter("mobile");
		    String email=request.getParameter("email");
			String address=request.getParameter("address");	
			
			// Sanitize the form data
			//TODO
			
			// Populate the Employee object
			Patient patient= new Patient(patientId,patientname,gender,LocalDate.parse(birthdate),bloodgroup,mobile,email,address);

			
			String result= patientService.updatePatient(patient);
			response.getWriter().println("<html><body><h4>"+result+"</h4></body></html>");
			
			request.getRequestDispatcher("all-patient")
						.include(request, response);
		}catch(PatientException e) {
			logger.error(e.getMessage(),e);
		}catch(Exception e) {
			logger.error(e.getMessage(),e);
		}
		
	}


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
