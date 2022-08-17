package com.fb.qa.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fb.qa.Pages.HomePage;
import com.fb.qa.Pages.LoginPage;
import com.fb.qa.base.TestBase;
import com.fb.qa.util.TestUtil;
import com.fb.qa.util.WebEventListener;



public class LoginPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
    TestUtil testUtil;
    WebEventListener WebEventListener; 
	String sheetName = "Sheet1";
	Logger log = Logger.getLogger(LoginPageTest.class);
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		homePage = new HomePage();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		WebEventListener = new WebEventListener();
	}
	
	@Test(priority=1) 
	public void LoginPageTitle() {
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title,"Facebook – log in or sign up");
	}
	@Test(priority=2) 
	public void fbLogoImageTest() {
		boolean flag = loginPage.validateFBImage();
		Assert.assertTrue(flag);
	}
	@Test(priority=3)
	public void loginTest() {
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@DataProvider
	public Object[][] getTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(dataProvider = "getTestData")
	public void loginTest(String username, String password) throws InterruptedException {
		loginPage.login(username, password);
		Thread.sleep(2000);
		log.info("Login successful with username: " +username);
	}

	
	@AfterMethod
	public void tearDown() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
		log.info("Browser is closed");
	}

}