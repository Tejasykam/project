package com.sapient.aem.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sapient.aem.service.PatientHistoryService;
import com.sapient.aem.service.PatientHistoryServiceImpl;

/**
 * Servlet implementation class DeletePatientHistoryServlet
 */
@WebServlet("/DeletePatientHistoryServlet")
public class DeletePatientHistoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static PatientHistoryService patientHistoryService = new PatientHistoryServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		try {
			Integer patientHistoryId = Integer.parseInt(request.getParameter("id"));
			String message = patientHistoryService.deletePatientHistory(patientHistoryId);
			request.getRequestDispatcher("ListOfPatientHistory").forward(request, response);
		}catch(Exception e) {
			e.printStackTrace();
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
