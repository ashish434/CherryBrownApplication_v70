<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.tcs.ilp.domain.*"%>
<%@page import="static com.tcs.ilp.util.CBApplicationConstants.*"%>
<%@taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="./css/style.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CHERRY BROWN HOTEL</title>

<script src="jquery-1.3.2.min.js" type="text/javascript"></script>
<script src="./js/hitCounter.js"></script>
</head>
<body>
<%@include file="customerHomeHeader.jsp"%>
	
	<div id="content3">
		<div class="inside3">

			<h4 id="adminbroadtitles">YOUR ACCOUNT DETAILS</h4>

			<table id="CHOStable"
				style="margin: 50px 0px 0px 100px; width: 100%; height: 100%; font-size: 20px; float: left">

				<s:iterator value="#session.objCustomer" status="userStatus">
					<%-- <s:if test="#userStatus.odd == true"> --%>
					<tr>
						<td style="color: #A52A2A">ID:</td>
						<td><s:property value="customerId"></s:property></td>
					</tr>
					<tr>
						<td style="color: #A52A2A">Name:</td>
						<td><s:property value="name"></s:property></td>
					</tr>
					<tr>
						<td style="color: #A52A2A">Age:</td>
						<td><s:property value="age"></s:property></td>
					</tr>
					<tr>
						<td style="color: #A52A2A">Gender:</td>
						<td><s:property value="gender"></s:property></td>
					</tr>
					<tr>
						<td style="color: #A52A2A">Location:</td>
						<td><s:property value="location"></s:property></td>
					</tr>
					<tr>
						<td style="color: #A52A2A">Email ID:</td>
						<td><s:property value="emailId"></s:property></td>
					</tr>
					<tr>
						<td style="color: #A52A2A">Contact Number:</td>
						<td><s:property value="contactNumber"></s:property></td>
					</tr>
				</s:iterator>

				<%-- </s:if> --%>

			</table>
		</div>
	</div>
	<%@include file="customerHomeFooter.jsp"%>


</body>
</html>