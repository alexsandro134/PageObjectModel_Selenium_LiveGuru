package pages;

import liveguru.CheckoutPageUI;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;

public class CheckoutPagePO extends AbstractPage {
	WebDriver driver;

	public CheckoutPagePO(WebDriver _driver) {
		driver = _driver;
	}

	public void applyCouponCode(String couponText) {
		sendkeyToElement(driver, CheckoutPageUI.COUPON_CODE, couponText);
		clickToElement(driver, CheckoutPageUI.APPLY_BUTTON);
	}

	public boolean discountGenerated(String couponText) {
		return isControlDisplayed(driver, CheckoutPageUI.DISCOUNT_GENERATED, couponText.toUpperCase());
	}
}
