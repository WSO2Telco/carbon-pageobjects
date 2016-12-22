package com.wso2telco.identityserver.pageobjects;

import org.openqa.selenium.WebDriver;

import com.wso2telco.test.framework.core.WebPelement;
import com.wso2telco.test.framework.util.UIType;

public class UserProfile extends BasicPageObject  {
	
		private WebPelement txtPin = defineEelement(UIType.ID, "http://wso2.org/claims/pin");	
		private WebPelement btnUpdate = defineEelement(UIType.Name, "updateprofile");	
		private WebPelement txtLOA = defineEelement(UIType.Xpath, "//td[contains(text(),'LOA')]/following-sibling::td/input");
		
		
		
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
	
	public boolean isLOAValue(String loa) throws Exception {
		flag = false;
		logInstruction("Verifying LOA value");
		try {
			if (loa.contains(getElement(txtLOA).getAttribute("value"))) {
				flag = true;
				logInstruction("Verified LOA value is matched");
			} else {
				logInstruction("Verified LOA value is not matched");
			}
		} catch (Exception e) {
			logInstruction("Exception While Verifying LOA value 'isLOAValue()'"
					+ e.getMessage());
			throw new Exception(
					"Exception While Verifying LOA value 'isLOAValue()'"
							+ e.getLocalizedMessage());
		}
		return flag;
	}

}
