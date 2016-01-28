package com.wso2telco.identityserver.pageobjects.carbon;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.wso2telco.identityserver.pageobjects.BasicPageObject;
import com.wso2telco.test.framework.core.WebPelement;
import com.wso2telco.test.framework.util.UIType;

public class CarbonRolesPage extends BasicPageObject {
	
	Logger logger = Logger.getLogger(CarbonRolesPage.class);

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
	
	private WebPelement lnkDeleteAggrigator = defineEelement(UIType.Xpath, "//table[@id='roleTable']/tbody/tr/td[2]/a[5]");
	
	private WebPelement btnYes = defineEelement(UIType.Xpath, "//div[@class='ui-dialog-buttonpane']/button[1]");
	
	private WebPelement txtSearchRole = defineEelement(UIType.Xpath, "//input[@name='org.wso2.carbon.role.filter']");
	
	private WebPelement btnOK = defineEelement(UIType.Xpath, "//button[contains(text(),'OK')]");
	 
	
	public CarbonRolesPage(WebDriver driver) {
		super(driver);
	}

	public boolean isRolePage(String role) throws Exception{
		flag = false;
		logger.debug("Validating Role page");
		try {
			if (getElement(lblRoles).getText().equalsIgnoreCase(role)){
				flag = true;
				logger.debug("Role page loaded properly");
			} else {
				logger.debug("Role page not loaded properly");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating Role page 'isRolePage()'" + e.getMessage());
			throw new Exception("Exception While Validating Role page 'isRolePage()'" + e.getLocalizedMessage());
		}
		return flag;
	}
	
	public void clickAddNewRole(){
		getElement(lnkAddRole).click();
	}
	
	public boolean isAddRolesPage(String lblText) throws Exception{
		flag = false;
		logger.debug("Validating Add Role page");
		try {
			if (getElement(lblAddRole).getText().equalsIgnoreCase(lblText)){
				flag = true;
				logger.debug("Add Role page loaded properly");
			} else {
				logger.debug("Add Role page not loaded properly");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating Add Role page 'isAddRolesPage()'" + e.getMessage());
			throw new Exception("Exception While Validating Add Role page 'isAddRolesPage()'" + e.getLocalizedMessage());
		}
		return flag;
	}
	
	public void enterRoleName(String rolename){
		getElement(txtRoleName).clearAndSendkeys(rolename);
	}
	
	public void clickNext(){
		getElement(btnNext).click();
	}
	
	public boolean isSelectPermission(String lblText) throws Exception{
		flag = false;
		logger.debug("Validating select permission page");
		try {
			if (getElement(lblSelectPermission).getText().equalsIgnoreCase(lblText)){
				flag = true;
				logger.debug("Select permission page loaded properly");
			} else {
				logger.debug("Select permission page not loaded properly");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating Select permission page 'isSelectPermission()'" + e.getMessage());
			throw new Exception("Exception While Validating Select permission page 'isSelectPermission()'" + e.getLocalizedMessage());
		}
		return flag;
	}
	
	public boolean isSelectUsers(String lblText) throws Exception{
		flag = false;
		logger.debug("Validating Select user page");
		try {
			if (getElement(lblSelectUsers).getText().equalsIgnoreCase(lblText)){
				flag = true;
				logger.debug("Select user page loaded properly");
			} else {
				logger.debug("Select user page not loaded properly");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating Select user page 'isSelectUsers()'" + e.getMessage());
			throw new Exception("Exception While Validating Select user page 'isSelectUsers()'" + e.getLocalizedMessage());
		}
		return flag;
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
	
	public boolean isSuccessPopup(String msg) throws Exception{
		flag = false;
		logger.debug("Validating Success popup");
		try {
			if (getElement(popUpSuccess).getText().equalsIgnoreCase(msg)){
				flag = true;
				logger.debug("Success popup load properly");
			} else {
				logger.debug("Success popup not load properly");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating Success popup 'isSuccessPopup()'" + e.getMessage());
			throw new Exception("Exception While Validating Success popup 'isSuccessPopup()'" + e.getLocalizedMessage());
		}
		return flag;
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
	
	public void clickOK(){
		getElement(btnOK).click();
	}

	public boolean isRoleVisible() throws Exception{
		flag = false;
		logger.debug("Validating user roles are visible");
		int count = driver.findElements(By.xpath("//a[text()[contains(.,'Rename')]]")).size();
		try {
			if (count != 0){
				flag = true;
				logger.debug("User roles are visible");
			} else {
				logger.debug("User roles are not visible");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating User roles are visible 'isRoleVisible()'" + e.getMessage());
			throw new Exception("Exception While Validating User roles are visible 'isRoleVisible()'" + e.getLocalizedMessage());
		}
		return flag;
	}
}
