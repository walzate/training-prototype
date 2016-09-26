package com.payulatam.dao.impl;

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

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.payulatam.dao.ClientDao#saveOrUpdate(com.payulatam.model.Client)
	 */
	public void saveOrUpdate(Client client) throws Exception {
		gigaSpace.write(client);
	}
}
