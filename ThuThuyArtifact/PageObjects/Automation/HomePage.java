package Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import Constants.Constant;

public class HomePage extends GeneralPage {

	// LOCATORS
	private final By signInLink = By.xpath("//div[@class='header_user_info']/a[@class='login']");
	private String productNameDyn = "//a[@class='product-name' and @title='{0}']";
	private String addToCartProductNameDyn = "//a[@class='product-name' and @title='{0}']/ancestor::div[@class='right-block']//a[@title='Add to cart']";
	private String quickViewDyn = "//a[@class='product_img_link' and @title='{0}']/ancestor::div[@class='product-image-container']//a[@class='quick-view']";
	private String productMoreDetailDyn = "//a[@class='product-name' and @title='{0}']/ancestor::div[@class='right-block']//a[@title='View']";
	
	// ELEMENTS
	public WebElement getSignInLink() {
		return Constant.WEBDRIVER.findElement(signInLink);
	}

	// METHODS
	public HomePage open() {
		Constant.WEBDRIVER.navigate().to(Constant.homePage_URL);
		return this;
	}

	public LoginPage goToLoginPage() {
		this.getSignInLink().click();
		return new LoginPage();
	}

	public DetailsProductPage selectProduct(String productName) {
		this.dynamicXpath(productName, productNameDyn).click();
		return new DetailsProductPage();
	}
	
	public DetailsProductPage selectMoreDetailProduct(String productName) {
		Actions action = new Actions(Constant.WEBDRIVER);
		action.moveToElement(this.dynamicXpath(productName, productNameDyn)).build().perform();
		;
		this.waitForControlStable(this.dynamicXpath(productName, productMoreDetailDyn));
		this.dynamicXpath(productName, productMoreDetailDyn).click();
		return new DetailsProductPage();
	}
	
	public DetailsProductPage_layerCart selectAddToCartProduct(String productName) {
		Actions action = new Actions(Constant.WEBDRIVER);
		action.moveToElement(this.dynamicXpath(productName, productNameDyn)).build().perform();
		;
		this.waitForControlStable(this.dynamicXpath(productName, addToCartProductNameDyn));
		this.dynamicXpath(productName, quickViewDyn).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new DetailsProductPage_layerCart();
	}
	
	public DetailsProductPage_QuickView quickViewProduct(String productName) {
		Actions action = new Actions(Constant.WEBDRIVER);
		action.moveToElement(this.dynamicXpath(productName, productNameDyn)).build().perform();
		this.waitForControlStable(this.dynamicXpath(productName, quickViewDyn));
		this.dynamicXpath(productName, quickViewDyn).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new DetailsProductPage_QuickView();
	}

	public DetailsProductPage addProductToCart(String productName) {
		this.dynamicXpath(productName, productNameDyn).click();
		return new DetailsProductPage();
	}

}
