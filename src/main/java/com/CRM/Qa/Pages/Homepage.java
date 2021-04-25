package com.CRM.Qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.CRM.Qa.Base.TestBase;

public class Homepage extends TestBase {

	@FindBy(xpath="//td[contains(text(),'User: group automation')]")
	@CacheLookup// used is store all the element value in cache memory  , not require browser every time to go and take the values
	// problem of chache is if page get refresh then memory will be crashed and gives stale element exception
	// how will you improve performance of script -- by using cachememory
	WebElement usernamelabel;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactlink;
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement newcontactlink;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement dealslink;
	
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement tasklink;
	
	
	// initialising page objects
	public Homepage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifyhomepagetitle()
	{
		return driver.getTitle();
	}
	
	public boolean verifycorrectusername()
	{
		
		return usernamelabel.isDisplayed();
	}
	
	public Contactpage  clickoncontactpagelink()
	{
		contactlink.click();
		return new Contactpage();
	}
	
	
	public Dealspage  clickondealspagelink()
	{
		dealslink.click();
		return new Dealspage();
	}
	
	public Teskpage  clickontaskpagelink()
	{
		tasklink.click();
		return new Teskpage();
	}
	
	public void clickonnewcontact()
	{
		Actions action=new Actions(driver);
		action.moveToElement(contactlink).build().perform();
		newcontactlink.click();
	}
}
