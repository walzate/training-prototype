package com.payulatam.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.payulatam.dao.AccountDao;
import com.payulatam.model.Account;
import com.payulatam.service.AccountService;

/**
 * Implementation of the account service interface
 * 
 * @author wilson.alzate
 *
 */
@Component
public class AccountServiceImpl implements AccountService {

	/**
	 * Instance of the data access object for accounts
	 */
	@Autowired
	AccountDao accountDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.payulatam.service.AccountService#saveOrUpdate(com.payulatam.model.
	 * Account)
	 */
	public void saveOrUpdate(Account account) throws Exception {
		accountDao.saveOrUpdate(account);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.payulatam.service.AccountService#getAccountsList()
	 */
	public Account[] getAccountsList() throws Exception {
		return accountDao.getAccountsList();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.payulatam.service.AccountService#delete(com.payulatam.model.Account)
	 */
	public boolean delete(Account account) throws Exception {
		return accountDao.delete(account);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.payulatam.service.AccountService#getById(java.lang.String)
	 */
	public Account getById(String id) throws Exception {
		return accountDao.getById(id);
	}

}
