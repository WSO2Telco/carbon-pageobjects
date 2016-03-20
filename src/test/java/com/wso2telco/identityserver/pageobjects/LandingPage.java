package com.wso2telco.identityserver.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.wso2telco.test.framework.core.WebPelement;
import com.wso2telco.test.framework.element.table.Table;
import com.wso2telco.test.framework.util.UIType;

public class LandingPage extends CarbonLeftNav {

	private WebPelement lblUsername = defineEelement(UIType.Xpath,
			".//div[@id='middle']/h2");
	private WebPelement lblConfigure = defineEelement(UIType.ID,
			"region1_configure_menu");
	private WebPelement lnkServiceProviderAdd = defineEelement(
			UIType.Xpath,
			"//ul[@class='main']//li[contains(text(),'Service Providers')]/following-sibling::li[1]/ul/li/a[text()='Add']");
	private WebPelement registerBttn = defineEelement(UIType.Xpath,
			"//input[@value='Register']");

	private WebPelement inBoundAuth = defineEelement(UIType.Xpath,
			"//*[@id='app_authentication_head']/a");
	private WebPelement oauthConfig = defineEelement(UIType.ID,
			"oauth.config.head");
	private WebPelement oauth_link = defineEelement(UIType.ID, "oauth_link");
	private WebPelement callback = defineEelement(UIType.ID, "callback");
	private WebPelement addprofileBttn = defineEelement(UIType.Name,
			"addprofile");

	private WebPelement localOutboundAuth = defineEelement(UIType.Xpath,
			"//*[@id='app_authentication_advance_head']/a");
	private WebPelement advancedConfig = defineEelement(UIType.ID, "advanced");
	private WebPelement stepsAddLink = defineEelement(UIType.ID, "stepsAddLink");
	private WebPelement stepSelect = defineEelement(UIType.Name,
			"step_1_local_oauth_select");
	private WebPelement addAuthentication = defineEelement(UIType.ID,
			"claimMappingAddLinkss");

	private WebPelement lnkUsers = defineEelement(UIType.Xpath,
			".//table[@id='internal']/tbody/tr[1]/td/a");
	private WebPelement txtUserName = defineEelement(UIType.Name,
			"org.wso2.carbon.user.filter");
	// private WebPelement btnSearch = defineEelement(UIType.Xpath,
	// "//input[@value='Search Users']");
	private WebPelement btnSearch = defineEelement(
			UIType.Xpath,
			".//*[@id='workArea']/form/table/tbody/tr[2]/td[2]/input[@value='Search Users']");

	private WebPelement btnDelete = defineEelement(UIType.Xpath,
			".//a[contains(text(),'Delete')]");

	private WebPelement btnOK = defineEelement(UIType.Xpath,
			"//button[contains(text(),'OK')]	");
	private WebPelement btnUpdate = defineEelement(UIType.Xpath,
			"//*[@value='Update']");

	private WebPelement btnConfirmarionYes = defineEelement(UIType.Css,
			".ui-dialog-buttonpane>button");
	private WebPelement btnConfirmarionNoUser = defineEelement(UIType.Css,
			".ui-dialog-buttonpane>button");
	private String strBtnConfirmarionNoUser = ".ui-dialog-buttonpane>button";

	private WebPelement lblNoUserMessage = defineEelement(UIType.ID,
			"messagebox-info");
	private WebPelement btnUserProfile = defineEelement(UIType.Xpath,
			".//a[contains(text(),'Profile')]");
	private WebPelement btndefaultUserProfile = defineEelement(UIType.Xpath,
			"//*[@id='workArea']/table/tbody/tr/td[1]/a");
	private WebPelement dialogYes = defineEelement(UIType.Xpath,
			"//div[@class='ui-dialog-buttonpane']/button[1]");

	// private WebPelement serviceProvidersRot = defineEelement(UIType.ID,
	// "ServiceProviders") ;


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

	public void addServiceProvider(String sercviceProvider) {
		getElement(lnkServiceProviderAdd).click();
		Table serviceProvidersAdd = getTable(UIType.ClassName,
				"carbonFormTable");

		serviceProvidersAdd.body().getRow(0).findElement(By.id("spName"))
				.sendKeys(sercviceProvider);
		getElement(registerBttn).click();
	}

	public void clickUsers() {
		getElement(lnkUsers).click();
	}

	public void enterUserName(String msisdn) {
		getElement(txtUserName).clear();
		getElement(txtUserName).sendKeys(msisdn);
	}

	public void clickSearch() {
		getElement(btnSearch).click();
	}

	public boolean isUserNotFound() throws Exception {
		flag = false;
		logInstruction("Validating IS Home Page");
		try {
			List<WebElement> found = driver.findElements(getBy(UIType.Css,
					strBtnConfirmarionNoUser));
			if (found.size() > 0) {
				getElement(btnConfirmarionNoUser).click();
				flag = true;
			}
		} catch (Exception e) {
			logInstruction("No user found'" + e.getMessage());
			throw new Exception("No User Found" + e.getLocalizedMessage());
		}
		return flag;
	}

	public void clickDelete() throws InterruptedException {
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

	public boolean isServiceProviderExist(String serviceProvider) {
		boolean flag = false;
		WebElement ele = null;
		// WebElement ple =getElement(serviceProvidersRot);
		Table serviceProviders = getTable(UIType.ID, "ServiceProviders");
		try {
			ele = serviceProviders.body().getRowContainingTextInColumn(
					serviceProvider, 0);
		} catch (NoSuchElementException e) {
			// TODO: handle exception
		}

		if (ele != null) {
			flag = true;
		}

		return flag;

	}

	public void deleteServiceProvider(String serviceProvider) {
		WebElement ele = null;
		Table serviceProviders = getTable(UIType.ID, "ServiceProviders");
		ele = serviceProviders.body()
				.getRowContainingTextInColumn(serviceProvider, 0)
				.findElement(By.xpath("./td[3]/a[2]"));
		ele.click();

		getElement(dialogYes).click();

		// div[@class='ui-dialog-buttonpane']/button[1]
	}

	public void setInboundAuthConfiguration(String serviceProvider) {
		WebElement ele = null;
		// WebElement ple =getElement(serviceProvidersRot);
		Table serviceProviders = getTable(UIType.ID, "ServiceProviders");
		try {
			ele = serviceProviders.body().getRowContainingTextInColumn(
					serviceProvider, 0);
		} catch (NoSuchElementException e) {
			// TODO: handle exception
		}
		ele.findElement(getBy(UIType.Xpath, "./td[3]/a[1]")).click();
		// getElement(btnEdit).click();
		getElement(inBoundAuth).click();
		getElement(oauthConfig).click();
		try {
			getElement(oauth_link).click();
			getElement(callback).sendKeys(config.getValue("Callback"));
			getElement(addprofileBttn).click();
			getElement(btnOK).click();
			getElement(btnUpdate).click();
		} catch (NullPointerException e) {
			// TODO: handle exception
		}

	}

	public void setOutboundAuthConfiguration(String serviceProvider)
			throws InterruptedException {
		WebElement ele = null;
		// WebElement ple =getElement(serviceProvidersRot);
		Table serviceProviders = getTable(UIType.ID, "ServiceProviders");
		try {
			ele = serviceProviders.body().getRowContainingTextInColumn(
					serviceProvider, 0);
		} catch (NoSuchElementException e) {
			// TODO: handle exception
		}
		ele.findElement(getBy(UIType.Xpath, "./td[3]/a[1]")).click();
		getElement(localOutboundAuth).click();
		getElement(advancedConfig).click();
		getElement(stepsAddLink).click();
		try {
			selectItem(stepSelect, "option", "LOA");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		getElement(addAuthentication).click();
		getElement(btnUpdate).click();

		getElement(btnUpdate).click();
	}

	public String getOauthClientKey(String serviceProvider) {
		WebElement ele = null;
		// WebElement ple =getElement(serviceProvidersRot);
		Table serviceProviders = getTable(UIType.ID, "ServiceProviders");
		try {
			ele = serviceProviders.body().getRowContainingTextInColumn(
					serviceProvider, 0);
		} catch (NoSuchElementException e) {
			// TODO: handle exception
		}
		ele.findElement(getBy(UIType.Xpath, "./td[3]/a[1]")).click();
		// getElement(btnEdit).click();
		getElement(inBoundAuth).click();
		getElement(oauthConfig).click();
		Table samlTable = getTable(UIType.ID, "samlTable");
		String id = samlTable.body().getRow(0).findElement(By.xpath("./td"))
				.getText();
		config.setValue("ClientId", id);
		return id;
	}

}
