package com.payulatam.dao;

import org.springframework.stereotype.Component;

import com.payulatam.model.Client;

/**
 * Interface for the clients data access objects
 * 
 * @author wilson.alzate
 *
 */
@Component
public interface ClientDao {
	/**
	 * Method used to save or update a client object
	 * 
	 * @param client
	 *            The client to persist
	 * @throws Exception
	 *             Any exception thrown saving or updating the object
	 */
	public void saveOrUpdate(Client client) throws Exception;

	/**
	 * Method used to query all the clients in the repository
	 * 
	 * @return the list of all clients in the repository
	 * @throws Exception
	 */
	public Client[] getClientsList() throws Exception;

	/**
	 * Method used to delete a client from the repository
	 * 
	 * @param client
	 *            The client to remove
	 * @return a boolean with the result. true on success false otherwise.
	 * @throws Exception
	 */
	public boolean delete(Client client) throws Exception;
}
