package lms_StepDefinition;

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
	
	
	
	
	public Program_SD(PicoContext pico) { 
		this.pico = pico;
		this.driver = pico.getDriver();
		this.lo = pico.getLogin();
		this.db = pico.getDashboardPage();
		this.programpage = pico.getProgramPage();
	}

	//##################### Navigation ################################
	
	@Then("Admin should be navigated to {string}")
	public void admin_should_be_navigated_to(String program) {
		
		Assert.assertTrue(programpage.getPageUrl().contains("/program"));  
		LoggerLoad.info(" Admin navigated to Program module");
		
	}
	
	//##################### Manage Program Page validation ################################
	
	@Then("Admin should see the heading Manage Program")
	public void admin_should_see_the_heading_manage_program() {
		Assert.assertTrue(programpage.doesHeaderExist());
		LoggerLoad.info(" Admin sees the heading Manage Program ");
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
	
//	@Then("Admin should see checkbox default state as unchecked beside Program Name column header as")
//	public void admin_should_see_checkbox_default_state_as_unchecked_beside_program_name_column_header_as() {
//		Assert.assertTrue(programpage.);
//	    LoggerLoad.info(" Admin sees a Delete button in left top is disabled");
//	}
	
	//##################### Add New Program validation ################################
	
	@When("Admin clicks Add New Program button")
	public void admin_clicks_add_new_program_button() {
	    programpage.clickAddNewProgramButton();
	    LoggerLoad.info(" Admin clicks Add New Program button");
	}

	

}
