package com.tcs.ilp.struts;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import com.tcs.ilp.delegate.CBBussinessDelegate;
import com.tcs.ilp.domain.Customer;
import com.tcs.ilp.domain.Login;
import com.tcs.ilp.domain.RoomRequest;
import com.tcs.ilp.exception.CBException;
import static com.tcs.ilp.util.CBApplicationConstants.*;
import java.util.regex.*;

/**
 * @author H55 - Group 1
 * @The action class for customer management
 */
public class CustomerManagementAction extends ActionSupport implements
		ModelDriven<Customer>, SessionAware, ServletRequestAware {

	private static final long serialVersionUID = -3525090712792163983L;

	Map<String, Object> sessionMap = null;
	CBBussinessDelegate delegate = new CBBussinessDelegate();
	String status = FAILURE;
	HttpServletRequest request = null;
	java.util.List<RoomRequest> requestList = null;
	Customer customer = new Customer();
	
	
	static Logger logger = Logger.getLogger(CustomerManagementAction.class);

	private String reqId;
	private String custoId;

	public String getCustoId() {
		return custoId;
	}

	public void setCustoId(String custoId) {
		this.custoId = custoId;
	}

	public String getReqId() {
		return reqId;
	}

	public void setReqId(String reqId) {
		this.reqId = reqId;
	}

	public Customer getModel() {
		// TODO Auto-generated method stub
		return customer;
	}

	public Map<String, Object> getSessionMap() {
		return sessionMap;
	}

	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;

	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request = request;
	}

	/*
	 * 
	 * @see com.opensymphony.xwork2.ActionSupport#validate() validate method is
	 * to apply validations on checkMyRequestProgress and registerCustomers
	 * javascript is used for the validations
	 */
	@Override
	public void validate() {

		String actionStr = ActionContext.getContext().getName();
		
		logger.info("ACTION Hit is: "+actionStr);
		logger.info("Entering Validate Method");

		if (actionStr.equalsIgnoreCase("checkCustomerRoomRequestStatusByREQID")) {
			if (getReqId() == null || getReqId().trim().equals("")) {
				logger.error("Validate Method Field Error: "+"reqid");
				addFieldError("reqid", "Request-id is required");
			}
		} else if (actionStr.equalsIgnoreCase("checkCustomerRequestsByCUSTID")) {

			if (getCustoId() == null || getCustoId().trim().equals("")) {
				logger.error("Validate Method Field Error: "+"custoId");
				addFieldError("custoId", "Customer-id is required");
				
			}
		} else if (actionStr.equalsIgnoreCase("registerNewCustomer")) {
			registerCustomerValidation();
		}
		else if (actionStr.equalsIgnoreCase("updateCustomerProfile"))
		{
			updateCustomerProfileValidation();
		}
	}

	private void registerCustomerValidation() {
		
		String namePattern = "^[A-Za-z]+$";
		String emailPattern = "^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,3})+$";
		//Pattern nameRegex = Pattern.compile(namePattern);
		
		if (getModel().getName() == null
				|| getModel().getName().trim().equals("")) {
			logger.error("Validate Method Field Error: "+"name");
			addFieldError("name", "Name is required");
			
		}
		
		else if (!Pattern.matches(namePattern, getModel().getName())) {
			logger.error("Validate Method Field Error: "+"name");
			addFieldError("name", "Name can contain only alphabets..");
	
		}
		
		else if (getModel().getAge() == 0) {
			logger.error("Validate Method Field Error: "+"age");
			addFieldError("age", "Age is required");
			
		}
		else if (getModel().getGender() == null
				|| getModel().getGender().trim().equals("")) {
			logger.error("Validate Method Field Error: "+"gender");
			addFieldError("gender", "Gender is required");
	
		}
		else if (getModel().getLocation() == null
				|| getModel().getLocation().trim().equals("")) {
			logger.error("Validate Method Field Error: "+"location");
			addFieldError("location", "Location is required");
			
		}
		
		else if (!Pattern.matches(namePattern, getModel().getLocation())) {
			
			logger.error("Validate Method Field Error: "+"location");
			addFieldError("location", "City can contain only alphabets..");
			
		}
		else if (getModel().getEmailId() == null
				|| getModel().getEmailId().trim().equals("")) {
			
			logger.error("Validate Method Field Error: "+"emailId");
			addFieldError("emailId", "EmailId is required");
		
		}
		else if (!Pattern.matches(emailPattern, getModel().getEmailId())) {
			
			logger.error("Validate Method Field Error: "+"emailId");
			addFieldError("emailId", "Invalid Email ID..");
			
		}
		else if (getModel().getContactNumber() == null
				|| getModel().getContactNumber().trim().equals("")) {
			logger.error("Validate Method Field Error: "+"contactNumber");
			addFieldError("contactNumber", "Contact Number is required");
			
		}
	}
	
	
	private void updateCustomerProfileValidation() {
		if (getModel().getName() == null
				|| getModel().getName().trim().equals("")) {
			logger.error("Validate Method Field Error: "+"name");
			addActionError("Name is required");
			
		}
		if (getModel().getAge() == 0) {
			logger.error("Validate Method Field Error: "+"age");
			addActionError("Age is required");
		
		}
		if (getModel().getLocation() == null
				|| getModel().getLocation().trim().equals("")) {
			logger.error("Validate Method Field Error: "+"location");
			addActionError( "Location is required");
	
		}
		if (getModel().getEmailId() == null
				|| getModel().getEmailId().trim().equals("")) {
			logger.error("Validate Method Field Error: "+"emailId");
			addActionError("Email-Id is required");
			
		}
		if (getModel().getContactNumber() == null
				|| getModel().getContactNumber().trim().equals("")) {
			
			logger.error("Validate Method Field Error: "+"contactNumber");
			addActionError( "Contact Number is required");
	
		}
	}
	
	
	/*
	 * processHome method is an action class method that simply returns SUCCESS.
	 * It provides direct access to home.jsp page.
	 */
	public String processHome(){
		
		logger.info("INSIDE ACTION METHOD processHome()");
		
		logger.info("SUCCESS in processHome()");
		
		return SUCCESS;
		}
	
	
	/*
	 * processRegisterCustomer method is an action class method that simply returns SUCCESS.
	 * It provides direct access to registerCustomer.jsp page.
	 */
	public String processRegisterCustomer(){
		
	logger.info("INSIDE ACTION METHOD processRegisterCustomer()");
	
	logger.info("SUCCESS in processRegisterCustomer()");
	
	
	return SUCCESS;
	}
	
	
	
	/*
	 * processCustomerRegistration method is for customer registration It throws
	 * Exception
	 */
	public String processCustomerRegistration(){
		
		logger.info("INSIDE ACTION METHOD processCustomerRegistration()");
		
		Login loginCredentials = null;
		try {
			loginCredentials = (Login) delegate.registerCustomer(customer);
		} catch (CBException e) {
			
			logger.error("FAILURE in CBCustomerManagementDAOImpl registerCustomer() method : "+e.getCBMessage());
			sessionMap.put(ERROR_MSG_ATTRIBUTE, e.getCBMessage());
			e.printStackTrace();
		}

		if (loginCredentials != null) {
			status = SUCCESS;
			sessionMap.put("loginCredentials", loginCredentials);
			logger.info("SUCCESS in CBCustomerManagementDAOImpl registerCustomer() method");
		} 
		return status;
	}
	
	
	
	/*
	 * processPhotoGallery method is an action class method that simply returns SUCCESS.
	 * It provides direct access to photoGallery.jsp page.
	 */
	
	public String processPhotoGallery(){
		
		logger.info("INSIDE ACTION METHOD processPhotoGallery()");
		
		logger.info("SUCCESS in processPhotoGallery()");
		
		return SUCCESS;
	}
	
	
	
	/*
	 * processCustomerHome method is an action class method that simply returns SUCCESS.
	 * It provides direct access to customerHome.jsp page.
	 */
	public String processCustomerHome() {
		
		logger.info("INSIDE ACTION METHOD processCustomerHome()");
		
		logger.info("SUCCESS in processCustomerHome()");
		
		return SUCCESS;
	}
	
	
	/*
	 * processBookCustomerRoom method is an action class method that simply returns SUCCESS.
	 * It provides direct access to roomBooking.jsp page.
	 */
	public String processBookCustomerRoom() {
		
		logger.info("INSIDE ACTION METHOD processBookCustomerRoom()");
		
		logger.info("SUCCESS in processBookCustomerRoom()");
		
		return SUCCESS;
	}
	
	
	/*
	 * processCheckCustomerRoomRequest method is an action class method that only returns SUCCESS.
	 * It provides direct access to customerRoomRequest.jsp page.
	 */
	public String processCheckCustomerRoomRequestStatus() {
		logger.info("INSIDE ACTION METHOD processCheckCustomerRoomRequestStatus()");
		
		logger.info("SUCCESS in processCheckCustomerRoomRequestStatus()");
		
		return SUCCESS;
		
	}
	

	

	/*
	 * processViewCustomerProfile method is to view the customer profile It
	 * throws Exception
	 */

	public String processViewCustomerProfile(){
		
		logger.info("INSIDE ACTION METHOD processViewCustomerProfile()");

		String custId = (String) sessionMap.get("custId");
		Customer objCustomer = null;
		try {
			objCustomer = (Customer) delegate.getCustomerDetails(custId);
		} catch (CBException e) {
			
			logger.error("FAILURE in CBCustomerManagementDAOImpl getCustomerDetails() method : "+e.getCBMessage());
			sessionMap.put(ERROR_MSG_ATTRIBUTE, e.getCBMessage());
			e.printStackTrace();
		}
		if (objCustomer != null) {
			sessionMap.put("objCustomer", objCustomer);
			status = SUCCESS;
			logger.info("SUCCESS in CBCustomerManagementDAOImpl getCustomerDetails() method");
		}
		return status;
	}
	
	
	
	
	/*
	 * processEditCustomerProfile method is to edit the customer profile.
	 * It simply return SUCCESS to provide direct access to editCustomerProfile.jsp page! 
	 * It also throws Exception
	 */

	public String processEditCustomerProfile() {
		
		logger.info("INSIDE ACTION METHOD processEditCustomerProfile()");
		
		String custId = (String) sessionMap.get("custId");
		Customer objCustomer = null;
		try {
			objCustomer = (Customer) delegate.getCustomerDetails(custId);
		} catch (CBException e) {
			logger.error("FAILURE in CBCustomerManagementDAOImpl getCustomerDetails() method : "+e.getCBMessage());
			sessionMap.put(ERROR_MSG_ATTRIBUTE, e.getCBMessage());
			e.printStackTrace();
		}
		if (objCustomer != null) {
			sessionMap.put("objCustomer", objCustomer);
			status = SUCCESS;
			logger.info("SUCCESS in CBCustomerManagementDAOImpl getCustomerDetails() method");
		}
		return status;
	}
	
	

	/*
	 * processViewCustomerProfile method is to update the customer profile It
	 * throws Exception
	 */

	public String processUpdateCustomerProfile() {
		
		logger.info("INSIDE ACTION METHOD processUpdateCustomerProfile()");
		
		status=ERROR;
		try {
			
			Customer objCustomer=(Customer) sessionMap.get("objCustomer");
			String oldGender=objCustomer.getGender();

			String custId = (String) sessionMap.get("custId");
			Customer changedCustomer = (Customer) delegate
					.updateCustomerProfile(
							custId,
							new Customer(getRequest().getParameter("name"),
									Integer.parseInt(getRequest().getParameter(
											"age")), oldGender, getRequest()
											.getParameter("location"),
									getRequest().getParameter("emailId"),
									getRequest().getParameter("contactNumber")));
			sessionMap.remove("objCustomer");
			sessionMap.put("objCustomer", changedCustomer);

			if (changedCustomer==null)
			{
				throw new CBException("Error encountered while updating Profile.. Please try again later!");
			}
			else
			{
				status = SUCCESS;
				logger.info("SUCCESS in CBCustomerManagementDAOImpl updateCustomerProfile() method");
			}
		} catch (CBException e) {
			logger.error("FAILURE in CBCustomerManagementDAOImpl updateCustomerProfile() method : "+e.getCBMessage());
			sessionMap.put(ERROR_MSG_ATTRIBUTE,e.getCBMessage());
			status = ERROR;
		}
		return status;
	}

	/*
	 * processRequestStatus method is to process the request status It throws
	 * Exception
	 */
	

	public String processCustomerRoomRequestStatus(){
		
		logger.info("INSIDE ACTION METHOD processCustomerRoomRequestStatus()");
		try {
			String custId = (String) sessionMap.get("custId");
			RoomRequest details = delegate.getRequestDetails(reqId, custId);

			System.out.println("==========" + details);
			
			if(details==null)
				throw new CBException(NO_SUCH_ROOM_REQUEST);
			
			
			if (details != null) {
				sessionMap.put("details", details);
				status = SUCCESS;
				logger.info("SUCCESS in CBCustomerManagementDAOImpl getRequestDetails() method");
			}
		} catch (CBException e) {
			logger.error("FAILURE in CBCustomerManagementDAOImpl getRequestDetails() method : "+e.getCBMessage());
			sessionMap.put(ERROR_MSG_ATTRIBUTE, e.getCBMessage());
			status = FAILURE;
		}
		return status;
	}

	/*
	 * processRequestStatus method is to process the request status on the basis
	 * of customer id It throws CBException
	 */
	public String processCustomerRoomRequestStatusByCustomerId() {
		
		logger.info("INSIDE ACTION METHOD processCustomerRoomRequestStatusByCustomerId()");
		
		try {
			if (custoId.equalsIgnoreCase((String) sessionMap.get("custId"))) 
			{
				requestList = delegate.getRequestDetailsByCustomerId(custoId);

				if(requestList==null)
					throw new CBException("NO REQUESTS TO SHOW!");
				
				if (requestList != null) {
					sessionMap.put("allDetails", requestList);
					status = SUCCESS;
					logger.info("SUCCESS in CBCustomerManagementDAOImpl getRequestDetailsByCustomerId() method");
				} 
			} 
			else 
			{
				status = ERROR;
				throw new CBException("PLEASE ENTER ONLY YOUR CUSTOMER ID!");
			}

		} catch (CBException e) {
			logger.error("FAILURE in CBCustomerManagementDAOImpl getRequestDetailsByCustomerId() method : "+e.getCBMessage());
			sessionMap.put(ERROR_MSG_ATTRIBUTE, e.getCBMessage());
		}
		return status;
	}

	
	
	
	
	public String processCancelRoomRequest() {
		
		logger.info("INSIDE ACTION METHOD processCancelRoomRequest()");
		
		try {
			System.out.println(getSessionMap().get("req"));
			int flag = delegate.cancelRoomRequest((String) getSessionMap().get("req"));
			System.out.println(flag);
			if (flag > 0) {
				status = SUCCESS;
				logger.info("SUCCESS in CBCustomerManagementDAOImpl cancelRoomRequest() method");
			}
			else if(flag==0)
			{
				status = ERROR;
				throw new CBException("REQUEST HAS BEEN ALREADY APPROVED.. PLEASE CONTACT ADMINISTRATOR!");
			}
		} catch (CBException e) {
			logger.error("FAILURE in CBCustomerManagementDAOImpl cancelRoomRequest() method : "+e.getCBMessage());
			status = FAILURE;
			sessionMap.put(ERROR_MSG_ATTRIBUTE, e.getCBMessage());
		}
		return status;

	}

}
