<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<title>CHERRY BROWN HOTEL</title>


<link rel="stylesheet" type="text/css" href="./css/style.css" />
<link rel="stylesheet" type="text/css" href="./css/validationForLogin.css" />
<link rel="stylesheet" type="text/css" href="./css/onloadPopup.css" />
<link rel="stylesheet" type="text/css" href="./css/sideMenu.css" />

<script language="JavaScript1.1">
var image1=new Image()
image1.src="./images/banner1.jpg"
var image2=new Image()
image2.src="./images/banner2.jpg"
var image3=new Image()
image3.src="./images/banner3.jpg"
var image4=new Image()
image4.src="./images/banner4.jpg"
</script>

<script src="./js/mmenu.js" type="text/javascript"></script>
<script src="./js/menuItems.js" type="text/javascript"></script>


<script src="jquery-1.3.2.min.js" type="text/javascript"></script>
<script src="./js/hitCounterHome.js" type="text/javascript"></script>

<%-- HAMDAN END: code for SIDE MENU! --%>

<script>
$(window).load(function(){
	 var userid='<%=application.getAttribute("logout")%>';
	if(userid===null||userid==='null'||userid===undefined){}
	else {alert(userid+" Logout Successful!");}
	<%application.removeAttribute("logout");%>
});
</script>


<script src="./js/loginValidations.js" type="text/javascript"></script>

<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1251">
<script src="./js/popup.js" type="text/javascript"></script>


</head>

<body>

	<div id="boxes">
		<div style="top: 199.5px; left: 551.5px; display: none;" id="dialog">
			<img src="./images/banner1.jpg" name="slide" width="500" height="400" />
			<a href="#" class="close">Close it</a>
<script>

var step=1
function slideit()
{
if (!document.images)
return
document.images.slide.src=eval("image"+step+".src")
if (step<4)
step++
else
step=1
setTimeout("slideit()",3500)
}
slideit()
</script>
		</div>
		<!-- Mask to cover the whole screen -->
		<div style="width: 1478px; height: auto; display: none; opacity: 0.8;"
			id="mask"></div>
	</div>

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

					<h4>Welcome to our hotel</h4>

					<p>
						<strong>Welcome to the splendid world of <br>Hotel
							Cherry Brown.
						</strong>
					</p>
					<p>This Hotel is located in the heart of Hyderabad at Banjara
						Hills, Masab Tank. It is about 30 minutes away from Hitec City.
						The Hotel is an ideal hotel for both business and leisure traveler
						and is very close to the Hyderabad Airport. For
						those who want to travel to Hyderabad, Cherry Brown hotel is
						only moments away from the city's main commercial, shopping and
						entertainment hubs.</p>
					<br></br>
					<p>As travel often means more hassle than harmony, more stress
						than satisfaction, modern travelers are looking for smarter
						choices. Driven by our passion for perfection, we welcome our
						customers to a refreshingly enjoyable and hassle-free experience,
						anytime, everywhere. Offering the highest consistency in quality,
						service and style we set new standards and take the unwanted
						surprises out of traveling. Our warm welcomes make our guests feel
						at home, away from home and our crisp and courteous service
						empowers them to get more done with greater effectiveness and
						control. And through our unrivalled network we provide service
						that is effortless, simple, never overwhelming, always warm.</p>
					<br></br>

					<p>The Hotel has endeavoured for more than Three decades to
						serve you the very best in hospitality services. Our motto is to
						provide our guests with customized hospitality services, backed up
						by latest technology equipment and trained service staff.</p>
					<p>The Hotel is beautifully furnished in contemporary style
						with lavish use of glass, wood and steel, providing a distinctive
						level of luxury, comfort, impeccable service and value for money.
						It was founded by Late Shri Mufti Siddique in the year 1979.</p>

				</div>

			</div>
			<div id="photogallery">
				<div class="photos">
					<img src="./images/photogallery_title.gif" alt="" width="270"
						height="62" id="title" /> <img class="i3" src="./images/img1.jpg"
						alt="" width="158" height="100" /> <span>Name Photo</span> <img
						class="i3" src="./images/img2.jpg" alt="" width="158" height="100" />
					<span>Name Photo</span> <img class="i3" src="./images/img3.jpg"
						alt="" width="158" height="100" /> <span>Name Photo</span> <img
						class="i3" src="./images/img4.jpg" alt="" width="158" height="100" />
					<span>Name Photo</span> <a href="#" id="all"><img
						src="./images/all.gif" alt="" width="134" height="21" /></a>
				</div>
				<img src="./images/end.gif" alt="" width="270" height="60" />
			</div>
		</div>
	</div>

		<%@include file="footer.jsp"%>

</body>
</html>