package com.payulatam.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.payulatam.dao.TransactionDao;
import com.payulatam.model.Transaction;
import com.payulatam.service.TransactionService;

/**
 * Implementation of the transaction service interface
 * 
 * @author wilson.alzate
 *
 */
@Component
public class TransactionServiceImpl implements TransactionService {

	/**
	 * Instance of the data access object for transactions
	 */
	@Autowired
	TransactionDao transactionDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.payulatam.service.TransactionService#saveOrUpdate(com.payulatam.model.
	 * Transaction)
	 */
	public void saveOrUpdate(Transaction transaction) throws Exception {
		transactionDao.saveOrUpdate(transaction);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.payulatam.service.TransactionService#getTransactionsList()
	 */
	public Transaction[] getTransactionsList() throws Exception {
		return transactionDao.getTransactionsList();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.payulatam.service.TransactionService#delete(com.payulatam.model.Transaction)
	 */
	public boolean delete(Transaction transaction) throws Exception {
		return transactionDao.delete(transaction);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.payulatam.service.TransactionService#getById(java.lang.String)
	 */
	public Transaction getById(String id) throws Exception {
		return transactionDao.getById(id);
	}

}
