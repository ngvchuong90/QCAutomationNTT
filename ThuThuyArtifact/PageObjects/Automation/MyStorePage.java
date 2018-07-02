package Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Constants.Constant;

public class MyStorePage extends GeneralPage {
	// LOCATORS
	private final By catNameLabel = By.xpath("//span[@class='cat-name']");
	
	// ELEMENTS
	public WebElement getCatNameLabel() {
		return Constant.WEBDRIVER.findElement(catNameLabel);
	}
	
	// METHODS
	public String getCategoriesTitleOpen() {
		return this.getCatNameLabel().getText();
	}
}
