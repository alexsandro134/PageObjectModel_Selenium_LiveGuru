package liveguru.pageobjects;

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
		return LiveGuruPageManagerDriver.getDetailProductPage(driver);
	}

	public CheckoutPagePO addToCart(String mobileName) {
		waitForControlVisible(driver, MobilePageUI.ADD_CART_BUTTON, mobileName);
		clickToElement(driver, MobilePageUI.ADD_CART_BUTTON, mobileName);
		return LiveGuruPageManagerDriver.getCheckoutPage(driver);
	}
	
	public ComparePagePO clickToCompare() {
		clickToElement(driver, MobilePageUI.COMPARE_BTN);
		switchWindowByTitle(driver, "Products Comparison List - Magento Commerce");
		return LiveGuruPageManagerDriver.getComparePage(driver);
	}
	
	public int getTotalNumberCompare() {
		return getSizeElement(driver, MobilePageUI.LIST_COMPARE);
	}
}
