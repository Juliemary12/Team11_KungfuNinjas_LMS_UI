package lms_StepDefinition;

import org.openqa.selenium.WebDriver;

import context.PicoContext;
import io.cucumber.java.en.When;
import lms_PageObject.Dashboard;
import lms_PageObject.LoginPage;
import lms_PageObject.ProgramPage;
import lms_Utils.LoggerLoad;

public class Dashboard_SD {

	WebDriver driver;
	LoginPage lo;
	Dashboard db;
	PicoContext pico;

	public Dashboard_SD(PicoContext pico) {
		this.pico = pico;
		this.driver = pico.getDriver();
		this.lo = pico.getLogin();
		this.db = pico.getDashboardPage();

	}

	@When("Admin clicks {string} on the navigation bar")
	public void admin_clicks_on_the_navigation_bar(String Program) {
		db.clickProgramMenu();
		LoggerLoad.info(" Admin clicks Program on the navigation bar ");
	}
}