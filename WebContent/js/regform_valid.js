function validateForm()
{alert("hi1");
	/*var custId=document.RegUser.customerId.value;
	//alert(custId);
	var filter = /^[a-zA-Z,0-9]{2,30}$/;
	 if (!filter.test(custId) || custId==0 || custId=="")
	  {
	  alert("Please enter valid customerId");
	  return false;
	  }*/
	 alert("hi2");
	var age=document.RegUser.age.value;
	//alert(age);
	if (age == 0 && age == "" && isNaN(age) && (age.length)!=2)
	  {
	  alert("Please enter your age properly(only with numbers)");
	  return false;
	  }
	alert("hi3");
 var uname=document.RegUser.name.value;
 //alert(uname);
 var filter = /^[a-zA-Z]{2,30}$/;
 if (!filter.test(uname) || uname==0 || uname==""||uname.length()<4)
  {
  alert("Please enter your name(with characters only)");
  return false;
  }
 alert("hi4");
/* var x=document.RegUser.password.value;
 var filter = /^[a-zA-Z,0-9]{2,30}$/;
 if (!filter.test(x) || x==0 || x=="")
  {
  alert("Please enter valid password");
  return false;
  }*/

 alert("hi5");
var reg = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
var email=document.RegUser.emailId.value;
//alert(email);
if(reg.test(email)==false)
{
	alert("Please enter a valid email address");
	return false;
}
alert("hi6");
var city=document.RegUser.city.value;
//alert(uname);
var filter = /^[a-zA-Z]{2,30}$/;
if (!filter.test(city) || city==0 || city=="")
 {
 alert("Please enter your name(with characters only)");
 return false;
 }
alert("hi7");
var x = document.RegUser.contactNumber.value;
var filter = /^[0-9]{10}$/;
if (!filter.test(x) || x=="")
  {
  alert("Enter your proper 10 digit mobile number");
  return false;
  }
 
alert("hi8");
  return true;
}




