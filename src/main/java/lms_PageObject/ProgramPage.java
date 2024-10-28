package lms_PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProgramPage {

private WebDriver webDriver;
	
	// Page Header section
		private By manageProgramHeading = By.xpath("//*[text()=' Manage Program']");
		private By searchbar = By.xpath("//input[@id='filterGlobal']/..");
	
	
	public ProgramPage(WebDriver driver) {
		super();
		this.webDriver=driver;
	}
}
