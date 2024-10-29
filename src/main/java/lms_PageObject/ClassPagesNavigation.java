package lms_PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ClassPagesNavigation {
	
	private WebDriver webDriver;
	
	
	private By classLink = By.xpath("/html/body/app-root/app-header/mat-toolbar/div/button[3]/span[1]");
	private By manageClass = By.xpath("//div[normalize-space()='Manage Class']");
	private By multiLinks = By.xpath("//button[@Class='mat-focus-indicator mat-menu-trigger mat-button mat-button-base']");
	private By logoutLink = By.xpath("//span[normalize-space()='Logout']");
	private By programLink = By.xpath("//button[@id='program']//Span");
	private By batchLink = By.xpath("/html/body/app-root/app-header/mat-toolbar/div/button[2]/span[1]");
	
	

	
	public ClassPagesNavigation(WebDriver driver) {
		super();
		this.webDriver=driver;
		}
	
	
	public void classLink() {
		
	 webDriver.findElement(classLink).click();
		
	}
	
	public String manageClassPage() {
		
		boolean isDisplayed = webDriver.findElement(manageClass).isDisplayed();
		System.out.println("Class Page is Displayed:" + isDisplayed);
		return null;
		
	}
	
	public String classToProgram() {
		
		webDriver.findElement(batchLink).click();
		String programUrl = webDriver.getCurrentUrl();
		return programUrl;
	}
	
	public String classToBatch() {
		
		webDriver.findElement(classLink).click();
		String batchUrl = webDriver.getCurrentUrl();
		return batchUrl;
	}
	
	
	public void logOut() {
		
		webDriver.findElement(logoutLink);
	}
	
	public void redirectedLoginPage() {
		
		webDriver.findElement(logoutLink);
		webDriver.getTitle();
	}
	
	

}

//public void classMultiLink() {
//
//List<WebElement> tabLinks = webDriver.findElements(multiLinks);
//
//   for (WebElement tabLink : tabLinks) {
//	   System.out.println(tabLink.getText());
//	   
//
//   }

//}


