package com.wso2telco.identityserver.pageobjects.carbon;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.wso2telco.identityserver.pageobjects.BasicPageObject;
import com.wso2telco.test.framework.core.WebPelement;
import com.wso2telco.test.framework.util.UIType;



public class CarbonServiceProvider extends BasicPageObject {

	Logger logger = Logger.getLogger(CarbonServiceProvider.class);
	
	private WebPelement lblHeader = defineEelement(UIType.Xpath, "//div[@id='middle']/h2");
	
	private WebPelement lnkInbound = defineEelement(UIType.Xpath, "//a[contains(.,'Inbound Authentication Configuration')]");
	
	private WebPelement lnkOAuth = defineEelement(UIType.Xpath, "//h2[@id='oauth.config.head']/a");
	
	private WebPelement btnShow = defineEelement(UIType.Xpath, "//input[@id='oauthConsumerSecret']/../span[1]/a");
	
	private WebPelement lnkOutbound = defineEelement(UIType.Xpath, "//a[contains(.,'Local & Outbound Authentication Configuration')]");
	
	private WebPelement btnAdConfig = defineEelement(UIType.Xpath, "//input[@id='advanced']");
	
	private WebPelement lnkAddAuth = defineEelement(UIType.Xpath, "/div[@id='stepsConfRow']/table/tbody/tr/td");
	
	private WebPelement btnAuthenticators = defineEelement(UIType.Xpath, "//table[@id='local_auth_table_1']/thead/tr/td/select");
	
	private WebPelement lblLOA = defineEelement(UIType.Xpath, "//option[contains(.,'LOA')]");
	
	private WebPelement btnUpdate = defineEelement(UIType.Xpath, "//input[@value='Update']");
	
	private WebPelement lnkEdit = defineEelement(UIType.Xpath, "//table[@id='samlTable']/tbody/tr/td[3]/a[1]");
	
	private WebPelement btnCode = defineEelement(UIType.Xpath, "//input[@id='grant_code']");
	
	private WebPelement btnImplicit = defineEelement(UIType.Xpath, "//input[@id='grant_implicit']");
	
	private WebPelement btnPassword = defineEelement(UIType.Xpath, "//input[@id='grant_password']");
	
	private WebPelement btnClient = defineEelement(UIType.Xpath, "//input[@id='grant_client']");
	
	private WebPelement btnRefresh= defineEelement(UIType.Xpath, "//input[@id='grant_refresh']");
	
	private WebPelement btnSAML = defineEelement(UIType.Xpath, "//input[@id='grant_saml']");
	
	private WebPelement btnIWA = defineEelement(UIType.Xpath, "//input[@id='grant_ntlm']");
	
	private WebPelement lblSuccess = defineEelement(UIType.Xpath, "//div[@id='messagebox-info']");
	
	private WebPelement lblClientKey = defineEelement(UIType.Xpath, "//table[@id='samlTable']/tbody/tr/td[1]");
	
	private WebPelement lblClientSec = defineEelement(UIType.Xpath, "//input[@id='oauthConsumerSecret']");
	
	private WebPelement lnkCallBack = defineEelement(UIType.Xpath, "//input[@id='callback']");
	
	public CarbonServiceProvider(WebDriver driver) {
		super(driver);
	}

	public boolean isAppinSPTable(String appName) throws Exception {

		flag = false;
		logger.debug("Validating App in SP");
		int count = driver.findElements(By.xpath("//a[contains(.,'Edit')]")).size();
		Thread.sleep(10000);
		
		try {
			if (count != 0) {
				flag = true;
				logger.debug("Validating App in SP completed");
			} else {
				logger.debug("App is Not Matched");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating App in SP Page Title 'isAppinSPTable()'"
					+ e.getMessage());
			throw new Exception(
					"Exception While Validating App in SP Page Title 'isAppinSPTable()'"
							+ e.getLocalizedMessage());
		}
		return flag;
	}
	
	public void clickAppEdit(String app){
		
		String xpath = "//td[contains(.,'"+app+"')]/../td[3]/a[1]";
		WebPelement btnEdit =defineEelement(UIType.Xpath, xpath);
		getElement(btnEdit).click();
	}
	
	public boolean isSPpageDisplyed(String spHeader) throws Exception {

		flag = false;
		logger.debug("Validating Title Service Provider");
		Thread.sleep(10000);
		
		try {
			if (spHeader.contains(getElement(lblHeader).getText())) {
				flag = true;
				logger.debug("Validating Title Service Provider completed");
			} else {
				logger.debug("Title Service Provider is Not Matched");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating Title Service Provider Page Title 'isSPpageDisplyed()'"
					+ e.getMessage());
			throw new Exception(
					"Exception While Validating Title Service Provider Page Title 'isSPpageDisplyed()'"
							+ e.getLocalizedMessage());
		}
		return flag;
	}
	
	public void clickInboundLink(){
		getElement(lnkInbound).click();
	}
	
	public void clickOAuthLink(){
		getElement(lnkOAuth).click();
	}
	
	public void clickShow(){
		getElement(btnShow).click();
	}
	
	public void clickOutbound(){
		getElement(lnkOutbound).click();
	}
	
	public void clickAdConfig(){
		getElement(btnAdConfig).click();
	}
	
	public boolean isAdConfigpageDisplyed(String AdConfigHeaderAppName) throws Exception {

		flag = false;
		logger.debug("Validating Title Advanced Authentication Configuration");
		Thread.sleep(10000);
		
		String header = getElement(lblHeader).getText();
		
		try {
			if (header.contains(AdConfigHeaderAppName)) {
				flag = true;
				logger.debug("Validating Title Advanced Authentication Configuration completed");
			} else {
				logger.debug("Title Advanced Authentication Configuration is Not Matched");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating Title Advanced Authentication Configuration Page Title 'isAdConfigpageDisplyed()'"
					+ e.getMessage());
			throw new Exception(
					"Exception While Validating Title Advanced Authentication Configuration Page Title 'isAdConfigpageDisplyed()'"
							+ e.getLocalizedMessage());
		}
		return flag;
	}
	
	public void clickAddAuthStep(){
		getElement(lnkAddAuth).click();
	}
	
	public void clickAuthenticators(){
		getElement(btnAuthenticators).click();
	}
	
	public void selectLOA(){
		getElement(lblLOA).click();
	}
	
	public void clickUpdate(){
		getElement(btnUpdate).click();
	}
	
	public void clickEdit(){
		getElement(lnkEdit).click();
	}
	
	public boolean isViewUpdatepageDisplyed(String viewHeader) throws Exception {

		flag = false;
		logger.debug("Validating Title View/Update application settings");
		Thread.sleep(10000);
		
		try {
			if (viewHeader.contains(getElement(lblHeader).getText())) {
				flag = true;
				logger.debug("Validating Title View/Update application settings completed");
			} else {
				logger.debug("Title View/Update application settings is Not Matched");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating Title View/Update application settings Page Title 'isViewUpdatepageDisplyed()'"
					+ e.getMessage());
			throw new Exception(
					"Exception While Validating Title View/Update application settings Page Title 'isViewUpdatepageDisplyed()'"
							+ e.getLocalizedMessage());
		}
		return flag;
	}
	
	public void selectCode(){
		getElement(btnCode).click();
	}
	
	public void selectImplicit(){
		getElement(btnImplicit).click();
	}
	
	public void selectPassword(){
		getElement(btnPassword).click();
	}
	
	public void selectClient(){
		getElement(btnClient).click();
	}
	
	public void selectRefresh(){
		getElement(btnRefresh).click();
	}
	
	public void selectSAML(){
		getElement(btnSAML).click();
	}
	
	public void selectIWA(){
		getElement(btnIWA).click();
	}
	
	public boolean isSuccessMessageDisplyed(String message) throws Exception {

		flag = false;
		logger.debug("Validating Success Message");
		Thread.sleep(10000);
		
		try {
			if (message.contains(getElement(lblSuccess).getText())) {
				flag = true;
				logger.debug("Validating Success Message completed");
			} else {
				logger.debug("Success Message is Not Matched");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating Success Message Page Title 'isSuccessMessageDisplyed()'"
					+ e.getMessage());
			throw new Exception(
					"Exception While Validating Success Message Page Title 'isSuccessMessageDisplyed()'"
							+ e.getLocalizedMessage());
		}
		return flag;
	}
	
	public boolean isClientKeyDisplyed(String clientKey) throws Exception {

		flag = false;
		logger.debug("Validating Client Key");
		Thread.sleep(10000);
		
			try {
			if (clientKey.contains(getElement(lblClientKey).getText())) {
				flag = true;
				logger.debug("Validating Client Key completed");
			} else {
				logger.debug("Client Key is Not Matched");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating Client Key Page Title 'isClientKeyDisplyed()'"
					+ e.getMessage());
			throw new Exception(
					"Exception While Validating Client Key Page Title 'isClientKeyDisplyed()'"
							+ e.getLocalizedMessage());
		}
		return flag;
	}
	
	public boolean isClientSecretDisplyed(String clientSec) throws Exception {

		flag = false;
		logger.debug("Validating Client Secret");
		Thread.sleep(10000);
		
			try {
			if (clientSec.contains(getElement(lblClientSec).getText())) {
				flag = true;
				logger.debug("Validating Client Secret completed");
			} else {
				logger.debug("Client Secret is Not Matched");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating Client Secret Page Title 'isClientSecretDisplyed()'"
					+ e.getMessage());
			throw new Exception(
					"Exception While Validating Client Secret Page Title 'isClientSecretDisplyed()'"
							+ e.getLocalizedMessage());
		}
		return flag;
	}
	
	public boolean isCallBackURLDisplyed(String callBackURL) throws Exception {

		flag = false;
		logger.debug("Validating Call Back URL");
		Thread.sleep(10000);
		
			try {
			if (callBackURL.contains(getElement(lnkCallBack).getText())) {
				flag = true;
				logger.debug("Validating Call Back URL completed");
			} else {
				logger.debug("Call Back URL is Not Matched");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating Call Back URL Page Title 'isCallBackURLDisplyed()'"
					+ e.getMessage());
			throw new Exception(
					"Exception While Validating Call Back URL Page Title 'isCallBackURLDisplyed()'"
							+ e.getLocalizedMessage());
		}
		return flag;
	}
}
