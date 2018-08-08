package com.liveguru;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.DetailProductPagePO;
import pages.HomePagePO;
import pages.PageManagerDriver;
import commons.AbstractTest;

public class TC_01_CostOfProduct extends AbstractTest {
	WebDriver driver;
	private HomePagePO homepage;
	private DetailProductPagePO detailProductPage;

	String mobileName = "Sony Xperia";

	@Parameters({ "browser", "version" })
	@BeforeClass
	public void beforeClass(String browser, String browserVersion) {
		driver = openMultiBrowser(browser, browserVersion);
		homepage = PageManagerDriver.getHomePage(driver);
	}

	@Test
	public void TC_01_CostOfProd() {
		homepage.clickOnDynamicMenuLink("Mobile");
		String priceMobile = homepage.getCostOfMobile(mobileName);
		detailProductPage = homepage.clickOnDynamicMobileLink(mobileName);
		String prodName = detailProductPage.getProductName();
		String detailPrice = detailProductPage.getProductPrice();
		verifyEquals(prodName.toUpperCase(), mobileName.toUpperCase());
		verifyEquals(priceMobile, detailPrice);
	}

	@AfterClass
	public void afterClass() {
		closeBrowser(driver);
	}

}
