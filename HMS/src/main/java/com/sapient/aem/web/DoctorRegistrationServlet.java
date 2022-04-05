package com.sapient.aem.web;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.sapient.aem.model.Doctor;
import com.sapient.aem.model.User;
import com.sapient.aem.service.DoctorService;
import com.sapient.aem.service.DoctorServiceImpl;
import com.sapient.aem.service.UserService;
import com.sapient.aem.service.UserServiceImpl;
@WebServlet("/add-doctor")
public class DoctorRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger logger= Logger.getLogger(DoctorRegistrationServlet.class);
	private static DoctorService doctorService = new DoctorServiceImpl();
	private static UserService userService = new UserServiceImpl();
	//private static Validator validator = new Validator();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			String doctorName = request.getParameter("doctor_name");
			String password = request.getParameter("password");
			String doc= request.getParameter("doctor_name");
			String specialization = request.getParameter("specialization");
			String availabletimings = request.getParameter("available_timings");
			String qualification = request.getParameter("qualification");
			String experienceinyears = request.getParameter("experience_in_years");
			String mobile = request.getParameter("mobile");
			String email = request.getParameter("email");


			User user=new User(doctorName,password,"Doctor");
			Doctor  doctor=new Doctor(doctorName,specialization,availabletimings,qualification,experienceinyears,mobile,email);
			Integer doctorId= doctorService.addDoctor(doctor);
			Integer userid= userService.addUser(user);

			if(doctorId!=null) {
				request.getRequestDispatcher("all-doctor").forward(request, response);
			}else {
				response.getWriter().println("<html><body><h2>"+"Unable to add doctor"+"</h2></body></html>");
				request.getRequestDispatcher("WEB-INF/views/doctor-reg-form.html")
				.include(request, response);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}