package com.wso2telco.test.carbon.pageobjects.carbon.steps;

import org.junit.Assert;

import com.wso2telco.identityserver.pageobjects.CarbonLeftNav;
import com.wso2telco.identityserver.pageobjects.carbon.CarbonRolesPage;
import com.wso2telco.identityserver.pageobjects.carbon.CarbonUserRoles;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class IDServerUserRoles extends BasicTestObject {
	
	@When("^I click identity server User Management Roles link$")
	public void i_click_identity_server_User_Management_Roles_link() throws Throwable {
		CarbonUserRoles carbonUserRolePage = new CarbonUserRoles(driver);
		carbonUserRolePage.clickRolesLink();
	}
	
	@Then("^I should see ids User Management Roles page header as \"([^\"]*)\"$")
	public void i_should_see_ids_User_Management_Roles_page_header_as(String arg1) throws Throwable {
	    CarbonRolesPage carbonRoles = new CarbonRolesPage(driver);
	    Assert.assertTrue("Roles page did not load properly",carbonRoles.isRolePage(arg1));
	}

	@When("^I click on ids User Management Roles add new role link$")
	public void i_click_on_ids_User_Management_Roles_add_new_role_link() throws Throwable {
		 CarbonLeftNav leftNav = new CarbonLeftNav(driver);
		 leftNav.clickUserRolesAdd();
		 CarbonRolesPage carbonRoles = new CarbonRolesPage(driver);
		 carbonRoles.clickAddNewRole();
	}

	@Then("^I should see ids User Management Add Role page header as \"([^\"]*)\"$")
	public void i_should_see_ids_User_Management_Add_Role_page_header_as(String arg1) throws Throwable {
		CarbonRolesPage carbonRoles = new CarbonRolesPage(driver);
	    Assert.assertTrue("Add Role page did not load properly",carbonRoles.isAddRolesPage(arg1));
	}

	@When("^I enter ids Add Role role name as \"([^\"]*)\"$")
	public void i_enter_ids_Add_Role_role_name_as(String arg1) throws Throwable {
		CarbonRolesPage carbonRoles = new CarbonRolesPage(driver);
		carbonRoles.enterRoleName(arg1);
	}

	@When("^I click on ids Add Role next button$")
	public void i_click_on_ids_Add_Role_next_button() throws Throwable {
		CarbonRolesPage carbonRoles = new CarbonRolesPage(driver);
		carbonRoles.clickNext();
	}

	@Then("^I should see ids Add Role Select permission to Add Role page header as \"([^\"]*)\"$")
	public void i_should_see_ids_Add_Role_Select_permission_to_Add_Role_page_header_as(String arg1) throws Throwable {
		CarbonRolesPage carbonRoles = new CarbonRolesPage(driver);
	    Assert.assertTrue("Select permission to Add Role page did not load properly",carbonRoles.isSelectPermission(arg1));
	}

	@When("^I click on ids Add Role Select permission to Add Role next button$")
	public void i_click_on_ids_Add_Role_Select_permission_to_Add_Role_next_button() throws Throwable {
		CarbonRolesPage carbonRoles = new CarbonRolesPage(driver);
		carbonRoles.clickNext();
	}

	@Then("^I should see ids Add Role Select Users to Add Role page header as \"([^\"]*)\"$")
	public void i_should_see_ids_Add_Role_Select_Users_to_Add_Role_page_header_as(String arg1) throws Throwable {
		CarbonRolesPage carbonRoles = new CarbonRolesPage(driver);
		Assert.assertTrue("Select Users to Add Role page did not load properly",carbonRoles.isSelectUsers(arg1));
	}

	@When("^I enter ids Select Users to Add Role user name pattern as \"([^\"]*)\"$")
	public void i_enter_ids_Select_Users_to_Add_Role_user_name_pattern_as(String arg1) throws Throwable {
		CarbonRolesPage carbonRoles = new CarbonRolesPage(driver);
		carbonRoles.eneterSearchValue(config.getValue( arg1 ));
	}

	@When("^I click on ids Select Users to Add Role search$")
	public void i_click_on_ids_Select_Users_to_Add_Role_search() throws Throwable {
		CarbonRolesPage carbonRoles = new CarbonRolesPage(driver);
		carbonRoles.clickSearchUsers();
	}

	@When("^I select ids Select Users to Add Role \"([^\"]*)\" check box$")
	public void i_select_ids_Select_Users_to_Add_Role_check_box(String arg1) throws Throwable {
		CarbonRolesPage carbonRoles = new CarbonRolesPage(driver);
		carbonRoles.selectUser(config.getValue(arg1 ));
	}

	@When("^I click on ids Select Users to Add Role Finish$")
	public void i_click_on_ids_Select_Users_to_Add_Role_Finish() throws Throwable {
		CarbonRolesPage carbonRoles = new CarbonRolesPage(driver);
		carbonRoles.clickFinish();
	}

	@Then("^I should see ids Add Role Success pop up message as \"([^\"]*)\"$")
	public void i_should_see_ids_Add_Role_Success_pop_up_message_as(String arg1) throws Throwable {
		CarbonRolesPage carbonRoles = new CarbonRolesPage(driver);
		Thread.sleep(sleepTime);
		Assert.assertTrue("Success message loaded properly", carbonRoles.isSuccessPopup(arg1));
	}

	@Then("^I should see identity server User Management page header as \"([^\"]*)\"$")
	public void i_should_see_identity_server_User_Management_page_header_as(String arg1) throws Throwable {
		CarbonUserRoles carbonUserRolesPage = new CarbonUserRoles(driver);
		Thread.sleep(sleepTime);
		Assert.assertTrue("Users page did not load properly",carbonUserRolesPage.isSystemUserStore(arg1));
	}
	
	@When("^I click carbon server User Management Users link$")
	public void i_click_identity_server_User_Management_Users_link() throws Throwable {
		CarbonUserRoles carbonUserRolesPage = new CarbonUserRoles(driver);
		Thread.sleep(sleepTime);
		carbonUserRolesPage.clickUsersLink();
	}

	@Then("^I should see carbon User Management Users page header as \"([^\"]*)\"$")
	public void i_should_see_ids_User_Management_Users_page_header_as(String arg1) throws Throwable {
		CarbonUserRoles carbonUserRolesPage = new CarbonUserRoles(driver);
		Thread.sleep(sleepTime);
		Assert.assertTrue("User page did not load properly", carbonUserRolesPage.isUserPage(arg1));
	}

	@When("^I enter identity server Search Users to Enter user name pattern as \"([^\"]*)\"$")
	public void i_enter_identity_server_Search_Users_to_Enter_user_name_pattern_as(String arg1) throws Throwable {
		CarbonUserRoles carbonUserRolesPage = new CarbonUserRoles(driver);
		Thread.sleep(sleepTime);
		carbonUserRolesPage.setSearchCriteria(config.getValue( arg1 ));
	}

	@When("^I click on identity server Users search button$")
	public void i_click_on_identity_server_Users_search_button() throws Throwable {
		CarbonUserRoles carbonUserRolesPage = new CarbonUserRoles(driver);
		Thread.sleep(sleepTime);
		carbonUserRolesPage.clickUserSearchButton();
	}
	
	@Then("^I should see the \"([^\"]*)\" on ids Users search area$")
	public void i_should_see_the_on_ids_Users_search_area(String arg1) throws Throwable {
		CarbonUserRoles carbonUserRolesPage = new CarbonUserRoles(driver);
		Thread.sleep(sleepTime);
		Assert.assertTrue("Username is not there on the search result area",carbonUserRolesPage.isUserSearch(config.getValue( arg1 )));
	}
	
	@When("^I click on ids Users view roles link and delete existing Publisher role from the user$")
	public void i_click_on_ids_Users_view_roles_link_and_delete_existing_Publisher_role_from_the_user() throws Throwable {
		CarbonUserRoles carbonUserRolesPage = new CarbonUserRoles(driver);
		Thread.sleep(sleepTime);
		carbonUserRolesPage.clickUsersViewRoles();
		Thread.sleep(sleepTime);
		if (carbonUserRolesPage.isPublisherRole()){
			Thread.sleep(sleepTime);
			carbonUserRolesPage.untickInternalPublisher();
			/*if (carbonUserRolesPage.isInternalSubscriber()){
				carbonUserRolesPage.untickInternalSubscriber();
			}*/
			Thread.sleep(sleepTime);
			carbonUserRolesPage.clickEditRolesFinish();
			Thread.sleep(sleepTime);
			carbonUserRolesPage.clickEditRolesSuccessMsgOk();
		} else {
			Thread.sleep(sleepTime);
			carbonUserRolesPage.clickEditRolesCancel();
		}
	}
	
	@When("^I click on ids Users assign roles link under \"([^\"]*)\"$")
	public void i_click_on_ids_Users_assign_roles_link_under(String arg1) throws Throwable {
		CarbonUserRoles carbonUserRolesPage = new CarbonUserRoles(driver);
		Thread.sleep(sleepTime);
		carbonUserRolesPage.clickAssignRoles(config.getValue( arg1 ));		
	}

	@Then("^I should see the ids List of roles page table header as \"([^\"]*)\"$")
	public void i_should_see_the_ids_List_of_roles_page_table_header_as(String arg1) throws Throwable {
		CarbonUserRoles carbonUserRolesPage = new CarbonUserRoles(driver);
		Thread.sleep(sleepTime);
		Assert.assertTrue("Assign role page did not load properly", carbonUserRolesPage.isAssignRolesPage(arg1));	
	}
	
	@When("^I enter ids Role list of users Enter role name pattern as \"([^\"]*)\"$")
	public void i_enter_ids_Role_list_of_users_Enter_role_name_pattern_as(String arg1) throws Throwable {
		CarbonUserRoles carbonUserRolesPage = new CarbonUserRoles(driver);
		carbonUserRolesPage.enterRoleNamePattern(arg1);
	}
	
	@When("^I click on ids List of roles search button$")
	public void i_click_on_ids_List_of_roles_search_button() throws Throwable {
		CarbonUserRoles carbonUserRolesPage = new CarbonUserRoles(driver);
		carbonUserRolesPage.clickRoleSearch();	
		Thread.sleep(sleepTime);
	}
	
	@Then("^I should see ids List of roles search area as \"([^\"]*)\"$")
	public void i_should_see_ids_List_of_roles_search_area_as(String arg1) throws Throwable {
		CarbonUserRoles carbonUserRolesPage = new CarbonUserRoles(driver);
		Thread.sleep(sleepTime);
		Assert.assertTrue(arg1 + " Role did not appear in the search area",carbonUserRolesPage.isRolesSearchArea(arg1));
	}
	
	@When("^I click on ids List of roles \"([^\"]*)\" permissions link$")
	public void i_click_on_ids_List_of_roles_permissions_link(String arg1) throws Throwable {
		CarbonUserRoles carbonUserRolesPage = new CarbonUserRoles(driver);
		Thread.sleep(sleepTime);
		carbonUserRolesPage.clickRolesPermission(arg1);
	}

	@Then("^I should see the ids permissions of the role page header as \"([^\"]*)\"$")
	public void i_should_see_the_ids_permissions_of_the_role_page_header_as(String arg1) throws Throwable {
		CarbonUserRoles carbonUserRolesPage = new CarbonUserRoles(driver);
		Thread.sleep(sleepTime);
		Assert.assertTrue("Role permission page did not load properly",carbonUserRolesPage.isRolePermissionPage(arg1));
	}
	
	@Then("^ids permissions of the role page Publish check box should be checked$")
	public void ids_permissions_of_the_role_page_Publish_check_box_should_be_checked() throws Throwable {
		CarbonUserRoles carbonUserRolesPage = new CarbonUserRoles(driver);
		Thread.sleep(sleepTime);
		Assert.assertTrue("Publisher role did not selected bydefault",carbonUserRolesPage.isPublisherRoleChecked());
	}
	
	@When("^I click on ids Permissions of the role page create check box$")
	public void i_click_on_ids_Permissions_of_the_role_page_create_check_box() throws Throwable {
		CarbonUserRoles carbonUserRolesPage = new CarbonUserRoles(driver);
		carbonUserRolesPage.clickCreatePermission();
	}
	
	@When("^I click on ids Permissions of the role page update button$")
	public void i_click_on_ids_Permissions_of_the_role_page_update_button() throws Throwable {
		CarbonUserRoles carbonUserRolesPage = new CarbonUserRoles(driver);
		carbonUserRolesPage.clickUpdate();		
	}
	
	@Then("^ids Role update success message should pop up \"([^\"]*)\"$")
	public void ids_Role_update_success_message_should_pop_up(String arg1) throws Throwable {
		CarbonUserRoles carbonUserRolesPage = new CarbonUserRoles(driver);
		Assert.assertTrue("Success message did not load properly",carbonUserRolesPage.isRoleAssignUpdate(arg1));
	}
	
	@When("^I click on ids Role update success message ok button$")
	public void i_click_on_ids_Role_update_success_message_ok_button() throws Throwable {
		CarbonUserRoles carbonUserRolesPage = new CarbonUserRoles(driver);
		carbonUserRolesPage.clickOK();
	}
	
	@When("^I checked the ids List of roles \"([^\"]*)\" check box$")
	public void i_checked_the_ids_List_of_roles_check_box(String arg1) throws Throwable {
		CarbonUserRoles carbonUserRolesPage = new CarbonUserRoles(driver);
		carbonUserRolesPage.clickRolesSearchArea(arg1);
	}
	
	@When("^I click on ids List of roles finish button$")
	public void i_click_on_ids_List_of_roles_finish_button() throws Throwable {
		CarbonUserRoles carbonUserRolesPage = new CarbonUserRoles(driver);
		carbonUserRolesPage.clickFinish();
	}
	
	@Then("^ids List of roles Role update success message should pop up \"([^\"]*)\"$")
	public void ids_List_of_roles_Role_update_success_message_should_pop_up(String arg1) throws Throwable {
		CarbonUserRoles carbonUserRolesPage = new CarbonUserRoles(driver);
		Assert.assertTrue("Success message did not load properly",carbonUserRolesPage.isRoleAssignUpdate(arg1));
	}
	
	@When("^I click on List of roles Role update success message ok button$")
	public void i_click_on_List_of_roles_Role_update_success_message_ok_button() throws Throwable {
		CarbonUserRoles carbonUserRolesPage = new CarbonUserRoles(driver);
		carbonUserRolesPage.clickOK();
	}

	@When("^I close the browser$")
	public void I_close_the_browser() throws Throwable {
		driver.close();
		openBrowser();
		driver.get(config.getValue( "ApiManagerSiteName"));
	}
	
	@When("^I close the api manager$")
	public void i_close_the_api_manager() throws Throwable {
		driver.close();
		openBrowser();
		driver.get(config.getValue( "CarbonSiteName"));
	}
	
	@When("^I close the browser and reopen the browsers and navigate to apipublisher page$")
	public void i_close_the_browser_and_reopen_the_browsers_and_navigate_to_apipublisher_page() throws Throwable {
		driver.close();
		launchBrowser();
		Thread.sleep(sleepTime);
		driver.get(config.getValue("ApiManagerPublisher"));
	}
	
	@When("^I close the browser and navigate to activity manager$")
	public void i_close_the_browser_and_navigate_to_activity_manager() throws Throwable {
		driver.close();
		launchBrowser();
		Thread.sleep(sleepTime);
		driver.get(config.getValue("ActivityMonitor"));
	}

	@When("^I clear existing aggrigator role \"([^\"]*)\"$")
	public void i_clear_existing_aggrigator_role(String arg1) throws Throwable {
		CarbonRolesPage carbonRoles = new CarbonRolesPage(driver);
		carbonRoles.enterAggrigatorRoleName(arg1);
		carbonRoles.clickSearch();

		if (carbonRoles.isRoleVisible()) {
			carbonRoles.clickDelete();
			carbonRoles.clickYes();
			//Thread.sleep(3000);
			Thread.sleep(2000);
			carbonRoles.clickOK();
			//Thread.sleep(2000);
			//carbonRoles.clickOK();
			//
		} else {
			//Thread.sleep(4000);
			carbonRoles.clickOK();
			//Thread.sleep(5000);
		}
	}
   
   @When("^I click delete existing username as \"([^\"]*)\"$")
	public void i_click_delete_existing_username_as(String arg1) throws Throwable {
		CarbonRolesPage carbonRoles = new CarbonRolesPage(driver);
		Thread.sleep(sleepTime);
		if (carbonRoles.isUserNameVisible()) {
			carbonRoles.clickDeleteUser(config.getValue( arg1 + "user"));
			Thread.sleep(sleepTime);
			carbonRoles.clickYes();
			Thread.sleep(sleepTime);
			carbonRoles.clickOK();
		} else {
			Thread.sleep(sleepTime);
			carbonRoles.clickOK();
		}
	}
   
   @Then("^I search \"([^\"]*)\" from the roles list$")
   public void i_search_from_the_roles_list(String arg1) throws Throwable {
	   CarbonRolesPage carbonRoles = new CarbonRolesPage(driver);
       carbonRoles.enterRoleNameToSearch(arg1);
       carbonRoles.clickSearch();
   }
   
	@Then("^I assign the \"([^\"]*)\" for the \"([^\"]*)\" role$")
	public void i_assign_the_for_the_role(String arg1, String arg2)
			throws Throwable {
		String username=config.getValue(arg1 + "user");
		CarbonRolesPage carbonRoles = new CarbonRolesPage(driver);
		carbonRoles.clickOnAssignUsers();
		carbonRoles.enterUsernamePattern(username);
		carbonRoles.clickSearch();

		if (carbonRoles.isUserNameToAssignVisible(username)) {
			carbonRoles.selectUserToAssign(username);
			carbonRoles.clickFinish();
		}else{
			carbonRoles.clickOK();
		}
	}
	
	@Then("^I should see ids User Management Add User page header as \"([^\"]*)\"$")
	public void i_should_see_ids_User_Management_Add_User_page_header_as(String arg1) throws Throwable {
		CarbonUserRoles carbonUserRolesPage = new CarbonUserRoles(driver);
		Assert.assertTrue("Add User page did not load properly",carbonUserRolesPage.isAddUsersPage(arg1));
	}
	
	@When("^I enter ids Add User name as \"([^\"]*)\"$")
	public void i_enter_ids_Add_User_name_as(String arg1) throws Throwable {
		CarbonUserRoles carbonUserRolesPage = new CarbonUserRoles(driver);
		carbonUserRolesPage.enterUserName(config.getValue( arg1 ));
	}
	
	@When("^I enter ids Add User password as \"([^\"]*)\"$")
	public void i_enter_ids_Add_User_password_as(String arg1) throws Throwable {
		CarbonUserRoles carbonUserRolesPage = new CarbonUserRoles(driver);
		carbonUserRolesPage.enterPassword(config.getValue(arg1 + "_PWD"));
	}

	@When("^I enter ids Add User password repeat as \"([^\"]*)\"$")
	public void i_enter_ids_Add_User_password_repeat_as(String arg1) throws Throwable {
		CarbonUserRoles carbonUserRolesPage = new CarbonUserRoles(driver);
		carbonUserRolesPage.enterRepeatPassword(config.getValue(arg1 + "_PWD"));
	}
	
	@When("^I click on ids Add User next button$")
	public void i_click_on_ids_Add_User_next_button() throws Throwable {
		CarbonUserRoles carbonUserRolesPage = new CarbonUserRoles(driver);
		carbonUserRolesPage.clickNext();
	}
	
	@Then("^I should click on role \"([^\"]*)\" checkbox$")
	public void i_should_click_on_role_checkbox(String arg1) throws Throwable {
		CarbonUserRoles carbonUserRolesPage = new CarbonUserRoles(driver);
		carbonUserRolesPage.selectRolesForUser(arg1);
	}
	
	@Then("^I should see ids User Management Select Role for user page header as \"([^\"]*)\"$")
	public void i_should_see_ids_User_Management_Select_Role_for_user_page_header_as(String arg1) throws Throwable {
		CarbonUserRoles carbonUserRolesPage = new CarbonUserRoles(driver);
	    Assert.assertTrue("Select Role to Add User page did not load properly",carbonUserRolesPage.isSelectRoles(arg1));
	}

	@Then("^I should see ids Add User Success pop up message as \"([^\"]*)\"$")
	public void i_should_see_ids_Add_User_Success_pop_up_message_as(String arg1) throws Throwable {
		CarbonUserRoles carbonUserRolesPage = new CarbonUserRoles(driver);
		Assert.assertTrue("User creation success message pop up not displayed",carbonUserRolesPage.isUserCreationSuccess(arg1));
	}

	@Then("^I click on Success pop up message Ok button$")
	public void i_click_on_Success_pop_up_message_Ok_button() throws Throwable {
		CarbonUserRoles carbonUserRolesPage = new CarbonUserRoles(driver);
		carbonUserRolesPage.clickOK();
	}
	
	@Then("^I select role \"([^\"]*)\" to Add Role$")
	public void i_select_role_to_Add_Role(String arg1) throws Throwable {
		CarbonRolesPage carbonRoles = new CarbonRolesPage(driver);
		carbonRoles.selectRolePermission(arg1);
	}
	
	@When("^I clear existing users \"([^\"]*)\"$")
	public void i_clear_existing_users(String arg1) throws Throwable {
		CarbonRolesPage carbonRoles = new CarbonRolesPage(driver);
        carbonRoles.enterUsersName(config.getValue( arg1 ));
		carbonRoles.clickSearchUsers();

		if (carbonRoles.isUserNameVisible()) {
			carbonRoles.clickDeleteUser(config.getValue( arg1 ));
			carbonRoles.clickYes();
			Thread.sleep(2000);
			carbonRoles.clickOK();
			Thread.sleep(2000);
		} else {
			Thread.sleep(2000);
			carbonRoles.clickOK();
			Thread.sleep(2000);
		}
	} 
}
