package com.wso2telco.identityserver.pageobjects.carbon;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.wso2telco.identityserver.pageobjects.BasicPageObject;
import com.wso2telco.test.framework.core.WebPelement;
import com.wso2telco.test.framework.util.UIType;

public class CarbonUserRoles extends BasicPageObject {
	
	Logger logger = Logger.getLogger(CarbonUserRoles.class);
	
	private WebPelement lnkUserRoles = defineEelement(UIType.Xpath, "//a[@href='../userstore/index.jsp?region=region1&item=userstores_menu']");
	
	private WebPelement lnkUsers = defineEelement(UIType.Xpath, "//td/a[text()[contains(.,'Users')]]");
	
	private WebPelement lblSystemUserStore = defineEelement(UIType.Xpath, "//table[@id='internal']/..//tr/th");
	
	private WebPelement lblUsersPage = defineEelement(UIType.Xpath, "//div[@id='middle']/h2");
	
	private WebPelement txtUserSearch = defineEelement(UIType.Xpath, "//td[text()[contains(.,'Enter user name pattern (* for all)')]]/../td/input[@type='text']");
	
	private WebPelement btnUserSearch = defineEelement(UIType.Xpath, "//td[text()[contains(.,'Enter user name pattern (* for all)')]]/../td/input[@type='submit']");

	private WebPelement lnkRoles = defineEelement(UIType.Xpath, "//td/a[text()[contains(.,'Roles')]]");
	
	private WebPelement lblUnassignedRoles = defineEelement(UIType.Xpath, "//th[text()[contains(.,'Unassigned Roles')]]");
	
	private WebPelement txtRoleNamePattern = defineEelement(UIType.Xpath, "//td/input[@type='text']");
	
	private WebPelement btnRoleSearch = defineEelement(UIType.Xpath, "//td/input[@type='submit']");
	
	private WebPelement lblRolePermission = defineEelement(UIType.Xpath, "//div[@id='middle']/h2");
	
	private WebPelement chkPublisherRole = defineEelement(UIType.Xpath, "//td[@id='ygtvcheck132']");
	
	private WebPelement chkCreateRole = defineEelement(UIType.Xpath, "//td[@id='ygtvcheck133']");
	
	private WebPelement btnUpdate = defineEelement(UIType.Xpath, "//input[@value='Update']");
	
	private WebPelement lblRoleUpdateMsg = defineEelement(UIType.Xpath, "//div[@id='messagebox-info']/p");
	
	private WebPelement btnSuccessOk = defineEelement(UIType.Xpath, "//button[text()[contains(.,'OK')]]");
	
	private WebPelement btnFinish = defineEelement(UIType.Xpath, "//td/input[@value='Finish']");
	
	private WebPelement btnUsersViewRoles = defineEelement(UIType.Xpath, "//td/a[text()[contains(.,'View Roles')]]");
	
	private WebPelement chkbxIntenalPublisher = defineEelement(UIType.Xpath, "//td/label[text()[contains(.,'Internal/publisher')]]/input");
	
	private WebPelement chkbxIntenalSubscriber = defineEelement(UIType.Xpath, "//td/label[text()[contains(.,'Internal/subscriber')]]/input");
	
	private WebPelement btnUsersEditRolesFinish = defineEelement(UIType.Xpath, "//td/input[@value='Finish']");
	
	private WebPelement btnUsersEditRolesCancel = defineEelement(UIType.Xpath, "//td/input[@value='Cancel']");
	
	private WebPelement btnEditRoleSuccessOk = defineEelement(UIType.Xpath, "//div/button[text()[contains(.,'OK')]]");
	
	private String permissionCheckBoxClass = "ygtvcheck2";
	
	public CarbonUserRoles(WebDriver driver) {
		super(driver);
	}
	
	public boolean isConfigurePage(String lblText) throws Exception{
		flag = false;
		logger.debug("Validating configure page");
		try {
			if (getElement(lnkUserRoles).getText().equalsIgnoreCase(lblText)){
				flag = true;
				logger.debug("Configure page load properly");
			} else {
				logger.debug("Configure page not load properly");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating Configure page'isConfigurePage()'" + e.getMessage());
			throw new Exception("Exception While Validating Configure page 'isConfigurePage()'" + e.getLocalizedMessage());
		}
		return flag;
	}
	
	public void clickUserRoles(){
		getElement(lnkUserRoles).click();
	}
	
	public void clickUsersLink(){
		getElement(lnkUsers).click();
	}

	public boolean isSystemUserStore(String lblText) throws Exception{
		flag = false;
		logger.debug("Validating system user store");
		try {
			if (getElement(lblSystemUserStore).getText().equalsIgnoreCase(lblText)){
				flag = true;
				logger.debug("system user store load properly");
			} else {
				logger.debug("system user store not load properly");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating system user store page'isConfigurePage()'" + e.getMessage());
			throw new Exception("Exception While Validating system user store page 'isConfigurePage()'" + e.getLocalizedMessage());
		}
		return  flag;
	}
	
	public boolean isUserPage(String lblText) throws Exception{
		flag = false;
		logger.debug("Validating user page");
		try {
			if (getElement(lblUsersPage).getText().trim().contains(lblText)){
				flag = true;
				logger.debug("User page load properly");
			} else {
				logger.debug("User page not load properly");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating User Page'isUserPage()'" + e.getMessage());
			throw new Exception("Exception While Validating User Page 'isUserPage()'" + e.getLocalizedMessage());
		}
		return flag;
	}
	
	public void setSearchCriteria(String username){
		getElement(txtUserSearch).clearAndSendkeys(username);
	}
	
	public void clickUserSearchButton(){
		getElement(btnUserSearch).click();
	}
	
	public void clickRolesLink(){
		getElement(lnkRoles).click();
	}
	
	public boolean isUserSearch(String username) throws Exception {
		flag = false;
		logger.debug("Validating user search function");
		String xpath = "//td[text()[contains(.,'" + username + "')]]";
		WebPelement lblSearchUser = defineEelement(UIType.Xpath, xpath);
		try {
			if (getElement(lblSearchUser).getText().trim().equalsIgnoreCase(username)){
				flag = true;
				logger.debug("User search fuction success");
			} else {
				logger.debug("User search fuction failed");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating user search 'isUserSearch()'" + e.getMessage());
			throw new Exception("Exception While Validating user search 'isUserSearch()'" + e.getLocalizedMessage());
		}
		return flag;
	}
	
	public void clickAssignRoles(String username){
		String xpath = "//td[text()[contains(.,'" + username + "')]]/../td[2]/a[text()[contains(.,'Assign Roles')]]";
		WebPelement lnkAssignRoles = defineEelement(UIType.Xpath, xpath);
		getElement(lnkAssignRoles).click();
	}
	
	public boolean validateAssignRolesPage(){
		return getElement(lblUnassignedRoles).getText().trim().equalsIgnoreCase("Unassigned Roles");
	}
	
	public void enterRoleNamePattern(String role){
		getElement(txtRoleNamePattern).clearAndSendkeys(role);
	}
	
	public void clickRoleSearch(){
		getElement(btnRoleSearch).click();
	}
	
	public boolean validateRolesSearchArea(String role){
		String xpath = "//td/label[text()[contains(.,'" + role + "')]]";
		WebPelement lblRole = defineEelement(UIType.Xpath, xpath);
		return getElement(lblRole).getText().trim().equalsIgnoreCase(role);
	}
	
	public void clickRolesPermission(String roleName){
		String xpath = "//tr/td/label[text()[contains(.,'" + roleName + "')]]/../../td[2]/a[text()[contains(.,'Permissions')]]";
		WebPelement lnkPermission = defineEelement(UIType.Xpath, xpath);
		lnkPermission.click();
	}
	
	public boolean validateRolePermissionPage(){
		return getElement(lblRolePermission).getText().trim().contains("Permissions of the Role");
	}
	
	public boolean validatePublisherRoleChecked(){
		return getElement(chkPublisherRole).getAttribute("class").equalsIgnoreCase(permissionCheckBoxClass);
	}
	
	public void clickCreatePermission(){
		String chkCreateClass = getElement(chkCreateRole).getAttribute("class");
		if (!(chkCreateClass.equalsIgnoreCase(permissionCheckBoxClass))){
			getElement(chkCreateRole).click();
		}
	}
	
	public void clickUpdate(){
		getElement(btnUpdate).click();
	}
	
	public boolean validateRoleAssignUpdate(String message){
		return getElement(lblRoleUpdateMsg).getText().trim().equalsIgnoreCase(message);
	}
	
	public void clickOK(){
		getElement(btnSuccessOk).click();
	}
	
	public void clickRolesSearchArea(String role){
		String xpath = "//td/label[text()[contains(.,'" + role + "')]]/input[@type='checkbox']";
		WebPelement chkRole = defineEelement(UIType.Xpath, xpath);
		getElement(chkRole).click();
	}
	
	public void clickFinish(){
		getElement(btnFinish).click();
	}
	
	public void clickUsersViewRoles(){
		getElement(btnUsersViewRoles).click();
	}
	
	public boolean validatePublisherRole(){
		int count = driver.findElements(By.xpath("//td/label[text()[contains(.,'Internal/publisher')]]")).size();
		return (count != 0);
	}
	
	public void untickInternalPublisher(){
		if (getElement(chkbxIntenalPublisher).isSelected()){
			getElement(chkbxIntenalPublisher).click();
		}
	}
	
	public boolean validateInternalSubscriber(){
		int count = driver.findElements(By.xpath("//td/label[text()[contains(.,'Internal/subscriber')]]")).size();
		return (count != 0);
	}
	
	public void untickInternalSubscriber(){
		if (getElement(chkbxIntenalSubscriber).isSelected()){
			getElement(chkbxIntenalSubscriber).click();
		}
	}
	
	public void clickEditRolesFinish(){
		getElement(btnUsersEditRolesFinish).click();
	}
	
	public void clickEditRolesCancel(){
		getElement(btnUsersEditRolesCancel).click();
	}
	
	public void clickEditRolesSuccessMsgOk(){
		getElement(btnEditRoleSuccessOk).click();
	}

}
