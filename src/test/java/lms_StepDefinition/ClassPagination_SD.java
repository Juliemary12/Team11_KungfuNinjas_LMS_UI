package lms_StepDefinition;

import org.openqa.selenium.WebDriver;

import context.PicoContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lms_PageObject.ClassPagination;
import lms_PageObject.LoginPage;
import lms_Utils.ConfigReader;

public class ClassPagination_SD {
	
	
	WebDriver driver;
    LoginPage lo;
    ClassPagination CP;
	PicoContext pico;
	ConfigReader configreader;
	 
	public ClassPagination_SD(PicoContext pico) { 
		this.pico = pico;
		this.driver = pico.getDriver();
		this.CP = pico.getclasspagination();
	}
	  

	@When("Admin clicks Next page link on the class table for pagination")
	public void admin_clicks_next_page_link_on_the_class_table_for_pagination() {
		CP.nextPage();
	

	}

	@Then("Admin should see the next page record on the table has next active link enabled")
	public void admin_should_see_the_next_page_record_on_the_table_has_next_active_link_enabled() {
	    
		CP.nextPageRecord();
	}

	@When("Admin clicks Last page link for pagination")
	public void admin_clicks_last_page_link_for_pagination() {
	    
	   CP.lastPage();
	}

	@Then("Admin should see the last page record on the table with Next page link are disabled")
	public void admin_should_see_the_last_page_record_on_the_table_with_next_page_link_are_disabled() {
	    
		CP.nextPageRecord();
	   
	}

	@When("Admin clicks First page link for pagination")
	public void admin_clicks_first_page_link_for_pagination() {
	    
	   CP.firstPage();
	}

	@Then("Admin should see the previous page record on the table having previous page link enabled")
	public void admin_should_see_the_previous_page_record_on_the_table_having_previous_page_link_enabled() {
		CP.nextPageRecord();
	   
	}

	@When("Admin clicks Start page link for pagination")
	public void admin_clicks_start_page_link_for_pagination() {
	    
	   CP.startPageLink();
	}

	@Then("Admin should see the very first page record on the table with Previous page link are disabled")
	public void admin_should_see_the_very_first_page_record_on_the_table_with_previous_page_link_are_disabled() {
	    
		CP.nextPageRecord();
	}


}
