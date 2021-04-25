package com.CRM.Qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.CRM.Qa.Base.TestBase;
import com.CRM.Qa.Pages.Contactpage;
import com.CRM.Qa.Pages.Homepage;
import com.CRM.Qa.Pages.Loginpage;
import com.CRM.Qa.Util.TestUtil;

public class ContactpageTest extends TestBase {

	Loginpage lp;
	Homepage hp;
	TestUtil tu;
	Contactpage cp;
	String sheetname="Sheet1";
	public ContactpageTest()
	{
		super();
	}
	
	@BeforeClass
	public void setup()
	{
		
		initialization();
		 lp=new Loginpage();
		 tu=new TestUtil();
		 cp=new Contactpage();
		hp= lp.login(prop.getProperty("username"),prop.getProperty("password"));
		tu.switchtoframe();
		cp=hp.clickoncontactpagelink();
	}
	
	@Test(priority=1)
	public void verifycontactlabelTest()
	{
		Assert.assertTrue(cp.verifyContactsLabel(), "contacts label is missing on the page");
	}
	
	@Test(priority=2)
	public void selectcontacttext()
	{
		cp.selectContactsByName("akash patel");
	}
	
	@Test(priority=3)
	public void selectMultipleContactsTest(){
		cp.selectContactsByName("akash patel");
		cp.selectContactsByName("bmala t");

	}
	
	@DataProvider
	public Object[][] getCRMTestData()
	{
		Object data[][]=TestUtil.getTestData(sheetname);
		return data;
	}
	
	@Test(priority=4,dataProvider="getCRMTestData")
	public void  validatecreatenewcontact(String title,String firstName,String lastName,String company)
	{
		hp.clickonnewcontact();
		//cp.createNewContact("Mr.", "Tom", "Peter","Google");
		cp.createNewContact(title, firstName, lastName, company);
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
}


		
 