package com.fb.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;


import com.fb.qa.util.TestUtil;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	
	
	public TestBase(){
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:\\Users\\HP 14-dh\\eclipse-workspace\\PageObjectModel\\src\\main\\java\\com\\fb\\qa\\config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void initialization()
	{
		String browserName = prop.getProperty("browser");
	if(browserName.equals("chrome")){
		System.setProperty("webdriver.chrome.driver","C:\\Users\\HP 14-dh\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();	
	}
	else if(browserName.equals("Edge")){
		System.setProperty("webdriver.edge.driver","C:\\Users\\HP 14-dh\\Downloads\\edgedriver_win32\\edgedriver.exe");
		driver = new EdgeDriver(); 
		}
	
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
	
	driver.get(prop.getProperty("url"));
	}
}