package lms_PageObject;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import lms_Utils.ConfigReader;
import lms_Utils.ExcelReader;
import lms_Utils.PropertiesFile;

public class LoginPage {

	private WebDriver webDriver;
	String UserNameExcelValue;
	String PasswordExcelValue;

	private By username = By.xpath("//input[@id='username']");
	private By password = By.xpath("//input[@id='password']");
	private By LoginButton = By.xpath("//span[@class='mat-button-wrapper']");

	public LoginPage(WebDriver driver) {
		super();
		this.webDriver = driver;
	}

	public void readDataFromSheet(String sheetName, Integer rowNumber) throws InvalidFormatException, IOException {
		lms_Utils.ExcelReader reader = new ExcelReader();
		List<Map<String, String>> testdata = reader.getData("src/test/resources/TestData/LMSTestData.xlsx", sheetName);
		UserNameExcelValue = testdata.get(rowNumber).get("UserName");
		PasswordExcelValue = testdata.get(rowNumber).get("Password");

	}

	public void sendUserName() {

		webDriver.findElement(username).sendKeys(UserNameExcelValue);

	}

	public void sendPassword() {

		webDriver.findElement(password).sendKeys(PasswordExcelValue);
	}

	public void loginButton() {

		webDriver.findElement(LoginButton).click();

	}

	public String getPageTitle() {
		String Title = webDriver.getTitle();
		return Title;

	}

	public void loginsucess() {
		String userName = PropertiesFile.readPropertiesFile("username");
		String passWord = PropertiesFile.readPropertiesFile("password");
		webDriver.findElement(username).sendKeys(userName);
		webDriver.findElement(password).sendKeys(passWord);

	}

}
