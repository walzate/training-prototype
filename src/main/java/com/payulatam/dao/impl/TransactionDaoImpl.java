package com.payulatam.dao.impl;

import org.apache.log4j.Logger;
import org.openspaces.core.GigaSpace;
import org.openspaces.core.context.GigaSpaceContext;
import org.springframework.stereotype.Component;

import com.payulatam.dao.TransactionDao;
import com.payulatam.model.Transaction;

/**
 * Implementation foe the data access object for transactions
 * 
 * @author wilson.alzate
 *
 */
@Component
public class TransactionDaoImpl implements TransactionDao {

	/**
	 * Reference to the Gigaspaces space
	 */
	@GigaSpaceContext
	private GigaSpace gigaSpace;

	/**
	 * Logging manager
	 */
	final Logger LOGGER = Logger.getLogger(TransactionDaoImpl.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.payulatam.dao.TransactionDao#saveOrUpdate(com.payulatam.model.Transaction)
	 */
	public void saveOrUpdate(Transaction transaction) throws Exception {
		gigaSpace.write(transaction);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.payulatam.dao.TransactionDao#getTransactionsList()
	 */
	public Transaction[] getTransactionsList() throws Exception {
		Transaction[] results = gigaSpace.readMultiple(new Transaction());
		LOGGER.debug("Result: " + java.util.Arrays.toString(results));
		return results;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.payulatam.dao.TransactionDao#delete(com.payulatam.model.Transaction)
	 */
	public boolean delete(Transaction transaction) throws Exception {
		LOGGER.debug("TransactionDaoImpl: delete " + transaction.toString());
		boolean result = false;
		try {
			gigaSpace.take(transaction);
			result = true;
		} catch (Exception e) {
			throw e;
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.payulatam.dao.TransactionDao#getById(java.lang.String)
	 */
	public Transaction getById(String id) throws Exception {
		Transaction result = gigaSpace.readById(Transaction.class, id);
		return result;
	}
}
