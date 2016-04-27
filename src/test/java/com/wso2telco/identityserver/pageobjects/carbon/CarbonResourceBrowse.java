package com.wso2telco.identityserver.pageobjects.carbon;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.wso2telco.identityserver.pageobjects.BasicPageObject;
import com.wso2telco.test.framework.core.WebPelement;
import com.wso2telco.test.framework.util.UIType;

/**
 * The Class CarbonResourceBrowse.
 */
public class CarbonResourceBrowse extends BasicPageObject {

	/**
	 * Instantiates a new carbon resource browse.
	 *
	 * @author SulakkhanaW
	 * @param driver the driver
	 */
	public CarbonResourceBrowse(WebDriver driver) {
		super(driver);
	}
	
	/** The logger. */
	Logger logger = Logger.getLogger(CarbonHomePage.class);
	
	/** The lbl page header. */
	private WebPelement lblPageHeader = defineEelement(UIType.Xpath, "//div[@id='middle']/h2");
	
	/** The txt location. */
	private WebPelement txtLocation = defineEelement(UIType.Xpath, "//input[@id='uLocationBar']");
	
	/** The btn go. */
	private WebPelement btnGo = defineEelement(UIType.Xpath, "//input[@value='Go']");
	
	/** The lnk display as text. */
	private String lnkDisplayAsText = "//td/a[contains(text(),'Display as text')]";
	
	/** The lnk display as text element. */
	private WebPelement lnkDisplayAsTextElement = defineEelement(UIType.Xpath, lnkDisplayAsText);
	
	/** The txt rate card. */
	private WebPelement txtRateCard = defineEelement(UIType.Xpath, "//div[@id='generalContentDiv']/textarea");
	
	/** The lnk upload. */
	private WebPelement lnkUpload = defineEelement(UIType.Xpath, "//td/a[contains(.,'Upload')]");
	
	/** The txt upload location. */
	private WebPelement txtUploadLocation = defineEelement(UIType.ID, "uResourceFile");
	
	/** The btn uplaod. */
	private WebPelement btnUplaod = defineEelement(UIType.ID, "uploadContentButtonID");
	
	/**
	 * Checks if is browse page.
	 *
	 * @author SulakkhanaW
	 * @param pageHeader the page header
	 * @return true, if is browse page
	 * @throws Exception the exception
	 */
	public boolean isBrowsePage(String pageHeader) throws Exception{
		flag = false;
		logger.debug("Validating resources browse page");
		Thread.sleep(sleepTime);
		try {
			if (pageHeader.contains(getElement(lblPageHeader).getText().trim())) {
				flag = true;
				logger.debug("Validating resources browse page completed");
			} else {
				logger.debug("Resources browse page title Not Matched");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating resources browse page, Page Title 'isBrowsePage()'" + e.getMessage());
			throw new Exception("Exception While Validating resources browse page, Page Title 'isBrowsePage()'" + e.getLocalizedMessage());
		}
		return flag;
	}
	
	/**
	 * Serach rate card.
	 *
	 * @author SulakkhanaW
	 * @param location the location
	 */
	public void serachRateCard(String location){
		logger.debug("Entering location");
		getElement(txtLocation).clearAndSendkeys(location);
		logger.debug("Location entered");
		logger.debug("Clicking on Go");
		getElement(btnGo).click();
		logger.debug("Clicked on Go");
	}
	
	/**
	 * Checks if is rate card search.
	 *
	 * @author SulakkhanaW
	 * @return true, if is rate card search
	 * @throws Exception the exception
	 */
	public boolean isRateCardSearch() throws Exception{
		flag = false;
		logger.debug("Validating rate card search");
		List<WebElement> element = driver.findElements(By.xpath(lnkDisplayAsText));
		try {
			if (element.size() == 1){
				flag = true;
				logger.debug("Rate card searched");
			} else {
				logger.debug("Rate card search failed");
			}
		} catch (Exception e) {
			logger.debug("Exception While Validating rate card search 'isRateCardSearch()'" + e.getMessage());
			throw new Exception("Exception While Validating rate card search 'isRateCardSearch()'" + e.getLocalizedMessage());
		}
		return flag;
	}
	
	/**
	 * Click display as text.
	 *
	 * @author SulakkhanaW
	 */
	public void clickDisplayAsText(){
		logger.debug("Clicking on Displays as Text link");
		getElement(lnkDisplayAsTextElement).click();
		logger.debug("Clicked on Displays as Text link");
	}
	
	/**
	 * Gets the rate card.
	 *
	 * @author SulakkhanaW
	 * @return the rate card
	 */
	public String getRateCard(){
		logger.debug("Finding rate card text area");
		String ratecard = getElement(txtRateCard).getText();
		logger.debug("Rate card text area found");
		return ratecard;
	}
	
	/**
	 * Upload rate card.
	 *
	 * @author SulakkhanaW
	 * @param filename the filename
	 */
	public void uploadRateCard(String filename){
		logger.debug("Clicking on Upload link");
		getElement(lnkUpload).click();
		logger.debug("Clicked on Upload link");
		logger.debug("Sending upload file name");
		getElement(txtUploadLocation).clearAndSendkeys(filename);
		logger.debug("Upload file name send");
		logger.debug("Clicking on Upload button");
		getElement(btnUplaod).click();
		logger.debug("Clicked on Upload button");
	}

}
