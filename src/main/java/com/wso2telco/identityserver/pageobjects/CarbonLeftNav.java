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
	private WebPelement lnkUsersRolesList = defineEelement(UIType.Xpath, "//ul[@class='main']//li[contains(text(),'Users and Roles')]/following-sibling::li[1]/ul/li/a[text()='List']");
	private WebPelement lnkUserRolesAdd = defineEelement(UIType.Xpath, "//ul[@class='main']//li[contains(text(),'Users and Roles')]/following-sibling::li[1]/ul/li/a[text()='Add']");
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

	private WebPelement wso2orgclaims = defineEelement(UIType.Xpath,".//*[@id='workArea']/table/tbody/tr[6]/td[1]/a");
	
	private WebPelement emailEdit = defineEelement(UIType.Xpath, ".//*[@id='workArea']/div[19]/a[2]");
	private WebPelement firstNameEdit = defineEelement(UIType.Xpath, ".//*[@id='workArea']/div[23]/a[2]");
	private WebPelement lastNameEdit = defineEelement(UIType.Xpath, ".//*[@id='workArea']/div[33]/a[2]");
	
	private WebPelement claimRequire = defineEelement(UIType.Xpath, ".//*[@id='required']");
	
	private WebPelement claimUpdate = defineEelement(UIType.Xpath, ".//*[@id='workArea']/form/table/tbody/tr[2]/td/input[1]");
	
	private WebPelement shutdownRestart = defineEelement(UIType.Xpath, ".//*[@id='menu']/ul/li[9]/ul/li[7]/a");
	
	private WebPelement gracefulRestart = defineEelement(UIType.Xpath, ".//*[@id='restart']/tbody/tr[3]/td[1]/a");
	
	private WebPelement clickYes = defineEelement(UIType.Xpath, "html/body/div[3]/div[2]/button[1]");
	
	private WebPelement clickOK = defineEelement(UIType.Xpath, "html/body/div[3]/div[2]/button");
	
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
	
	public void clickUserRolesAdd(){
		getElement(lnkUserRolesAdd).click();
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
	
	public void clickWSO2OrgClaims(){
		getElement(wso2orgclaims).click();
	}
	
	public void clickEmailEdit(){
		getElement(emailEdit).click();
	}
	
	public void clickFirstNameEdit(){
		getElement(firstNameEdit).click();
	}
	
	public void clickLastNameEdit(){
		getElement(lastNameEdit).click();
	}
	
	public void clickClaimrequire(){
		getElement(claimRequire).click();
	}
	
	public void clickClaimUpdate(){
		getElement(claimUpdate).click();
	}
	
	public void clickShutdownRestart(){
		getElement(shutdownRestart).click();
	}
	
	public void clickGracefulRestart(){
		getElement(gracefulRestart).click();
	}
	
	public void clickYes(){
		getElement(clickYes).click();
	}
	
	public void clickOK(){
		getElement(clickOK).click();
	}
}
