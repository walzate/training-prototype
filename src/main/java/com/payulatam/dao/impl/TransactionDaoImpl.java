package com.payulatam.dao.impl;

import java.util.Random;

import org.apache.log4j.Logger;
import org.openspaces.core.GigaSpace;
import org.openspaces.core.context.GigaSpaceContext;
import org.springframework.stereotype.Component;

import com.payulatam.dao.TransactionDao;
import com.payulatam.model.Transaction;
import com.payulatam.pollingcontainer.TransactionRequest;
import com.payulatam.pollingcontainer.TransactionResult;

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
	 * @see com.payulatam.dao.TransactionDao#saveOrUpdate(com.payulatam.model.
	 * Transaction)
	 */
	public void saveOrUpdate(Transaction transaction) throws Exception {
		// http://docs.gigaspaces.com/sbp/master-worker-pattern.html#example-2-designated-workers
		LOGGER.debug("TransactionDaoImpl.saveOrUpdate - Begin");
		TransactionRequest request = new TransactionRequest();

		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(1000);

		request.setTransaction(transaction);
		request.setJobID(randomInt);

		LOGGER.debug("Writing to the pooling container the transaction request: " + request.toString());
		gigaSpace.write(request);
	}

	/**
	 * Method used to take the polling result from the space
	 * 
	 * @author wilson.alzate
	 * @version 28/09/2016 5:39:09 p. m.
	 */
	public void removeResultFromSpace(Integer randomInt) {
		TransactionResult resultTemplate = new TransactionResult();
		resultTemplate.setJobID(randomInt);
		resultLoop: while (true) {
			TransactionResult[] results = gigaSpace.readMultiple(new TransactionResult());
			LOGGER.debug("TransactionDaoImpl.saveOrUpdate - found transaction results " + results.toString());
			LOGGER.debug("TransactionDaoImpl.saveOrUpdate - found transaction results.length " + results.length);

			TransactionResult result = gigaSpace.take(resultTemplate, 1000);
			if (result != null) {
				LOGGER.debug("TransactionDaoImpl.saveOrUpdate - result " + result.toString());
				break resultLoop;
			} else {
				LOGGER.debug(
						"TransactionDaoImpl.saveOrUpdate - result not found template: " + resultTemplate.toString());
				break resultLoop;
			}
		}
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
	 * @see
	 * com.payulatam.dao.TransactionDao#delete(com.payulatam.model.Transaction)
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
