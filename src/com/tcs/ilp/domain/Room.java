package com.tcs.ilp.domain;

import java.io.Serializable;

/**
 * @author H55 - Group 1 The Domain class encapsulating a Room
 */
public class Room implements Serializable {

	private static final long serialVersionUID = 1L;

	private int roomNumber;
	private int floorNumber;
	private String roomStatus;
	private String roomType;
	private String acFacility;
	private String category;
	private String requestId;

	public Room(int roomNumber, int floorNumber, String roomStatus,
			String roomType, String acFacility, String category,
			String requestId) {

		this.roomNumber = roomNumber;
		this.floorNumber = floorNumber;
		this.roomStatus = roomStatus;
		this.roomType = roomType;
		this.acFacility = acFacility;
		this.category = category;
		this.requestId = requestId;

	}

	public Room() {
		// TODO Auto-generated constructor stub
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public int getFloorNumber() {
		return floorNumber;
	}

	public void setFloorNumber(int floorNumber) {
		this.floorNumber = floorNumber;
	}

	public String getRoomStatus() {
		return roomStatus;
	}

	public void setRoomStatus(String roomStatus) {
		this.roomStatus = roomStatus;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public String getAcFacility() {
		return acFacility;
	}

	public void setAcFacility(String acFacility) {
		this.acFacility = acFacility;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public String getRequestId() {
		return requestId;
	}

	public String toString() {
		return "Room No:" + roomNumber + ", Floor No:" + floorNumber
				+ ", Room Status:" + roomStatus + ", Room Type: " + roomType
				+ ", AC:" + acFacility + ", Category:" + category
				+ "Request ID:" + requestId;
	}
	
	public boolean equals(Object o)
	{
		Room objRoom=(Room)o;
		
		if(this.getRoomNumber()==objRoom.getRoomNumber() && this.getRequestId().equals(objRoom.getRequestId())
				&& this.getCategory().equals(objRoom.getCategory()) && this.getRoomType().equals(objRoom.getRoomType())
				&& this.getAcFacility().equals(objRoom.getAcFacility()) && this.getFloorNumber() == objRoom.getFloorNumber()
				&& this.getRoomStatus().equals(objRoom.getRoomStatus()))
				
				return true;
		else
			return false;
	}
}
