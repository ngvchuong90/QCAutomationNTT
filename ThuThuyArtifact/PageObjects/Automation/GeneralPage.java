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
	
	// ELEMENTS
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
}
