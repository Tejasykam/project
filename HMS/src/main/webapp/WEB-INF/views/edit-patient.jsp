<html>
<head>
	<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
	<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
	 <script src="https://kit.fontawesome.com/20c5629a29.js" crossorigin="anonymous"></script>
	<link href="css/add-emp.css" rel="stylesheet">
</head>
<body>
  
	<div class="container">
			<div class="main">
				<div class="main-center">
				<h4 align="center">	Patient Edit Form</h4>
					<form class="" method="post" action="post-edit">
						<div class="form-group">
							<label>Patient Number</label>
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
									<input type="number" class="form-control" name="patient_id" id="patient_Id"  value="${p.patientId}" readonly="readonly" />
							</div>
						</div>
						<div class="form-group">
							<label>Edit Patient Name</label>
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
									<input type="text" class="form-control" name="patient_name" id="patient_name" value="${p.patientName}" />
							</div>
						</div>
						
						<div class="form-group">
							<label>Edit Gender</label>
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
                                <select name= "gender" value="${p.gender}">
                                <option value="male">Male</option>  
                                <option value="female">Female</option> 
                                <option value="other">Other</option>
                                </select> 
                                </div>
						</div>
						<div class="form-group">
							<label>Edit DateOfBirth</label>
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
									<input type="date" class="form-control" name="birthdate" id="birthdate" value="${p.birthdate}" />
							</div>
						</div>
						<div class="form-group">
							<label>Edit Blood Group</label>
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
									<input type="text" class="form-control" name="blood_group" id="blood_group" value="${p.bloodGroup}" />
							</div>
						</div>
						
						
						
						<div class="form-group">
							<label>Edit Phone Number</label>
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
									<input type="text" class="form-control" name="mobile" id="mobile" value="${p.mobile}" />
							</div>
						</div>
						
						<div class="form-group">
							<label>Edit Email</label>
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
									<input type="text" class="form-control" name="email" id="email" value="${p.email}" />
							</div>
						</div>
						
						
						<div class="form-group">
							<label>Edit Address</label>
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
									<input type="text" class="form-control" name="address" id="address" value="${p.address}" />
							</div>
						</div>

						
						<div class="form-group" align="center">
							<button type="submit" class="btn btn-primary">Update</button>
						</div>
					</form>
				</div><!--main-center"-->
			</div><!--main-->
		</div><!--container-->
	</body>	
</html>