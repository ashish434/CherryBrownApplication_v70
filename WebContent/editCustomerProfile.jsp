<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import="com.tcs.ilp.domain.*" %>
     <%@page import="static com.tcs.ilp.util.CBApplicationConstants.*" %>
     <%@taglib uri="/struts-tags" prefix="s" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link rel="stylesheet" type="text/css" href="./css/style.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CHERRY BROWN HOTEL</title>

<script src="jquery-1.3.2.min.js" type="text/javascript"></script>
<script src="./js/hitCounter.js"></script>
<script src="./js/registrationValidations.js" type="text/javascript"></script>



</head>
<body>
<%@ include file="customerHomeHeader.jsp" %>

	<div id="content3">
		<div class="inside3">

<h4 id="adminbroadtitles">UPDATE YOUR DETAILS</h4>

<table id="CHOStable" style="margin:50px 0px 0px 100px; width:100%; height:100%; font-size:20px; float:left">
<s:actionerror cssClass="pos"/>
<form action="updateCustomerProfile" method="post">
	<s:textfield name="customerId" label="ID" value="%{#session.objCustomer.customerId}" disabled="true"/>
	<s:textfield name="name" label="Name" value="%{#session.objCustomer.name}" onblur="return checkName(this)"/>
	<s:textfield name="age" label="Age" value="%{#session.objCustomer.age}" onblur="return checkAge(this)"/>
	<s:textfield name="gender" label="Gender" value="%{#session.objCustomer.gender}" disabled="true"/>
	<s:textfield name="location" label="Location" value="%{#session.objCustomer.location}" onblur="return checkCity(this)"/>
	<s:textfield name="emailId" label="Email ID" value="%{#session.objCustomer.emailId}" onblur="return validateEmail(this)"/>
	<s:textfield name="contactNumber" label="Contact Number" value="%{#session.objCustomer.contactNumber}" onblur="return validatePhoneNum(this)"/>
	<s:submit value="UPDATE" label="Submit!" align="center" cssClass="hamd_button"/>
</form>
</table>
</div>
</div>
<%@ include file="customerHomeFooter.jsp" %>

</body>
</html>