package com.sapient.aem.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.sapient.aem.model.Doctor;
import com.sapient.aem.service.PatientSearchService;
import com.sapient.aem.service.PatientSearchServiceImpl;


@WebServlet("/doc-specialization-search")
public class SearchByDocSpecServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PatientSearchService patientSearchService= new PatientSearchServiceImpl();
	private Logger logger= Logger.getLogger(SearchByDocSpecServlet.class);

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String specialization = request.getParameter("specialization");
			List<Doctor> doctorList=patientSearchService.searchBySpecialization(specialization);
			if(doctorList != null) {
				//store doctor object in request object
				request.setAttribute("doctorList", doctorList);
				//request.setAttribute("doctor_name", doctorList);
				logger.info(doctorList);
				request.getRequestDispatcher("WEB-INF/views/show-all-doctor.jsp")
				.forward(request, response);		
			}else {
				request.setAttribute("message", "Invalid DoctorName");
				request.getRequestDispatcher("WEB-INF/views/status.jsp")
				.forward(request, response);
			}

		
		}catch(Exception e) {
			logger.error(e.getMessage(),e);
		}

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
