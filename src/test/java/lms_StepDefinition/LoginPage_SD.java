package lms_StepDefinition;

import java.io.IOException;


import org.openqa.selenium.WebDriver;

//import browserlaunch.Driverfactory;
import context.PicoContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lms_PageObject.LoginPage;
import lms_Utils.ConfigReader;
import lms_Utils.PropertiesFile;

public class LoginPage_SD {
	
//	LoginPage loginpage = new LoginPage(Driverfactory.getDriver());
		WebDriver driver;
	    LoginPage lo;
		PicoContext pico;
		ConfigReader configreader;
		
		
		
		public LoginPage_SD(PicoContext pico) { 
			this.pico = pico;
			this.driver = pico.getDriver();
			this.lo = pico.getLogin();
		}
//			ConfigReader configreader=new ConfigReader();		
		
		
	
	@Given("Admin launch the browser")
	public void admin_launch_the_browser() {
	    
		System.out.println("Browser is open");
		
	}

	@When("Admin gives the correct LMS portal URL")
	public void admin_gives_the_correct_lms_portal_url() {
		
//		  try {
//		        Driverfactory.getDriver().get("https://lms-frontend-hackathon-oct24-173fe394c071.herokuapp.com/login");
//		        System.out.println("Navigated to URL");
//		    } catch (Exception e) {
//		        System.out.println("Error navigating to URL: " + e.getMessage());
//		    }
	    
//		Driverfactory.getDriver().get("https://lms-frontend-hackathon-oct24-173fe394c071.herokuapp.com/login");
//		
//		System.out.println("inside apll");
		
		String url = PropertiesFile.readPropertiesFile("LMSURL");
		driver.get(url);

	}

	@Then("Admin should land on the login page")
	public void admin_should_land_on_the_login_page() {
	    
		String title =lo.getPageTitle();
		System.out.println("Title of the page is:" + title);
		
	}

	@When("Admin enters sheetname {string} and rownumber {int}")
	public void admin_enters_sheetname_and_rownumber(String string, Integer rowNumber) throws Throwable {
	    
		lo.readDataFromSheet(string, rowNumber);
		
//		loginpage.readDataFromSheet(string, rowNumber);
//		
//		System.out.println("printing: " + string + " " + rowNumber);
		
	}

	@When("Admin enters userusername {string} and password {string} and click on login button")
	public void admin_enters_userusername_and_password_and_click_on_login_button(String string, String string2) {
	    
		lo.sendUserName();
		lo.sendPassword();
		lo.loginButton();
//		loginpage.sendUserName();
//		loginpage.sendPassword();
//		loginpage.loginButton();
		
		
	}

	@Then("Admin should land on dashboard page\\(centre of the page will be empty , menu bar is present)")
	public void admin_should_land_on_dashboard_page_centre_of_the_page_will_be_empty_menu_bar_is_present() {
		
	}
	
}