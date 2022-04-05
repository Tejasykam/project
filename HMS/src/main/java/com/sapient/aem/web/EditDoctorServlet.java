package com.sapient.aem.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.sapient.aem.model.Doctor;
import com.sapient.aem.model.Patient;
import com.sapient.aem.service.DoctorService;
import com.sapient.aem.service.DoctorServiceImpl;

@WebServlet("/edit-doctor")
public class EditDoctorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger logger= Logger.getLogger(EditDoctorServlet.class);
	private DoctorService doctorService= new DoctorServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Integer doctorId= Integer.parseInt(request.getParameter("id"));
			System.out.println(doctorId);
			Doctor doctor= doctorService.getDoctorById(doctorId);
			System.out.println(doctorId);
			request.setAttribute("doctor", doctor);
			
			request.getRequestDispatcher("WEB-INF/views/edit-doctor.jsp")
								.forward(request, response);
			
		}catch(Exception e) {
			logger.error(e.getMessage(), e);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}

