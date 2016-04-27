package com.wso2telco.identityserver.pageobjects;

import org.openqa.selenium.WebDriver;

import com.wso2telco.test.framework.core.WebPelement;
import com.wso2telco.test.framework.util.UIType;

public class CarbonLeftNav extends BasicPageObject {

	private WebPelement mainBttn = defineEelement(UIType.Xpath,
			"//span[text()='Main']/..");
	//private WebPelement lblUsername = defineEelement(UIType.Xpath, ".//div[@id='middle']/h2");
	private WebPelement menuConfigure = defineEelement(UIType.ID,
			"menu-panel-button3");
	private WebPelement lnkUsersRoles = defineEelement(UIType.Xpath,
			".//a[contains(text(),'Users and Roles')]");
	private WebPelement lnkUsersRolesList = defineEelement(
			UIType.Xpath,
			"//ul[@class='main']//li[contains(text(),'Users and Roles')]/following-sibling::li[1]/ul/li/a[text()='List']");
	private WebPelement lnkServiceProviderList = defineEelement(
			UIType.Xpath,
			"//ul[@class='main']//li[contains(text(),'Service Providers')]/following-sibling::li[1]/ul/li/a[text()='List']");
	//private WebPelement lnkServiceProviderAdd = defineEelement(UIType.Xpath, "//ul[@class='main']//li[contains(text(),'Service Providers')]/following-sibling::li[1]/ul/li/a[text()='Add']");
	private WebPelement lnkClaimList = defineEelement(
			UIType.Xpath,
			"//ul[@class='main']//li[contains(text(),'Claims')]/following-sibling::li[1]/ul/li/a[text()='List']");
	private WebPelement lnkClaimAdd = defineEelement(
			UIType.Xpath,
			"//ul[@class='main']//li[contains(text(),'Claims')]/following-sibling::li[1]/ul/li/a[text()='Add']");

	public CarbonLeftNav(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void clickConfigure() {
		getElement(menuConfigure).click();
	}

	public void clickMain() {
		getElement(mainBttn).click();
	}

	public void clickUserRoles() {
		getElement(lnkUsersRoles).click();
	}

	public void clickUserRolesList() {
		getElement(lnkUsersRolesList).click();
	}

	public void clickServiceProviderList() {
		getElement(lnkServiceProviderList).click();
	}

	public ClaimsListPage getClaimsListPage() {
		getElement(lnkClaimList).click();

		return new ClaimsListPage(driver);

	}

	public ClaimsAddPage getClaimsAddPage() {
		getElement(lnkClaimAdd).click();

		return new ClaimsAddPage(driver);

	}
}
