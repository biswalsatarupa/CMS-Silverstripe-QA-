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
import pages.CMSLogInPage;

public class CMSCreatePage {

	private WebDriver driver;
	private ConfigReader configReaderObj;
	private WebDriverWait wait;

	@FindBy(css = "#Menu-SilverStripe-CMS-Controllers-CMSPagesController > a")
	private WebElement link_pages;

	@FindBy(css = "#pages-controller-cms-content > div.flexbox-area-grow.fill-height.cms-content-fields.ui-widget-content.cms-panel-padded > div.panel.panel--padded.panel--scrollable.flexbox-area-grow.fill-height.flexbox-display.cms-content-view.cms-tree-view-sidebar.cms-panel-deferred > div.toolbar.toolbar--content.cms-content-toolbar > div.btn-toolbar.cms-actions-buttons-row > a")
	private WebElement btn_addNew;

	
	  @FindBy(css = "#Form_AddForm_PageType_SilverStripe_Com_PageTypes_HomePage")  
	  private WebElement radiobtn_homePage;
	  
	  @FindBy(css = "#Form_AddForm_PageType_SilverStripe_Com_PageTypes_AgencyLandingPage")  
	  private WebElement radiobtn_agencyLandingPage;
	  
	  
	  @FindBy(css = "#Form_AddForm_PageType_SilverStripe_Com_PageTypes_CareersLandingPage")
	  private WebElement radiobtn_careersLandingPage;
	  
	  @FindBy(css = "#Form_AddForm_PageType_SilverStripe_Com_PageTypes_PartnerLandingPage")
	  private WebElement radiobtn_partnerLandingPage;
	  
	  @FindBy(css = "#Form_AddForm_PageType_SilverStripe_Com_PageTypes_PricingPage")
	  private WebElement radiobtn_pricingPage;
	  
	  @FindBy(css = "#Form_AddForm_PageType_SilverStripe_Com_PageTypes_ResourceLandingPage")
	  private WebElement radiobtn_resourceLandingPage;
	  
	  @FindBy(css = "#Form_AddForm_PageType_SilverStripe_Com_PageTypes_TeamLandingPage")
	  private WebElement radiobtn_teamLandingPage;
	  
	  @FindBy(css = "#Form_AddForm_PageType_SilverStripe_Com_PageTypes_TeamPage")
	  private WebElement radiobtn_teamPage;
	  
	  @FindBy(css = "#Form_AddForm_PageType_SilverStripe_CMS_Model_VirtualPage")
	  private WebElement radiobtn_virtualPage;
	 
	
	  @FindBy(css="#Form_AddForm_action_doAdd")
	   private WebElement btn_create;
	  
	  @FindBy(css="#pages-controller-cms-content > div.fill-height.flexbox-area-grow > div.cms-content-header.north > div.cms-content-header-info.flexbox-area-grow.vertical-align-items > div > span")
	  private WebElement heading_newPage;
	 

	public CMSCreatePage(WebDriver driver) {
		this.driver = driver;
		configReaderObj = new ConfigReader();
		wait = new WebDriverWait(driver, configReaderObj.getImpliciteWaitTime());
		PageFactory.initElements(driver, this);
	}

	public void CreatePageInSilverstripeCMS(String url, String UserName, String Password, String pageType) throws InterruptedException {
		
		wait.until(ExpectedConditions.elementToBeClickable(link_pages));
		link_pages.click();
		wait.until(ExpectedConditions.elementToBeClickable(btn_addNew));
		btn_addNew.click();
		wait.until(ExpectedConditions.visibilityOf(radiobtn_homePage));
				
		switch(pageType) {
		
			case "Home Page":
			radiobtn_homePage.click();
			break;
			case "Agency Landing Page":
			radiobtn_agencyLandingPage.click();
			break;	
			case "Careers Landing Page":
			radiobtn_careersLandingPage.click();
			break;
			case "Partner Landing Page":
			radiobtn_partnerLandingPage.click();
			break;
			case "Pricing Page":
			radiobtn_pricingPage.click();
			break;
			case "Resource Landing Page":
			radiobtn_resourceLandingPage.click();
			break;
			case "Team Landing Page":
			radiobtn_teamLandingPage.click();
			break;
			case "Team Page":
			radiobtn_teamPage.click();
			break;
			case "Virtual Page":
			radiobtn_virtualPage.click();
			break;
			
					
		}
		
		wait.until(ExpectedConditions.visibilityOf(btn_create));	
		btn_create.click();
		wait.until(ExpectedConditions.visibilityOf(heading_newPage)); 
		Assert.assertTrue(heading_newPage.isDisplayed());
		// Assert.assertTrue(txt_silverStripe.getText().contains("Silverstripe"));

	}

}
