package pages;

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

public class CMSLogInPage {

	private WebDriver driver;
	private ConfigReader configReaderObj;
	private WebDriverWait wait;

		
	@FindBy(css="#MemberLoginForm_LoginForm_Email")
	private WebElement txt_login;
	
	@FindBy(css="#MemberLoginForm_LoginForm_Password")
	private WebElement txt_password;
	
	@FindBy(css="#MemberLoginForm_LoginForm_action_doLogin")
	private WebElement btn_login;
	
	@FindBy(css="#cms-menu > div.cms-menu__header > div.cms-sitename > a.cms-sitename__title")
	private WebElement txt_silverStripe;
		
	public CMSLogInPage(WebDriver driver) {
		this.driver = driver;
		configReaderObj = new ConfigReader();
		wait = new WebDriverWait(driver, configReaderObj.getImpliciteWaitTime());
		PageFactory.initElements(driver, this);
	}

	public void LogInSilverstripeCMS(String url, String UserName, String Password) throws InterruptedException {
		driver.get(url);		
		wait.until(ExpectedConditions.elementToBeClickable(txt_login));
		txt_login.click();
		txt_login.sendKeys(UserName);
		wait.until(ExpectedConditions.elementToBeClickable(txt_password));
		txt_password.click();
		txt_password.sendKeys(Password);
		wait.until(ExpectedConditions.elementToBeClickable(btn_login));
		btn_login.click();
		wait.until(ExpectedConditions.elementToBeClickable(txt_silverStripe));
		Assert.assertTrue(txt_silverStripe.getText().contains("Silverstripe"));
		Thread.sleep(5000);
		}

	

	
	
}
