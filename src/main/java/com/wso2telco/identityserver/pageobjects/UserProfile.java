package com.wso2telco.identityserver.pageobjects;

import org.openqa.selenium.WebDriver;

import com.wso2telco.test.framework.core.WebPelement;
import com.wso2telco.test.framework.util.UIType;

public class UserProfile extends BasicPageObject  {
	
		private WebPelement txtPin = defineEelement(UIType.ID, "http://wso2.org/claims/pin");	
		private WebPelement btnUpdate = defineEelement(UIType.Name, "updateprofile");	
		
		
	public UserProfile(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void sendPin(String pin){
		getElement(txtPin).sendKeys(pin);		
	}
	
	
	public void clickUpdate(){
		getElement(btnUpdate).click();		
	}
	

}
