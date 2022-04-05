<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

</head>
<body>
<div class="container">
<h2 align="center">Patient List</h2>
<table class="table">
<thead>
				<tr>					
					<th>PatientId</th>
					<th>PatientName</th>
					<th>Gender</th>
					<th>BirthDate</th>
					<th>BloodGroup</th>
					<th>Mobile</th>										
					<th>Email</th>
					<th>Address</th>
					<th>Edit</th>
					<th>Delete</th>
				</tr>
			</thead>
			<tbody>
			    <%-- <c:forEach> is a jstl core tag that iterates through a list --%>
				<%-- we are able to iterate through an arraylist
				     using jstl tag without writing any Java code --%>
				<c:forEach var="p" items="${patientList}">
					<tr class="success">						
						<td>${p.patientId}</td>
				        <td>${p.patientName}</td>
				        <td>${p.gender}</td>
				        <td>${p.birthdate }</td>
				        <td>${p.bloodGroup}</td>
				        <td>${p.mobile}</td>
				        <td>${p.email}</td>
				        <td>${p.address}</td>						
						<td><a href="edit-patient?id=${p.patientId}">edit</a></td>
						<td><a href="delete-patient?id=${p.patientId}">delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
</table>
</div>

</body>
</html>