<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="jquery-1.3.2.min.js" type="text/javascript"></script>
<script src="./js/onloadPopup.js" type="text/javascript"></script>
<script src="./js/registrationValidations.js" type="text/javascript"></script>
<script src="./js/loginValidations.js" type="text/javascript"></script>

<script src="./js/hitCounter.js"></script>
<script src="./js/mmenu.js" type="text/javascript"></script>
<script src="./js/menuItems.js" type="text/javascript"></script>

<title>CHERRY BROWN HOTEL</title>
<meta http-equiv="Content-Type"content="text/html; charset=windows-1251">
<link rel="stylesheet" type="text/css" href="./css/style.css" />
<link rel="stylesheet" type="text/css" href="./css/validationForLogin.css" />
<link rel="stylesheet" type="text/css" href="./css/sideMenu.css" />
</head>

<body>
<%@include file="header.jsp"%>
	
	<div id="content">
		<div class="inside">
			<div id="sidebar">

				<div class="block99"
					style="box-shadow: 10px 10px 5px #FFDEAD; border-radius: 10px; border-style: solid; border-color: black; border-width: 1px;">
					<!-- sourabh -->

					<h4>Login</h4>

					<form method="post" action="login">
						<div class="dynamiclabel">


							<s:textfield id="userid" name="userid" label="USERID"
								placeholder="USERID" onblur="return checkId(this)" />
							<s:label value="User Id" />
						</div>


						<div class="dynamiclabel">

							<s:password id="password" name="password" label="PASSWORD"
								placeholder="PASSWORD" onblur="return validatePassword(this)" />
							<s:label value="Password" />
							<s:a href="#" style="float:right; padding-right:75px">
								<u>Forgot Password?</u>
							</s:a>
						</div>

						<div class="dynamiclabel">
							<input type="submit" value="Submit" />
						</div>
					</form>

					<div class="create_account">
						Don't have an ID?<a href="customerRegistration"> <u>Create
								a new account!</u></a>
					</div>

					<!-- sourabh -->
					<br>
				</div>
				<br>
				<br>
				<br>
				<br>
				<br>
				<div class="block99">
					<!-------Do not change below this line------->
					<div align="center">
						<iframe align="center"
							src="http://www.calendarlabs.com/calendars/web-content/calendar.php?cid=1001&uid=1298010900&c=8&l=en&cbg=C3D9FF&cfg=000000&hfg=000000&hfg1=000000&ct=1&cb=1&cbc=2275FF&cf=verdana&cp=&sw=0&hp=t&ib=0&ibc=&i="
							width="170" height="155" marginwidth=0 marginheight=0
							frameborder=0 scrolling=no allowtransparency='true'>Loading...</iframe>
						<div align="center"
							style="width: 140px; font-size: 10px; color: #666;">
							Powered by <a href="http://www.calendarlabs.com/" target="_blank"
								style="font-size: 10px; text-decoration: none; color: #666;">Calendar</a>
							Labs
						</div>
					</div>
					<!-------Do not change above this line------->

				</div>
			</div>
			<div id="center">

				<div class="block">
					<h4>Customer Registration</h4>

					<form name="RegUser" action="registerNewCustomer" method="POST">
						<div class="container" align="center">
							<div class="dynamiclabel">
								<s:textfield placeholder="User Name" type="text" name="name"
									onblur="return checkName(this)"></s:textfield>
								<s:label value="User Name"></s:label>

							</div>

							<div class="dynamiclabel">
								<s:textfield id="age" placeholder="Age" type="text" name="age"
									onblur="return checkAge(this)"></s:textfield>
								<s:label value="Age"></s:label>

							</div>


							<div class="dynamiclabel">
								<input type="radio" name="gender" value="male" checked="checked">Male
								<input type="radio" name="gender" value="female">Female
							</div>
							<div class="dynamiclabel">

								<s:textfield placeholder="City" type="text" name="location"
									onblur="return checkCity(this)"></s:textfield>
								<s:label value="City"></s:label>

							</div>

							<div class="dynamiclabel">
								<s:textfield placeholder="Email ID" type="text" name="emailId"
									onblur="return validateEmail(this)"></s:textfield>
								<s:label value="Email Id"></s:label>


							</div>



							<div class="dynamiclabel">
								<s:textfield placeholder="Contact Number" type="text"
									name="contactNumber" onblur="return validatePhoneNum(this)"></s:textfield>
								<s:label value="Contact Number"></s:label>

							</div>

							<div class="dynamiclabel">
								<s:token></s:token>
								<input type="submit" value="Register">
							</div>
						</div>
					</form>
				</div>

			</div>
			<div id="photogallery">
				<div class="photos">
					<img src="images/photogallery_title.gif" alt="" width="270"
						height="62" id="title" /> <a href="#" target="_blank"><img
						class="i3" src="images/img1.jpg" alt="" width="158" height="100" /></a>
					<span>Name Photo</span> <a href="#" target="_blank"><img
						class="i3" src="images/img2.jpg" alt="" width="158" height="100" /></a>
					<span>Name Photo</span> <a href="#" target="_blank"><img
						class="i3" src="images/img3.jpg" alt="" width="158" height="100" /></a>
					<span>Name Photo</span> <a href="#" target="_blank"><img
						class="i3" src="images/img4.jpg" alt="" width="158" height="100" /></a>
					<span>Name Photo</span> <a href="#" id="all"><img
						src="images/all.gif" alt="" width="134" height="21" /></a>
				</div>
				<img src="images/end.gif" alt="" width="270" height="60" />
			</div>
		</div>
	</div>
	<%@include file="footer.jsp"%>
	

</body>
</html>