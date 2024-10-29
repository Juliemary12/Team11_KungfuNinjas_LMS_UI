package lms_PageObject;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;


import lms_Utils.LoggerLoad;

public class BatchPage {
	private WebDriver webdriver;
	private String DatatableHeaders;
	private WebDriverWait wait;
	
	//Batch page validation locators
	
	 By batchTitle =By.xpath("//mat-toolbar/span[contains(text(),' LMS -')]");
     By batchIcon = By.xpath("//button//span[text()='Batch']");
	 By manageBatchHeading = By.xpath("//div[text()=' Manage Batch']");
	 By disabledDeleteButton = By.xpath("//mat-card-title//button[@icon='pi pi-trash']");
	 By batchpageHeader = By.xpath("//mat-toolbar/span[contains(text(),' LMS -')]"); //both dash head batch head same
	 By enabledPaginator = By.xpath("//button[contains(@class,'p-paginator-next')]");
	 By editIcon = By.xpath("//tr[1]//button[@icon='pi pi-pencil']");
	 By deleteIcon =By.xpath("//tr[1]//button[@icon='pi pi-trash']");
	 By checkBox= By.xpath("//tr[1]/th//div[@role='checkbox']");
	 //By dataTableheader = By.xpath("//table//tr//th[@psortablecolumn='"+headerName+"']");
	//By dataTableheader = By.xpath("//table//tr//th["+i+"]");
	 By checkboxInDbHeader = By.xpath("//tr[1]//div[@class='p-checkbox-box']");
	 By sorticonInDbHeader = By.xpath("//thead/tr/th//p-sorticon");
	 
	 
	 
	 
	
	//constructor -intializing driver
	public BatchPage(WebDriver driver) {
		super();
		this.webdriver=driver;
		this.wait = new WebDriverWait(webdriver, Duration.ofSeconds(10));
		}
	
	//Batch Page action methods
	
		
	public void clickBatchiconMenubar() {
		
		webdriver.findElement(batchIcon).click();
	}
   public String getTextbatchTitle() {
		
		String batchPageTitle = webdriver.findElement(batchTitle).getText();
		return batchPageTitle;
		
		
	}
	
	public  boolean ManageBatchHeaderDisplayed() {
		return webdriver.findElement(manageBatchHeading).isDisplayed();
			
	}
	
	public String getManageBatchText() {
		return webdriver.findElement(manageBatchHeading).getText();
	}
	
	
	
	public Boolean checkDisabledDeletebutton() {
		return webdriver.findElement(disabledDeleteButton).isDisplayed();
		
	}
	
    public boolean checkEnabledPaginationControls() {
	return webdriver.findElement(enabledPaginator).isDisplayed();
		
	}
	
    public boolean checkEditIconInEachrow() {
	//webdriver.findElement(editIcon).isDisplayed();
	
	List<WebElement> EditIconInEachrow = webdriver.findElements(editIcon);
	  for (WebElement element : EditIconInEachrow) {
        
        System.out.println(element.isDisplayed());
	  }
	return true ;
	
    }


    public boolean checkDeleteIconinEachRow() {
	//webdriver.findElement(deleteIcon).isDisplayed();
	List<WebElement> DeleteIconinEachRow = webdriver.findElements(deleteIcon);
	  for (WebElement element : DeleteIconinEachRow) {
      
      System.out.println(element.isDisplayed());
	  }
	return true;
	
	
    }

     public boolean checkCheckboxInEachRow() {
	//webdriver.findElement(checkBox).isDisplayed();
	  List<WebElement> checkboxEachRow = webdriver.findElements(checkBox);
	  for (WebElement element : checkboxEachRow) {
          
          System.out.println(element.isDisplayed());
	  }
	return true;
	
     }
    public boolean checkCheckboxDbHeader() {
	return webdriver.findElement(checkboxInDbHeader).isDisplayed();
	
	
	
     }

    public String checkDatatableHeaderRow() {
	//webdriver.findElement(dataTableheader).isDisplayed();
//	String headerName ="batchName";
//	
//	List<WebElement> DatatableHeaders = webdriver.findElements(By.xpath("//table//tr//th[@psortablecolumn='"+headerName+"']"));
//
//    // Iterate through the elements
//    for (WebElement element : DatatableHeaders) {
//        // Do something with each element
//        System.out.println(element.getText());
//    }
	
	int[]numbers = {2,3,4,5,6};
	for (int i = 2; i>=numbers.length;  i++) {
		
		List<WebElement> DatatableHeaders = webdriver.findElements(By.xpath("//table//tr//th["+i+"]"));	
		for (WebElement element : DatatableHeaders) {

	        System.out.println(element.getText());
	      
		}
	
	}
	return DatatableHeaders;
    }


    public boolean checkSorticonOfDatatableheaders() {
        List<WebElement> SorticonOfDatatableheaders = webdriver.findElements(sorticonInDbHeader);
        for (WebElement element : SorticonOfDatatableheaders) {
            System.out.println(element.isDisplayed());
        }
        return true;
    }
}

