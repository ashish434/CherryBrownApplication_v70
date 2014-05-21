<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="./css/style.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CHERRY BROWN HOTEL</title>

<script src="jquery-1.3.2.min.js" type="text/javascript"></script>
<script src="./js/hitCounter.js"></script>
</head>
<body>
<%@ include file="customerHomeHeader.jsp" %>
	

	<div id="content3">
		<div class="inside3">
			<p style="font-family:counterfont; font-size:25px;">WELCOME
			<%=session.getAttribute("role")%>
			with USERID -
			<%=session.getAttribute("userid")%>
			<%session.setAttribute("custId",session.getAttribute("userid"));%>
			</p>
		</div>
	</div>
<%@ include file="customerHomeFooter.jsp" %>

	
</body>
</html>