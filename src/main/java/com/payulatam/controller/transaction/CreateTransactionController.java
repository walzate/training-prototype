package com.payulatam.controller.transaction;

import java.math.BigDecimal;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Label;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.api.Datebox;
import org.zkoss.zul.api.Doublebox;
import org.zkoss.zul.api.Listbox;

import com.payulatam.enums.TransactionTypeEnum;
import com.payulatam.locator.ServiceLocator;
import com.payulatam.model.Account;
import com.payulatam.model.Transaction;
import com.payulatam.renderers.AccountsListitemRenderer;
import com.payulatam.renderers.TransactionTypesListitemRenderer;
import com.payulatam.service.AccountService;
import com.payulatam.service.TransactionService;

/**
 * Controller for the create account view
 * 
 * @author wilson.alzate
 *
 */
@Controller
public class CreateTransactionController extends GenericForwardComposer {

	/**
	 * Serialization id
	 */
	private static final long serialVersionUID = 2116314619237122525L;

	/**
	 * Logging manager
	 */
	final Logger LOGGER = Logger.getLogger(CreateTransactionController.class);

	/**
	 * Label for the messages resulting from the operation
	 */
	private Label messageLabel;

	/**
	 * Field with the transaction's number
	 */
	private Listbox transactionTypeListBox;
	/**
	 * Field with the transaction's balance
	 */
	private Datebox transactionDateDateBox;
	/**
	 * The transaction's value
	 */
	private Doublebox transactionValueDoubleBox;
	/**
	 * Field with the transaction's account
	 */
	private Listbox transactionAccountListBox;

	/**
	 * Method called on initialization phase
	 */
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		buildAccountsListBox();
		buildTransactionTypesListBox();
	}

	/**
	 * Method used to build the dropdown list for accounts
	 * 
	 * @throws Exception
	 * @author wilson.alzate
	 * @version 27/09/2016 2:13:25 p. m.
	 */
	public void buildTransactionTypesListBox() throws Exception {
		ListModelList model = new ListModelList(TransactionTypeEnum.values());

		transactionTypeListBox.setModel(model);
		transactionTypeListBox.setItemRenderer(new TransactionTypesListitemRenderer());
	}

	/**
	 * Method used to build the dropdown list for accounts
	 * 
	 * @throws Exception
	 * @author wilson.alzate
	 * @version 27/09/2016 2:13:25 p. m.
	 */
	public void buildAccountsListBox() throws Exception {
		AccountService accountService = ServiceLocator.getAccountService();
		Account[] accountsList = accountService.getAccountsList();

		ListModelList model = new ListModelList(accountsList);

		transactionAccountListBox.setModel(model);
		transactionAccountListBox.setItemRenderer(new AccountsListitemRenderer());
	}

	/**
	 * Method used to listen the onclick event from the create transaction
	 * button. It is used to create a new transaction and persist it.
	 */
	public void onClick$createTransactionButton() {

		Transaction transaction = buildTransaction();

		TransactionService transactionService = ServiceLocator.getTransactionService();

		try {
			transactionService.saveOrUpdate(transaction);
		} catch (Exception e) {
			messageLabel.setValue("Error al crear el movimiento");
			LOGGER.error(e);
			e.printStackTrace();
		}

		Executions.sendRedirect("queryTransactions.zul");
		messageLabel.setValue("Movimiento creado exitosamente.");
	}

	/**
	 * Method used as onclick listener for the cancel button
	 */
	public void onClick$cancelCreateTransactionButton() {
		Executions.sendRedirect("transactionsManagement.zul");
	}

	/**
	 * Method used to create the account object using the view components values
	 * 
	 * @return A new account object with the values entered by the user.
	 */
	private Transaction buildTransaction() {
		Transaction transaction = new Transaction();
		transaction.setType(getSelectedTransactionType());

		transaction.setDate(transactionDateDateBox.getValue());

		transaction.setValue(BigDecimal.valueOf(transactionValueDoubleBox.getValue()));

		transaction.setAccount(getSelectedAccount());

		return transaction;
	}

	private TransactionTypeEnum getSelectedTransactionType() {
		TransactionTypeEnum result = null;
		if (transactionTypeListBox != null && transactionTypeListBox.getSelectedItems() != null
				&& transactionTypeListBox.getSelectedItems().size() > 0) {
			for (Object o : transactionTypeListBox.getSelectedItems()) {
				Listitem listItem = (Listitem) o;
				result = TransactionTypeEnum.valueOf(listItem.getValue().toString());
			}
		}
		return result;
	}

	/**
	 * Method used to obtain the selected account
	 * 
	 * @return The instance of the selected account
	 * @author wilson.alzate
	 * @version 27/09/2016 2:19:14 p. m.
	 */
	private Account getSelectedAccount() {
		Account account = null;
		try {
			if (transactionAccountListBox.getSelectedItems() != null
					&& transactionAccountListBox.getSelectedItems().size() > 0) {

				for (Object o : transactionAccountListBox.getSelectedItems()) {
					Listitem listItem = (Listitem) o;
					account = (Account) listItem.getValue();
				}
				LOGGER.debug("accountId " + account);

			}
		} catch (Exception e) {
			LOGGER.error(e);
		}
		return account;
	}

}
