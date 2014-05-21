<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page import="java.util.*"%>
<%@page import="static com.tcs.ilp.util.CBApplicationConstants.*"%>
<%@page import="com.tcs.ilp.domain.RoomRequest"%>
<%@page import="com.tcs.ilp.domain.Customer"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@page import="java.lang.Exception, java.sql.SQLException"%>
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
			<h4 id="adminbroadtitles">LIST OF ROOM REQUESTS</h4>
			<br>
			<br>
			<br>
						
<%List<RoomRequest> listRoomRequest=(List<RoomRequest>)session.getAttribute("listRoomRequest"); %>

	<display:table id="CHOStable" name="${listRoomRequest}" pagesize="4" cellpadding="5px;" cellspacing="5px;"  requestURI="" sort="list" >
		<display:column property="requestId"  title=" REQUEST<br>ID" href="allotRoomRequest" paramId="name" paramProperty="requestId" sortable="true" />
		<display:column property="customerId" title=" CUSTOMER<br>ID" sortable="true" />
		<display:column property="checkInDate" title="CHECKIN<br>DATE" sortable="true"/>
		<display:column property="checkOutDate" title="CHECKOUT<br>DATE" sortable="true" />
		<display:column property="numberOfRoomsRequired" title="NUMBER<br>OFROOMS<br>REQUIRED" sortable="true"/>
		<display:column property="requestedRoomType" title="REQUESTED<br>ROOMTYPE" sortable="true"/>
		<display:column property="ACRequired" title="AC<br>REQUIRED" sortable="true"/>
		<display:column property="requestedCategory" title="REQUESTED<br>CATEGORY" sortable="true"/>
		<display:column property="requestStatus" title="REQUEST<br>STATUS" sortable="true"/>
	</display:table>
		
		</div>
	</div>
	
	<%@include file="adminHomeFooter.jsp"%>
	
</body>
</html>