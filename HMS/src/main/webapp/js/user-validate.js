/**
This is Doctor Validation 
 */
function validate(){
	var count=0;
	if(!isValidDoctorName() || !isValidEmail() || !isValidMobile()){
		window.alert("Form validation error. Enter valid form data");
		return false;		
	}else{
		console.log("Form submitted successfully");
		return true;
	}
}

function isValidDoctorName(){
	var nameInput = document.getElementById("dname").value;
	var regex="^[a-zA-Z.{1}a-zA-Z ]*$";
	if(nameInput.match(regex)){
		document.getElementById("p1").innerHTML = "";
		return true;
	}else{
		document.getElementById("p1").innerHTML = "<span style='color:#FF0000'>Invalid  Name</span>";
		return f
	}
}

function isValidEmail(){
	var emailInput = document.getElementById("email").value;
	var regex="^[a-zA-Z]+[a-zA-Z0-9._]+@{1}[a-z]{3,}.{1}[a-z]{2,}$";
	if(emailInput.match(regex)){
		document.getElementById("p3").innerHTML = "";
		return true;
	}else{
		document.getElementById("p3").innerHTML = "<span style='color:#FF0000'> Invalid Email</span>";
		return false;
	}
}

function isValidMobile(){
	var inputString= document.getElementById("mobile").value;
	var count = 0;
	//checking for service numbers. ex. 9999999999
	for(var i=1;i<inputString.length;i++){
		if(inputString.charAt(i) != inputString.charAt(0)){
			count = count+1; break;
		}
	}
	
	if(count == 0){
		document.getElementById("p2").innerHTML = "<span style='color:#FF0000'> Invaild Mobile Number</span>";
		return false;
	} else{
		document.getElementById("p2").innerHTML = " ";	
		return true;
	}
	
 }