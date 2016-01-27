package com.wso2telco.identityserver.pageobjects.carbon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.wso2telco.identityserver.pageobjects.BasicPageObject;
import com.wso2telco.test.framework.core.WebPelement;
import com.wso2telco.test.framework.util.UIType;

public class CarbonRolesPage extends BasicPageObject {

	private WebPelement lblRoles = defineEelement(UIType.Xpath, "//div[@id='middle']/h2");
	
	private WebPelement lnkAddRole = defineEelement(UIType.Xpath, "//a[text()[contains(.,'Add New Role')]]");
	
	private WebPelement lblAddRole = defineEelement(UIType.Xpath, "//div[@id='workArea']/h3");
	
	private WebPelement txtRoleName = defineEelement(UIType.Xpath, "//input[@name='roleName']");
	
	private WebPelement btnNext = defineEelement(UIType.Xpath, "//input[@value='Next >']");
	
	private WebPelement lblSelectPermission = defineEelement(UIType.Xpath, "//div[@id='workArea']/h3");
	
	private WebPelement lblSelectUsers = defineEelement(UIType.Xpath, "//div[@id='workArea']/h3");
	
	private WebPelement txtSearch = defineEelement(UIType.Xpath, "//input[@name='org.wso2.carbon.role.assign.filter']");
	
	private WebPelement btnSearch = defineEelement(UIType.Xpath, "//input[@value='Search']");
	
	private WebPelement btnFinish = defineEelement(UIType.Xpath, "//input[@value='Finish']");
	
	private WebPelement popUpSuccess = defineEelement(UIType.Xpath, "//div[@id='messagebox-info']");
	
	private WebPelement lblAggrigator = defineEelement(UIType.Xpath, "//td[contains(text(),'aggrigator')]");
	
	private WebPelement lnkDeleteAggrigator = defineEelement(UIType.Xpath, "//table[@id='roleTable']/tbody/tr/td[2]/a[5]");
	
	private WebPelement btnYes = defineEelement(UIType.Xpath, "//div[@class='ui-dialog-buttonpane']/button[1]");
	
	private WebPelement txtSearchRole = defineEelement(UIType.Xpath, "//input[@name='org.wso2.carbon.role.filter']");
	
	private WebPelement popUpInfo = defineEelement(UIType.Xpath, "//div[@id='messagebox-info']");
	
	private WebPelement btnOK = defineEelement(UIType.Xpath, "//button[contains(text(),'OK')]");
	 
	
	public CarbonRolesPage(WebDriver driver) {
		super(driver);
	}

	public boolean validateRoles(){
		return getElement(lblRoles).getText().equalsIgnoreCase("Roles");
	}
	
	public void clickAddNewRole(){
		getElement(lnkAddRole).click();
	}
	
	public boolean validateAddRoles(){
		return getElement(lblAddRole).getText().equalsIgnoreCase("Step 1 : Enter role details");
	}
	
	public void enterRoleName(String rolename){
		getElement(txtRoleName).clearAndSendkeys(rolename);
	}
	
	public void clickNext(){
		getElement(btnNext).click();
	}
	
	public boolean validateSelectPermission(){
		return getElement(lblSelectPermission).getText().equalsIgnoreCase("Step 2 : Select permissions to add to Role");
	}
	
	public boolean validateSelectUsers(){
		return getElement(lblSelectUsers).getText().equalsIgnoreCase("Step 3 : Select users to add to Role");
	}
	
	public void eneterSearchValue(String searchvalue){
		getElement(txtSearch).clearAndSendkeys(searchvalue);
	}
	
	public void clickSearch(){
		getElement(btnSearch).click();
	}
	
	public void selectUser(String username1){
		String xpath = "//input[@value='" + username1 + "' and @type='checkbox']";
		WebPelement btnUser =defineEelement(UIType.Xpath, xpath);
		getElement(btnUser).click();
	}
	
	public void clickFinish(){
		getElement(btnFinish).click();
	}
	
	public boolean validateSuccessPopup(){
		return getElement(popUpSuccess).getText().equalsIgnoreCase("Role PRIMARY/aggrigator is added successfully.");
	}
	
	public boolean validateAggrigatorRole(){
		return getElement(lblAggrigator).getText().trim().equalsIgnoreCase("aggrigator");
	}
	
	public void clickDelete(){
		getElement(lnkDeleteAggrigator).click();
	}
	
	public void clickYes(){
		getElement(btnYes).click();
	}
	
	public void enterAggrigatorRoleName(String rolename){
		getElement(txtSearchRole).clearAndSendkeys(rolename);
	}
	
	public boolean validateNoResultPopUp(){
		return getElement(popUpInfo).getText().equalsIgnoreCase("No matching roles found");
	}
	
	public void clickOK(){
		getElement(btnOK).click();
	}

	public boolean validateRoleTable(){
		int count = driver.findElements(By.xpath("//a[text()[contains(.,'Rename')]]")).size();
		return (count != 0);
	}
}
