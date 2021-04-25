package com.CRM.Qa.Base;

import java.io.File;
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

import com.CRM.Qa.Util.TestUtil;
import com.CRM.Qa.Util.WebEventListener;
//import com.CRM.Qa.Util.WebEventListener;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	public TestBase()
	{
		try {
			
			 prop=new Properties();
			 FileInputStream fis=new FileInputStream(new File("C:\\Users\\lenovo\\eclipse-workspace\\freeCRMTest\\src\\main\\java\\com\\CRM\\Qa\\config\\config.properties"));
			 prop.load(fis);
		
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public void initialization()
	{
		String browsername = prop.getProperty("browser");
		if(browsername.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","./Driver/chromedriver1.exe");
			
			 driver=new ChromeDriver();	
		}
		else if(browsername.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver","./Driver/geckodriver.exe");
			 driver= new FirefoxDriver();
		}
		else if(browsername.equals("ie"))
		{
			System.setProperty("webdriver.ie.driver","./Driver/IEDriverServer.exe.");
			 driver=new InternetExplorerDriver();
		}
		else
		{
			System.out.println("no browser launche");
			
		}
		
//		e_driver = new EventFiringWebDriver(driver);
//		// Now create object of EventListerHandler to register it with EventFiringWebDriver
//		eventListener = new WebEventListener();
//		e_driver.register(eventListener);
//		driver = e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(TestUtil.page_load_timeout,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(TestUtil.implicit_weight, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}
	
	
	
}
