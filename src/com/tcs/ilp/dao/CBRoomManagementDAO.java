package com.tcs.ilp.dao;

import java.util.List;

import com.tcs.ilp.domain.Room;
import com.tcs.ilp.domain.RoomRequest;
import com.tcs.ilp.exception.CBException;

/**
 * @author H55 - Group 1 The interface declaring basic methods to be implemented
 *         by DAO of Room Management
 */
public interface CBRoomManagementDAO {
	public String addRoomRequest(RoomRequest request) throws CBException;

	public List<Room> fetchAllRoomDetails() throws CBException;

	public List<RoomRequest> fetchAllRoomRequestDetails() throws CBException;

	public List<Room> checkAndAllotRoomRequest(String reqId) throws CBException;

}
