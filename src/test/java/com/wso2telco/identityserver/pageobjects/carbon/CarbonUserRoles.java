package com.wso2telco.identityserver.pageobjects.carbon;

import java.util.ArrayList;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.wso2telco.identityserver.pageobjects.BasicPageObject;
import com.wso2telco.test.framework.core.WebPelement;
import com.wso2telco.test.framework.util.UIType;

/**
 * The Class CarbonUserRoles.
 */
public class CarbonUserRoles extends BasicPageObject {
	
	/** The logger. */
	Logger logger = Logger.getLogger(CarbonUserRoles.class);
	
	/** The lnk user roles. */
	private WebPelement lnkUserRoles = defineEelement(UIType.Xpath, "//a[@href='../userstore/index.jsp?region=region1&item=userstores_menu']");
	
	/** The lnk users. */
	private WebPelement lnkUsers = defineEelement(UIType.Xpath, "//td/a[text()[contains(.,'Users')]]");
	
	/** The lbl system user store. */
	private WebPelement lblSystemUserStore = defineEelement(UIType.Xpath, "//table[@id='internal']/..//tr/th");
	
	/** The lbl users page. */
	private WebPelement lblUsersPage = defineEelement(UIType.Xpath, "//div[@id='middle']/h2");
	
	/** The txt user search. */
	private WebPelement txtUserSearch = defineEelement(UIType.Xpath, "//td[text()[contains(.,'Enter user name pattern (* for all)')]]/../td/input[@type='text']");
	
	/** The btn user search. */
	private WebPelement btnUserSearch = defineEelement(UIType.Xpath, "//td[text()[contains(.,'Enter user name pattern (* for all)')]]/../td/input[@type='submit']");

	/** The lnk roles. */
	private WebPelement lnkRoles = defineEelement(UIType.Xpath, "//td/a[text()[contains(.,'Roles')]]");
	
	/** The lbl unassigned roles. */
	private WebPelement lblUnassignedRoles = defineEelement(UIType.Xpath, "//th[text()[contains(.,'Unassigned Roles')]]");
	
	/** The txt role name pattern. */
	private WebPelement txtRoleNamePattern = defineEelement(UIType.Xpath, "//td/input[@type='text']");
	
	/** The btn role search. */
	private WebPelement btnRoleSearch = defineEelement(UIType.Xpath, "//td/input[@type='submit']");
	
	/** The lbl role permission. */
	private WebPelement lblRolePermission = defineEelement(UIType.Xpath, "//div[@id='middle']/h2");
	
	/** The chk publisher role. */
	private WebPelement chkPublisherRole = defineEelement(UIType.ID, "ygtvcheck132");
	
	/** The chk create role. */
	private WebPelement chkCreateRole = defineEelement(UIType.ID, "ygtvcheck133");
	
	/** The btn update. */
	private WebPelement btnUpdate = defineEelement(UIType.Xpath, "//input[@value='Update']");
	
	/** The lbl role update msg. */
	private WebPelement lblRoleUpdateMsg = defineEelement(UIType.Xpath, "//div[@id='messagebox-info']/p");
	
	/** The btn success ok. */
	private WebPelement btnSuccessOk = defineEelement(UIType.Xpath, "//button[text()[contains(.,'OK')]]");
	
	/** The btn finish. */
	private WebPelement btnFinish = defineEelement(UIType.Xpath, "//td/input[@value='Finish']");
	
	/** The btn users view roles. */
	private WebPelement btnUsersViewRoles = defineEelement(UIType.Xpath, "//td/a[text()[contains(.,'View Roles')]]");
	
	/** The chkbx intenal publisher. */
	private WebPelement chkbxIntenalPublisher = defineEelement(UIType.Xpath, "//td/label[text()[contains(.,'Internal/publisher')]]/input");
	
	/** The chkbx intenal subscriber. */
	private WebPelement chkbxIntenalSubscriber = defineEelement(UIType.Xpath, "//td/label[text()[contains(.,'Internal/subscriber')]]/input");
	
	/** The btn users edit roles finish. */
	private WebPelement btnUsersEditRolesFinish = defineEelement(UIType.Xpath, "//td/input[@value='Finish']");
	
	/** The btn users edit roles cancel. */
	private WebPelement btnUsersEditRolesCancel = defineEelement(UIType.Xpath, "//td/input[@value='Cancel']");
	
	/** The btn edit role success ok. */
	private WebPelement btnEditRoleSuccessOk = defineEelement(UIType.Xpath, "//div/button[text()[contains(.,'OK')]]");
	
	/** The permission check box class. */
	private String permissionCheckBoxClass = "ygtvcheck2";

	/** The lbl publisher. */
	private String lblPublisher = "//td/label[text()[contains(.,'Internal/publisher')]]";
	
	/** The lbl subscriber. */
	private String lblSubscriber = "//td/label[text()[contains(.,'Internal/subscriber')]]";
	
	/** The lbl user search. 
	 * %s_1 = username
	 **/
	private String lblUserSearch = "//td[text()[contains(.,'%s')]]";
	
	/** The lnk assign role. 
	 * %s_1 = username
	 **/
	private String lnkAssignRole = "//td[text()[contains(.,'%s')]]/../td[2]/a[text()[contains(.,'Assign Roles')]]";
	
	/** The lbl name role. 
	 * %s_1 = Role
	 **/
	private String lblNameRole = "//td/label[text()[contains(.,'%s')]]";
	
	/** The lnk permission. 
	 * %s_1 = roleName
	 **/
	private String lnkPermission = "//tr/td/label[text()[contains(.,'%s')]]/../../td[2]/a[text()[contains(.,'Permissions')]]";
	
	/** The chk role. 
	 * %s_1 = role
	 **/
	private String chkRole = "//td/label[text()[contains(.,'%s')]]/input[@type='checkbox']";
	
	/**
	 * Instantiates a new carbon user roles.
	 *
	 * @author SulakkhanaW
	 * @param driver the driver
	 */
	public CarbonUserRoles(WebDriver driver) {
		super(driver);
	}
	
	/**
	 * Checks if is configure page.
	 *
	 * @author SulakkhanaW
	 * @param lblText the lbl text
	 * @return true, if is configure page
	 * @throws Exception the exception
	 */
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
	
	/**
	 * Click user roles.
	 *
	 * @author SulakkhanaW
	 */
	public void clickUserRoles(){
		logger.debug("Clicking on user roles");
		getElement(lnkUserRoles).click();
		logger.debug("Clicked on user roles");
	}
	
	/**
	 * Click users link.
	 *
	 * @author SulakkhanaW
	 */
	public void clickUsersLink(){
		logger.debug("Clicking on user link");
		getElement(lnkUsers).click();
		logger.debug("Clicked on user link");
	}

	/**
	 * Checks if is system user store.
	 *
	 * @author SulakkhanaW
	 * @param lblText the lbl text
	 * @return true, if is system user store
	 * @throws Exception the exception
	 */
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
	
	/**
	 * Checks if is user page.
	 *
	 * @author SulakkhanaW
	 * @param lblText the lbl text
	 * @return true, if is user page
	 * @throws Exception the exception
	 */
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
	
	/**
	 * Sets the search criteria.
	 *
	 * @author SulakkhanaW
	 * @param username the new search criteria
	 */
	public void setSearchCriteria(String username){
		logger.debug("Entering search criteria");
		getElement(txtUserSearch).clearAndSendkeys(username);
		logger.debug("Entered search criteria");
	}
	
	/**
	 * Click user search button.
	 *
	 * @author SulakkhanaW
	 */
	public void clickUserSearchButton(){
		logger.debug("Clicking on user search button");
		getElement(btnUserSearch).click();
		logger.debug("Clicked on user search button");
	}
	
	/**
	 * Click roles link.
	 *
	 * @author SulakkhanaW
	 */
	public void clickRolesLink(){
		logger.debug("Clicking on Roles link");
		getElement(lnkRoles).click();
		logger.debug("Clicked on Roles link");
	}
	
	/**
	 * Checks if is user search.
	 *
	 * @author SulakkhanaW
	 * @param username the username
	 * @return true, if is user search
	 * @throws Exception the exception
	 */
	public boolean isUserSearch(String username) throws Exception {
		flag = false;
		logger.debug("Validating user search function");
		String xpath = String.format(lblUserSearch, username);
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
	
	/**
	 * Click assign roles.
	 *
	 * @author SulakkhanaW
	 * @param username the username
	 */
	public void clickAssignRoles(String username){
		String xpath = String.format(lnkAssignRole, username);
		WebPelement lnkAssignRoles = defineEelement(UIType.Xpath, xpath);
		logger.debug("Clicking on Assign roles");
		getElement(lnkAssignRoles).click();
		logger.debug("Clicked on Assign roles");
	}
	
	/**
	 * Checks if is assign roles page.
	 *
	 * @author SulakkhanaW
	 * @param lblText the lbl text
	 * @return true, if is assign roles page
	 * @throws Exception the exception
	 */
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
	
	/**
	 * Enter role name pattern.
	 *
	 * @author SulakkhanaW
	 * @param role the role
	 */
	public void enterRoleNamePattern(String role){
		logger.debug("Entering role name pattern");
		getElement(txtRoleNamePattern).clearAndSendkeys(role);
		logger.debug("Entered role name pattern");
	}
	
	/**
	 * Click role search.
	 *
	 * @author SulakkhanaW
	 */
	public void clickRoleSearch(){
		
		String parent =driver.getWindowHandle();
		
		logger.debug("Clicking on role search");
		getElement(btnRoleSearch).click();
		logger.debug("Clicked on role search");
		
		Set<String> winhandles = driver.getWindowHandles();
		
		if(winhandles.size()>2){
			
			ArrayList<String> elements = new ArrayList<>();
			
			for(String handle : winhandles){
				
				elements.add(handle);
				
			}
			
			if(elements.contains(parent)){
				
				elements.remove((elements.indexOf(parent)));
			}
			
			
		}else if (driver.findElement(By.xpath("//*[@id='messagebox-info']/p")).isDisplayed()){
			
			driver.findElement(By.xpath("html/body/div[3]/div[2]/button")).click();
		}
		
		
		
	}
	
	/**
	 * Checks if is roles search area.
	 *
	 * @author SulakkhanaW
	 * @param role the role
	 * @return true, if is roles search area
	 * @throws Exception the exception
	 */
	public boolean isRolesSearchArea(String role) throws Exception{
		flag = false;
		logger.debug("Validating Role search area");
		String xpath = String.format(lblNameRole, role);
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
	
	/**
	 * Click roles permission.
	 *
	 * @author SulakkhanaW
	 * @param roleName the role name
	 * @throws InterruptedException the interrupted exception
	 */
	public void clickRolesPermission(String roleName) throws InterruptedException{
		String xpath = String.format(lnkPermission, roleName);
		WebPelement lnkPermission = defineEelement(UIType.Xpath, xpath);
		Thread.sleep(sleepTime);
		logger.debug("Clicking on role permission");
		getElement(lnkPermission).click();
		logger.debug("Clicked on role permission");
	}
	
	/**
	 * Checks if is role permission page.
	 *
	 * @author SulakkhanaW
	 * @param lblText the lbl text
	 * @return true, if is role permission page
	 * @throws Exception the exception
	 */
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
	
	/**
	 * Checks if is publisher role checked.
	 *
	 * @author SulakkhanaW
	 * @return true, if is publisher role checked
	 * @throws Exception the exception
	 */
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
	
	/**
	 * Click create permission.
	 *
	 * @author SulakkhanaW
	 * @throws Exception the exception
	 */
	public void clickCreatePermission() throws Exception{
		String chkCreateClass = getElement(chkCreateRole).getAttribute("class");
		try {
			logger.debug("Validating create permission is selected");
			if (!(chkCreateClass.equalsIgnoreCase(permissionCheckBoxClass))){
				logger.debug("Create permission is not selected");
				logger.debug("Seleting Create permission");
				getElement(chkCreateRole).click();
				logger.debug("Seleted Create permission");
			}logger.debug("Seleting Create permission");
		} catch (Exception e) {
			logger.debug("Exception While Validating Publisher role 'clickCreatePermission()'" + e.getMessage());
			throw new Exception("Exception While Validating Publisher role 'clickCreatePermission()'" + e.getLocalizedMessage());
		}
	}
	
	/**
	 * Click update.
	 *
	 * @author SulakkhanaW
	 */
	public void clickUpdate(){
		logger.debug("Clicking on update");
		getElement(btnUpdate).click();
		logger.debug("Clicked on update");
	}
	
	/**
	 * Checks if is role assign update.
	 *
	 * @author SulakkhanaW
	 * @param message the message
	 * @return true, if is role assign update
	 * @throws Exception the exception
	 */
	public boolean isRoleAssignUpdate(String message) throws Exception{
		flag = false;
		logger.debug("Validating Role assign update");
		Thread.sleep(sleepTime);
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
	
	/**
	 * Click ok.
	 *
	 * @author SulakkhanaW
	 */
	public void clickOK(){
		logger.debug("Clicking on OK");
		getElement(btnSuccessOk).click();
		logger.debug("Clicked on update");
	}
	
	/**
	 * Click roles search area.
	 *
	 * @author SulakkhanaW
	 * @param role the role
	 */
	public void clickRolesSearchArea(String role){
		String xpath = String.format(chkRole, role);
		WebPelement chkRole = defineEelement(UIType.Xpath, xpath);
		logger.debug("Clicking on Role search area");
		getElement(chkRole).click();
		logger.debug("Clicked on Role search area");
	}
	
	/**
	 * Click finish.
	 *
	 * @author SulakkhanaW
	 */
	public void clickFinish(){
		logger.debug("Clicking on Finish");
		getElement(btnFinish).click();
		logger.debug("Clicked on finished");
	}
	
	/**
	 * Click users view roles.
	 *
	 * @author SulakkhanaW
	 */
	public void clickUsersViewRoles(){
		logger.debug("Clicking on Users view roles");
		getElement(btnUsersViewRoles).click();
		logger.debug("Clicked on Users view roles");
	}
	
	/**
	 * Checks if is publisher role.
	 *
	 * @author SulakkhanaW
	 * @return true, if is publisher role
	 * @throws Exception the exception
	 */
	public boolean isPublisherRole() throws Exception{
		flag = false;
		logger.debug("Validating publisher role asign");
		int count = verifyListContent(UIType.Xpath, lblPublisher).size();
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
	
	/**
	 * Untick internal publisher.
	 *
	 * @author SulakkhanaW
	 * @throws Exception the exception
	 */
	public void untickInternalPublisher() throws Exception{
		try {
			logger.debug("Validating untick internal publisher role");
			if (getElement(chkbxIntenalPublisher).isSelected()){
				logger.debug("Internal publisher role is selected");
				logger.debug("Unticking Internal publisher role");
				getElement(chkbxIntenalPublisher).click();
				logger.debug("Internal publisher role is not selected");
			}
			logger.debug("Internal publisher role is not selected");
		} catch (Exception e) {
			logger.debug("Exception While untick internal publisher role 'untickInternalPublisher()'" + e.getMessage());
			throw new Exception("Exception While untick internal publisher role 'untickInternalPublisher()'" + e.getLocalizedMessage());
		}
	}
	
	/**
	 * Checks if is internal subscriber.
	 *
	 * @author SulakkhanaW
	 * @return true, if is internal subscriber
	 * @throws Exception the exception
	 */
	public boolean isInternalSubscriber() throws Exception{
		flag = false;
		logger.debug("Validating subscriber role asign");
		int count = verifyListContent(UIType.Xpath, lblSubscriber).size();
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
	
	/**
	 * Untick internal subscriber.
	 *
	 * @author SulakkhanaW
	 * @throws Exception the exception
	 */
	public void untickInternalSubscriber() throws Exception{
		try {
			logger.debug("Validating untick internal subscriber role");
			if (getElement(chkbxIntenalSubscriber).isSelected()){
				logger.debug("Internal subscriber role is selected");
				logger.debug("Unticking Internal subscriber role");
				getElement(chkbxIntenalSubscriber).click();
				logger.debug("Internal subscriber role is not selected");
			}
			logger.debug("Internal subscriber role is not selected");
		} catch (Exception e) {
			logger.debug("Exception While untick internal subscriber role 'untickInternalSubscriber()'" + e.getMessage());
			throw new Exception("Exception While untick internal subscriber role 'untickInternalSubscriber()'" + e.getLocalizedMessage());
		}
	}
	
	/**
	 * Click edit roles finish.
	 *
	 * @author SulakkhanaW
	 */
	public void clickEditRolesFinish(){
		logger.debug("Clicking edit roles finish");
		getElement(btnUsersEditRolesFinish).click();
		logger.debug("Clicked edit roles finish");
	}
	
	/**
	 * Click edit roles cancel.
	 *
	 * @author SulakkhanaW
	 */
	public void clickEditRolesCancel(){
		logger.debug("Clicking edit roles cancel");
		getElement(btnUsersEditRolesCancel).click();
		logger.debug("Clicked edit roles cancel");
	}
	
	/**
	 * Click edit roles success msg ok.
	 *
	 * @author SulakkhanaW
	 */
	public void clickEditRolesSuccessMsgOk(){
		logger.debug("Clicking edit roles success message");
		getElement(btnEditRoleSuccessOk).click();
		logger.debug("Clicked edit roles success message");
	}

}
