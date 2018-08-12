package liveguru.pageobjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import liveguru.EmptyCartPageUI;

public class EmptyCartPagePO extends AbstractPage {
	WebDriver driver;

	public EmptyCartPagePO(WebDriver _driver) {
		driver = _driver;
	}

	public boolean verifyEmptyMessageDisplayed() {
		return isControlDisplayed(driver, EmptyCartPageUI.EMPTY_MSG);
	}

	public String getEmptyMsg() {
		return getTextElement(driver, EmptyCartPageUI.EMPTY_MSG);
	}
}
