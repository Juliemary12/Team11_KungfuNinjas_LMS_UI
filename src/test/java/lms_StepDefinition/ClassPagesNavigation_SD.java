package lms_StepDefinition;

import org.bouncycastle.util.Properties;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import context.PicoContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lms_PageObject.ClassPagesNavigation;
import lms_PageObject.LoginPage;
import lms_Utils.ConfigReader;
import lms_Utils.PropertiesFile;

public class ClassPagesNavigation_SD {
	
	WebDriver driver;
	ClassPagesNavigation classPGN;
	PicoContext pico;
	ConfigReader configreader;
	 
	public ClassPagesNavigation_SD(PicoContext pico) { 
		this.pico = pico;
		this.driver = pico.getDriver();
		this.classPGN = pico.getPageNavigation();
		 
	}
	
	@When("Admin clicks on Class link page for navigation")
	public void admin_clicks_on_class_link_page_for_navigation() throws InterruptedException {
	    
		classPGN.classLink();
		Thread.sleep(20);
	}
	
	@Then("Admin is re-directed to Manage class page and navigated")
	public void admin_is_re_directed_to_manage_class_page_and_navigated() {
	   
			classPGN.manageClassPage();
	}

	@When("Admin clicks on any module link on Manage Class page for navigation")
	public void admin_clicks_on_any_module_link_on_manage_class_page_for_navigation() {
		
		classPGN.classToProgram();
		classPGN.classToBatch();
	}
	
	@Then("Admin is re-directed to which module link they clicked and navigated")
	public void admin_is_re_directed_to_which_module_link_they_clicked_and_navigated() {
		
		String url = classPGN.classToProgram();
		String url1 = classPGN.classToBatch();
		System.out.println("Program page URL:" + url);
		System.out.println("Batch page URL:" + url1);
	}

	@When("Admin clicks on Logout link on Manage class page for navigation")
	public void admin_clicks_on_logout_link_on_manage_class_page_for_navigation() {
	   
		classPGN.logOut();
	}

	@Then("Admin is re-directed to Login page and navigated")
	public void admin_is_re_directed_to_login_page_and_navigated() {
	   
		classPGN.redirectedLoginPage();
	}
}
