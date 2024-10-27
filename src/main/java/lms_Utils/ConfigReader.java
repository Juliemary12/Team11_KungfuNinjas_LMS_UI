package lms_Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	private static Properties properties;
	private final String configFilePath= "src/test/resources/lms_Config/config.properties";

	public ConfigReader(){

	File ConfigFile = new File(configFilePath);

	try {
	      FileInputStream configFileReader = new FileInputStream(ConfigFile);
	      properties = new Properties();

	try {
	      properties.load(configFileReader);
	      configFileReader.close();
	    } catch (IOException e) 
	      {
	        System.out.println(e.getMessage());
	      }
	  }  catch (FileNotFoundException e) 
	      {
	        System.out.println(e.getMessage());
	        throw new RuntimeException("config.properties not found at config file path " + configFilePath);
	      }
	  }

	public String getApplicationUrl() {
	String applicationurl = properties.getProperty("LMSURL");
	if(applicationurl != null)
	  return applicationurl;
	else 
	  throw new RuntimeException("Application url not specified in the config.properties file.");
	}

	public static String getUserName() {
	String username = properties.getProperty("username");
	if(username != null)
	  return username;
	else
	  throw new RuntimeException("username not specified in the config.properties file.");
	}

	public static String getPassword() {
	String password = properties.getProperty("password");
	if(password != null)
	  return password;
	else
	  throw new RuntimeException("password not specified in the config.properties file.");
	}

	public String getBrowser() {
	String browser = properties.getProperty("browser");

	if(browser != null)
	  return browser;
	else
	  throw new RuntimeException("browser not specified in the config.properties file.");
	}
	
}

	
