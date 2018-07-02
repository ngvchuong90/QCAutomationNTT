package Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Constants.Constant;

public class GeneralPage extends generalActions{
	
	// LOCATORS
	private final By txtSearchBox = By.xpath("//input[@id='search_query_top']");
	private final By txtSearchButton = By.xpath("//button[@name='submit_search']");
	private final By navigationPageSearchLabel = By.xpath("// span[@class='navigation_page' and text()='Search']");
	private final By accountInfoLink = By.xpath("//a[@class='account']");
	private final By loGo = By.xpath("//div[@id='header_logo']");
	private final By signInLink = By.xpath("//div[@class='header_user_info']/a[@class='login']");
	private final By signOutLink = By.xpath("//a[@class='logout']");
	private final By contactLink = By.xpath("//div[@id='contact-link']");
	private final By catTitleWomen = By.xpath("//a[@title='Women']");
	private final By catTitleDresses = By.xpath("//ul[contains(@class,'submenu-container')]/preceding-sibling::a[@title='Dresses']");
	private final By catTitleTShirts = By.xpath("//ul/li[3]/a[@title='T-shirts']");
	private final By textQuantityWanted = By.xpath("//input[@id='quantity_wanted']");
	private final By selectSize = By.xpath("//select[@id='group_1']");
	private String choseColorDyn = "//a[contains(@id,'color') and @name='{0}']";
	private final By productTitleLabel = By.xpath("//span[@id='layer_cart_product_title']");
	private final By productAttributeLabel = By.xpath("//span[@id='layer_cart_product_attributes']");
	private final By productQuantityLabel = By.xpath("//span[@id='layer_cart_product_quantity']");
	
	// ELEMENTS
	public WebElement getProductQuantityLabel() {
		return Constant.WEBDRIVER.findElement(productQuantityLabel);
	}
	
	public WebElement getProductAttributeLabel() {
		return Constant.WEBDRIVER.findElement(productAttributeLabel);
	}
	
	public WebElement getProductTitleLabel() {
		return Constant.WEBDRIVER.findElement(productTitleLabel);
	}
	
	public WebElement getSelectSize() {
		return Constant.WEBDRIVER.findElement(selectSize);
	}
	
	public WebElement getTextQuantityWanted() {
		return Constant.WEBDRIVER.findElement(textQuantityWanted);
	}
	
	public WebElement getTxtSearchBox() {
		return Constant.WEBDRIVER.findElement(txtSearchBox);
	}
	
	public WebElement getTxtSearchButtton() {
		return Constant.WEBDRIVER.findElement(txtSearchButton);
	}
	
	public WebElement getNavigationPageSearchLabel() {
		return Constant.WEBDRIVER.findElement(navigationPageSearchLabel);
	}
	
	public WebElement getAccountInfoLink() {
		return Constant.WEBDRIVER.findElement(accountInfoLink);
	}
	
	public WebElement getloGo() {
		return Constant.WEBDRIVER.findElement(loGo);
	}
	
	public WebElement getSignInLink() {
		return Constant.WEBDRIVER.findElement(signInLink);
	}
	
	public WebElement getSignOutLink() {
		return Constant.WEBDRIVER.findElement(signOutLink);
	}
	
	public WebElement getContactLink() {
		return Constant.WEBDRIVER.findElement(contactLink);
	}
	
	public WebElement getCatTitleWomen() {
		return Constant.WEBDRIVER.findElement(catTitleWomen);
	}
	
	public WebElement getCatTitleDresses() {
		return Constant.WEBDRIVER.findElement(catTitleDresses);
	}
	
	public WebElement getCatTitleTShirts() {
		return Constant.WEBDRIVER.findElement(catTitleTShirts);
	}
	
	// METHODS
	public SearchPage searchValue(String value) {
		this.getTxtSearchBox().sendKeys(value);
		this.getTxtSearchButtton().click();
		this.waitForControlStable(this.getNavigationPageSearchLabel());
		return new SearchPage();
	}
	
	public MyAccountPage goToMyAccountPage() {
		this.getAccountInfoLink().click();
		return new MyAccountPage();
	}
	
	public HomePage goToHomePage() {
		this.getloGo().click();
		return new HomePage();
	}
	
	public void logOut() {
		this.getSignOutLink().click();
	}
	
	public MyStorePage goToCategories(String page) {
		if(page.equalsIgnoreCase("women")) {
			this.getCatTitleWomen().click();
		} else if(page.equalsIgnoreCase("dresses")) {
			this.getCatTitleDresses().click();
		} else if(page.equalsIgnoreCase("t-shirts")) {
			this.getCatTitleTShirts().click();
		}
		return new MyStorePage();
	}
	
	public ContactUsPage goToContactUsPage() {
		this.getContactLink().click();
		return new ContactUsPage();
	}
	
	public DetailsProductPage_layerCart choseCartInformation(String quantity, String size, String color) throws InterruptedException {
		this.getTextQuantityWanted().clear();
		this.getTextQuantityWanted().sendKeys(quantity);
		this.getSelectSize().sendKeys(size);
		this.dynamicXpath(color, choseColorDyn).click();
		new DetailsProductPage().addProducToCart();
		Thread.sleep(2000);
		return new DetailsProductPage_layerCart();
	}
	
	public String getProductInfo() {
		return this.getProductTitleLabel().getText() + " " + this.getProductAttributeLabel().getText() + " " + this.getProductQuantityLabel().getText(); 
	}
}
