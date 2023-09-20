package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import org.testng.Assert;
import org.testng.ITestContext;


import pages.CMSLogInPage;
import testbase.BaseTest;
import utility.ConfigReader;
import utility.DriverUtils;

public class CMSLogInTest extends BaseTest {

	private WebDriver driver;
	private CMSLogInPage cmsLoginPageObj;
	
	private ConfigReader configReader;
	private String url;

	public CMSLogInTest() {
		configReader = new ConfigReader();
		url = configReader.getTestURL();
	}
	
	@BeforeTest()
	public void setupInitial() {
		driver = new DriverUtils().getDriver();
		cmsLoginPageObj = new CMSLogInPage(driver);
		
	}
	
	

	/*
	 *This method will verify the Log-In in Silverstripe CMS 
	 */
	@Test(dataProvider = "getTestData",priority = 1, enabled = true,description= "To verify the Log-In in Silverstripe CMS")
	public void verifyLogInSilverstripeCMS(ITestContext context,String UserName,String Password) throws Throwable {
		driver = new DriverUtils().getDriver();
		cmsLoginPageObj.LogInSilverstripeCMS(url, UserName, Password);
        
        test.log(Status.PASS, MarkupHelper.createLabel("Log-In  is successful in Silverstripe CMS", ExtentColor.GREEN));
			
	}

	
	
	
}

	
		
	
		


	