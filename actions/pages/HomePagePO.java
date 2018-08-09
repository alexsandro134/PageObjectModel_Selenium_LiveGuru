package pages;

import liveguru.HomePageUI;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;

public class HomePagePO extends AbstractPage{
	WebDriver driver;
	
	public HomePagePO(WebDriver _driver) {
		driver = _driver;
	}
	
	public MobilePagePO clickOnDynamicMenuLink(String text) {
		waitForControlVisible(driver, HomePageUI.DYNAMIC_MENU_LINK, text);
		clickToElement(driver, HomePageUI.DYNAMIC_MENU_LINK, text);
		return PageManagerDriver.getMobilePage(driver);
	}
}
