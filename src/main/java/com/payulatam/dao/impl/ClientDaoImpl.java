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
}
