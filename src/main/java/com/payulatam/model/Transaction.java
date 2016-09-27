/**
 * 
 */
package com.payulatam.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.gigaspaces.annotation.pojo.SpaceId;
import com.payulatam.enums.TransactionTypeEnum;

/**
 * Clients entity
 * 
 * @author wilson.alzate
 * @version 27/09/2016 9:38:06 a. m.
 *
 */
public class Transaction {

	/**
	 * The UUID for Gigaspaces
	 */
	private String id;
	/**
	 * The transaction's name
	 */
	private TransactionTypeEnum type;
	/*
	 * The transaction's date
	 */
	private Date date;
	/**
	 * The transaction's address
	 */
	private BigDecimal value;
	/**
	 * The transaction's account
	 */
	private Account account;

	/**
	 * The empty constructor needed by Gigaspaces
	 */
	public Transaction() {
	}

	/**
	 * Method used to return the value of the variable id
	 * 
	 * @author wilson.alzate
	 * @version 27/09/2016 9:47:44 a. m.
	 * @return the id to return
	 */
	@Id
	@SpaceId(autoGenerate = true)
	public String getId() {
		return id;
	}

	/**
	 * Method used to modify the value of the variable id
	 * 
	 * @author wilson.alzate
	 * @version 27/09/2016 9:47:44 a. m.
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Method used to return the value of the variable type
	 * 
	 * @author wilson.alzate
	 * @version 27/09/2016 9:47:44 a. m.
	 * @return the type to return
	 */
	public TransactionTypeEnum getType() {
		return type;
	}

	/**
	 * Method used to modify the value of the variable type
	 * 
	 * @author wilson.alzate
	 * @version 27/09/2016 9:47:44 a. m.
	 * @param type
	 *            the type to set
	 */
	public void setType(TransactionTypeEnum type) {
		this.type = type;
	}

	/**
	 * Method used to return the value of the variable value
	 * 
	 * @author wilson.alzate
	 * @version 27/09/2016 9:47:44 a. m.
	 * @return the value to return
	 */
	public BigDecimal getValue() {
		return value;
	}

	/**
	 * Method used to modify the value of the variable value
	 * 
	 * @author wilson.alzate
	 * @version 27/09/2016 9:47:44 a. m.
	 * @param value
	 *            the value to set
	 */
	public void setValue(BigDecimal value) {
		this.value = value;
	}

	/**
	 * Method used to return the value of the variable account
	 * 
	 * @author wilson.alzate
	 * @version 27/09/2016 9:49:27 a. m.
	 * @return the account to return
	 */
	@ManyToOne
	public Account getAccount() {
		return account;
	}

	/**
	 * Method used to modify the value of the variable account
	 * 
	 * @author wilson.alzate
	 * @version 27/09/2016 9:49:27 a. m.
	 * @param account
	 *            the account to set
	 */
	public void setAccount(Account account) {
		this.account = account;
	}

	/**
	 * Method used to return the value of the Transaction's date
	 * 
	 * @author wilson.alzate
	 * @version 27/09/2016 3:59:19 p. m.
	 * @return The Transaction's date to return
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * Method used to modify the value of the Transaction's date
	 * 
	 * @author wilson.alzate
	 * @version 27/09/2016 3:59:19 p. m.
	 * @param date
	 *            The Transaction's date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Transaction [id=" + id + ", type=" + type + ", date=" + date + ", value=" + value + ", account="
				+ account + "]";
	}
}
