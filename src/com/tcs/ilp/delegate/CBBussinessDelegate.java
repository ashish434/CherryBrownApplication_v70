package com.tcs.ilp.delegate;

import java.util.List;

import com.tcs.ilp.dao.CBRoomBookingServicesDAOFactory;

import com.tcs.ilp.domain.Customer;
import com.tcs.ilp.domain.Login;
import com.tcs.ilp.domain.Room;
import com.tcs.ilp.domain.RoomRequest;
import com.tcs.ilp.exception.CBException;

/**
 * @author H55 - Group 1 The Business Delegate implementation class for the
 *         application
 */
public class CBBussinessDelegate {

	public String checkLoginDetails(Login login) throws CBException {
		return CBRoomBookingServicesDAOFactory.getInstance()
				.getCBLoginDetailsDAO().checkLoginDetails(login);
	}

	public Object registerCustomer(Customer customer) throws CBException {
		return CBRoomBookingServicesDAOFactory.getInstance()
				.getCBCustomerManagementDAO().registerCustomer(customer);
	}

	public Customer getCustomerDetails(String custId) throws CBException {
		return CBRoomBookingServicesDAOFactory.getInstance()
				.getCBCustomerManagementDAO().getCustomerDetails(custId);
	}

	public Customer updateCustomerProfile(String customerId, Customer customer) throws CBException {
		return CBRoomBookingServicesDAOFactory.getInstance()
				.getCBCustomerManagementDAO()
				.updateCustomerProfile(customerId, customer);
	}

	public String addRoomRequest(RoomRequest request) throws CBException {
		return CBRoomBookingServicesDAOFactory.getInstance()
				.getCBRoomManagementDAO().addRoomRequest(request);
	}

	public RoomRequest getRequestDetails(String reqId, String custId)
			throws CBException {
		return CBRoomBookingServicesDAOFactory.getInstance()
				.getCBCustomerManagementDAO().getRequestDetails(reqId, custId);

	}

	public List<RoomRequest> getRequestDetailsByCustomerId(String customerId)
			throws CBException {
		return CBRoomBookingServicesDAOFactory.getInstance()
				.getCBCustomerManagementDAO()
				.getRequestDetailsByCustomerId(customerId);

	}

	public int cancelRoomRequest(String reqId) throws CBException {
		// TODO Auto-generated method stub
		return CBRoomBookingServicesDAOFactory.getInstance()
				.getCBCustomerManagementDAO().cancelRoomRequest(reqId);
	}

	public List<Room> fetchAllRoomDetails() throws CBException {
		return CBRoomBookingServicesDAOFactory.getInstance()
				.getCBRoomManagementDAO().fetchAllRoomDetails();
	}

	public List<RoomRequest> getAllRoomRequestDetails() throws CBException {
		return CBRoomBookingServicesDAOFactory.getInstance()
				.getCBRoomManagementDAO().fetchAllRoomRequestDetails();
	}

	public List<Room> getRoomAllotted(String reqId) throws CBException {
		return CBRoomBookingServicesDAOFactory.getInstance()
				.getCBRoomManagementDAO().checkAndAllotRoomRequest(reqId);
	}

}
