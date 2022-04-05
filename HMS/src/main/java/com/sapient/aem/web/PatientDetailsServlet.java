package com.sapient.aem.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sapient.aem.model.Patient;
import com.sapient.aem.service.PatientService;
import com.sapient.aem.service.PatientServiceImpl;

@WebServlet("/PatientDetailsServlet")
public class PatientDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static PatientService ps = new PatientServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		try {
			List<Patient> l = ps.getAllPatients();
			request.setAttribute("patient", l);
			request.getRequestDispatcher("WEB-INF/views/patient-details.jsp").forward(request, response);
		}catch(Exception e) {
			
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
