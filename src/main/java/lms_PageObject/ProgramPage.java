package lms_PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import lms_Utils.ElementUtils;

public class ProgramPage {

	private WebDriver webDriver;
	private ElementUtils util;

	
	// Page Header section
		private By manageProgramHeading = By.xpath("//*[text()=' Manage Program']");
		private By multipleRecordDeleteBtn = By
				.xpath("//*[text()=' Manage Program']//following-sibling::div//button[@icon='pi pi-trash']");
		private By searchbar = By.xpath("//input[@id='filterGlobal']");
		private By addNewProgram = By.xpath("//*[text()='Add New Program']");
		
	//CheckBox
		private By CheckBoxTop =  By.xpath("//*[@psortablecolumn='programName']/..//*[@role='checkbox']");
	
	
	public ProgramPage(WebDriver driver) {
		super();
		this.webDriver=driver;
		this.util = new ElementUtils(driver);
	}
	
	public String getPageUrl() {
		return webDriver.getCurrentUrl();
	}
	
	public Boolean doesHeaderExist() {
		
		return webDriver.findElement(manageProgramHeading).isDisplayed();
		
	}
	
	/**
	 * @return String get search box innter text
	 */
	public String getSearchBoxText() {
		
		if (util.isElementDisplayed(searchbar)) {
			return util.getAttributeVal(searchbar, "placeholder");
		} else
			return "SearchBox was not found in Manage Program Page";
		
		
	}
	
	/**
	 * This method checks if Multiple Delete Btn is enabled
	 * 
	 * @return boolean
	 */
	public boolean isMultipleDeleteBtnDisabled() {
		return util.getElement(multipleRecordDeleteBtn).isDisplayed();
	}

	//****** CheckBox on left side on manage program
	
//			public Boolean CheckBoxTop() {
//				
//				if (util.isElementDisplayed(CheckBoxTop)) {
//					
//				}
//			}
			
			/**
			 * Method clicks on + A New Program button
			 * 
			 * @return object of ProgramDetailsPage
			 */
			public void clickAddNewProgramButton() {
				util.doClick(addNewProgram);
				//return ProgramDetails;
			}
}

