package pages;

import org.openqa.selenium.WebDriver;

public class PageManagerDriver {

	private static HomePagePO homepage;
	private static DetailProductPagePO detailProductPage;

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
}
