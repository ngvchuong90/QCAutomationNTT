package Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Constants.Constant;

public class SearchPage {

	// LOCATORS
	private final By navigationPageSearchLabel = By.xpath("// span[@class='navigation_page' and text()='Search']");
	private final By errorMessageLabel = By.xpath("//p[@class='alert alert-warning']");
	private final By headingCounterLabel = By.xpath("//span[@class='heading-counter']");
	
	// ELEMENTS
	public WebElement getNavigationPageSearchLabel() {
		return Constant.WEBDRIVER.findElement(navigationPageSearchLabel);
	}
	
	public WebElement getErrorMessageLabel() {
		return Constant.WEBDRIVER.findElement(errorMessageLabel);
	}
	
	public WebElement getHeadingCounterLabel() {
		return Constant.WEBDRIVER.findElement(headingCounterLabel);
	}

	// METHODS
	public String getErrorMessage() {
		String errorMess = this.getErrorMessageLabel().getText();
		return errorMess;
	}
	
	
}
