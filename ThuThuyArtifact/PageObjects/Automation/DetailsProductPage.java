package Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Constants.Constant;

public class DetailsProductPage extends GeneralPage {
	// LOCATORS
	private final By productHeaderLabel = By.xpath("//h1[@itemprop='name']");
	private final By btnWishlist = By.xpath("//a[@id='wishlist_button']");
	private final By fancyBoxError = By.xpath("//p[@class='fancybox-error']");
	private final By fancyBoxOverLay = By.xpath("//div[contains(@class,'fancybox-overlay')]");
	private final By btnCloseBoxError = By.xpath("//a[@title='Close']");
	private final By btnAddToCart = By.xpath("//p[@id='add_to_cart']");
	
	// ELEMENTS
	public WebElement getProductHeaderLabel() {
		return Constant.WEBDRIVER.findElement(productHeaderLabel);
	}

	public WebElement getBtnWishlist() {
		return Constant.WEBDRIVER.findElement(btnWishlist);
	}

	public WebElement getFancyBoxError() {
		return Constant.WEBDRIVER.findElement(fancyBoxError);
	}

	public WebElement getFancyBoxOverLay() {
		return Constant.WEBDRIVER.findElement(fancyBoxOverLay);
	}
	
	public WebElement getBtnCloseBoxError() {
		return Constant.WEBDRIVER.findElement(btnCloseBoxError);
	}

	public WebElement getBtnAddToCart() {
		return Constant.WEBDRIVER.findElement(btnAddToCart);
	}
	
	// METHODS
	public String getProductHeader() {
		String headerLabel = this.getProductHeaderLabel().getText();
		return headerLabel;
	}

	public DetailsProductPage addProductToWishList() {
		this.getBtnWishlist().click();
		this.waitForControlStable(this.getBtnCloseBoxError());
		return this;
	}

	public DetailsProductPage closeAddedWishListLayout() {
		System.out.println("zo");
		boolean check = false;
		try {
			while (check == false) {
				Thread.sleep(1000);
				check = this.getBtnCloseBoxError().isDisplayed();
				if(check == true) {
					this.getBtnCloseBoxError().click();
					Thread.sleep(1000);
				}
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this;
	}

}
