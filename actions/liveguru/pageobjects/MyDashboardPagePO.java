package liveguru.pageobjects;

import liveguru.MyDashboardPageUI;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;

public class MyDashboardPagePO extends AbstractPage {
	WebDriver driver;

	public MyDashboardPagePO(WebDriver _driver) {
		driver = _driver;
	}

	public boolean isUserLoginSuccessful() {
		return isControlDisplayed(driver, MyDashboardPageUI.MYDASHBOARD_TEXT);
	}
}
