package com.wso2telco.identityserver.pageobjects.carbon;


import org.openqa.selenium.WebDriver;

import com.wso2telco.identityserver.pageobjects.BasicPageObject;
import com.wso2telco.test.framework.core.WebPelement;
import com.wso2telco.test.framework.util.UIType;

public class CarbonLoginPage extends BasicPageObject {
	
	
	
	private WebPelement txtCarbonUsername = defineEelement(UIType.ID, "txtUserName");
	
	private WebPelement txtCarbonPassword = defineEelement(UIType.ID, "txtPassword");
	
	private WebPelement btnLogin = defineEelement(UIType.Xpath, "//input[@value='Sign-in']");
	
	
	
	public CarbonLoginPage(WebDriver driver) {
		super(driver);
	}
	
	public void setCarbonUsername(String username){
		getElement(txtCarbonUsername).clearAndSendkeys(username);
	}
	
	public void setCarbonPassword(String password){
		getElement(txtCarbonPassword).clearAndSendkeys(password);
	}
	
	public CarbonHomePage clickCarbonLogin(){
		getElement(btnLogin).click();
		return new CarbonHomePage(driver);
	}


}
