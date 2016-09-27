package com.payulatam.dao;

import org.springframework.stereotype.Component;

import com.payulatam.model.Account;

/**
 * Interface for the accounts data access objects
 * 
 * @author wilson.alzate
 *
 */
@Component
public interface AccountDao {
	/**
	 * Method used to save or update an account object
	 * 
	 * @param account
	 *            The account to persist
	 * @throws Exception
	 *             Any exception thrown saving or updating the object
	 */
	public void saveOrUpdate(Account account) throws Exception;

	/**
	 * Method used to query all the accounts in the repository
	 * 
	 * @return the list of all accounts in the repository
	 * @throws Exception
	 */
	public Account[] getAccountsList() throws Exception;

	/**
	 * Method used to delete an account from the repository
	 * 
	 * @param account
	 *            The account to remove
	 * @return a boolean with the result. true on success false otherwise.
	 * @throws Exception
	 */
	public boolean delete(Account account) throws Exception;
	
	/**
	 * Method used to query an account given its id
	 * 
	 * @param id
	 *            The unique identifier of the account
	 * @return The Account instance
	 * @throws Exception
	 */
	public Account getById(String id) throws Exception;
}
