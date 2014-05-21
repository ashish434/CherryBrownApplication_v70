package com.tcs.ilp.struts;

import static com.tcs.ilp.util.CBApplicationConstants.*;


import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.tcs.ilp.delegate.CBBussinessDelegate;
import com.tcs.ilp.domain.Login;
import com.tcs.ilp.exception.CBException;


/**
 * @author H55 - Group 1 The action class for login management
 */
public class LoginManagementAction extends ActionSupport implements
		ModelDriven<Login>, ServletRequestAware, SessionAware {

	HttpServletRequest request = null;
	Map<String,Object> sessionMap = null;
	Login login = new Login();
	String status = null;
	private static final long serialVersionUID = -4297464878507428391L;
	static Logger logger = Logger.getLogger(LoginManagementAction.class);
	

	public void validate() {

		String actionStr = ActionContext.getContext().getName();
		
		logger.info("ACTION Hit is: "+actionStr);
		logger.info("Entering Validate Method");
		

		if (actionStr.equalsIgnoreCase(LOGIN)) 
		{
			if (getModel().getUserid() == null||getModel().getUserid().isEmpty() || getModel().getUserid().trim().equals(""))
			{
				
				logger.error("Validate Method Field Error: "+"userid");
				addFieldError("userid", "UserID is required ..");
				
			}
				
			if (getModel().getPassword()== null ||getModel().getPassword().isEmpty()|| getModel().getPassword().trim().equals("")) 
			{	
				logger.error("Validate Method Field Error: "+"password");
				addFieldError("password", "Password is required ..");
			}
		}
	}

	/*
	 * processLogin method is to process the login details entered by the
	 * customer It throws CBException in case any exception occurs
	 */
	public String processLogin() {
		
		logger.info("INSIDE ACTION METHOD processLogin()");
		
		logger.info("LOGGED IN: "+login.getUserid());
		
		HttpSession session = request.getSession();
		CBBussinessDelegate delegate = new CBBussinessDelegate();

		Login login = (Login) getModel();
		System.out.println(login.getUserid() + " " + login.getPassword());
		String getRole=null;
		try {
			
			logger.info("RETRIEVING USER ROLE . .");
			getRole = delegate.checkLoginDetails(login);
			System.out.println("---->>>>>>" + getRole);
			
			if(getRole==null)
			{
				logger.error("ROLE RETRIEVED IS NULL");
				throw new CBException(LOGIN_ERROR);
			}

			if (getRole.equals(ADMIN_ROLE)) {

				logger.info("ROLE:"+ADMIN_ROLE);
				session.setAttribute(ROLE, ADMIN_ROLE);
				session.setAttribute(USERID_ATTRIBUTE, login.getUserid());
				status = ADMIN_ROLE;
			} else if (getRole.equals(CLERK_ROLE)) {
				logger.info("ROLE:"+CLERK_ROLE);
				session.setAttribute(ROLE,CLERK_ROLE);
				session.setAttribute(USERID_ATTRIBUTE, login.getUserid());

			} else if (getRole.equals(CUSTOMER_ROLE)) {

				logger.info("ROLE:"+CUSTOMER_ROLE);
				session.setAttribute(ROLE,CUSTOMER_ROLE);
				session.setAttribute(USERID_ATTRIBUTE, login.getUserid());
				status = CUSTOMER_ROLE;
			} 
		} catch (CBException e) {
			logger.error("FAILURE in CBLoginDetailsDAOImpl checkLoginDetails() method : "+e.getCBMessage());
			sessionMap.put(ERROR_MSG_ATTRIBUTE, e.getCBMessage());
			e.printStackTrace();
			status=ERROR;
		}
		return status;
	}

	/*
	 * processLogout method is process logout when customer presses logout,the
	 * session is closed It throws CBException
	 */
	public String processLogout() throws CBException {
		
		logger.info("INSIDE ACTION METHOD processLogout()");
		
		ServletContext context = ServletActionContext.getServletContext();
		HttpSession session = request.getSession();

		if (session != null) {
			context.setAttribute(LOGOUT, session.getAttribute(USERID_ATTRIBUTE));
			logger.info("SUCCESSFULLY LOGGED OUT: "+session.getAttribute(USERID_ATTRIBUTE));
			session.invalidate();
			return SUCCESS;
		} else
			logger.error("LOGOUT ERROR: "+session.getAttribute(USERID_ATTRIBUTE));
			return ERROR;
	}

	public Map<String, Object> getSession() {
		return sessionMap;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public HttpServletRequest getServletRequest() {
		return request;
	}

	public Login getModel() {
		return login;
	}

	public void setModel(Login login) {
		this.login = login;
	}

	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}
}