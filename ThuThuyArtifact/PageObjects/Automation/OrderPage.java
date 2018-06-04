package Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Constants.Constant;

public class OrderPage extends GeneralPage {

	// LOCATORS
	private final By cartTitleLabel = By.xpath("// h1[@id='cart_title']");
	private final By currentStepLabel = By.xpath("//li[contains(@class,'step_current')]");
	private final By btnProceedToCheckOut = By
			.xpath("//p[@class='cart_navigation clearfix']//span[contains(text(),'Proceed to checkout')]");
	private final By cbTermsOfService = By.xpath("//input[@id='cgv']");
	private final By continueShoppingLink = By.xpath("//a[contains(@title,'Continue shopping') or contains(@title,'Previous')]");
	
	// ELEMENTS
	public WebElement getCartTitleLabel() {
		return Constant.WEBDRIVER.findElement(cartTitleLabel);
	}

	public WebElement getCurrentStep() {
		return Constant.WEBDRIVER.findElement(currentStepLabel);
	}

	public WebElement getBtnProceedToCheckOut() {
		return Constant.WEBDRIVER.findElement(btnProceedToCheckOut);
	}
	
	public WebElement getCbTermsOfService() {
		return Constant.WEBDRIVER.findElement(cbTermsOfService);
	}
	
	public WebElement getContinueShoppingLink() {
		return Constant.WEBDRIVER.findElement(continueShoppingLink);
	}

	// METHODS
	public boolean checkStepIn(int i) {
		boolean check = false;
		String header = this.getCartTitleLabel().getText();
		if (i == 1) {
			check = header.contains("SUMMARY");
		} else if (i == 2) {
			check = header.contains("SignIn");
		} else if (i == 3) {
			check = header.contains("ADDRESSES");
		} else if (i == 4) {
			check = header.contains("SHIPPING");
		} else if (i == 5) {
			check = header.contains("PAYMENT");
		}

		return check;
	}

	public OrderPage goToNextStep() {
		try {
			this.getBtnProceedToCheckOut().click();
			Thread.sleep(1000);		
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this;
	}
	
	public LoginPage goToNextStepWithOutLogin(String step) {
		try {
			this.getBtnProceedToCheckOut().click();
			Thread.sleep(1000);			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new LoginPage();
	}
	
	public OrderPage acceptTermsOfService() {
		this.getCbTermsOfService().click();
		return this;
	}

	public OrderPage goToPreviousStep() {
		try {
			this.getContinueShoppingLink().click();
			Thread.sleep(1000);		
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this;
	}
	
}
