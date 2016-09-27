package com.payulatam.controller.account;

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

import com.payulatam.listeners.account.DeleteAccountButtonListener;
import com.payulatam.listeners.account.EditAccountButtonListener;
import com.payulatam.locator.ServiceLocator;
import com.payulatam.model.Account;
import com.payulatam.service.AccountService;

/**
 * Controller for the query accounts page
 * 
 * @author wilson.alzate
 *
 */
public class QueryAccountsController extends GenericForwardComposer {

	/**
	 * Serialization id
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Logging manager
	 */
	final Logger LOGGER = Logger.getLogger(QueryAccountsController.class);

	/**
	 * Reference to the grid used to display the accounts
	 */
	private Grid accountsGrid;

	/**
	 * List of accounts obtained from the repository
	 */
	private ListModelList accountsList;

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

		if (accountsGrid != null) {
			// create model
			accountsGrid.setModel(getAccountsList()); // assign model to Grid

			accountsGrid.setRowRenderer(new RowRenderer() {

				public void render(Row row, Object data) throws Exception {
					final Account account = (Account) data;
					new Label(account.getNumber()).setParent(row);
					new Label(account.getBalance().toString()).setParent(row);
					new Label(account.getClient().getName()).setParent(row);

					Button editButton = new Button();
					editButton.setLabel("Editar");
					editButton.addEventListener(Events.ON_CLICK, new EditAccountButtonListener(account));
					editButton.setParent(row);

					Button deleteButton = new Button();
					deleteButton.setLabel("Eliminar");
					deleteButton.addEventListener(Events.ON_CLICK, new DeleteAccountButtonListener(account));
					deleteButton.setParent(row);
				}
			});
		}
	}

	/**
	 * Method used to query all the accounts in the repository
	 * 
	 * @return the list of all accounts in the repository
	 * @throws Exception
	 */
	public ListModelList getAccountsList() {
		accountsList = null;
		try {
			AccountService accountService = ServiceLocator.getAccountService();
			Account[] results = accountService.getAccountsList();
			accountsList = new ListModelList(results);
		} catch (Exception e) {
			messageLabel.setValue("Error al consultar los accountes");
		}
		return accountsList;
	}

}
