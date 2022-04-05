<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 align="center">Doctor Details</h1>
	<h2 align="left">
		DoctorId: ${doctor.doctorId}<br>
		DoctorName: ${ doctor.doctorName}<br>
		Specialization:${doctor.specialization }<br>
		AvailableTimings:  ${doctor.availableTiming }<br>
		Qualification: ${doctor.qualification  }<br>
		ExperienceInYears: ${doctor.experienceInYears  }<br>
		mobile: ${doctor.mobile }<br>
		email: ${doctor.email }	
	</h2>
</body>
</html>