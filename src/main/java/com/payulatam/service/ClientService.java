package com.payulatam.service;

import org.springframework.stereotype.Component;

import com.payulatam.model.Client;

/**
 * Interface representing the clients service
 * 
 * @author wilson.alzate
 *
 */
@Component
public interface ClientService {

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

}
