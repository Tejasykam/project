package com.sapient.aem.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sapient.aem.model.Doctor;
import com.sapient.aem.service.DoctorService;
import com.sapient.aem.service.DoctorServiceImpl;

/**
 * Servlet implementation class SearchDoctorServlet
 */
@WebServlet("/SearchDoctorServlet")
public class SearchDoctorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static DoctorService doctorService = new DoctorServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	PrintWriter out=response.getWriter();
	try {
		String string = request.getParameter("search");
		List<Doctor> doctor = doctorService.searchDoctor(string);
		request.setAttribute("doctor", doctor);
		request.getRequestDispatcher("./WEB-INF/views/searched-doctors.jsp").forward(request, response);
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
