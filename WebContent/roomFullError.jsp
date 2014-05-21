<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="com.tcs.ilp.domain.Room"%>
<%@ page import="java.util.*"%>
<%@ page import="com.tcs.ilp.domain.*"%>
<%@page import="static com.tcs.ilp.util.CBApplicationConstants.*"%>
<%@page errorPage="showError.jsp" isErrorPage="false"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="./css/style.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CHERRY BROWN HOTEL</title>

<script src="jquery-1.3.2.min.js" type="text/javascript"></script>
<script src="./js/hitCounter.js"></script>

</head>
<body>
<%@include file="adminHomeHeader.jsp"%>

	<div id="content3">
		<div class="inside3">

			<table border="1"
				style="margin: 70px 50px 20px 0px; font-family: Eras Medium ITC, Trebuchet MS; font-size: 20px; background-color: #FDD7E4; border-collapse: collapse; border-color: red; width: 900px; height: 100px; color: black;">
				<tr>
					<td style="padding-left: 10;"><b>ALL ROOMS BOOKED.. NO VACANT ROOMS AVAILABLE.. PLEASE TRY AGAIN LATER!</b></td>
				</tr>

			</table>
		</div>
	</div>
	<%@include file="adminHomeFooter.jsp"%>
	
</body>
</html>