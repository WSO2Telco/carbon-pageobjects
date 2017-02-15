package com.wso2telco.identityserver.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.wso2telco.test.framework.core.WebPelement;
import com.wso2telco.test.framework.util.UIType;

public class LandingPage extends BasicPageObject  {
	
	//public String appName = "";
	//public String sp ;
	private WebPelement lblUsername = defineEelement(UIType.Xpath, ".//div[@id='middle']/h2");
	private WebPelement menuConfigure = defineEelement(UIType.ID, "menu-panel-button3");
	private WebPelement lblConfigure = defineEelement(UIType.ID, "region1_configure_menu");
	private WebPelement lnkUsersRoles = defineEelement(UIType.Xpath, ".//a[contains(text(),'Users and Roles')]");
	private WebPelement lnkUsers = defineEelement(UIType.Xpath, ".//table[@id='internal']/tbody/tr[1]/td/a");
	private WebPelement txtUserName = defineEelement(UIType.Name, "org.wso2.carbon.user.filter");
	private WebPelement btnSearch = defineEelement(UIType.Xpath, ".//input[@value='Search']");
	private WebPelement btnDelete = defineEelement(UIType.Xpath, ".//a[contains(text(),'Delete')]");
	private WebPelement btnConfirmarionYes = defineEelement(UIType.Css, ".ui-dialog-buttonpane>button");
	private WebPelement btnConfirmarionNoUser = defineEelement(UIType.Css, ".ui-dialog-buttonpane>button");
	private String strBtnConfirmarionNoUser = ".ui-dialog-buttonpane>button";
	private WebPelement lblNoUserMessage = defineEelement(UIType.ID, "messagebox-info");
	private WebPelement btnUserProfile = defineEelement(UIType.Xpath, ".//a[contains(text(),'Profile')]");
	private String tableUserNameCell= "//table[@id='userTable']//tr/td[contains(.,'%s')]";
	private WebPelement lnkSPList = defineEelement(UIType.Xpath, "//li[contains(text(),'Service Providers')]/following-sibling::li[1]//ul//li[2]//a");
	//private WebPelement btnEditApp_APPname= defineEelement(UIType.Xpath,"//td[contains(text(),'"+sp+"')]/following-sibling::td[2]//a[1]");
	private WebPelement menuInbound_Authentication_Configuration = defineEelement(UIType.Xpath, "//h2[@id='app_authentication_head']/a");
	private WebPelement menuOAuth_OpenID_Connect_Configuration = defineEelement(UIType.Xpath, "//h2[@id='oauth.config.head']/a");
	private WebPelement btnEdit_OAuth_OpenID_Connect_Configuration = defineEelement(UIType.Xpath, "//*[@id='samlTable']/tbody/tr/td[3]/a[1]");
	private WebPelement txtCallBack = defineEelement(UIType.Xpath, "//input[@id='callback']");
	private WebPelement btnUpdate = defineEelement(UIType.Xpath, "//input[@value='Update']");
	
	
	public LandingPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public boolean isISHomePage(String pageTitle) throws Exception {
		flag = false;
		logInstruction("Validating IS Home Page");
		try {
			if (pageTitle.contains(getElement(lblUsername).getText())) {
				flag = true;
				logInstruction("Validating IS Home Page completed");
			} else {
				logInstruction("Title is Not Matched");
			}
		} catch (Exception e) {
			logInstruction("Exception While Validating IS Home Page 'isISHomePage()'"
					+ e.getMessage());
			throw new Exception(
					"Exception While Validating IS Home Page 'isISHomePage()'"
							+ e.getLocalizedMessage());
		}
		return flag;
	}
	
	public void clickConfigure(){
		getElement(menuConfigure).click();		
	}
	
	public void clickEditBtnOfAPP(String NameOfSP){
		System.out.println("//td[contains(text(),'"+NameOfSP+"')]/following-sibling::td[2]//a[1]");
		getElement(defineEelement(UIType.Xpath,"//td[contains(text(),'"+NameOfSP+"')]/following-sibling::td[2]//a[1]")).click();		
	}
	
	public void clickLnkSPList(){
		getElement(lnkSPList).click();		
	}
	
	public void clickMenu_Inbound_Authentication_Configuration(){
		getElement(menuInbound_Authentication_Configuration).click();		
	}
	
	public void clickMenuOAuth_OpenID_Connect_Configuration(){
		getElement(menuOAuth_OpenID_Connect_Configuration).click();		
	}
	
	public void clickBtnEdit_OAuth_OpenID_Connect_Configuration(){
		getElement(btnEdit_OAuth_OpenID_Connect_Configuration).click();		
	}
	
	public void clearTxtCallBack(){
		getElement(txtCallBack).clear();		
	}
	
	public void editTxtCallBack(String callback){
		getElement(txtCallBack).clearAndSendkeys(callback);		
	}
	
	public void ClickBtnUpdate(){
		getElement(btnUpdate).click();		
	}
	
	
	
	public boolean isConfigurePage(String pageTitle) throws Exception {
		flag = false;
		logInstruction("Validating Configure Label");
		try {
			if (pageTitle.contains(getElement(lblConfigure).getText())) {
				flag = true;
				logInstruction("Validating Configure Label completed");
			} else {
				logInstruction("Configure Label not displayed");
			}
		} catch (Exception e) {
			logInstruction("Exception While Validating Configure Label 'isConfigurePage()'"
					+ e.getMessage());
			throw new Exception(
					"Exception While Validating Configure Label 'isConfigurePage()'"
							+ e.getLocalizedMessage());
		}
		return flag;
	}
	
	public void clickUserRoles(){
		getElement(lnkUsersRoles).click();		
	}
	
	public void clickUsers(){
		getElement(lnkUsers).click();		
	}
	
	public void enterUserName(String msisdn){
		getElement(txtUserName).clear();
		getElement(txtUserName).sendKeys(msisdn);	
	}
	
	public void clickSearch(){
		getElement(btnSearch).click();	
	}
	
	public boolean isUserNotFound() throws Exception {
		flag = false;
		logInstruction("Validating IS Home Page");
		try {
			
			List<WebElement> found = driver.findElements(getBy(UIType.Css,strBtnConfirmarionNoUser));
			if (found.size() > 0) {
				getElement(btnConfirmarionNoUser).click();
				flag = true;
			}
		} catch (Exception e) {
			logInstruction("No user found'"
					+ e.getMessage());
			throw new Exception(
					"No User Found"
							+ e.getLocalizedMessage());
		}
		return flag;
	}

	public void clickDelete() throws InterruptedException{
		getElement(btnDelete).click();	
		getElement(btnConfirmarionYes).click();	

	}
	

	public boolean isUserDeleted(String message) throws Exception {
		flag = false;
		logInstruction("Validating user is deleted");
		try {
			if (message.contains(getElement(lblNoUserMessage).getText())) {
				flag = true;
				logInstruction("Validating user is deleted completed");
			} else {
				logInstruction("user is not deleted");
			}
		} catch (Exception e) {
			logInstruction("Exception While Validating user deletion message 'isUserDeleted()'"
					+ e.getMessage());
			throw new Exception(
					"Exception While Validating user deletion message 'isUserDeleted()'"
							+ e.getLocalizedMessage());
		}
		return flag;
	}

	public UserProfile clickUserProfile() {
		// TODO Auto-generated method stub
		getElement(btnUserProfile).click();
		return new UserProfile(driver);
	}
/**
 * @author Achiniuj
 * @param msisdn
 * @return
 * @throws Throwable
 */
	public boolean isUserTableUpdated(String msisdn) throws Throwable {
		flag = false;
		logInstruction("Validating user is at user table");
		try {
			String xpath = String.format(tableUserNameCell, msisdn);
			List<WebElement> number = driver.findElements(By.xpath(xpath));

			if (number.size() == 1) {
				logInstruction("Validated user is at user table");
				return true;

			} else {
				logInstruction("user is not at user table");
			}
		} catch (Exception e) {
			logInstruction("Exception While Validating user table 'isUserTableUpdated'"
					+ e.getMessage());
			throw new Exception(
					"Exception While Validating user table 'isUserTableUpdated'"
							+ e.getLocalizedMessage());
		}
		return false;

	}
	

	
	
}
