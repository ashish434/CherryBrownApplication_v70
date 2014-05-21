<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page import="java.util.List, org.hibernate.SessionFactory"%>
<%@page import="java.sql.Connection"%>
<%@ page isErrorPage="false" errorPage="showError.jsp"%>
<%@page import="com.tcs.ilp.dao.CBRoomBookingServicesDAOFactory"%>

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
			<h4 id="adminbroadtitles">CONNECTION STATUS</h4>
			<br>
			<br>

			<%!SessionFactory sessionFactory = null; String status;%>

			<%
			sessionFactory = CBRoomBookingServicesDAOFactory.getInstance().getSessionFactory();
				if (sessionFactory != null)
					status = "Established Successfully . .";
				else
					status = "Failure . .";
			%>

			<p>
				<b>Connection Status: </b><b style="color:green"><%=status%></b></p>
			<%=sessionFactory%><br>
			<br>
			<br>
			<% if(status.equalsIgnoreCase("Established Successfully . .")) { %>
			<b style="color:green">TESTING FEW FUNCTIONALITIES!</b><BR>
			<br>
			<p style="word-wrap:break-word;">
				<b>Testing fetchAllRoomDetails() method: </b><br/><%=CBRoomBookingServicesDAOFactory.getInstance()
					.getCBRoomManagementDAO().fetchAllRoomDetails() %></p><b style="color:red">Test Successful!</b>
			<br>
			<br>
			<p style="word-wrap:break-word;">
				<b>Testing fetchAllRoomRequestDetails() method: </b><br/><%=CBRoomBookingServicesDAOFactory.getInstance()
					.getCBRoomManagementDAO().fetchAllRoomRequestDetails()%></p><b style="color:red">Test Successful!</b>
			<br>
			<br>
			<p style="word-wrap:break-word;">
				<b>Testing updateRoomAllotmentStatus() method: </b><%=CBRoomBookingServicesDAOFactory.getInstance()
					.getCBRoomManagementDAO()
					.checkAndAllotRoomRequest("REQ123")%></p><b style="color:red">Test Successful!</b> <% } %>
			<br>
			<br>
		</div>
	</div>
	<%@include file="adminHomeFooter.jsp"%>
	

</body>
</html>