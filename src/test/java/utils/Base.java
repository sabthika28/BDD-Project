package utils;

import java.util.Properties;

import java.util.HashMap;
import java.util.Map;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	 static final int TIME=2000;
	public static WebDriver driver;

	
	public static void launchBrowser() {
		Properties prop=PropertyReader.readProperties();
		if(prop.getProperty("Browser").equalsIgnoreCase("Chrome")) {
			ChromeOptions chromeOptions = new ChromeOptions();
			Map<String, Object> chromePrefs = new HashMap<>();
			chromePrefs.put("credentials_enable_service", false);

			chromePrefs.put("profile.password_manager_leak_detection", false);
			chromeOptions.setExperimentalOption("prefs", chromePrefs);

			driver = new ChromeDriver(chromeOptions);

			driver.get("https://www.saucedemo.com/");
			driver.manage().window().maximize();
		} else if(prop.getProperty("Browser").equalsIgnoreCase("Firefox")) {
			driver=new FirefoxDriver();
			driver.manage().window().maximize();
			
		}
		
	    driver.get(prop.getProperty("URL"));
		
	}


	public static void sleep() {
		// TODO Auto-generated method stub
		
	}
	
}
