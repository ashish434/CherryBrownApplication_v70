package com.tcs.ilp.struts;

import static com.tcs.ilp.util.CBApplicationConstants.*;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.tcs.ilp.delegate.CBBussinessDelegate;
import com.tcs.ilp.domain.Room;
import com.tcs.ilp.domain.RoomRequest;
import com.tcs.ilp.exception.CBException;

/**
 * @author H55 - Group 1 The action class for room management
 */
public class RoomManagementAction extends ActionSupport implements
		ModelDriven<RoomRequest>, SessionAware, ServletRequestAware {

	Map<String, Object> sessionMap = null;
	private static final long serialVersionUID = -2135335977699277847L;
	CBBussinessDelegate delegate = new CBBussinessDelegate();
	String status = FAILURE;
	HttpServletRequest request = null;
	RoomRequest roomRequest = new RoomRequest();
	
	static Logger logger = Logger.getLogger(RoomManagementAction.class);

	public RoomRequest getModel() {
		return roomRequest;
	}

//	
//	public String processAllRoomDetails() {
//		
//		logger.info("INSIDE ACTION METHOD processAllRoomDetails()");
//
//		List<Room> listOfAllRooms = null;
//		try {
//			listOfAllRooms = (List<Room>) delegate.fetchAllRoomDetails();
//		} catch (CBException e) {
//			sessionMap.put(ERROR_MSG_ATTRIBUTE, e.getCBMessage());
//			e.printStackTrace();
//		}
//		if ((!listOfAllRooms.isEmpty()) || listOfAllRooms != null) {
//			sessionMap.put("listOfAllRooms", listOfAllRooms);
//			status = SUCCESS;
//		}
//
//		return status;
//
//	}
	
	
	/*
	 * processTestConnection method is an action class method that simply returns SUCCESS.
	 * It provides direct access to testConnection.jsp page for testing DB connection
	 */
	public String processTestConnection() {
		
		logger.info("INSIDE ACTION METHOD processTestConnection()");
		
		logger.info("SUCCESS in processTestConnection()");
		
		return SUCCESS;
	}
	
	
	/*
	 * processAdminHome method is an action class method that simply returns SUCCESS.
	 * It provides direct access to adminHome.jsp page.
	 */
	public String processAdminHome() {
		
		logger.info("INSIDE ACTION METHOD processAdminHome()");
		
		logger.info("SUCCESS in processAdminHome()");
		
		return SUCCESS;
	}
	
	
	/*
	 * processGetAllRoomRequests method is to get all the room requests made by
	 * customer It throws Exception in case any exception occurs
	 */
	public String processGetAllRoomRequests() {
		
		logger.info("INSIDE ACTION METHOD processGetAllRoomRequests()");

		List<RoomRequest> listOfRoomRequest = null;
		try {
			listOfRoomRequest = delegate.getAllRoomRequestDetails();
			
			if(listOfRoomRequest==null)
			{
				status=ERROR;
				throw new CBException(ERROR_FETCH_ALL_ROOM_REQUESTS);
			}
			else if (listOfRoomRequest != null||listOfRoomRequest.isEmpty())
			{
				sessionMap.put("listRoomRequest", listOfRoomRequest);
				status = SUCCESS;
				logger.info("SUCCESS in CBRoomManagementDAOImpl fetchAllRoomRequestDetails() method");
			}
			
		} catch (CBException e) {
			logger.error("FAILURE in CBRoomManagementDAOImpl fetchAllRoomRequestDetails() method : "+e.getCBMessage());
			sessionMap.put(ERROR_MSG_ATTRIBUTE, e.getCBMessage());
			e.printStackTrace();
		}
		return status;
	}

	/*
	 * processAllotCustomerRoom method is to allot room to the customer It
	 * throws Exception in case any exception occurs
	 */
	public String processAllotCustomerRoom(){
		
		logger.info("INSIDE ACTION METHOD processAllotCustomerRoom()");
		
		List<Room> allottedRooms = null;
		try {
			allottedRooms = delegate.getRoomAllotted(getServletRequest().getParameter("name"));
			System.out.println(allottedRooms);
			
			if(allottedRooms==null)
				throw new CBException("INVALID REQUESTID.. NO SUCH REQUEST-ID EXISTS IN OUR DATABASE");
			else
			{
				sessionMap.put("allottedRooms", allottedRooms);
				status = SUCCESS;
				logger.info("SUCCESS in CBRoomManagementDAOImpl checkAndAllotRoomRequest() method");
			}
		} catch (CBException e) {
			logger.error("FAILURE in CBRoomManagementDAOImpl checkAndAllotRoomRequest() method : "+e.getCBMessage());
			sessionMap.put(ERROR_MSG_ATTRIBUTE, e.getCBMessage());
			e.printStackTrace();
			status = ERROR;
		}
		return status;
	}

	/*
	 * 
	 * @see com.opensymphony.xwork2.ActionSupport#validate() validate method is
	 * to apply validations on checkMyRequestProgress and registerCustomers
	 * javascript is used for the validations
	 */
	public void validate() {

		String actionStr = ActionContext.getContext().getName();
		
		logger.info("ACTION Hit is: "+actionStr);
		logger.info("Entering Validate Method");

		if (actionStr.equalsIgnoreCase("addRoomRequest")) {

			System.out.println(roomRequest.getCheckInDate());
			SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT);
			Date checkInDate = null;
			Date checkOutDate = null;
			try {
				checkInDate = format.parse(roomRequest.getCheckInDate());
				checkOutDate = format.parse(roomRequest.getCheckOutDate());
			} catch (ParseException e) {
				e.printStackTrace();
			}
			validateRoomRequest(checkInDate, checkOutDate);
		}
	}

	private void validateRoomRequest(Date checkInDate, Date checkOutDate) {
		if ((roomRequest.getCheckInDate().equals("null")
				|| roomRequest.getCheckInDate() == null || roomRequest
				.getCheckInDate().trim().equals(""))
				&& (roomRequest.getCheckOutDate().equals("null")
						|| roomRequest.getCheckOutDate() == null || roomRequest
						.getCheckOutDate().trim().equals(""))) {

			logger.error("Validate Method Field Error: "+"checkInDate and checkOutDate fields");
			addActionError(BOTH_DATES_ERROR);
		}

		else if (roomRequest.getCheckInDate().equals("null")
				|| roomRequest.getCheckInDate() == null
				|| roomRequest.getCheckInDate().trim().equals("")) {

			logger.error("Validate Method Field Error: "+"checkInDate");
			addActionError(CHECKIN_DATE_ERROR);
		}

		else if (roomRequest.getCheckOutDate().equals("null")
				|| roomRequest.getCheckOutDate() == null
				|| roomRequest.getCheckOutDate().trim().equals("")) {

			logger.error("Validate Method Field Error: "+"checkOutDate");
			addActionError(CHECKOUT_DATE_ERROR);
		}

		else if (checkOutDate.before(checkInDate)) {
			
			logger.error("Validate Method Field Error: "+CHECKIN_CHECKOUT_COMPARISON_ERROR);
			addActionError(CHECKIN_CHECKOUT_COMPARISON_ERROR);
		}
	}

	public String processAddRoomRequest() {
		
		logger.info("INSIDE ACTION METHOD processAddRoomRequest()");
		
		String userId = (String) sessionMap.get(USERID_ATTRIBUTE);
		roomRequest.setCustomerId(userId);
		System.out.println("Customer Id: " + userId);
		roomRequest.setRequestStatus(PENDING);
		String requestId = null;
		try {
			requestId = delegate.addRoomRequest(roomRequest);
			
			if(requestId==null)
			{
				status=ERROR;
				throw new CBException(ROOMREQUEST_ID_ERROR);
			}
			else
			{	
				sessionMap.put("requestId", requestId);
				status=SUCCESS;
				logger.info("SUCCESS in CBRoomManagementDAOImpl addRoomRequest() method");
			}
			
		} catch (CBException e) {
			logger.error("FAILURE in CBRoomManagementDAOImpl addRoomRequest() method : "+e.getCBMessage());
			sessionMap.put(ERROR_MSG_ATTRIBUTE, e.getCBMessage());
			e.printStackTrace();
		}
			return status;
	}

	/*
	 * processViewAllRoomDetails method is to process the details of all the rooms
	 * It returns the status of the room It throws Exception in case any
	 * exception occurs
	 */
	public String processViewAllRoomDetails(){
		
		logger.info("INSIDE ACTION METHOD processViewAllRoomDetails()");
		
		List<Room> listOfAllRooms = null;
		try {
			listOfAllRooms = (List<Room>) delegate.fetchAllRoomDetails();
			
			if(listOfAllRooms==null||listOfAllRooms.isEmpty())
			{
				status=ERROR;
				throw new CBException(ERROR_FETCH_ALL_ROOM_DETAILS);
			}
			else
			{
				sessionMap.put("listOfAllRooms", listOfAllRooms);
				status = SUCCESS;
				logger.info("SUCCESS in CBRoomManagementDAOImpl fetchAllRoomDetails() method");
			}
			
		} catch (CBException e) {
			logger.error("FAILURE in CBRoomManagementDAOImpl fetchAllRoomDetails() method : "+e.getCBMessage());
			sessionMap.put(ERROR_MSG_ATTRIBUTE, e.getCBMessage());
			e.printStackTrace();
		}
		return status;
	}

//	public String rejectRoomRequest() throws Exception {
//		
//		logger.info("INSIDE ACTION METHOD rejectRoomRequest()");
//		
//		logger.info("SUCCESS in rejectRoomRequest()");
//		
//		return SUCCESS;
//	}

	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;

	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public HttpServletRequest getServletRequest() {
		return request;

	}

}
