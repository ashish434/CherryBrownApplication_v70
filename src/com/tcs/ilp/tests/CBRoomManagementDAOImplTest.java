/**
 * 
 */
package com.tcs.ilp.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
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
import com.tcs.ilp.domain.Room;
import com.tcs.ilp.domain.RoomRequest;

/**
 * @author HAMD
 *
 */
public class CBRoomManagementDAOImplTest {

	/**
	 * @throws java.lang.Exception
	 */
	
	SessionFactory objSessionFactory=null;
	Session session=null;
	CBRoomManagementDAO objCBRoomManagementDAO=null;
	CBCustomerManagementDAO objCBCustomerManagementDAO=null;
	RoomRequest objRoomRequest=null;
	RoomRequest objInvalidRoomRequest=null;
	List<RoomRequest> listOfRoomRequests=null;
	List<Room> listOfRooms=null;
	List<Room> listOfRoomsForSpecificRequest=null;
	String tempRequestId=null;
	Room objRoom=null;
	
	@Before
	public void setUp() throws Exception {
		
		
		objSessionFactory = new Configuration().configure().buildSessionFactory();
		session = objSessionFactory.openSession();
	
		objCBRoomManagementDAO=new CBRoomManagementDAOImpl(objSessionFactory);
		
		objCBCustomerManagementDAO =new CBCustomerManagementDAOImpl(objSessionFactory);

		objRoomRequest=new RoomRequest("REQ787","CUST787","2014-03-01","2014-04-01",1,"SINGLE","AC","Standard","PENDING");
		
		objInvalidRoomRequest=new RoomRequest("CUST60", "2014-04-01", "2014-05-01", 0, "", "","");
		
		objRoom=new Room(999, 9, "ALLOTTED", "Single", "AC", "Standard","REQ2" );
		//objRoomRequest=new RoomRequest("REQ2","CUST444","2014-03-01","2014-04-01",1,"Single","AC","Standard","APPROVED");
		
		tempRequestId=objCBRoomManagementDAO.addRoomRequest(objRoomRequest);
		
		
		listOfRoomRequests=new ArrayList<RoomRequest>(objCBRoomManagementDAO.fetchAllRoomRequestDetails());
		
		listOfRooms=new ArrayList<Room>(objCBRoomManagementDAO.fetchAllRoomDetails());
		
		listOfRoomsForSpecificRequest=new ArrayList<Room>();
		
		listOfRoomsForSpecificRequest.add(objRoom);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		
		objCBCustomerManagementDAO.cancelRoomRequestSpecifictoCustomer("CUST787");
		listOfRoomRequests=null;
		listOfRooms=null;
		objRoomRequest=null;
		objInvalidRoomRequest=null;
		objRoom=null;
		tempRequestId=null;
		listOfRoomsForSpecificRequest=null;
		objCBRoomManagementDAO=null;
		session=null;
		objSessionFactory=null;
	}

	/**
	 * Test method for {@link com.tcs.ilp.dao.CBRoomManagementDAOImpl#addRoomRequest(com.tcs.ilp.domain.RoomRequest)}.
	 */
	@Test
	public void testAddRoomRequest() throws Exception {
		assertNotNull(objCBRoomManagementDAO.addRoomRequest(objRoomRequest));

	}


	@Test
	public void testInvalidAddRoomRequest() throws Exception {
		assertNull(objCBRoomManagementDAO.addRoomRequest(objInvalidRoomRequest));
	}
	
	/**
	 * Test method for {@link com.tcs.ilp.dao.CBRoomManagementDAOImpl#fetchAllRoomRequestDetails()}.
	 * @throws Exception 
	 */
	
	@Test
	public void testFetchAllRoomRequestDetails() throws Exception {
		assertEquals(listOfRoomRequests,(List<RoomRequest>)objCBRoomManagementDAO.fetchAllRoomRequestDetails());
	}

	@Test
	public void testInvalidFetchAllRoomRequestDetails() throws Exception {
		//assertNull(null,objCBRoomManagementDAO.fetchAllRoomRequestDetails());
		
		//this test will run successfully only when the ROOM_REQUEST table is empty, as for now
		//objCBRoomManagementDAO.fetchAllRoomRequestDetails() always returns list of requests!
		//our table always has data, so we presume it will never return Empty List!
		//We can test this case only when there are no Room Requests!
	}

	@Test
	public void testNotNullFetchAllRoomRequestDetails() throws Exception {
		assertTrue(!objCBRoomManagementDAO.fetchAllRoomRequestDetails().isEmpty());
	}
	
	
	/**
	 * Test method for {@link com.tcs.ilp.dao.CBRoomManagementDAOImpl#fetchAllRoomDetails()}.
	 * @throws Exception 
	 */
	@Test
	public void testFetchAllRoomDetails() throws Exception {
		assertEquals(listOfRooms,(List<Room>)objCBRoomManagementDAO.fetchAllRoomDetails());
	}
	
	@Test
	public void testInvalidFetchAllRoomDetails() throws Exception {
		//assertNull(null,objCBRoomManagementDAO.fetchAllRoomDetails());
		
		//this test will run successfully only when the ROOM_DETAILS table is empty, as for now
		//objCBRoomManagementDAO.fetchAllRoomDetails() always returns list of rooms!
		//our table always has pre-fed room details data, so we presume it will never return Empty List!
		//We can test this case only when there are no Room details!
	}
	
	@Test
	public void testNotNullFetchAllRoomDetails() throws Exception {
		assertTrue(!objCBRoomManagementDAO.fetchAllRoomDetails().isEmpty());
	}
	

	/**
	 * Test method for {@link com.tcs.ilp.dao.CBRoomManagementDAOImpl#checkAndAllotRoomRequest(java.lang.String)}.
	 */
	@Test
	public void testCheckAndAllotRoomRequest() throws Exception {
		assertEquals(listOfRoomsForSpecificRequest, (List<Room>)objCBRoomManagementDAO.checkAndAllotRoomRequest("REQ2") );
	}
	
	@Test
	public void testInvalidCheckAndAllotRoomRequest() throws Exception {
		assertFalse(objCBRoomManagementDAO.checkAndAllotRoomRequest("REQ987654")!=null);
	}

}
