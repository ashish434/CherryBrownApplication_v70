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
		
		

			<h4 id="adminbroadtitles">Check REQUEST Progress By Customer-ID</h4>
			<br/><br/>
		<div style="border: 1px solid #c3c3c3; border-radius:20px; width:320px; display:block;  left: 370px">
		
			<div style="position:relative ;">
			
			<form method="post" action="checkCustomerRequestsByCUSTID">
				<div class="dynamiclabel">

					<s:textfield name="custoId" label="CUSTOMERID"  
						placeholder="Enter CUSTOMER-ID" onblur="return checkId(this)" />
					<s:label value="Customer Id" />
				</div>
				<div class="dynamiclabel">
					<input type="submit" value="Submit"/>
				</div>
			</form>
			
			</div>
			<br/>
			</div>
			
			
		</div>
	</div>
	<%@ include file="customerHomeFooter.jsp" %>
	
</body>
</html>