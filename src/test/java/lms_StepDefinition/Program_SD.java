package lms_StepDefinition;

import org.openqa.selenium.WebDriver;

import context.PicoContext;
import lms_PageObject.Dashboard;
import lms_PageObject.LoginPage;
import lms_PageObject.ProgramPage;

public class Program_SD {

	WebDriver driver;
    LoginPage lo;
    Dashboard db;
    ProgramPage programpage;
	PicoContext pico;
	
	
	
	
	public Program_SD(PicoContext pico) { 
		this.pico = pico;
		this.driver = pico.getDriver();
		this.lo = pico.getLogin();
		this.db = pico.getDashboardPage();
		this.programpage = pico.getprogrampage();
	}
}
