package com.sapient.aem.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.sapient.aem.service.PatientSearchService;
import com.sapient.aem.service.PatientSearchServiceImpl;


@WebServlet("/by-doc-spec")
public class PatientSearchByDocSpecServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PatientSearchService patientSearchService= new PatientSearchServiceImpl();
	private Logger logger= Logger.getLogger(PatientSearchByDocSpecServlet.class);
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/views/search-doc-sep.jsp")
		.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
