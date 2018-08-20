package liveguru.pageobjects;

import liveguru.BillingPageUI;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;

public class BillingPagePO extends AbstractPage {
	WebDriver driver;

	public BillingPagePO(WebDriver _driver) {
		driver = _driver;
	}

	public void selectStateList(String valueDropdown) {
		selectItemInDropdown(driver, BillingPageUI.STATE_DROPDOWN, valueDropdown);
	}

	public void selectCountryList(String valueDropdown) {
		selectItemInDropdown(driver, BillingPageUI.COUNTRY_DROPDOWN, valueDropdown);
	}

	public void clickContinueInShipping(String idDiv) {
		waitForControlVisible(driver, BillingPageUI.CONTINE_BUTTON, idDiv);
		clickToElement(driver, BillingPageUI.CONTINE_BUTTON, idDiv);
	}

	public void selectOrderType(String orderType) {
		waitForControlVisible(driver, BillingPageUI.ORDER_TYPE, orderType);
		clickToElement(driver, BillingPageUI.ORDER_TYPE, orderType);
	}
}
