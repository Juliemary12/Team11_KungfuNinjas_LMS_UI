package lms_Hooks;

import java.io.ByteArrayInputStream;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import context.PicoContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;

public class Hooks {

	PicoContext pico;
	static WebDriver driver;
	
	public Hooks(PicoContext pico) {
		this.pico = pico;
	}
	
	@Before
	public void setUp() throws Throwable{
		pico.setDriver(driver);
		driver = pico.getDriver();
		pico.initializePageObjects(driver);		
		
	}
	
	@After 
	public void tearDown(Scenario scenario) {
		
//		To take a screenshot if there is any failed scenario. 
		if(scenario.isFailed()) {
			final byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			Allure.addAttachment("Failed Screenshot", new ByteArrayInputStream(screenshot));//Allure report screenshot
			scenario.attach(screenshot, "image/png", "image");//Extent report screenshot
		}
		
		pico.getDriver().quit();
	}

}
	

