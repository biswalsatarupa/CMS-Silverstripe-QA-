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

import pages.CMSCreatePage;
import pages.CMSLogInPage;
import testbase.BaseTest;
import utility.ConfigReader;
import utility.DriverUtils;

public class CMSCreatePageTest extends BaseTest {

	private WebDriver driver;
	private CMSCreatePage cmsCreatePageObj;
	private CMSLogInPage cmsLoginPageObj;
	
	private ConfigReader configReader;
	private String url;

	public CMSCreatePageTest() {
		configReader = new ConfigReader();
		url = configReader.getTestURL();
	}
	
	@BeforeTest()
	public void setupInitial() {
		driver = new DriverUtils().getDriver();
		cmsLoginPageObj = new CMSLogInPage(driver);
		cmsCreatePageObj = new CMSCreatePage(driver);
		
	}
	
	

	/*
	 *This method will verify the Page Creation in Silverstripe CMS 
	 */
	@Test(dataProvider = "getTestData",priority = 1, enabled = true,description= "To verify the Page Creation in Silverstripe CMS")
	public void verifyPageCreationInSilverstripeCMS(ITestContext context,String UserName,String Password, String pageType) throws Throwable {
		driver = new DriverUtils().getDriver();
		cmsLoginPageObj.LogInSilverstripeCMS(url, UserName, Password);
		cmsCreatePageObj.CreatePageInSilverstripeCMS(url, UserName, Password, pageType);
        
        test.log(Status.PASS, MarkupHelper.createLabel("Page creation  is successful in Silverstripe CMS", ExtentColor.GREEN));
			
	}

	
	
	
}

	
		
	
		


	