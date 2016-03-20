package com.wso2telco.identityserver.pageobjects;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.wso2telco.test.framework.core.WebPelement;
import com.wso2telco.test.framework.element.table.Table;
import com.wso2telco.test.framework.util.UIType;

public class ClaimsListPage extends CarbonLeftNav {

	Logger logger = Logger.getLogger(ClaimsListPage.class);
	WebPelement inputDisplayOrder = defineEelement(UIType.Xpath,
			"//*[@id='displayOrder']");
	WebPelement inputSupported = defineEelement(UIType.Xpath,
			"//*[@id='supported']");
	WebPelement inputRequired = defineEelement(UIType.Xpath,
			"//*[@id='required']");
	WebPelement headerForClaim = defineEelement(UIType.Xpath,
			"//*[@id='middle']/h2");

	public ClaimsListPage(WebDriver driver) {
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

	public boolean getClaimDialects(String dialects) throws Exception {

		Table dialect = getTable(UIType.ClassName, "styledLeft");

		List<WebElement> listEle = dialect.body().getAllRows();

		for (WebElement e : listEle) {
			if (e.findElement(By.xpath("./td/a")).getText().trim()
					.equalsIgnoreCase(dialects)) {
				e.findElement(By.xpath("./td/a")).click();
				break;
			}
		}
		return verifyClaimDialectPage(dialects);

	}

	public boolean isClaimAvailable(String claimItem) {
		String tmp = "//div/a/span[text() = '" + claimItem + "']";
		WebPelement claimItemSelect = defineEelement(UIType.Xpath, tmp);
		flag = getElement(claimItemSelect).isAvailable();
		return flag;

	}

	public void editClaimDetail(String claimItem, String displayOrder,
			boolean isSupportedDefault, boolean isRequired) {
		String tmp = "//div/a/span[text() = '" + claimItem + "']";
		WebPelement claimItemSelect = defineEelement(UIType.Xpath, tmp);
		getElement(claimItemSelect).findElement(By.xpath("../../a[2]")).click();

		if (displayOrder != null) {
			enterDisplayOrder(displayOrder);
		}

		if (isSupportedDefault) {
			checkedElement(inputSupported);
		} else {
			unCheckedElement(inputSupported);
		}

		if (isRequired) {
			checkedElement(inputRequired);
		} else {
			unCheckedElement(inputRequired);
		}

		update();

	}

	public void update() {
		Table ele = getTable(UIType.ClassName, "styledLeft");
		ele.body().getRow(1).findElement(By.xpath("./td/input[1]")).click();
	}

	public void enterDisplayOrder(String order) {

		getElement(inputDisplayOrder).clearAndSendkeys(order);

	}

	public void checkedElement(WebPelement pelement) {
		if (!isCheckedElement(pelement)) {
			getElement(pelement).click();
			logger.debug("Element is checked now");
		}

	}

	public void unCheckedElement(WebPelement pelement) {
		if (isCheckedElement(pelement)) {
			getElement(pelement).click();
			logger.debug("Element is unchecked now");
		}

	}

	public boolean isCheckedElement(WebPelement pelement) {
		boolean isChecked = false;
		try {
			logger.debug("isChecked "
					+ getElement(pelement).getAttribute("checked"));
			isChecked = Boolean.parseBoolean(getElement(pelement).getAttribute(
					"checked"));
			logger.debug("Element is checked");

		} catch (Exception e) {
			// TODO: handle exception
			logger.debug("Element is Unchecked");
		}

		return isChecked;

	}

}
