package lms_PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class Dashboard {
	
	private WebDriver webDriver;

	private By programMenu = By.xpath("//button[@id='program']");

	public Dashboard(WebDriver driver) {
		super();
		this.webDriver = driver;
	}

	public void clickProgramMenu() {

		webDriver.findElement(programMenu).click();
	}

}
