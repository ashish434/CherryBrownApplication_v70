package com.tcs.ilp.dao;

import java.util.List;

import com.tcs.ilp.domain.Customer;
import com.tcs.ilp.domain.Login;
import com.tcs.ilp.domain.RoomRequest;
import com.tcs.ilp.exception.CBException;

/**
 * @author H55 - Group 1 The interface declaring basic methods to be implemented
 *         by DAO of Customer Management
 */
public interface CBCustomerManagementDAO {

	public Object registerCustomer(Customer customer) throws CBException;

	public Customer getCustomerDetails(String custid) throws CBException;

	public Customer updateCustomerProfile(String customerId, Customer customer) throws CBException;

	public RoomRequest getRequestDetails(String reqId, String custId)
			throws CBException;

	public List<RoomRequest> getRequestDetailsByCustomerId(String customerId)
			throws CBException;

	public int cancelRoomRequest(String reqId) throws CBException;
	
	public int cancelRoomRequestSpecifictoCustomer(String custId) throws CBException ;

	public int cancelCustomer(Login objValidCustomerLogin) throws CBException;

}
