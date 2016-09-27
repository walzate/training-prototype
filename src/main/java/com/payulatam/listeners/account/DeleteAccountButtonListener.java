package com.payulatam.listeners.account;

import org.apache.log4j.Logger;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;

import com.payulatam.locator.ServiceLocator;
import com.payulatam.model.Account;
import com.payulatam.service.AccountService;

/**
 * Event listener for the delete button for accounts
 * 
 * @author wilson.alzate
 *
 */
public class DeleteAccountButtonListener implements EventListener {

	/**
	 * The account instance to delete
	 */
	private Account account;

	/**
	 * Logging manager
	 */
	final Logger LOGGER = Logger.getLogger(DeleteAccountButtonListener.class);

	/**
	 * Class constructor
	 * 
	 * @param account
	 *            The account needed for the event listener
	 */
	public DeleteAccountButtonListener(Account account) {
		super();
		this.account = account;
	}

	/**
	 * Method used to execute after the event has been fired
	 */
	public void onEvent(Event arg0) throws Exception {
		LOGGER.debug("DeleteButtonListener OnEvent " + account.toString());
		AccountService accountService = ServiceLocator.getAccountService();
		accountService.delete(account);
		Executions.sendRedirect("queryAccounts.zul");
	}

	/**
	 * Method used to return the account to delete
	 * 
	 * @return The instance of the account to delete
	 */
	public Account getAccount() {
		return account;
	}

	/**
	 * Method used to set the account to delete instance
	 * 
	 * @param account
	 *            A new account instance to delete
	 */
	public void setAccount(Account account) {
		this.account = account;
	}

}
