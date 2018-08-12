package liveguru.pageobjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import liveguru.ComparePageUI;

public class ComparePagePO extends AbstractPage {
	WebDriver driver;

	public ComparePagePO(WebDriver _driver) {
		driver = _driver;
	}

	public String getCompareTitle() {
		return getTextElement(driver, ComparePageUI.TITLE);
	}

	public int getNumberOfCompare() {
		return getSizeElement(driver, ComparePageUI.LIST_PROD_NAME);
	}

	public void closeComparePage() {
		driver.close();
	}

	public boolean isPhoneComparedDisplayed(String mobileName) {
		return isControlDisplayed(driver, ComparePageUI.PHONE_COMPARE, mobileName);
	}
}
