package liveguru.pageobjects;

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

	public void updateQuantity(String number) {
		clickToElement(driver, CheckoutPageUI.QUANTITY_TXT);
		sendkeyToElement(driver, CheckoutPageUI.QUANTITY_TXT, number);
		clickToElement(driver, CheckoutPageUI.UPDATE_BTN);
	}

	public boolean verifyErrorMessageDisplayed() {
		return isControlDisplayed(driver, CheckoutPageUI.ERROR_MSG_QUANTITY);
	}

	public String getErrorMessage() {
		return getTextElement(driver, CheckoutPageUI.ERROR_MSG_QUANTITY);
	}

	public EmptyCartPagePO clickToEmptyCart() {
		clickToElement(driver, CheckoutPageUI.EMPTY_CART_BTN);
		return LiveGuruPageManagerDriver.getEmptyCartPagePO(driver);
	}

	public void selectCountryToShip(String countryText) {
		waitForControlVisible(driver, CheckoutPageUI.COUNTRY_DROPDOWN);
		selectItemInDropdown(driver, CheckoutPageUI.COUNTRY_DROPDOWN, countryText);
	}

	public void selectState(String stateText) {
		selectItemInDropdown(driver, CheckoutPageUI.REGION_DROPDOWN, stateText);
	}

	public void inputZipCode(String zipText) {
		sendkeyToElement(driver, CheckoutPageUI.ZIP_CODE_INPUT, zipText);
	}

	public boolean verifyShippingCostIsGenerated() {
		waitForControlVisible(driver, CheckoutPageUI.SHIPPING_FORM);
		return isControlDisplayed(driver, CheckoutPageUI.SHIPPING_FORM);
	}

	public void addShippingCost() {
		clickToElement(driver, CheckoutPageUI.CHECKBOX_SHIPPING_COST);
		clickToDynamicButton(driver, "Update Total");
	}
	
	public String getTotalPrice() {
		waitForControlVisible(driver, CheckoutPageUI.SHIPPING_COST_TOTAL);
		return getTextElement(driver, CheckoutPageUI.TOTAL_COST);
	}
	
	public String getProdPrice() {
		return getTextElement(driver, CheckoutPageUI.PRODUCT_PRICE);
	}
}
