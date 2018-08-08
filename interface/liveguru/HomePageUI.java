package liveguru;

public class HomePageUI {
	public static final String DYNAMIC_MENU_LINK = "//nav[@id='nav']//a[text() = '%s']";
	public static final String MOBILE_PRICE = "//h2[a[text()='%s']]/following-sibling::div//span[contains(@id,'product-price')]";
	public static final String DYNAMIC_MOBILE_LINK = "//a[text()='%s']";
}
