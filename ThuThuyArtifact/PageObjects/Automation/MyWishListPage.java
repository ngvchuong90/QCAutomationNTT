package Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Constants.Constant;

public class MyWishListPage {

	// LOCATORS
	private final By wishListFirstProduct = By.xpath("//tr[contains(@id,'wishlist')]");

	// ELEMENTS
	public WebElement getWishListFirstProduct() {
		return Constant.WEBDRIVER.findElement(wishListFirstProduct);
	}

	// METHODS

}
