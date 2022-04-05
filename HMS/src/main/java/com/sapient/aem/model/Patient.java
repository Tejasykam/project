package com.sapient.aem.model;

import java.time.LocalDate;

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

public class Patient {
	private Integer patientId;
	private String patientName;
	private String gender;
	private LocalDate birthdate;
	private String bloodGroup;
	private String mobile;
	private String email;
	private String address;
	
	
	public Patient(String patientName, String gender, LocalDate birthdate, String bloodGroup, String mobile,String email,
			String address ) {
		super();
		this.patientName = patientName;
		this.gender = gender;
		this.birthdate = birthdate;
		this.bloodGroup = bloodGroup;
		this.mobile = mobile;
		this.email = email;
		this.address = address;
	}


		
	

	
	
	
	
	
	
}
