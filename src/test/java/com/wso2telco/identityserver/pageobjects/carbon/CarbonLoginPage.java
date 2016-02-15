package com.wso2telco.identityserver.pageobjects.carbon;


import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
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
	
	/** The txt carbon username_ ie. */
	private WebPelement txtCarbonUsername_IE = defineEelement(UIType.Xpath, "//input[@id='txtUserName']");
	
	/** The txt carbon password. */
	private WebPelement txtCarbonPassword = defineEelement(UIType.ID, "txtPassword");
	
	/** The txt carbon password_ ie. */
	private WebPelement txtCarbonPassword_IE = defineEelement(UIType.Xpath, "//input[@id='txtPassword']");
	
	/** The btn login. */
	private WebPelement btnLogin = defineEelement(UIType.Xpath, "//input[@value='Sign-in']");
	
	private WebPelement btnLogin_IE = defineEelement(UIType.Xpath, "//div[@id='loginbox']/form/table/tbody/tr[5]/td[2]/input");
	
	
	
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
	 */
	public void setCarbonUsername(String username) throws Exception{
		logger.debug("Entering username");
		
    	WebPelement eleCarbonUser = txtCarbonUsername;
    	//try {
    	if (config.getValue("browser").equalsIgnoreCase("INTERNETEXPLORER")){
    		eleCarbonUser = txtCarbonUsername_IE;
    		getElement(eleCarbonUser).sendKeys(Keys.ENTER);
    		getElement(btnLogin).click();
    		//getElement(txtCarbonUsername_IE).getAttribute("name")
    		getElement(eleCarbonUser).clearAndSendkeys(username);
    		logger.debug("Entered username");
    	}
/*    	else{
    		getElement(eleCarbonUser).clearAndSendkeys(username);
    		logger.debug("Entered username");
    	}
    	} catch (Exception e) {
    	logger.debug("Exception While Entering username 'setCarbonUsername()'" + e.getMessage());
    	throw new Exception("Exception While Entering username 'setCarbonUsername()'" + e.getLocalizedMessage());
    	}*/
    	
	}
	
	/**
	 * Sets the carbon password.
	 *
	 * @author SulakkhanaW
	 * @param password the new carbon password
	 */
	public void setCarbonPassword(String password) throws Exception{
		logger.debug("Entering password");
    	WebPelement eleCarbonPassWord = txtCarbonPassword;
    	try {
    	if (config.getValue("browser").equalsIgnoreCase("INTERNETEXPLORER")){
    		eleCarbonPassWord = txtCarbonPassword_IE;
    		getElement(eleCarbonPassWord).clearAndSendkeys(password);
    		logger.debug("Entered password");
    	}
    	else{
    		getElement(eleCarbonPassWord).clearAndSendkeys(password);
    		logger.debug("Entered password");
    	}
    	} catch (Exception e) {
    	logger.debug("Exception While Entering password 'setCarbonUsername()'" + e.getMessage());
    	throw new Exception("Exception While Entering password 'setCarbonUsername()'" + e.getLocalizedMessage());
    	}
	}
	
	/**
	 * Click carbon login.
	 *
	 * @author SulakkhanaW
	 * @return the carbon home page
	 * @throws Exception the exception
	 */
	public CarbonHomePage clickCarbonLogin() throws Exception {
		try {
			logger.debug("Start clicking on API IS login");
			WebPelement eleCarbonLogin = btnLogin;
			if (config.getValue("browser").equalsIgnoreCase("INTERNETEXPLORER")) {
				eleCarbonLogin = btnLogin_IE;
				getElement(eleCarbonLogin).click();
				logger.debug("Clicked on API IS login");
			} else {
				getElement(eleCarbonLogin).click();
				logger.debug("Clicked on API IS login");
			}

		} catch (Exception e) {
			logInstruction("Exception While clicking on IS login 'clickCarbonLogin()'"
					+ e.getMessage());
			throw new Exception(
					"Exception While clicking on IS login 'clickCarbonLogin()'"
							+ e.getLocalizedMessage());
		}
		return new CarbonHomePage(driver);
	}


}
