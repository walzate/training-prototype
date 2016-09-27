package com.payulatam.enums;

/**
 * Enumeration for the transaction types
 * 
 * @author wilson.alzate
 * @version 27/09/2016 9:42:37 a. m.
 *
 */
public enum TransactionTypeEnum {
	DEBIT("Débito"), CREDIT("Crédito");
	
	/**
	 * Name related to the enumeration
	 */
	String name;

	/**
	 * Constructor method for the class TransactionTypeEnum.java
	 * @param name
	 */
	private TransactionTypeEnum(String name) {
		this.name = name;
	}

	/**
	 * Method used to return the value of the TransactionTypeEnum's name
	 * @author wilson.alzate
	 * @version 27/09/2016 4:24:12 p. m.
	 * @return The TransactionTypeEnum's name to return
	 */
	public String getName() {
		return name;
	}
}
