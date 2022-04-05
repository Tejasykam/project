package com.sapient.aem.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class PatientCaseSheet {
	private Integer patientCaseSheetId ;
	private String patientName ;
	private LocalDate caseSheetOpenDate;
	private LocalDate caseSheetCloseDate;
	private String hostipalDetails ;
	private String healthStatistics;
	private String symptoms ;
	private String prescription;
	private String diet ;
	private String status;
	private Integer patientId ;
	private Integer doctorId  ;
	
	public PatientCaseSheet(String patientName, LocalDate caseSheetOpenDate, LocalDate caseSheetCloseDate,
			String hostipalDetails, String healthStatistics, String symptoms, String prescription, String diet,
			String status, Integer patientId, Integer doctorId) {
		super();
		this.patientName = patientName;
		this.caseSheetOpenDate = caseSheetOpenDate;
		this.caseSheetCloseDate = caseSheetCloseDate;
		this.hostipalDetails = hostipalDetails;
		this.healthStatistics = healthStatistics;
		this.symptoms = symptoms;
		this.prescription = prescription;
		this.diet = diet;
		this.status = status;
		this.patientId = patientId;
		this.doctorId = doctorId;
	}
	
	
	
	

}
