package lms_StepDefinition;

import org.openqa.selenium.WebDriver;

import context.PicoContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lms_PageObject.LoginPage;
import lms_Utils.ConfigReader;

public class Dashboard_SD {
	WebDriver driver;
    LoginPage lo;
	PicoContext pico;
	ConfigReader configreader;
	
	
	
	public Dashboard_SD(PicoContext pico) { 
		this.pico = pico;
		this.driver = pico.getDriver();
		this.lo = pico.getLogin();
	}
	
	@Given("Admin is in loginPage")
	public void admin_is_in_login_page() {
	    
		
	}

	
	@Then("Admin should see dashboard")
	public void admin_should_see_dashboard() {
	    
	}

	@Then("Maximum navigation time in milliseconds, defaults to {int} seconds")
	public void maximum_navigation_time_in_milliseconds_defaults_to_seconds(Integer int1) {
	   
	}

	@Then("HTTP response >= {int}. Then the link is broken")
	public void http_response_then_the_link_is_broken(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Admin should see LMS -Learning management system as title")
	public void admin_should_see_lms_learning_management_system_as_title() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("LMS title should be on the top left corner of page")
	public void lms_title_should_be_on_the_top_left_corner_of_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Admin should see correct spelling in navigation bar text")
	public void admin_should_see_correct_spelling_in_navigation_bar_text() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Admin should see correct spelling and space in LMS title")
	public void admin_should_see_correct_spelling_and_space_in_lms_title() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Admin should see the navigation bar text on the top right side")
	public void admin_should_see_the_navigation_bar_text_on_the_top_right_side() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Admin should see Home in the 1st place")
	public void admin_should_see_home_in_the_1st_place() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Admin should see program in the 2nd place")
	public void admin_should_see_program_in_the_2nd_place() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Admin should see batch in the 3rd place")
	public void admin_should_see_batch_in_the_3rd_place() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Admin should see class in the 4th place")
	public void admin_should_see_class_in_the_4th_place() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Admin should see logout in the 5th place")
	public void admin_should_see_logout_in_the_5th_place() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

}
