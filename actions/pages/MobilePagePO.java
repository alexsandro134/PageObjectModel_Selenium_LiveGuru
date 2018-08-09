package pages;

import liveguru.MobilePageUI;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;

public class MobilePagePO extends AbstractPage {
	WebDriver driver;

	public MobilePagePO(WebDriver _driver) {
		driver = _driver;
	}

	public String getCostOfMobile(String mobileName) {
		waitForControlVisible(driver, MobilePageUI.MOBILE_PRICE, mobileName);
		return getTextElement(driver, MobilePageUI.MOBILE_PRICE, mobileName);
	}

	public DetailProductPagePO clickOnDynamicMobileLink(String mobileName) {
		waitForControlVisible(driver, MobilePageUI.DYNAMIC_MOBILE_LINK, mobileName);
		clickToElement(driver, MobilePageUI.DYNAMIC_MOBILE_LINK, mobileName);
		return PageManagerDriver.getDetailProductPage(driver);
	}

	public CheckoutPagePO addToCart(String mobileName) {
		waitForControlVisible(driver, MobilePageUI.ADD_CART_BUTTON, mobileName);
		clickToElement(driver, MobilePageUI.ADD_CART_BUTTON, mobileName);
		return PageManagerDriver.getCheckoutPage(driver);
	}

}
