<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.3/dist/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
<style>
  .cards {
    display: flex;
    flex-wrap: wrap;
    align-items:stretch;
  }
  .card {
    flex: 0 0 200px;
    margin: 10px;
    border: 1px solid #ccc;
    box-shadow: 2px 2px 6px 0px  rgba(0,0,0,0.3);
  } 
  .card img {
    max-width: 100%;
  }
  .card .text {
    padding: 0 20px 20px;
  }
  .card .text > button {
    background: gray;
    border: 0;
    color: white;
    padding: 10px;
    width: 100%;
    }
</style>
</head>
<body>
<div align="center">
<h4>Doctors</h4>
		<form action="SearchDoctorServlet" class="mt-2">
			<input type="text" name="search" placeholder="search...." />
			<button type="submit">search</button>
		</form>
	</div>
	<div class="cards">
	<c:forEach var="d" items="${doctor}">
	<article class="card">
    <img src="https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_1280.png" alt="Sample photo">
    <div class="text">
      <h3>${d.doctorId}</h3>
      <h4>${d.doctorName}</h4>
      <h6>${d.specialization}</h6>
      <p>${d.qualification }</p>
       <p>Experience : ${d.experienceInYears} years</p>
        <hr>
      ${d.mobile}<br>
      ${d.email}
      <hr>
    <a href="edit-doctor?id=${d.doctorId }">edit</a>
    <a href="DeleteDoctorServlet?id=${d.doctorId }">delete</a>
    </div>
  </article></c:forEach>
	</div>
</body>
</html>