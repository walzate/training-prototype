package com.payulatam.dao.impl;

import org.apache.log4j.Logger;
import org.openspaces.core.GigaSpace;
import org.openspaces.core.context.GigaSpaceContext;
import org.springframework.stereotype.Component;

import com.payulatam.dao.AccountDao;
import com.payulatam.model.Account;

/**
 * Implementation foe the data access object for accounts
 * 
 * @author wilson.alzate
 *
 */
@Component
public class AccountDaoImpl implements AccountDao {

	/**
	 * Reference to the Gigaspaces space
	 */
	@GigaSpaceContext
	private GigaSpace gigaSpace;

	/**
	 * Logging manager
	 */
	final Logger LOGGER = Logger.getLogger(AccountDaoImpl.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.payulatam.dao.AccountDao#saveOrUpdate(com.payulatam.model.Account)
	 */
	public void saveOrUpdate(Account account) throws Exception {
		gigaSpace.write(account);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.payulatam.dao.AccountDao#getAccountsList()
	 */
	public Account[] getAccountsList() throws Exception {
		Account[] results = gigaSpace.readMultiple(new Account());
		LOGGER.debug("Result: " + java.util.Arrays.toString(results));
		return results;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.payulatam.dao.AccountDao#delete(com.payulatam.model.Account)
	 */
	public boolean delete(Account account) throws Exception {
		LOGGER.debug("AccountDaoImpl: delete " + account.toString());
		boolean result = false;
		try {
			gigaSpace.take(account);
			result = true;
		} catch (Exception e) {
			throw e;
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.payulatam.dao.AccountDao#getById(java.lang.String)
	 */
	public Account getById(String id) throws Exception {
		Account result = gigaSpace.readById(Account.class, id);
		return result;
	}
}
