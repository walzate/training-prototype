package com.payulatam.pollingcontainer;

import com.gigaspaces.annotation.pojo.SpaceClass;
import com.gigaspaces.annotation.pojo.SpaceId;
import com.payulatam.model.Transaction;

/**
 * 
 * Class used to represent the request to the pooling container for the
 * transactions management
 * 
 * @author wilson.alzate
 * @version 28/09/2016 11:03:15 a. m.
 *
 */
@SpaceClass
public class TransactionRequest{
	/**
	 * The UUID for Gigaspaces
	 */
	private String id;

	/*
	 * Identifier for the entire job
	 */
	private Integer jobID;

	/**
	 * The request process status
	 */
	private boolean processed;
	/**
	 * The transaction to process
	 */
	private Transaction transaction;

	/**
	 * Constructor method for the class TransactionRequest.java
	 */
	public TransactionRequest() {
	}

	/**
	 * Constructor method for the class TransactionRequest.java
	 * 
	 * @param processed
	 * @param transaction
	 */
	public TransactionRequest(boolean processed, Transaction transaction) {
		super();
		this.processed = processed;
		this.transaction = transaction;
	}

	/**
	 * Method used to return the value of the variable id
	 * 
	 * @author wilson.alzate
	 * @version 27/09/2016 9:47:44 a. m.
	 * @return the id to return
	 */
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
	 * Method used to return the value of the TransactionRequest's processed
	 * 
	 * @author wilson.alzate
	 * @version 28/09/2016 10:09:28 a. m.
	 * @return The TransactionRequest's processed to return
	 */
	public boolean isProcessed() {
		return processed;
	}

	/**
	 * Method used to modify the value of the TransactionRequest's processed
	 * 
	 * @author wilson.alzate
	 * @version 28/09/2016 10:09:28 a. m.
	 * @param processed
	 *            The TransactionRequest's processed to set
	 */
	public void setProcessed(boolean processed) {
		this.processed = processed;
	}

	/**
	 * Method used to return the value of the TransactionRequest's transaction
	 * 
	 * @author wilson.alzate
	 * @version 28/09/2016 10:09:28 a. m.
	 * @return The TransactionRequest's transaction to return
	 */
	public Transaction getTransaction() {
		return transaction;
	}

	/**
	 * Method used to modify the value of the TransactionRequest's transaction
	 * 
	 * @author wilson.alzate
	 * @version 28/09/2016 10:09:28 a. m.
	 * @param transaction
	 *            The TransactionRequest's transaction to set
	 */
	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}

	/**
	 * Method used to return the value of the TransactionPoolingBase's jobID
	 * 
	 * @author wilson.alzate
	 * @version 28/09/2016 11:46:04 a. m.
	 * @return The TransactionPoolingBase's jobID to return
	 */
	public Integer getJobID() {
		return jobID;
	}

	/**
	 * Method used to modify the value of the TransactionPoolingBase's jobID
	 * 
	 * @author wilson.alzate
	 * @version 28/09/2016 11:46:04 a. m.
	 * @param jobID
	 *            The TransactionPoolingBase's jobID to set
	 */
	public void setJobID(Integer jobID) {
		this.jobID = jobID;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TransactionRequest [id=" + id + ", jobID=" + jobID + ", processed=" + processed + ", transaction="
				+ transaction + "]";
	}
}
