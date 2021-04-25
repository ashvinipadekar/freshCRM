package com.CRM.Qa.testcases;


import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.CRM.Qa.Base.TestBase;
import com.CRM.Qa.Pages.Homepage;
import com.CRM.Qa.Pages.Loginpage;

public class LoginpageTest  extends TestBase{

	Loginpage lp;
	Homepage hp;
	public LoginpageTest()
	{
		super();
	//	 lp=new Loginpage();
	}
	
	@BeforeClass
	public void setup()
	{
		
		initialization();
		 lp=new Loginpage();
		
	}
	@Test(priority=1)
	public void loginpageTest()
	{
		String title=lp.validateloginpagetitle();
		Assert.assertEquals(title,"CRMPRO - CRM software for customer relationship management, sales, and support.");
	}
	@Test(priority=2)
	public void crmlogoTest()
	{
		boolean flag=lp.validatecrmimage();
		Assert.assertTrue(flag);
	}
	@Test(priority=3)
	public void loginTest()
	{
		hp=lp.login(prop.getProperty("username"),prop.getProperty("password"));
	}
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
}
