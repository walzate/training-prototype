package com.payulatam.controller;

import org.apache.log4j.Logger;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Label;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;

import com.payulatam.listeners.DeleteButtonListener;
import com.payulatam.listeners.EditButtonListener;
import com.payulatam.locator.ServiceLocator;
import com.payulatam.model.Client;
import com.payulatam.service.ClientService;

public class QueryClientsController extends GenericForwardComposer {

	/**
	 * Serialization id
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Logging manager
	 */
	final Logger LOGGER = Logger.getLogger(CreateClientController.class);

	/**
	 * Reference to the grid used to display the clients
	 */
	private Grid clientsGrid;

	/**
	 * List of clients obtained from the repository
	 */
	private ListModelList clientsList;

	/**
	 * Label for the messages resulting from the operation
	 */
	private Label messageLabel;

	/**
	 * Method called on initialization phase
	 */
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
			ClientService clientService = ServiceLocator.getClientService();
			Client[] results = clientService.getClientsList();
			clientsList = new ListModelList(results);
		} catch (Exception e) {
			messageLabel.setValue("Error al consultar los clientes");
		}
		return clientsList;
	}

}
