<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="com.tcs.ilp.domain.Room" %>
        <%@ page import="java.util.*" %>
                <%@ page import="com.tcs.ilp.domain.*" %>
    <%@page import="static com.tcs.ilp.util.CBApplicationConstants.*"%>
    <%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="./css/style.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CHERRY BROWN HOTEL</title>

<script src="jquery-1.3.2.min.js" type="text/javascript"></script>
<script src="./js/hitCounter.js"></script>
</head>
<body>
<%@ include file="adminHomeHeader.jsp" %>
	
	<div id="content3">
		<div class="inside3">

		<h4 id="adminbroadtitles" style="width:370px">ROOM ALLOTTED TO <%=request.getParameter("name") %></h4>
		<br><br><br>
		<table id="CHOStable">
    	 <tr>
            <th>ROOMNUMBER</th>
            <th>FLOORNUMBER</th>
            <th>ROOMSTATUS</th>
            <th>ROOMTYPE</th>
             <th>ACFACILITY</th>
            <th>CATEGORY</th>
            <th>REQUESTID</th>
     	</tr>
		
		<s:iterator value="#session.allottedRooms" status="userStatus">
		<s:if test="#userStatus.odd==true">
		<tr class="alt">
			<td><s:property value="roomNumber"/></td>
			<td><s:property value="floorNumber"/></td>
			<td><s:property value="roomStatus"/></td>
			<td><s:property value="roomType"/></td>
			<td><s:property value="acFacility"/></td>
			<td><s:property value="category"/></td>
			<td><s:property value="requestId"/></td>
		</tr>
		</s:if>
		<s:else>
		<tr>
			<td><s:property value="roomNumber"/></td>
			<td><s:property value="floorNumber"/></td>
			<td><s:property value="roomStatus"/></td>
			<td><s:property value="roomType"/></td>
			<td><s:property value="acFacility"/></td>
			<td><s:property value="category"/></td>
			<td><s:property value="requestId"/></td>
		</tr>
		</s:else>
		</s:iterator>
		</table>
		
		<a href="manageRoomRequests">Click to go Back!</a>
</div>
</div>
<%@ include file="adminHomeFooter.jsp" %>

</body>
</html>