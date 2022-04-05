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
	<h1>List of Doctors</h1>

	<table border="1">
		<tr>
			<th>DoctorId</th>
			<th>DoctorName</th>
			<th>Specialization</th>
			<th>AvailableTimings</th>
			<th>Qualification</th>
			<th>Experience-In-Years</th>
			<th>Mobile</th>
			<th>email</th>
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
				<td><a href="edit-doctor?id=${d.doctorId}">edit</a></td>
				<td><a href="delete-doctor?id=${d.doctorId}">delete</a></td>
			</tr>
		</c:forEach>

	</table>


</body>
</html>