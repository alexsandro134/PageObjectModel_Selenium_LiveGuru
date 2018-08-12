package com.liveguru;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import liveguru.pageobjects.CheckoutPagePO;
import liveguru.pageobjects.EmptyCartPagePO;
import liveguru.pageobjects.HomePagePO;
import liveguru.pageobjects.MobilePagePO;
import liveguru.pageobjects.PageManagerDriver;

public class TC_03_AddOverQuantiyInStock extends AbstractTest {
	WebDriver driver;
	private HomePagePO homePage;
	private MobilePagePO mobilePage;
	private CheckoutPagePO checkoutPage;
	private EmptyCartPagePO emptyCartPage;

	String mobileName = "Sony Xperia";
	String quantityErrorMsg = "* The maximum quantity allowed for purchase is 500.";
	String emptyMsg = "SHOPPING CART IS EMPTY";

	@Parameters({ "browser", "version" })
	@BeforeClass
	public void beforeClass(String browser, String browserVersion) {
		driver = openMultiBrowser(browser, browserVersion);
		homePage = PageManagerDriver.getHomePage(driver);
	}

	@Test
	public void TC_01_CostOfProd() {
		mobilePage = homePage.clickOnDynamicMenuLink(driver, "Mobile");
		checkoutPage = mobilePage.addToCart(mobileName);
		checkoutPage.updateQuantity("1000");
		verifyTrue(checkoutPage.verifyErrorMessageDisplayed());
		verifyEquals(checkoutPage.getErrorMessage().trim(), quantityErrorMsg);

		log.info("Click to Empty Cart");
		emptyCartPage = checkoutPage.clickToEmptyCart();
		
		log.info("Verify Empty Msg is displayed");
		verifyTrue(emptyCartPage.verifyEmptyMessageDisplayed());
		
		log.info("Verify content of Empty Msg");
		verifyEquals(emptyCartPage.getEmptyMsg(), emptyMsg);
	}

	@AfterClass
	public void afterClass() {
		closeBrowser(driver);
	}

}