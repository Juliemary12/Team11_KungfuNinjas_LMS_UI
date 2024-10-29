//package browserlaunch;
//
//import java.time.Duration;
//import java.util.Properties;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.safari.SafariDriver;
//
//import lms_Utils.ConfigReader;
//
//import io.github.bonigarcia.wdm.WebDriverManager;
//
//public class Driverfactory {
//	private static WebDriver driver;
//    private static ConfigReader Config;
//    
//	  private static WebDriver init_driver(String Browser) {
//	        System.out.println(" Drive Factory browser value is :" + Browser);
//	        
//	        if (Browser.equals("chrome")) {
//				 WebDriverManager.chromedriver().setup(); 
//				 
//				 ChromeOptions chromeOptions = new ChromeOptions();
//				 chromeOptions.addArguments("--headless=new");
//				 driver = new ChromeDriver(chromeOptions);
//	        } else if (Browser.equals("firefox")) {
//	            WebDriverManager.firefoxdriver().setup();
//	            //tlDriver.set(new FirefoxDriver());
//	            driver = new FirefoxDriver();
//	        } else if (Browser.equals("safari")) {
//	            WebDriverManager.safaridriver().setup();
//	            //tlDriver.set(new SafariDriver());
//	            driver = new SafariDriver();
//	        } else if (Browser.equals("edge")) {
//	            WebDriverManager.edgedriver().setup();
//	            //tlDriver.set(new EdgeDriver());
//	            driver = new EdgeDriver();
//	        }else {
//	            System.out.println("Please pass the correct browser value :" + Browser);
//	        }
//	        
//	        getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
//	        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//	        getDriver().manage().deleteAllCookies();
//	        getDriver().manage().window().maximize();
//	        return getDriver();
//	    }
//
//	    public static synchronized WebDriver getDriver() {
//	    	//loading for the first time
//	    	if (driver == null) {
//	            Config = new ConfigReader();
//	            Properties prop  = Config.init_prop();
//	    		init_driver(prop.getProperty("browser"));
//	    	}
//	        return driver;
//	    }
//	    public static void closeallDriver() {
//			try {
//				driver.close();
//				driver.quit();
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//
//}
