package com.tcs.ilp.util;

/**
 * @author H55 - Group 1 The class defines constants used throughout the
 *         application
 */
public class CBApplicationConstants {

	// HAMDAN

	// ACTION PARAMETER CONSTANTS
	public static final String ACTION = "action";
	public static final String LOGIN = "login";

	// Action constant to populate room requests
	public static final String ACTION_POPULATE_REQUESTS = "populateRoomRequests";

	// Action constant to allot rooms
	public static final String ACTION_ALLOT_ROOM = "allotRoom";

	// Action constant to populate rooms
	public static final String ACTION_POPULATE_ROOMS = "populateRooms";
	public static final String ACTION_HOME = "home";

	// Action constant to add room request
	public static final String ACTION_ADD_ROOM_REQUEST = "addRoomRequest";

	public static final String ERROR_DETAILS = "ErrorDetails";

	public static final String OBJ_ROOM_REQUEST = "objRoomRequest";

	// Action constant to list room requests
	public static final String LIST_ROOM_REQUESTS = "listOfRoomRequest";

	// Action constant to list all rooms
	public static final String LIST_ROOM_DETAILS = "listOfAllRooms";

	public static final String PARAM_REQID = "name";

	// Room Allotment JSP page
	public static final String URL_ALLOT_ROOM = "allotRoomToRoomRequest.jsp";

	// JSP page listing all room requests
	public static final String URL_LIST_ROOM_REQUESTS = "listRoomRequests.jsp";

	// Error page url
	public static final String ERROR_URL = "error.jsp";

	// JSP page showing all room details
	public static final String URL_LIST_ROOM_DETAILS = "viewAllRoomDetails.jsp";
	public static final String URL_ROOM_REQUEST_PAGE = "listRoomRequests.jsp";

	// Admin Home page
	public static final String URL_HOME = "adminHome.jsp";

	// HQL query to retrieve details for a specific Customer ID
	public static final String HQL_GET_REQUEST_DETAILS_BY_CUSTOMER_ID = "FROM RoomRequest where CUSTOMERID=:CUSTOMERID";

	// Error message string
	public static final String ERROR_MESAGE = "An error occured:";

	public static final String PARAM_CUST_ID = "custId";
	public static final String PARAM_CHECK_IN_DATE = "checkInDate";
	public static final String PARAM_CHECK_OUT_DATE = "checkOutDate";
	public static final String PARAM_NUM_ROOMS = "numOfRooms";
	public static final String PARAM_ROOM_TYPE = "roomType";
	public static final String PARAM_AC_TYPE = "acType";
	public static final String PARAM_ROOM_CATEGORY = "roomCat";

	// View Customer details page URL
	public static final String URL_CUSTOMER_DETAILS = "viewCustomerProfile.jsp";

	// Get Profile Action constant
	public static final String ACTION_GET_PROFILE = "viewCustomerProfile";
	public static final String GET_ID = "reqId";

	// Register Profile Action constant
	public static final String REGISTER_PROFILE = "registerProfile";

	// LOGIN
	public static final String ALLROOM_LIST = "roomList";

	// JSP page shows all Room details
	public static final String ALLROOM_LIST_URL = "allRoomDetails.jsp";

	// Admin home page URL
	public static final String ADMIN_INDEX_URL = "adminHome.jsp";

	// Clerk Home page URL
	public static final String CLERK_INDEX_URL = "clerk.jsp";

	// Customer Home page URL
	public static final String CUSTOMER_INDEX_URL = "customerHome.jsp";

	// Application error page URL
	public static final String ERROR_INDEX_URL = "error.jsp";

	public static final String USERID = "USERID";
	public static final String PASSWORD = "PASSWORD";
	public static final String USER_ROLE = "role";

	// Constant specifying user role - Admin
	public static final String ADMIN_ROLE = "admin";

	// Constant specifying user role - Clerk
	public static final String CLERK_ROLE = "clerk";

	// Constant specifying user role - Customer
	public static final String CUSTOMER_ROLE = "customer";

	// JNDI CONSTANTS
	public static final String JNDI_ENV_PREFIX = "java:/comp/env";
	public static final String DATASOURCE_JNDI = "jdbc/myoracle";

	// SQL CONSTANTS
	public static final String FETCH_ALL_ROOM_REQUESTS = "SELECT * FROM ROOM_REQUEST_GROUP1";

	// HQL query to fetch all room requests
	public static final String HQL_FETCH_ALL_ROOM_REQUESTS = "FROM RoomRequest r";

	public static final String FETCH_ALL_ROOM_DETAILS = "SELECT * FROM ROOM_DETAILS_GROUP1";

	// HQL query to fetch all room details
	public static final String HQL_FETCH_ALL_ROOM_DETAILS = "FROM Room r ";

	// SQL query to update room request status
	public static final String UPDATE_ROOM_REQUEST_STATUS = "UPDATE ROOM_REQUEST_GROUP1 SET REQUESTSTATUS=? WHERE REQUESTID=?";

	// HQL query to update room request status
	public static final String HQL_UPDATE_ROOM_REQUEST_STATUS = "UPDATE RoomRequest SET REQUESTSTATUS=:REQUESTSTATUS WHERE REQUESTID=:REQUESTID";

	// SQL query to update room status
	public static final String UPDATE_ROOM_STATUS = "UPDATE ROOM_DETAILS_GROUP1 SET ROOMSTATUS=?, REQUESTID=? WHERE ROOMNUMBER=?";

	// HQL query to update room status
	public static final String HQL_UPDATE_ROOM_STATUS = "UPDATE Room SET ROOMSTATUS=:ROOMSTATUS, REQUESTID=:REQUESTID WHERE ROOMNUMBER=:ROOMNUMBER";

	// HQL query to fetch login role
	public static final String HQL_FETCH_LOGIN_ROLE = "SELECT C.role FROM Login C WHERE C.userid=:USERID AND C.password=:PASSWORD";
	public static final String ADD_RREQ = "INSERT INTO ROOM_REQUEST_GROUP1(REQUESTID,CUSTOMERID,CHECKINDATE,CHECKOUTDATE,NUMBEROFROOMSREQUIRED,REQUESTEDROOMTYPE,ACREQUIRED,REQUESTEDCATEGORY,REQUESTSTATUS) VALUES (?,?,?,?,?,?,?,?,?)";
	public static final String GET_ROOM_DETAILS = "SELECT * FROM TBL_ROOMS";

	public static final String GET_CUSTOMER_DETAILS = "select * from CUSTOMER_DETAILS_GROUP1 where CUSTOMERID=?";
	public static final String ADD_CUST = "insert into customer_details_group1(CUSTOMERID,NAME,AGE,GENDER,LOCATION,EMAILID,CONTACT_NUMBER,PASSWORD) values(?,?,?,?,?,?,?,?)";

	public static final String GET_REQUEST_DETAILS = "select * from ROOM_REQUEST_GROUP1 where REQUESTID=?";

	// HQL query to fetch all room request details
	public static final String HQL_GET_REQUEST_DETAILS = "FROM RoomRequest where REQUESTID=:REQUESTID AND CUSTOMERID=:CUSTOMERID ";

	// HQL query to cancel(delete) room request details
	public static final String HQL_CANCEL_REQUEST = "DELETE FROM RoomRequest where REQUESTID=:REQUESTID AND REQUESTSTATUS='PENDING'";

	public static final String HQL_CANCEL_REQUEST_SPECIFIC_TO_CUSTOMER = "DELETE FROM RoomRequest where CUSTOMERID=:CUSTOMERID AND REQUESTSTATUS='PENDING'";
	
	// HQL query to cancel(delete) CUSTOMER details
	public static final String HQL_DELETE_CUSTOMER_FROM_LOGIN_TABLE = "DELETE FROM Login where USERID=:USERID AND PASSWORD=:PASSWORD";
	public static final String HQL_DELETE_CUSTOMER_FROM_CUSTOMER_TABLE = "DELETE FROM Customer where NAME=:NAME AND PASSWORD=:PASSWORD";
	
	// SEQUENCES

	// SQL query to generate request id from sequence
	public static final String GENERATE_REQUEST_ID = "select 'REQ'||SEQ_ROOM_REQ.nextval from dual";
	// SQL query to generate customer id from sequence
	public static final String GENERATE_CUSTOMER_ID = "select 'CUST'||SEQ_CUSTOMER_ID.nextval from dual";

	// SQL ERROR CONSTANTS

	// Error constant specifying occurrence of an error while fetching room
	// request details
	public static final String ERROR_FETCH_ALL_ROOM_REQUESTS = "An error occured while fetching Room Requests!";
	public static final String ERROR_FETCH_ROOM_REQUEST = "An error occured while fetching Room Request!";
	public static final String NO_SUCH_ROOM_REQUEST = "No such room request exists!";
	
	// Error constant specifying occurrence of an error while fetching room
	// details
	public static final String ERROR_FETCH_ALL_ROOM_DETAILS = "An error occured while fetching all Room Details!";

	// Error constant specifying occurrence of an error while updating room
	// request status
	public static final String ERROR_UPDATE_ROOM_REQUEST_STATUS = "An error occured while updating Room Request Status!";

	// Error constants specifying occurrence of an error while updating room
	// status
	public static final String ERROR_UPDATE_ROOM_STATUS = "An error occured while updating Room Status!";
	public static final String INSUFFICIENT_ROOMS = "Sufficient Rooms not available to fulfill the request!";

	// Error constant specifying unavailability of rooms
	public static final String ERROR_ROOMS_UNAVAILABLE = "No Vacant rooms available at the moment!";

	// Error constant specifying occurrence of an error during Registration
	public static final String ERROR_REGISTRATION = "Error occurred in Registration..Please try later";

	// Error constant specifying occurrence of an error while submitting a room
	// request
	public static final String ADD_RREQ_ERR = "An error occured while adding the room request:";

	// Error constant specifying occurrence of an error while fetching room
	// details
	public static final String FETCH_ALL_ROOM_DETAILS_ERR = "An error occured while fetching room details";

	public static final String ROLE = "role";
	public static final String USERID_ATTRIBUTE = "userid";
	public static final String LOGOUT = "logout";
	
	// Constants of RoomManagementDAOImpl indicating the various Room Statuses
	public static final String VACANT="VACANT";
	public static final String EMPTY="EMPTY";
	public static final String ALLOTTED="ALLOTTED";
	public static final String APPROVED="APPROVED";
	public static final String PENDING="PENDING";
	public static final String FAILURE = "failure";
	
	public static final String BOTH_DATES_ERROR = "Enter Check-In and Check-Out dates..";
	public static final String CHECKIN_DATE_ERROR = "Enter Check-In date..";
	public static final String CHECKOUT_DATE_ERROR = "Enter Check-Out date..";
	public static final String CHECKIN_CHECKOUT_COMPARISON_ERROR = "Check-out date cannot be before Check-in date..";
	public static final String DATE_FORMAT = "yyyy-MM-dd";
	public static final String ERROR_MSG_ATTRIBUTE = "errorMsg";
	
	public static final String LOGIN_ERROR = "User Does not Exist..!";
	public static final String PROFILE_VIEW_ERROR = "Error displaying your profile..Please try later";
	public static final String PROFILE_UPDATE_ERROR = "Error updating your profile..Please try later";
	public static final String ROOM_BOOKING_ERROR = "Error processing your room request..Please try later";
	public static final String ROOMREQUEST_ID_ERROR = "Error generating room request id..Please try later";
	public static final String ROOM_VIEW_ERROR = "Error displaying room list..Please try later";
	public static final String ROOMREQUEST_CANCEL_ERROR = "Error cancelling your room request..Please try later";
	
	//HQL constants ..
	public static final String REQUESTID = "REQUESTID";
	public static final String CUSTOMERID = "CUSTOMERID";
	public static final String REQUESTSTATUS = "REQUESTSTATUS";
	public static final String ROOMSTATUS = "ROOMSTATUS";
	public static final String ROOMNUMBER = "ROOMNUMBER";

	
}
