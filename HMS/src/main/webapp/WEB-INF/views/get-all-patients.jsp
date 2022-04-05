<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>List of Patients</h1>

	<table border="1">
		<tr>
			<th>PatientId</th>
			<th>PatientName</th>
			<th>Gender</th>
			<th>BirthDate</th>
			<th>BloodGroup</th>
			<th>Mobile</th>
			<th>Email</th>
			<th>Address</th>
		</tr>
		<c:forEach var="p" items="${patient}">
			<tr>
				<td>${p.patientId}</td>
				<td>${p.patientName}</td>
				<td>${p.gender}</td>
				<td>${p.birthdate }</td>
				<td>${p.bloodGroup}</td>
				<td>${p.mobile}</td>
				<td>${p.email}</td>
				<td>${p.address}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>