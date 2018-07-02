package TestSuite;

import org.testng.annotations.Test;

import Automation.HomePage;
import Automation.LoginPage;
import Automation.generalActions;

import static org.testng.Assert.assertEquals;

public class testRegister extends configNormal {

	@Test(dataProvider = "createCustomerData", dataProviderClass = AllData.createCustomerData.class)
	public void TC01(String noN, String testCase, String firstName, String lastName, String passWord, String address, String city, String state,
			String postCode, String country, String mobiPhone, String allias) throws InterruptedException {
		System.out.println("TC" + noN + " - " + testCase);
		String emailRandom = new generalActions().generateRandomEmail();
		HomePage homePage = new HomePage();
		LoginPage loginPage = homePage.open().goToLoginPage();
		loginPage.createEmailAccountAuthenticationSuccessfull(emailRandom);
		String welcome = loginPage.submitCreateAccountSuccessfull(firstName, lastName, passWord, address, city, state,
				postCode, country, mobiPhone, allias).getkWelcomeMessage();
		assertEquals(welcome,
				"Welcome to your account. Here you can manage all of your personal information and orders.");
	}

//	@Test(dataProvider = "createCustomerData", dataProviderClass = AllData.createCustomerData.class)
//	public void TC02(String noN, String testCase, String email, String errorM) throws InterruptedException {
//		System.out.println("TC" + noN + " - " + testCase);
//		HomePage homePage = new HomePage();
//		String ErrorMess = homePage.open().goToLoginPage().createEmailAccountAuthenticationUnsuccessfull(email)
//				.getErrorMessage();
//		assertEquals(ErrorMess, errorM);
//	}
//
//	@Test(dataProvider = "createCustomerData", dataProviderClass = AllData.createCustomerData.class)
//	public void TC03(String noN, String testCase, String firstName, String lastName, String passWord, String address,
//			String city, String state, String postCode, String country, String mobiPhone, String allias, String errorM)
//			throws InterruptedException {
//		System.out.println("TC" + noN + " - " + testCase);
//		String emailRandom = new generalActions().generateRandomEmail();
//		HomePage homePage = new HomePage();
//		String ErrorMess = homePage.open().goToLoginPage().createEmailAccountAuthenticationSuccessfull(emailRandom)
//				.submitCreateAccountUnsuccessfull(firstName, lastName, passWord, address, city, state, postCode,
//						country, mobiPhone, allias)
//				.getErrorMessage();
//		assertEquals(ErrorMess, errorM);
//	}
}
