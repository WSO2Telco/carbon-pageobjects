package com.wso2telco.identityserver.pageobjects.carbon;


import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.wso2telco.identityserver.pageobjects.BasicPageObject;
import com.wso2telco.test.framework.core.WebPelement;
import com.wso2telco.test.framework.util.UIType;

/**
 * The Class CarbonLoginPage.
 */
public class CarbonLoginPage extends BasicPageObject {
	
	/** The logger. */
	Logger logger = Logger.getLogger(CarbonLoginPage.class);
	
	/** The txt carbon username. */
	private WebPelement txtCarbonUsername = defineEelement(UIType.ID, "txtUserName");
	
	/** The txt carbon password. */
	private WebPelement txtCarbonPassword = defineEelement(UIType.ID, "txtPassword");
	
	/** The btn login. */
	private WebPelement btnLogin = defineEelement(UIType.Xpath, "//input[@value='Sign-in']");
	
	
	
	/**
	 * Instantiates a new carbon login page.
	 *
	 * @author SulakkhanaW
	 * @param driver the driver
	 */
	public CarbonLoginPage(WebDriver driver) {
		super(driver);
	}
	
	/**
	 * Sets the carbon username.
	 *
	 * @author SulakkhanaW
	 * @param username the new carbon username
	 * @throws Exception 
	 */
	public void setCarbonUsername(String username) throws Exception{
		logger.debug("Entering username");
		typeTextBox(txtCarbonUsername, username);
		//getElement(txtCarbonUsername).clearAndSendkeys(username);
		//Thread.sleep(5000);
		logger.debug("Entered username");
	}
	
	/**
	 * Sets the carbon password.
	 *
	 * @author SulakkhanaW
	 * @param password the new carbon password
	 * @throws InterruptedException 
	 */
	public void setCarbonPassword(String password) throws InterruptedException{
		logger.debug("Entering password");
		getElement(txtCarbonPassword).clearAndSendkeys(password);
		logger.debug("Entered password");
	}
	
	/**
	 * Click carbon login.
	 *
	 * @author SulakkhanaW
	 * @return the carbon home page
	 * @throws Exception the exception
	 */
	public CarbonHomePage clickCarbonLogin() throws Exception{
		try {
			logger.debug("Start clicking on API IS login");
			getElement(btnLogin).click();
			logger.debug("Clicked on API IS login");
			Thread.sleep(5000);
		} catch (Exception e) {
			logInstruction("Exception While clicking on IS login 'clickCarbonLogin()'" + e.getMessage());
			throw new Exception("Exception While clicking on IS login 'clickCarbonLogin()'" + e.getLocalizedMessage());
		}
		return new CarbonHomePage(driver);
	}


}
