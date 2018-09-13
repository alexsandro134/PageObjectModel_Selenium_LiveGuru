package liveguru.pageobjects;

import liveguru.MyAccountPageUI;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;

public class MyAccountPagePO extends AbstractPage {
	WebDriver driver;

	public MyAccountPagePO(WebDriver _driver) {
		driver = _driver;
	}

	public CreateAccountPagePO clickToCreateNewAccount() {
		clickToElement(driver, MyAccountPageUI.CREATE_ACCOUNT_BTN);
		return (CreateAccountPagePO) LiveGuruPageManagerDriver.getInstance(driver, "CreateAccountPage");
	}

	public void inputInfoToLogin(String liveguruUsername, String idXpath) {
		sendkeyToElement(driver, liveguruUsername, MyAccountPageUI.INPUT_INFO_LOGIN, idXpath);
	}
	
	
}
