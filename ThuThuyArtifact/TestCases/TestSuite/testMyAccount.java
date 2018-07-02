package TestSuite;

import org.testng.annotations.Test;
import Automation.HomePage;
import Constants.Constant;
import static org.testng.Assert.assertEquals;

public class testMyAccount extends configNormal {

	@Test()
	public void TC01() {
		System.out.println("TC01 - Verify My Account page title is displayed correctly");
		HomePage homePage = new HomePage();
		String titlePage = homePage.open().goToLoginPage()
				.loginSuccessfull(Constant.adminUserName, Constant.adminPassWord).getPageHeading();
		assertEquals(titlePage, "MY ACCOUNT");
	}

	@Test()
	public void TC02() {
		System.out.println(
				"TC02 - Verify Order History page is displayed after clicking \"Order history and details\" button");
		HomePage homePage = new HomePage();
		String titlePage = homePage.open().goToLoginPage()
				.loginSuccessfull(Constant.adminUserName, Constant.adminPassWord).goToOrderHistoryPage()
				.getPageHeading();
		assertEquals(titlePage, "ORDER HISTORY");
	}

	@Test()
	public void TC03() {
		System.out.println("TC03 - Verify My Wishlist page is displayed after clicking \"My wishlist\" button");
		HomePage homePage = new HomePage();
		String titlePage = homePage.open().goToLoginPage()
				.loginSuccessfull(Constant.adminUserName, Constant.adminPassWord).goToMyWishListPage().getPageHeading();
		assertEquals(titlePage, "MY WISHLISTS");
	}

	@Test()
	public void TC04() {
		System.out.println("TC04 - Verify My Address page is displayed after clicking \"My address\" button");
		HomePage homePage = new HomePage();
		String titlePage = homePage.open().goToLoginPage()
				.loginSuccessfull(Constant.adminUserName, Constant.adminPassWord).goToMyWishListPage().getPageHeading();
		assertEquals(titlePage, "MY ADDRESSES");
	}

	@Test()
	public void TC05() {
		System.out.println(
				"TC05 - Verify Personal information page is displayed after clicking \"My personal information\" button");
		HomePage homePage = new HomePage();
		String titlePage = homePage.open().goToLoginPage()
				.loginSuccessfull(Constant.adminUserName, Constant.adminPassWord).goToPersonalInformationPage()
				.getPageHeading();
		assertEquals(titlePage, "YOUR PERSONAL INFORMATION");
	}

	@Test()
	public void TC06() {
		System.out.println("TC06 - Verify Credit slips page is displayed after clicking \"Credit slips\" button");
		HomePage homePage = new HomePage();
		String titlePage = homePage.open().goToLoginPage()
				.loginSuccessfull(Constant.adminUserName, Constant.adminPassWord).goToCreditSlipsPage()
				.getPageHeading();
		assertEquals(titlePage, "CREDIT SLIPS");
	}

	@Test()
	public void TC07() {
		System.out.println("TC07 - Verify Home page is displayed after clicking \"home\" button");
		HomePage homePage = new HomePage();
		homePage.open().goToLoginPage().loginSuccessfull(Constant.adminUserName, Constant.adminPassWord)
				.goToHomePageByClickHomeButton();
		String url = Constant.WEBDRIVER.getCurrentUrl();
		assertEquals(url, "http://automationpractice.com/index.php");
	}
}
