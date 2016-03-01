package com.wso2telco.identityserver.pageobjects;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.wso2telco.test.framework.core.WebPelement;
import com.wso2telco.test.framework.util.UIType;

public class LandingPage extends BasicPageObject  {
	
	private WebPelement lblUsername = defineEelement(UIType.Xpath, ".//div[@id='middle']/h2");
	private WebPelement menuConfigure = defineEelement(UIType.ID, "menu-panel-button3");
	private WebPelement lblConfigure = defineEelement(UIType.ID, "region1_configure_menu");
	private WebPelement lnkUsersRoles = defineEelement(UIType.Xpath, ".//a[contains(text(),'Users and Roles')]");
	private WebPelement lnkUsersRolesList = defineEelement(UIType.Xpath, "//ul[@class='main']//li[contains(text(),'Users and Roles')]/../li[2]/ul/li/a[text()='List']");
	
	private WebPelement lnkUsers = defineEelement(UIType.Xpath, ".//table[@id='internal']/tbody/tr[1]/td/a");
	private WebPelement txtUserName = defineEelement(UIType.Name, "org.wso2.carbon.user.filter");
	//private WebPelement btnSearch = defineEelement(UIType.Xpath, "//input[@value='Search Users']");
	private WebPelement btnSearch = defineEelement(UIType.Xpath, ".//*[@id='workArea']/form/table/tbody/tr[2]/td[2]/input[@value='Search Users']");
	
	private WebPelement btnDelete = defineEelement(UIType.Xpath, ".//a[contains(text(),'Delete')]");
	private WebPelement btnConfirmarionYes = defineEelement(UIType.Css, ".ui-dialog-buttonpane>button");
	private WebPelement btnConfirmarionNoUser = defineEelement(UIType.Css, ".ui-dialog-buttonpane>button");
	private String strBtnConfirmarionNoUser = ".ui-dialog-buttonpane>button";
	private WebPelement lblNoUserMessage = defineEelement(UIType.ID, "messagebox-info");
	private WebPelement btnUserProfile = defineEelement(UIType.Xpath, ".//a[contains(text(),'Profile')]");
	private WebPelement btndefaultUserProfile = defineEelement(UIType.Xpath, "//*[@id='workArea']/table/tbody/tr/td[1]/a");
	private WebPelement mainBttn = defineEelement(UIType.Xpath, "//span[text()='Main']/..");
	

	
	
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
	
	
	public void clickMain(){
		getElement(mainBttn).click();		
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
	
	public void clickUserRolesList(){
		getElement(lnkUsersRolesList).click();		
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
		getElement(btndefaultUserProfile).click();
		
		return new UserProfile(driver);
	}


	
}
