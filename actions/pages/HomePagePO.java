package pages;

import liveguru.HomePageUI;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;

public class HomePagePO extends AbstractPage{
	WebDriver driver;
	
	public HomePagePO(WebDriver _driver) {
		driver = _driver;
	}
	
	public void clickOnDynamicMenuLink(String text) {
		waitForControlVisible(driver, HomePageUI.DYNAMIC_MENU_LINK, text);
		clickToElement(driver, HomePageUI.DYNAMIC_MENU_LINK, text);
	}
	
	public String getCostOfMobile(String mobileName) {
		waitForControlVisible(driver, HomePageUI.MOBILE_PRICE, mobileName);
		return getTextElement(driver, HomePageUI.MOBILE_PRICE, mobileName);
	}
	
	public DetailProductPagePO clickOnDynamicMobileLink(String mobileName) {
		waitForControlVisible(driver, HomePageUI.DYNAMIC_MOBILE_LINK, mobileName);
		clickToElement(driver, HomePageUI.DYNAMIC_MOBILE_LINK, mobileName);
		return PageManagerDriver.getDetailProductPage(driver);
	}
}
