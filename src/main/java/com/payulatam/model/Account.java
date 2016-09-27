package com.payulatam.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.gigaspaces.annotation.pojo.SpaceId;

/**
 * Accounts entity
 * 
 * @author wilson.alzate
 *
 */
@Entity
public class Account {

	/**
	 * The UUID for Gigaspaces
	 */
	private String id;
	/**
	 * The account's name
	 */
	private String number;
	/**
	 * The account's address
	 */
	private BigDecimal balance;
	/**
	 * The account's owner
	 */
	private Client client;

	/**
	 * The empty constructor needed by Gigaspaces
	 */
	public Account() {
	}

	/**
	 * Method used to return the value of the Account's id
	 * 
	 * @author wilson.alzate
	 * @version 27/09/2016 9:55:42 a. m.
	 * @return The Account's id to return
	 */
	@Id
	@SpaceId(autoGenerate = true)
	public String getId() {
		return id;
	}

	/**
	 * Method used to modify the value of the Account's id
	 * 
	 * @author wilson.alzate
	 * @version 27/09/2016 9:55:42 a. m.
	 * @param id
	 *            The Account's id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Method used to return the value of the Account's number
	 * 
	 * @author wilson.alzate
	 * @version 27/09/2016 9:55:42 a. m.
	 * @return The Account's number to return
	 */
	public String getNumber() {
		return number;
	}

	/**
	 * Method used to modify the value of the Account's number
	 * 
	 * @author wilson.alzate
	 * @version 27/09/2016 9:55:42 a. m.
	 * @param number
	 *            The Account's number to set
	 */
	public void setNumber(String number) {
		this.number = number;
	}

	/**
	 * Method used to return the value of the Account's balance
	 * 
	 * @author wilson.alzate
	 * @version 27/09/2016 9:55:42 a. m.
	 * @return The Account's balance to return
	 */
	public BigDecimal getBalance() {
		return balance;
	}

	/**
	 * Method used to modify the value of the Account's balance
	 * 
	 * @author wilson.alzate
	 * @version 27/09/2016 9:55:42 a. m.
	 * @param balance
	 *            The Account's balance to set
	 */
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	/**
	 * Method used to return the value of the Account's client
	 * 
	 * @author wilson.alzate
	 * @version 27/09/2016 9:55:42 a. m.
	 * @return The Account's client to return
	 */
	@ManyToOne
	public Client getClient() {
		return client;
	}

	/**
	 * Method used to modify the value of the Account's client
	 * 
	 * @author wilson.alzate
	 * @version 27/09/2016 9:55:42 a. m.
	 * @param client
	 *            The Account's client to set
	 */
	public void setClient(Client client) {
		this.client = client;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Account [id=" + id + ", number=" + number + ", balance=" + balance + ", client=" + client + "]";
	}
}
