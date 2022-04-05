package com.sapient.aem.service;

import java.util.List;

import com.sapient.aem.exception.DoctorException;
import com.sapient.aem.model.Doctor;

public interface DoctorService {
	public abstract Doctor getDoctorById(Integer doctorId) throws DoctorException;
	public abstract List<Doctor> getAllDoctors() throws DoctorException;
    public abstract Integer  addDoctor(Doctor doctor) throws DoctorException;
    public abstract String updateDoctor(Doctor doctor) throws DoctorException;
    public abstract String deleteDoctor(Integer doctorId) throws DoctorException;
    
}
