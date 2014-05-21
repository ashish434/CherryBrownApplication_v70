<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.tcs.ilp.domain.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="./css/style.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CHERRY BROWN HOTEL</title>
<script src="jquery-1.3.2.min.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css"
	href="./css/validationForLogin.css" />
<script src="./js/hitCounter.js"></script>
</head>
<body>
<%@ include file="customerHomeHeader.jsp" %>
	
	<div id="content3">
		<div class="inside3">
			<h4 id="adminbroadtitles">REQUEST DETAILS</h4>
			<br>
			<br>
			<br>
			<%
				RoomRequest req = (RoomRequest) session.getAttribute("details");
				session.setAttribute("req", req.getRequestId());
			%>

			<table id="CHOStable"
				style="margin: 10px 0px 0px 10px; width: 100%; height: 100%; font-size: 20px; float: left">

				<tr>
					<td style="color: #A52A2A">REQUESTID:</td>
					<td><b><%=req.getRequestId()%></b></td>
				</tr>
				<tr class="alt">
					<td style="color: #A52A2A">CUSTOMERID:</td>
					<td><b><%=req.getCustomerId()%></b></td>
				</tr>
				<tr>
					<td style="color: #A52A2A">CHECKINDATE:</td>
					<td><b><%=req.getCheckInDate()%></b></td>
				</tr>
				<tr class="alt">
					<td style="color: #A52A2A">CHECKOUTDATE:</td>
					<td><b><%=req.getCheckOutDate()%></b></td>
				</tr>
				<tr>
					<td style="color: #A52A2A">NUMBEROFROOMREQUIRED:</td>
					<td><b><%=req.getNumberOfRoomsRequired()%></b></td>
				</tr>
				<tr class="alt">
					<td style="color: #A52A2A">REQUESTEDROOMTYPE:</td>
					<td><b><%=req.getRequestedRoomType()%></b></td>
				</tr>
				<tr>
					<td style="color: #A52A2A">ACREQURIED:</td>
					<td><b><%=req.getACRequired()%></b></td>
				</tr>
				<tr class="alt">
					<td style="color: #A52A2A">REQUESTEDCATAGORY:</td>
					<td><b><%=req.getRequestedCategory()%></b></td>
				</tr>
				<tr>
					<td style="color: #A52A2A">REQUESTSTATUS:</td>
					<td><b><%=req.getRequestStatus()%></b></td>
				</tr>
			</table>
			<br>
			<form method="post" action="cancelRoomRequest.action">
				
				<br/><div class="dynamiclabel">
					<input type="submit" value="Cancel Request" style="margin-top: 5px;margin-left: 200px" />
				</div>
			</form>
		</div>
	</div>
	<%@ include file="customerHomeFooter.jsp" %>
	
</body>
</html>