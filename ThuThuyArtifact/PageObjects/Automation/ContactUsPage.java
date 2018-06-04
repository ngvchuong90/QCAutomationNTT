package Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Constants.Constant;

public class ContactUsPage extends GeneralPage {

	// LOCATORS
	private final By pageHeadingLabel = By.xpath("//h1[contains(@class,'page-heading')]");
	private final By subjectHeadingSelection = By.xpath("//select[@id='id_contact']");
	private final By txtEmailAddress = By.xpath("//input[@id='email']");
	private final By txtOrderReference = By.xpath("//input[@id='id_order']");
	private final By fileUpload = By.xpath("//input[@id='fileUpload']");
	private final By btnSend = By.xpath("//button[@id='submitMessage']");
	private final By btnChooseFile = By.xpath("//div[@id='uniform-fileUpload']/span[@class='action']");
	private final By txtMessageContent = By.xpath("//textarea[@id='message']");
	private final By errorMessageLabel = By.xpath("//div[@class='alert alert-danger']//li");
	private final By alertSuccessLabel = By.xpath("//p[@class='alert alert-success']");
	
	
	// ELEMENTS
	public WebElement getPageHeadingLabel() {
		return Constant.WEBDRIVER.findElement(pageHeadingLabel);
	}
	
	public WebElement getSubjectHeadingSelection() {
		return Constant.WEBDRIVER.findElement(subjectHeadingSelection);
	}
	
	public WebElement getTxtEmailAddress() {
		return Constant.WEBDRIVER.findElement(txtEmailAddress);
	}
	
	public WebElement getTxtOrderReference() {
		return Constant.WEBDRIVER.findElement(txtOrderReference);
	}
	
	public WebElement getFileUpload() {
		return Constant.WEBDRIVER.findElement(fileUpload);
	}
	
	public WebElement getBtnSend() {
		return Constant.WEBDRIVER.findElement(btnSend);
	}
	
	public WebElement getBtnChooseFile() {
		return Constant.WEBDRIVER.findElement(btnChooseFile);
	}
	
	public WebElement getTxtMessageContent() {
		return Constant.WEBDRIVER.findElement(txtMessageContent);
	}
	
	public WebElement getErrorMessageLabel() {
		return Constant.WEBDRIVER.findElement(errorMessageLabel);
	}
	
	public WebElement getAlertSuccessLabel() {
		return Constant.WEBDRIVER.findElement(alertSuccessLabel);
	}
	
	// METHODS
	
}
