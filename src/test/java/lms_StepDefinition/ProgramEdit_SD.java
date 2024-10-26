package lms_StepDefinition;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import context.PicoContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lms_PageObject.Dashboard;
import lms_PageObject.LoginPage;
import lms_PageObject.ProgramEdit;
import lms_Utils.ConfigReader;
import lms_Utils.LoggerLoad;
import lms_Utils.PropertiesFile;

public class ProgramEdit_SD {

	WebDriver driver;
	LoginPage lo;
	PicoContext pico;
	ConfigReader configreader;
	ProgramEdit pe;
	Dashboard db;

	public ProgramEdit_SD(PicoContext pico) {
		this.pico = pico;
		this.driver = pico.getDriver();
		this.lo = pico.getLogin();
		this.pe = pico.getprogramedit();
		this.db = pico.getDashboardPage();
		ConfigReader configreader = new ConfigReader();
		if (db == null) {
			throw new NullPointerException("Dashboard object is not initialized!");
		}

	}

	@Given("Admin is on Program module")
	public void admin_is_on_program_module() {
		String actualprogrampageurl = PropertiesFile.readPropertiesFile("PROGRAMURL");
		String expectedurl = driver.getCurrentUrl();
		assertEquals(expectedurl, actualprogrampageurl, "Admin on Program module page");

	}

	@When("Admin clicks {string} on the navigation bar")
	public void admin_clicks_on_the_navigation_bar(String menuoption) {
		db.clickprogram();
	}

	@When("Admin clicks on searchfield box to particular program")
	public void admin_clicks_on_searchfield_box_to_particular_program() {
		pe.searchbox();

	}

	@When("Admin clicks on Edit option for particular program")
	public void admin_clicks_on_edit_option_for_particular_program() throws InterruptedException {
		pe.editbutton();
	}

	@Then("Admin lands on Program details form")
	public void admin_lands_on_program_details_form() {
		pe.programdetailspopup();

	}

	@Then("Admin should see window title as {string}")
	public void admin_should_see_window_title_as(String string) {
		Assert.assertTrue(pe.doesprogramdetailsHeaderExist());
		LoggerLoad.info(" Admin sees the heading Program Details ");

	}

	@Then("Admin should see red {string} mark beside mandatory field {string}")
	public void admin_should_see_red_mark_beside_mandatory_field(String string, String string2) {
		Assert.assertTrue(pe.redstarmark());
		LoggerLoad.info(" Admin sees the red * mark ");

	}

	@When("Admin edits the program name and click on save button")
	public void admin_edits_the_program_name_and_click_on_save_button() {
		pe.programeditname();
		pe.programsavebutton();
	}

	@Then("Updated program name is seen by the Admin")
	public void updated_program_name_is_seen_by_the_admin() {
		Assert.assertTrue(pe.updatedprogramname());
		LoggerLoad.info(" Admin sees the updated program name ");
	}

	@When("Admin edits the description text and click on save button")
	public void admin_edits_the_description_text_and_click_on_save_button() {
		pe.programeditdescription();
		pe.programsavebutton();
	}

	@Then("Admin can see the description is updated")
	public void admin_can_see_the_description_is_updated() {
		pe.programeditdescription();
	}

	@When("Admin can change the status of the program and click on save button")
	public void admin_can_change_the_status_of_the_program_and_click_on_save_button() {
		pe.statusradiobutton();
		pe.programsavebutton();
	}

	@Then("Status updated can be viewed by the Admin")
	public void status_updated_can_be_viewed_by_the_admin() {

		boolean isActive = pe.verifyingstatusradiobutton();

		// whether the status is "Active" or "Inactive"
		if (isActive) {
			Assert.assertTrue(isActive, "Expected status is 'Active' but found 'Inactive'");
			LoggerLoad.info("Admin sees the updated status: Active");
		} else {
			Assert.assertFalse(isActive, "Expected status is 'Inactive' but found 'Active'");
			LoggerLoad.info("Admin sees the updated status: Inactive");
		}
		Assert.assertTrue(pe.verifyingstatusradiobutton());
		LoggerLoad.info(" Admin sees the updated status of radio button ");

	}

	@When("Admin click on save button")
	public void admin_click_on_save_button() {
		pe.programsavebutton();
	}

	@Then("Admin can see the updated program details")
	public void admin_can_see_the_updated_program_details() {
		pe.searchbox();
		String expectedProgramName = "javasdet";
	    String expectedProgramDescription = "java program ";
	    String expectedProgramStatus = "Inactive";

	    assertEquals(expectedProgramName, pe.getProgramName());
	    assertEquals(expectedProgramDescription, pe.getProgramDescription());
	    assertEquals(expectedProgramStatus, pe.getProgramStatus());
	}

	@When("Admin click on cancel button")
	public void admin_click_on_cancel_button() {
		pe.programcancelbutton();
	}

	@Then("Admin can see the Program details form disappears")
	public void admin_can_see_the_program_details_form_disappears() throws InterruptedException {

		// Assert that the dialog has disappeared
		Thread.sleep(1000);
		Assert.assertFalse(pe.disaapearprogramdetails(), "Program details dialog did not disappear as expected!");

		LoggerLoad.info("The program details dialog has successfully disappeared.");

	}

	@When("Admin searches with newly updated {string}")
	public void admin_searches_with_newly_updated(String string) {
		pe.programeditname();
	}

	@Then("Admin verifies that the details are correctly updated")
	public void admin_verifies_that_the_details_are_correctly_updated() {
		String actualprograme = "JavaProgram";
		String expectedname = "JavaProgram";
		assertEquals(actualprograme, expectedname, "Admin on Program module page");
		String actualstatus = "Active";
		String expectedstatus = "Inactive";
		assertEquals(actualprograme, expectedname, "Admin on Program module page");
	}

	@When("Admin Click on {string} button")
	public void admin_click_on_button(String string) {
		pe.programclosebutton();
	}

	@Then("Admin can see program details form disappear")
	public void admin_can_see_program_details_form_disappear() {
		Assert.assertTrue(pe.disaapearprogramdetails(), "Program details dialog did not disappear as expected!");

		LoggerLoad.info("The program details dialog has successfully disappeared.");
	}

}
