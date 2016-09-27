package com.payulatam.listeners.account;

import org.apache.log4j.Logger;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;

import com.payulatam.model.Account;

/**
 * Event listener for the edit button for accounts
 * 
 * @author wilson.alzate
 *
 */
public class EditAccountButtonListener implements EventListener {

	/**
	 * The account instance to edit
	 */
	private Account account;

	/**
	 * Logging manager
	 */
	final Logger LOGGER = Logger.getLogger(EditAccountButtonListener.class);

	/**
	 * Class constructor
	 * 
	 * @param account
	 *            The account needed for the event listener
	 */
	public EditAccountButtonListener(Account account) {
		super();
		this.account = account;
	}

	/**
	 * Method used to execute after the event has been fired
	 */
	public void onEvent(Event arg0) throws Exception {
		LOGGER.debug("EditButtonListener OnEvent " + account.toString());
		Executions.sendRedirect("editAccount.zul?accountId=" + account.getId());
	}

	/**
	 * Method used to return the account to edit
	 * 
	 * @return The instance of the account to edit
	 */
	public Account getAccount() {
		return account;
	}

	/**
	 * Method used to set the account to edit instance
	 * 
	 * @param account
	 *            A new account instance to edit
	 */
	public void setAccount(Account account) {
		this.account = account;
	}

}
