package pages;

import org.openqa.selenium.WebDriver;

public class PageManagerDriver {

	private static HomePagePO homepage;
	private static DetailProductPagePO detailProductPage;
	private static MobilePagePO mobilePage;
	private static CheckoutPagePO checkoutPage;

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
}
