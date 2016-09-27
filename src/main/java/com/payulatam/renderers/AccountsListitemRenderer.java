/**
 * 
 */
package com.payulatam.renderers;

import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;

import com.payulatam.model.Account;

/**
 * Class used to
 * 
 * @author wilson.alzate
 * @version 27/09/2016 2:31:09 p. m.
 *
 */
public class AccountsListitemRenderer implements ListitemRenderer {

	/**
	 * The account selected by the user
	 */
	private Account selectedAccount;

	/**
	 * Default constructor method for the class AccountsListitemRenderer.java
	 */
	public AccountsListitemRenderer() {

	}

	/**
	 * Constructor method for the class AccountsListitemRenderer.java
	 * 
	 * @param selectedAccount
	 *            The account selected by the user
	 */
	public AccountsListitemRenderer(Account selectedAccount) {
		super();
		this.selectedAccount = selectedAccount;
	}

	public void render(Listitem listItem, Object object) throws Exception {
		Account account = (Account) object;
		listItem.setLabel(account.getNumber());
		listItem.setValue(account);

		if (selectedAccount != null && selectedAccount.getId().equals(account.getId())) {
			listItem.setSelected(true);
		}
	}

	/**
	 * Method used to return the value of the AccountsListitemRenderer's
	 * selectedAccount
	 * 
	 * @author wilson.alzate
	 * @version 27/09/2016 2:31:52 p. m.
	 * @return The AccountsListitemRenderer's selectedAccount to return
	 */
	public Account getSelectedAccount() {
		return selectedAccount;
	}

	/**
	 * Method used to modify the value of the AccountsListitemRenderer's
	 * selectedAccount
	 * 
	 * @author wilson.alzate
	 * @version 27/09/2016 2:31:52 p. m.
	 * @param selectedAccount
	 *            The AccountsListitemRenderer's selectedAccount to set
	 */
	public void setSelectedAccount(Account selectedAccount) {
		this.selectedAccount = selectedAccount;
	}
}
