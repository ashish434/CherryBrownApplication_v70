
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html>

<html>
<head>
<script src="./js/registrationValidations.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="./css/validationForLogin.css" />
<script type="text/javascript" src="./js/roomBookingValidations.js"></script>
<script src="./js/onloadPopup.js" type="text/javascript"></script>
<script src="./js/regform_valid.js" type="text/javascript"></script>
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
		
			
					<h4 id="adminbroadtitles">Room Booking</h4>
					<s:actionerror cssClass="styleActionErrorChaitanya" />
					<p class="try"></p>

					<form action="addRoomRequest" method="POST">

						<div class="container" align="center">

							<div class="dynamiclabel">

								<input name="checkInDate" id="checkInDate" class="text"
									placeholder="Check In Date" type="date" min=""
									onclick="initializeCheckIn()"
									onblur="return validateCheckIn(this)" />
								<s:label value="Check In Date"></s:label>
							</div>

							<div class="dynamiclabel">

								<input name="checkOutDate" id="checkOutDate" class="text"
									placeholder="Check Out Date" type="date" min=""
									onclick="initializeCheckOut()"
									onblur="return validateCheckOutDate(this)" />
								<s:label value="Check Out Date"></s:label>
							</div>

							<div class="dynamiclabel">
								<s:select list="#{'1':1, '2':2, '3':3, '4':4 }"
									name="numberOfRoomsRequired" label="Number of Rooms Required"
									placeholder="Number of Rooms Required" cssClass="text"></s:select>
								<s:label value="Number of Rooms Required"></s:label>
							</div>

							<div class="dynamiclabel">
								<s:select list="#{'Single':'Single', 'Double':'Double' }"
									name="requestedRoomType" label="Room Type"
									placeholder="Room Type" cssClass="text"
									onblur="return isRoomTypeSelected(this)"></s:select>
								<s:label value="Request Room Type"></s:label>
							</div>

							<div class="dynamiclabel">
								<s:select list="#{'AC':'AC', 'Non-AC':'Non-AC' }"
									name="ACRequired" label="AC/Non-AC" placeholder="AC/Non-AC"
									cssClass="text" onblur="return isACTypeSelected(this)"></s:select>
								<s:label value=" Room Type"></s:label>
							</div>

							<div class="dynamiclabel">
								<s:select
									list="#{'Standard':'Standard', 'Suite':'Suite', 'Executive':'Executive' }"
									name="requestedCategory" label="Category"
									placeholder="Category" cssClass="text"
									onblur="return isRoomCategorySelected(this)"></s:select>
								<s:label value="Room Category"></s:label>
							</div>

							<div class="dynamiclabel">
								<s:submit cssClass="buttons" value="Book My Room" align="center"></s:submit>
								<s:token></s:token>
							</div>
						</div>
					</form>
				
		</div>
		<div id="photogallery"></div>
	</div>
	<%@include file="customerHomeFooter.jsp"%>
	
</body>
</html>