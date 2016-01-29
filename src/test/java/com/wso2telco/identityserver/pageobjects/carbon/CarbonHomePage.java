package com.wso2telco.identityserver.pageobjects.carbon;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.wso2telco.identityserver.pageobjects.BasicPageObject;
import com.wso2telco.test.framework.core.WebPelement;
import com.wso2telco.test.framework.util.UIType;

public class CarbonHomePage extends BasicPageObject {
	
	Logger logger = Logger.getLogger(CarbonLoginPage.class);
	
	private WebPelement lnkSignout = defineEelement(UIType.Xpath, "//li[@class='right']/a");
	
	private WebPelement lblConfigure = defineEelement(UIType.Xpath, "//span[text()[contains(.,'Configure')]]");
	
	private WebPelement lblMain = defineEelement(UIType.Xpath, "//span[text()[contains(.,'Main')]]");
	
	private WebPelement titleHome = defineEelement(UIType.Xpath, "//div[@id='middle']/h2");
	
	private WebPelement lblServiceProvider = defineEelement(UIType.Xpath, "//div[@id='menu']/ul/li[3]/ul/li[1]");
	
	private WebPelement lnkList = defineEelement(UIType.Xpath, "//div[@id='menu']/ul/li[3]/ul/li[1]/../li[2]/ul/li[2]");
	
	
	public CarbonHomePage(WebDriver driver) {
		super(driver);
	}
	
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
	
	public void clickConfigure(){
		getElement(lblConfigure).click();
	}

	public void clickMain(){
		getElement(lblMain).click();
	}
	
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
	
	public void clickList(){
		getElement(lnkList).click();
	}

}
