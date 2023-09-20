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

public class CMSSavePage {

	private WebDriver driver;
	private ConfigReader configReaderObj;
	private WebDriverWait wait;

	@FindBy(css = "#Form_EditForm_Title")
	private WebElement txt_pageName;

	@FindBy(css = "#Form_EditForm_action_save")
	private WebElement btn_save;
	
	@FindBy(css = "#Form_EditForm_HeroTitle")
	private WebElement txt_heroTitle;
	
	@FindBy(css = "#Form_EditForm_HeroIntro")
	private WebElement txt_heroIntro;
	
	@FindBy(css = "#Form_EditForm_HeroBackgroundImage_Holder > div > div > div > div > span > button.uploadfield__add-button")
	private WebElement btn_chooseExistingheroBackGroundImage;
	
	@FindBy(css = "#Form_EditForm_HeroBackgroundImage_Holder > div > div > div > div > span > button.uploadfield__upload-button.dz-clickable")
	private WebElement btn_uploadNewheroBackGroundImage;
	
	@FindBy(css = "#selectableItem-788 > div > div")
	private WebElement image_heroImages;
	
	@FindBy(xpath  = "//button[contains(text(),'Insert')]")
	private WebElement btn_insertbuttonInHeroImagesPage; 
	
	
	public CMSSavePage(WebDriver driver) {
		this.driver = driver;
		configReaderObj = new ConfigReader();
		wait = new WebDriverWait(driver, configReaderObj.getImpliciteWaitTime());
		PageFactory.initElements(driver, this);
	}

	public void SavePageInSilverstripeCMS(String url, String UserName, String Password, String pageType) throws InterruptedException {
		
		wait.until(ExpectedConditions.elementToBeClickable(txt_pageName));
		txt_pageName.sendKeys(new SimpleDateFormat("yyyy/MM/dd").format(new java.util.Date()));
		switch(pageType) {
		
		case "Home Page":
			txt_heroTitle.sendKeys("Hero");
			txt_heroIntro.sendKeys("Hero Introduction");
			wait.until(ExpectedConditions.elementToBeClickable(btn_chooseExistingheroBackGroundImage));
			btn_chooseExistingheroBackGroundImage.click();
			image_heroImages.click();
			btn_insertbuttonInHeroImagesPage.click();
			Thread.sleep(5000);
			wait.until(ExpectedConditions.elementToBeClickable(btn_save));
			btn_save.click();
			Thread.sleep(5000);
		break;
		
		
		

	}

}
	
}
