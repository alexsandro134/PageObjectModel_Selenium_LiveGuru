package com.liveguru;

import liveguru.pageobjects.CreateAccountPagePO;
import liveguru.pageobjects.HomePagePO;
import liveguru.pageobjects.LiveGuruPageManagerDriver;
import liveguru.pageobjects.MyAccountPagePO;
import liveguru.pageobjects.MyDashboardPagePO;
import liveguru.pageobjects.MyWishlistPagePO;
import liveguru.pageobjects.ShareWishlistPagePO;
import liveguru.pageobjects.TVPagePO;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;

public class TC_05_CreateAccountSuccessful extends AbstractTest {
	WebDriver driver;
	private HomePagePO homePage;
	private MyAccountPagePO myAccountPage;
	private CreateAccountPagePO createAccountPage;
	private MyDashboardPagePO myDashboardPage;
	private TVPagePO tvPage;
	private MyWishlistPagePO myWishlistPage;
	private ShareWishlistPagePO shareWishlistPage;

	String mobileName = "Sony Xperia";
	String firstName = "TAI";
	String middleName = "THIEN";
	String lastName = "LE";
	String password = "MyP@ssw0rd123";
	String successCreateMessage = "Thank you for registering with Main Website Store.";
	String tvName = "LG LCD";
	String shareWishlistBtn = "Share Wishlist";
	String successWishlistMessage = "Your Wishlist has been shared.";
	String shareMsg = "Sharing message tvPage Liveguru";

	@Parameters({ "browser", "version", "url" })
	@BeforeClass
	public void beforeClass(String browser, String browserVersion, String url) {
		driver = openMultiBrowser(browser, browserVersion, url);
		homePage = (HomePagePO) LiveGuruPageManagerDriver.getInstance(driver, "HomePage");
	}

	@Test
	public void TC_01_CreateAccAndShareWishlist() {
		homePage.clickOnDynamicFooterLink(driver, "My Account");
		myAccountPage = (MyAccountPagePO) LiveGuruPageManagerDriver.getInstance(driver, "MyAccountPage");
		createAccountPage = myAccountPage.clickToCreateNewAccount();
		createAccountPage.inputAccountDynamicInformation(driver, "firstname", firstName);
		createAccountPage.inputAccountDynamicInformation(driver, "middlename", middleName);
		createAccountPage.inputAccountDynamicInformation(driver, "lastname", lastName);
		createAccountPage.inputAccountDynamicInformation(driver, "email_address", generateEmail());
		createAccountPage.inputAccountDynamicInformation(driver, "password", password);
		createAccountPage.inputAccountDynamicInformation(driver, "confirmation", password);
		myDashboardPage = createAccountPage.clickToRegisterAccount();
		verifyEquals(myDashboardPage.getSuccessMsg(driver), successCreateMessage);
		homePage.clickOnDynamicMenuLink(driver, "TV");
		tvPage = (TVPagePO) LiveGuruPageManagerDriver.getInstance(driver, "TVPage");
		tvPage.addAction(driver, tvName, "link-wishlist");
		myWishlistPage = (MyWishlistPagePO) LiveGuruPageManagerDriver.getInstance(driver, "MyWishlistPage");
		myWishlistPage.clickToDynamicButton(driver, shareWishlistBtn);
		shareWishlistPage = (ShareWishlistPagePO) LiveGuruPageManagerDriver.getInstance(driver, "ShareWishlistPage");
		shareWishlistPage.inputToTextArea("email_address", generateEmail());
		shareWishlistPage.inputToTextArea("message", shareMsg);
		shareWishlistPage.clickToDynamicButton(driver, shareWishlistBtn);
		myWishlistPage = (MyWishlistPagePO) LiveGuruPageManagerDriver.getInstance(driver, "MyWishlistPage");
		verifyEquals(myWishlistPage.getSuccessMsg(driver), successWishlistMessage);
	}

	@AfterClass
	public void afterClass() {
		closeBrowser(driver);
	}

}
