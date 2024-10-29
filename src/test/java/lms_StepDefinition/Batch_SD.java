package lms_StepDefinition;


import static org.testng.Assert.assertEquals;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import context.PicoContext;
import io.cucumber.java.en.*;
import lms_PageObject.BatchDetails;
import lms_PageObject.BatchPage;
import lms_PageObject.LoginPage;
import lms_Utils.ConfigReader;
import lms_Utils.LoggerLoad;
import lms_Utils.PropertiesFile;

public class Batch_SD {
	WebDriver driver;
    LoginPage lo;
	PicoContext pico;
	BatchPage batch;
	String ExpectedUrl;
	private BatchDetails batchPopup;
	
	public Batch_SD(PicoContext pico) {
		this.pico = pico;
		this.driver = pico.getDriver();
		this.lo = pico.getLogin();
		this.batch = pico.getBatch();
		
	}

	@When("Admin enter valid credentials and clicks login button")
	public void admin_enter_valid_credentials_and_clicks_login_button() {
		
		lo.loginsucess();
		lo.loginButton();
	   
	}

	@When("Admin Clicks on the Batch menu from the header")
	public void admin_clicks_on_the_batch_menu_from_the_header() {
	    batch.clickBatchiconMenubar();
	    
	}

	@Then("Admin should be in the Manage Batch Page")
	public void admin_should_be_in_the_manage_batch_page() {
		String actualbatchpageurl = PropertiesFile.readPropertiesFile("batchUrl");
		String expectedurl = driver.getCurrentUrl();
		assertEquals(expectedurl, actualbatchpageurl, "Admin on Program module page");	
//	String ExpectedBatchUrl = PropertiesFile.readPropertiesFile("batchUrl");
//	   System.out.println(ExpectedBatchUrl);
//		String ActualBatchUrl = driver.getCurrentUrl();
//		System.out.println(ActualBatchUrl);
//		//Assert.assertEquals(ActualBatchUrl, ExpectedBatchUrl,  "Admin is on Manage batch page");
//		
//	Assert.assertEquals("Admin is on Manage batch page", ExpectedBatchUrl, ActualBatchUrl);
//
//		//assertEquals(ExpectedBatchUrl, ActualBatchUrl, "Admin is on Manage batch page");
		
		
	}
	
	
	@Then("Admin should see the {string} Title")
	public void admin_should_see_the_title(String batchPageTitle) {
		
//		boolean Actual = batch.ManageBatchHeaderDisplayed();
//		
//	   String Expected = "Manage batch not displayed";
//			
//		Assert.assertEquals(Expected, Actual);
//			//LoggerLoad.info();
			batch.getTextbatchTitle();
			LoggerLoad.info(batchPageTitle+" :Title displayed" );
	}
	
	@Then("Admin should see the {string} Heading")
	public void admin_should_see_the_heading(String manageBatchHeading) {
		Assert.assertTrue(batch.ManageBatchHeaderDisplayed());
		String ActualMB = "Manage Batch";
	  String expectedMB =  batch.getManageBatchText();
	    assertEquals(ActualMB, expectedMB);
	    LoggerLoad.info("admin should see : "+manageBatchHeading);
	    
	}

	@Then("Admin should see the disabled {string} under the header")
	public void admin_should_see_the_disabled_under_the_header(String disabledDeleteButton) {
		Assert.assertTrue(batch.checkDisabledDeletebutton());
		LoggerLoad.info("admin should see disabled DeleteButton");
	    
	    
	}

	@Then("Admin should see the enabled pagination controls under the data table")
	public void admin_should_see_the_enabled_pagination_controls_under_the_data_table() {
	    batch.checkEnabledPaginationControls();
	    LoggerLoad.info("admin should see enabled pagination controls");
	    
	}

	@Then("Admin should see the edit icon in each row")
	public void admin_should_see_the_edit_icon_in_each_row() {
	 boolean eacheditdisplayed =   batch.checkEditIconInEachrow();
	 LoggerLoad.info("edit icon in each row displayed");
	    
	}

	@Then("Admin should see the delete icon in each row")
	public void admin_should_see_the_delete_icon_in_each_row() {
	    
	boolean eachdeleteicon =    batch.checkDeleteIconinEachRow();
	    LoggerLoad.info("delete icon in each row displayed");
	    
	}

	@Then("Admin should the checkbox in each row")
	public void admin_should_the_checkbox_in_each_row() {
	 boolean eachCheckbox = batch.checkCheckboxInEachRow(); 
	   LoggerLoad.info("checkbox is displayed in each row");
	    
	}

	@Then("Admin should see the datatable headers Batch name, Batch Description,Batch Status,No Of classes, Program Name, Edit\\/Delete")
	public void admin_should_see_the_datatable_headers_batch_name_batch_description_batch_status_no_of_classes_program_name_edit_delete() {
	 String dataTableHeaders=  batch.checkDatatableHeaderRow();
	 LoggerLoad.info(dataTableHeaders);
	       
	}
	
	@Then("Admin should see the checkbox  in the datatable header row")
	public void admin_should_see_the_checkbox_in_the_datatable_header_row() {
	    
	  boolean checkboxHeader =  batch.checkCheckboxDbHeader();
	  LoggerLoad.info("checkbox in the datatable header is displayed ");
	}
	
	@Then("Admin should see the sort icon next to all Datatable headers")
	public void admin_should_see_the_sort_icon_next_to_all_datatable_headers() {
		boolean sorticonAllHeaders = batch.checkSorticonOfDatatableheaders();
		   LoggerLoad.info("sort icon next to all Datatable headers is displayed ");
	}


}
