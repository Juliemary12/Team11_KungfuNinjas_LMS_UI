package lms_PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ClassPagination {

	private WebDriver webDriver;
	
	private By nextPageLink = By.xpath("//button[@Class='p-paginator-next p-paginator-element p-link p-ripple']//Span");
	private By lastPageLink = By.xpath("//button[@Class='p-paginator-last p-paginator-element p-link p-ripple ng-star-inserted']//Span");
	private By firstPageLink = By.xpath("//button[@class='p-paginator-prev p-paginator-element p-link p-disabled p-ripple']//Span");
	private By startPageLink = By.xpath("//button[@Class='p-paginator-first p-paginator-element p-link p-disabled p-ripple ng-star-inserted']//Span");

	
	public ClassPagination(WebDriver driver) {
		super();
		this.webDriver=driver;
		}
	
	
	public void nextPage() {
		
		WebElement nextPageElement = webDriver.findElement(nextPageLink);
		((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", nextPageElement);
		
	}
	
	public void nextPageRecord () {
		
	        WebElement table = webDriver.findElement(By.xpath("//table[@role='grid']")); 

	        // Get all rows in the table
	        List<WebElement> rows = table.findElements(By.tagName("tr"));

	        // Iterate through each row
	        for (int rowIndex = 0; rowIndex < rows.size(); rowIndex++) {
	            WebElement row = rows.get(rowIndex);
	            // Get all columns (cells) in the current row
	            List<WebElement> cols = row.findElements(By.tagName("td")); // or th for header cells

	            // Iterate through each column and print the text
	            for (int colIndex = 0; colIndex < cols.size(); colIndex++) {
	                System.out.print(cols.get(colIndex).getText() + "\t");
	            }
	            System.out.println("Page Record is Printed"); 
	        }
	}
	
	public void lastPage() {
		
		WebElement pageElement = webDriver.findElement(lastPageLink);
		((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", pageElement);
			

	}
	
	public void firstPage() {
		
		WebElement pageText = webDriver.findElement(firstPageLink);
		((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", pageText);
		
	}
	
	
	public void startPageLink() {
		
		WebElement pageList= webDriver.findElement(startPageLink);
		((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", pageList);
	}
}
