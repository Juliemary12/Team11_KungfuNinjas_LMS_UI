package lms_StepDefinition;

import static org.testng.Assert.assertEquals;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import context.PicoContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lms_Constants.AppConstants;
import lms_PageObject.Dashboard;
import lms_PageObject.LoginPage;
import lms_PageObject.ProgramDetails;
import lms_PageObject.ProgramPage;
import lms_Utils.DynamicDataGenerator;
import lms_Utils.LoggerLoad;

public class ProgramAdd_SD {

	WebDriver driver;
    LoginPage lo;
    Dashboard db;
    ProgramPage programpage;
    ProgramDetails pdp;
	PicoContext pico;
	SoftAssert softAssert = new SoftAssert();
	
	
	
	
	public ProgramAdd_SD(PicoContext pico) { 
		this.pico = pico;
		this.driver = pico.getDriver();
		this.lo = pico.getLogin();
		this.db = pico.getDashboardPage();
		this.programpage = pico.getProgramPage();
		this.pdp = pico.getProgramDetailsPage();
		
	}
	
	 //##################### Add New Program validation ################################
	 
	@Then("Admin should see pop up window for Program Details")
	public void admin_should_see_pop_up_window_for_program_details()  { 
		Assert.assertTrue(pdp.doesPopUpExist());
		LoggerLoad.info(" Admin sees pop up window for Program Details");
	}
	
	@Then("Admin should see window title as {string}")
	public void admin_should_see_window_title_as(String expectedProgramDetailsHeader) {
		String actualString = pdp.getHeaderText();
		Assert.assertTrue(pdp.doesHeaderExist());
		Assert.assertEquals(actualString, expectedProgramDetailsHeader);
		LoggerLoad.info(" Admin sees window title as Program Details"); 
	  
	}
	
	@Then("Admin should see red * mark beside mandatory field Name")
	public void admin_should_see_red_mark_beside_mandatory_field_name() {
		Assert.assertTrue(pdp.doesredstarmarkexist());
		LoggerLoad.info(" Admin sees red * mark beside mandatory field Name");
	}
	
	@When("Admin clicks Cancel button")
	public void admin_clicks_cancel_button() {
	    pdp.clickCancelBtn();
	    LoggerLoad.info(" Admin clicked Cancel button");
	}

	@Then("Admin can see Program Details form disappears")
	public void admin_can_see_program_details_form_disappears() throws InterruptedException {
		Thread.sleep(1000);
	   Assert.assertFalse(pdp.doesPopUpExist());
	   LoggerLoad.info(" Admin sees Program Details form disappears");
	}
	
	@When("Admin Click on X button")
	public void admin_click_on_x_button() {
	    pdp.clickCloseBtn();
	    LoggerLoad.info(" Admin clicked X button");
	}

		
	@When("Admin enters the {string} in the text box")
	public void admin_enters_the_in_the_text_box(String naenteredStringme) {
		String name = "KungfuNinja";
	    pdp.enterProgramName(name);
	    LoggerLoad.info(" Admin enters the Name in the text box");
	}

	@Then("Admin can see the {string} entered")
	public void admin_can_see_the_entered(String expectedProgramName)  {
		String actualString = pdp.getEnteredNameText();
		Assert.assertEquals(actualString, expectedProgramName, "Text entered in the text box does not match.");
		LoggerLoad.info(" Admin sees the entered name"); 
	}
	
	@When("Admin enters the {string} in description text box")
	public void admin_enters_the_in_description_text_box(String enteredString) {
		String description = "SDET";
		pdp.enterDescription(description);
	    LoggerLoad.info(" Admin enters the Description in the text box");
	}

	@Then("Admin can see the text entered {string} in description box")
	public void admin_can_see_the_text_entered_in_description_box(String expectedDescriptiom) {
		String actualString = pdp.getEnteredDescriptionText();
		Assert.assertEquals(actualString, expectedDescriptiom, "Text entered in the text box does not match.");
		LoggerLoad.info(" Admin sees the entered text in Description box"); 
	}

	/*@When("Admin selects the status of the program by clicking on the radio button Active\\/InActive")
	public void admin_selects_the_status_of_the_program_by_clicking_on_the_radio_button_active_in_active() throws InterruptedException {
	   //String StatusEntered = "Active";
	   //pdp.selectActiveInactiveRadioButton(StatusEntered);
		pdp.selectActiveRadioBtn();
	   LoggerLoad.info(" Admin selects the status of the program by clicking on the radio button Active or InActive"); 
	}

	@Then("Admin can see Active or Inactive status selected")
	public void admin_can_see_active_or_inactive_status_selected() {
		//WebElement Active = pdp.ActiveRadioButtonSelected();
		//boolean InActive = pdp.isInActiveRadioButtonSelected();
		//WebElement Active = pdp.selectActiveRadioBtn();
		//System.out.println("Active button");
	   //Assert.assertTrue((pdp.selectActiveRadioBtn()).isSelected());
		Assert.assertTrue(pdp.isActiveRadioButtonSelected());
	    LoggerLoad.info(" Admin can see Active or Inactive status selected"); 
	}*/

	@When("Admin clicks save button without entering mandatory")
	public void admin_clicks_save_button_without_entering_mandatory() throws InterruptedException {
		String programName = "";
		String description = "";
		pdp.emptyProgramDetails(programName, description);
		LoggerLoad.info("Admin clicks save button without entering mandatory");
	}

	@Then("Admin gets message field is required")
	public void admin_gets_message_field_is_required() {
		HashMap<String, String> allErrMsgs= pdp.getErrorMsgs();
		  
		  softAssert.assertEquals(allErrMsgs.get("nameError"),
		  AppConstants.NAME_REQUIRED_ERR_PROGDETAILSPAGE);
		  
		  softAssert.assertEquals(allErrMsgs.get("descriptionError"),
		  AppConstants.DESCRIPTION_REQUIRED_ERR_PROGDETAILSPAGE);
		  
		  softAssert.assertEquals(allErrMsgs.get("statusError"),
		  AppConstants.STATUS_REQUIRED_ERR_PROGDETAILSPAGE);
		  
		  softAssert.assertAll();
		  LoggerLoad.info("Admin is getting an error messages on Program Details Page");
	}

	// ##################### Add New Program with valid details ################################
	
	@When("Admin enter valid details for mandatory fields {string}, {string}, status and Click on save button")
	public void admin_enter_valid_details_for_mandatory_fields_status_and_click_on_save_button(String progName, String progDescription) throws InterruptedException {
		String programName = "KungfuNinjasTeamp";
		String description = "For SDET";
		pdp.ProgramDetails(programName, description);
		LoggerLoad.info("Admin Enters valid data in all fields and clicks on save to create a Program");
		
	}

	@Then("Admin gets message {string}")
	public void admin_gets_message(String ExpectedMsg) throws InterruptedException {
		String ExpectedMsg1 = "Successful";
		String ExpectedMsg2 = "Program Created Successfully";
		String ExpectedMessage = ExpectedMsg1+" "+ExpectedMsg2;
		System.out.println("Expected Message is: " + ExpectedMessage);
		softAssert.assertEquals(pdp.getSuccessMessageText(), ExpectedMessage);
		LoggerLoad.info("Admin sees Successful Program created");
	}

	@When("Admin searches with newly created Program Name")
	public void admin_searches_with_newly_created_program_name()  {
		String name = "KungfuNinjasTeamd";
	    pdp.enterNameInSearchbox(name);
	    LoggerLoad.info("Admin searches with newly created name");
	}

	@Then("Records of the newly created  Program Name is displayed and match the data entered")
	public void records_of_the_newly_created_program_name_is_displayed_and_match_the_data_entered() {
		String ExpectedName = "KungfuNinjasTeamd";
		String ExpectedDescription = "SDET";
		String ExpectedStatus = "Active";
	    Assert.assertEquals(pdp.getCreatedNameText(), ExpectedName);
	    Assert.assertEquals(pdp.getCreatedDescriptionText(), ExpectedDescription);
	    Assert.assertEquals(pdp.getCreatedStatusText(), ExpectedStatus);
	  
	    LoggerLoad.info("Records of the newly created  name is displayed and match the data entered");
	}
}


