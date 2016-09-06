package com.wso2telco.identityserver.pageobjects;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.wso2telco.test.framework.core.WebPelement;
import com.wso2telco.test.framework.element.table.Table;
import com.wso2telco.test.framework.util.UIType;

public class ClaimsAddPage extends CarbonLeftNav {

	Logger logger = Logger.getLogger(ClaimsAddPage.class);

	WebPelement selectDialect = defineEelement(UIType.Xpath,
			"//*[@id='dialect']");
	WebPelement inputDisplayName = defineEelement(UIType.Xpath,
			"//*[@id='displayName']");
	WebPelement inputDescription = defineEelement(UIType.Xpath,
			"//*[@id='description']");
	WebPelement inputClaimUri = defineEelement(UIType.Xpath,
			"//*[@id='claimUri']");
	WebPelement inputAttribute = defineEelement(UIType.Xpath,
			"//*[@id='attribute']");
	WebPelement headerForClaim = defineEelement(UIType.Xpath,
			"//*[@id='middle']/h2");

	public ClaimsAddPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public boolean verifyClaimDialectPage(String claimDialect) throws Exception {
		flag = false;
		String h2 = "Available Claims for " + claimDialect;
		logInstruction("Validating Claim page");
		try {
			if (getElement(headerForClaim).getText().trim().equals(h2)) {
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

	public boolean getLink(String dialects) throws Exception {

		Table dialect = getTable(UIType.ClassName, "styledLeft");

		List<WebElement> listEle = dialect.body().getAllRows();

		for (WebElement e : listEle) {
			if (e.findElement(By.xpath("./td/div/a")).getText().trim()
					.equalsIgnoreCase(dialects)) {
				e.findElement(By.xpath("./td/div/a")).click();
				break;
			}
		}
		return verifyClaimDialectPage(dialects);

	}

	public void selectDialect(String dialect) {

		String xpathOption = "//*[@id='dialect']/option[@value='" + dialect
				+ "']";

		WebPelement selectVal = defineEelement(UIType.Xpath, xpathOption);
		getElement(selectVal).click();

	}

	public void addClaimWithMandatoryField(String dialect, String displayName,
			String descripton, String claimUri, String mapAtrribute) {

		selectDialect(dialect);
		enterDisplayName(displayName);
		enterDescripton(descripton);
		enterClaimUri(claimUri);
		enterMappedAttribute(mapAtrribute);
		Add();
	}

	public void enterDisplayName(String displayName) {

		getElement(inputDisplayName).clearAndSendkeys(displayName);

	}

	public void enterDescripton(String descripton) {

		getElement(inputDescription).clearAndSendkeys(descripton);

	}

	public void enterClaimUri(String claimUri) {

		getElement(inputClaimUri).clearAndSendkeys(claimUri);

	}

	public void enterMappedAttribute(String mapAtrribute) {

		getElement(inputAttribute).clearAndSendkeys(mapAtrribute);

	}

	public void Add() {
		Table ele = getTable(UIType.ClassName, "styledLeft");
		ele.body().getRow(1).findElement(By.xpath("./td/input[1]")).click();
	}

}
