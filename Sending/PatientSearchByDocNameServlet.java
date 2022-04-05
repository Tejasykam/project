package com.sapient.aem.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.sapient.aem.exception.DoctorException;
import com.sapient.aem.model.Doctor;
import com.sapient.aem.service.PatientSearchService;
import com.sapient.aem.service.PatientSearchServiceImpl;


@WebServlet("/by-doc-name")
public class PatientSearchByDocNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PatientSearchService patientSearchService= new PatientSearchServiceImpl();
	private Logger logger= Logger.getLogger(PatientSearchByDocNameServlet.class);
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.getRequestDispatcher("WEB-INF/views/search-doc-name.jsp")
	.forward(request, response);


	
	}
	
//			List<Doctor> doctorList=  patientSearchService.searchByDoctorName("doctor_name");
//			
//			request.setAttribute("doctor_name", doctorList);
//			//dispatch doctorList to show-all-doctor.jsp
//			request.getRequestDispatcher("WEB-INF/views/show-all-doctor.jsp")
//										.include(request, response);
//			
//		
//		}catch(Exception e) {
//			logger.error(e.getMessage(),e);
//		}
		
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
