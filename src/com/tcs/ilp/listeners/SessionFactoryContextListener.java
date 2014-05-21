package com.tcs.ilp.listeners;

import static com.tcs.ilp.util.CBApplicationConstants.ERROR_MSG_ATTRIBUTE;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tcs.ilp.dao.CBRoomBookingServicesDAOFactory;
import com.tcs.ilp.exception.CBException;

/**
 * Application Lifecycle Listener implementation class
 * SessionFactoryContextListener
 * 
 */
public class SessionFactoryContextListener implements ServletContextListener {

	/**
	 * Default constructor.
	 */
	public SessionFactoryContextListener() {

	}

	/**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		SessionFactory objSessionFactory = new Configuration().configure()
				.buildSessionFactory();
		
		System.out.println("&&&&&&^^^^%%%%%%%%%%%%%"+objSessionFactory);
		if(objSessionFactory==null)
			try {
				throw new CBException("DATABASE PROBLEM!");
			} catch (CBException e) {
			//	logger.error("FAILURE in CBLoginDetailsDAOImpl checkLoginDetails() method : "+e.getCBMessage());
				sce.getServletContext().setAttribute(ERROR_MSG_ATTRIBUTE, e.getCBMessage());
				e.printStackTrace();
			}
		sce.getServletContext().setAttribute("sessionFactory",
				objSessionFactory);
		CBRoomBookingServicesDAOFactory.getInstance().setSessionFactory(
				objSessionFactory);
	}

	/**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent arg0) {

	}

}
