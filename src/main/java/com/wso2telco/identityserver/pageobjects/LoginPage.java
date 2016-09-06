package com.wso2telco.identityserver.pageobjects;

import org.openqa.selenium.WebDriver;

import com.wso2telco.test.framework.core.WebPelement;
import com.wso2telco.test.framework.util.UIType;

public class LoginPage extends BasicPageObject 
{
	private WebPelement txtUsername = defineEelement(UIType.ID, "txtUserName");
	private WebPelement txtPassword = defineEelement(UIType.ID, "txtPassword");
	private WebPelement btnSignIn = defineEelement(UIType.Css, ".button");
	
	
	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public LandingPage clickSignIn(String userName, String password){
		getElement(txtUsername).sendKeys(userName);
		getElement(txtPassword).sendKeys(password);
		getElement(btnSignIn).click();
		return new LandingPage(driver);	
		
	}
	
	
}
