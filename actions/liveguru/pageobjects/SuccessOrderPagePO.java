package liveguru.pageobjects;

import liveguru.SuccessOrderPageUI;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;

public class SuccessOrderPagePO extends AbstractPage {
	WebDriver driver;

	public SuccessOrderPagePO(WebDriver _driver) {
		driver = _driver;
	}

	public String getOrderMessage() {
		waitForControlVisible(driver, SuccessOrderPageUI.SUCCESS_MSG);
		return getTextElement(driver, SuccessOrderPageUI.SUCCESS_MSG);
	}

	public String getOrderNumber() {
		return getTextElement(driver, SuccessOrderPageUI.ORDER_NUMBER);
	}
}
