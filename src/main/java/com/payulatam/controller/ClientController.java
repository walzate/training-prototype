package com.payulatam.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Label;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;
import org.zkoss.zul.api.Textbox;

import com.payulatam.listeners.DeleteButtonListener;
import com.payulatam.listeners.EditButtonListener;
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
public class ClientController extends GenericForwardComposer {

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
	 * List of clients obtained from the repository
	 */
	private ListModelList clientsList;

	private Grid clientsGrid;

	/**
	 * Logging manager
	 */
	final Logger LOGGER = Logger.getLogger(ClientController.class);

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

	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);

		if (clientsGrid != null) {
			// create model
			clientsGrid.setModel(getClientsList()); // assign model to Grid

			clientsGrid.setRowRenderer(new RowRenderer() {

				public void render(Row row, Object data) throws Exception {
					final Client client = (Client) data;
					new Label(client.getName()).setParent(row);
					new Label(client.getAddress()).setParent(row);
					new Label(client.getTelephone()).setParent(row);

					Button editButton = new Button();
					editButton.setLabel("Editar");
					editButton.addEventListener(Events.ON_CLICK, new EditButtonListener(client));					
					editButton.setParent(row);

					Button deleteButton = new Button();
					deleteButton.setLabel("Eliminar");
					deleteButton.addEventListener(Events.ON_CLICK, new DeleteButtonListener(client));
					deleteButton.setParent(row);
				}
			});
		}
	}

	/**
	 * Method used to query all the clients in the repository
	 * 
	 * @return the list of all clients in the repository
	 * @throws Exception
	 */
	public ListModelList getClientsList() {
		clientsList = null;
		try {
			clientService = ServiceLocator.getClientService();
			Client[] results = clientService.getClientsList();
			clientsList = new ListModelList(results);
		} catch (Exception e) {
			messageLabel.setValue("Error al consultar los clientes");
		}
		return clientsList;
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
