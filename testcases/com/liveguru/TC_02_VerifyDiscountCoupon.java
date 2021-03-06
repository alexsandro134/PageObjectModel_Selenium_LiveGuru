package com.liveguru;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import liveguru.pageobjects.CheckoutPagePO;
import liveguru.pageobjects.HomePagePO;
import liveguru.pageobjects.LiveGuruPageManagerDriver;
import liveguru.pageobjects.MobilePagePO;

public class TC_02_VerifyDiscountCoupon extends AbstractTest {
	WebDriver driver;
	private HomePagePO homePage;
	private MobilePagePO mobilePage;
	private CheckoutPagePO checkoutPage;

	String mobileName = "IPhone";
	String couponCode = "GURU50";
	
	@Parameters({ "browser", "version", "url" })
	@BeforeClass
	public void beforeClass(String browser, String browserVersion, String url) throws Exception {
		driver = openMultiBrowser(browser, browserVersion, url);
		homePage = (HomePagePO) LiveGuruPageManagerDriver.getInstance(driver, "HomePage");
	}

	@Test
	public void TC_02_VerifyCoupon() throws IOException {
		homePage.clickOnDynamicMenuLink(driver, "Mobile");
		mobilePage = (MobilePagePO) LiveGuruPageManagerDriver.getInstance(driver, "MobilePage");
		checkoutPage = mobilePage.addToCart(mobileName);
		checkoutPage.applyCouponCode(couponCode);
		verifyTrue(checkoutPage.discountGenerated(couponCode));
	}

	@AfterClass
	public void afterClass() {
		closeBrowser(driver);
	}

}
