package lms_Utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class PropertiesFile {

	static Properties prop = new Properties();

	// Method to read from config.properties file
	public static String readPropertiesFile(String key) {

		try { // Giving the config.properties file location
			FileInputStream input = new FileInputStream("src/test/resources/lms_Config/config.properties");
			prop.load(input); // Loading the config.properties file
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		return prop.getProperty(key);// Getting the required property from the config.properties file
	}

	// Method to write to config.properties file
	public static void writePropertiesFile(String key, String value) {

		try {
			FileOutputStream output = new FileOutputStream("src/test/resources/lms_Config/config.properties");
			prop.setProperty(key, value);
			prop.store(output, null);
		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}
}
