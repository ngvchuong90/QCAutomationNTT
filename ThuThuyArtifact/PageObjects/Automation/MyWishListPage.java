package Automation;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import Constants.Constant;

public class MyWishListPage extends GeneralPage {

	// LOCATORS
	private final By wishListFirstProduct = By.xpath("//tr[contains(@id,'wishlist')]");
	private final By pageHeadingLabel = By.xpath("//h1[contains(@class,'page-heading')]");
	private final By txtwishlistName = By.xpath("//input[@id='name']");
	private final By btnSubmitWishlist = By.xpath("//button[@id='submitWishlist']");
	private final By wishlistHistory = By.xpath("//div[@id='block-history']");
	private String removeIconDyn = "//a[contains(text(),'{0}')]/ancestor::tr//i[@class='icon-remove']";
	private final By btnBackToYourAccount = By
			.xpath("//a[@class='btn btn-default button button-small' and contains(@href,'my-account')]");
	private final By btnBackHome = By.xpath(
			"//a[@class='btn btn-default button button-small' and @href='http://automationpractice.com/']/span/i[@class='icon-chevron-left']");

	// ELEMENTS
	public WebElement getBtnBackHome() {
		return Constant.WEBDRIVER.findElement(btnBackHome);
	}

	public WebElement getBtnBackToYourAccount() {
		return Constant.WEBDRIVER.findElement(btnBackToYourAccount);
	}

	public WebElement getWishlistHistory() {
		return Constant.WEBDRIVER.findElement(wishlistHistory);
	}

	public WebElement getBtnSubmitWishlist() {
		return Constant.WEBDRIVER.findElement(btnSubmitWishlist);
	}

	public WebElement getTxtwishlistName() {
		return Constant.WEBDRIVER.findElement(txtwishlistName);
	}

	public WebElement getWishListFirstProduct() {
		return Constant.WEBDRIVER.findElement(wishListFirstProduct);
	}

	public WebElement getPageHeadingLabel() {
		return Constant.WEBDRIVER.findElement(pageHeadingLabel);
	}

	// METHODS
	public String getPageHeading() {
		return this.getPageHeadingLabel().getText();
	}

	public MyWishListPage submitNewWishlist(String wishListname) {
		this.getTxtwishlistName().sendKeys(wishListname);
		this.getBtnSubmitWishlist().click();
		return this;
	}

	public MyWishListPage removeWishList(String wishListName) throws InterruptedException {
		this.dynamicXpath(wishListName, removeIconDyn).click();
		Thread.sleep(1000);
		try {
			Alert alert = Constant.WEBDRIVER.switchTo().alert();
			alert.accept();
		} catch (Exception e) {
			Actions action = new Actions(Constant.WEBDRIVER);
			action.sendKeys(Keys.ENTER).build().perform();
		}
		Thread.sleep(2000);
		return this;
	}

	public boolean checkWishListDisplay(String wishListName) {
		return this.dynamicXpath(wishListName, removeIconDyn).isDisplayed();
	}

	public MyWishListPage removeAllWishList() throws InterruptedException {
		try {
			while (this.dynamicXpath("", removeIconDyn).isDisplayed() == true) {
				this.removeWishList("");
			}
		} catch (Exception e) {

		}
		return this;
	}

	public MyAccountPage goBackToYourAccountPage() {
		this.getBtnBackToYourAccount().click();
		return new MyAccountPage();
	}

	public HomePage goHomeByClickBackHome() {
		this.getBtnBackHome().click();
		return new HomePage();
	}
}
