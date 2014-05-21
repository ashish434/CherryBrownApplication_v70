/**
 * 
 */
package com.tcs.ilp.tests;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.tcs.ilp.dao.CBCustomerManagementDAO;
import com.tcs.ilp.dao.CBCustomerManagementDAOImpl;
import com.tcs.ilp.dao.CBRoomManagementDAO;
import com.tcs.ilp.dao.CBRoomManagementDAOImpl;
import com.tcs.ilp.domain.Customer;
import com.tcs.ilp.domain.Login;
import com.tcs.ilp.domain.RoomRequest;

/**
 * @author HAMD
 *
 */
public class CBCustomerManagementDAOImplTest {
	/**
	 * @throws java.lang.Exception
	 */
	
	Session session=null;
	SessionFactory objSessionFactory=null;
	Customer objValidCustomer=null,objCustomer2=null,objInvalidCustomer=null,newCustomerDetails=null;
	CBCustomerManagementDAO objCBCustomerManagementDAO=null;
	CBRoomManagementDAO objCBRoomManagementDAO=null;
	Login objValidCustomerLogin=null;
	RoomRequest objRoomRequest=null;
	List<RoomRequest> listOfRoomRequests=null;
	String tempRequestId=null;
	
	@Before
	public void setUp() throws Exception {
		objSessionFactory = new Configuration().configure().buildSessionFactory();
		session = objSessionFactory.openSession();
		objCBCustomerManagementDAO=new CBCustomerManagementDAOImpl(objSessionFactory);
		objCBRoomManagementDAO=new CBRoomManagementDAOImpl(objSessionFactory);
		
		objValidCustomer=new Customer("testName",24,"male","Y City","abc@xyz.com","9900110022");
		objInvalidCustomer=new Customer("",0,"Male","Location","","");
		objCustomer2=new Customer();
		
		objValidCustomerLogin=(Login) objCBCustomerManagementDAO.registerCustomer(objValidCustomer);
		objRoomRequest=new RoomRequest("REQ787","CUST787","2014-03-01","2014-04-01",1,"SINGLE","AC","stnd","PENDING");
		
		listOfRoomRequests=objCBCustomerManagementDAO.getRequestDetailsByCustomerId("CUST123");
		
		tempRequestId=objCBRoomManagementDAO.addRoomRequest(objRoomRequest);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		objCBCustomerManagementDAO.cancelRoomRequestSpecifictoCustomer("CUST787");
	//	objCBCustomerManagementDAO.cancelCustomer(objValidCustomerLogin);
		
		objValidCustomer=null;
		objInvalidCustomer=null;
		objCustomer2=null;
		newCustomerDetails=null;
		objValidCustomerLogin=null;
		listOfRoomRequests=null;
		objRoomRequest=null;
		objCBCustomerManagementDAO=null;
		objCBRoomManagementDAO=null;
		tempRequestId=null;
		session=null;
		objSessionFactory=null;
	}

	/**
	 * Test method for {@link com.tcs.ilp.dao.CBCustomerManagementDAOImpl#getCustomerDetails(com.tcs.ilp.domain.Customer)}.
	 */
	
	@Test
	public void testRegisterCustomer() throws Exception {		
		assertEquals(new Login(objValidCustomerLogin.getUserid(),objValidCustomerLogin.getPassword(),"customer"), objValidCustomerLogin);
		}

	@Test
	public void testInvalidRegisterCustomer() throws Exception {
		assertNull(objCBCustomerManagementDAO.registerCustomer(objInvalidCustomer));
		}
	
	@Test
	public void testGetCustomerDetails() throws Exception {
		assertEquals(objValidCustomer, objCBCustomerManagementDAO.getCustomerDetails(objValidCustomerLogin.getUserid()));
		}

	@Test
	public void testInvalidGetCustomerDetails() throws Exception {
		assertTrue(objCBCustomerManagementDAO.getCustomerDetails("CUST799")==null);
		}
	
	@Test
	public void testUpdateCustomerProfile() throws Exception {
		newCustomerDetails=new Customer("NewTest",25,"female","India","abc@xcv.com","9911307760");
		assertEquals(newCustomerDetails, objCBCustomerManagementDAO.updateCustomerProfile(objValidCustomerLogin.getUserid(),newCustomerDetails ));
		}
	
	@Test
	public void testInvalidUpdateCustomerProfile() throws Exception {
		newCustomerDetails=new Customer("",25,"female","","","9911307760");
		assertNull(objCBCustomerManagementDAO.updateCustomerProfile(objValidCustomerLogin.getUserid(),newCustomerDetails ));
		}
	
	@Test
	public void testNullUpdateCustomerProfile() throws Exception {
		assertSame(null,objCBCustomerManagementDAO.updateCustomerProfile(objValidCustomerLogin.getUserid(),null));
		}
	
	
	@Test
	public void testGetRoomRequestDetails() throws Exception {
		objRoomRequest=objCBCustomerManagementDAO.getRequestDetails("REQ2", "CUST123");
		assertEquals(objRoomRequest, objCBCustomerManagementDAO.getRequestDetails("REQ2", "CUST123"));
		}

	@Test
	public void testInvalidGetRoomRequestDetails() throws Exception {
		assertNull(objCBCustomerManagementDAO.getRequestDetails("REQ5", "CUST123"));
		}
	
	
	@Test
	public void testGetRoomRequestDetailsByCustomerId() throws Exception {
		assertEquals(listOfRoomRequests, (List<RoomRequest>)objCBCustomerManagementDAO.getRequestDetailsByCustomerId("CUST123"));
		}

	@Test
	public void testInvalidGetRoomRequestDetailsByCustomerId() throws Exception {
		assertFalse(!(objCBCustomerManagementDAO.getRequestDetailsByCustomerId("CUST090")==null));
		}
	
	@Test
	public void testCancelRoomRequest() throws Exception {
		assertTrue(new Integer(objCBCustomerManagementDAO.cancelRoomRequest(tempRequestId))>new Integer(0) );
		}

	@Test
	public void testInvalidCancelRoomRequest() throws Exception {
		assertTrue(objCBCustomerManagementDAO.cancelRoomRequest("REQ505")==0);
	}
}