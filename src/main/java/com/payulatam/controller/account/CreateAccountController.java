package com.payulatam.controller.account;

import java.math.BigDecimal;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Label;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;
import org.zkoss.zul.api.Listbox;
import org.zkoss.zul.api.Textbox;

import com.payulatam.locator.ServiceLocator;
import com.payulatam.model.Account;
import com.payulatam.model.Client;
import com.payulatam.service.AccountService;
import com.payulatam.service.ClientService;

/**
 * Controller for the create client view
 * 
 * @author wilson.alzate
 *
 */
@Controller
public class CreateAccountController extends GenericForwardComposer {

	/**
	 * Serialization id
	 */
	private static final long serialVersionUID = 2116314619237122525L;

	/**
	 * Logging manager
	 */
	final Logger LOGGER = Logger.getLogger(CreateAccountController.class);

	/**
	 * Label for the messages resulting from the operation
	 */
	private Label messageLabel;

	/**
	 * Field with the account's number
	 */
	private Textbox accountNumberTextBox;
	/**
	 * Field with the account's balance
	 */
	private Textbox accountBalanceTextBox;
	/**
	 * Field with the account's client
	 */
	private Listbox accountClientListBox;

	/**
	 * Method called on initialization phase
	 */
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		ClientService clientService = ServiceLocator.getClientService();
		Client[] clientsList = clientService.getClientsList();

		ListModelList model = new ListModelList(clientsList);

		accountClientListBox.setModel(model);
		accountClientListBox.setItemRenderer(new ListitemRenderer() {
			public void render(Listitem listItem, Object object) throws Exception {
				Client client = (Client) object;
				listItem.setLabel(client.getName());
				listItem.setValue(client.getId());

			}
		});

	}

	/**
	 * Method used to listen the onclick event from the create account button.
	 * It is used to create a new account and persist it.
	 */
	public void onClick$createAccountButton() {

		Account account = buildAccount();

		AccountService accountService = ServiceLocator.getAccountService();

		try {
			accountService.saveOrUpdate(account);
		} catch (Exception e) {
			messageLabel.setValue("Error al crear la cuenta");
			LOGGER.error(e);
		}

		Executions.sendRedirect("queryAccounts.zul");
		messageLabel.setValue("Cuenta creada exitosamente.");
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
	private Account buildAccount() {
		Account account = new Account();
		account.setNumber(accountNumberTextBox.getValue());

		BigDecimal balance = new BigDecimal(accountBalanceTextBox.getValue());
		account.setBalance(balance);

		try {
			if (accountClientListBox.getSelectedItems() != null && accountClientListBox.getSelectedItems().size() > 0) {
				String clientId = "";
				ClientService clientService = ServiceLocator.getClientService();
				for (Object o : accountClientListBox.getSelectedItems()) {
					Listitem listItem = (Listitem) o;
					clientId = listItem.getValue().toString();
				}
				LOGGER.debug("clientId " + clientId);
				Client client = clientService.getById(clientId);
				account.setClient(client);
			}
		} catch (Exception e) {
			LOGGER.error(e);
		}
		return account;
	}

}
