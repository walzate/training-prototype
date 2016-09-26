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

}