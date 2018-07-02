package Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Constants.Constant;

public class OrderConfirmationPage extends GeneralPage {
	// LOCATORS
	private final By alertSuccessLabel = By.xpath("//p[@class='alert alert-success']");
	private final By orderCompletelabel = By.xpath("//p[@class='cheque-indent']");

	// ELEMENTS
	public WebElement getOrderCompletelabel() {
		return Constant.WEBDRIVER.findElement(orderCompletelabel);
	}

	public WebElement getAlertSuccessLabel() {
		return Constant.WEBDRIVER.findElement(alertSuccessLabel);
	}

	// METHODS
	public String getSuccessMessage() {
		boolean check;
		try {
			check = this.getAlertSuccessLabel().isDisplayed();
		} catch (Exception e) {
			check = false;
		}

		if (check == true) {
			return this.getAlertSuccessLabel().getText();
		} else {
			return this.getOrderCompletelabel().getText();
		}
	}
}
