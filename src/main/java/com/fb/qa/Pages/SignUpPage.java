package com.fb.qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fb.qa.base.TestBase;

public class SignUpPage extends TestBase {
	@FindBy(xpath = "//a[text()='Create New Account']")
	WebElement CreateAccountBtn;
	
	@FindBy(xpath="//input[@name='firstname']")
	WebElement firstName;
	
	@FindBy(xpath="//input[@name='lastname']")
	WebElement lastName;
	
	@FindBy(xpath="//input[@name='reg_email__']")
	WebElement emailAddress;
	
	@FindBy(xpath="//input[@name='reg_email_confirmation__']")
	WebElement remailAddress;
	
	@FindBy(xpath="//input[@name='reg_passwd__']")
	WebElement newPassword;
	
	@FindBy(xpath="//*[@id='day']")
	WebElement day;
	
	@FindBy(xpath="//*[@id='month']")
	WebElement month;
	
	@FindBy(xpath="//*[@id='year']")
	WebElement year;
	
	@FindBy(xpath="//label[text()='Male']")
	WebElement Gender;
	
	@FindBy(xpath="//button[contains(text(),'Sign')]")
	WebElement signUpBtn;
	
	//Initialize page objects
	public SignUpPage() {
		PageFactory.initElements(driver, this);		
	}
	
	//Actions
	public String validateSignUpPageTitle() {
		return driver.getTitle();
	}
//	public boolean validateFBImage() {
//		return fbLogo.isDisplayed();
//	}
	
	public SignUpPage createNewAccount() {
		CreateAccountBtn.click();
		return new SignUpPage();
	}
	
	public HomePage signup(String fn, String ln, String em, String rem, String pwd, String d, String m, String y) {
		firstName.sendKeys(fn);
		lastName.sendKeys(ln);
		emailAddress.sendKeys(em);
		remailAddress.sendKeys(rem);
		newPassword.sendKeys(pwd);
		day.sendKeys(d);
		month.sendKeys(m);
		year.sendKeys(y);
		Gender.click();
		signUpBtn.click();
		
		return new HomePage();
	}

}
