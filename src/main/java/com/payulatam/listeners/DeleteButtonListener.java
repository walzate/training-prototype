package com.payulatam.listeners;

import org.apache.log4j.Logger;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;

import com.payulatam.controller.client.CreateClientController;
import com.payulatam.locator.ServiceLocator;
import com.payulatam.model.Client;
import com.payulatam.service.ClientService;

/**
 * Event listener for the delete button for clients
 * 
 * @author wilson.alzate
 *
 */
public class DeleteButtonListener implements EventListener {

	/**
	 * The client instance to delete
	 */
	private Client client;

	/**
	 * Logging manager
	 */
	final Logger LOGGER = Logger.getLogger(DeleteButtonListener.class);

	/**
	 * Class constructor
	 * 
	 * @param client
	 *            The client needed for the event listener
	 */
	public DeleteButtonListener(Client client) {
		super();
		this.client = client;
	}

	/**
	 * Method used to execute after the event has been fired
	 */
	public void onEvent(Event arg0) throws Exception {
		LOGGER.debug("DeleteButtonListener OnEvent " + client.toString());
		ClientService clientService = ServiceLocator.getClientService();
		clientService.delete(client);
		Executions.sendRedirect("queryClients.zul");
	}

	/**
	 * Method used to return the client to delete
	 * 
	 * @return The instance of the client to delete
	 */
	public Client getClient() {
		return client;
	}

	/**
	 * Method used to set the client to delete instance
	 * 
	 * @param client
	 *            A new client instance to delete
	 */
	public void setClient(Client client) {
		this.client = client;
	}

}
