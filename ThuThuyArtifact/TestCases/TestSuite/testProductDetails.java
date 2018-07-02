package TestSuite;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import Automation.HomePage;
import Constants.Constant;

public class testProductDetails extends configNormal {

	@Test(dataProvider = "productData", dataProviderClass = AllData.productData.class)
	public void TC01(String noN, String testCase, String productName) {
		System.out.println("TC" + noN + " - " + testCase);
		HomePage homePage = new HomePage();
		String productLabel = homePage.open().selectProduct(productName).getProductHeader();
		assertEquals(productLabel, productName);
	}

	@Test(dataProvider = "productData", dataProviderClass = AllData.productData.class)
	public void TC02(String noN, String testCase, String product, String name, String email, String mess) {
		System.out.println("TC" + noN + " - " + testCase);
		HomePage homePage = new HomePage();
		String successfulMess = homePage.open().selectProduct(product).openSendToFriendDialog()
				.sendLinkToFriend(name, email).getMessageSuccessfullAfterSendToFriend();
		assertEquals(successfulMess, mess);
	}

	@Test(dataProvider = "productData", dataProviderClass = AllData.productData.class)
	public void TC03(String noN, String testCase, String product, String name, String email, String mess) {
		System.out.println("TC" + noN + " - " + testCase);
		HomePage homePage = new HomePage();
		String errorMess = homePage.open().selectProduct(product).openSendToFriendDialog().sendLinkToFriend(name, email)
				.getErrorMessageAfterSendToFriend();
		assertEquals(errorMess, mess);
	}

	@Test(dataProvider = "productData", dataProviderClass = AllData.productData.class)
	public void TC04(String noN, String testCase, String product, String startN, String title, String comment)
			throws InterruptedException {
		System.out.println("TC" + noN + " - " + testCase);
		HomePage homePage = new HomePage();
		boolean check = homePage.open().goToLoginPage().loginSuccessfull(Constant.adminUserName, Constant.adminPassWord)
				.goToHomePage().selectProduct(product).openReviewDialog().submitReviewProduct(startN, title, comment)
				.getSuccessMessageLabel().isDisplayed();
		assertEquals(check, true);
	}

	@Test(dataProvider = "productData", dataProviderClass = AllData.productData.class)
	public void TC05(String noN, String testCase, String product, String startN, String title, String comment)
			throws InterruptedException {
		System.out.println("TC" + noN + " - " + testCase);
		HomePage homePage = new HomePage();
		boolean check = homePage.open().goToLoginPage().loginSuccessfull(Constant.adminUserName, Constant.adminPassWord)
				.goToHomePage().selectProduct(product).openReviewDialog().submitReviewProduct(startN, title, comment)
				.getErrorMessagelabel().isDisplayed();
		assertEquals(check, true);
	}
}
