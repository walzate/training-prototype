package com.payulatam.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.payulatam.dao.ClientDao;
import com.payulatam.model.Client;
import com.payulatam.service.ClientService;

/**
 * Implementation of the client service interface
 * 
 * @author wilson.alzate
 *
 */
@Component
public class ClientServiceImpl implements ClientService {

	/**
	 * Instance of the data access object for clients
	 */
	@Autowired
	ClientDao clientDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.payulatam.service.ClientService#saveOrUpdate(com.payulatam.model.
	 * Client)
	 */
	public void saveOrUpdate(Client client) throws Exception {
		clientDao.saveOrUpdate(client);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.payulatam.service.ClientService#getClientsList()
	 */
	public Client[] getClientsList() throws Exception {
		return clientDao.getClientsList();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.payulatam.service.ClientService#delete(com.payulatam.model.Client)
	 */
	public boolean delete(Client client) throws Exception {
		return clientDao.delete(client);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.payulatam.service.ClientService#getById(java.lang.String)
	 */
	public Client getById(String id) throws Exception {
		return clientDao.getById(id);
	}

}
