package liveguru;

public class MobilePageUI {
	public static final String MOBILE_PRICE = "//h2[a[text()='%s']]/following-sibling::div//span[contains(@id,'product-price')]";
	public static final String DYNAMIC_MOBILE_LINK = "//a[text()='%s']";
	public static final String ADD_CART_BUTTON = "//h2[a[text()='%s']]/following-sibling::div[@class='actions']/button";
}
