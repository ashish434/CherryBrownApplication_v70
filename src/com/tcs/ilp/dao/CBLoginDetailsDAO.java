package com.tcs.ilp.dao;

import com.tcs.ilp.domain.Login;
import com.tcs.ilp.exception.CBException;

/**
 * @author H55 - Group 1 The interface declaring basic methods to be implemented
 *         by DAO of Login Management
 */
public interface CBLoginDetailsDAO {
	public String checkLoginDetails(Login login) throws CBException;
}
