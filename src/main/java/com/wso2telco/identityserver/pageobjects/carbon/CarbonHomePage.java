package com.wso2telco.identityserver.pageobjects.carbon;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.wso2telco.identityserver.pageobjects.BasicPageObject;
import com.wso2telco.test.framework.core.WebPelement;
import com.wso2telco.test.framework.util.UIType;

import java.util.concurrent.TimeUnit;

/**
 * The Class CarbonHomePage.
 */
public class CarbonHomePage extends BasicPageObject {
	
	/** The logger. */
	Logger logger = Logger.getLogger(CarbonHomePage.class);
	
	/** The lnk signout. */
	private WebPelement lnkSignout = defineEelement(UIType.Xpath, "//li[@class='right']/a");
	
	/** The lbl configure. */
	private WebPelement lblConfigure = defineEelement(UIType.Xpath, "//span[text()[contains(.,'Configure')]]");
	
	/** The lbl main. */
	private WebPelement lblMain = defineEelement(UIType.Xpath, "//span[text()[contains(.,'Main')]]");
	
	/** The title home. */
	private WebPelement titleHome = defineEelement(UIType.Xpath, "//div[@id='middle']/h2");
	
	/** The lbl service provider. */
	private WebPelement lblServiceProvider = defineEelement(UIType.Xpath, "//div[@id='menu']/ul/li[3]/ul/li[1]");
	
	/** The lnk list. */
	private WebPelement lnkList = defineEelement(UIType.Xpath, "//div[@id='menu']/ul/li[3]/ul/li[1]/../li[2]/ul/li[2]");
	
	/** The lnk browse. */
	private WebPelement lnkBrowse = defineEelement(UIType.Xpath, "//a[text()='Browse']");

	/** The lbl resources. */
	private WebPelement lblResources = defineEelement(UIType.Xpath, "//td[@id='region3']/div/ul/li[4]");
	
	/** The lnk resources. */
	private WebPelement lnkResources = defineEelement(UIType.Xpath, "//td[@id='region3']/div/ul/li[3]");

	/** The lnk features. */
	private WebPelement linkFeatures = defineEelement(UIType.Xpath, ".//*[@id='menu']/ul/li[7]/ul/li[1]/a");

	/** The tab Repository Management. */
	private WebPelement repoMgtTab = defineEelement(UIType.Xpath, ".//*[@id='tabs']/ul/li[4]/a");

	/** The button Add Repository. */
	private WebPelement buttonAddRepo = defineEelement(UIType.Xpath, ".//*[@id='_table_add_repository_link']/tbody/tr[2]/td/a");

	/** The TextField Name. */
	private WebPelement txtFiledName = defineEelement(UIType.Xpath, ".//*[@id='_txt_repository_name']");

	/** The TextField locationUrl. */
	private WebPelement locationUrl = defineEelement(UIType.Xpath, "//*[@id='_txt_repository_location_url']");

	/** The Add button under Repository . */
	private WebPelement addButton = defineEelement(UIType.Xpath, "//*[@id='_btn_add_repository']");

	/** The Available Features tab . */
	private WebPelement avlblFeatureTab = defineEelement(UIType.Xpath, "//*[@id='tabs']/ul/li[1]/a");

	/** The find feature button . */
	private WebPelement findFeatureButton = defineEelement(UIType.Xpath, "//*[@id='_btn_next_filter_repositories']");

	/** The API Key Manager button . */
	private WebPelement apiKeyManagerButton = defineEelement(UIType.Xpath, "//*[@id='file:/tmp/equinox-p23812776211616538295category_org_wso2_apimgt_keymanager_category_feature_category_1_0_0_7X19GcKBrwb']/td[1]/img[2]");

	/** The  API Key Manager version 6.0.4 button . */
	private WebPelement apiKeyManagerVersionButton = defineEelement(UIType.Xpath, "//*[@id='org_wso2_apimgt_keymanager_category_feature_group_6_0_4']/td[1]/img[2]");

	/** The  API Key Management key button . */
	private WebPelement apiManagementButton = defineEelement(UIType.Xpath, "//*[@id='org_wso2_carbon_apimgt_keymanager_feature_group_6_0_4']/td[1]/input[2]");

	/** The  Install button . */
	private WebPelement installButton = defineEelement(UIType.Xpath, "//*[@id='install2']");

	/** The  Ok button . */
	private WebPelement okButton = defineEelement(UIType.Xpath, "html/body/div[3]/div[2]/button");

	/** The  install next button . */
	private WebPelement installNextButton = defineEelement(UIType.Xpath, "//*[@id='_btn_next_review_features']");

	/** The  I accept button . */
	private WebPelement acceptButton = defineEelement(UIType.Xpath, "//*[@id='_radio_af_accept_licenses']");

	/** The  I accept Next button . */
	private WebPelement acceptedNextButton = defineEelement(UIType.Xpath, "//*[@id='_btn_finish_af_review_licenses']");

	/** The  installing label . */
	private WebPelement installingProcess = defineEelement(UIType.Xpath, "//*[@id='_table_installing']/thead/tr/th/h4");

	/** The  install complete label . */
	private WebPelement installComplete = defineEelement(UIType.Xpath, "//*[@id='_table_Installation_Complete']/thead/tr/th/h4/strong");

	/** The  Restart Later Button. */
	private WebPelement restartLaterButton = defineEelement(UIType.Xpath, "//*[@id='_btn_ic_restart_later']");

	/**
	// * Instantiates a new carbon home page.
	 *
	 * @author SulakkhanaW
	 * @param driver the driver
	 */
	public CarbonHomePage(WebDriver driver) {
		super(driver);
	}

	/**
	 * Checks if is IDS home displayed.
	 *
	 * @author SulakkhanaW
	 * @param title the title
	 * @return true, if is IDS home displayed
	 * @throws Exception the exception
	 */
	public boolean isIDSHomeDisplayed(String title) throws Exception {
		flag = false;
		logger.debug("Validating IDS Home page");
		Thread.sleep(sleepTime);
		try {
			if (title.contains(getElement(titleHome).getText().trim())) {
				flag = true;
				logger.debug("Validating IDS Home page completed");
			} else {
				logger.debug("IDS Home page title Not Matched");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating IDS Home page, Page Title 'isIDSHomeDisplayed()'"
					+ e.getMessage());
			throw new Exception(
					"Exception While Validating IDS Home page, Page Title 'isIDSHomeDisplayed()'"
							+ e.getLocalizedMessage());
		}
		return flag;
	}
	
	/**
	 * Checks if is signout.
	 *
	 * @author SulakkhanaW
	 * @param value the value
	 * @return true, if is signout
	 * @throws Exception the exception
	 */
	public boolean isSignout(String value) throws Exception{
		flag = false;
		logger.debug("Validating Sign out");
		try {
			if (getElement(lnkSignout).getText().equalsIgnoreCase(value)){
				flag = true;
				logger.debug("Sign out success");
			} else {
				logger.debug("Sign out failed");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating sign out 'isSignout()'" + e.getMessage());
			throw new Exception("Exception While Validating sign out 'isSignout()'" + e.getLocalizedMessage());
		}
		return flag;
	}
	
	/**
	 * Click configure.
	 *
	 * @author SulakkhanaW
	 */
	public void clickConfigure(){
		logger.debug("Clicking on configure");
		getElement(lblConfigure).click();
		logger.debug("Clicked on configure");
	}

	/**
	 * Click main.
	 *
	 * @author SulakkhanaW
	 */
	public void clickMain(){
		logger.debug("Clicking on main");
		getElement(lblMain).click();
		logger.debug("Clicked on main");
	}

	/**
	 * Click Feature.
	 *
	 * @author RajithK
	 */
	public void clickFeature(){
		logger.debug("Clicking on Features");
     	getElement(linkFeatures).click();
		logger.debug("Clicked on Features");
	}

	/**
	 * Click Repository Management tab.
	 *
	 * @author RajithK
	 */
	public void clickRepoMgt(){
		logger.debug("Clicking on Repository Management tab");
		getElement(repoMgtTab).click();
		logger.debug("Clicked on Repository Management tab");
	}

	/**
	 * Click Add Repository button.
	 *
	 * @author RajithK
	 */
	public void clickAddRepo() throws Exception{
		logger.debug("Clicking on Add Repository button");
		Thread.sleep(2000);
		getElement(buttonAddRepo).click();
		Thread.sleep(3000);
		logger.debug("Clicked on Add Repository button");
	}

	/**
	 * Set Repository values.
	 *
	 * @author RajithK
	 */
	public void setRepositoryValues(String name, String locationUrl) throws Exception{
		logger.debug("Going to Set Name to text field");
		this.getElement(this.txtFiledName).sendKeys(Keys.ENTER);
		this.getElement(this.txtFiledName).clearAndSendkeys(name);
		logger.debug("Going to Set Location Url to text field");
		this.getElement(this.locationUrl).sendKeys(Keys.ENTER);
		this.getElement(this.locationUrl).clearAndSendkeys(locationUrl);
		logger.debug("Clicking on Add button");
		Thread.sleep(2000);
		getElement(addButton).click();
     	Thread.sleep(800);
		logger.debug("Clicking on ok button");
		getElement(okButton).click();
		Thread.sleep(6000);
		logger.debug("set repository values completed");
	}

	/**
	 * Click Available Features tab.
	 *
	 * @author RajithK
	 */
	public void clickAvlblFeature() throws Exception{
		logger.debug("Clicking on Available Features tab");
		getElement(avlblFeatureTab).click();
		Thread.sleep(3000);
		logger.debug("Clicked on Available Features tab");
	}

	/**
	 * Click Find Feature button.
	 *
	 * @author RajithK
	 */
	public void clickFindFeature() throws Exception{
		logger.debug("Clicking on find feature button");
		getElement(findFeatureButton).click();
		Thread.sleep(1000);
		getElement(okButton).click();
		logger.debug("Clicked on find feature button");
		Thread.sleep(3500);
	}

	/**
	 * Click api Key Manager button.
	 *
	 * @author RajithK
	 */
	public void clickApiKeyManager() throws Exception{
		logger.debug("Clicking on apiKeyManager button");
		getElement(apiKeyManagerButton).click();
		Thread.sleep(2000);
		logger.debug("Clicked on apiKeyManager button");
	}

	/**
	 * Click api Manager version button.
	 *
	 * @author RajithK
	 */
	public void clickApiKeyManagerVersion() throws Exception{
		logger.debug("Clicking on apiKeyManagerVersion button");
		getElement(apiKeyManagerVersionButton).click();
		Thread.sleep(2000);
		logger.debug("Clicked on apiKeyManagerVersion button");
	}

	/**
	 * Click api Manager version button.
	 *
	 * @author RajithK
	 */
	public void tickApiManagement(){
		logger.debug("Clicking on api Management button");
		getElement(apiManagementButton).click();
		logger.debug("Clicked on api Management button");
	}

	/**
	 * Click installButton button.
	 *
	 * @author RajithK
	 */
	public void clickInstall() throws Exception{
		logger.debug("Clicking on clickInstall");
		getElement(installButton).click();
		Thread.sleep(3000);
		logger.debug("Clicked on clickInstall");
	}

	/**
	 * Continue install process.
	 *
	 * @author RajithK
	 */
	public void installFeature(String installing, String complete) throws Exception{
		logger.debug("Clicking on next button");
		getElement(installNextButton).click();
		Thread.sleep(1500);
		logger.debug("Clicking on accept radio button");
		getElement(acceptButton).click();
		logger.debug("Clicking on accept Next button");
		getElement(acceptedNextButton).click();
		logger.debug("Validate on installing label title");
		if(isLabelAvailable(1, installing)) {
			Thread.sleep(10000);
			logger.debug("Validate on install complete label title");
			isLabelAvailable(2, complete);
		}
		logger.debug("clicking restart later button");
		getElement(restartLaterButton).click();
		logger.debug("Install Feature complete");
	}


	/**
	 * Checks if is menu list displayed.
	 *
	 * @author SulakkhanaW
	 * @param menuList the menu list
	 * @return true, if is menu list displayed
	 * @throws Exception the exception
	 */
	public boolean isMenuListDisplayed(String menuList) throws Exception {

		flag = false;
		logger.debug("Validating Menu tab");
		Thread.sleep(sleepTime);
		try {
			if (menuList.contains(getElement(lblServiceProvider).getText())) {
				flag = true;
				logger.debug("Validating Menu tab completed");
			} else {
				logger.debug("Menu tab Not Matched");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating Menu tab Page Title 'isMenuListDisplayed()'" + e.getMessage());
			throw new Exception("Exception While Validating Menu tab Page Title 'isMenuListDisplayed()'" + e.getLocalizedMessage());
		}
		return flag;
	}
	
	/**
	 * Click list.
	 *
	 * @author SulakkhanaW
	 */
	public void clickList(){
		logger.debug("Clicking on list");
		getElement(lnkList).click();
		logger.debug("Clicked on list");
	}
	
	/**
	 * Click browse.
	 *
	 * @author SulakkhanaW
	 * @throws Exception 
	 */
	public void clickBrowse() throws Exception{
		logger.debug("Clicking on Browse");
		try {
			logger.debug("Validating Resources link already clicked");
			if (getElement(lblResources).getAttribute("style").equalsIgnoreCase("display: none;")){
				logger.debug("Validating Resources link is not clicked");
				logger.debug("Clicking on resources link");
				getElement(lnkResources).click();
				logger.debug("Clicked on resources link");
				getElement(lnkBrowse).click();
				logger.debug("Clicked on Browse");
			} else {
				logger.debug("Validating Resources link is clicked");
				logger.debug("Clicking on Browse");
				getElement(lnkBrowse).click();
				logger.debug("Clicked on Browse");
			}
		} catch (Exception e) {
			logger.debug("Exception While clicking browse link 'clickBrowse()'" + e.getMessage());
			throw new Exception("Exception While clicking browse link 'clickBrowse()'" + e.getLocalizedMessage());
		}
	}


	/**
	 * Checks if the label is available.
	 *
	 * @author RajithK
	 * @param step of the title
	 *             1 installing
	 *             2 install completed
	 * @param label the label
	 * @return true, if the label is matching
	 * @throws Exception the exception
	 */
	private boolean isLabelAvailable(int step, String label) throws Exception {
		flag = false;
		logger.debug("switch statement: Validating installing process step " + step + " label " + label);
		switch (step) {
			case 1:
				return label.contains(getElement(installingProcess).getText().trim());
			case 2:
				return label.contains(getElement(installComplete).getText().trim());
			default:
				return flag;
		}
	}
}
