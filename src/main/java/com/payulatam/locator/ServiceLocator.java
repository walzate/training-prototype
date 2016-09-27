package com.payulatam.locator;

import org.zkoss.zkplus.spring.SpringUtil;

import com.payulatam.service.AccountService;
import com.payulatam.service.ClientService;

/**
 * Class used to communicate ZK with Spring, looking for the spring beans
 * instances
 * 
 * @author wilson.alzate
 *
 */
public class ServiceLocator {

	/**
	 * Instance of the ClientService bean
	 * 
	 * @return The proper instance for the clients service
	 */
	public static ClientService getClientService() {
		return (ClientService) SpringUtil.getBean("clientServiceImpl", ClientService.class);
	}

	/**
	 * Instance of the AccountService bean
	 * 
	 * @return The proper instance for the clients service
	 */
	public static AccountService getAccountService() {
		return (AccountService) SpringUtil.getBean("accountServiceImpl", AccountService.class);
	}

}
