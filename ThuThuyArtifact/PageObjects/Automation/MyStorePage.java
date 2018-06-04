package Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Constants.Constant;

public class MyStorePage extends GeneralPage {
	// LOCATORS
	private final By categoriesMenuHoverForce = By.xpath("//li[@class='sfHoverForce']/a");
	
	// ELEMENTS
	public WebElement getCategoriesMenuHoverForce() {
		return Constant.WEBDRIVER.findElement(categoriesMenuHoverForce);
	}
	
	// METHODS
	public String getCategoriesTitleOpen() {
		return this.getCategoriesMenuHoverForce().getText();
	}
}
