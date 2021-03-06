package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Parameters;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;

public class TestBase {
	public static WebDriver driver; 
	public static Properties prop;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:\\Users\\Shubham\\eclipse-workspace\\CRMTest\\src\\com\\crm\\qa\\config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	
	}
	@Parameters("browser")
	public static void initialization(String browserName) {
	//String browserName = prop.getProperty("browser");
		System.out.println("browserName is: " + browserName);
	if(browserName.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		 driver = new ChromeDriver();
		}
	else if(browserName.equalsIgnoreCase("firefox")) {
		System.setProperty("webdriver.gecko.driver", "D:\\Selenium\\chromedriver_win32\\geckodriver.exe");
		driver = new FirefoxDriver();
	}
	e_driver = new EventFiringWebDriver(driver);
	
	// Now create object of EventListerHandler to register it with EventFiringWebDriver
	eventListener = new WebEventListener();
	e_driver.register(eventListener);
	driver = e_driver;
	
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_Load_TimeOut, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(TestUtil.implicit_wait, TimeUnit.SECONDS);
	driver.get(prop.getProperty("url"));
	}

}
