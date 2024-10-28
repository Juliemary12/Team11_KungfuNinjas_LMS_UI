package lms_PageObject;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import lms_Utils.ElementUtils;

public class ProgramDetails {

	private WebDriver webDriver;
	private ElementUtils util;
	private WebDriverWait wait;
	
	private By programDetailPopUp = By.xpath("//p-dialog[@header='Program Details']");
	private By programDetailBtn = By.xpath("//*[text()='Program Details']");
	private By redmarkProgName = By.xpath("//label[text()='Name']//span");
	
	//Name Field
	private By nameField_Program = By.xpath("//input[@id='programName']");
	
	//Description Field
	private By descriptionField_Program = By.xpath("//input[@id='programDescription']");
	
	//Radio Button
	private By status = By.xpath("//div[@class='ng-star-inserted']");
	private By statusinactive = By.xpath("//p-radiobutton[@ng-reflect-input-id='Inactive']");
	private By statusactive = By.xpath("//p-radiobutton[@ng-reflect-input-id='Active']");
	
	private By Active_Selected = By.xpath("//div[@class='p-radiobutton p-component p-radiobutton-checked']");
	private By ActiveSelected = By.xpath("//div[@class='p-radiobutton-box p-highlight']//span[@class='p-radiobutton-icon']");
	//private By Active=By.xpath("//p-radiobutton[@class='ng-untouched ng-pristine ng-valid']//input[@type='radio' and @value='Active']");
	//private By InActive=By.xpath("//p-radiobutton[@class='ng-untouched ng-pristine ng-valid']//input[@type='radio' and @value='Inactive']");
	//private By Active=By.xpath("(//span[@class='p-radiobutton-icon'])[1]");
	//private By InActive=By.xpath("(//span[@class='p-radiobutton-icon'])[2]");
	
	//Cancel, Save, x
	private By cancelBtn=By.xpath("//span[text()='Cancel']");
	private By saveBtn=By.xpath("//span[text()='Save']");
	private By closeBtn=By.xpath("//button[@tabindex='-1']");
	
	//Error Msg xpaths
	private By errorList = By.tagName("small");
	private By errormsg_ProgNameRequired = By.xpath("//label[@for='programName']/following-sibling::small");
	private By errormsg_ProgDescRequired = By.xpath("//label[@for='programDescription']/following-sibling::small");
	private By errormsg_StatusRequired = By.xpath("//small[normalize-space()='Status is required.']");
	
	private By errormsg_FailedMsg = By.xpath("//div[text()='Failed']");
	private By errormsg_ProgAlreadyExists = By.xpath("//div[text()='cannot create program , since already exists']");
	
	//success message
	private By ProgramSuccess1 = By.xpath("//div[text()='Successful']");
    private By ProgramSuccess2 = By.xpath("//div[text()='Program Created Successfully']");
    
    //Search
    private By search = By.xpath("//input[@type='text']");
    
 // Table Body section
 	private By rowList = By.xpath("//tbody/tr");
 	private By createdProgName = By.xpath("//tbody/tr/td[text()='KungfuNinjasTeamd']");
 	private By createdProgDescription = By.xpath("//td[text()='SDET']");
 	private By createdStatus = By.xpath("//td[text()='Active']");
	
	public ProgramDetails(WebDriver driver) {
		super();
		this.webDriver=driver;
		this.util = new ElementUtils(driver);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	public String getPageUrl() {
		return webDriver.getCurrentUrl();
	}
	
	public String getHeaderText() {
		return webDriver.findElement(programDetailBtn).getText();
		
	}
	
	public Boolean doesPopUpExist() {		
		return webDriver.findElement(programDetailPopUp).isDisplayed();
		
	}
	
	public Boolean doesHeaderExist() {		
		return webDriver.findElement(programDetailBtn).isDisplayed();
		
	}
	
	public Boolean doesredstarmarkexist() {
		return webDriver.findElement(redmarkProgName).isDisplayed();
	}
	
	public void clickCancelBtn() {
		util.doClick(cancelBtn);
	}
	
	public void clickCloseBtn() {
		util.doClick(closeBtn);
	}
	
	public void clickstatusActive() throws InterruptedException {
//		 WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
//		    WebElement activeRadioButton = wait.until(ExpectedConditions.elementToBeClickable(statusactive));
//		    activeRadioButton.click(); 
		
		webDriver.findElement(statusactive).click();
	}
	
	public WebElement isActiveStatusBTnSelected() {
		WebElement SelectedActiveBtn = webDriver.findElement(Active_Selected);
		System.out.println("Active button is selected");
		return SelectedActiveBtn;
		//return webDriver.findElement(Active_Selected).isSelected();
	}
	
	public void clickstatusInActive() throws InterruptedException {
		webDriver.findElement(statusinactive).click();
	}
	public void clickSaveBtn() {
		util.doClick(saveBtn);
	}
	
	public void enterProgramName(String name) {
		webDriver.findElement(nameField_Program).sendKeys(name);
	}
	
	public String getEnteredNameText() {
		return webDriver.findElement(nameField_Program).getAttribute("ng-reflect-model");
		
	}
	
	public void enterDescription(String description) {
		webDriver.findElement(descriptionField_Program).sendKeys(description);
	}
	
	public String getEnteredDescriptionText() {
		return webDriver.findElement(descriptionField_Program).getAttribute("ng-reflect-model");
		
	}
	
	
	/*public void selectActiveInactiveRadioButton(String radioBtnName) throws InterruptedException {
		
		switch (radioBtnName.trim().toLowerCase()) {
		case "active":
			WebElement ActiveradioButton = webDriver.findElement(statusactive); // Use the correct locator
		    if (!ActiveradioButton.isSelected()) {
		    	ActiveradioButton.click(); // Select the radio button if not already selected
		    	System.out.println("The Active button is selected");
		    }
			break;
		case "inactive":
			WebElement InActiveradioButton = webDriver.findElement(statusinactive); // Use the correct locator
		    if (!InActiveradioButton.isSelected()) {
		    	InActiveradioButton.click(); // Select the radio button if not already selected
		    }
			break;
		default:
			break;
		}
		 
	}*/
	
	/*public WebElement selectActiveRadioBtn() {
		WebElement ActiveradioButton = webDriver.findElement(statusactive); // Use the correct locator
	    if (!ActiveradioButton.isSelected()) {
	    	ActiveradioButton.click(); // Select the radio button if not already selected
	    	System.out.println("The Active button is selected");
	    }
	   return ActiveradioButton;
	}*/

	/*public boolean clickActiveRadioBtn() {
		//WebElement ActiveBtnSelected = webDriver.findElement(Active_Selected);
		//System.out.println("Validation Passed");
		//return webDriver.findElement(Active_Selected).isSelected();
		//return ActiveBtnSelected;
		WebElement ActiveBtnSelected = selectActiveRadioBtn();
		return ActiveBtnSelected.isSelected();
		
		util.
	}*/
	
	/*public Boolean isInActiveRadioButtonSelected() {
		return webDriver.findElement(statusinactive).isSelected();
	}*/
	
	//************************* Error Msg Function *********************
	
	
		public HashMap<String, String> getErrorMsgs() {
		
			  HashMap<String, String> map = new HashMap<>(); 
			  StringBuffer buffer = new StringBuffer(""); 
			  
			  List<WebElement> errList = util.getElements(errorList);
			  
			  for(WebElement ele:errList) { 
				  if(ele.getText().contains("Description")) {
					  map.put("descriptionError", ele.getText()); 
				  } 
				  else if(ele.getText().contains("Status")) { 
					  map.put("statusError", ele.getText());
				  } 			 			   
				  else if(ele.getText().contains("Program") || ele.getText().contains("special char")){
					 buffer.append(ele.getText()); 		  
				  }
			  
			  map.put("nameError", buffer.toString()); 
			  }
			  
			  return map;	 
		}
		
		public void emptyProgramDetails(String programName,String description) throws InterruptedException {
			
			String wh = webDriver.getWindowHandle();
			webDriver.switchTo().window(wh);
			
			try
			{
			util.doSendKeys(nameField_Program, programName);
			util.doSendKeys(descriptionField_Program, description);
			
			clickSaveBtn();
			}
			catch (StaleElementReferenceException e) {}
		}
	
	public void ProgramDetails(String programName,String description) throws InterruptedException {
		
		String wh = webDriver.getWindowHandle();
		webDriver.switchTo().window(wh);
		
		try
		{
		util.doSendKeys(nameField_Program, programName);
		util.doSendKeys(descriptionField_Program, description);
		
		Thread.sleep(2000);
		clickstatusInActive();
		
		//util.doSendKeys(NumberOfClasses, numberOfClasses);
		clickSaveBtn();
		}
		catch (StaleElementReferenceException e) {}
	}

	public String getSuccessMessageText() throws InterruptedException {
	Thread.sleep(1000);
	String Message1 = webDriver.findElement(ProgramSuccess1).getText();
	String Message2 = webDriver.findElement(ProgramSuccess2).getText();
	String Message = Message1+" "+Message2;
	System.out.println("Actual message appeared on the screen is: " + Message);
	return Message;
}
	
	public void enterNameInSearchbox(String name) {
		webDriver.findElement(search).sendKeys(name);
	}
	
	public String getCreatedNameText() {
		String createdName = webDriver.findElement(createdProgName).getText();
		System.out.println("Entered name Row Details is : " +createdName);
		return createdName;
	}
	
	public String getCreatedDescriptionText() {
		String createdDescription = webDriver.findElement(createdProgDescription).getText();
		System.out.println("Entered Description Row Details is : " +createdDescription);
		return createdDescription;
	}
	
	public String getCreatedStatusText() {
		String createdstatus = webDriver.findElement(createdStatus).getText();
		System.out.println("Entered name Row Details is : " +createdstatus);
		return createdstatus;
	}
}
