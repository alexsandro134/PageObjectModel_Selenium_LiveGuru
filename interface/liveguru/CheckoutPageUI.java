package liveguru;

public class CheckoutPageUI {
	public static final String COUPON_CODE = "//input[@id='coupon_code']";
	public static final String APPLY_BUTTON = "//button[@value='Apply']";
	public static final String DISCOUNT_GENERATED = "//td[contains(text(),'%s')]/following-sibling::td/span";
	public static final String QUANTITY_TXT = "//input[@title='Qty']";
	public static final String UPDATE_BTN = "//button[span[span[text()='Update']]]";
	public static final String ERROR_MSG_QUANTITY = "//p[@class='item-msg error']";
	public static final String EMPTY_CART_BTN = "//button[span[span[text()='Empty Cart']]]";
	public static final String COUNTRY_DROPDOWN = "//select[@id='country']";
	public static final String REGION_DROPDOWN = "//select[@id='region_id']";
	public static final String ZIP_CODE_INPUT = "//input[@id='postcode']";
	public static final String SHIPPING_FORM = "//form[@id='co-shipping-method-form']";
	public static final String CHECKBOX_SHIPPING_COST = "//form[@id='co-shipping-method-form']//input[@type='radio']";
	public static final String SHIPPING_COST_TOTAL = "//table[@id='shopping-cart-totals-table']//td[contains(text(),'Shipping')]";
	public static final String TOTAL_COST = "//table[@id='shopping-cart-totals-table']//strong/span[@class='price']";
	public static final String PRODUCT_PRICE = "//td[@class='product-cart-price']//span[@class='price']";
}
