package com.wso2telco.identityserver.pageobjects.carbon;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.wso2telco.identityserver.pageobjects.BasicPageObject;
import com.wso2telco.test.framework.core.WebPelement;
import com.wso2telco.test.framework.util.UIType;

/**
 * The Class CarbonRolesPage.
 */
public class CarbonRolesPage extends BasicPageObject {
	
	/** The logger. */
	Logger logger = Logger.getLogger(CarbonRolesPage.class);

	/** The lbl roles. */
	private WebPelement lblRoles = defineEelement(UIType.Xpath, "//div[@id='middle']/h2");
	
	/** The lnk add role. */
	private WebPelement lnkAddRole = defineEelement(UIType.Xpath, "//a[text()[contains(.,'Add New Role')]]");
	
	/** The lbl add role. */
	private WebPelement lblAddRole = defineEelement(UIType.Xpath, "//div[@id='workArea']/h3");
	
	/** The txt role name. */
	private WebPelement txtRoleName = defineEelement(UIType.Xpath, "//input[@name='roleName']");
	
	/** The btn next. */
	private WebPelement btnNext = defineEelement(UIType.Xpath, "//input[@value='Next >']");
	
	/** The lbl select permission. */
	private WebPelement lblSelectPermission = defineEelement(UIType.Xpath, "//div[@id='workArea']/h3");
	
	/** The lbl select users. */
	private WebPelement lblSelectUsers = defineEelement(UIType.Xpath, "//div[@id='workArea']/h3");
	
	/** The txt search. */
	private WebPelement txtSearch = defineEelement(UIType.Xpath, "//input[@name='org.wso2.carbon.role.assign.filter']");
	
	/** The btn search. */
	private WebPelement btnSearch = defineEelement(UIType.Xpath, "//input[@value='Search']");
	
	/** The btn finish. */
	private WebPelement btnFinish = defineEelement(UIType.Xpath, "//input[@value='Finish']");
	
	/** The pop up success. */
	private WebPelement popUpSuccess = defineEelement(UIType.ID, "messagebox-info");
	
	/** The lnk delete aggrigator. */
	private WebPelement lnkDeleteAggrigator = defineEelement(UIType.Xpath, "//table[@id='roleTable']/tbody/tr/td[2]/a[5]");
	
	/** The btn yes. */
	private WebPelement btnYes = defineEelement(UIType.Xpath, "//div[@class='ui-dialog-buttonpane']/button[1]");
	
	/** The txt search role. */
	private WebPelement txtSearchRole = defineEelement(UIType.Xpath, "//input[@name='org.wso2.carbon.role.filter']");
	
	/** The btn ok. */
	private WebPelement btnOK = defineEelement(UIType.Xpath, "//button[contains(text(),'OK')]");
	
	/** The lnk role visible. */
	private String lnkRoleVisible = "//a[text()[contains(.,'Rename')]]";
	
	/** The lnk delete. */
	private String lnkDelete = "//a[text()[contains(.,'Delete')]]";
	
	/** The btn user. 
	 * %s_1 = username
	 **/
	private String btnUser = "//input[@value='%s' and @type='checkbox']";
	
	/** The btn delete. 
	 * %s_1 = username
	 **/
	private String btnDelete = "//td[contains(.,'%s')]/following-sibling::td[1]/a[4]"; 
	
	/** The lnk assign users. */
	private WebPelement lnkAssignUsers = defineEelement(UIType.Xpath, " //a[contains(.,'Assign Users')]");
	
	/** The txt users search. */
	private WebPelement txtUsersSearch = defineEelement(UIType.Xpath, " //td[contains(.,'Enter user name pattern')]/following-sibling::td[1]/input");
	
	/** The check box user nameto assign. */
	private String checkBoxUserNametoAssign = "//a[contains(.,'Select all on this page')]/../../following-sibling::tr[1]/td/input[@value='%s'][1]";
	
	/** The txt role search. */
	private WebPelement txtRoleSearch = defineEelement(UIType.Xpath, "//td[contains(.,'Enter role name pattern')]/following-sibling::td[1]/input[1]");
	/**
	 * Instantiates a new carbon roles page.
	 *
	 * @author SulakkhanaW
	 * @param driver the driver
	 */
	public CarbonRolesPage(WebDriver driver) {
		super(driver);
	}

	/**
	 * Checks if is role page.
	 *
	 * @author SulakkhanaW
	 * @param role the role
	 * @return true, if is role page
	 * @throws Exception the exception
	 */
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
	
	/**
	 * Click add new role.
	 *
	 * @author SulakkhanaW
	 */
	public void clickAddNewRole(){
		logger.debug("Clicking on Add new role");
		getElement(lnkAddRole).click();
		logger.debug("Clicked on Add new role");
	}
	
	/**
	 * Checks if is adds the roles page.
	 *
	 * @author SulakkhanaW
	 * @param lblText the lbl text
	 * @return true, if is adds the roles page
	 * @throws Exception the exception
	 */
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
	
	/**
	 * Enter role name.
	 *
	 * @author SulakkhanaW
	 * @param rolename the rolename
	 */
	public void enterRoleName(String rolename){
		logger.debug("Entering Role name");
		getElement(txtRoleName).clearAndSendkeys(rolename);
		logger.debug("Entered Role name");
	}
	
	/**
	 * Click next.
	 *
	 * @author SulakkhanaW
	 */
	public void clickNext(){
		logger.debug("Clicking on Next");
		getElement(btnNext).click();
		logger.debug("Clicked on Next");
	}
	
	/**
	 * Checks if is select permission.
	 *
	 * @author SulakkhanaW
	 * @param lblText the lbl text
	 * @return true, if is select permission
	 * @throws Exception the exception
	 */
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
	
	/**
	 * Checks if is select users.
	 *
	 * @author SulakkhanaW
	 * @param lblText the lbl text
	 * @return true, if is select users
	 * @throws Exception the exception
	 */
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
	
	/**
	 * Eneter search value.
	 *
	 * @author SulakkhanaW
	 * @param searchvalue the searchvalue
	 */
	public void eneterSearchValue(String searchvalue){
		logger.debug("Entering search value");
		getElement(txtSearch).clearAndSendkeys(searchvalue);
		logger.debug("Entered search value");
	}
	
	/**
	 * Click search.
	 *
	 * @author SulakkhanaW
	 */
	public void clickSearch(){
		logger.debug("Clicking search button");
		getElement(btnSearch).click();
		logger.debug("Clicked search button");
	}
	
	/**
	 * Select user.
	 *
	 * @author SulakkhanaW
	 * @param username1 the username1
	 */
	public void selectUser(String username1){
		String xpath = String.format(btnUser, username1);
		WebPelement btnUser =defineEelement(UIType.Xpath, xpath);
		logger.debug("Selecting user");
		getElement(btnUser).click();
		logger.debug("Selected user");
	}
	
	/**
	 * Click finish.
	 *
	 * @author SulakkhanaW
	 */
	public void clickFinish(){
		logger.debug("Clicking on finish");
		getElement(btnFinish).click();
		logger.debug("Clicked on finish");
	}
	
	/**
	 * Checks if is success popup.
	 *
	 * @author SulakkhanaW
	 * @param msg the msg
	 * @return true, if is success popup
	 * @throws Exception the exception
	 */
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
	
	/**
	 * Click delete.
	 *
	 * @author SulakkhanaW
	 */
	public void clickDelete(){
		logger.debug("Clicking on delete");
		getElement(lnkDeleteAggrigator).click();
		logger.debug("Clicked on delete");
	}
	
	/**
	 * Click yes.
	 *
	 * @author SulakkhanaW
	 */
	public void clickYes(){
		logger.debug("Clicking on yes");
		getElement(btnYes).click();
		logger.debug("Clicked on yes");
	}
	
	/**
	 * Enter aggrigator role name.
	 *
	 * @author SulakkhanaW
	 * @param rolename the rolename
	 */
	public void enterAggrigatorRoleName(String rolename){
		logger.debug("Entering aggrigator role name");
		getElement(txtSearchRole).clearAndSendkeys(rolename);
		logger.debug("Entered aggrigator role name");
	}
	
	/**
	 * Click ok.
	 *
	 * @author SulakkhanaW
	 * @throws InterruptedException 
	 */
	public void clickOK() throws InterruptedException{
		logger.debug("Clicking on OK");
		getElement(btnOK).click();
		Thread.sleep(8000);
		logger.debug("Clicked on OK");
	}

	/**
	 * Checks if is role visible.
	 *
	 * @author SulakkhanaW
	 * @return true, if is role visible
	 * @throws Exception the exception
	 */
	public boolean isRoleVisible() throws Exception{
		flag = false;
		logger.debug("Validating user roles are visible");
		int count = driver.findElements(By.xpath(lnkRoleVisible)).size();
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
	
	/**
	 * Checks if is user name visible.
	 *
	 * @author SulakkhanaW
	 * @return true, if is user name visible
	 * @throws Exception the exception
	 */
	public boolean isUserNameVisible() throws Exception{
		
		flag = false;
		logger.debug("Validating user name is visible");
		int count = driver.findElements(By.xpath(lnkDelete)).size();
		try {
			if (count != 0){
				flag = true;
				logger.debug("User name is visible");
			} else {
				logger.debug("User name is not visible");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating User name is visible 'isUserNameVisible()'" + e.getMessage());
			throw new Exception("Exception While Validating User name is visible 'isUserNameVisible()'" + e.getLocalizedMessage());
		}
		return flag;
	}
	
	/**
	 * Click delete user.
	 *
	 * @author SulakkhanaW
	 * @param username the username
	 */
	public void clickDeleteUser(String username){
		String xpath = String.format(btnDelete, username);
		WebPelement btnDelete =defineEelement(UIType.Xpath, xpath);
		logger.debug("Clicking on delete");
		getElement(btnDelete).click();
		logger.debug("Clicked on delete");
	}
	
	/**
	 * Click on assign users.
	 */
	public void clickOnAssignUsers(){
		logger.debug("Clicking on assign users");
		getElement(lnkAssignUsers).click();
		logger.debug("Clicked on assign users");
	}
	
	/**
	 * Enter username pattern.
	 *
	 * @param username the username
	 */
	public void enterUsernamePattern(String username){
		logger.debug("Entering user name");
		getElement(txtUsersSearch).clearAndSendkeys(username);
		logger.debug("Entered User name");
	}
	
	/**
	 * Checks if is user name to assign visible.
	 *
	 * @param username the username
	 * @return true, if is user name to assign visible
	 * @throws Exception the exception
	 */
	public boolean isUserNameToAssignVisible(String username) throws Exception {

		flag = false;
		logger.debug("Validating user name is visible");
		String xpath = String.format(checkBoxUserNametoAssign, username);
		int count = driver.findElements(By.xpath(xpath)).size();
		try {
			if (count != 0) {
				flag = true;
				logger.debug("User name is visible");
			} else {
				logger.debug("User name is not visible");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating User name is visible 'isUserNameToAssignVisible()'"
					+ e.getMessage());
			throw new Exception(
					"Exception While Validating User name is visible 'isUserNameToAssignVisible()'"
							+ e.getLocalizedMessage());
		}
		return flag;
	}
	
	/**
	 * Select user to assign.
	 */
	public void selectUserToAssign(String username){
		logger.debug("Selecting user");
		String xpath = String.format(checkBoxUserNametoAssign, username);
		driver.findElement(By.xpath(xpath)).click();
		logger.debug("Selecting User");
	}
	
	/**
	 * Enter role name to search.
	 */
	public void enterRoleNameToSearch(String rolename){
		logger.debug("Entering user name");
		getElement(txtRoleSearch).clearAndSendkeys(rolename);
		logger.debug("Entered User name");
	}
}