package Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Constants.Constant;

public class DetailsProductPage_layerCart extends GeneralPage{
	// LOCATORS
	
	private final By layerCart = By.xpath("//div[@id='layer_cart']");
	private final By btnContinueShopping = By.xpath("//span[@title='Continue shopping']");
	private final By btnProceedToCheckOut = By.xpath("//a[@title='Proceed to checkout']");
	private final By btnCloseCartDialog = By.xpath("//span[@title='Close window']");
	private final By addToCartSuccessMessLabel = By.xpath("//div[contains(@class,'layer_cart_product')]/h2");
	
	// ELEMENTS
	public WebElement getAddToCartSuccessMessLabel() {
		return Constant.WEBDRIVER.findElement(addToCartSuccessMessLabel);
	}
	
	public WebElement getBtnCloseCartDialog() {
		return Constant.WEBDRIVER.findElement(btnCloseCartDialog);
	}
	
	public WebElement getLayerCart() {
		return Constant.WEBDRIVER.findElement(layerCart);
	}
	
	public WebElement getBtnContinueShopping() {
		return Constant.WEBDRIVER.findElement(btnContinueShopping);
	}
	
	public WebElement getBtnProceedToCheckOut() {
		return Constant.WEBDRIVER.findElement(btnProceedToCheckOut);
	}
	
	public DetailsProductPage continueShopping() {
		this.getBtnContinueShopping().click();
		this.waitForControlNotDisplay(this.getLayerCart());
		return new DetailsProductPage();
	}
	
	public OrderPage proceedToCheckOut() {
		this.getBtnProceedToCheckOut().click();
		this.waitForControlNotDisplay(this.getLayerCart());
		return new OrderPage();
	}
}
