package com.payulatam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkplus.spring.SpringUtil;
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
	 * 
	 */
	private Label helloLabel;
	/**
	 * Reference to the client telephone text box
	 */
	private Textbox clientTelephoneTextBox;

	/**
	 * Spring context object
	 */
	private ApplicationContext context;

	private ClientService clientService;

	/**
	 * Constructor for the class used to initialize the space
	 */
	public ClientController() {

	}

	/**
	 * Method used to listen the onclick event from the create client button. It
	 * is used to create a new client and persist it.
	 */
	public void onClick$createClientButton() {

		Client client = buildClient();

		clientService = ServiceLocator.getClientService();
		
		//clientService = (ClientService) SpringUtil.getBean("clientServiceImpl", ClientService.class);

		// context = new
		// ClassPathXmlApplicationContext(PrototypeConstants.SPRING_CONFIGURATION_FILE);
		//
		// clientService = (ClientService) context.getBean(ClientService.class);

		try {
			clientService.saveOrUpdate(client);
		} catch (Exception e) {
			e.printStackTrace();
		}

		helloLabel.setValue("Hello: " + client.toString());

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
