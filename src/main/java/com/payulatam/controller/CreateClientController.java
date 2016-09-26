package com.payulatam.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Label;
import org.zkoss.zul.api.Textbox;

import com.payulatam.locator.ServiceLocator;
import com.payulatam.model.Client;
import com.payulatam.service.ClientService;

/**
 * Controller for the create client view
 * 
 * @author wilson.alzate
 *
 */
@Controller
public class CreateClientController extends GenericForwardComposer {

	/**
	 * Serialization id
	 */
	private static final long serialVersionUID = 2116314619237122525L;

	/**
	 * Reference to the name text box
	 */
	private Textbox clientNameTextBox;
	/**
	 * Reference to the client address text box
	 */
	private Textbox clientAddressTextBox;
	/**
	 * Label for the messages resulting from the operation
	 */
	private Label messageLabel;
	/**
	 * Reference to the client telephone text box
	 */
	private Textbox clientTelephoneTextBox;
	/**
	 * Client service instance
	 */
	private ClientService clientService;

	/**
	 * Logging manager
	 */
	final Logger LOGGER = Logger.getLogger(CreateClientController.class);

	/**
	 * Method used to listen the onclick event from the create client button. It
	 * is used to create a new client and persist it.
	 */
	public void onClick$createClientButton() {

		Client client = buildClient();

		clientService = ServiceLocator.getClientService();

		try {
			clientService.saveOrUpdate(client);
		} catch (Exception e) {
			messageLabel.setValue("Error al crear el cliente");
			LOGGER.error(e);
		}
		Executions.sendRedirect("queryClients.zul");
		messageLabel.setValue("Cliente creado exitosamente.");

	}

	/**
	 * Method used as onclick listener for the cancel button
	 */
	public void onClick$cancelCreateClientButton() {
		Executions.sendRedirect("clientsManagement.zul");
	}

	/**
	 * Method used to create the client object using the view components values
	 * 
	 * @return A new client object with the values entered by the user.
	 */
	private Client buildClient() {
		Client client = new Client();
		client.setName(clientNameTextBox.getValue());
		client.setAddress(clientAddressTextBox.getValue());
		client.setTelephone(clientTelephoneTextBox.getValue());
		return client;
	}

}
