package com.sapient.aem.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sapient.aem.model.PatientHistory;
import com.sapient.aem.service.PatientHistoryService;
import com.sapient.aem.service.PatientHistoryServiceImpl;

/**
 * Servlet implementation class ViewPatientHistoryDetails
 */
@WebServlet("/ViewPatientHistoryDetails")
public class ViewPatientHistoryDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static PatientHistoryService patientHistoryService=new PatientHistoryServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter  out=response.getWriter();
		try {
			Integer patientHistroyid = Integer.parseInt(request.getParameter("id"));
			PatientHistory patientHistory=patientHistoryService.getPatientHistoryById(patientHistroyid);
			request.setAttribute("patientHistory", patientHistory);
			request.getRequestDispatcher("./WEB-INF/views/view-patient-history.jsp").forward(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
