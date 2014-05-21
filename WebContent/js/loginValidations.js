function checkId(id){
	var idExp = /^[a-z0-9]+$/i;
	var custId = id.value;
	
	if(custId.length==0)
	{
		alert("Please enter a valid UserID!");
		return false;
	}

	if(!custId.match(idExp)){
		alert("UserID cannot contain special characters!");
		return false;
	}
	else return true;
}

    function validatePassword(pass) {
        var checkpass = /\w/i;
        if (pass.value.match(checkpass)) {
            return true;
        }
        else {
            alert("Please enter a valid Password!");
            return false;
        }

    }