package Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Constants.Constant;

public class MyAccountPage extends GeneralPage{

	// LOCATORS
	private final By infoWelcomeMessLabel = By.xpath("//p[@class='info-account']");
	private final By wishListLink = By.xpath("//li[@class='lnk_wishlist']");
	private final By pageHeadingLabel = By.xpath("//h1[@class='page-heading']");
	private final By btnOderHistoryAndDetails = By.xpath("//a[@title='Orders']");
	private final By btnMyCreditSlips = By.xpath("//a[@title='Credit slips']");
	private final By btnMyAddress = By.xpath("//a[@title='Addresses']");
	private final By btnMyPersonalInformation = By.xpath("//a[@title='Information']");
	private final By btnMyWishlists = By.xpath("//a[@title='My wishlists']");
	private final By btnHome = By.xpath("//a[@title='Home']");
	
	// ELEMENTS
	public WebElement getBtnHome() {
		return Constant.WEBDRIVER.findElement(btnHome);
	}
	
	public WebElement getBtnMyWishlists() {
		return Constant.WEBDRIVER.findElement(btnMyWishlists);
	}
	
	public WebElement getBtnMyPersonalInformation() {
		return Constant.WEBDRIVER.findElement(btnMyPersonalInformation);
	}
	
	public WebElement getBtnMyAddress() {
		return Constant.WEBDRIVER.findElement(btnMyAddress);
	}
	
	public WebElement getBtnMyCreditSlips() {
		return Constant.WEBDRIVER.findElement(btnMyCreditSlips);
	}
	
	public WebElement getBtnOderHistoryAndDetails() {
		return Constant.WEBDRIVER.findElement(btnOderHistoryAndDetails);
	}
	
	public WebElement getPageHeadingLabel() {
		return Constant.WEBDRIVER.findElement(pageHeadingLabel);
	}
	
	public WebElement getInfoWelcomeMessLabel() {
		return Constant.WEBDRIVER.findElement(infoWelcomeMessLabel);
	}
	
	public WebElement getWishListLink() {
		return Constant.WEBDRIVER.findElement(wishListLink);
	}

	// METHODS
	public String getkWelcomeMessage() {
		String welcomeMess = this.getInfoWelcomeMessLabel().getText();
		return welcomeMess;
	}
	
	public MyWishListPage goToMyWishListPage() {
		this.getWishListLink().click();
		return new MyWishListPage();
	}
	
	public String getPageHeading() {
		return this.getPageHeadingLabel().getText();		
	}
	
	public OrderHistoryPage goToOrderHistoryPage() {
		this.getBtnOderHistoryAndDetails().click();
		return new OrderHistoryPage();
	}
	
	public CreditSlipsPage goToCreditSlipsPage() {
		this.getBtnMyCreditSlips().click();
		return new CreditSlipsPage();
	}
	
	public MyAddressPage goToMyAddressPage() {
		this.getBtnMyAddress().click();
		return new MyAddressPage();
	}
	
	public PersonalInformationPage goToPersonalInformationPage() {
		this.getBtnMyPersonalInformation().click();
		return new PersonalInformationPage();
	}
	
	public HomePage goToHomePageByClickHomeButton() {
		this.getBtnHome().click();
		return new HomePage();
	}
}
