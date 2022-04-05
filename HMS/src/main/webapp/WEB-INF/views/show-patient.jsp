<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="card">
  <div class="card-body">
    <h4 class="card-title">Patient Details</h4>
    <p class="card-text">
        PatientId:      ${patient.patientId}<br>
		Patient Name:   ${patient.patientName}<br>
		Gender:	        ${patient.gender}<br>
		Date Of Birth:  ${patient.birthdate }<br>
		Blood Group:    ${patient.bloodGroup}<br>
	    Contact:        ${patient.mobile}<br>
	    GMail:          ${patient.email}<br>
		Address:        ${patient.address}<br>
    </p>
    
  </div>
  <a href="hms-login.html"> <button  class="btn btn-lg btn-info" >Back</button></a>
</div>


</body>
</html>