package com.CRM.Qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.CRM.Qa.Base.TestBase;
import com.CRM.Qa.Pages.Contactpage;
import com.CRM.Qa.Pages.Homepage;
import com.CRM.Qa.Pages.Loginpage;
import com.CRM.Qa.Util.TestUtil;

public class HomepageTest  extends TestBase{

	
	Loginpage lp;
	Homepage hp;
	TestUtil tu;
	Contactpage cp;
	
	public HomepageTest()
	{
		super();
	}
	
	// test cases should be seperated---independent to each other
	//before each test case--launche the browser and login
	//@Test
	//after each test case --close the browser
	@BeforeClass
	public void setup()
	{
		
		initialization();
		 lp=new Loginpage();
		 tu=new TestUtil();
		 cp=new Contactpage();
		hp= lp.login(prop.getProperty("username"),prop.getProperty("password"));
		
	}
	
	@Test(priority=1)
	public void verifyHomepagetitle()
	{
		String homepagetitle=hp.verifyhomepagetitle();
		Assert.assertEquals(homepagetitle, "CRMPRO","Home page title not matched");
	}
	@Test(priority=2)
	public void verifyusernameTest()
	{
		tu.switchtoframe();
		Assert.assertTrue(hp.verifycorrectusername());
	}
	@Test(priority=3)
	public void verifycontactlist()
	{
		//tu.switchtoframe();
		cp=hp.clickoncontactpagelink();
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
}
