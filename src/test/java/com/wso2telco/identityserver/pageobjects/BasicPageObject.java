package com.wso2telco.identityserver.pageobjects;

import org.openqa.selenium.WebDriver;

import com.wso2telco.test.framework.core.WebPelement;
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
	
public void typeTextBox(WebPelement textbox, String value) throws Exception{
		
		getElement(textbox).clearAndSendkeys(value);
		String enteredValue = textbox.getAttribute("value");
		try {
		if(!(enteredValue.equalsIgnoreCase(value))){
				do{
					getElement(textbox).clearAndSendkeys(value);
					enteredValue = textbox.getAttribute("value");
				}while(!(enteredValue.equalsIgnoreCase(value)));
			}	
		}
		 catch (Exception e) {
			e.getMessage();
			throw new Exception("Exception While Validating User name 'isUserName()'" + e.getLocalizedMessage());
		}
}
	
}
