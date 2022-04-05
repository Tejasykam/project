<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
.card {
	box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
	max-width: 300px;
	margin: auto;
	text-align: center;
	font-family: arial;
}

.title {
	color: grey;
	font-size: 18px;
}

button {
	border: none;
	outline: 0;
	display: inline-block;
	padding: 8px;
	color: white;
	background-color: #000;
	text-align: center;
	cursor: pointer;
	width: 100%;
	font-size: 18px;
}

a {
	text-decoration: none;
	font-size: 22px;
	color: black;
}

button:hover, a:hover {
	opacity: 0.7;
}
</style>
</head>
<body>
	<div class="card">
		<img
			src="https://media.istockphoto.com/vectors/user-avatar-profile-icon-black-vector-illustration-vector-id1209654046?k=20&m=1209654046&s=612x612&w=0&h=Atw7VdjWG8KgyST8AXXJdmBkzn0lvgqyWod9vTb2XoE="
			alt="not found" style="width: 200px" height="200px">
		<h1>${patient.patientName}</h1>
		<p class="title">Patient</p>
		<p>gender : ${patient.gender}</p>
		<p>Birthdate : ${patient.birthdate}</p>
		<p>blood Group : ${patient.bloodGroup}</p>
		<p>address : ${patient.address}</p>
		<p>email : ${patient.email}</p>
		<p>
			<button>Contact</button>
		</p>
	</div>
</body>
</html>