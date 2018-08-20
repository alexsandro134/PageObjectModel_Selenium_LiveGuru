package liveguru.pageobjects;

import org.openqa.selenium.WebDriver;

public class LiveGuruPageManagerDriver {

	private static HomePagePO homepage;
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

	public static HomePagePO getHomePage(WebDriver driver) {
		if (homepage == null) {
			return new HomePagePO(driver);
		}
		return homepage;
	}

	public static DetailProductPagePO getDetailProductPage(WebDriver driver) {
		if (detailProductPage == null) {
			return new DetailProductPagePO(driver);
		}
		return detailProductPage;
	}

	public static MobilePagePO getMobilePage(WebDriver driver) {
		if (mobilePage == null) {
			return new MobilePagePO(driver);
		}
		return mobilePage;
	}

	public static CheckoutPagePO getCheckoutPage(WebDriver driver) {
		if (checkoutPage == null) {
			return new CheckoutPagePO(driver);
		}
		return checkoutPage;
	}

	public static EmptyCartPagePO getEmptyCartPagePO(WebDriver driver) {
		if (emptyCartPage == null) {
			return new EmptyCartPagePO(driver);
		}
		return emptyCartPage;
	}

	public static ComparePagePO getComparePage(WebDriver driver) {
		if (comparePage == null) {
			return new ComparePagePO(driver);
		}
		return comparePage;
	}

	public static MyAccountPagePO getMyAccountPage(WebDriver driver) {
		if (myAccountPage == null) {
			return new MyAccountPagePO(driver);
		}
		return myAccountPage;
	}

	public static CreateAccountPagePO getCreateAccountPage(WebDriver driver) {
		if (createAccountPage == null) {
			return new CreateAccountPagePO(driver);
		}
		return createAccountPage;
	}

	public static MyDashboardPagePO getMyDashboardPage(WebDriver driver) {
		if (myDashboardPage == null) {
			return new MyDashboardPagePO(driver);
		}
		return myDashboardPage;
	}

	public static TVPagePO getTVPage(WebDriver driver) {
		if (tvPage == null) {
			return new TVPagePO(driver);
		}
		return tvPage;
	}

	public static MyWishlistPagePO getMyWishlistPage(WebDriver driver) {
		if (myWishlistPage == null) {
			return new MyWishlistPagePO(driver);
		}
		return myWishlistPage;
	}

	public static ShareWishlistPagePO getShareWishlistPage(WebDriver driver) {
		if (shareWishlistPage == null) {
			return new ShareWishlistPagePO(driver);
		}
		return shareWishlistPage;
	}

	public static BillingPagePO getBillingPage(WebDriver driver) {
		if (billingPage == null) {
			return new BillingPagePO(driver);
		}
		return billingPage;
	}

	public static SuccessOrderPagePO getSuccessOrderPage(WebDriver driver) {
		if (successOrderPage == null) {
			return new SuccessOrderPagePO(driver);
		}
		return successOrderPage;
	}
}
