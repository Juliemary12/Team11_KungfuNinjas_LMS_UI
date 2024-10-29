package lms_PageObject;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import javax.imageio.ImageIO;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.languagetool.JLanguageTool;
import org.languagetool.language.AmericanEnglish;
import org.languagetool.rules.RuleMatch;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import lms_Utils.ExcelReader;
import lms_Utils.PropertiesFile;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class LoginPage {
	
	private WebDriver webDriver;
	String UserNameExcelValue;
	String PasswordExcelValue;
	String Username="";
	String Password="";
	String ErrorMessage="";
	static int actualX =490; 
	static int actualY=354;
	
	

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

	private By loginContent = By.xpath("//p[normalize-space()='Please login to LMS application']");
	private By userLabel = By.xpath("//label[@id='mat-form-field-label-1']");
	private By pwdLabel =By.xpath("//span[@class='ng-tns-c78-1 ng-star-inserted']");
	private By asteriskLabel = By.xpath("//span[@class='mat-placeholder-required mat-form-field-required-marker ng-tns-c78-1 ng-star-inserted']");
	private By inputFieldAllign = By.xpath("//mat-card-content[@class='mat-card-content']");
	private By loginBtn = By.xpath("//span[@class='mat-button-wrapper']");
	private By userColour = By.xpath("//span[@class='ng-tns-c78-0 ng-star-inserted']");
	private By pwdColour = By.xpath("//label[@id='mat-form-field-label-3']");
	private By errorMsg = By.xpath("//mat-error[@id='errormessage']");
	private By userErrorMsg= By.xpath("//mat-error[@id='mat-error-1']");
	private By logo = By.xpath("//img[@class='images']");
	private By login = By.xpath("//button[@id='login']");
	
	
	   public String  dashboardPgae() {
		   
		   webDriver.findElement(username).sendKeys(PropertiesFile.readPropertiesFile("userName"));
		   webDriver.findElement(password).sendKeys(PropertiesFile.readPropertiesFile("passWord"));
		   webDriver.findElement(LoginButton).click();
		   String url = webDriver.getCurrentUrl();
//		   System.out.println("curent page titile:" + url);
		   return url;
	   }  
	   
		  
		public String invalidurl() {
			String InvalidUrl= "http://lms-frntend-hackathon-oct74-173fe79471.herokuapp.ccom/login";
			return InvalidUrl;
			
		}		
		
		public String loginContentText() {
			
			String ContentText = webDriver.findElement(loginContent).getText();
			return ContentText;			
		}
		
		public String textFirstField() {
			String textUser=webDriver.findElement(userLabel).getText();
			return textUser;			
		}
		
		public String textSecondField() {
			
			String textPwd=webDriver.findElement(pwdLabel).getText();
			return textPwd;
			
		}
		
		public String secondFieldAstk(){
			
			String asterik=webDriver.findElement(asteriskLabel).getText();
			return asterik;
		}
		
		public Point inputFldAlgn() {

			WebElement inputfield = webDriver.findElement(inputFieldAllign);
			return inputfield.getLocation();

		}
		
		public void logiButton() {
			
			webDriver.findElement(loginBtn).isDisplayed();
			
		}
		
		public Point loginBtnAllignment() {
			
			Point location=webDriver.findElement(loginBtn).getLocation();
			return location;
		}
		
		public String userColor() {
			
			String uColor = webDriver.findElement(userColour).getCssValue("color");
			System.out.println("User Text Color is:"+ uColor);
			return uColor; 
		}
		
		public String getUserColor() {
			
			String actualColor="rgba(0, 0, 0, 0.54)";
			return actualColor;
		}
		
		public String pwdColor() {
			
			String pwduColor = webDriver.findElement(pwdColour).getCssValue("color");
			System.out.println("Password Text Color is:"+ pwduColor);
			return pwduColor; 
		}
		
		public String getTextColor() {
			
			String actualColor="rgba(0, 0, 0, 0.54)";
			return actualColor;
		}
		
		
		public void Username() {
			
			webDriver.findElement(username).sendKeys("sdet2020");
				
		}
						
		public void Password() {
			
			webDriver.findElement(password).sendKeys("lmshackthon@2025");
			
		}
		
		public void clickButton() {
			
			webDriver.findElement(loginBtn).click();
		}

		
		public String errorMsg() {
			
		    String errorMessage = "";
		    
		    try {
		        errorMessage = webDriver.findElement(errorMsg).getText();
		        
		    } catch (NoSuchElementException e) {
		        System.out.println("Error message element not found: " + e.getMessage());
		    } 
		    return errorMessage;
		}
		
		public void pwd() {
			
			webDriver.findElement(password).sendKeys("LmsHackathon@2024");
			
		}
		
		public void UName() {
			
			webDriver.findElement(username).sendKeys("Sdet@2024");	
		}
		
		public void pwdEMsg() {
			
			
		}
	
		public String UNameErrorMsg() {
			
			String eMsg = webDriver.findElement(userErrorMsg).getText();
			return eMsg;
		}
		
		public void twoTextField() {
			
			boolean isDisplayed= webDriver.findElement(username).isDisplayed();
			boolean isDisplayed1=webDriver.findElement(password).isDisplayed();
			
			if(isDisplayed) {
				System.out.println("User name field is displayed");
			}else {
				System.out.println("User name field is not displayed");
			}
			if(isDisplayed1) {
				System.out.println("Password field is displayed");
			}else {
				System.out.println("Password field is not displayed");
			}
		}
		
		public void appNameOnLogo() throws IOException, TesseractException {
			 
			 try {
				    String imageURL = webDriver.findElement(logo).getAttribute("src");
				    
				    if (imageURL != null && !imageURL.isEmpty()) {
				        URL url = new URL(imageURL);
				        BufferedImage image1 = ImageIO.read(url);
				        
				        if (image1 != null) {
				            Tesseract tesseract = new Tesseract();
				            tesseract.setDatapath("C:/Users/shwet/git/Team11_KungfuNinjas_LMS_UI/tessdata");
				            tesseract.setLanguage("eng");
				            String extractedText = tesseract.doOCR(image1);
				            System.out.println("Image Text: " + extractedText);
				        } else {
				            System.err.println("Could not read image from URL: " + imageURL);
				        }
				    } else {
				        System.err.println("Image URL is null or empty.");
				    }
				} catch (MalformedURLException e) {
				    System.err.println("Invalid URL: " + e.getMessage());
				} catch (IOException e) {
				    System.err.println("Error reading the image: " + e.getMessage());
				} catch (TesseractException e) {
				    System.err.println("Error during OCR processing: " + e.getMessage());
				}
		} 
		
		public void keyAction() throws InterruptedException {
		
			Actions actions = new Actions(webDriver);	
		        WebElement userField = webDriver.findElement(username);
		        //userField.clear();
		        Thread.sleep(2000);
		        userField.sendKeys("Sdet@2024"+Keys.TAB);
		        Thread.sleep(2000);
		        WebElement pwdField = webDriver.findElement(password);
		        pwdField.clear();
		        Thread.sleep(2000);
		        pwdField.sendKeys("LmsHackathon@2024");
		        webDriver.findElement(loginBtn).click();
		        actions.sendKeys(Keys.ALT, Keys.LEFT).perform();
		        
		}
		
		public void mouseAction() throws InterruptedException {
			
			Actions actions = new Actions(webDriver);	
			WebElement mouseUserField = webDriver.findElement(username);
			
			actions.sendKeys(Keys.BACK_SPACE).perform();;
			
			actions.click(mouseUserField).perform();
			mouseUserField.sendKeys("Sdet@2024");
			Thread.sleep(2000);
			WebElement mousePwdField = webDriver.findElement(password);
			actions.sendKeys(Keys.BACK_SPACE).perform();;
			Thread.sleep(2000);
			actions.click(mousePwdField).perform();
			mousePwdField.sendKeys("LmsHackathon@2024");
			webDriver.findElement(loginBtn).click();
			
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
		
		 public void textSpellings() {
			  
			  String userText = webDriver.findElement(userLabel).getText();			  
			JLanguageTool languageTool = new JLanguageTool (new AmericanEnglish());
			  
			  try {
				  
				  List<RuleMatch> errors = languageTool.check(userText);  //perform spell check on the page text
				   if(errors.isEmpty()) {
					   System.out.println("No spelling mistake");
				   }else {
					   System.out.println("Spelling mistake found");
					   for (RuleMatch error : errors) {
						  
						   System.out.println("error on word:" + error.getLine() +", column" + error.getColumn() + ": " + error.getMessage());  
					   }
				   }
			  }catch (IOException e) {
				  
				  e.printStackTrace();
			  }		  
		  }
		 
		 public void textSpellings1() {
			  
			  String userText = webDriver.findElement(pwdColour).getText();			  
			JLanguageTool languageTool = new JLanguageTool (new AmericanEnglish());
			  
			  try {
				  
				  List<RuleMatch> errors = languageTool.check(userText);  //perform spell check on the page text
				   if(errors.isEmpty()) {
					   System.out.println("No spelling mistake");
				   }else {
					   System.out.println("Spelling mistake found");
					   for (RuleMatch error : errors) {
						  
						   System.out.println("error on word:" + error.getLine() +", column" + error.getColumn() + ": " + error.getMessage());  
					   }
				   }
			  }catch (IOException e) {
				  
				  e.printStackTrace();
			  }		  
		  }
		 
		 public void textSpellings3() {
			  
			  String userText = webDriver.findElement(loginBtn).getText();			  
			JLanguageTool languageTool = new JLanguageTool (new AmericanEnglish());
			  
			  try {
				  
				  List<RuleMatch> errors = languageTool.check(userText);  //perform spell check on the page text
				   if(errors.isEmpty()) {
					   System.out.println("No spelling mistake");
				   }else {
					   System.out.println("Spelling mistake found");
					   for (RuleMatch error : errors) {
						  
						   System.out.println("error on word:" + error.getLine() +", column" + error.getColumn() + ": " + error.getMessage());  
					   }
				   }
			  }catch (IOException e) {
				  
				  e.printStackTrace();
			  }		  
		  }
		 
		 public void textSpellings2() {
			  
			  String userText = webDriver.findElement(loginContent).getText();			  
			JLanguageTool languageTool = new JLanguageTool (new AmericanEnglish());
			  
			  try {
				  
				  List<RuleMatch> errors = languageTool.check(userText);  //perform spell check on the page text
				   if(errors.isEmpty()) {
					   System.out.println("No spelling mistake");
				   }else {
					   System.out.println("Spelling mistake found");
					   for (RuleMatch error : errors) {
						  
						   System.out.println("error on word:" + error.getLine() +", column" + error.getColumn() + ": " + error.getMessage());  
					   }
				   }
			  }catch (IOException e) {
				  
				  e.printStackTrace();
			  }		  
		  }
		 
		 public void logoutButton() {
			boolean isDisplayed =  webDriver.findElement(login).isDisplayed();	
			
			if (isDisplayed) {
				
				System.out.println("Logout Button is Displayed");
				
		 }else {
			 System.out.println("Logout Button is NOT Displayed");
			 
		 }
			
		
	}
}


	
	


