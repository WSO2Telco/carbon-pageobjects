package com.wso2telco.identityserver.pageobjects.carbon;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.wso2telco.identityserver.pageobjects.BasicPageObject;
import com.wso2telco.test.framework.core.WebPelement;
import com.wso2telco.test.framework.util.UIType;

/**
 * The Class CarbonHomePage.
 */
public class CarbonHomePage extends BasicPageObject {
	
	/** The logger. */
	Logger logger = Logger.getLogger(CarbonHomePage.class);
	
	/** The lnk signout. */
	private WebPelement lnkSignout = defineEelement(UIType.Xpath, "//li[@class='right']/a");
	
	/** The lbl configure. */
	private WebPelement lblConfigure = defineEelement(UIType.Xpath, "//span[text()[contains(.,'Configure')]]");
	
	/** The lbl main. */
	private WebPelement lblMain = defineEelement(UIType.Xpath, "//span[text()[contains(.,'Main')]]");
	
	/** The title home. */
	private WebPelement titleHome = defineEelement(UIType.Xpath, "//div[@id='middle']/h2");
	
	/** The lbl service provider. */
	private WebPelement lblServiceProvider = defineEelement(UIType.Xpath, "//div[@id='menu']/ul/li[3]/ul/li[1]");
	
	/** The lnk list. */
	private WebPelement lnkList = defineEelement(UIType.Xpath, "//div[@id='menu']/ul/li[3]/ul/li[1]/../li[2]/ul/li[2]");
	
	
	/**
	 * Instantiates a new carbon home page.
	 *
	 * @author SulakkhanaW
	 * @param driver the driver
	 */
	public CarbonHomePage(WebDriver driver) {
		super(driver);
	}
	
	/**
	 * Checks if is IDS home displayed.
	 *
	 * @author SulakkhanaW
	 * @param title the title
	 * @return true, if is IDS home displayed
	 * @throws Exception the exception
	 */
	public boolean isIDSHomeDisplayed(String title) throws Exception {
		flag = false;
		logger.debug("Validating IDS Home page");
		Thread.sleep(10000);
		try {
			if (title.contains(getElement(titleHome).getText().trim())) {
				flag = true;
				logger.debug("Validating IDS Home page completed");
			} else {
				logger.debug("IDS Home page title Not Matched");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating IDS Home page, Page Title 'isIDSHomeDisplayed()'"
					+ e.getMessage());
			throw new Exception(
					"Exception While Validating IDS Home page, Page Title 'isIDSHomeDisplayed()'"
							+ e.getLocalizedMessage());
		}
		return flag;
	}
	
	/**
	 * Checks if is signout.
	 *
	 * @author SulakkhanaW
	 * @param value the value
	 * @return true, if is signout
	 * @throws Exception the exception
	 */
	public boolean isSignout(String value) throws Exception{
		flag = false;
		logger.debug("Validating Sign out");
		try {
			if (getElement(lnkSignout).getText().equalsIgnoreCase(value)){
				flag = true;
				logger.debug("Sign out success");
			} else {
				logger.debug("Sign out failed");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating sign out 'isSignout()'" + e.getMessage());
			throw new Exception("Exception While Validating sign out 'isSignout()'" + e.getLocalizedMessage());
		}
		return flag;
	}
	
	/**
	 * Click configure.
	 *
	 * @author SulakkhanaW
	 */
	public void clickConfigure(){
		logger.debug("Clicking on configure");
		getElement(lblConfigure).click();
		logger.debug("Clicked on configure");
	}

	/**
	 * Click main.
	 *
	 * @author SulakkhanaW
	 */
	public void clickMain(){
		logger.debug("Clicking on main");
		getElement(lblMain).click();
		logger.debug("Clicked on main");
	}
	
	/**
	 * Checks if is menu list displayed.
	 *
	 * @author SulakkhanaW
	 * @param menuList the menu list
	 * @return true, if is menu list displayed
	 * @throws Exception the exception
	 */
	public boolean isMenuListDisplayed(String menuList) throws Exception {

		flag = false;
		logger.debug("Validating Menu tab");
		Thread.sleep(10000);
		try {
			if (menuList.contains(getElement(lblServiceProvider).getText())) {
				flag = true;
				logger.debug("Validating Menu tab completed");
			} else {
				logger.debug("Menu tab Not Matched");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating Menu tab Page Title 'isMenuListDisplayed()'"
					+ e.getMessage());
			throw new Exception(
					"Exception While Validating Menu tab Page Title 'isMenuListDisplayed()'"
							+ e.getLocalizedMessage());
		}
		return flag;
	}
	
	/**
	 * Click list.
	 *
	 * @author SulakkhanaW
	 */
	public void clickList(){
		logger.debug("Clicking on list");
		getElement(lnkList).click();
		logger.debug("Clicked on list");
	}

}
