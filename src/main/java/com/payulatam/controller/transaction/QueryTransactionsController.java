package com.payulatam.controller.transaction;

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

import com.payulatam.listeners.transaction.DeleteTransactionButtonListener;
import com.payulatam.listeners.transaction.EditTransactionButtonListener;
import com.payulatam.locator.ServiceLocator;
import com.payulatam.model.Transaction;
import com.payulatam.service.TransactionService;

/**
 * Controller for the query transactions page
 * 
 * @author wilson.alzate
 *
 */
public class QueryTransactionsController extends GenericForwardComposer {

	/**
	 * Serialization id
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Logging manager
	 */
	final Logger LOGGER = Logger.getLogger(QueryTransactionsController.class);

	/**
	 * Reference to the grid used to display the transactions
	 */
	private Grid transactionsGrid;

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

		if (transactionsGrid != null) {
			// create model
			transactionsGrid.setModel(getTransactionsList()); // assign model to
																// Grid

			transactionsGrid.setRowRenderer(new RowRenderer() {

				public void render(Row row, Object data) throws Exception {
					final Transaction transaction = (Transaction) data;
					new Label(transaction.getType().getName()).setParent(row);
					new Label(transaction.getDate().toString()).setParent(row);
					new Label(transaction.getValue().toString()).setParent(row);
					new Label(transaction.getAccount().getNumber()).setParent(row);

					Button editButton = new Button();
					editButton.setLabel("Editar");
					editButton.addEventListener(Events.ON_CLICK, new EditTransactionButtonListener(transaction));
					editButton.setParent(row);

					Button deleteButton = new Button();
					deleteButton.setLabel("Eliminar");
					deleteButton.addEventListener(Events.ON_CLICK, new DeleteTransactionButtonListener(transaction));
					deleteButton.setParent(row);
				}
			});
		}
	}

	/**
	 * Method used to query all the transactions in the repository
	 * 
	 * @return the list of all transactions in the repository
	 * @throws Exception
	 */
	public ListModelList getTransactionsList() {
		ListModelList transactionsList = null;
		try {
			TransactionService transactionService = ServiceLocator.getTransactionService();
			Transaction[] results = transactionService.getTransactionsList();
			transactionsList = new ListModelList(results);
		} catch (Exception e) {
			messageLabel.setValue("Error al consultar los transactiones");
			e.printStackTrace();
		}
		return transactionsList;
	}

}
