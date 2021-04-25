package com.CRM.Qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.CRM.Qa.Base.TestBase;

public class Loginpage extends TestBase {
	
	
	//page factory or object repository
	
	@FindBy(xpath="//input[@name='username']")
	WebElement username;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement lgnbtn;
	
	@FindBy(xpath="//*[@id=\"navbar-collapse\"]/ul/li[2]/a")
	WebElement signupbtn;
	
	
	@FindBy(xpath="/html/body/div[2]/div/div[1]/a")
//	@FindBy(xpath="/html/body/div[2]/div/div[1]/a/img")
	WebElement crmlogo;
	
	//initialize the page objects
	public Loginpage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String validateloginpagetitle()
	{
		return driver.getTitle();
	}
	public boolean validatecrmimage()
	{
		return crmlogo.isDisplayed();
	}
	public Homepage login(String uname,String pass)
	{
		username.sendKeys(uname);
		password.sendKeys(pass);
		
		lgnbtn.click();
		return new Homepage();
	}

}
