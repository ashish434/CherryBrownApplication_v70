<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="./css/style.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="jquery-1.3.2.min.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="./css/validationForLogin.css" />
<script src="./js/hitCounter.js"></script>
<script src="./js/registrationValidations.js" type="text/javascript"></script>
<title>CHERRY BROWN HOTEL</title>
</head>
<body>
<%@ include file="customerHomeHeader.jsp" %>
	
	
	<div id="content3">
		<div class="inside3">

	
<h4 id="adminbroadtitles" style="position:relative;">Check REQUEST Progress By Request-ID</h4>
		<br/><br/>
		<div style="border: 1px solid #c3c3c3; border-radius:20px; width:320px; display:block;  left: 370px">
		
			<div style="position:relative;">
			<form method="post" action="checkCustomerRoomRequestStatusByREQID">
				<div class="dynamiclabel">
					<s:textfield id="reqId" name="reqId" label="REQUESTID"  
						placeholder="Enter REQUEST-ID" onblur="return checkId(this)" />
					<s:label value="Request Id" />
					
				</div>
				<div class="dynamiclabel">
					<input type="submit" value="Submit"/>
				</div>
			
				</form>
				<div class="create_account">
						<a href="customerRoomRequestStatusByCUSTID"> <u>Browse REQUEST Progress by Customer-ID</u></a>
			</div>
			</div>
			<br/>
			</div>
			
			</div>
		</div>
	
<%@ include file="customerHomeFooter.jsp" %>
	

</body>
</html>