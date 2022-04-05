package com.sapient.aem.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Doctor {
	private Integer doctorId;
	private String doctorName;
	private String specialization;
	private String availableTiming;
	private String qualification;
	private String experienceInYears;
	private String mobile;
	private String email;
	
	
	public Doctor(String doctorName, String specialization, String availableTiming, String qualification,
			String experienceInYears, String mobile, String email) {
		super();
		this.doctorName = doctorName;
		this.specialization = specialization;
		this.availableTiming = availableTiming;
		this.qualification = qualification;
		this.experienceInYears = experienceInYears;
		this.mobile = mobile;
		this.email = email;
		
	}
	
	
	

}
