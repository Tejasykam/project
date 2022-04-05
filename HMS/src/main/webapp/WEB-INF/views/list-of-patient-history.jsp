<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.14.3/dist/umd/popper.min.js"
	integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/js/bootstrap.min.js"
	integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
	crossorigin="anonymous"></script>

<style>
table {
	border-collapse: collapse;
	width: 100%;
	border: 1px solid #ddd;
}

th, td {
	text-align: center;
	padding: 5px;
}
</style>
</head>

<body>
	<div align="center">
		<form action="SearchPatienHistory" class="mt-2">
			<input type="text" name="search" placeholder="search...." />
			<button type="submit">search</button>
		</form>
	</div>
	<div align="center">
		<table border="1" class="mt-2">
			<tr>
				<th>patientHistoryId</th>
				<th>patientName</th>
				<th>caseSheetOpenDate</th>
				<th>caseSheetCloseDate</th>
				<th>hostipalDetails</th>
				<th>healthStatistics</th>
				<th>symptoms</th>
				<th>prescription</th>
				<th>diet</th>
				<th>patientId</th>
				<th>Edit</th>
				<th>Delete</th>
				<th>View</th>
			</tr>
			<c:forEach var="d" items="${patientHistoryList}">
				<div class="card">
				<tr>
					<td>${d.patientHistoryId}</td>
					<td>${d.patientName}</td>
					<td>${d.caseSheetOpenDate}</td>
					<td>${d.caseSheetCloseDate }</td>
					<td>${d.hostipalDetails }</td>
					<td>${d.healthStatistics }</td>
					<td>${d.symptoms}</td>
					<td>${d.prescription}</td>
					<td>${d.diet}</td>
					<td>${d.patientId}</td>
					<td><a
						href="UpdatePatientHistoryServlet?id=${d.patientHistoryId}">edit</a></td>
					<td><a
						href="DeletePatientHistoryServlet?id=${d.patientHistoryId}">delete</a></td>
					<td><a
						href="ViewPatientHistoryDetails?id=${d.patientHistoryId}">view</a></td>
				</tr>
			</c:forEach>

		</table>
	</div>
</body>
</html>