package com.tcs.ilp.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.tcs.ilp.domain.Customer;
import com.tcs.ilp.domain.Login;
import com.tcs.ilp.domain.RoomRequest;
import com.tcs.ilp.exception.CBException;

import static com.tcs.ilp.util.CBApplicationConstants.*;

/*
 * The DAO implementation class for customer management
 * It implements CBCustomerManagementDAO
 * 
 */
public class CBCustomerManagementDAOImpl implements CBCustomerManagementDAO {

	private SessionFactory sessionFactory;
	

	public CBCustomerManagementDAOImpl() {
	}

	/*
	 * CBCustomerManagementDAOImpl constructor uses sessionFactory as argument
	 */
	public CBCustomerManagementDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.tcs.ilp.dao.CBCustomerManagementDAO#registerCustomer(com.tcs.ilp.
	 * domain.Customer) registerCustomer method is for customer registration It
	 * takes customer as the argument and returns status(int) It throws
	 * CBException
	 */
	public Object registerCustomer(Customer customer) throws CBException {
		
		
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		String custId = null;
		Login login = null;
		try {
			
			if(customer.getAge()==0||customer.getContactNumber().isEmpty()||customer.getName().isEmpty()
					||customer.getGender().isEmpty()||customer.getEmailId().isEmpty())
			{
				 return login; 
			}
			
			tx = session.beginTransaction();	
			Query query = session.createSQLQuery(GENERATE_CUSTOMER_ID);
			List<String> result = query.list();
			custId = result.get(0);
			if(result.isEmpty()||result==null||custId==null){
				throw new CBException(ERROR_REGISTRATION);
			}
			
			customer.setCustomerId(custId);
			customer.setPassword(generateCustomerPassword(customer.getName()));
			login = new Login(customer.getCustomerId(), customer.getPassword(),CUSTOMER_ROLE);
			session.save(login);
			session.save(customer);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
			throw new CBException(ERROR_REGISTRATION);
		} finally {
			session.close();
		}
		return login;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.tcs.ilp.dao.CBCustomerManagementDAO#getCustDetails(java.lang.String)
	 * getCustomerDetails method is to get the details of the customer It takes
	 * custId as argument and throws CBException if any exception occurs
	 */

	public Customer getCustomerDetails(String custId) throws CBException {
		Customer customer = null;
		// SessionFactory factory = new
		// Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		System.out.println(")))))))))))"+custId);
		try {
			tx = session.beginTransaction();
			customer = (Customer) session.get(Customer.class, custId);
			tx.commit();

		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
			throw new CBException(PROFILE_VIEW_ERROR);
		} finally {
			session.close();
		}
		return customer;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.tcs.ilp.dao.CBCustomerManagementDAO#updateCustomerProfile(java.lang
	 * .String, com.tcs.ilp.domain.Customer) updateCustomerProfile method is to
	 * update the customer profile It takes customer Id and returns customer
	 * object It throws CBException in case if any exception occurs
	 */

	public Customer updateCustomerProfile(String custId, Customer newCustomer) throws CBException {

		Session session = sessionFactory.openSession();
		Transaction tx = null;
		Customer customer = null;
		try {
		
			if(newCustomer==null)
				return customer;
			
			if(newCustomer.getAge()==0||newCustomer.getContactNumber().isEmpty()||newCustomer.getName().isEmpty()
					||newCustomer.getGender().isEmpty()||newCustomer.getEmailId().isEmpty())
			{
				return customer; 
			}
			
			tx = session.beginTransaction();
			
			Customer oldCustomer = (Customer) session.get(Customer.class,custId);
			oldCustomer.setName(newCustomer.getName());
			oldCustomer.setAge(newCustomer.getAge());
			oldCustomer.setGender(newCustomer.getGender());
			oldCustomer.setLocation(newCustomer.getLocation());
			oldCustomer.setEmailId(newCustomer.getEmailId());
			oldCustomer.setContactNumber(newCustomer.getContactNumber());

			session.update(oldCustomer);

			customer = (Customer) session.get(Customer.class, custId);
			tx.commit();

		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
			throw new CBException(PROFILE_UPDATE_ERROR);
		} finally {
			session.close();
		}
		return customer;
	}

	/*
	 * generateCustomerPassword method is to generate password for the customer
	 * while registration It takes customerName as the argument and returns
	 * string that is customer password
	 */
	private String generateCustomerPassword(String customerName)
			throws CBException {
		
		if(customerName.length()<4)
			throw new CBException("Could not generate Password: Insufficient length of Name");
		String customerPassword = customerName.substring(0, 4);
		String postappend = "0";
		int vowels = 0;
		for (int i = 0; i < customerName.length(); i++) {
			if (customerName.charAt(i) == 'a' || customerName.charAt(i) == 'A'
					|| customerName.charAt(i) == 'e'
					|| customerName.charAt(i) == 'E'
					|| customerName.charAt(i) == 'i'
					|| customerName.charAt(i) == 'I'
					|| customerName.charAt(i) == 'o'
					|| customerName.charAt(i) == 'O'
					|| customerName.charAt(i) == 'u'
					|| customerName.charAt(i) == 'U')
				vowels++;
		}
		if (vowels < 10)
			postappend += vowels;
		customerPassword += postappend;

		return customerPassword;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.tcs.ilp.dao.CBCustomerManagementDAO#getrequestDetails(java.lang.String
	 * ) getrequestDetails method is to retrieve the request details of the
	 * customer It takes request Id as parameter and throws CBException
	 */
	public RoomRequest getRequestDetails(String reqId, String custId)
			throws CBException {

		Session session = sessionFactory.openSession();
		Transaction tx = null;
		RoomRequest objRoomRequest = null;
		try {
			tx = session.beginTransaction();
			Query query = session.createQuery(HQL_GET_REQUEST_DETAILS);
			query.setParameter(REQUESTID, reqId);
			query.setParameter(CUSTOMERID, custId);
			if ((boolean) query.list().isEmpty()){
				return objRoomRequest;
			}
				
			else
				objRoomRequest = (RoomRequest) query.list().get(0);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
			throw new CBException(ERROR_FETCH_ROOM_REQUEST);
		} finally {
			session.close();
		}
		return objRoomRequest;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.tcs.ilp.dao.CBCustomerManagementDAO#getrequestDetailsByCustomerId
	 * (java.lang.String) getrequestDetailsByCustomerId method is to retrieve
	 * all the request details made by customer It throws CBException
	 */
	public List<RoomRequest> getRequestDetailsByCustomerId(String customerId)
			throws CBException {

		Session session = sessionFactory.openSession();
		Transaction tx = null;
		List<RoomRequest> listRoomRequest = null;
		try {
			tx = session.beginTransaction();
			Query query = session
					.createQuery(HQL_GET_REQUEST_DETAILS_BY_CUSTOMER_ID);
			query.setParameter(CUSTOMERID,customerId);
			listRoomRequest = query.list();
			if(listRoomRequest.isEmpty()){
				listRoomRequest=null;
				return listRoomRequest;
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
			throw new CBException(ERROR_FETCH_ROOM_REQUEST);
		} finally {
			session.close();
		}
		return listRoomRequest;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.tcs.ilp.dao.CBCustomerManagementDAO#cancelRoomRequest(java.lang.String
	 * ) cancelRoomRequest method is to cancel the room request made by customer
	 * It throws CBException in case if any exception occurs
	 */
	public int cancelRoomRequest(String reqId) throws CBException {

		Session session = sessionFactory.openSession();
		Transaction tx = null;
		int flag = 0;
		try {
			tx = session.beginTransaction();
			Query query = session.createQuery(HQL_CANCEL_REQUEST);
			query.setParameter(REQUESTID, reqId);
			flag = query.executeUpdate();
			
			if(flag<1)
				//throw new CBException("REQUEST HAS BEEN ALREADY APPROVED.. PLEASE CONTACT ADMINISTRATOR!");
				return flag;
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
			throw new CBException(ROOMREQUEST_CANCEL_ERROR);
		}
		catch(NullPointerException ne){
			throw new CBException(ROOMREQUEST_CANCEL_ERROR);
		}
		finally {
			session.close();
		}

		System.out.println(flag);
		return flag;
	}
	
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.tcs.ilp.dao.CBCustomerManagementDAO#cancelRoomRequest(java.lang.String
	 * ) cancelRoomRequest method is to cancel the room request made by customer
	 * It throws CBException in case if any exception occurs
	 */
	public int cancelRoomRequestSpecifictoCustomer(String custId) throws CBException {

		Session session = sessionFactory.openSession();
		Transaction tx = null;
		int flag = 0;
		try {
			tx = session.beginTransaction();
			Query query = session.createQuery(HQL_CANCEL_REQUEST_SPECIFIC_TO_CUSTOMER);
			query.setParameter(CUSTOMERID, custId);
			flag = query.executeUpdate();
			
			if(flag==0)
				//throw new CBException("REQUEST HAS BEEN ALREADY APPROVED.. PLEASE CONTACT ADMINISTRATOR!");
				return 0;
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
			throw new CBException(ROOMREQUEST_CANCEL_ERROR);
		}
		catch(NullPointerException ne){
			throw new CBException(ROOMREQUEST_CANCEL_ERROR);
		}
		finally {
			session.close();
		}

		System.out.println(flag);
		return flag;
	}

	public int cancelCustomer(Login objValidCustomerLogin) throws CBException {
//		Session session = sessionFactory.openSession();
//		Transaction tx = null;
//		int flag1 = 0, flag2=0;
//		try {
//			tx = session.beginTransaction();
//			flag1 = cancelCustomerLoginDetails(objValidCustomerLogin, session);
//			
//			
//			flag2 = cancelCustomerDetails(objValidCustomerLogin, session);
//			
//			
//			if(flag1<1 || flag2<1)
//				//throw new CBException("REQUEST HAS BEEN ALREADY APPROVED.. PLEASE CONTACT ADMINISTRATOR!");
//				return 0;
//			tx.commit();
//		} catch (HibernateException e) {
//			if (tx != null)
//				tx.rollback();
//			e.printStackTrace();
//			throw new CBException(ROOMREQUEST_CANCEL_ERROR);
//		}
//		catch(NullPointerException ne){
//			throw new CBException(ROOMREQUEST_CANCEL_ERROR);
//		}
//		finally {
//			session.close();
//		}
//		return flag1;
		return 0;
	}
//
	private int cancelCustomerDetails(Login objValidCustomerLogin,
			Session session) throws CBException {
//		int flag;
//		Customer objCustomer= getCustomerDetails(objValidCustomerLogin.getUserid());
//		Query query = session.createQuery(HQL_DELETE_CUSTOMER_FROM_CUSTOMER_TABLE);
//		query.setParameter("NAME",objCustomer.getCustomerId());
//		query.setParameter("PASSWORD",objCustomer.getPassword());
//		flag = query.executeUpdate();
//		return flag;
//	}
//
//	private int cancelCustomerLoginDetails(Login objValidCustomerLogin,
//			Session session) {
//		int flag;
//		Query query = session.createQuery(HQL_DELETE_CUSTOMER_FROM_LOGIN_TABLE);
//		query.setParameter(USERID, objValidCustomerLogin.getUserid());
//		query.setParameter(PASSWORD, objValidCustomerLogin.getPassword());
//		flag = query.executeUpdate();
//		return flag;
		return 0;
	}
	
}