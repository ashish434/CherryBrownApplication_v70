function checkName(name){
	var nameExp = /^[a-z]+$/i;
	var custName = name.value;
	
	if(custName.length==0)
	{
		alert("Name cannot be empty..");
		return false;
	}

	if(!custName.match(nameExp)){
		alert("Name should contain alphabets only..");
		return false;
	}
	else return true;
}

function validateEmail(email) {
	var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
    
    if (email.value.match(mailformat)) {
        return true;
    }
    else {
        alert("You have entered an invalid email address!");
        return false;
    }
}

function isGenderSelected(gender){
	if(gender.value.length==0){
		alert("Please select your gender");
		return false;
	}
	else return true;
}

function checkCity(city){
	var nameExp = /^[a-z]+$/i;
	var custCity = city.value;
	
	if(custCity.length==0)
	{
		alert("City cannot be empty..");
		return false;
	}

	if(!custCity.match(nameExp)){
		alert("City should contain alphabets only..");
		return false;
	}
	else return true;
}

function validatePhoneNum(num) {
	var regEx = /^[0-9]+$/;
    
	if (!num.value.match(regEx)){
        alert("Contact number should contain only digits...");
        return false;
    }
	
	else if(num.value.length!=10){
		alert("Contact number should be 10 digits long..");
        return false;
	}
	
	else {
        return true;
    }
    
}

function validatePassword(pass) {
    var checkpass = /^[a-z0-9]$/i;
    
    if(pass.value == ""){
    	alert("Password cannot be empty..");
    	return false;
    }
    
    else if(pass.value.length<5){
    	alert("Password too short..should contain atleast 5 characters..");
    	return false;
    }
    
    else if(pass.value.length>8){
    	alert("Password too long..can contain atmost 8 characters..");
    	return false;
    }
    
    else if (!pass.value.match(checkpass)) {
    	alert("Invalid characters in password....");
    	return false;
    }

    else return true;

}

function checkAge(num){
var regEx = /^[0-9]+$/;
    
	if(num.value.length==0){
		alert("Enter your age..");
        return false;
	}
	
	else if (!num.value.match(regEx)){
        alert("Age should be numeric..");
        return false;
    }
	
	else {
        return true;
    }
}

function checkId(id){
	var nameExp = /^[0-9a-zA-Z]*$/;
	var id1 = id.value;
	
	if(id.length==0||id.value=="")
	{
		alert("ID cannot be empty..");
		return false;
	}

	if(!id1.match(nameExp)){
		alert("Id should contain alphanumeric only..");
		return false;
	}
	else return true;
}
