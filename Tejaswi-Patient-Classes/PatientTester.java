package com.sapient.aem.ui;

import com.sapient.aem.exception.PatientException;
import com.sapient.aem.model.Patient;
import com.sapient.aem.service.PatientService;
import com.sapient.aem.service.PatientServiceImpl;

public class PatientTester {
	private static PatientService patientService=new PatientServiceImpl();
	public static void main(String[] args) throws PatientException {
		 addPatient();
		
		//try {
//			String message= addEmployee(new Employee(ename,job,null,hiredate,sal,null,deptno));
//			logger.info(message);
//		}catch(EmployeeException e) {
//			logger.error(e.getMessage(), e);
//		}
//		try {
//			doctorService.addDoctor(new Doctor("Raj","stsf","tyuu","sfsg",23,9876543210L,"raj@gmail.com"));
//		}catch(Exception e) {
//			e.printStackTrace();
//		}



	}
	private static void  addPatient() throws PatientException{
		
		try {
			patientService.addPatient(new Patient("Raj","Male",2011-09-13,"B+ve",9876543210L,"jclkjtloerjanh","raj@gmail.com"));
		}catch(Exception e) {
			e.printStackTrace();
		}
		return ;
		
	}
}