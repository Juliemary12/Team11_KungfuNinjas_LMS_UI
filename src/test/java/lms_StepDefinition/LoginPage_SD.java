package lms_StepDefinition;


import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;

import context.PicoContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lms_PageObject.LoginPage;
import lms_Utils.ConfigReader;
import lms_Utils.PropertiesFile;

public class LoginPage_SD {

	WebDriver driver;
    LoginPage lo;
	PicoContext pico;
	ConfigReader configreader;
	
	
	public LoginPage_SD(PicoContext pico) { 
		this.pico = pico;
		this.driver = pico.getDriver();
		this.lo = pico.getLogin();
		
		ConfigReader configreader=new ConfigReader();
		
		
	}
	

@Given("Admin launch the browser")
public void admin_launch_the_browser() {
    
    System.out.println("Browser is launched");

}

@When("Admin gives the correct LMS portal URL")
public void admin_gives_the_correct_lms_portal_url() {
    
	String url = PropertiesFile.readPropertiesFile("LMSURL");
	driver.get(url);
}

@Then("Admin should land on the login page")
public void admin_should_land_on_the_login_page() {
    
	String pageTitle = lo.getPageTitle();
    if (pageTitle.contains("LMSURL")) {
        System.out.println("Admin is on the login page.");
    } else {
        System.out.println("Login page is not loaded correctly.");
    }
    }

@When("Admin enters sheetname {string} and rownumber {int}")
public void admin_enters_sheetname_and_rownumber(String string, Integer int1) throws InvalidFormatException, IOException {
    
	lo.readDataFromSheet(string, int1);
    
}

@When("Admin enters userusername {string} and password {string} and click on login button")
public void admin_enters_userusername_and_password_and_click_on_login_button(String string, String string2) {
    
	lo.sendUserName();
	lo.sendPassword();
	lo.loginButton();
}

@Then("Admin should land on dashboard page \\( centre of the page will be empty , menu bar is present)")
public void admin_should_land_on_dashboard_page_centre_of_the_page_will_be_empty_menu_bar_is_present()  {
    
    System.out.println("Admin is on the dashboard page.");

}

@When("Admin enter valid credentials and clicks login button")
public void admin_enter_valid_credentials_and_clicks_login_button() {
	lo.loginsucess();
	lo.loginButton();
}

}


