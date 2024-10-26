package lms_PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ProgramEdit {

	private WebDriver webDriver;

	private By program = By.xpath("//button[contains(@id, 'program')]");
	private By search = By.xpath("//input[@type='text']");
	private By edit = By.xpath("//*[@id='editProgram']");
	private By programdetailspopup = By.xpath("//span[contains(text(), 'Program Details')]");
	private By redmark = By.xpath("//span[@style='color: red !important;']");
	private By editname = By.xpath("//input[@id='programName']");
	private By save = By.xpath("//button[@id='saveProgram']");
	private By updatedname = By.xpath("//td[text()='javasdet']");
	private By description = By.xpath("//input[@id='programDescription']");
	private By status = By.xpath("//div[contains(@class, 'ng-star-inserted') and contains(text(), 'Inactive')]");
	//private By updatedprogram = By.xpath("//tr[td[text()='JavaProgram'] and td[text()='Inactive']]");
	private By cancelbutton = By.xpath("//button[@label='Cancel']");
	private By toastsucess = By.className("p-toast-summary");
	private By disappearpop = By.xpath("//p-dialog[@header='Program Details']");
	
	//#########locators for update program details#########
	private By programName = By.xpath("//tr/td[text()='javasdet']");  
	private By programDescription = By.xpath("//tr/td[text()='java program ']");  
	private By programStatus = By.xpath("//tr/td[text()='Active']"); 

	private By close = By.xpath("//button[contains(@class, 'p-dialog-header-close')]");
	
	public ProgramEdit(WebDriver driver) {
		super();
		this.webDriver = driver;
	}

	public void searchbox() {
		webDriver.findElement(search).sendKeys("Javasde");
	}

	public void editbutton() throws InterruptedException {
		Actions actions = new Actions(webDriver);
		WebElement editButton = webDriver.findElement(edit);
		actions.moveToElement(editButton).click().perform();
		Thread.sleep(1000);
		webDriver.findElement(edit).click();

	}

	public void programdetailspopup() {
		webDriver.findElement(programdetailspopup).getText();
	}

	public Boolean doesprogramdetailsHeaderExist() {

		return webDriver.findElement(programdetailspopup).isDisplayed();

	}

	public Boolean redstarmark() {
		return webDriver.findElement(redmark).isDisplayed();
	}

	public void programeditname() {
		webDriver.findElement(editname).clear();
		webDriver.findElement(editname).sendKeys("javasdet");
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

	public void programeditdescription() {
		webDriver.findElement(description).clear();
		webDriver.findElement(description).sendKeys("java program ");

	}

	public void statusradiobutton() {
		webDriver.findElement(status).click();
	}

	public Boolean verifyingstatusradiobutton() {
		return webDriver.findElement(status).isDisplayed();
	}

//	public Boolean updatedprogramrowvisible() {
//
//		return webDriver.findElement(updatedprogram).isDisplayed();
//		
//	}

	public void programcancelbutton() {
		webDriver.findElement(cancelbutton).click();
	}
//********************getter methods *******************
	public String getProgramName() {
        WebElement nameElement = webDriver.findElement(programName);
        return nameElement.getText();
    }
    public String getProgramDescription() {
        WebElement descriptionElement = webDriver.findElement(programDescription);
        return descriptionElement.getText();
    }
    public String getProgramStatus() {
        WebElement statusElement = webDriver.findElement(programStatus);
        return statusElement.getText();
    }

    // ***********Visibility checks (if needed for presence verification)**************
    public boolean isProgramNameVisible() {
        return webDriver.findElement(programName).isDisplayed();
    }

    public boolean isProgramDescriptionVisible() {
        return webDriver.findElement(programDescription).isDisplayed();
    }

    public boolean isProgramStatusVisible() {
        return webDriver.findElement(programStatus).isDisplayed();
    }

//************
	
	public boolean disaapearprogramdetails() {
		return webDriver.findElement(disappearpop).isDisplayed();
	}
	public void programclosebutton() {
		webDriver.findElement(close).click();
	}
}
