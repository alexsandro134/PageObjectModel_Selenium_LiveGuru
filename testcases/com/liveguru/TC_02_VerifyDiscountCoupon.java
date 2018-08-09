package com.liveguru;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.CheckoutPagePO;
import pages.HomePagePO;
import pages.MobilePagePO;
import pages.PageManagerDriver;

import commons.AbstractTest;

public class TC_02_VerifyDiscountCoupon extends AbstractTest {
	WebDriver driver;
	private HomePagePO homepage;
	private MobilePagePO mobilePage;
	private CheckoutPagePO checkoutPage;

	String mobileName = "IPhone";
	String couponCode = "GURU50";
	
	@Parameters({ "browser", "version" })
	@BeforeClass
	public void beforeClass(String browser, String browserVersion) {
		driver = openMultiBrowser(browser, browserVersion);
		homepage = PageManagerDriver.getHomePage(driver);
	}

	@Test
	public void TC_02_VerifyCoupon() {
		mobilePage = homepage.clickOnDynamicMenuLink("Mobile");
		checkoutPage = mobilePage.addToCart(mobileName);
		checkoutPage.applyCouponCode(couponCode);
		verifyTrue(checkoutPage.discountGenerated(couponCode));
	}

	@AfterClass
	public void afterClass() {
		closeBrowser(driver);
	}

}
