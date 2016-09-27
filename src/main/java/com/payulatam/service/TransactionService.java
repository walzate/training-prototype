package com.payulatam.service;

import org.springframework.stereotype.Component;

import com.payulatam.model.Transaction;

/**
 * Interface representing the transactions service
 * 
 * @author wilson.alzate
 *
 */
@Component
public interface TransactionService {

	/**
	 * Method used to save or update a transaction object
	 * 
	 * @param transaction
	 *            The transaction to persist
	 * @throws Exception
	 *             Any exception thrown saving or updating the object
	 */
	public void saveOrUpdate(Transaction transaction) throws Exception;
	
	/**
	 * Method used to query all the transactions in the repository
	 * 
	 * @return the list of all transactions in the repository
	 * @throws Exception
	 */
	public Transaction[] getTransactionsList() throws Exception;
	
	/**
	 * Method used to delete a transaction from the repository
	 * 
	 * @param transaction
	 *            The transaction to remove
	 * @return a boolean with the result. true on success false otherwise.
	 * @throws Exception
	 */
	public boolean delete(Transaction transaction) throws Exception;
	
	/**
	 * Method used to query a transaction given its id
	 * @param id The unique identifier of the transaction
	 * @return The Transaction instance
	 * @throws Exception
	 */
	public Transaction getById(String id) throws Exception;

}
