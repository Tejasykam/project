<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
<h2 align="center" style="color:green">Doctors List</h2>
<table class="table">

	
		<tr>
			<th>DoctorId</th>
			<th>DoctorName</th>
			<th>Specialization</th>
			<th>AvailableTimings</th>
			<th>Qualification</th>
			<th>Experience-In-Years</th>
			<th>Mobile</th>
			<th>Email</th>
		</tr>
		<c:forEach var="d" items="${doctorList}">
			<tr>
				<td>${d.doctorId}</td>
				<td>${d.doctorName}</td>
				<td>${d.specialization}</td>
				<td>${d.availableTiming }</td>
				<td>${d.qualification }</td>
				<td>${d.experienceInYears }</td>
				<td>${d.mobile}</td>
				<td>${d.email}</td>
				
			</tr>
		</c:forEach>

	</table>
	<a href="hms-login.html">  
       <button>Back</button>  
     </a>


</body>
</html>