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
	
	public boolean isAssignRolesPage(String lblText) throws Exception{
		flag = false;
		logger.debug("Validating Assign role page");
		try {
			if (getElement(lblUnassignedRoles).getText().trim().equalsIgnoreCase(lblText)){
				flag = true;
				logger.debug("Assign role page load properly");
			} else {
				logger.debug("Assign role page not load properly");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating Assign role page 'isAssignRolesPage()'" + e.getMessage());
			throw new Exception("Exception While Validating Assign role page 'isAssignRolesPage()'" + e.getLocalizedMessage());
		}
		return flag;
	}
	
	public void enterRoleNamePattern(String role){
		getElement(txtRoleNamePattern).clearAndSendkeys(role);
	}
	
	public void clickRoleSearch(){
		getElement(btnRoleSearch).click();
	}
	
	public boolean isRolesSearchArea(String role) throws Exception{
		flag = false;
		logger.debug("Validating Role search area");
		String xpath = "//td/label[text()[contains(.,'" + role + "')]]";
		WebPelement lblRole = defineEelement(UIType.Xpath, xpath);
		try {
			if (getElement(lblRole).getText().trim().equalsIgnoreCase(role)){
				flag = true;
				logger.debug("Role search is working as expected");
			} else {
				logger.debug("Role search is not working as expected");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating Role search 'isRolesSearchArea()'" + e.getMessage());
			throw new Exception("Exception While Validating Role search 'isRolesSearchArea()'" + e.getLocalizedMessage());
		}
		return flag;
	}
	
	public void clickRolesPermission(String roleName) throws InterruptedException{
		String xpath = "//tr/td/label[text()[contains(.,'" + roleName + "')]]/../../td[2]/a[text()[contains(.,'Permissions')]]";
		WebPelement lnkPermission = defineEelement(UIType.Xpath, xpath);
		Thread.sleep(5000);
		getElement(lnkPermission).click();
	}
	
	public boolean isRolePermissionPage(String lblText) throws Exception{
		flag = false;
		logger.debug("Validating Role permission page");
		try {
			if (getElement(lblRolePermission).getText().trim().contains(lblText)){
				flag = true;
				logger.debug("Role permission page load properly");
			} else {
				logger.debug("Role permission page not load properly");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating Role permission page 'isRolePermissionPage()'" + e.getMessage());
			throw new Exception("Exception While Validating Role permission page 'isRolePermissionPage()'" + e.getLocalizedMessage());
		}
		return flag;
	}
	
	public boolean isPublisherRoleChecked() throws Exception{
		flag = false;
		logger.debug("Validating Publisher role checked");
		try {
			if (getElement(chkPublisherRole).getAttribute("class").equalsIgnoreCase(permissionCheckBoxClass)){
				flag = true;
				logger.debug("Publisher role ticked");
			} else {
				logger.debug("Publisher role unticked");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating Publisher role 'isPublisherRoleChecked()'" + e.getMessage());
			throw new Exception("Exception While Validating Publisher role 'isPublisherRoleChecked()'" + e.getLocalizedMessage());
		}
		return flag;
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
	
	public boolean isRoleAssignUpdate(String message) throws Exception{
		flag = false;
		logger.debug("Validating Role assign update");
		Thread.sleep(5000);
		try {
			if (getElement(lblRoleUpdateMsg).getText().trim().contains(message)){
				flag = true;
				logger.debug("Role assign update success");
			} else {
				logger.debug("Role assign update unsuccess");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating Role assign update 'isRoleAssignUpdate()'" + e.getMessage());
			throw new Exception("Exception While Validating Role assign update 'isRoleAssignUpdate()'" + e.getLocalizedMessage());
		}
		return flag;
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
	
	public boolean isPublisherRole() throws Exception{
		flag = false;
		logger.debug("Validating publisher role asign");
		int count = driver.findElements(By.xpath("//td/label[text()[contains(.,'Internal/publisher')]]")).size();
		try {
			if (count != 0){
				flag = true;
				logger.debug("Pblisher role is assigned");
			} else {
				logger.debug("Pblisher role is unsigned");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating Pblisher role is assigned 'isPublisherRole()'" + e.getMessage());
			throw new Exception("Exception While Validating Pblisher role is assigned 'isPublisherRole()'" + e.getLocalizedMessage());
		}
		return flag;
	}
	
	public void untickInternalPublisher(){
		if (getElement(chkbxIntenalPublisher).isSelected()){
			getElement(chkbxIntenalPublisher).click();
		}
	}
	
	public boolean isInternalSubscriber() throws Exception{
		flag = false;
		logger.debug("Validating subscriber role asign");
		int count = driver.findElements(By.xpath("//td/label[text()[contains(.,'Internal/subscriber')]]")).size();
		try {
			if (count != 0){
				flag = true;
				logger.debug("Subscriber role is assigned");
			} else {
				logger.debug("Subscriber role is unsigned");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating Subscriber role is assigned 'isInternalSubscriber()'" + e.getMessage());
			throw new Exception("Exception While Validating Subscriber role is assigned 'isInternalSubscriber()'" + e.getLocalizedMessage());
		}
		return flag;
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
