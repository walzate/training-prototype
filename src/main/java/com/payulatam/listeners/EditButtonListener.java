package com.payulatam.listeners;

import org.apache.log4j.Logger;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;

import com.payulatam.model.Client;

public class EditButtonListener implements EventListener {

	private Client client;

	/**
	 * Logging manager
	 */
	final Logger LOGGER = Logger.getLogger(EditButtonListener.class);

	public EditButtonListener(Client client) {
		super();
		this.client = client;
	}

	public void onEvent(Event arg0) throws Exception {
		LOGGER.debug("EditButtonListener OnEvent " + client.toString());
		Executions.sendRedirect("editClient.zul?clientId=" + client.getId());
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

}
