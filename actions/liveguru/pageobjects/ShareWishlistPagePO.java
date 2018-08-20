package liveguru.pageobjects;

import liveguru.ShareWishlistPageUI;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;

public class ShareWishlistPagePO extends AbstractPage {
	WebDriver driver;

	public ShareWishlistPagePO(WebDriver _driver) {
		driver = _driver;
	}
	
	public void inputToTextArea(String idArea, String text) {
		sendkeyToElement(driver, text, ShareWishlistPageUI.DYNAMIC_TEXT_AREA, idArea);
	}
}
