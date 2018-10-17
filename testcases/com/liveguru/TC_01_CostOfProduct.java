package com.liveguru;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import liveguru.pageobjects.DetailProductPagePO;
import liveguru.pageobjects.HomePagePO;
import liveguru.pageobjects.LiveGuruPageManagerDriver;
import liveguru.pageobjects.MobilePagePO;

public class TC_01_CostOfProduct extends AbstractTest {
	WebDriver driver;
	private HomePagePO homePage;
	private MobilePagePO mobilePage;
	private DetailProductPagePO detailProductPage;

	String mobileName = "Sony Xperia";

	@Parameters({ "browser", "version", "url" })
	@BeforeClass
	public void beforeClass(String browser, String browserVersion, String url) throws Exception {
		driver = openMultiBrowser(browser, browserVersion, url);
		homePage = (HomePagePO) LiveGuruPageManagerDriver.getInstance(driver, "HomePage");
	}

	@Test
	public void TC_01_CostOfProd() {
		homePage.clickOnDynamicMenuLink(driver, "Mobile");
		mobilePage = (MobilePagePO) LiveGuruPageManagerDriver.getInstance(driver, "MobilePage");
		String priceMobile = mobilePage.getCostOfMobile(mobileName);
		detailProductPage = mobilePage.clickOnDynamicMobileLink(mobileName);
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
