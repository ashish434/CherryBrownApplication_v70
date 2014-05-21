<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="./css/style.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="jquery-1.3.2.min.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css"
	href="./css/validationForLogin.css" />
<script src="./js/hitCounter.js"></script>
<title>CHERRY BROWN HOTEL</title>
</head>
<body>
<%@include file="customerHomeHeader.jsp"%>
	
	<div id="content3">
		<div class="inside3">

			<h1>
				Your Room Booking request has been successfully submitted and will
				be processed shortly.. Your Request ID is:
				<%=session.getAttribute("requestId").toString()%></h1>
		</div>
	</div>
	<%@include file="customerHomeFooter.jsp"%>
	
</body>
</html>