package lms_PageObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import lms_Utils.ElementUtils;

public class ProgramPage {

	private WebDriver webDriver;
	private ElementUtils util;

	
	// Page Header section
		private By manageProgramHeading = By.xpath("//*[text()=' Manage Program']");
		private By LMSHeading = By.xpath("//span[text()=' LMS - Learning Management System ']");
		
		private By modulenames = By.xpath("//div[@class='ng-star-inserted']//button");
		private By logoutBtn = By.xpath("//span[text()='Logout']");
		
		private By multipleRecordDeleteBtn = By
				.xpath("//*[text()=' Manage Program']//following-sibling::div//button[@icon='pi pi-trash']");
		private By searchbar = By.xpath("//input[@id='filterGlobal']");
		private By headerList = By.xpath("//thead//tr/th");
		
		
		private By addNewProgram = By.xpath("//*[text()='Add New Program']");
		
	//CheckBox
		private By CheckBoxTop =  By.xpath("//*[@psortablecolumn='programName']/..//*[@role='checkbox']");
		private By CheckBoxFirst =  By.xpath("(//*[@class='p-datatable-tbody']//tr/td[1]//div[@role='checkbox'])[1]");
		private By CheckBoxSecond =  By.xpath("(//*[@class='p-datatable-tbody']//tr/td[1]//div[@role='checkbox'])[2]");
		private By CheckBoxThird  =  By.xpath("(//*[@class='p-datatable-tbody']//tr/td[1]//div[@role='checkbox'])[3]");
		private By CheckBoxForth  =  By.xpath("(//*[@class='p-datatable-tbody']//tr/td[1]//div[@role='checkbox'])[4]");
		private By CheckBoxFifth  =  By.xpath("(//*[@class='p-datatable-tbody']//tr/td[1]//div[@role='checkbox'])[5]");
		
		// Table header section - Column Sort Icons
		private By programNameSortIcon = By.xpath("//*[@psortablecolumn='programName']//i");
		private By programDescriptionSortIcon = By.xpath("//*[@psortablecolumn='programDescription']//i");
		private By programStatusSortIcon = By.xpath("//*[@psortablecolumn='programStatus']//i");
		
		// Table Body section
		private By rowList = By.xpath("//tbody/tr");
		private By rowDeleteBtnList = By.xpath("//button[@id='deleteProgram']");
		private By rowEditBtnList = By.xpath("//button[@id='editProgram'] ");
		private By AllEditnDeleteBtn = By.xpath("//div[@class='action']");
		private By rowPrgNameList = By.xpath("//*[@class='p-datatable-tbody']//tr/td[2]");
		private By rowPrgDescList = By.xpath("//*[@class='p-datatable-tbody']//tr/td[3]");
		private By rowPrgStatusList = By.xpath("//*[@class='p-datatable-tbody']//tr/td[4]");
		
		// Pagination section
		private By paginationEntryInfo = By.className("p-paginator-current");
		
		//Footer section
		private By TotalNoOfProgram = By.xpath("//div[@class='p-d-flex p-ai-center p-jc-between ng-star-inserted']");
	
	public ProgramPage(WebDriver driver) {
		super();
		this.webDriver=driver;
		this.util = new ElementUtils(driver);
	}
	
	public String getPageUrl() {
		return webDriver.getCurrentUrl();
	}
	
	public void brokenLink() throws URISyntaxException {
		 
		  List<WebElement> links = webDriver.findElements(By.tagName("iframe"));
			
			for (WebElement link : links) {
				
				String url = link.getAttribute("src");
				if (url== null || url.isEmpty()) {
					System.out.println("URL is empty");
					
					continue;
				}
				try {
					URL appLink = new URI(url).toURL();
					HttpURLConnection huc = (HttpURLConnection) (appLink.openConnection());
					huc.connect();
					if (huc.getResponseCode()>=400 ) {
						
						System.out.println(url + " is broken");
						
					}
					else
					{
						System.out.println(url + " is valid");
					}
					
				} catch (MalformedURLException e) {
			
					e.printStackTrace();
				} catch (IOException e) {
					
					e.printStackTrace();
				} 
			}
			}
	
	public Boolean doesLMSHeaderExist() {		
		return webDriver.findElement(LMSHeading).isDisplayed();		
	}
		
	public Boolean doesHeaderExist() {		
		return webDriver.findElement(manageProgramHeading).isDisplayed();		
	}	
	
	public List<String> getModuleNamesText() {
		List<WebElement> moduleItems = util.getElements(modulenames);
		 return moduleItems.stream().map(WebElement::getText).collect(Collectors.toList());
	}
	
	public Boolean doesLogoutBtnExist() {		
		return webDriver.findElement(logoutBtn).isDisplayed();		
	}
	
	public Boolean doesAddNewProgramBtnExist() {		
		return webDriver.findElement(addNewProgram).isDisplayed();		
	}
	
	public List<String> getHeaderListText() {
		List<WebElement> headerItems = util.getElements(headerList);
		List<String> listHeader = headerItems.stream().map(WebElement::getText)
									.filter(header -> !header.trim().isEmpty())
									.map(String::trim).collect(Collectors.toList());
		System.out.println("Header List are : " +listHeader);
		return listHeader;
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
	
			public WebElement CheckBoxTop() {
				WebElement checkboxtop = webDriver.findElement(CheckBoxTop);
				return checkboxtop;
			}
			

			public WebElement CheckBox1() {
				WebElement checkbox1 = webDriver.findElement(CheckBoxFirst);
				return checkbox1;
			}
			

			public WebElement CheckBox2() {
				WebElement checkbox2 = webDriver.findElement(CheckBoxSecond);
				return checkbox2;
			}
			

			public WebElement CheckBox3() {
				WebElement checkbox3 = webDriver.findElement(CheckBoxThird);
				return checkbox3;
			}
			

			public WebElement CheckBox4() {
				WebElement checkbox4 = webDriver.findElement(CheckBoxForth);
				return checkbox4;
			}
			

			public WebElement CheckBox5() {
				WebElement checkbox5 = webDriver.findElement(CheckBoxFifth);
				return checkbox5;
			}

	//****** Sort Arrow icon near ProgramName, Description and Status on manage program
			
			public Boolean isSortIconNearProgramNameExist() {		
				return webDriver.findElement(programNameSortIcon).isDisplayed();		
			}
			
			public Boolean isSortIconNearProgramDescriptionExist() {		
				return webDriver.findElement(programDescriptionSortIcon).isDisplayed();		
			}
			
			public Boolean isSortIconNearStatusExist() {		
				return webDriver.findElement(programStatusSortIcon).isDisplayed();		
			}
			
	// Get total number of rows in a given page:
			public int getTotalRows() {
				return util.getElementSize(rowList);
			}
			
			public Boolean AllEditnDeleteBtn() {
				return util.isElementDisplayed(AllEditnDeleteBtn);
			}
			
			public Boolean AllProgramBtn() {
				return util.isElementDisplayed(rowPrgNameList);
			}
			
			public Boolean AllDescriptionBtn() {
				return util.isElementDisplayed(rowPrgDescList);
			}
			
			public Boolean AllStatusBtn() {
				return util.isElementDisplayed(rowPrgStatusList);
			}
			
		
			// Edit/Delete buttons related:

						/**
						 * This method return number of delete or edit button in table in Manage Program
						 * Page
						 * 
						 * @param "edit" or "delete"
						 * @return count in int
						 */
						public int getEditOrDeleteBtnCount(String editOrDelete) {

							String btnName = editOrDelete.trim().toLowerCase();
							if (btnName.equals("edit")) {
								return util.getElementSize(rowEditBtnList);
							} else if (btnName.equals("delete")) {
								return util.getElementSize(rowDeleteBtnList);
							} else {
								System.out.println("Please enter 'edit' or 'delete'");
								return 0;
							}

						}
						
						// Program / Description /Status row count 

									/**
									 * This method return number of program/description/status button in table in Manage Program
									 * Page
									 * 
									 * @param "program" or "desc" or "status
									 * @return count in int
									 */
						
									public int getProgramBtnCount() {
										return util.getElementSize(rowPrgNameList);
									}
									
									public int getDescriptionBtnCount() {
										return util.getElementSize(rowPrgDescList);
									}
									
									public int getStatusBtnCount() {
										return util.getElementSize(rowPrgStatusList);
									}
										

			
		
			
			/**
			 * Method clicks on + A New Program button
			 * 
			 * @return object of ProgramDetailsPage
			 */
			public void clickAddNewProgramButton() {
				util.doClick(addNewProgram);
				//return ProgramDetails;
			}
			
			
							
			
			// ********************* Pagination Functions ***********************

			/**
			 * @return total pagination text section
			 */
			public String getPaginationText() {
				
				return util.getElementText(paginationEntryInfo);
			}
			
			// ********************* Footer Functions ***********************
			
			   public boolean Pagefooter() {
					return util.isElementDisplayed(TotalNoOfProgram);		
				}
			   
			   public String getTotalRecordText() {
					return util.getElementText(TotalNoOfProgram);	
					
				}
}

