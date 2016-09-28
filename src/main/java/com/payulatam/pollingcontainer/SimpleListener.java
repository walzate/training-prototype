package com.payulatam.pollingcontainer;

import org.apache.log4j.Logger;
import org.openspaces.core.GigaSpace;
import org.openspaces.core.context.GigaSpaceContext;
import org.openspaces.events.EventDriven;
import org.openspaces.events.EventTemplate;
import org.openspaces.events.adapter.SpaceDataEvent;
import org.openspaces.events.polling.Polling;

import com.j_spaces.core.LeaseContext;
import com.payulatam.model.Transaction;

@EventDriven
@Polling
public class SimpleListener {

	/**
	 * Logging manager
	 */
	final Logger LOGGER = Logger.getLogger(SimpleListener.class);

	/**
	 * Reference to the Gigaspaces space
	 */
	@GigaSpaceContext
	private GigaSpace gigaSpace;

	@EventTemplate
	TransactionRequest unprocessedData() {
		TransactionRequest template = new TransactionRequest();
		template.setProcessed(false);
		LOGGER.debug("SimpleListener.unprocessedData - " + template.toString());
		return template;
	}

	@SpaceDataEvent
	public TransactionResult eventListener(TransactionRequest request) {
		LOGGER.debug("SimpleListener.eventListener - Persisting the transaction " + request.getTransaction());
		gigaSpace.write(request.getTransaction());
		
		TransactionResult result = new TransactionResult();
		
		result.setId(request.getId());
		result.setTransaction(request.getTransaction());
		result.setJobID(request.getJobID());
		
		result.setProcessed(true);
		return result;
	}
}
