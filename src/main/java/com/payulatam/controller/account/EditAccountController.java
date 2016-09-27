package com.payulatam.controller.account;

import java.math.BigDecimal;

import org.apache.log4j.Logger;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Label;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.api.Listbox;
import org.zkoss.zul.api.Textbox;

import com.payulatam.locator.ServiceLocator;
import com.payulatam.model.Account;
import com.payulatam.model.Client;
import com.payulatam.renderers.ClientsListitemRenderer;
import com.payulatam.service.AccountService;
import com.payulatam.service.ClientService;

/**
 * Controller for the edit accounts page
 * 
 * @author wilson.alzate
 *
 */
public class EditAccountController extends GenericForwardComposer {

	/**
	 * Serialization id
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Logging manager
	 */
	final Logger LOGGER = Logger.getLogger(EditAccountController.class);

	/**
	 * Reference to the name text box
	 */
	private Textbox accountNumberTextBox;
	/**
	 * Reference to the account address text box
	 */
	private Textbox accountBalanceTextBox;
	/**
	 * Reference to the drop down list for clients
	 */
	private Listbox accountClientListBox;
	/**
	 * Label for the messages resulting from the operation
	 */
	private Label messageLabel;
	/**
	 * Reference to the account to be edited
	 */
	private Account accountToEdit;

	/**
	 * Initialization method
	 */
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);

		String accountId = Executions.getCurrent().getParameter("accountId");

		AccountService accountService = ServiceLocator.getAccountService();

		accountToEdit = accountService.getById(accountId);

		LOGGER.debug("EditAccountController:doAfterCompose " + accountToEdit);

		if (accountToEdit != null) {
			accountNumberTextBox.setValue(accountToEdit.getNumber());
			accountBalanceTextBox.setValue(accountToEdit.getBalance().toString());
			buildClientsListBox(accountToEdit);
		}
	}

	/**
	 * Method used to build the dropdown list for clients
	 * 
	 * @throws Exception
	 * @author wilson.alzate
	 * @version 27/09/2016 2:13:25 p. m.
	 */
	public void buildClientsListBox(Account account) throws Exception {
		ClientService clientService = ServiceLocator.getClientService();
		Client[] clientsList = clientService.getClientsList();

		ListModelList model = new ListModelList(clientsList);

		accountClientListBox.setModel(model);
		accountClientListBox.setItemRenderer(new ClientsListitemRenderer(accountToEdit.getClient()));
	}

	/**
	 * Method used to listen the onclick event from the create account button.
	 * It is used to create a new account and persist it.
	 */
	public void onClick$editAccountButton() {

		Account account = buildAccount();
		account.setId(accountToEdit.getId());

		AccountService accountService = ServiceLocator.getAccountService();

		try {
			accountService.saveOrUpdate(account);
		} catch (Exception e) {
			messageLabel.setValue("Error al crear el accounte");
			LOGGER.error(e);
		}
		Executions.sendRedirect("queryAccounts.zul");
		messageLabel.setValue("Accounte creado exitosamente.");
	}

	/**
	 * Method used as onclick listener for the cancel button
	 */
	public void onClick$cancelEditAccountButton() {
		Executions.sendRedirect("queryAccounts.zul");
	}

	/**
	 * Method used to create the account object using the view components values
	 * 
	 * @return A new account object with the values entered by the user.
	 */
	private Account buildAccount() {
		Account account = new Account();
		account.setNumber(accountNumberTextBox.getValue());
		account.setBalance(new BigDecimal(accountBalanceTextBox.getValue()));

		account.setClient(getSelectedClient());

		return account;
	}

	/**
	 * Method used to obtain the selected client
	 * 
	 * @return The instance of the selected client
	 * @author wilson.alzate
	 * @version 27/09/2016 2:19:14 p. m.
	 */
	private Client getSelectedClient() {
		Client client = null;
		try {
			if (accountClientListBox.getSelectedItems() != null && accountClientListBox.getSelectedItems().size() > 0) {
				String clientId = "";
				ClientService clientService = ServiceLocator.getClientService();
				for (Object o : accountClientListBox.getSelectedItems()) {
					Listitem listItem = (Listitem) o;
					clientId = listItem.getValue().toString();
				}
				LOGGER.debug("clientId " + clientId);
				client = clientService.getById(clientId);

			}
		} catch (Exception e) {
			LOGGER.error(e);
		}
		return client;
	}

}
