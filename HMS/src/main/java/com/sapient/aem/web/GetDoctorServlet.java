package com.sapient.aem.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.sapient.aem.exception.DoctorException;
import com.sapient.aem.model.Doctor;
import com.sapient.aem.service.DoctorService;
import com.sapient.aem.service.DoctorServiceImpl;

@WebServlet("/getDoc")
public class GetDoctorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DoctorService doctorService= new DoctorServiceImpl();
	private Logger logger= Logger.getLogger(GetAllDoctorsServlet.class);
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Integer doctorId= Integer.parseInt(request.getParameter("doctorId"));
			Doctor doctor= doctorService.getDoctorById(doctorId);
			if(doctor != null) {
				//store employee object in request object
				request.setAttribute("doctor", doctor);
				logger.info(doctor);
				request.getRequestDispatcher("WEB-INF/views/show-doctor.jsp")
				.forward(request, response);		
			}else {
				request.setAttribute("message", "Invalid DocId");
				request.getRequestDispatcher("WEB-INF/views/status.jsp")
				.forward(request, response);
			}

		}catch(DoctorException e) {
			logger.error(e.getMessage(),e);
		}catch(Exception e) {
			logger.error(e.getMessage(),e);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
