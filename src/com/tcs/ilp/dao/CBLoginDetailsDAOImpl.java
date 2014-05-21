package com.tcs.ilp.dao;

import java.util.List;

import com.tcs.ilp.domain.Login;
import com.tcs.ilp.exception.CBException;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import static com.tcs.ilp.util.CBApplicationConstants.*;

/**
 * @author H55 - Group 1 The DAO implementation class for Login Management
 */
public class CBLoginDetailsDAOImpl implements CBLoginDetailsDAO {

	private SessionFactory sessionFactory;

	public CBLoginDetailsDAOImpl() {
	}

	public CBLoginDetailsDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.tcs.ilp.dao.CBLoginDetailsDAO#checkLoginDetails(com.tcs.ilp.domain
	 * .Login) checkLoginDetails method is to check and verify the login details
	 * It throws CBException
	 */
	public String checkLoginDetails(Login login) throws CBException {
		
		
		
		Session session = getSessionFactory().openSession();
		String role = null;
		Transaction tx=null;
		try
		{ 	
			tx=session.beginTransaction();
			Query query=session.createQuery(HQL_FETCH_LOGIN_ROLE);
			query.setParameter(USERID, login.getUserid());
			query.setParameter(PASSWORD, login.getPassword());
		
			List listOfRole=query.list();
			
			
			if(listOfRole.isEmpty())
				return role;
//				throw new CBException(LOGIN_ERROR);
			if (listOfRole.get(0).toString().equalsIgnoreCase(ADMIN_ROLE)) {
				role = ADMIN_ROLE;
			} else if (listOfRole.get(0).toString().equalsIgnoreCase(CUSTOMER_ROLE)) {
				role = CUSTOMER_ROLE;
			} else if (listOfRole.get(0).toString().equalsIgnoreCase(CLERK_ROLE)) {
				role = CLERK_ROLE;
			}
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return role;
	}
		
}
