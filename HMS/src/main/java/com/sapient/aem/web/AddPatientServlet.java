package com.sapient.aem.web;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.sapient.aem.model.Patient;
import com.sapient.aem.model.User;
import com.sapient.aem.service.PatientService;
import com.sapient.aem.service.PatientServiceImpl;
import com.sapient.aem.service.UserService;
import com.sapient.aem.service.UserServiceImpl;



@WebServlet("/add-patient")
public class AddPatientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger logger= Logger.getLogger(AddPatientServlet.class);
	private PatientService patientService= new PatientServiceImpl();
	private UserService userService= new UserServiceImpl();
       
   
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// read the form data
			
			String patientname= request.getParameter("patient_name");
			String gender= request.getParameter("gender");
			String birthdate= request.getParameter("birthdate");
			String bloodgroup=request.getParameter("blood_group");
		    String mobile=request.getParameter("mobile");
			String email=request.getParameter("email");
			String address=request.getParameter("address");	
			String password=request.getParameter("password");

		
			User user=new User(patientname,password,"Patient");
			Patient patient= new Patient(patientname,gender,LocalDate.parse(birthdate),bloodgroup,mobile,email,address);
			Integer patientId= patientService.addPatient(patient);
			Integer userid= userService.addUser(user);
			if(patientId !=null) {	
				response.getWriter().println("<html><body><h2 align=\"center\">"+"Register Success"+"</h2>"
						+"</body></html>");
			}else {
				response.getWriter().println("<html><body><h2>"+"Unable to add Patient"+"</h2></body></html>");
				
			}
			request.getRequestDispatcher("WEB-INF/views/pdash.jsp").include(request, response);

		}catch(Exception e) {
			logger.error(e.getMessage(),e);
		}
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
