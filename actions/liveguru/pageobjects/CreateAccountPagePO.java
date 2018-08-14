package liveguru.pageobjects;

import liveguru.CreateAccountPageUI;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;

public class CreateAccountPagePO extends AbstractPage {
	WebDriver driver;

	public CreateAccountPagePO(WebDriver _driver) {
		driver = _driver;
	}
	


	public MyDashboardPagePO clickToRegisterAccount() {
		clickToElement(driver, CreateAccountPageUI.REGISTER_BTN);
		return LiveGuruPageManagerDriver.getMyDashboardPage(driver);
	}
}
