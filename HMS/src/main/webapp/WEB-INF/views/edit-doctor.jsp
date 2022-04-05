<html>
<head>
	<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
	<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
	<link href="css/edit-doc.css" rel="stylesheet" >
</head>
<body>
   <div class="container">
       
       <h4 align="center" class="heading">Doctor Registration Form</h4>
       <form class="" method="post" action="add-doctor">
						<div class="form-group">
							<label for="dId">Doctor Id</label>
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
									<input type="text" class="form-control" name="dId" id="dId"  value="${doctor.doctorId}" disabled>
							</div>
						</div>
						<div class="form-group">
							<label for="dname">Enter Doctor Name</label>
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
									<input type="text" class="form-control" name="dname" id="dname"  value="${doctor.doctorName}" readonly="readonly">
							</div>
						</div>
						
						<div class="form-group">
							<label for="specialization">Enter Specialization</label>
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
									<input type="text" class="form-control" name="specialization" id="specialization" value="${doctor.specialization}"  placeholder="Enter your specialization"/>
							</div>
						</div>
						
						<div class="form-group">
							<label for="availabletiming">Enter Available Timing</label>
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
									<input type="text" class="form-control" name="availabletiming" id="availabletiming" value="${doctor.availableTiming}" placeholder="Enter your  Available Timings"/>
							</div>
						</div>
						
						<div class="form-group">
							<label for="qualification">Enter Qualification</label>
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
									<input type="text" class="form-control" name="qualification" id="qualification" value="${doctor.qualification}" placeholder="Enter Qualification"/>
							</div>
						</div>
						
						<div class="form-group">
							<label for="expinyears">Enter Experience In Years</label>
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
									<input type="number" class="form-control" name="expinyears" id="expinyears" value="${doctor.experienceInYears}" placeholder="Enter Experience In Years"/>
							</div>
						</div>
						
						<div class="form-group">
							<label for="mobile">Enter Mobile</label>
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
									<input type="number" class="form-control" name="mobile" id="mobile" value="${doctor.mobile}" placeholder="Enter mobile"/>
							</div>
						</div>
						
						
						<div class="form-group">
							<label for="email">Enter Email</label>
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
									<input type="text" class="form-control" name="email" id="email" value="${doctor.email}" placeholder="Enter Email"/>
							</div>
						</div>

						

						<button type="submit">REGISTER</button>
						
					</form>
      <div class="reg-container ">
      </div>
      </div>
	</body>	
</html>