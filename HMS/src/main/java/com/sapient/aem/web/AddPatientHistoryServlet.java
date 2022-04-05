package com.sapient.aem.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sapient.aem.model.PatientCaseSheet;
import com.sapient.aem.model.PatientHistory;
import com.sapient.aem.service.PatientHistoryService;
import com.sapient.aem.service.PatientHistoryServiceImpl;

@WebServlet("/AddPatientHistoryServlet")
public class AddPatientHistoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static PatientHistoryService patientHistoryService = new PatientHistoryServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		try {
			String patientName = request.getParameter("patientName");
			String caseSheetOpenDate = request.getParameter("case_sheet_open_date");
			String caseSheetCloseDate = request.getParameter("case_sheet_close_date");
			String hostipalDetails = request.getParameter("hostipal_details");
			String healthStatistics = request.getParameter("health_statistics");
			String symptoms = request.getParameter("symptoms");
			String prescription = request.getParameter("prescription");
			String diet = request.getParameter("diet");
			Integer patientId = Integer.parseInt(request.getParameter("patientId"));
			PatientHistory patientCaseSheet = new PatientHistory(patientName,LocalDate.parse(caseSheetOpenDate),LocalDate.parse(caseSheetCloseDate),hostipalDetails,symptoms,prescription,prescription,diet,patientId);
			Integer patientHistoryId=patientHistoryService.addPatientHistory(patientCaseSheet);
			if(patientHistoryId!=null) {
				request.getRequestDispatcher("ListOfPatientHistory").forward(request, response);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
