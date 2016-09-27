package com.payulatam.listeners.transaction;

import org.apache.log4j.Logger;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;

import com.payulatam.model.Transaction;

/**
 * Event listener for the edit button for transactions
 * 
 * @author wilson.alzate
 *
 */
public class EditTransactionButtonListener implements EventListener {

	/**
	 * The transaction instance to edit
	 */
	private Transaction transaction;

	/**
	 * Logging manager
	 */
	final Logger LOGGER = Logger.getLogger(EditTransactionButtonListener.class);

	/**
	 * Class constructor
	 * 
	 * @param transaction
	 *            The transaction needed for the event listener
	 */
	public EditTransactionButtonListener(Transaction transaction) {
		super();
		this.transaction = transaction;
	}

	/**
	 * Method used to execute after the event has been fired
	 */
	public void onEvent(Event arg0) throws Exception {
		LOGGER.debug("EditButtonListener OnEvent " + transaction.toString());
		Executions.sendRedirect("editTransaction.zul?transactionId=" + transaction.getId());
	}

	/**
	 * Method used to return the transaction to edit
	 * 
	 * @return The instance of the transaction to edit
	 */
	public Transaction getTransaction() {
		return transaction;
	}

	/**
	 * Method used to set the transaction to edit instance
	 * 
	 * @param transaction
	 *            A new transaction instance to edit
	 */
	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}

}
