package com.tcs.ilp.dao;

import static com.tcs.ilp.util.CBApplicationConstants.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;










//import com.tcs.ilp.cbapp.exception.CBException;
import com.tcs.ilp.domain.Room;
import com.tcs.ilp.domain.RoomRequest;
import com.tcs.ilp.exception.*;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * @author H55 - Group 1 The DAO implementation class for Room Management
 */
public class CBRoomManagementDAOImpl implements CBRoomManagementDAO {

	private SessionFactory sessionFactory;

	public CBRoomManagementDAOImpl() {
	}

	public CBRoomManagementDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/*
	 * addRoomRequest method is to add request for room and has roomRequest as
	 * argument It returns status(string)
	 */
	public String addRoomRequest(RoomRequest roomRequest) throws CBException {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		String requestId = null;

		try {
			tx = session.beginTransaction();
			Query query = session.createSQLQuery(GENERATE_REQUEST_ID);
			List<Object> result = query.list();
			if(result.isEmpty()){
				return requestId;
			}
			
			if(roomRequest.getACRequired().isEmpty()||roomRequest.getCheckInDate().isEmpty()||
					roomRequest.getCheckOutDate().isEmpty()||roomRequest.getCustomerId().isEmpty()||
					roomRequest.getNumberOfRoomsRequired()==0||roomRequest.getRequestedRoomType().isEmpty()||
					roomRequest.getRequestStatus().isEmpty()||roomRequest.getRequestedCategory().isEmpty())
			{
				return requestId;
			}
			
			Iterator<Object> resultIterator = result.iterator();
			while (resultIterator.hasNext()) {
				requestId = resultIterator.next().toString();
			}
			roomRequest.setRequestId(requestId);
			session.save(roomRequest);
			tx.commit();

		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
			throw new CBException(ROOM_BOOKING_ERROR);
		} finally {
			session.close();
		}
		return requestId;
	}

	/*
	 * updateRoomRequestStatus is to update the status of the room request It
	 * throws CBException
	 */
	private void updateRoomRequestStatus(String reqId) throws CBException {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Query query = session.createQuery(HQL_UPDATE_ROOM_REQUEST_STATUS);
			query.setParameter(REQUESTSTATUS, APPROVED);
			query.setParameter(REQUESTID, reqId);
			int result = query.executeUpdate();
			tx.commit();

		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
			throw new CBException(ERROR_UPDATE_ROOM_REQUEST_STATUS);
		} finally {
			session.close();
		}
		// return result;
	}

	/*
	 * getRoomAllotted method is to get the alloted room It throws CBException
	 * It returns allotedRoom
	 */

	private List<Room> getRoomAllotted(String reqId, RoomRequest objRoomRequest) throws CBException {
		List<Room> listOfRooms=new ArrayList<Room>();
		boolean found = false;
		
		if(objRoomRequest.getNumberOfRoomsRequired()>countOfVacantRooms(objRoomRequest, fetchAllRoomDetails()))
			throw new CBException(INSUFFICIENT_ROOMS);
		
		for(int i=0; i<objRoomRequest.getNumberOfRoomsRequired();i++)
		{		
			found = allocateRoomsToRequests(reqId, objRoomRequest, listOfRooms,found);	 
		}
			
		if (found) {
				updateRoomRequestStatus(reqId);
		}
	return listOfRooms;
	}

	private boolean allocateRoomsToRequests(String reqId,RoomRequest objRoomRequest, List<Room> listOfRooms, boolean found)
			throws CBException {
		Room allottedRoom=null;
		int roomNum=0;
		for (Room room : fetchAllRoomDetails()) {
			if (room.getRoomStatus().equalsIgnoreCase(VACANT)
				&& room.getRequestId().equalsIgnoreCase(EMPTY) && room.getAcFacility().equalsIgnoreCase(objRoomRequest.getACRequired())
				&& room.getCategory().equalsIgnoreCase(objRoomRequest.getRequestedCategory()) && room.getRoomType().equalsIgnoreCase(objRoomRequest.getRequestedRoomType())) 
			{
				roomNum = room.getRoomNumber();
				allottedRoom = (Room) room;
				found = true; 
				updateRoomStatus(roomNum, reqId);
				listOfRooms.add(allottedRoom);			
			}
			else continue;
		}
		return found;
	}

	private int countOfVacantRooms(RoomRequest objRoomRequest,List<Room> listOfRoom) {
		int countOfVacantRooms=0;
		for(Room room:listOfRoom)
		{
			if(room.getRoomStatus().equalsIgnoreCase(VACANT) && room.getRequestId().equalsIgnoreCase(EMPTY) && room.getAcFacility().equalsIgnoreCase(objRoomRequest.getACRequired())
					&& room.getCategory().equalsIgnoreCase(objRoomRequest.getRequestedCategory()) && room.getRoomType().equalsIgnoreCase(objRoomRequest.getRequestedRoomType()))
				countOfVacantRooms++;
		}
		return countOfVacantRooms;
	}

	/*
	 * updateRoomStatus is to update the status of the room It uses roomNum and
	 * reqId as arguments. It throws CBException
	 */

	private void updateRoomStatus(int roomNum, String reqId) throws CBException {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Query query = session.createQuery(HQL_UPDATE_ROOM_STATUS);
			query.setParameter(ROOMSTATUS, ALLOTTED);
			query.setParameter(REQUESTID, reqId);
			query.setParameter(ROOMNUMBER, roomNum);
			int result = query.executeUpdate();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
			throw new CBException(ERROR_UPDATE_ROOM_STATUS);
		} finally {
			session.close();
		}
	}

	public List<RoomRequest> fetchAllRoomRequestDetails() throws CBException {
		List<RoomRequest> listOfRoomRequests = null;
		Session session = sessionFactory.openSession();
		try {
			Query query = session.createQuery(HQL_FETCH_ALL_ROOM_REQUESTS);

			listOfRoomRequests = query.list();
			if (listOfRoomRequests.isEmpty()){
				return null;
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfRoomRequests;
	}

	/*
	 * viewAllRoomDetails method is to display all the room details It uses List
	 * to display the data It returns the lostofrooms
	 */
	public List<Room> fetchAllRoomDetails() throws CBException {
		List<Room> listOfRooms = null;
		Session session = sessionFactory.openSession();
		try {
			Query query = session.createQuery(HQL_FETCH_ALL_ROOM_DETAILS);
			listOfRooms = query.list();
			if (listOfRooms.isEmpty()){
				return null;
			}
		} catch (HibernateException e) {

			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfRooms;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.tcs.ilp.dao.CBRoomManagementDAO#checkAndAllotRoomRequest(java.lang
	 * .String) checkAndAllotRoomRequest method is to check and allot room to
	 * the customers. It throws CBException and returns room
	 */

	public List<Room> checkAndAllotRoomRequest(String reqId) throws CBException {
		List<Room> listOfRooms=new ArrayList<Room>();
		
		boolean found=false;
		
		List<RoomRequest> listRoomRequest = (List<RoomRequest>) fetchAllRoomRequestDetails();

		for (RoomRequest objRoomRequest : listRoomRequest) {
			if (objRoomRequest.getRequestId().equals(reqId)) {
				found=true;
				if (objRoomRequest.getRequestStatus()
						.equalsIgnoreCase(APPROVED)) {
					List<Room> listRoom = fetchAllRoomDetails();
					for (Room room : listRoom) {
						if (room.getRequestId().equals(reqId)) {
							listOfRooms.add(room);
						}
					}
					break;
				} else if (objRoomRequest.getRequestStatus().equalsIgnoreCase(PENDING)) {

					listOfRooms = getRoomAllotted(reqId,objRoomRequest);

					break;
				}
			}
		}
		if(found==false)
			listOfRooms=null;
		
		return listOfRooms;
	}
}