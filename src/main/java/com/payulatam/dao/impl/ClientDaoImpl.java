package com.payulatam.dao.impl;

import org.apache.log4j.Logger;
import org.openspaces.core.GigaSpace;
import org.openspaces.core.context.GigaSpaceContext;
import org.springframework.stereotype.Component;

import com.payulatam.dao.ClientDao;
import com.payulatam.model.Client;

@Component
public class ClientDaoImpl implements ClientDao {

	/**
	 * Reference to the Gigaspaces space
	 */
	@GigaSpaceContext
	private GigaSpace gigaSpace;

	/**
	 * Logging manager
	 */
	final Logger LOGGER = Logger.getLogger(ClientDaoImpl.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.payulatam.dao.ClientDao#saveOrUpdate(com.payulatam.model.Client)
	 */
	public void saveOrUpdate(Client client) throws Exception {
		gigaSpace.write(client);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.payulatam.dao.ClientDao#getClientsList()
	 */
	public Client[] getClientsList() throws Exception {
		Client[] results = gigaSpace.readMultiple(new Client());
		LOGGER.debug("Result: " + java.util.Arrays.toString(results));
		return results;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.payulatam.dao.ClientDao#delete(com.payulatam.model.Client)
	 */
	public boolean delete(Client client) throws Exception {
		LOGGER.debug("ClientDaoImpl: delete " + client.toString());
		boolean result = false;
		try {
			gigaSpace.take(client);
			result = true;
		} catch (Exception e) {
			throw e;
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.payulatam.dao.ClientDao#getById(java.lang.String)
	 */
	public Client getById(String id) throws Exception {
		Client result = gigaSpace.readById(Client.class, id);
		return result;
	}
}
