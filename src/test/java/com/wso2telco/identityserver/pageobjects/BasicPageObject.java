package com.wso2telco.identityserver.pageobjects;

import org.openqa.selenium.WebDriver;

import com.wso2telco.test.framework.pageobjects.PageBase;

/**
 * The Class BasicPageObject.
 */
public class BasicPageObject extends PageBase {
	
	/** The sleep time. */
	public Long sleepTime = Long.parseLong(config.getValue("sleepTime"));

	/**
	 * Instantiates a new basic page object.
	 *
	 * @param driver the driver
	 */
	public BasicPageObject(WebDriver driver) {
		super(driver);
	}
	
}
