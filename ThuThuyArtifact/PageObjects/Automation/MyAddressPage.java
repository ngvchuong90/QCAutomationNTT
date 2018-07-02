package Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Constants.Constant;

public class MyAddressPage extends GeneralPage {
	// LOCATORS
	private final By pageHeadingLabel = By.xpath("//h1[contains(@class,'page-heading')]");

	// ELEMENTS
	public WebElement getPageHeadingLabel() {
		return Constant.WEBDRIVER.findElement(pageHeadingLabel);
	}

	// METHODS
	public String getPageHeading() {
		return this.getPageHeadingLabel().getText();
	}
}
