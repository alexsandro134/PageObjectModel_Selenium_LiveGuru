package com.liveguru;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import liveguru.pageobjects.ComparePagePO;
import liveguru.pageobjects.HomePagePO;
import liveguru.pageobjects.LiveGuruPageManagerDriver;
import liveguru.pageobjects.MobilePagePO;

public class TC_04_CompareProducts extends AbstractTest {
	WebDriver driver;
	private HomePagePO homePage;
	private MobilePagePO mobilePage;
	private ComparePagePO comparePage;

	String mobileSony = "Sony Xperia";
	String mobileIphone = "IPhone";
	String quantityErrorMsg = "* The maximum quantity allowed for purchase is 500.";
	String emptyMsg = "Shopping Cart is Empty";
	String comparePageTitle = "COMPARE PRODUCTS";

	@Parameters({ "browser", "version", "url" })
	@BeforeClass
	public void beforeClass(String browser, String browserVersion, String url) throws Exception {
		driver = openMultiBrowser(browser, browserVersion, url);
		homePage = (HomePagePO) LiveGuruPageManagerDriver.getInstance(driver, "HomePage");
	}

	@Test
	public void TC_01_CompareProd() throws IOException {
		homePage.clickOnDynamicMenuLink(driver, "Mobile");
		mobilePage = (MobilePagePO) LiveGuruPageManagerDriver.getInstance(driver, "MobilePage");
		mobilePage.addAction(driver, mobileSony, "link-compare");
		mobilePage.addAction(driver, mobileIphone, "link-compare");
		int totalPhoneCompare = mobilePage.getTotalNumberCompare();
		comparePage = mobilePage.clickToCompare();
		verifyEquals(comparePage.getCompareTitle(), comparePageTitle);
		verifyEquals(comparePage.getNumberOfCompare(), totalPhoneCompare);
		verifyTrue(comparePage.isPhoneComparedDisplayed(mobileIphone));
		verifyTrue(comparePage.isPhoneComparedDisplayed(mobileSony));
		comparePage.closeComparePage();
	}

	@AfterClass
	public void afterClass() {
		closeBrowser(driver);
	}

}
