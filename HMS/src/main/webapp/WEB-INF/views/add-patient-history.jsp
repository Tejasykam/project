<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
* {
	box-sizing: border-box;
}

input[type=text], select, textarea {
	width: 100%;
	padding: 12px;
	border: 1px solid #ccc;
	border-radius: 4px;
	resize: vertical;
}

label {
	padding: 12px 12px 12px 0;
	display: inline-block;
}

input[type=submit] {
	background-color: #04AA6D;
	color: white;
	padding: 12px 20px;
	border: none;
	border-radius: 4px;
	cursor: pointer;
	float: right;
}

input[type=submit]:hover {
	background-color: #45a049;
}

.container {
	border-radius: 5px;
	background-color: #f2f2f2;
	padding: 20px;
}

.col-25 {
	float: left;
	width: 25%;
	margin-top: 6px;
}

.col-75 {
	float: left;
	width: 75%;
	margin-top: 6px;
}

/* Clear floats after the columns */
.row:after {
	content: "";
	display: table;
	clear: both;
}

@media screen and (max-width: 600px) {
	.col-25, .col-75, input[type=submit] {
		width: 100%;
		margin-top: 0;
	}
}
</style>
</head>
<body>

	<h2>Patient History</h2>

	<div class="container">
		<form action="AddPatientHistoryServlet" onsubmit="return validate()">
			<div class="row">
				<div class="col-25">
					<label for="fname">Patient Name</label>
				</div>
				<div class="col-75">
					<input type="text" id="fname" onblur="isValidPatientName()"
						name="patientName" placeholder="Enter patient name..">
				</div>
				<p id="p1"></p>
			</div>

			<div class="row">
				<div class="col-25">
					<label for="fname">Case sheet open date</label>
				</div>
				<div class="col-75">
					<input type="date" id="fname" name="case_sheet_open_date"
						placeholder="Enter case_sheet_open_date..">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="fname">Case sheet close date</label>
				</div>
				<div class="col-75">
					<input type="date" id="fname" name="case_sheet_close_date"
						placeholder="Enter case_sheet_close_dat..">
				</div>
			</div>

			<div class="row">
				<div class="col-25">
					<label for="lname">Hostipal Details </label>
				</div>
				<div class="col-75">
					<input type="text" id="lname" name="hostipal_details"
						placeholder="Enter hostipal details ..">
				</div>
			</div>

			<div class="row">
				<div class="col-25">
					<label for="lname">Health Statistics</label>
				</div>
				<div class="col-75">
					<input type="text" id="lname" name="health_statistics"
						placeholder="Enter health statistics..">
				</div>
			</div>


			<div class="row">
				<div class="col-25">
					<label for="lname">Symptoms </label>
				</div>
				<div class="col-75">
					<input type="text" id="lname" name="symptoms"
						placeholder="Enter symptoms ..">
				</div>
			</div>



			<div class="row">
				<div class="col-25">
					<label for="lname">Prescription </label>
				</div>
				<div class="col-75">
					<input type="text" id="lname" name="prescription"
						placeholder="Enter prescription ..">
				</div>
			</div>


			<div class="row">
				<div class="col-25">
					<label for="lname">Diet </label>
				</div>
				<div class="col-75">
					<input type="text" id="lname" name="diet"
						placeholder="Enter diet ..">
				</div>
			</div>

			<div class="row">
				<div class="col-25">
					<label for="lname">Patient id</label>
				</div>
				<div class="col-75">
					<input type="text" id="lname" name="patientId"
						placeholder="Enter patient id..">
				</div>
			</div>
			<br>
			<div class="row">
				<input type="submit" value="Submit">
			</div>
		</form>
	</div>
</body>
</html>