package liveguru;

public class CheckoutPageUI {
	public static final String COUPON_CODE = "//input[@id='coupon_code']";
	public static final String APPLY_BUTTON = "//button[@value='Apply']";
	public static final String DISCOUNT_GENERATED = "//td[contains(text(),'%s')]/following-sibling::td/span";
	public static final String QUANTITY_TXT = "//input[@title='Qty']";
	public static final String UPDATE_BTN = "//button[span[span[text()='Update']]]";
	public static final String ERROR_MSG_QUANTITY = "//p[@class='item-msg error']";
	public static final String EMPTY_CART_BTN = "//button[span[span[text()='Empty Cart']]]";
}
