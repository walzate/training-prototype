/**
 * 
 */
package com.payulatam.renderers;

import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;

import com.payulatam.enums.TransactionTypeEnum;

/**
 * Class used to render the list of transaction types
 * 
 * @author wilson.alzate
 * @version 27/09/2016 2:31:09 p. m.
 *
 */
public class TransactionTypesListitemRenderer implements ListitemRenderer {

	/**
	 * The transaction type selected by the user
	 */
	private TransactionTypeEnum selectedTransactionTypeEnum;

	/**
	 * Default constructor method for the class ClientsListitemRenderer.java
	 */
	public TransactionTypesListitemRenderer() {

	}

	/**
	 * Constructor method for the class ClientsListitemRenderer.java
	 * 
	 * @param selectedClient
	 *            The transaction type selected by the user
	 */
	public TransactionTypesListitemRenderer(TransactionTypeEnum transactionTypeEnum) {
		super();
		this.selectedTransactionTypeEnum = transactionTypeEnum;
	}

	/**
	 * Method used to configure the list items to be rendered
	 */
	public void render(Listitem listItem, Object object) throws Exception {
		TransactionTypeEnum transactionTypeEnum = (TransactionTypeEnum) object;
		listItem.setLabel(transactionTypeEnum.getName());
		listItem.setValue(transactionTypeEnum);

		if (selectedTransactionTypeEnum != null && selectedTransactionTypeEnum.equals(transactionTypeEnum)) {
			listItem.setSelected(true);
		}
	}
}
