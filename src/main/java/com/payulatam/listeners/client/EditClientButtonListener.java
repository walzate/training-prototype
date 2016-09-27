package com.payulatam.listeners.client;

import org.apache.log4j.Logger;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;

import com.payulatam.model.Client;

/**
 * Event listener for the edit button for clients
 * 
 * @author wilson.alzate
 *
 */
public class EditClientButtonListener implements EventListener {

	/**
	 * The client instance to edit
	 */
	private Client client;

	/**
	 * Logging manager
	 */
	final Logger LOGGER = Logger.getLogger(EditClientButtonListener.class);

	/**
	 * Class constructor
	 * 
	 * @param client
	 *            The client needed for the event listener
	 */
	public EditClientButtonListener(Client client) {
		super();
		this.client = client;
	}

	/**
	 * Method used to execute after the event has been fired
	 */
	public void onEvent(Event arg0) throws Exception {
		LOGGER.debug("EditButtonListener OnEvent " + client.toString());
		Executions.sendRedirect("editClient.zul?clientId=" + client.getId());
	}

	/**
	 * Method used to return the client to edit
	 * 
	 * @return The instance of the client to edit
	 */
	public Client getClient() {
		return client;
	}

	/**
	 * Method used to set the client to edit instance
	 * 
	 * @param client
	 *            A new client instance to edit
	 */
	public void setClient(Client client) {
		this.client = client;
	}

}
