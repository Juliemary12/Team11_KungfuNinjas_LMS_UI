package context;

import java.time.Duration;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
import lms_PageObject.Dashboard;
import lms_PageObject.LoginPage;
import lms_PageObject.ProgramDetails;
import lms_PageObject.ProgramPage;
import lms_Utils.PropertiesFile;

public class PicoContext {

	public static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();
	WebDriver driver;

	LoginPage lo;
	Dashboard db;
	ProgramPage programpage;
	ProgramDetails pdp;

	public void setDriver(WebDriver driver) throws Throwable {
		String browser = PropertiesFile.readPropertiesFile("browser");

		// Uncomment for cross Browser testing
		// String browser = TestNgConfigReader.getBrowserType();

		System.out.println("The browser value from properties file is: " + browser);

		if (browser.equalsIgnoreCase("Chrome")) {
			ChromeOptions co = new ChromeOptions();
			WebDriverManager.chromedriver().setup();

			co.addArguments("--headless");
			co.setPageLoadStrategy(PageLoadStrategy.NORMAL);
			driver = new ChromeDriver(co);
			threadLocalDriver.set(driver);
		}

		else if (browser.equalsIgnoreCase("Edge")) {
			EdgeOptions eo = new EdgeOptions();
			WebDriverManager.edgedriver().setup();

			eo.addArguments("--headless");
			driver = new EdgeDriver(eo);
			threadLocalDriver.set(driver);
		}

		else if (browser.equalsIgnoreCase("FireFox")) {

			FirefoxOptions fo = new FirefoxOptions();
			WebDriverManager.firefoxdriver().setup();

			fo.addArguments("--headless");
			driver = new FirefoxDriver(fo);
			threadLocalDriver.set(driver);
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		this.driver = driver;
	}

	public WebDriver getDriver() {
		return threadLocalDriver.get();
	}

	public LoginPage getLogin() {
		return lo;
	}

	public Dashboard getDashboardPage() {
		return db;
	}

	public ProgramPage getProgramPage() {
		return programpage;
	}

	public ProgramDetails getProgramDetailsPage() {
		return pdp;
	}

	public void initializePageObjects(WebDriver driver) {

		this.lo = new LoginPage(driver);
		this.db = new Dashboard(driver);
		this.programpage = new ProgramPage(driver);
		this.pdp = new ProgramDetails(driver);

	}
}
