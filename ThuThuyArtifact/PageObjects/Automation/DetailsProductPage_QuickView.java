package Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Constants.Constant;

public class DetailsProductPage_QuickView extends GeneralPage{
	// LOCATORS
	private final By addToCartButton = By.xpath("//button[@name='Submit']");
	private final By btnAddToWishlist = By.xpath("//a[@id='wishlist_button']");
	private final By btnCloseBoxError = By.xpath("//a[@title='Close']");
	private final By addedWishListLabel = By.xpath("//p[text()='Added to your wishlist.']");
	
	// ELEMENTS
	public WebElement getAddedWishListLabel() {
		return Constant.WEBDRIVER.findElement(addedWishListLabel);
	}
	
	public WebElement getBtnAddToWishlist() {
		return Constant.WEBDRIVER.findElement(btnAddToWishlist);
	}
	
	public WebElement getAddToCartButton() {
		return Constant.WEBDRIVER.findElement(addToCartButton);
	}
	
	public WebElement getBtnCloseBoxError() {
		return Constant.WEBDRIVER.findElement(btnCloseBoxError);
	}
	
	// METHODS
	public DetailsProductPage_layerCart addProducToCart() {
		Constant.WEBDRIVER.switchTo().frame(4);
		this.getAddToCartButton().click();
		this.waitForControlStable(new DetailsProductPage_layerCart().getBtnCloseCartDialog());
		Constant.WEBDRIVER.switchTo().defaultContent();
		return new DetailsProductPage_layerCart();
	}
	
	public DetailsProductPage_QuickView addProductToWishList() throws InterruptedException {
		Constant.WEBDRIVER.switchTo().frame(4);
		Constant.WEBDRIVER.findElement(btnAddToWishlist).click();
		Constant.WEBDRIVER.switchTo().defaultContent();
		Thread.sleep(1000);
		return this;
	}
	
	public DetailsProductPage_QuickView closeAddedWishListLayout() {
		System.out.println("closeAddedWishListLayout");
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
		return new DetailsProductPage_QuickView();
	}
	
	public HomePage closeQuickReviewDialog() {
		System.out.println("closeQuickReviewDialog");
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
		return new HomePage();
	}
	
	public boolean checkAddedWishListLabelDisplay() {
		Constant.WEBDRIVER.switchTo().frame(4);
		return Constant.WEBDRIVER.findElement(addedWishListLabel).isDisplayed();
	}
}
