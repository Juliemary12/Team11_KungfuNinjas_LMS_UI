package lms_StepDefinition;

import static org.testng.Assert.assertEquals;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import context.PicoContext;
import io.cucumber.java.en.*;
import lms_PageObject.BatchPage;
import lms_PageObject.LoginPage;
import lms_Utils.LoggerLoad;

public class Batch_SD {
	WebDriver driver;
    LoginPage lo;
	PicoContext pico;
	BatchPage batch;
	
	
	
	public Batch_SD(PicoContext pico) {
		this.pico = pico;
		this.driver = pico.getDriver();
		this.lo = pico.getLogin();
		this.batch = pico.getBatch();
	}
	@ Given("Admin is on the Dashboard Page")
	public void Admin_is_on_the_Dashboard_Page() {
		
		String actual = batch.getTextDashboardHeader();
		String Expected = "LMS - Learning Management System";
		Assert.assertEquals(actual, Expected);
		
	}
	
	
	@When("Admin enter valid credentials and clicks login button")
	public void admin_enter_valid_credentials_and_clicks_login_button() {
		lo.successfullLogin();
	   
	}

	@When("Admin Clicks on the Batch menu from the header")
	public void admin_clicks_on_the_batch_menu_from_the_header() {
	    batch.clickBatchiconMenubar();
	    
	}

	@Then("Admin should be in the Manage Batch Page")
	public void admin_should_be_in_the_manage_batch_page() {
		
		String ExpectedUrl = "https://lms-frontend-hackathon-oct24-173fe394c071.herokuapp.com/batch";
		String BatchUrl = driver.getCurrentUrl();
		assertEquals(BatchUrl, ExpectedUrl);
		
	}
	@Then("Admin should see the {string} Title")
	public void admin_should_see_the_title(String string) {
		
		boolean Actual = batch.ManageBatchHeaderDisplayed();
		
	   String Expected = "Manage Batch";
			
		Assert.assertEquals(Expected, Actual);
			//LoggerLoad.info();
			
	}
	
	
	
	

}
