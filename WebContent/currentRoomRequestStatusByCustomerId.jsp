<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@page import="com.tcs.ilp.domain.*" %>
      <%@page import="java.util.List"%>
      <%@taglib prefix="display" uri="http://displaytag.sf.net"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="./css/style.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CHERRY BROWN HOTEL</title>
<script src="jquery-1.3.2.min.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="./css/validationForLogin.css" />
<script src="./js/hitCounter.js"></script>
</head>
<body>
<%@ include file="customerHomeHeader.jsp" %>

	<div id="content3">
		<div class="inside3">
		<h4 id="adminbroadtitles">REQUESTS DETAILS</h4>
<br><br><br>


<%
List<RoomRequest> listOfAllRequest=(List<RoomRequest>)session.getAttribute("allDetails");
%>

	<display:table id="CHOStable" name="${allDetails}"  pagesize="4" cellpadding="5px;" cellspacing="5px;"  requestURI="#" sort="list">
		<display:column property="requestId"  title=" REQUEST<br>ID" sortable="true" />
		<display:column property="checkInDate" title="CHECKIN<br>DATE" sortable="true"/>
		<display:column property="checkOutDate" title="CHECKOUT<br>DATE" sortable="true" />
		<display:column property="numberOfRoomsRequired" title="NUMBER<br>OFROOM<br>REQUIRED" sortable="true"/>
		<display:column property="requestedRoomType" title="REQUESTED<br>ROOMTYPE" sortable="true"/>
		<display:column property="ACRequired" title="AC<br>REQUIRED" sortable="true"/>
		<display:column property="requestedCategory" title="REQUESTED<br>CATEGORY" sortable="true"/>
		<display:column property="requestStatus" title="REQUEST<br>STATUS" sortable="true"/>
		</display:table>
	</div>
</div>
<%@ include file="customerHomeFooter.jsp" %>

</body>
</html>