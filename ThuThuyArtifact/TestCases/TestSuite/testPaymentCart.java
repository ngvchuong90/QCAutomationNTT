package TestSuite;

import org.testng.annotations.Test;

import Automation.HomePage;
import static org.testng.Assert.assertEquals;

public class testPaymentCart extends configNormal {

	@Test(dataProvider = "paymentData", dataProviderClass = AllData.paymentData.class)
	public void TC01(String noN, String testCase, String userName, String passWord, String productN, String payBy) throws InterruptedException {
		System.out.println("TC" + noN +  " - " + testCase + " with logged user");
		HomePage homePage = new HomePage();
		String messSuccess = homePage.open().goToLoginPage().loginSuccessfull(userName, passWord).goToHomePage()
				.selectProduct(productN).addProducToCart().proceedToCheckOut().goToNextStep().goToNextStep()
				.acceptTermsOfService().goToNextStep().paymentByCheckOrBankWire(payBy).confirmPayment()
				.getSuccessMessage();
		assertEquals(messSuccess, "Your order on My Store is complete.");
	}

	@Test(dataProvider = "paymentData", dataProviderClass = AllData.paymentData.class)
	public void TC02(String noN, String testCase, String userName, String passWord, String productN, String payBy) throws InterruptedException {
		System.out.println("TC" + noN +  " - " + testCase + " without login");
		HomePage homePage = new HomePage();
		String messSuccess = homePage.open().selectProduct(productN).addProducToCart().proceedToCheckOut()
				.goToNextStepWithOutLogin().loginSuccessfullToPayment(userName, passWord).goToNextStep()
				.acceptTermsOfService().goToNextStep().paymentByCheckOrBankWire(payBy).confirmPayment()
				.getSuccessMessage();
		assertEquals(messSuccess, "Your order on My Store is complete.");
	}

	@Test(dataProvider = "paymentData", dataProviderClass = AllData.paymentData.class)
	public void TC03(String noN, String testCase, String userName, String passWord, String productN, String payBy) {
		System.out.println("TC" + noN +  " - " + testCase + " after logging in and payment.");
		HomePage homePage = new HomePage();
		String messSuccess = homePage.open().goToLoginPage().loginSuccessfull(userName, passWord).goToHomePage()
				.selectAddToCartProduct(productN).proceedToCheckOut().goToNextStep().goToNextStep()
				.acceptTermsOfService().goToNextStep().paymentByCheckOrBankWire(payBy).confirmPayment()
				.getSuccessMessage();
		assertEquals(messSuccess, "Your order on My Store is complete.");
	}

	@Test(dataProvider = "paymentData", dataProviderClass = AllData.paymentData.class)
	public void TC04(String noN, String testCase, String userName, String passWord, String productN, String payBy) {
		System.out.println("TC" + noN +  " - " + testCase + " before logging in and payment.");
		HomePage homePage = new HomePage();
		String messSuccess = homePage.open().selectAddToCartProduct(productN).proceedToCheckOut()
				.goToNextStepWithOutLogin().loginSuccessfullToPayment(userName, passWord).goToNextStep()
				.acceptTermsOfService().goToNextStep().paymentByCheckOrBankWire(payBy).confirmPayment()
				.getSuccessMessage();
		assertEquals(messSuccess, "Your order on My Store is complete.");
	}
}
