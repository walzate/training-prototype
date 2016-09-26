package com.payulatam.dao.impl;

import org.openspaces.core.GigaSpace;
import org.openspaces.core.GigaSpaceConfigurer;
import org.openspaces.core.space.EmbeddedSpaceConfigurer;
import org.springframework.stereotype.Component;

import com.payulatam.constants.PrototypeConstants;
import com.payulatam.dao.ClientDao;
import com.payulatam.model.Client;

@Component
public class ClientDaoImpl implements ClientDao {

	/**
	 * Reference to the Gigaspaces space
	 */
	private GigaSpace gigaSpace;
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.payulatam.dao.ClientDao#saveOrUpdate(com.payulatam.model.Client)
	 */
	public void saveOrUpdate(Client client) throws Exception {
		findSpace();
		gigaSpace.write(client);
	}
	
	public void findSpace() {
		EmbeddedSpaceConfigurer configurer = new EmbeddedSpaceConfigurer(PrototypeConstants.SPACE_NAME);
		// Create the Space
		gigaSpace = new GigaSpaceConfigurer(configurer).gigaSpace();
	}

}
