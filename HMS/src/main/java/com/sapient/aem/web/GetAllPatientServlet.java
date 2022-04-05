package com.sapient.aem.web;

import java.io.IOException;
import java.util.List;

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


@WebServlet("/get-patients")
public class GetAllPatientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    PatientService patientService=new PatientServiceImpl();
    private Logger logger= Logger.getLogger(GetAllPatientServlet.class);
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
try {
			
			List<Patient> patient=  patientService.getAllPatients();
			
			request.setAttribute("patient",patient );
			request.getRequestDispatcher("WEB-INF/views/get-all-patients.jsp").forward(request, response);
		
			
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
