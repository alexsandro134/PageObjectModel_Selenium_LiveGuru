package liveguru.pageobjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;

public class LiveGuruPageManagerDriver {

	private static HomePagePO homePage;
	private static DetailProductPagePO detailProductPage;
	private static MobilePagePO mobilePage;
	private static CheckoutPagePO checkoutPage;
	private static EmptyCartPagePO emptyCartPage;
	private static ComparePagePO comparePage;
	private static MyAccountPagePO myAccountPage;
	private static CreateAccountPagePO createAccountPage;
	private static MyDashboardPagePO myDashboardPage;
	private static TVPagePO tvPage;
	private static MyWishlistPagePO myWishlistPage;
	private static ShareWishlistPagePO shareWishlistPage;
	private static BillingPagePO billingPage;
	private static SuccessOrderPagePO successOrderPage;

	public static AbstractPage getInstance(WebDriver driver, String page) {
		switch (page) {
		case "HomePage":
			if (homePage == null) {
				return new HomePagePO(driver);
			}
			return homePage;

		case "DetailProductPage":
			if (detailProductPage == null) {
				return new DetailProductPagePO(driver);
			}
			return detailProductPage;
			
		case "MobilePage":
			if (mobilePage == null) {
				return new MobilePagePO(driver);
			}
			return mobilePage;
			
		case "CheckoutPage":
			if (checkoutPage == null) {
				return new CheckoutPagePO(driver);
			}
			return checkoutPage;
			
		case "ComparePage":
			if (comparePage == null) {
				return new ComparePagePO(driver);
			}
			return comparePage;

		case "MyAccountPage":
			if (myAccountPage == null) {
				return new MyAccountPagePO(driver);
			}
			return myAccountPage;
			
		case "CreateAccountPage":
			if (createAccountPage == null) {
				return new CreateAccountPagePO(driver);
			}
			return createAccountPage;
			
		case "MyDashboardPage":
			if (myDashboardPage == null) {
				return new MyDashboardPagePO(driver);
			}
			return myDashboardPage;
			
		case "EmptyCartPage":
			if (emptyCartPage == null) {
				return new EmptyCartPagePO(driver);
			}
			return emptyCartPage;
			
		case "TVPage":
			if (tvPage == null) {
				return new TVPagePO(driver);
			}
			return tvPage;
			
		case "MyWishlistPage":
			if (myWishlistPage == null) {
				return new MyWishlistPagePO(driver);
			}
			return myWishlistPage;
			
		case "ShareWishlistPage":
			if (shareWishlistPage == null) {
				return new ShareWishlistPagePO(driver);
			}
			return shareWishlistPage;
			
		case "BillingPage":
			if (billingPage == null) {
				return new BillingPagePO(driver);
			}
			return billingPage;
			
		case "SuccessOrderPage":
			if (successOrderPage == null) {
				return new SuccessOrderPagePO(driver);
			}
			return successOrderPage;
		default:
			return null;
		}
	}
}
