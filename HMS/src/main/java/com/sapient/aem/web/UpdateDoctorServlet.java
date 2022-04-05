package com.sapient.aem.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sapient.aem.model.Doctor;
import com.sapient.aem.service.DoctorService;
import com.sapient.aem.service.DoctorServiceImpl;

@WebServlet("/UpdateDoctorServlet")
public class UpdateDoctorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static DoctorService service = new DoctorServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		try {
			Integer id = Integer.parseInt(request.getParameter("dId"));
			String dname= request.getParameter("dname");
			String specialization= request.getParameter("specialization");
			String availabletiming=request.getParameter("availabletiming");
			String qualification= request.getParameter("qualification");
			Integer expinyears= Integer.parseInt(request.getParameter("expinyears"));
			Long mobile= Long.parseLong(request.getParameter("mobile"));
			String email= request.getParameter("email");
			Doctor doctor= 
				new Doctor(id,dname,specialization,availabletiming,qualification,expinyears,mobile,email);	
		    String message = service.updateDoctor(doctor);
		    if(message!=null) {
		    	out.println("<html><body>"+message+"</body></html>");
		    }
		    request.getRequestDispatcher("ListOfDoctor").forward(request, response);
			
		}catch(Exception e) {
			
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
