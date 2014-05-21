<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="com.tcs.ilp.domain.Login"%>

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
<%@include file="header.jsp"%>
	
	<div id="content3">

		<%
			Login loginDetails = (Login) session.getAttribute("loginCredentials");
		%>

		<div class="inside3">

			<table border="1"
				style="margin: 70px 50px 20px 80px; font-family: counterfont; font-size: 24px; background-color: #BCED91; border-collapse: collapse; border-color: red; width: 750px; height: 100px; color: black;">
				<tr>
					<td colspan="2" style="padding-left: 20px;">CUSTOMER REGISTERED SUCCESSFULLY</td>
				</tr>
				<tr style="font-family: Verdana; font-size: 14px;">
					<td style="padding-left: 20px;">Your ID is: <b><%=loginDetails.getUserid()%></b>&nbsp;and
						Password is: <b><%=loginDetails.getPassword()%></b></td>
				</tr>
			</table>
		</div>
	</div>
	<%@include file="footer.jsp"%>

</body>
</html>