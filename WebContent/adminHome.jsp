<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CHERRY BROWN HOTEL</title>

<link rel="stylesheet" type="text/css" href="./css/style.css" />

<script src="jquery-1.3.2.min.js" type="text/javascript"></script>
<script src="./js/hitCounter.js"></script>


</head>
<body>
<%@ include file="adminHomeHeader.jsp" %>
	
	
	<div id="content3">
		<div class="inside3">
			<p style="font-family:counterfont; font-size:25px;">WELCOME
			<%=session.getAttribute("role")%>
			with USERID -
			<%=session.getAttribute("userid")%>
			</p>
		</div>
	</div>
	<%@ include file="adminHomeFooter.jsp" %>

</body>
</html>