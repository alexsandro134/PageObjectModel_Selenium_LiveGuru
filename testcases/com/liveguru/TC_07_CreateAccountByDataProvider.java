package com.liveguru;

import java.io.IOException;
import java.util.Arrays;

import liveguru.pageobjects.CreateAccountPagePO;
import liveguru.pageobjects.HomePagePO;
import liveguru.pageobjects.LiveGuruPageManagerDriver;
import liveguru.pageobjects.MyAccountPagePO;
import liveguru.pageobjects.MyDashboardPagePO;
import liveguru.pageobjects.MyWishlistPagePO;
import liveguru.pageobjects.ShareWishlistPagePO;
import liveguru.pageobjects.TVPagePO;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import commons.ExcelUtils;

public class TC_07_CreateAccountByDataProvider extends AbstractTest {

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
	Integer index;

	@Parameters({ "browser", "version", "url" })
	@BeforeClass
	public void beforeClass(String browser, String browserVersion, String url) throws Exception {
		driver = openMultiBrowser(browser, browserVersion, url);
		homePage = (HomePagePO) LiveGuruPageManagerDriver.getInstance(driver, "HomePage");
	}

	@Test(dataProvider = "Authentication")
	public void TC_01_CreateAccAndShareWishlist(String usr, String pwd) throws IOException, InvalidFormatException {
		
		Object[][] testObjArray = ExcelUtils.readExcel(".//resources//TestData.xlsx");
		Object[] myTwoDimensionalStringArray = new Object[]{usr,pwd};
		for(int i = 0; i < testObjArray.length; i++){
			if(Arrays.equals(testObjArray[i], myTwoDimensionalStringArray)){
				index = i;
				break;
			}
		}
		
		homePage.clickOnDynamicFooterLink(driver, "My Account");
		myAccountPage = (MyAccountPagePO) LiveGuruPageManagerDriver.getInstance(driver, "MyAccountPage");
		createAccountPage = myAccountPage.clickToCreateNewAccount();
		createAccountPage.inputAccountDynamicInformation(driver, "firstname", usr);
		createAccountPage.inputAccountDynamicInformation(driver, "middlename", middleName);
		createAccountPage.inputAccountDynamicInformation(driver, "lastname", pwd);
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
		myWishlistPage.clickOnAccountHeader(driver);
		myWishlistPage.logoutUser(driver);
		myWishlistPage.openAnyUrl(driver, "http://live.guru99.com/");
	}

	@DataProvider(name = "Authentication")
	public Object[][] credentials() throws Exception {
		Object[][] testObjArray = ExcelUtils.readExcel(".//resources//TestData.xlsx");
		return testObjArray;
	}

	@AfterClass
	public void afterClass(ITestResult result) {
		System.out.println(result.toString());
//		index = index + 1;
//		if (result.getStatus() == ITestResult.SUCCESS) {
//			ExcelUtils.writeData(index, "Pass");
//		} else if (result.getStatus() == ITestResult.FAILURE) {
//			ExcelUtils.writeData(index, "Fail");
//		} else if (result.getStatus() == ITestResult.SKIP) {
//			ExcelUtils.writeData(index, "Skip");
//		}
		closeBrowser(driver);
	}

}
