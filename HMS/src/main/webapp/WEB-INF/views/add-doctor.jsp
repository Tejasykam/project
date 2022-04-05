<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>
<body>
	<div class="container md-2">
	<form action="DoctorRegistrationServlet" method="post">
		<div class="form-group">
			<label>Enter Doctor name</label> <input type="text"
				class="form-control" name="doctorName" placeholder="Enter user name">
		</div>
		<div class="form-group">
			<label>Enter specialization</label> <input type="text"
				class="form-control" name="specilization"
				placeholder="Enter specialization">
		</div>
		<div class="form-group">
			<label>Enter your available timings</label> <input type="text"
				class="form-control" name="availabletimings"
				placeholder="Enter your available timings">
		</div>
		<div class="form-group">
			<label>Qualification </label> <input type="text" class="form-control"
				name="qulification" placeholder="Qualification ">
		</div>

		<div class="form-group">
			<label>Experience in years </label> <input type="number"
				class="form-control" name="expirience"
				placeholder="Experience in years ">
		</div>
		<div class="form-group">
			<label>Mobile number</label> <input type="number"
				class="form-control" name="mobileNumber" placeholder="Mobile Number">
		</div>
		<div class="form-group">
			<label>Email</label> <input type="email" class="form-control"
				name="email" placeholder="Email">
		</div>
		<div class="form-group mt-3">
			<select name="role" class="form-control">
				<option value="">Select Role</option>
				<option value="DOCTOR">Doctor</option>
			</select>
		</div>
		<button type="submit" class="btn btn-primary mt-4">Sign Up</button>
	</form>
	
	</div>
</body>
</html>