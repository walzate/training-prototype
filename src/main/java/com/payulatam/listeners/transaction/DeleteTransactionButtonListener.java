package com.payulatam.listeners.transaction;

import org.apache.log4j.Logger;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;

import com.payulatam.locator.ServiceLocator;
import com.payulatam.model.Transaction;
import com.payulatam.service.TransactionService;

/**
 * Event listener for the delete button for transactions
 * 
 * @author wilson.alzate
 *
 */
public class DeleteTransactionButtonListener implements EventListener {

	/**
	 * The transaction instance to delete
	 */
	private Transaction transaction;

	/**
	 * Logging manager
	 */
	final Logger LOGGER = Logger.getLogger(DeleteTransactionButtonListener.class);

	/**
	 * Class constructor
	 * 
	 * @param transaction
	 *            The transaction needed for the event listener
	 */
	public DeleteTransactionButtonListener(Transaction transaction) {
		super();
		this.transaction = transaction;
	}

	/**
	 * Method used to execute after the event has been fired
	 */
	public void onEvent(Event arg0) throws Exception {
		LOGGER.debug("DeleteButtonListener OnEvent " + transaction.toString());
		TransactionService transactionService = ServiceLocator.getTransactionService();
		transactionService.delete(transaction);
		Executions.sendRedirect("queryTransactions.zul");
	}

	/**
	 * Method used to return the transaction to delete
	 * 
	 * @return The instance of the transaction to delete
	 */
	public Transaction getTransaction() {
		return transaction;
	}

	/**
	 * Method used to set the transaction to delete instance
	 * 
	 * @param transaction
	 *            A new transaction instance to delete
	 */
	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}

}
