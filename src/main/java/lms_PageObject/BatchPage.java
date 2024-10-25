package lms_PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import lms_Utils.LoggerLoad;

public class BatchPage {
	private WebDriver webDriver;
	
	//locators
	
	 By dashboardHeader =By.xpath("//mat-toolbar/span[contains(text(),' LMS -')]");
     By batchIcon = By.xpath("//button//span[text()='Batch']");
	 By manageBatchHeading = By.xpath("//div[text()=' Manage Batch']");
	
	//constructor -intializing driver
	public BatchPage(WebDriver driver) {
		super();
		this.webDriver=driver;
		}
	
	//action methods
	
	public String getTextDashboardHeader() {
		String dashboardHeaderText = webDriver.findElement(dashboardHeader).getText();
		LoggerLoad.info(dashboardHeaderText);
		return dashboardHeaderText;
		
		
	}
	
	
	public void clickBatchiconMenubar() {
		
		webDriver.findElement(batchIcon).click();
	}
	
	public boolean ManageBatchHeaderDisplayed() {
	 webDriver.findElement(manageBatchHeading).isDisplayed();
	return true ;
	
	
	}
	
	
	
	

}
