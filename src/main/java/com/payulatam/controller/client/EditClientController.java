package com.payulatam.controller.client;

import org.apache.log4j.Logger;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Label;
import org.zkoss.zul.api.Textbox;

import com.payulatam.locator.ServiceLocator;
import com.payulatam.model.Client;
import com.payulatam.service.ClientService;

/**
 * Controller for the edit clients page
 * 
 * @author wilson.alzate
 *
 */
public class EditClientController extends GenericForwardComposer {

	/**
	 * Serialization id
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Logging manager
	 */
	final Logger LOGGER = Logger.getLogger(EditClientController.class);

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
	 * Reference to the client to be edited
	 */
	private Client clientToEdit;

	/**
	 * Initialization method
	 */
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);

		String clientId = Executions.getCurrent().getParameter("clientId");

		ClientService clientService = ServiceLocator.getClientService();

		clientToEdit = clientService.getById(clientId);

		LOGGER.debug("EditClientController:doAfterCompose " + clientToEdit);

		if (clientToEdit != null) {
			clientNameTextBox.setValue(clientToEdit.getName());
			clientAddressTextBox.setValue(clientToEdit.getAddress());
			clientTelephoneTextBox.setValue(clientToEdit.getTelephone());
		}
	}

	/**
	 * Method used to listen the onclick event from the create client button. It
	 * is used to create a new client and persist it.
	 */
	public void onClick$editClientButton() {

		Client client = buildClient();
		client.setId(clientToEdit.getId());

		ClientService clientService = ServiceLocator.getClientService();

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
	public void onClick$cancelEditClientButton() {
		Executions.sendRedirect("queryClients.zul");
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
