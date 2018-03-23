package com.testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.*;
import org.testng.annotations.Parameters;

import com.listners.WebEventListner;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	
	
	
	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream fip = new FileInputStream("C:\\Users\\sarit\\eclipse-workspace\\BrowserAutomation\\src\\main\\java\\com\\"
					+ "configuration\\config.properties");
			prop.load(fip);
				}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public static void Intialization(String browserName) {
		//String browserName=prop.getProperty("browser");
		
		String baseUrl=prop.getProperty("url");
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
			driver=new ChromeDriver();
		} else if(browserName.equals("ie")) {
			System.setProperty("webdriver.ie.driver", "C:\\IEDriverServer.exe");
			driver=new InternetExplorerDriver();
		}
		else if(browserName.equals("firefox")) {
			System.setProperty("webdriver.firefox.driver", "C:\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
	
	
	e_driver=new EventFiringWebDriver(driver);
	WebEventListner eventListner=new WebEventListner();
	e_driver.register(eventListner);
	driver=e_driver;
	
	driver.manage().window().maximize();
	driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS);
	driver.get(baseUrl);

}
}
