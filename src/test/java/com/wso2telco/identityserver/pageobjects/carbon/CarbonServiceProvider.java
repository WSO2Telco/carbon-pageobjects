package com.wso2telco.identityserver.pageobjects.carbon;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.wso2telco.identityserver.pageobjects.BasicPageObject;
import com.wso2telco.test.framework.core.WebPelement;
import com.wso2telco.test.framework.util.UIType;



public class CarbonServiceProvider extends BasicPageObject {

	Logger logger = Logger.getLogger(CarbonServiceProvider.class);
	
	private WebPelement lblSP = defineEelement(UIType.Xpath, "//div[@id='middle']/h2");
	
	private WebPelement lnkInbound = defineEelement(UIType.Xpath, "//a[contains(.,'Inbound Authentication Configuration')]");
	
	private WebPelement lnkOAuth = defineEelement(UIType.Xpath, "//h2[@id='oauth.config.head']/a");
	
	private WebPelement btnShow = defineEelement(UIType.Xpath, "//input[@id='oauthConsumerSecret']/../span[1]/a");
	
	public CarbonServiceProvider(WebDriver driver) {
		super(driver);
	}

	public boolean isAppinSPTable(String appName) throws Exception {

		flag = false;
		logger.debug("Validating App in SP");
		int count = driver.findElements(By.xpath("//a[contains(.,'Edit')]")).size();
		Thread.sleep(10000);
		
		try {
			if (count != 0) {
				flag = true;
				logger.debug("Validating App in SP completed");
			} else {
				logger.debug("App is Not Matched");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating App in SP Page Title 'isAppinSPTable()'"
					+ e.getMessage());
			throw new Exception(
					"Exception While Validating App in SP Page Title 'isAppinSPTable()'"
							+ e.getLocalizedMessage());
		}
		return flag;
	}
	
	public void clickAppEdit(String app){
		
		String xpath = "//td[contains(.,'"+app+"')]/../td[3]/a[1]";
		WebPelement btnEdit =defineEelement(UIType.Xpath, xpath);
		getElement(btnEdit).click();
	}
	
	public boolean isSPpageDisplyed(String spHeader) throws Exception {

		flag = false;
		logger.debug("Validating Title Service Provider");
		Thread.sleep(10000);
		
		try {
			if (spHeader.contains(getElement(lblSP).getText())) {
				flag = true;
				logger.debug("Validating Title Service Provider completed");
			} else {
				logger.debug("Title Service Provider is Not Matched");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating Title Service Provider Page Title 'isSPpageDisplyed()'"
					+ e.getMessage());
			throw new Exception(
					"Exception While Validating Title Service Provider Page Title 'isSPpageDisplyed()'"
							+ e.getLocalizedMessage());
		}
		return flag;
	}
	
	public void clickInboundLink(){
		getElement(lnkInbound).click();
	}
	
	public void clickOAuthLink(){
		getElement(lnkOAuth).click();
	}
	
	public void clickShow(){
		getElement(btnShow).click();
	}
}
