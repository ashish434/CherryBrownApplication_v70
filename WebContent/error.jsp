<%@page import="com.opensymphony.xwork2.inject.Context"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="static com.tcs.ilp.util.CBApplicationConstants.ERROR_MSG_ATTRIBUTE"%>
<%@page isErrorPage="true"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="./css/style.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CHERRY BROWN HOTEL</title>

<script src="jquery-1.3.2.min.js" type="text/javascript"></script>
<script src="./js/hitCounter.js"></script>
</head>
<body>

	<div id="header">
		<a href="index.html" id="logo"><img src="./images/logo1.jpg"
			alt="" width="507" height="88" /></a> <span>Traditionally Royal
			hotel</span>
		<ul id="menu">
			<li id="item1"><a href="logout">HOME</a></li>
		</ul>
		<img src="./images/image.jpg" alt="" width="1000" height="311" /><br />
	</div>
	<div id="content3">
		<div class="inside3">

			<table border="1" style="margin: 70px 50px 20px 5px; font-family: Eras Medium ITC, Trebuchet MS; font-size: 20px; background-color: #FDD7E4; border-collapse: collapse; border-color: red; width: 900px; height: 100px; color: black;">
				<tr>
					<td style="padding-left: 10;"><b>APPLICATION ENCOUNTERED FOLLOWING
						EXCEPTION. PLEASE TRY AGAIN LATER!</b></td>
				</tr>
				<tr style="background-color:white">
				<td style="padding-left: 30;"><ul><li><%if(session.getAttribute(ERROR_MSG_ATTRIBUTE)==null){%><%=session.getAttribute(ERROR_MSG_ATTRIBUTE)%><%} else%><%=application.getAttribute(ERROR_MSG_ATTRIBUTE) %></li></ul></td>
				</tr>
			</table>
		</div>
	</div>
	<div id="footer">
		<ul>
			<li id="item1"><a href="logout">HOME</a></li>
		</ul>
		<div id="hitcounter"></div>

		<div id="copyright1">
			<span><b> &copy; Copyright 2013, CHERRY BROWN HOTEL. All
					Rights Reserved.</b></span> <span><b>Designed by #HAMDAN #SOURABH
					#CHAITANYA #KEERTHI #DIVYANI</b></span>
		</div>
	</div>
</body>
</html>