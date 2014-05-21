function initializeCheckIn()
{
	var checkOutDate = document.getElementById("checkOutDate");
	if(!checkOutDate.value==""){
		checkOutDate.value=null;
	}
	var date = new Date();
	var day  = date.getDate();
	var month = date.getMonth()+1;
	var dayString = ""+day;
	var monthString = ""+month;
	if(day<10){dayString = "0"+day;}
	if(month<10){monthString = "0"+month;}
	var today = date.getFullYear()+"-"+monthString+"-"+dayString;
	document.getElementById("checkInDate").setAttribute("min",today);
}

function initializeCheckOut()
{
	var checkInDate = document.getElementById("checkInDate").value;
	if(checkInDate == ""){
		alert("Please Select Check-in date first..");
	}
	var day = parseInt(checkInDate.substr(8,2));
	var month = parseInt(checkInDate.substr(6,2));
	var year = parseInt(checkInDate.substr(0,4));
	var dayString = ""+day;
	var monthString = ""+month;
	if(day<10){dayString = "0"+day;}
	if(month<10){monthString = "0"+month;}
	var today = year+"-"+monthString+"-"+dayString;
	document.getElementById("checkOutDate").setAttribute("min",today);
}

function validateCheckOutDate(checkOutDate){
	var checkIn = new Date(document.getElementById("checkInDate").value);
	var checkOut = new Date(checkOutDate.value);
	if(checkOut-checkIn<0){
	alert("Check-out date cannot be before Check-in Date");
	}
	return true;
}

function checkId(id){
	var idExp = /^[a-z0-9]+$/i;
	var custId = id.value;
	
	if(custId.length==0)
	{
		alert("Customer ID cannot be empty..");
		return false;
	}

	if(!custId.match(idExp)){
		alert("Customer ID cannot contain special characters..");
		return false;
	}
	else return true;
}

function checkName(name){
	var nameExp = /^[a-z]+$/i;
	var custName = name.value;
	
	if(custName.length==0)
	{
		alert("Customer Name cannot be empty..");
		return false;
	}

	if(!custName.match(nameExp)){
		alert("Customer Name should contain alphabets only..");
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

function isRoomTypeSelected(type){
	if(type.value == "default"){
		alert("Please select a room type..");
		return false;
	}
	
	else return true;
}

function isACTypeSelected(type){
	if(type.value == "default"){
		alert("Please select AC/Non-AC room..");
		return false;
	}
	
	else return true;
}

function isRoomCategorySelected(type){
	if(type.value == "default"){
		alert("Please select a room category..");
		return false;
	}
	
	else return true;
}

function checkNumRooms(num){
	if(isNaN(num)){
		alert("Please enter a number");
		return false;
	}
	else return true;
}