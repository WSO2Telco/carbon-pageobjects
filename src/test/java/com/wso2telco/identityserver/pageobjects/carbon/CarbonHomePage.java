package com.wso2telco.identityserver.pageobjects.carbon;

import org.openqa.selenium.WebDriver;

import com.wso2telco.identityserver.pageobjects.BasicPageObject;
import com.wso2telco.test.framework.core.WebPelement;
import com.wso2telco.test.framework.util.UIType;

public class CarbonHomePage extends BasicPageObject {
	
	private WebPelement lnkSignout = defineEelement(UIType.Xpath, "//li[@class='right']/a");
	
	private WebPelement lblConfigure = defineEelement(UIType.Xpath, "//span[text()[contains(.,'Configure')]]");
	
	public CarbonHomePage(WebDriver driver) {
		super(driver);
	}
	
	public boolean validateSignout(String value){
		return getElement(lnkSignout).getText().equalsIgnoreCase(value);
	}
	
	public void clickConfigure(){
		getElement(lblConfigure).click();
	}

}
