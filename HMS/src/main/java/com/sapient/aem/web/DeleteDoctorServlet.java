package com.sapient.aem.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.sapient.aem.service.DoctorService;
import com.sapient.aem.service.DoctorServiceImpl;


@WebServlet("/delete-doctor")
public class DeleteDoctorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger logger= Logger.getLogger(DeleteDoctorServlet.class);
	private DoctorService doctorService=new DoctorServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		try {
			Integer doctorId= Integer.parseInt(request.getParameter("id"));
			String status=doctorService.deleteDoctor(doctorId);
			out.print("<html><body><h4>"+status+"</h4></body></html>");
			
			request.getRequestDispatcher("getAllDoctor")
						.include(request, response);
		}catch(Exception e) {
			logger.error(e.getMessage(), e);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
