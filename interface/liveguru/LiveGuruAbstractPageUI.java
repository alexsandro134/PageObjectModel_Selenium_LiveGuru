package liveguru;

public class LiveGuruAbstractPageUI {
	public static final String DYNAMIC_MENU_LINK = "//nav[@id='nav']//a[text() = '%s']";
	public static final String ACTION_LINK = "//h2[a[text()='%s']]/following-sibling::div[@class='actions']//a[@class='%s']";
	public static final String DYNAMIC_FOOTER_LINK = "//div[@class='footer']//a[text()='%s']";
	public static final String DYNAMIC_BUTTON = "//button[@title='%s']";
	public static final String SUCCESS_MSG = "//li[@class='success-msg']//span";
	public static final String DYNAMIC_INPUT_INFORMATION = "//input[@id='%s']";
}
