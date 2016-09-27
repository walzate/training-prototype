/**
 * 
 */
package com.payulatam.renderers;

import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;

import com.payulatam.model.Client;

/**
 * Class used to
 * 
 * @author wilson.alzate
 * @version 27/09/2016 2:31:09 p. m.
 *
 */
public class ClientsListitemRenderer implements ListitemRenderer {

	/**
	 * The client selected by the user
	 */
	private Client selectedClient;

	/**
	 * Default constructor method for the class ClientsListitemRenderer.java
	 */
	public ClientsListitemRenderer() {

	}

	/**
	 * Constructor method for the class ClientsListitemRenderer.java
	 * 
	 * @param selectedClient
	 *            The client selected by the user
	 */
	public ClientsListitemRenderer(Client selectedClient) {
		super();
		this.selectedClient = selectedClient;
	}

	public void render(Listitem listItem, Object object) throws Exception {
		Client client = (Client) object;
		listItem.setLabel(client.getName());
		listItem.setValue(client.getId());

		if (selectedClient != null && selectedClient.getId().equals(client.getId())) {
			listItem.setSelected(true);
		}
	}

	/**
	 * Method used to return the value of the ClientsListitemRenderer's
	 * selectedClient
	 * 
	 * @author wilson.alzate
	 * @version 27/09/2016 2:31:52 p. m.
	 * @return The ClientsListitemRenderer's selectedClient to return
	 */
	public Client getSelectedClient() {
		return selectedClient;
	}

	/**
	 * Method used to modify the value of the ClientsListitemRenderer's
	 * selectedClient
	 * 
	 * @author wilson.alzate
	 * @version 27/09/2016 2:31:52 p. m.
	 * @param selectedClient
	 *            The ClientsListitemRenderer's selectedClient to set
	 */
	public void setSelectedClient(Client selectedClient) {
		this.selectedClient = selectedClient;
	}
}
