package com.wso2telco.test.carbon.pageobjects.carbon.steps;

import org.junit.Assert;
import org.w3c.dom.Document;

import com.wso2telco.identityserver.pageobjects.carbon.CarbonResourceBrowse;
import com.wso2telco.identityserver.util.data.RateCardReader;
import com.wso2telco.identityserver.util.data.RateCardXML;
import com.wso2telco.test.carbon.pageobjects.carbon.steps.BasicTestObject;
import com.wso2telco.test.framework.tools.xml.XMLReader;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class IDServerResourcesBrowse extends BasicTestObject {
	
	@Then("^I should see the identity server Resources Browse page header as \"([^\"]*)\"$")
	public void i_should_see_the_identity_server_Resources_Browse_page_header_as(String arg1) throws Throwable {
		CarbonResourceBrowse browsePage = new CarbonResourceBrowse(driver);
		Assert.assertTrue("Resources Browse page not load properly", browsePage.isBrowsePage(arg1));
	}
	
	@When("^I search rate card by providing \"([^\"]*)\" location$")
	public void i_search_rate_card_by_providing_location(String arg1) throws Throwable {
		CarbonResourceBrowse browsePage = new CarbonResourceBrowse(driver);
		browsePage.serachRateCard(arg1);
		Thread.sleep(sleepTime);
	}
	
	@Then("^I should be able to search rate card$")
	public void i_should_be_able_to_search_rate_card() throws Throwable {
		CarbonResourceBrowse browsePage = new CarbonResourceBrowse(driver);
		Assert.assertTrue("Rate card did not search", browsePage.isRateCardSearch());
	}
	
	@When("^I click on rate card display as text link$")
	public void i_click_on_rate_card_display_as_text_link() throws Throwable {
		CarbonResourceBrowse browsePage = new CarbonResourceBrowse(driver);
		browsePage.clickDisplayAsText();
		String rateCardText = browsePage.getRateCard();
		RateCardXML rateCard = new RateCardXML();
		rateCard.setRateCardXMl(rateCardText);
		XMLReader xmlreader = new XMLReader();
		Document doc = xmlreader.readXMLFile(projectPath + config.getValue("rateCardXML"));
		RateCardReader rateCardReader = new RateCardReader();
		rateCardReader.checkXML(doc);
	}
	
	@When("^I upload \"([^\"]*)\" rate card file from \"([^\"]*)\" location$")
	public void i_upload_rate_card_file_from_location(String arg1, String arg2) throws Throwable {
		String rateCardFilePath = projectPath + config.getValue("uploadRateCard") + arg2 + arg1;
		CarbonResourceBrowse browsePage = new CarbonResourceBrowse(driver);
		Thread.sleep(sleepTime);
		browsePage.uploadRateCard(rateCardFilePath);
	}

}
