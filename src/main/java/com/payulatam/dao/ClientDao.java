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
}
