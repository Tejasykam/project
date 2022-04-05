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
	private Long mobile;
	private String address;
	private String email;
	
	public Patient(String patientName, String gender, LocalDate birthdate, String bloodGroup, Long mobile,
			String address, String email) {
		super();
		this.patientName = patientName;
		this.gender = gender;
		this.birthdate = birthdate;
		this.bloodGroup = bloodGroup;
		this.mobile = mobile;
		this.address = address;
		this.email = email;
	}
	
	
	
	
	
}
