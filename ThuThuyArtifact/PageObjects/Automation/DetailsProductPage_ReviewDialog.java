package Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Constants.Constant;

public class DetailsProductPage_ReviewDialog extends GeneralPage{
	// LOCATORS
	private final By txtCommentTitle = By.xpath("//input[@id='comment_title']");
	private final By txtComment = By.xpath("//textarea[@id='content']");
	private final By btnSubmitNewMessage = By.xpath("//button[@id='submitNewMessage']");
	private final By btnCloseMessage = By.xpath("//div[@id='new_comment_form']//a[@class='closefb']");
	private String startCommentDyn = "//div[@class='star_content']//a[@title='{0}']";
	private final By errorMessagelabel = By.xpath("//div[@id='new_comment_form_error']//li[contains(text(),'Comment is incorrect') or contains(text(),'Title is incorrect')]");
	private final By successMessageLabel = By.xpath("//p[text()='Your comment has been added and will be available once approved by a moderator']");
	
	// ELEMENTS
	public WebElement getSuccessMessageLabel() {
		return Constant.WEBDRIVER.findElement(successMessageLabel);
	}
	
	public WebElement getErrorMessagelabel() {
		return Constant.WEBDRIVER.findElement(errorMessagelabel);
	}
	
	public WebElement getBtnCloseMessage() {
		return Constant.WEBDRIVER.findElement(btnCloseMessage);
	}
	
	public WebElement getBtnSubmitNewMessage() {
		return Constant.WEBDRIVER.findElement(btnSubmitNewMessage);
	}
	
	public WebElement getTxtCommentTitle() {
		return Constant.WEBDRIVER.findElement(txtCommentTitle);
	}
	
	public WebElement getTxtComment() {
		return Constant.WEBDRIVER.findElement(txtComment);
	}
	
	// METHODS
	public void rankStartComment(String startN) {
		this.dynamicXpath(startN,startCommentDyn).click();
	}
	
	public void writeReviewProduct(String startN, String title, String comment, String sendReview) throws InterruptedException {
		this.rankStartComment(startN);
		this.getTxtCommentTitle().sendKeys(title);
		this.getTxtComment().sendKeys(comment);
		if(sendReview.equalsIgnoreCase("send")) {
			this.getBtnSubmitNewMessage().click();
			Thread.sleep(1500);
		} else if(sendReview.equalsIgnoreCase("cancel")) {
			this.getBtnCloseMessage().click();
			Thread.sleep(1500);
		}
	}
	
	public DetailsProductPage_ReviewDialog submitReviewProduct(String startN, String title, String comment) throws InterruptedException {
		this.writeReviewProduct(startN, title, comment, "send");
		Thread.sleep(1500);
		return this;
	}
	
	public String getErrorMessage() {
		return this.getErrorMessagelabel().getText();
	}
	
}
