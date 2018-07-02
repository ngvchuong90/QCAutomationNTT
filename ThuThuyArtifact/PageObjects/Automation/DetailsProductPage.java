package Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Constants.Constant;

public class DetailsProductPage extends GeneralPage {
	// LOCATORS
	private final By productHeaderLabel = By.xpath("//h1[@itemprop='name']");
	private final By btnWishlist = By.xpath("//a[@id='wishlist_button']");
	private final By fancyBoxError = By.xpath("//p[@class='fancybox-error']");
	private final By fancyBoxOverLay = By.xpath("//div[contains(@class,'fancybox-overlay')]");
	private final By btnCloseBoxError = By.xpath("//a[@title='Close']");
	private final By btnAddToCart = By.xpath("//p[@id='add_to_cart']");
	private final By btnTweetSharing = By.xpath("//button[@class='btn btn-default btn-twitter']");
	private final By btnFacebookSharing = By.xpath("//button[@class='btn btn-default btn-facebook']");
	private final By btnGooglePlusSharing = By.xpath("//button[@class='btn btn-default btn-google-plus']");
	private final By btnPinterestSharing = By.xpath("//button[@class='btn btn-default btn-pinterest']");
	private final By btnSendFriend = By.xpath("//a[@id='send_friend_button']");
	private final By fancyBoxSendToFriend = By.xpath("//div[@class='fancybox-skin']");
	private final By txtFriendName = By.xpath("//input[@id='friend_name']");
	private final By txtFriendEmail = By.xpath("//input[@id='friend_email']");
	private final By btnSendEmail = By.xpath("//button[@id='sendEmail']");
	private final By btnCloseFancyBox = By.xpath("//a[@title='Close']");
	private final By messageSuccessfulLabel = By.xpath("//div[@class='fancybox-inner']/p");
	private final By errorMessSendFriendLabel = By.xpath("//div[@id='send_friend_form_error']");
	private final By btnWriteAReview = By.xpath("//ul[@class='comments_advices']/li/a[contains(@class,'open-comment-form')]");
	
	// ELEMENTS
	public WebElement getBtnWriteAReview() {
		return Constant.WEBDRIVER.findElement(btnWriteAReview);
	}
	
	public WebElement getErrorMessSendFriendLabel() {
		return Constant.WEBDRIVER.findElement(errorMessSendFriendLabel);
	}
	
	public WebElement getMessageSuccessfulLabel() {
		return Constant.WEBDRIVER.findElement(messageSuccessfulLabel);
	}
	
	public WebElement getFancyBoxSendToFriend() {
		return Constant.WEBDRIVER.findElement(fancyBoxSendToFriend);
	}
	
	public WebElement getBtnCloseFancyBox() {
		return Constant.WEBDRIVER.findElement(btnCloseFancyBox);
	}
	
	public WebElement getBtnSendEmail() {
		return Constant.WEBDRIVER.findElement(btnSendEmail);
	}
	
	public WebElement getTxtFriendEmail() {
		return Constant.WEBDRIVER.findElement(txtFriendEmail);
	}
	
	public WebElement getTxtFriendName() {
		return Constant.WEBDRIVER.findElement(txtFriendName);
	}
	
	public WebElement getBtnSendFriend() {
		return Constant.WEBDRIVER.findElement(btnSendFriend);
	}
	
	public WebElement getBtnPinterestSharing() {
		return Constant.WEBDRIVER.findElement(btnPinterestSharing);
	}
	
	public WebElement getBtnGooglePlusSharing() {
		return Constant.WEBDRIVER.findElement(btnGooglePlusSharing);
	}
	
	public WebElement getBtnFacebookSharing() {
		return Constant.WEBDRIVER.findElement(btnFacebookSharing);
	}
	
	public WebElement getBtnTweetSharing() {
		return Constant.WEBDRIVER.findElement(btnTweetSharing);
	}
	
	public WebElement getProductHeaderLabel() {
		return Constant.WEBDRIVER.findElement(productHeaderLabel);
	}

	public WebElement getBtnWishlist() {
		return Constant.WEBDRIVER.findElement(btnWishlist);
	}

	public WebElement getFancyBoxError() {
		return Constant.WEBDRIVER.findElement(fancyBoxError);
	}

	public WebElement getFancyBoxOverLay() {
		return Constant.WEBDRIVER.findElement(fancyBoxOverLay);
	}
	
	public WebElement getBtnCloseBoxError() {
		return Constant.WEBDRIVER.findElement(btnCloseBoxError);
	}

	public WebElement getBtnAddToCart() {
		return Constant.WEBDRIVER.findElement(btnAddToCart);
	}
	
	// METHODS
	public boolean checkSocialSharingDisplayed(String sharing) {
		if(sharing.equalsIgnoreCase("Tweet")) {
			return this.getBtnTweetSharing().isDisplayed();
		} else if(sharing.equalsIgnoreCase("FaceBook")) {
			return this.getBtnFacebookSharing().isDisplayed();
		} else if(sharing.equalsIgnoreCase("Google")) {
			return this.getBtnGooglePlusSharing().isDisplayed();
		} else if(sharing.equalsIgnoreCase("Pinterest")) {
			return this.getBtnPinterestSharing().isDisplayed();
		} else {
			return false;
		}
	}
	
 	public String getProductHeader() {
		String headerLabel = this.getProductHeaderLabel().getText();
		return headerLabel;
	}

	public DetailsProductPage addProductToWishList() {
		this.getBtnWishlist().click();
		this.waitForControlStable(this.getBtnCloseBoxError());
		return this;
	}

	public DetailsProductPage closeAddedWishListLayout() {
		System.out.println("zo");
		boolean check = false;
		try {
			while (check == false) {
				Thread.sleep(1000);
				check = this.getBtnCloseBoxError().isDisplayed();
				if(check == true) {
					this.getBtnCloseBoxError().click();
					Thread.sleep(1000);
				}
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this;
	}
	
	public DetailsProductPage openSendToFriendDialog() {
		this.getBtnSendFriend().click();
		this.waitForControlStable(this.getFancyBoxSendToFriend());
		return this;
	}
	
	public DetailsProductPage sendLinkToFriend(String friendName, String friendEmail) {
		this.getTxtFriendName().sendKeys(friendName);
		this.getTxtFriendEmail().sendKeys(friendEmail);
		this.getBtnSendEmail().click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this; 
	}
	
	public String getMessageSuccessfullAfterSendToFriend() {
		return this.getMessageSuccessfulLabel().getText();
	}
	
	public String getErrorMessageAfterSendToFriend() {
		return this.getErrorMessSendFriendLabel().getText();
	}
	
	public DetailsProductPage_layerCart addProducToCart() {
		this.getBtnAddToCart().click();
		this.waitForControlStable(new DetailsProductPage_layerCart().getBtnCloseCartDialog());
		return new DetailsProductPage_layerCart();
	}
	
	public DetailsProductPage_ReviewDialog openReviewDialog() throws InterruptedException {
		this.getBtnWriteAReview().click();
		Thread.sleep(1500);
		return new DetailsProductPage_ReviewDialog();
	}
}
