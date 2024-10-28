package lms_Utils;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementUtils {

private WebDriver webDriver;
	
	public ElementUtils(WebDriver driver) {
		super();
		this.webDriver=driver;
	}
	public void clearExistingText(WebElement ele) {
		ele.sendKeys(Keys.CONTROL);
		ele.sendKeys("A");
		ele.sendKeys(Keys.BACK_SPACE);
	}
	
	
	
}
