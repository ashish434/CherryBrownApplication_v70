/**
 * 
 */
package com.tcs.ilp.tests;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.tcs.ilp.dao.CBLoginDetailsDAO;
import com.tcs.ilp.dao.CBLoginDetailsDAOImpl;
import com.tcs.ilp.domain.Login;

/**
 * @author HAMD
 *
 */
public class CBLoginDetailsDAOImplTest {
	/**
	 * @throws java.lang.Exception
	 */
	
	Session session=null;
	SessionFactory objSessionFactory=null;
	Login objAdminLogin=null,objCustomerLogin=null,objInvalidLogin=null,objEmptyLogin=null;
	CBLoginDetailsDAO objCBLoginDetailsDAO=null;
	
	@Before
	public void setUp() throws Exception {
		objSessionFactory = new Configuration().configure().buildSessionFactory();
		session = objSessionFactory.openSession();
		objCBLoginDetailsDAO=new CBLoginDetailsDAOImpl(objSessionFactory);
		objAdminLogin=new Login("admin","admin");
		objCustomerLogin=new Login("customer","customer");
		objInvalidLogin=new Login("TEST","TEST");
		objEmptyLogin=new Login("","");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		objAdminLogin=null;
		objCustomerLogin=null;
		objInvalidLogin=null;
		objCBLoginDetailsDAO=null;
		session=null;
		objSessionFactory=null;
	}

	/**
	 * Test method for {@link com.tcs.ilp.dao.CBLoginDetailsDAOImpl#checkLoginDetails(com.tcs.ilp.domain.Login)}.
	 */
	
	@Test
	public void testAdminLoginDetails() throws Exception {
		assertEquals("admin", objCBLoginDetailsDAO.checkLoginDetails(objAdminLogin));
		}
	
	@Test
	public void testCustomerLoginDetails() throws Exception {
		assertSame("customer", objCBLoginDetailsDAO.checkLoginDetails(objCustomerLogin));
		}
	
	@Test
	public void testInvalidLoginDetails() throws Exception {
		assertNull(objCBLoginDetailsDAO.checkLoginDetails(objInvalidLogin));
		}
	
	@Test
	public void testEmptyLoginDetails() throws Exception {
		assertTrue(objCBLoginDetailsDAO.checkLoginDetails(objEmptyLogin)==null);
		}
	
}