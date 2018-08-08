package pages;

import liveguru.DetailProductUI;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;

public class DetailProductPagePO extends AbstractPage {
	WebDriver driver;

	public DetailProductPagePO(WebDriver _driver) {
		driver = _driver;
	}

	public String getProductPrice() {
		waitForControlVisible(driver, DetailProductUI.PRODUCT_PRICE);
		String price = getTextElement(driver, DetailProductUI.PRODUCT_PRICE);
		return price;
	}
	
	public String getProductName() {
		waitForControlVisible(driver, DetailProductUI.PRODUCT_NAME);
		String prodName = getTextElement(driver, DetailProductUI.PRODUCT_NAME);
		return prodName;
	}
}
