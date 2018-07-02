package TestSuite;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;

import Automation.HomePage;
import Constants.Constant;

public class testWishList extends configNormal {
	
	@Test(dataProvider = "wishListData", dataProviderClass = AllData.wishListData.class)
	public void TC01(String noN, String testCase, String userName, String passW, String product) {
		System.out.println("TC" + noN +  " - " + testCase);
		HomePage homePage = new HomePage();
		boolean check = homePage.open().goToLoginPage().loginSuccessfull(userName, passW)
				.goToHomePage().selectProduct(product).addProductToWishList()
				.closeAddedWishListLayout().goToMyAccountPage().goToMyWishListPage().getWishListFirstProduct()
				.isDisplayed();
		assertEquals(check, true);
	}
	
	@Test(dataProvider = "wishListData", dataProviderClass = AllData.wishListData.class)
	public void TC02(String noN, String testCase, String userName, String passW, String product) throws InterruptedException {
		System.out.println("TC" + noN +  " - " + testCase);
		HomePage homePage = new HomePage();
		boolean check = homePage.open().goToLoginPage().loginSuccessfull(userName, passW).goToMyAccountPage().goToMyWishListPage().removeAllWishList()
				.goToHomePage().selectProduct(product).addProductToWishList()
				.closeAddedWishListLayout().goToMyAccountPage().goToMyWishListPage().submitNewWishlist(product).getWishListFirstProduct()
				.isDisplayed();
		assertEquals(check, true);
	}
	
	@Test(dataProvider = "wishListData", dataProviderClass = AllData.wishListData.class)
	public void TC03(String noN, String testCase, String userName, String passW, String product) throws InterruptedException {
		System.out.println("TC" + noN +  " - " + testCase);
		HomePage homePage = new HomePage();
		boolean check = homePage.open().goToLoginPage().loginSuccessfull(userName, passW).goToMyWishListPage().submitNewWishlist(product).removeWishList(product).checkWishListDisplay(product);
		assertEquals(check, false);
	}
	
	@Test(dataProvider = "wishListData", dataProviderClass = AllData.wishListData.class)
	public void TC04(String noN, String testCase, String userName, String passW, String product) throws InterruptedException {
		System.out.println("TC" + noN +  " - " + testCase);
		HomePage homePage = new HomePage();
		boolean check = homePage.open().goToLoginPage().loginSuccessfull(userName, passW)
				.goToHomePage().quickViewProduct(product).addProductToWishList().checkAddedWishListLabelDisplay();
		assertEquals(check, true);
	}
	
	@Test
	public void TC12() throws InterruptedException {
		System.out.println("TC12 - Verify  my account page is displayed after click “Back to your account” button");
		HomePage homePage = new HomePage();
		String headingpage = homePage.open().goToLoginPage().loginSuccessfull(Constant.adminUserName, Constant.adminPassWord).goToMyWishListPage().goBackToYourAccountPage().getPageHeading();
		assertEquals(headingpage, "MY ACCOUNT");
	}
	
	@Test
	public void TC13() throws InterruptedException {
		System.out.println("TC13 - Verify home page is displayed after click “Home” button");
		HomePage homePage = new HomePage();
		homePage.open().goToLoginPage().loginSuccessfull(Constant.adminUserName, Constant.adminPassWord).goToMyWishListPage().goHomeByClickBackHome();
		String url = Constant.WEBDRIVER.getCurrentUrl();
		assertEquals(url, "http://automationpractice.com/index.php");
	}
}
