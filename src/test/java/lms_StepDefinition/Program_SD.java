package lms_StepDefinition;

import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import context.PicoContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lms_PageObject.Dashboard;
import lms_PageObject.LoginPage;
import lms_PageObject.ProgramPage;
import lms_Utils.ConfigReader;
import lms_Utils.LoggerLoad;

public class Program_SD {

	WebDriver driver;
	LoginPage lo;
	Dashboard db;
	ProgramPage programpage;
	PicoContext pico;
	SoftAssert softAssert = new SoftAssert();

	public Program_SD(PicoContext pico) {
		this.pico = pico;
		this.driver = pico.getDriver();
		this.lo = pico.getLogin();
		this.db = pico.getDashboardPage();
		this.programpage = pico.getProgramPage();
	}

	// ##################### Navigation ################################

	@Then("Admin should be navigated to {string}")
	public void admin_should_be_navigated_to(String program) {

		Assert.assertTrue(programpage.getPageUrl().contains("/program"));
		LoggerLoad.info(" Admin navigated to Program module");

	}

	// ##################### Menu Bar ################################

	@Then("Admin should not have any broken links for Program module")
	public void admin_should_not_have_any_broken_links_for_program_module() throws URISyntaxException {
		programpage.brokenLink();

	}

	@Then("Admin should see the heading {string}")
	public void admin_should_see_the_heading(String expectedLMSHeading) {
		Assert.assertTrue(programpage.doesLMSHeaderExist());
		LoggerLoad.info(" Admin sees the LMS heading ");
	}

	@Then("Admin should see the module names as in order {string}")
	public void admin_should_see_the_module_names_as_in_order(String expectedModnames) {
		List<String> expectedModuleNames = Arrays.asList(expectedModnames.split(" "));

		List<String> actualModuleNames = programpage.getModuleNamesText();

		Assert.assertEquals(actualModuleNames, expectedModuleNames, "The module names are not in the expected order");
		LoggerLoad.info(" Admin sees the module names as in order ");
	}

	@Then("Admin should see Logout in menu bar")
	public void admin_should_see_logout_in_menu_bar() {
		Assert.assertTrue(programpage.doesLogoutBtnExist());
		LoggerLoad.info(" Admin sees the Logout in menu bar ");
	}

	@Then("Admin should see sub menu in menu bar as {string}")
	public void admin_should_see_sub_menu_in_menu_bar_as(String addNewProgram) {
		Assert.assertTrue(programpage.doesAddNewProgramBtnExist());
		LoggerLoad.info(" Admin sees the Add New Program in Sub menu bar ");
	}

	// ################# Manage Program Page validation ################################

	@Then("Admin should see the heading Manage Program")
	public void admin_should_see_the_heading_manage_program() {
		Assert.assertTrue(programpage.doesHeaderExist());
		LoggerLoad.info(" Admin sees the heading Manage Program ");
	}

	@Then("Admin should able to see Program name, description, and status for each program")
	public void admin_should_able_to_see_program_name_description_and_status_for_each_program() {
		Assert.assertTrue(programpage.AllProgramBtn());
		Assert.assertTrue(programpage.AllDescriptionBtn());
		Assert.assertTrue(programpage.AllStatusBtn());

		int rowFound = programpage.getTotalRows();
		softAssert.assertEquals(programpage.getProgramBtnCount(), rowFound);
		softAssert.assertEquals(programpage.getDescriptionBtnCount(), rowFound);
		softAssert.assertEquals(programpage.getStatusBtnCount(), rowFound);
		softAssert.assertAll();
		LoggerLoad.info(" Admin is able to see the Program name, description, and status for each program ");
	}

	@Then("Admin should see a Delete button in left top is disabled")
	public void admin_should_see_a_delete_button_in_left_top_is_disabled() {
		Assert.assertTrue(programpage.isMultipleDeleteBtnDisabled());
		LoggerLoad.info(" Admin sees a Delete button in left top is disabled");
	}

	@Then("Admin should see Search bar with text as {string}")
	public void admin_should_see_search_bar_with_text_as(String expectedString) {
		String actualString = programpage.getSearchBoxText();
		Assert.assertEquals(actualString, expectedString, "SearchBox was not found in Manage Program Page");
		LoggerLoad.info(" Admin sees Search bar with text search ");
	}

	@Then("Admin should see data table with column header on the Manage Program Page as  {string}")
	public void admin_should_see_data_table_with_column_header_on_the_manage_program_page_as(
			String expectedHeadernames) {
		List<String> expectedHeaderNames = Arrays.stream(expectedHeadernames.split(",")).map(String::trim)
				.collect(Collectors.toList());

		List<String> actualHeaderNames = programpage.getHeaderListText();

		Assert.assertEquals(actualHeaderNames, expectedHeaderNames, "The Header names are not in the expected order");
		LoggerLoad.info(" Admin sees data table with column header on the Manage Program Page ");
	}

	@Then("Admin should see checkbox default state as unchecked beside Program Name column header as")
	public void admin_should_see_checkbox_default_state_as_unchecked_beside_program_name_column_header_as() {
		Assert.assertTrue((programpage.CheckBoxTop()).isDisplayed());
		Assert.assertFalse((programpage.CheckBoxTop()).isSelected());
		LoggerLoad.info(" Admin sees checkbox default state as unchecked beside Program Name column header");
	}

	@Then("Admin should see check box default state as unchecked on the left side in all rows against program name")
	public void admin_should_see_check_box_default_state_as_unchecked_on_the_left_side_in_all_rows_against_program_name() {
		Assert.assertTrue((programpage.CheckBox1()).isDisplayed());
		Assert.assertFalse((programpage.CheckBox1()).isSelected());
		Assert.assertTrue((programpage.CheckBox2()).isDisplayed());
		Assert.assertFalse((programpage.CheckBox2()).isSelected());
		Assert.assertTrue((programpage.CheckBox3()).isDisplayed());
		Assert.assertFalse((programpage.CheckBox3()).isSelected());
		Assert.assertTrue((programpage.CheckBox4()).isDisplayed());
		Assert.assertFalse((programpage.CheckBox4()).isSelected());
		Assert.assertTrue((programpage.CheckBox5()).isDisplayed());
		Assert.assertFalse((programpage.CheckBox5()).isSelected());
		LoggerLoad.info(
				" Admin sees check box default state as unchecked on the left side in all rows against program name");
	}

	@Then("Admin should see the sort arrow icon beside to each column header except Edit and Delete")
	public void admin_should_see_the_sort_arrow_icon_beside_to_each_column_header_except_edit_and_delete() {
		Assert.assertTrue(programpage.isSortIconNearProgramNameExist());
		Assert.assertTrue(programpage.isSortIconNearProgramDescriptionExist());
		Assert.assertTrue(programpage.isSortIconNearStatusExist());
		LoggerLoad.info(" Admin sees the sort arrow icon beside to each column header except Edit and Delete");
	}

	@Then("Admin should see the Edit and Delete buttons on each row of the data table")
	public void admin_should_see_the_edit_and_delete_buttons_on_each_row_of_the_data_table() {
		Assert.assertTrue(programpage.AllEditnDeleteBtn());

		int rowFound = programpage.getTotalRows();
		softAssert.assertEquals(programpage.getEditOrDeleteBtnCount("edit"), rowFound);
		softAssert.assertEquals(programpage.getEditOrDeleteBtnCount("delete"), rowFound);
		softAssert.assertAll();
		LoggerLoad.info(" Admin is able to see the Edit and Delete buttons on each row of the data table ");
	}

	@Then("Admin should see the text as Showing x to y of z entries along with Pagination icon below the table.")
	public void admin_should_see_the_text_as_showing_x_to_y_of_z_entries_along_with_pagination_icon_below_the_table() {
		Assert.assertTrue(programpage.getPaginationText().contains("Showing 1"));
		LoggerLoad.info(
				" Admin is able to see the text as Showing x to y of z entries along with Pagination icon below the table. ");
	}

	@Then("Admin should see the footer as In total there are z programs.")
	public void admin_should_see_the_footer_as_in_total_there_are_z_programs() {
		softAssert.assertTrue(programpage.getTotalRecordText().contains("In total there are "));
		softAssert.assertTrue(programpage.getTotalRecordText().contains(" programs."));

		softAssert.assertAll();
	}

	// ##################### Add New Program validation	################################

	@When("Admin clicks Add New Program button")
	public void admin_clicks_add_new_program_button() {
		programpage.clickAddNewProgramButton();
		LoggerLoad.info(" Admin clicks Add New Program button");
	}

}
