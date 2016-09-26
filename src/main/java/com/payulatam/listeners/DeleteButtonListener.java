package com.payulatam.listeners;

import org.apache.log4j.Logger;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;

import com.payulatam.controller.ClientController;
import com.payulatam.locator.ServiceLocator;
import com.payulatam.model.Client;
import com.payulatam.service.ClientService;

public class DeleteButtonListener implements EventListener {

	private Client client;
	
	/**
	 * Logging manager
	 */
	final Logger LOGGER = Logger.getLogger(ClientController.class);
	
	public DeleteButtonListener(Client client) {
		super();
		this.client = client;
	}

	public void onEvent(Event arg0) throws Exception {
		LOGGER.debug("DeleteButtonListener OnEvent " + client.toString());
		ClientService clientService = ServiceLocator.getClientService();
		clientService.delete(client);
		Executions.sendRedirect("queryClients.zul");
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}	

}
