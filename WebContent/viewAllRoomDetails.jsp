<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page import="java.util.List"%>
<%@page import="com.tcs.ilp.domain.Room"%>
<%@page import="static com.tcs.ilp.util.CBApplicationConstants.*"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>

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
			<h4 id="adminbroadtitles">LIST OF ROOM DETAILS</h4>
			<br> <br> <br>



			<%
				List<Room> listOfAllRooms = (List<Room>) session.getAttribute("listOfAllRooms");
			%>

			<display:table id="CHOStable" name="${listOfAllRooms}" pagesize="4" cellpadding="5px;" cellspacing="5px;" requestURI="#" sort="list">
				<display:column property="roomNumber" title=" ROOMNUMBER" sortable="true" />
				<display:column property="floorNumber" title="FLOORNUMBER" sortable="true" />
				<display:column property="roomStatus" title="ROOMSTATUS" sortable="true" />
				<display:column property="roomType" title="ROOMTYPE" sortable="true" />
				<display:column property="acFacility" title="ACFACILITY" sortable="true" />
				<display:column property="category" title="CATEGORY" sortable="true" />
				<display:column property="requestId" title="REQUESTID" sortable="true" />
			</display:table>
		
		</div>
	</div>
	<%@include file="adminHomeFooter.jsp"%>

</body>
</html>