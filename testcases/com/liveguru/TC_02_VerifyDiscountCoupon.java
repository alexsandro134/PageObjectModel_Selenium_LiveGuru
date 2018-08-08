package com.liveguru;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;

public class TC_02_VerifyDiscountCoupon extends AbstractTest {
	WebDriver driver;

	@Parameters({ "browser", "version" })
	@BeforeClass
	public void beforeClass(String browser, String browserVersion) {
		driver = openMultiBrowser(browser, browserVersion);
	}

	@Test
	public void TC_02_VerifyCoupon() {
		// test Pull request in Github
	}

	@AfterClass
	public void afterClass() {
		closeBrowser(driver);
	}

}
