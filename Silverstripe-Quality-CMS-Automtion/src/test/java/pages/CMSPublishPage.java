package pages;

import java.text.SimpleDateFormat;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import utility.ConfigReader;
import pages.CMSLogInPage;

public class CMSPublishPage {

	private WebDriver driver;
	private ConfigReader configReaderObj;
	private WebDriverWait wait;


	@FindBy(xpath = "//span[contains(text(),'Publish')]")
	private WebElement btn_publish;
	

	public CMSPublishPage(WebDriver driver) {
		this.driver = driver;
		configReaderObj = new ConfigReader();
		wait = new WebDriverWait(driver, configReaderObj.getImpliciteWaitTime());
		PageFactory.initElements(driver, this);
	}

	public void publishPageInSilverstripeCMS(String url, String UserName, String Password, String pageType) throws InterruptedException {
		
		
		wait.until(ExpectedConditions.elementToBeClickable(btn_publish));
		btn_publish.click();
		Thread.sleep(5000);

	}

}
