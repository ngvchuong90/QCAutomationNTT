package Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Constants.Constant;

public class HomePage extends GeneralPage{

	// LOCATORS
	private final By signInLink = By.xpath("//div[@class='header_user_info']/a[@class='login']");
	private String productNameDyn = "//a[@class='product-name' and @title='{0}']";
	
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

}
	