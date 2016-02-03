package com.wso2telco.identityserver.pageobjects.carbon;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.wso2telco.identityserver.pageobjects.BasicPageObject;
import com.wso2telco.test.framework.core.WebPelement;
import com.wso2telco.test.framework.util.UIType;

/**
 * The Class CarbonServiceProvider.
 */
public class CarbonServiceProvider extends BasicPageObject {

	/** The logger. */
	Logger logger = Logger.getLogger(CarbonServiceProvider.class);
	
	/** The lbl header. */
	private WebPelement lblHeader = defineEelement(UIType.Xpath, "//div[@id='middle']/h2");
	
	/** The lnk inbound. */
	private WebPelement lnkInbound = defineEelement(UIType.Xpath, "//a[contains(.,'Inbound Authentication Configuration')]");
	
	/** The lnk o auth. */
	private WebPelement lnkOAuth = defineEelement(UIType.Xpath, "//h2[@id='oauth.config.head']/a");
	
	/** The btn show. */
	private WebPelement btnShow = defineEelement(UIType.Xpath, "//input[@id='oauthConsumerSecret']/../span[1]/a");
	
	/** The lnk outbound. */
	private WebPelement lnkOutbound = defineEelement(UIType.Xpath, "//a[contains(.,'Local & Outbound Authentication Configuration')]");
	
	/** The btn ad config. */
	private WebPelement btnAdConfig = defineEelement(UIType.ID, "advanced");
	
	/** The lnk add auth. */
	private WebPelement lnkAddAuth = defineEelement(UIType.Xpath, "/div[@id='stepsConfRow']/table/tbody/tr/td");
	
	/** The btn authenticators. */
	private WebPelement btnAuthenticators = defineEelement(UIType.Xpath, "//table[@id='local_auth_table_1']/thead/tr/td/select");
	
	/** The lbl loa. */
	private WebPelement lblLOA = defineEelement(UIType.Xpath, "//option[contains(.,'LOA')]");
	
	/** The btn update. */
	private WebPelement btnUpdate = defineEelement(UIType.Xpath, "//input[@value='Update']");
	
	/** The lnk edit. */
	private WebPelement lnkEdit = defineEelement(UIType.Xpath, "//table[@id='samlTable']/tbody/tr/td[3]/a[1]");
	
	/** The btn code. */
	private WebPelement btnCode = defineEelement(UIType.ID, "grant_code");
	
	/** The btn implicit. */
	private WebPelement btnImplicit = defineEelement(UIType.ID, "grant_implicit");
	
	/** The btn password. */
	private WebPelement btnPassword = defineEelement(UIType.ID, "grant_password");
	
	/** The btn client. */
	private WebPelement btnClient = defineEelement(UIType.ID, "grant_client");
	
	/** The btn refresh. */
	private WebPelement btnRefresh= defineEelement(UIType.ID, "grant_refresh");
	
	/** The btn saml. */
	private WebPelement btnSAML = defineEelement(UIType.ID, "grant_saml");
	
	/** The btn iwa. */
	private WebPelement btnIWA = defineEelement(UIType.ID, "grant_ntlm");
	
	/** The lbl success. */
	private WebPelement lblSuccess = defineEelement(UIType.ID, "messagebox-info");
	
	/** The lbl client key. */
	private WebPelement lblClientKey = defineEelement(UIType.Xpath, "//table[@id='samlTable']/tbody/tr/td[1]");
	
	/** The lbl client sec. */
	private WebPelement lblClientSec = defineEelement(UIType.ID, "oauthConsumerSecret");
	
	/** The lnk call back. */
	private WebPelement lnkCallBack = defineEelement(UIType.ID, "callback");
	
	/** The lbl edit. */
	private String lblEdit =  "//a[contains(.,'Edit')]";
	
	/** The btn edit. 
	 * %s_1 = appName
	 **/
	private String btnEdit = "//td[contains(.,'%s')]/../td[3]/a[1]";
	
	/**
	 * Instantiates a new carbon service provider.
	 *
	 * @author SulakkhanaW
	 * @param driver the driver
	 */
	public CarbonServiceProvider(WebDriver driver) {
		super(driver);
	}

	/**
	 * Checks if is appin sp table.
	 *
	 * @author SulakkhanaW
	 * @param appName the app name
	 * @return true, if is appin sp table
	 * @throws Exception the exception
	 */
	public boolean isAppinSPTable(String appName) throws Exception {

		flag = false;
		logger.debug("Validating App in SP");
		int count = verifyListContent(UIType.Xpath, lblEdit).size();
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
	
	/**
	 * Click app edit.
	 *
	 * @author SulakkhanaW
	 * @param app the app
	 */
	public void clickAppEdit(String app){
		String xpath = String.format(btnEdit, app);
		WebPelement btnEdit =defineEelement(UIType.Xpath, xpath);
		logger.debug("Clicking on Application edit");
		getElement(btnEdit).click();
		logger.debug("Clicked on Application edit");
	}
	
	/**
	 * Checks if is s ppage displyed.
	 *
	 * @author SulakkhanaW
	 * @param spHeader the sp header
	 * @return true, if is s ppage displyed
	 * @throws Exception the exception
	 */
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
	
	/**
	 * Click inbound link.
	 *
	 * @author SulakkhanaW
	 */
	public void clickInboundLink(){
		logger.debug("Clicking on inbound link");
		getElement(lnkInbound).click();
		logger.debug("Clicked on inbound link");
	}
	
	/**
	 * Click o auth link.
	 *
	 * @author SulakkhanaW
	 */
	public void clickOAuthLink(){
		logger.debug("Clicking on Authintication link");
		getElement(lnkOAuth).click();
		logger.debug("Clicked on Authintication link");
	}
	
	/**
	 * Click show.
	 *
	 * @author SulakkhanaW
	 */
	public void clickShow(){
		logger.debug("Clicking on Show");
		getElement(btnShow).click();
		logger.debug("Clicked on Show");
	}
	
	/**
	 * Click outbound.
	 *
	 * @author SulakkhanaW
	 */
	public void clickOutbound(){
		logger.debug("Clicking on outbound");
		getElement(lnkOutbound).click();
		logger.debug("Clicked on outbound");
	}
	
	/**
	 * Click add config.
	 *
	 * @author SulakkhanaW
	 */
	public void clickAddConfig(){
		logger.debug("Clicking on Add config");
		getElement(btnAdConfig).click();
		logger.debug("Clickedon Add config");
	}
	
	/**
	 * Checks if is adds the config page displyed.
	 *
	 * @author SulakkhanaW
	 * @param AdConfigHeaderAppName the ad config header app name
	 * @return true, if is adds the config page displyed
	 * @throws Exception the exception
	 */
	public boolean isAddConfigPageDisplyed(String AdConfigHeaderAppName) throws Exception {

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
	
	/**
	 * Click add auth step.
	 *
	 * @author SulakkhanaW
	 */
	public void clickAddAuthStep(){
		logger.debug("Clicking on Add Authintication step");
		getElement(lnkAddAuth).click();
		logger.debug("Clicked on Add Authintication step");
	}
	
	/**
	 * Click authenticators.
	 *
	 * @author SulakkhanaW
	 */
	public void clickAuthenticators(){
		logger.debug("Clicking on Authinticators");
		getElement(btnAuthenticators).click();
		logger.debug("Clicked on Authinticators");
	}
	
	/**
	 * Select loa.
	 *
	 * @author SulakkhanaW
	 */
	public void selectLOA(){
		logger.debug("Selecting LOA");
		getElement(lblLOA).click();
		logger.debug("Selected LOA");
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
	 * Click edit.
	 *
	 * @author SulakkhanaW
	 */
	public void clickEdit(){
		logger.debug("Clicking on Edit");
		getElement(lnkEdit).click();
		logger.debug("Clicked on Edit");
	}
	
	/**
	 * Checks if is view update page displyed.
	 *
	 * @author SulakkhanaW
	 * @param viewHeader the view header
	 * @return true, if is view update page displyed
	 * @throws Exception the exception
	 */
	public boolean isViewUpdatePageDisplyed(String viewHeader) throws Exception {

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
	
	/**
	 * Select code.
	 *
	 * @author SulakkhanaW
	 */
	public void selectCode(){
		logger.debug("Selecting code");
		getElement(btnCode).click();
		logger.debug("Selected code");
	}
	
	/**
	 * Select implicit.
	 *
	 * @author SulakkhanaW
	 */
	public void selectImplicit(){
		logger.debug("Selecting Implicit");
		getElement(btnImplicit).click();
		logger.debug("Selected Implicit");
	}
	
	/**
	 * Select password.
	 *
	 * @author SulakkhanaW
	 */
	public void selectPassword(){
		logger.debug("Selecting password");
		getElement(btnPassword).click();
		logger.debug("Selected password");
	}
	
	/**
	 * Select client.
	 *
	 * @author SulakkhanaW
	 */
	public void selectClient(){
		logger.debug("Selecting Client");
		getElement(btnClient).click();
		logger.debug("Selected Client");
	}
	
	/**
	 * Select refresh.
	 *
	 * @author SulakkhanaW
	 */
	public void selectRefresh(){
		logger.debug("Selecting refresh");
		getElement(btnRefresh).click();
		logger.debug("Selected refresh");
	}
	
	/**
	 * Select saml.
	 *
	 * @author SulakkhanaW
	 */
	public void selectSAML(){
		logger.debug("Selecting SAML");
		getElement(btnSAML).click();
		logger.debug("Selected SAML");
	}
	
	/**
	 * Select iwa.
	 *
	 * @author SulakkhanaW
	 */
	public void selectIWA(){
		logger.debug("Selecting IWA");
		getElement(btnIWA).click();
		logger.debug("Selected IWA");
	}
	
	/**
	 * Checks if is success message displyed.
	 *
	 * @author SulakkhanaW
	 * @param message the message
	 * @return true, if is success message displyed
	 * @throws Exception the exception
	 */
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
	
	/**
	 * Checks if is client key displyed.
	 *
	 * @author SulakkhanaW
	 * @param clientKey the client key
	 * @return true, if is client key displyed
	 * @throws Exception the exception
	 */
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
	
	/**
	 * Checks if is client secret displyed.
	 *
	 * @author SulakkhanaW
	 * @param clientSec the client sec
	 * @return true, if is client secret displyed
	 * @throws Exception the exception
	 */
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
	
	/**
	 * Checks if is call back url displyed.
	 *
	 * @author SulakkhanaW
	 * @param callBackURL the call back url
	 * @return true, if is call back url displyed
	 * @throws Exception the exception
	 */
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
