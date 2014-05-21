package com.tcs.ilp.dao;

import org.hibernate.SessionFactory;

/**
 * @author H55 - Group 1 The Factory class providing a singleton instance
 */
public class CBRoomBookingServicesDAOFactory {
	private static final CBRoomBookingServicesDAOFactory instance = new CBRoomBookingServicesDAOFactory();
	private SessionFactory sessionFactory;

	private CBRoomBookingServicesDAOFactory() {

	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static CBRoomBookingServicesDAOFactory getInstance() {
		return instance;
	}

	public CBCustomerManagementDAO getCBCustomerManagementDAO() {
		CBCustomerManagementDAO objCBCustomerManagementDAO = new CBCustomerManagementDAOImpl(
				getSessionFactory());
		return objCBCustomerManagementDAO;
	}

	public CBRoomManagementDAO getCBRoomManagementDAO() {
		CBRoomManagementDAO objCBRoomManagementDAO = new CBRoomManagementDAOImpl(
				getSessionFactory());
		return objCBRoomManagementDAO;
	}

	public CBLoginDetailsDAO getCBLoginDetailsDAO() {
		CBLoginDetailsDAO objCBLoginDetailsDAO = new CBLoginDetailsDAOImpl(
				getSessionFactory());
		return objCBLoginDetailsDAO;
	}
}