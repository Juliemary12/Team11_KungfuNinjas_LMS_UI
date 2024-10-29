package lms_StepDefinition;

import java.io.IOException;
import java.net.URISyntaxException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;

import context.PicoContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lms_PageObject.LoginPage;
import lms_Utils.ConfigReader;
import lms_Utils.LoggerLoad;
import lms_Utils.PropertiesFile;
import net.sourceforge.tess4j.TesseractException;

public class LoginPage_SD {

		WebDriver driver;
	    LoginPage lo;
		PicoContext pico;
		ConfigReader configreader;
		 
		public LoginPage_SD(PicoContext pico) { 
			this.pico = pico;
			this.driver = pico.getDriver();
			this.lo = pico.getLogin();
		}
	
		
	
	@Given("Admin launch the browser")
	public void admin_launch_the_browser() {
	    
		System.out.println("Browser is open");
		
	}

	@When("Admin gives the correct LMS portal URL")
	public void admin_gives_the_correct_lms_portal_url() {
		
		String url = PropertiesFile.readPropertiesFile("LMSURL");
		driver.get(url);

	}

	@Then("Admin should land on the login page")
	public void admin_should_land_on_the_login_page() {
	    
		String title =lo.getPageTitle();
		System.out.println("Title of the page is:" + title);
		
	}

	@When("Admin enters sheetname {string} and rownumber {int}")
	public void admin_enters_sheetname_and_rownumber(String string, Integer rowNumber) throws InvalidFormatException, IOException {
	    
		lo.readDataFromSheet(string, rowNumber);		
	}

	@When("Admin enters userusername {string} and password {string} and click on login button")
	public void admin_enters_userusername_and_password_and_click_on_login_button(String string, String string2) {
	    
		lo.sendUserName();
		lo.sendPassword();
		lo.loginButton();
	
	}

//	@Then("Admin should land on dashboard page\\(centre of the page will be empty , menu bar is present)")
//	public void admin_should_land_on_dashboard_page_centre_of_the_page_will_be_empty_menu_bar_is_present() {
//		
//	}
	
	@When("Admin gives the {string} LMS portal URL")
	public void admin_gives_the_lms_portal_url(String string) {
		
		String Iurl=lo.invalidurl();
		driver.get(Iurl);
		
	}

	@Then("Admin should recieve {int} page not found error")
	public void admin_should_recieve_page_not_found_error(Integer int1) {
	   
		
	}
	
	@Then("HTTP response >={int} and  the link is broken")
	public void http_response_and_the_link_is_broken(Integer int1) throws URISyntaxException {
	    
	    lo.brokenLink();
	}

	@Then("Admin should see correct spellings in all fields")
	public void admin_should_see_correct_spellings_in_all_fields() {
	    		
		lo.textSpellings();
		lo.textSpellings1();
		lo.textSpellings2();
		lo.textSpellings3();
		
	}

	@Then("Admin should see logo on the left  side on login page")
	public void admin_should_see_logo_on_the_left_side_on_login_page() {
	    
	    
	}

	@Then("Admin should see  LMS - Learning Management System on login page")
	public void admin_should_see_lms_learning_management_system_on_login_page() throws IOException, TesseractException {
	    
		 lo.appNameOnLogo();     
		  
	}

	@Then("Admin should see company name below the app name on login page")
	public void admin_should_see_company_name_below_the_app_name_on_login_page() {
	    
	    
	}

	@Then("Admin should see {string} on login page")
	public void admin_should_see_on_login_page(String string) {
	    
		String loginText = lo.loginContentText();
		Assert.assertEquals("Please login to LMS application", loginText);
		LoggerLoad.info("Validate Login Text Content" + loginText );
	    
	}

	@Then("Admin should see two text field on login page")
	public void admin_should_see_two_text_field_on_login_page() {
	    
	    lo.twoTextField();
	}

	@Then("Admin should see {string} in the first text field on login page")
	public void admin_should_see_in_the_first_text_field_on_login_page(String string) {
	    
		
		String actualText =lo.textFirstField();
		System.out.println("Print User Text:" + actualText);
		Assert.assertEquals(actualText.contains("User"), true);
		LoggerLoad.info("Validate Text on First Field" + actualText);  
	}

	@Then("Admin should see * symbol next to user text on login page")
	public void admin_should_see_symbol_next_to_user_text_on_login_page() {
	    
		String actualText=lo.textFirstField();
		Assert.assertEquals(actualText.contains("*"), true);
		LoggerLoad.info("Validate Asterisk on First Field" + actualText);  
	}

	@Then("Admin should {string} in the second text field on login page")
	public void admin_should_in_the_second_text_field_on_login_page(String string) {
		
	    String secondFieldText=lo.textSecondField();
	    System.out.println("print password text:" + secondFieldText );
	    
	    Assert.assertEquals(secondFieldText.contains("Password"), true);
	    LoggerLoad.info("Validate Text On Second Field" + secondFieldText);
	}

	@Then("Admin should see * symbol next to password text on login page")
	public void admin_should_see_symbol_next_to_password_text_on_login_page() {
	    
	    String secondFieldAstk=lo.secondFieldAstk();
	    Assert.assertTrue("Text Should Contain *", secondFieldAstk.contains("*") );
	    LoggerLoad.info("Validate Asterisk On Second Field" + secondFieldAstk);
	}

	@Then("Admin should see input field on the centre of the page")
	public void admin_should_see_input_field_on_the_centre_of_the_page() {
		int actualX = 490; 
		int actualY=354;
		
		Point location =lo.inputFldAlgn();
		
		Assert.assertEquals(actualX, location.getX());
		Assert.assertEquals(actualY, location.getY());
		LoggerLoad.info("Validation Of Input Field");
	}

	@Then("Admin should see Login button on login page")
	public void admin_should_see_login_button_on_login_page() {
	    
	    lo.logiButton();
	    LoggerLoad.info("Validation Of Login Button");
	}

	@Then("Admin should see login button on the centre of the login page")
	public void admin_should_see_login_button_on_the_centre_of_the_login_page() {
		int actualX = 647; 
		int actualY=509;
		
	Point location=lo.loginBtnAllignment();
	   int x= location.getX();
	   int y=location.getY();
	   System.out.println("Coordinates: " + x + ", " + y);
	   
	   Assert.assertEquals(actualX, x);
	   Assert.assertEquals(actualY, y);
	   
	   LoggerLoad.info("Validate Location Of Login Button");
		
	}

	@Then("Admin should see user in gray color on login page")
	public void admin_should_see_user_in_gray_color_on_login_page() {
	    
		String actualColor = lo.userColor();
		Assert.assertEquals(actualColor, lo.getTextColor());
		
		LoggerLoad.info("Validation Of User Text Color");
	    
	}

	@Then("Admin should see password in gray color on login page")
	public void admin_should_see_password_in_gray_color_on_login_page() {
	    
	    String actualColor = lo.pwdColor();
	    Assert.assertEquals(actualColor,lo.getTextColor());
	}

	@When("Admin enter invalid Username and Password then clicks login button")
	public void admin_enter_invalid_username_and_password_then_clicks_login_button() {
	
	lo.Username();
	lo.Password();
	lo.clickButton();
	
	}

	@Then("Error message errorMessage should display")
	public void error_message_error_message_should_display() {
		
	   lo.errorMsg();	
	}

	@When("Admin enter value only in password and clicks login button")
	public void admin_enter_value_only_in_password_and_clicks_login_button() {
		
	    lo.pwd();
	    lo.clickButton();
	    
	}
	
	@Then("Error message should display for admin field")
	public void error_message_should_display_for_admin_field() {
	
//		lo.UNameErrorMsg();
		
	}
	
	@When("Admin enter only in Adminname and clicks login button")
	public void admin_enter_only_in_adminname_and_clicks_login_button() {
		
		lo.UName();
		lo.clickButton();
		
	}
	
	@Then("Error message should display for pwd field")
	public void error_message_should_display_for_pwd_field() {
	
		
	}

	@When("Admin enter valid credentials and clicks login button through keyboard")
	public void admin_enter_valid_credentials_and_clicks_login_button_through_keyboard() throws InterruptedException {
	    
	    lo.keyAction();
	}

	@Then("Admin should land on dashboard page")
	public void admin_should_land_on_dashboard_page() throws InterruptedException {
			
		String url = lo.dashboardPgae();
		
//		Assert.assertEquals(PropertiesFile.readPropertiesFile("dashboardUrl"),url);
// 
	}

	@When("Admin enter valid credentials  and clicks login button through mouse")
	public void admin_enter_valid_credentials_and_clicks_login_button_through_mouse() throws InterruptedException {
		
		lo.mouseAction();  
	} 
	
	@Then("Admin should see login button")
	public void admin_should_see_login_button() {
	    
		lo.logoutButton();		
	}
	
	@Then("Admin should see login button on the centre of the page")
	public void admin_should_see_login_button_on_the_centre_of_the_page() {
		
		
	}

}
	



