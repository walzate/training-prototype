package com.payulatam.locator;

import org.zkoss.zkplus.spring.SpringUtil;

import com.payulatam.service.ClientService;

/**
 * Class used to comunicate ZK with Spring, lookin for the spring beans
 * instances
 * 
 * @author wilson.alzate
 *
 */
public class ServiceLocator {

	/**
	 * Instance of the ClientService bean
	 * 
	 * @return
	 */
	public static ClientService getClientService() {
		return (ClientService) SpringUtil.getBean("clientServiceImpl", ClientService.class);
	}
}
