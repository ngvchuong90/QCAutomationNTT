package TestSuite;

import org.testng.annotations.Test;

import Automation.HomePage;

import static org.testng.Assert.assertEquals;

public class testLogin extends configNormal{

	@Test(dataProvider = "loginData", dataProviderClass = AllData.loginData.class)
	public void TC01(String noN, String testCase, String userName, String passWord) throws InterruptedException {
		System.out.println("TC" + noN +  " - " + testCase);
		HomePage homePage = new HomePage();
		String welcome = homePage.open().goToLoginPage().loginSuccessfull(userName, passWord).getkWelcomeMessage();
		assertEquals(welcome,
				"Welcome to your account. Here you can manage all of your personal information and orders.");
	}

	@Test(dataProvider = "loginData", dataProviderClass = AllData.loginData.class)
	public void TC02(String noN, String testCase, String userName, String passWord, String errorMess) throws InterruptedException {
		System.out.println("TC" + noN +  " - " + testCase);
		HomePage homePage = new HomePage();
		String errorM = homePage.open().goToLoginPage().loginUnsuccessfull(userName, passWord).getErrorMessage();
		assertEquals(errorM, errorMess);
	}
}
