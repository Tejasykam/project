package com.sapient.aem.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sapient.aem.exception.DoctorException;
import com.sapient.aem.model.Patient;
import com.sapient.aem.service.PatientService;
import com.sapient.aem.service.PatientServiceImpl;

/**
 * Servlet implementation class PatientByIdServlet
 */
@WebServlet("/PatientByIdServlet")
public class PatientByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static PatientService patientService = new PatientServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		try {
			Integer patientId= Integer.parseInt(request.getParameter("patientId"));
			Patient patient= patientService.getPatientById(patientId);
			if(patient != null) {
				request.setAttribute("patient", patient);
				request.getRequestDispatcher("WEB-INF/views/show-patient.jsp")
				.forward(request, response);		
			}else {
				request.setAttribute("message", "Invalid |");
				request.getRequestDispatcher("WEB-INF/views/status.jsp")
				.forward(request, response);
			}

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
