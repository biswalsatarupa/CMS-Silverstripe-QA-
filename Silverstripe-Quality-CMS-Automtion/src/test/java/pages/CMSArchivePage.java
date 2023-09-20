package pages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.text.SimpleDateFormat;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import utility.ConfigReader;
import pages.CMSLogInPage;

public class CMSArchivePage {

	private WebDriver driver;
	private ConfigReader configReaderObj;
	private WebDriverWait wait;

	@FindBy(css="#pages-controller-cms-content > div.fill-height.flexbox-area-grow > div.cms-content-header.north > div.cms-content-header-info.flexbox-area-grow.vertical-align-items > div > span")
	private WebElement heading_newPage;

	@FindBy(xpath  = "//button[contains(text(),'Insert')]")
	private WebElement btn_insertbuttonInHeroImagesPage; 
	
	@FindBy(xpath = "//a[@id='tab-ActionMenus_MoreOptions']")
	private WebElement btn_unpublishArchive;
	
	@FindBy(xpath = "//input[@id='Form_EditForm_action_unpublish']")
	private WebElement btn_optionUnpublish;
	
	@FindBy(xpath = "//input[@id='Form_EditForm_action_archive']")
	private WebElement btn_optionArchive;
	
	@FindBy(css = "body.cms.js-react-boot.js-injector-boot:nth-child(2) div.cms-container.cms-container--content-mode:nth-child(2) div.fill-height.cms-menu.cms-panel.cms-panel-layout:nth-child(2) div.flexbox-area-grow.panel--scrollable.panel--triple-toolbar.cms-panel-content ul.cms-menu__list li.link:nth-child(8) > a:nth-child(1)")
	private WebElement link_archive;
	
	@FindBy( css = "#Form_EditForm_Pages > table > tbody > tr.ss-gridfield-item.first.odd > td.col-Title")
	private WebElement txt_archivePageText;
	
	
	public CMSArchivePage(WebDriver driver) {
		this.driver = driver;
		configReaderObj = new ConfigReader();
		wait = new WebDriverWait(driver, configReaderObj.getImpliciteWaitTime());
		PageFactory.initElements(driver, this);
	}

	public void archivePageInSilverstripeCMS(String url, String UserName, String Password, String pageType) throws InterruptedException {
		
		String pageName = heading_newPage.getText();
		System.out.println("Page name is :" + heading_newPage.getText() + "and String value is : " + pageName.toString() );
		wait.until(ExpectedConditions.elementToBeClickable(btn_unpublishArchive));
		btn_unpublishArchive.click();
		wait.until(ExpectedConditions.elementToBeClickable(btn_optionUnpublish));
		btn_optionUnpublish.click();
		Alert al = driver.switchTo().alert();
	    al.accept();
	    Thread.sleep(5000);
	    wait.until(ExpectedConditions.elementToBeClickable(btn_unpublishArchive));
		btn_unpublishArchive.click();
	    wait.until(ExpectedConditions.elementToBeClickable(btn_optionArchive));
	    btn_optionArchive.click();
		Alert al1 = driver.switchTo().alert();
	    al1.accept();
	    Thread.sleep(5000);
	    wait.until(ExpectedConditions.elementToBeClickable(link_archive));
	    link_archive.click();
	    Assert.assertTrue(txt_archivePageText.getText().equalsIgnoreCase(pageName), "Page name is equal");
	    Thread.sleep(5000);
		
		
		
		
		

	}

}
	

