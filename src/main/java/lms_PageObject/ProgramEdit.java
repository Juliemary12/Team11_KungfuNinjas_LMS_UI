package lms_PageObject;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import lms_Utils.ElementUtils;

public class ProgramEdit {

	private WebDriver webDriver;

	private By program = By.xpath("//button[contains(@id, 'program')]");
	private By search = By.xpath("//input[@type='text']");
	private By programdetailspopup = By.xpath("//span[contains(text(), 'Program Details')]");
	private By redmark = By.xpath("//span[@style='color: red !important;']");
	private By updatedname = By.xpath("//tbody[@class='p-datatable-tbody']//tr");
	private By toastsucess = By.className("p-toast-summary");
	private By disappearpop = By.xpath("//p-dialog[@header='Program Details']");
	
	//****************popup edit field*********
	private By editicon = By.xpath("//button[@id='editProgram']");
	private By editname = By.xpath("//input[@id='programName']");
	private By description = By.xpath("//input[@id='programDescription']");
	private By status = By.xpath("//div[@class='ng-star-inserted']");
	private By statusinactive = By.xpath("//p-radiobutton[@ng-reflect-input-id='Inactive']");
	private By statusactive = By.xpath("//p-radiobutton[@ng-reflect-input-id='Active']");
	
//******************close,save,edit**************
	//private By editicon= By.xpath("//button[@id='deleteProgram']");
	private By close = By.xpath("//button[contains(@class, 'p-dialog-header-close')]");
	private By save = By.xpath("//button[@id='saveProgram']");
	private By cancelbutton = By.xpath("//button[@label='Cancel']");
	
//	//******Delete program*****
	//private By deleteicon = By.xpath("//tbody//tr//td[5]//button[@id='deleteProgram']");
	//private By deleteicon = By.xpath("//table//tbody//tr[1]//td[5]//button[@icon='pi pi-trash']");
	private By deleteicon = By.xpath("//button[@id='deleteProgram']");
    private By deeltepopup = By.className("p-confirm-dialog-message");
	private By noButton = By.xpath("//span[text()='No']/..");
	private By yesButton = By.xpath("//span[text()='Yes']/..");
	private By showresult = By.xpath("//span[@class='p-paginator-current ng-star-inserted']");
	private By closeButton = By.className("p-dialog-header-close");
	
	public ProgramEdit(WebDriver driver) {
		super();
		this.webDriver = driver;
	}

	public void searchbox() {
		
		webDriver.findElement(search).sendKeys("JavaTeamrock");
	}

	public void editsearchbutton() throws InterruptedException {
	JavascriptExecutor js = (JavascriptExecutor) webDriver;
       js.executeScript("document.querySelector('.cdk-overlay-backdrop').style.display = 'none';");
        webDriver.findElement(editicon).click();
	}

	public void programdetailspopup() {
		
		WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        WebElement programdetail = wait.until(ExpectedConditions.visibilityOfElementLocated(programdetailspopup));
        programdetail.getText();
	}

	public Boolean doesprogramdetailsHeaderExist() {

		return webDriver.findElement(programdetailspopup).isDisplayed();

	}

	public Boolean redstarmark() {
		return webDriver.findElement(redmark).isDisplayed();
	}

	public void programeditname() {
		WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
		WebElement editForname = wait
				.until(ExpectedConditions.visibilityOfElementLocated(editname));
		((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", editForname);
		wait.until(ExpectedConditions.elementToBeClickable(editForname)).clear();
		editForname.sendKeys("basket");
	}

	public void programsavebutton() {
		webDriver.findElement(save).click();
		
	}

	public void sucessmessage() {
		webDriver.findElement(toastsucess).isDisplayed();
	}

	public Boolean updatedprogramname() {
		return webDriver.findElement(updatedname).isDisplayed();
	}

	public void programeditdescription() throws InterruptedException {
	WebDriverWait wait = new WebDriverWait(webDriver,Duration.ofSeconds(10) );
		WebElement editForDescription = wait.until(ExpectedConditions.visibilityOfElementLocated(description));
	    
	    editForDescription.clear();
	    editForDescription.sendKeys("Seleinium java course");
	}

	public void statusradiobutton() {
		
		for(WebElement listofStatus : webDriver.findElements(status))
		{
			String stastustext = listofStatus.getText();
			System.out.println(stastustext);
			if(listofStatus.getText().contains("Active"))
		{
				webDriver.findElement(statusinactive).click();
				
			}
			else{
				webDriver.findElement(statusactive).click();

			}
		}
	}
	public Boolean verifyingstatusradiobutton() {
		return webDriver.findElement(status).isDisplayed();
	}

	public void programcancelbutton() {
		webDriver.findElement(cancelbutton).click();
	}
	
	public void programnameedit() {
    webDriver.findElement(editname).getText();
    webDriver.findElement(description).getText();
    webDriver.findElement(status).getText();

	}

   //  ***********Visibility checks (if needed for presence verification)**************
    public boolean isProgramNameVisible() {
        return webDriver.findElement(editname).isDisplayed();
    }

    public boolean isProgramDescriptionVisible() {
        return webDriver.findElement(description).isDisplayed();
    }

    public boolean isProgramStatusVisible() {
        return webDriver.findElement(status).isDisplayed();
    }

//************disappearpopuo*********
	
	public boolean disaapearprogramdetails() {
		return webDriver.findElement(disappearpop).isDisplayed();
	}
	public void programclosebutton() {
		webDriver.findElement(close).click();
	}

//***********toastmessage*************88

	public String getToastMessage() {
	WebDriverWait wait = new WebDriverWait(webDriver,Duration.ofSeconds(10) ); // Wait for up to 10 seconds
	WebElement toastsucessmesssage = wait.until(ExpectedConditions.visibilityOfElementLocated(toastsucess));

	String toastMessage = toastsucessmesssage.getText();
	System.out.println("Toast message: " + toastMessage);
	
	return toastMessage;
	
}
//************delete program****************
	
	
	public void updatednameinsearchbox() {
		webDriver.findElement(search).clear();
		webDriver.findElement(search).sendKeys("CoreJava");
	}

	public void programdeleteicon() throws InterruptedException {
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("cdk-overlay-backdrop")));

		WebElement deleteButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("deleteProgram")));
		((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", deleteButton);
		
	}
	
	public boolean programdeletepopup() throws InterruptedException {
		
		programdeleteicon();
		WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        WebElement confirmPopup = wait.until(ExpectedConditions.visibilityOfElementLocated(deeltepopup));
          if (confirmPopup.isDisplayed()) {
            System.out.println("Admin is on the Confirm Deletion form.");
        } else {
            System.out.println("Confirm Deletion form is not displayed.");
        }
		return false;
	}
	
	public void deleteyesbutton() {
		WebDriverWait wait = new WebDriverWait(webDriver,Duration.ofSeconds(10) );
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("cdk-overlay-backdrop")));

		WebElement yesButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Yes']/..")));
		((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", yesButton);
	}
	public void searchdeletedprogram() {
		webDriver.findElement(search).clear();
		webDriver.findElement(search).sendKeys("CoreJava");
		webDriver.findElement(showresult).getText();
	}
	public boolean deleteNobutton() {
		WebDriverWait wait = new WebDriverWait(webDriver,Duration.ofSeconds(10) );
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("cdk-overlay-backdrop")));

		WebElement Nobutton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Yes']/..")));
		((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", Nobutton);
		return false;
	}
	
		public boolean programdeletepopup1() {
		   
			WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("p-confirm-dialog-message")));
			return false;
		}

		
		public void deleteclosebutton() {
			  webDriver.findElement(closeButton).click();
		  }
	}
