package Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Constants.Constant;

public class MyAccountPage extends GeneralPage{

	// LOCATORS
	private final By infoAccountLabel = By.xpath("//p[@class='info-account']");
	private final By wishListLink = By.xpath("//li[@class='lnk_wishlist']");
	
	// ELEMENTS
	public WebElement getInfoAccountLabel() {
		return Constant.WEBDRIVER.findElement(infoAccountLabel);
	}
	
	public WebElement getWishListLink() {
		return Constant.WEBDRIVER.findElement(wishListLink);
	}

	// METHODS
	public String getkWelcomeMessage() {
		String welcomeMess = this.getInfoAccountLabel().getText();
		return welcomeMess;
	}
	
	public MyWishListPage goToMyWishListPage() {
		this.getWishListLink().click();
		return new MyWishListPage();
	}
}
