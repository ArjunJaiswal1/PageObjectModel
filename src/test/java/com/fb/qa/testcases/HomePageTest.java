package com.fb.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.fb.qa.Pages.HomePage;
import com.fb.qa.Pages.LoginPage;
import com.fb.qa.base.TestBase;

public class HomePageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest() {
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "Facebook – log in or sign up");
	}
	
	
	//@AfterMethod
	//public void tearDown() {
		//driver.quit();
	}


