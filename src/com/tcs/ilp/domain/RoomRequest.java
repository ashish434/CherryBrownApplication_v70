package com.tcs.ilp.domain;

import java.io.Serializable;

/**
 * @author H55 - Group 1 The Domain class encapsulating a Room Request
 */
public class RoomRequest implements Serializable {

	private static final long serialVersionUID = 1L;
	private String requestId;
	private String customerId;
	private Room room;
	private String checkInDate;
	private String checkOutDate;
	private int numberOfRoomsRequired;
	private String requestedRoomType;
	private String ACRequired;
	private String requestedCategory;
	private String requestStatus;

	public RoomRequest() {

	}

	public RoomRequest(String customerId, String checkInDate,
			String checkOutDate, int numberOfRoomsRequired,
			String requestedRoomType, String ACRequired,
			String requestedCategory) {
		this.customerId = customerId;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.numberOfRoomsRequired = numberOfRoomsRequired;
		this.requestedRoomType = requestedRoomType;
		this.ACRequired = ACRequired;
		this.requestedCategory = requestedCategory;
	}

	public RoomRequest(String requestId, String customerId, String checkInDate,
			String checkOutDate, int numberOfRoomsRequired,
			String requestedRoomType, String ACRequired,
			String requestedCategory, String requestStatus) {
		this.requestId = requestId;
		this.customerId = customerId;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.numberOfRoomsRequired = numberOfRoomsRequired;
		this.requestedRoomType = requestedRoomType;
		this.ACRequired = ACRequired;
		this.requestedCategory = requestedCategory;
		this.requestStatus = requestStatus;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate(String checkInDate) {
		this.checkInDate = checkInDate;
	}

	public String getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(String checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	public int getNumberOfRoomsRequired() {
		return numberOfRoomsRequired;
	}

	public void setNumberOfRoomsRequired(int numberOfRoomsRequired) {
		this.numberOfRoomsRequired = numberOfRoomsRequired;
	}

	public String getRequestedRoomType() {
		return requestedRoomType;
	}

	public void setRequestedRoomType(String requestedRoomType) {
		this.requestedRoomType = requestedRoomType;
	}

	public String getACRequired() {
		return ACRequired;
	}

	public void setACRequired(String ACRequired) {
		this.ACRequired = ACRequired;
	}

	public String getRequestedCategory() {
		return requestedCategory;
	}

	public void setRequestedCategory(String requestedCategory) {
		this.requestedCategory = requestedCategory;
	}

	public String getRequestStatus() {
		return requestStatus;
	}

	public void setRequestStatus(String requestStatus) {
		this.requestStatus = requestStatus;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public Room getRoom() {
		return room;
	}

	public String toString() {
		return "Request Id:" + requestId + ", Check-in Date:" + checkInDate
				+ " ,Check-out Date:" + checkOutDate + ", No of Room Required:"
				+ numberOfRoomsRequired + ", Requested Room Type:"
				+ requestedRoomType + ", ACRequired: " + ACRequired
				+ ", RequestedCategory:" + requestedCategory
				+ ", RequestStatus:" + requestStatus;
	}

	public boolean equals(Object o)
	{
		RoomRequest objRoomRequest=(RoomRequest)o;
		
		if(objRoomRequest.getRequestId().equals(this.getRequestId())
				&& this.getCustomerId().equals(objRoomRequest.getCustomerId()) && this.getCheckInDate().equals(objRoomRequest.getCheckInDate()) 
				&& this.getCheckOutDate().equals(objRoomRequest.getCheckOutDate()) && this.getRequestedRoomType().equals(objRoomRequest.getRequestedRoomType())
				&& this.getRequestedCategory().equals(objRoomRequest.getRequestedCategory()) && this.getNumberOfRoomsRequired()==objRoomRequest.getNumberOfRoomsRequired()
				&& this.getACRequired().equals(objRoomRequest.getACRequired()) && this.getRequestStatus().equals(objRoomRequest.getRequestStatus()))
					return true;
		else
			return false;
	}
}
