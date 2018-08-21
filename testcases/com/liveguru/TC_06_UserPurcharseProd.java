package com.liveguru;

import liveguru.pageobjects.BillingPagePO;
import liveguru.pageobjects.CheckoutPagePO;
import liveguru.pageobjects.HomePagePO;
import liveguru.pageobjects.LiveGuruPageManagerDriver;
import liveguru.pageobjects.MyAccountPagePO;
import liveguru.pageobjects.MyDashboardPagePO;
import liveguru.pageobjects.MyWishlistPagePO;
import liveguru.pageobjects.SuccessOrderPagePO;
import liveguru.pageobjects.TVPagePO;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import commons.Constants;

public class TC_06_UserPurcharseProd extends AbstractTest {
	WebDriver driver;
	private HomePagePO homePage;
	private MyAccountPagePO myAccountPage;
	private MyDashboardPagePO myDashboardPage;
	private TVPagePO tvPage;
	private MyWishlistPagePO myWishlistPage;
	private CheckoutPagePO checkoutPage;
	private BillingPagePO billingPage;
	private SuccessOrderPagePO successOrderPage;

	String tvName = "LG LCD";
	String addToCartBtn = "Add to Cart";
	String usaCountry = "United States";
	String stateText = "New York";
	String zipCode = "543432";
	String thanksMsg = "THANK YOU FOR YOUR PURCHASE!";

	@Parameters({ "browser", "version", "url" })
	@BeforeClass
	public void beforeClass(String browser, String browserVersion, String url) {
		driver = openMultiBrowser(browser, browserVersion, url);
		homePage = LiveGuruPageManagerDriver.getHomePage(driver);
	}

	@Test
	public void TC_01_UserAblePurchaseProd() {
		homePage.clickOnDynamicFooterLink(driver, "My Account");
		myAccountPage = LiveGuruPageManagerDriver.getMyAccountPage(driver);
		myAccountPage.inputInfoToLogin(Constants.LIVEGURU_USERNAME, "email");
		myAccountPage.inputInfoToLogin(Constants.LIVEGURU_PASSWORD, "pass");
		myAccountPage.clickToDynamicButton(driver, "Login");
		
		myDashboardPage = LiveGuruPageManagerDriver.getMyDashboardPage(driver);
		verifyTrue(myDashboardPage.isUserLoginSuccessful());
		myDashboardPage.clickOnDynamicMenuLink(driver, "TV");
		
		tvPage = LiveGuruPageManagerDriver.getTVPage(driver);
		tvPage.addAction(driver, tvName, "link-wishlist");
		
		myWishlistPage = LiveGuruPageManagerDriver.getMyWishlistPage(driver);
		myWishlistPage.clickToDynamicButton(driver, addToCartBtn);
		
		checkoutPage = LiveGuruPageManagerDriver.getCheckoutPage(driver);
		checkoutPage.selectCountryToShip(usaCountry);
		checkoutPage.selectState(stateText);
		checkoutPage.inputZipCode(zipCode);
		checkoutPage.clickToDynamicButton(driver, "Estimate");
		verifyTrue(checkoutPage.verifyShippingCostIsGenerated());
		
		checkoutPage.addShippingCost();
		
		String expectedPrice = "$" + String.format("%.2f", Double.parseDouble(checkoutPage.getProdPrice().substring(1)) + 5.00);
		verifyEquals(checkoutPage.getTotalPrice(), expectedPrice);
		
		checkoutPage.clickToDynamicButton(driver, "Proceed to Checkout");
		billingPage = LiveGuruPageManagerDriver.getBillingPage(driver);
		billingPage.clickToDynamicButton(driver, "Continue");
		billingPage.clickContinueInShipping("shipping-method-buttons-container");
		billingPage.selectOrderType("p_method_checkmo");
		billingPage.clickContinueInShipping("payment-buttons-container");
		billingPage.clickToDynamicButton(driver, "Place Order");
		
		successOrderPage = LiveGuruPageManagerDriver.getSuccessOrderPage(driver);
		verifyEquals(successOrderPage.getOrderMessage(), thanksMsg);
		
		log.info(successOrderPage.getOrderNumber());
	}

	@AfterClass
	public void afterClass() {
		closeBrowser(driver);
	}

}
